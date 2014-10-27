/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.login;

import edu.servicio.toluca.beans.SesionBean;
import edu.servicio.toluca.beans.StringMD;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.UsuarioInstancia;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.UsuarioInstanciaFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bustedvillain
 */
public class ValidaLogin
{

    public SesionBean validaLogin(String usuario, String pass,
            VistaAlumnoFacade vistaAlumnoFacade, InstanciaFacade instanciaFacade,
            UsuarioInstanciaFacade uInstanciaFacade, HttpSession session)
    {
        SesionBean sesionBean = new SesionBean();

        System.out.println("Usuario: " + usuario);
        System.out.println("Pass: " + pass);

        usuario = usuario.trim();
        pass = pass.trim();
        if(usuario.equals("") || pass.equals(""))
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
            if(rol.equals("ROLE_ALUMNOS"))
            {
                System.out.println("buscar:" + usuario.substring(4));
                List<VistaAlumno> alumno = vistaAlumnoFacade.findBySpecificField("id", usuario.substring(4), "equal", null, null);
                System.out.println("tamaño lista:" + alumno.size());
                Double porcentaje = Double.parseDouble(alumno.get(0).getPorcentaje());
                System.out.println("Porcentaje del alumno:" + porcentaje);
                if(porcentaje >= 70)
                {
                    //Valida que no este cancelado su servicio
                    try
                    {
                        List<DatosPersonales> datosPersonales = new ArrayList<DatosPersonales>(alumno.get(0).getDatosPersonalesCollection());
                        List<FormatoUnico> formatoUnico = new ArrayList<FormatoUnico>(datosPersonales.get(0).getFormatoUnicoCollection());

                        //Cancelado
                        if(formatoUnico.get(0).getStatusServicio().toString().equals("2"))
                        {
                            sesionBean.setMensaje("<div class=\"alert alert-danger\">Lo sentimos tu servicio social ha sido cancelado. Contacta al Jefe del Departamento de Servicio Social para solucionar esta situacion.</div>");
                            sesionBean.setPagReturn("/NavegacionPrincipal/loginPrincipal");
                        } else
                        {
                            //Baja Temporal
                            if(formatoUnico.get(0).getStatusServicio().toString().equals("3"))
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
                    } catch(Exception e)
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
            } //JOEL (Administrador de Servicio Social)
            else if(rol.equals("ROLE_GESVIN_OPERACION"))
            {
                session.setAttribute("ROL", "OPERACION");
                session.setAttribute("NOMBRE", "OPERADOR");
                sesionBean.setPagReturn("redirect:panelAdministrador.do");
            } //DIRECTIVOS
            else if(rol.equals("ROLE_GESVIN_CONSULTAS"))
            {
                session.setAttribute("ROL", "CONSULTAS");
                session.setAttribute("NOMBRE", "ADMINISTRATIVO");
                sesionBean.setPagReturn("redirect:panelAdministrador.do");
            } //BACKDOOR
            else if(rol.equals("ROLE_GESVIN_ADMIN"))
            {
                session.setAttribute("ROL", "ADMIN");
                session.setAttribute("NOMBRE", "SUPER ADMIN");
                sesionBean.setPagReturn("redirect:panelAdministrador.do");
            } //ASISTENTE
            else if(rol.equals("ROLE_GESVIN_REGISTRO"))
            {
                session.setAttribute("ROL", "REGISTRO");
                session.setAttribute("NOMBRE", "ASISTENTE");
                sesionBean.setPagReturn("redirect:panelAdministrador.do");
            } //OTRO
            else if(rol.equals("OTRO"))
            {
                sesionBean.setMensaje("<div class=\"alert alert-danger\">Lo sentimos no tiene los permisos necesarios para accesar al sistema.</div>");
                sesionBean.setPagReturn("/NavegacionPrincipal/loginPrincipal");
            } 
            else//Ultima opcion para intentar con instancias
            {
                boolean inicioSesion = false;
                
                //Verifica si es una instancia por medio de su correo
                List<UsuarioInstancia> usuarioInstancia
                        = uInstanciaFacade.findBySpecificField("email", usuario.trim(), "equal", null, null);
                if(usuarioInstancia.size() > 0)
                {
                    //System.out.println("SA86");
                    //System.out.println("pass: " + StringMD.getStringMessageDigest(pass, StringMD.SHA1));
                    try
                    {
                        if(usuarioInstancia.get(0).getPassword().equals(StringMD.getStringMessageDigest(pass, StringMD.SHA1)))
                        {
                            System.err.println("Las contraseñas coinciden");
                            inicioSesion = true;
                        }
                        else
                        {
                            System.err.println("Las contraseñas no coinciden");
                        }
                    } 
                    catch(Exception ex)
                    {
                        System.out.println("Las contraseñas no coinciden");
                    }
                } 
                else
                {
                    System.err.println("El usuario no existe o no se encontro ...");
                }
                if(inicioSesion)
                {
                    //Verificando si este usuario tiene permisos de entrar
//                    System.out.println("Validacion Admin: " + instancia.get(0).getValidacionAdmin());
//                    System.out.println("Estatus: " + instancia.get(0).getEstatus());
//                    int validacionAdmin = Integer.parseInt(instanciaU.get(0).getValidacionAdmin().toString());
                    int status = usuarioInstancia.get(0).getStatus();

                    if(status == 1)
                    {
                        //System.out.println("Iniciando sesion con organizacion " + instancia.get(0).getNombre());
                        session.setAttribute("ROL", "ORGANIZACION");
                        session.setAttribute(("NCONTROL"), usuarioInstancia.get(0).getIdUsuarioInstancia().toString());
                        session.setAttribute("NOMBRE", usuarioInstancia.get(0).getNombre());
                        session.setAttribute("EMAIL", usuarioInstancia.get(0).getEmail());
//                        if (validacionAdmin == 2)
//                        {
//                            session.setAttribute("MENSAJE", "<div class=\"alert alert-danger\">Tu instancia aún no ha sido validada por el administrador, por favor corrija tus datos como se te ha indicado en la retroalimentación.</div>");
//                        }
                        sesionBean.setPagReturn("redirect:panelOrganizacion.do");
                    } 
                    else if(status == 0)
                    {
                        System.err.println("El usuario no ha sido aprobado por el Administrador");
                        sesionBean.setMensaje("<div class=\"alert alert-danger\">Su cuenta no ha sido aceptada por el administrador de Servicio Social.</div>");
                        sesionBean.setPagReturn("/NavegacionPrincipal/loginPrincipal");
                    }
                    else //si el status es 2
                    {
                        System.out.println("La organizacion no puede ingresar, status: inactivo");
                        sesionBean.setMensaje("<div class=\"alert alert-danger\">Esta cuenta ha sido dada de baja y no puede ingresar al sistema, contacte al administrador.</div>");
                        sesionBean.setPagReturn("/NavegacionPrincipal/loginPrincipal");
                    }

                } 
                else
                {
                    sesionBean.setMensaje("<div class=\"alert alert-danger\">Usuario o contraseña incorrecta</div>");
                    sesionBean.setPagReturn("/NavegacionPrincipal/loginPrincipal");
                }
            }
        } 
        catch(Exception e)
        {
            
        }
        return sesionBean;
    }
}
