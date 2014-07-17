/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

/**
 *
 * @author bustedvillain
 */
import edu.servicio.toluca.beans.NoticiaJson;
import edu.servicio.toluca.beans.SesionBean;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.login.ValidaLogin;
import edu.servicio.toluca.model.noticias.ConsultasNoticias;
import edu.servicio.toluca.sesion.CodigosPostalesFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.NoticiasFacade;
import edu.servicio.toluca.sesion.TipoOrganizacionFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.util.LinkedHashMap;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Victor
 * 
 * Clase encargada de manejar las solicitiudes realizadas a la página de inicio
 * 
 * @see index.jsp   
 */
@Controller
public class NavegacionPrincipalController {

    /**
     * Facade que pertenece a las instancias
     */
    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
    public InstanciaFacade instanciaFacade;

    /**
     * Facade que pertenece a los Códigos postales
     */
    @EJB(mappedName = "java:global/ServicioSocial/CodigosPostalesFacade")
    public CodigosPostalesFacade codigosPostalesFacade;

    /**
     * Facade que pertenece a los tipos de Organizaciones
     */
    @EJB(mappedName = "java:global/ServicioSocial/TipoOrganizacionFacade")
    public TipoOrganizacionFacade tipoOrganizacionFacade;

    /**
     * Facade que pertenece a los estados
     */
    @EJB(mappedName = "java:global/ServicioSocial/EstadosSiaFacade")
    public EstadosSiaFacade estadosFacade;

    /**
     * Facade que pertenece a la vista alumno
     */
    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    public VistaAlumnoFacade vistaAlumnoFacade;

    /**
     * Facade que pertenece a las noticias
     */
    @EJB(mappedName = "java:global/ServicioSocial/NoticiasFacade")
    public NoticiasFacade noticiasFacade;

    /**
     *
     * @param modelo
     * @return la vista de la página principal
     */
    @RequestMapping(method = RequestMethod.GET, value = "/index.do")
    public String index(Model modelo) {
        ConsultasNoticias noticiasBean = new ConsultasNoticias(noticiasFacade);
        modelo.addAttribute("Noticias", noticiasBean.consultaNoticiasPrincipales("desc"));
        return "/NavegacionPrincipal/index";
    }

    /**
     *
     * @param modelo
     * @param idNoticia
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/mostrarNoticiaCompleta.do")
    @ResponseBody
    public NoticiaJson mostarNoticiaCompleta(Model modelo, String idNoticia) {
        NoticiaJson noticia = new NoticiaJson();
        ConsultasNoticias noticiasBean = new ConsultasNoticias(noticiasFacade);
        noticia.setTitulo(noticiasBean.consultaNoticiaPrincipal(Integer.parseInt(idNoticia)).getTitulo());
        noticia.setDetalle(noticiasBean.consultaNoticiaPrincipal(Integer.parseInt(idNoticia)).getDetalle());
        System.out.println("descrpcion" + noticia.getDetalle());
        return noticia;
    }

    /**
     * Muestra el reglamento del servicio social en formato PDF
     * 
     * @param modelo
     * @param alumno_id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/muestraReglamento.do")
    public String muestraReglamento(Model modelo, String alumno_id) {
        return "/NavegacionPrincipal/muestraReglamento";
    }


    /**
     *
     * @param a
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/manualProcedimiento.do")
    public String manualProcedimiento(Model a) {
        return "/NavegacionPrincipal/manualProcedimiento";
    }

    /**
     * * Muesta la misma información que acercaDeAdmin.do
     * 
     * @param a
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/acercaDe.do")
    public String acercaDe(Model a) {
        return "/NavegacionPrincipal/acercaDe";
    }

    /**
     * Muesta la misma información que acercaDe.do
     * 
     * @param a
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/acercaDeAdmin.do")
    public String acercaDeAdmin(Model a) {
        return "/NavegacionPrincipal/acercaDeAdmin";
    }

    /**
     * Muestra la vista (incompleta) para el login de instancias
     * SE DEBE DE TENER SOLO UNA VISTA PARA EL LOGIN
     * Para alumnos, admin e instancias
     * 
     * @param a
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/loginOrganizaciones.do")
    public String loginOrganizaciones(Model a) {
        return "/NavegacionPrincipal/loginOrganizaciones";
    }

    /**
     * Página para registrar instancias
     * 
     * @param model
     * @return
     */
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

    /**
     *
     * @param a
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/login.do")
    public String loginAlumnos(Model a) {
        return "/NavegacionPrincipal/loginPrincipal";
    }

    /**
     *
     * @param model
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "cerrarSesion.do")
    public String cerrarSesion(Model model, HttpSession session, HttpServletRequest request) {
        session = request.getSession();
        session.invalidate();
        return "redirect:index.do";
    }

    /**
     *
     * @param model
     * @param usuario
     * @param pass
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/validaLogin.do")
    public String validaLogin(Model model, String usuario, String pass, HttpSession session, HttpServletRequest request) {
        session = request.getSession();

        ValidaLogin login = new ValidaLogin();
        SesionBean sesionBean = login.validaLogin(usuario, pass, vistaAlumnoFacade, instanciaFacade, session);

        if (sesionBean.getMensaje() != null) {
            model.addAttribute("error", sesionBean.getMensaje());
            model.addAttribute("MENSAJE", session.getAttribute("MENSAJE"));
        }
        System.out.println("retorna:" + sesionBean.getPagReturn());
        return sesionBean.getPagReturn();

    }
}
