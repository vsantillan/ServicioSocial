/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

/**
 *
 * @author bustedvillain
 */
import edu.servicio.toluca.beans.StringMD;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.login.Login;
import edu.servicio.toluca.sesion.CodigosPostalesFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.TipoOrganizacionFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavegacionPrincipalController {

    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
    public InstanciaFacade instanciaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CodigosPostalesFacade")
    public CodigosPostalesFacade codigosPostalesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/TipoOrganizacionFacade")
    public TipoOrganizacionFacade tipoOrganizacionFacade;
    @EJB(mappedName = "java:global/ServicioSocial/EstadosSiaFacade")
    public EstadosSiaFacade estadosFacade;
    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    public VistaAlumnoFacade vistaAlumnoFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/index.do")
    public String index(Model a) {
        return "/NavegacionPrincipal/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/convocatorias.do")
    public String convocatorias(Model a) {
        return "/NavegacionPrincipal/convocatorias";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/manualProcedimiento.do")
    public String manualProcedimiento(Model a) {
        return "/NavegacionPrincipal/manualProcedimiento";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/organizaciones.do")
    public String organizaciones(Model a) {
        return "/NavegacionPrincipal/organizaciones";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/loginOrganizaciones.do")
    public String loginOrganizaciones(Model a) {
        return "/NavegacionPrincipal/loginOrganizaciones";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/registroOrganizaciones.do")
    public String registroOrganizaciones(Model model) {

        model.addAttribute("preOrganizaciones", instanciaFacade.findBySpecificField("estatus", "2", "equal", null, null));
        model.addAttribute("instancia", new Instancia());
        model.addAttribute("tipoOrganizaciones", tipoOrganizacionFacade.findBySpecificField("estatus", "1", "equal", null, null));
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("nombre", "asc");
        model.addAttribute("estados", estadosFacade.findAll(ordenamiento));
        return "/Organizaciones/registroOrganizaciones";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login.do")
    public String loginAlumnos(Model a) {
        return "/NavegacionPrincipal/loginPrincipal";
    }

    @RequestMapping(method = RequestMethod.GET, value = "cerrarSesion.do")
    public String cerrarSesion(Model model, HttpSession session, HttpServletRequest request) {
        session = request.getSession();
        session.invalidate();
        return "redirect:index.do";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/validaLogin.do")
    public String validaLogin(Model model, String usuario, String pass, HttpSession session, HttpServletRequest request) {
        session = request.getSession();

        System.out.println("Usuario:" + usuario);
        System.out.println("Pass:" + pass);

        if (usuario.equals("") || pass.equals("")) {
            model.addAttribute("error", "<div class='error'>Datos de acceso inválidos</div>");
            return "/NavegacionPrincipal/loginPrincipal";
        }
        try {
            String rol = new Login().ValidarUsuario(usuario, pass);
            System.out.println("rol:" + rol);

            //ALUMNOS
            if (rol.equals("ROLE_ALUMNOS")) {
                System.out.println("buscar:" + usuario.substring(4));
                List<VistaAlumno> alumno = vistaAlumnoFacade.findBySpecificField("id", usuario.substring(4), "equal", null, null);
                System.out.println("tamaño lista:" + alumno.size());
                Double porcentaje = Double.parseDouble(alumno.get(0).getPorcentaje());
                System.out.println("Porcentaje del alumno:" + porcentaje);
                if (porcentaje >= 70) {
                    //Sesion
                    session.setAttribute("ROL", "ALUMNO");
                    session.setAttribute(("NCONTROL"), usuario.substring(4));
                    session.setAttribute("NOMBRE", alumno.get(0).getNombre());
                    return "redirect:panelUsuario.do";
                } else {
                    model.addAttribute("error", "<div class='error'>Lo sentimos no cumples con el minimo de 70% de créditos para tramitar tu servicio social</div>");
                    return "/NavegacionPrincipal/loginPrincipal";
                }
            }
            //JOELITO
            if (rol.equals("ROLE_GESVIN_OPERACION")) {
                session.setAttribute("ROL", "OPERACION");
                return "redirect:panelAdministrador.do";
            }
            //DIRECTIVOS
            if (rol.equals("ROLE_GESVIN_CONSULTAS")) {
                session.setAttribute("ROL", "CONSULTAS");
            }
            //BACKDOOR
            if (rol.equals("ROLE_GESVIN_ADMIN")) {
                session.setAttribute("ROL", "ADMIN");
            }
            //ASISTENTE
            if (rol.equals("ROLE_GESVIN_REGISTRO")) {
                session.setAttribute("ROL", "REGISTRO");
            }
            //OTRO
            if (rol.equals("OTRO")) {
                model.addAttribute("error", "<div class='error'>Lo sentimos no tiene los permisos necesarios para accesar al sistema.</div>");
            }

            return "/NavegacionPrincipal/loginPrincipal";

        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Error al conectar!");
            System.out.println("Verificando si es una organizacion");
            boolean inicioSesion = false;
            //Verificar si es una instancia  Login por usuario
            List<Instancia> instancia = instanciaFacade.findBySpecificField("usuario", usuario, "equal", null, null);
            if (instancia.size() > 0) {
                if (instancia.get(0).getPassword().equals(StringMD.getStringMessageDigest(pass, StringMD.SHA1))) {
                    inicioSesion = true;
                }
            } else {
                //No encntro instancia por usuario, busqueda por correo
                instancia = instanciaFacade.findBySpecificField("correo", usuario, "equal", null, null);
                if (instancia.size() > 0) {
                    if (instancia.get(0).getPassword().equals(StringMD.getStringMessageDigest(pass, StringMD.SHA1))) {
                        inicioSesion = true;
                    }
                }
            }
            if (inicioSesion) {
                //Verificando si este usuario tiene permisos de entrar
                if (instancia.get(0).getValidacionAdmin() != BigInteger.ZERO && instancia.get(0).getEstatus() == BigInteger.ONE) {
                    System.out.println("Iniciando sesion con organziacion " + instancia.get(0).getNombre());
                    session.setAttribute("ROL", "ORGANIZACION");
                    session.setAttribute(("NCONTROL"), instancia.get(0).getIdInstancia().toString().trim());
                    session.setAttribute("NOMBRE", instancia.get(0).getNombre());
                    if(instancia.get(0).getValidacionAdmin() == BigInteger.valueOf(2)){
                        session.setAttribute("MENSAJE", "<div class='error'>Tu instancia aún no ha sido validada por el administrador, por favor corrija tus datos como se te ha indicado en la retroalimentación.</div>");
                    }
                    return "redirect:panelOrganizacion.do";
                } else {   
                    System.out.println("La organizacion no puede ingresar, estatus inactivo");
                    model.addAttribute("error", "<div class='error'>Lo sentimos, su cuenta no puede ingresar al sistema, contacte al adminsitrador para informar sobre el problema.</div>");
                    return "/NavegacionPrincipal/loginPrincipal";
                }

            }


            model.addAttribute("error", "<div class='error'>Usuario o contraseña incorrecta</div>");

            return "/NavegacionPrincipal/loginPrincipal";
        }

    }
    @RequestMapping(method = RequestMethod.GET, value = "/contacto.do")
    public String contacto(Model a) {
        return "/NavegacionPrincipal/contacto";
    }
    
}
