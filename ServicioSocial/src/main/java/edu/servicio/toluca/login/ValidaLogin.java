/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.login;

import edu.servicio.toluca.beans.SesionBean;
import edu.servicio.toluca.beans.StringMD;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bustedvillain
 */
public class ValidaLogin
{

    public SesionBean validaLogin(String usuario, String pass, VistaAlumnoFacade vistaAlumnoFacade, InstanciaFacade instanciaFacade, HttpSession session)
    {
        SesionBean sesionBean = new SesionBean();

        System.out.println("Usuario: " + usuario);
        System.out.println("Pass: " + pass);

        usuario = usuario.trim();
        pass = pass.trim();
        if (usuario.equals("") || pass.equals(""))
        {
            //Verifica que el campo usuario y contraseña no esten vacios de lo contrario retorna a loginPrincipal
            sesionBean.setMensaje("<div class=\"alert alert-danger\">Datos de acceso inválidos</div>");
            sesionBean.setPagReturn("/NavegacionPrincipal/loginPrincipal");
        }
        try
        {
            String rol = new Login().ValidarUsuario(usuario, pass);
            System.out.println("rol: " + rol);
            //ALUMNOS
            if (rol.equals("ROLE_ALUMNOS"))
            {
                System.out.println("buscar:" + usuario.substring(4));
                List<VistaAlumno> alumno = vistaAlumnoFacade.findBySpecificField("id", usuario.substring(4), "equal", null, null);
                System.out.println("tamaño lista:" + alumno.size());
                Double porcentaje = Double.parseDouble(alumno.get(0).getPorcentaje());
                System.out.println("Porcentaje del alumno:" + porcentaje);
                if (porcentaje >= 70)
                {
                    //Valida que no este cancelado su servicio
                    try
                    {
                        List<DatosPersonales> datosPersonales = new ArrayList<DatosPersonales>(alumno.get(0).getDatosPersonalesCollection());
                        List<FormatoUnico> formatoUnico = new ArrayList<FormatoUnico>(datosPersonales.get(0).getFormatoUnicoCollection());

                        //Cancelado
                        if (formatoUnico.get(0).getStatusServicio().toString().equals("2"))
                        {
                            sesionBean.setMensaje("<div class=\"alert alert-danger\">Lo sentimos tu servicio social ha sido cancelado. Contacta al Jefe del Departamento de Servicio Social para solucionar esta situacion.</div>");
                            sesionBean.setPagReturn("/NavegacionPrincipal/loginPrincipal");
                        } else
                        {
                            //Baja Temporal
                            if (formatoUnico.get(0).getStatusServicio().toString().equals("3"))
                            {
                                sesionBean.setMensaje("<div class=\"alert alert-danger\"'>Lo sentimos tu servicio social ha sido dado de baja temporalmente. Contacta al Jefe del Departamento de Servicio Social para solucionar esta situacion.</div>");
                                sesionBean.setPagReturn("/NavegacionPrincipal/loginPrincipal");
                            } else
                            {
                                System.out.println("Inicia sesion en proceso...");
                                //Sesion
                                session.setAttribute("ROL", "ALUMNO");
                                session.setAttribute(("NCONTROL"), usuario.substring(4));
                                session.setAttribute("NOMBRE", alumno.get(0).getNombre() + " " + alumno.get(0).getApellidoPat() + " " + alumno.get(0).getApellidoMat());
                                sesionBean.setPagReturn("redirect:panelUsuario.do");
                            }
                        }
                    } catch (Exception e)
                    {
                        //Sesion
                        session.setAttribute("ROL", "ALUMNO");
                        session.setAttribute(("NCONTROL"), usuario.substring(4));
                        session.setAttribute("NOMBRE", alumno.get(0).getNombre() + " " + alumno.get(0).getApellidoPat() + " " + alumno.get(0).getApellidoMat());
                        sesionBean.setPagReturn("redirect:panelUsuario.do");
                    }
                } else
                {
                    sesionBean.setMensaje("<div class=\"alert alert-danger\">Lo sentimos no cumples con el mínimo de 70% de créditos para tramitar tu servicio social</div>");
                    sesionBean.setPagReturn("/NavegacionPrincipal/loginPrincipal");
                }
            } //JOELITO
            else if (rol.equals("ROLE_GESVIN_OPERACION"))
            {
                session.setAttribute("ROL", "OPERACION");
                session.setAttribute("NOMBRE", "OPERADOR");
                sesionBean.setPagReturn("redirect:panelAdministrador.do");
            } //DIRECTIVOS
            else if (rol.equals("ROLE_GESVIN_CONSULTAS"))
            {
                session.setAttribute("ROL", "CONSULTAS");
                session.setAttribute("NOMBRE", "ADMINISTRATIVO");
                sesionBean.setPagReturn("redirect:panelAdministrador.do");
            } //BACKDOOR
            else if (rol.equals("ROLE_GESVIN_ADMIN"))
            {
                session.setAttribute("ROL", "ADMIN");
                session.setAttribute("NOMBRE", "SUPER ADMIN");
                sesionBean.setPagReturn("redirect:panelAdministrador.do");
            } //ASISTENTE
            else if (rol.equals("ROLE_GESVIN_REGISTRO"))
            {
                session.setAttribute("ROL", "REGISTRO");
                session.setAttribute("NOMBRE", "ASISTENTE");
                sesionBean.setPagReturn("redirect:panelAdministrador.do");
            } //OTRO
            else if (rol.equals("OTRO"))
            {
                sesionBean.setMensaje("<div class=\"alert alert-danger\">Lo sentimos no tiene los permisos necesarios para accesar al sistema.</div>");
                sesionBean.setPagReturn("/NavegacionPrincipal/loginPrincipal");
            } //Ultima opcion para intentar con instancias
            else
            {
                System.out.println("Verificando si es una organizacion ahora..");
                boolean inicioSesion = false;
                //Verifica si es una instancia por medio de su correo
                List<Instancia> instancia = instanciaFacade.findBySpecificField("correo", usuario, "equal", null, null);
                System.out.println(instancia.size());
                if (instancia.size() > 0)
                {
                    System.out.println("SA86");
                    System.out.println("pass: " + StringMD.getStringMessageDigest(pass, StringMD.SHA1));
                    try
                    {
                        if (instancia.get(0).getPassword().equals(StringMD.getStringMessageDigest(pass, StringMD.SHA1)))
                        {
                            inicioSesion = true;
                        }
                    } catch (Exception ex)
                    {
                        System.out.println("No hay password");
                    }
                } else
                {
                    System.out.println("No se ha encontrado conicidencia de ese correo...");
                }
                System.out.println("eres una porqueria " + inicioSesion);
                if (inicioSesion)
                {
                    //Verificando si este usuario tiene permisos de entrar
                    System.out.println("Validacion Admin: " + instancia.get(0).getValidacionAdmin());
                    System.out.println("Estatus: " + instancia.get(0).getEstatus());
                    int validacionAdmin = Integer.parseInt(instancia.get(0).getValidacionAdmin().toString());
                    int estatus = Integer.parseInt(instancia.get(0).getEstatus().toString());

                    if ((validacionAdmin == 1 || validacionAdmin == 2) && estatus == 1)
                    {
                        System.out.println("Iniciando sesion con organizacion " + instancia.get(0).getNombre());
                        session.setAttribute("ROL", "ORGANIZACION");
                        session.setAttribute(("NCONTROL"), instancia.get(0).getIdInstancia().toString().trim());
                        session.setAttribute("NOMBRE", instancia.get(0).getNombre());
                        System.out.println("Asignando rol...");
                        if (validacionAdmin == 2)
                        {
                            session.setAttribute("MENSAJE", "<div class=\"alert alert-danger\">Tu instancia aún no ha sido validada por el administrador, por favor corrija tus datos como se te ha indicado en la retroalimentación.</div>");
                        }
                        sesionBean.setPagReturn("redirect:panelOrganizacion.do");
                    } else //si el status es 0
                    {
                        System.out.println("La organizacion no puede ingresar, estatus inactivo");
                        sesionBean.setMensaje("<div class=\"alert alert-danger\">Lo sentimos, su cuenta no puede ingresar al sistema, contacte al adminsitrador para informar sobre el problema.</div>");
                        sesionBean.setPagReturn("/NavegacionPrincipal/loginPrincipal");
                    }

                } else
                {
                    sesionBean.setMensaje("<div class=\"alert alert-danger\">Usuario o contraseña incorrecta</div>");
                    sesionBean.setPagReturn("/NavegacionPrincipal/loginPrincipal");
                }
            }
            System.out.println("finish.. if");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return sesionBean;
    }
}
