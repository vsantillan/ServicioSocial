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
import edu.servicio.toluca.dao.GenericDao;
import edu.servicio.toluca.entidades.CodigosPostales;
import edu.servicio.toluca.entidades.EstadosSia;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.Noticias;
import edu.servicio.toluca.entidades.TipoOrganizacion;
import edu.servicio.toluca.entidades.UsuarioInstancia;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.login.ValidaLogin;
import edu.servicio.toluca.model.noticias.ConsultasNoticias;
import edu.servicio.toluca.sesion.CodigosPostalesFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.NoticiasFacade;
import edu.servicio.toluca.sesion.TipoOrganizacionFacade;
import edu.servicio.toluca.sesion.UsuarioInstanciaFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.util.LinkedHashMap;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NavegacionPrincipalController
{
    
    private GenericDao<Instancia> daoInstancia;
    private GenericDao<CodigosPostales> daoCodigosPostales;
    private GenericDao<TipoOrganizacion> daoTipoOrganizacion;
    private GenericDao<EstadosSia> daoEstadosSia;
    private GenericDao<VistaAlumno> daoVistaAlumno;
    private GenericDao<Noticias> daoNoticias;
    private GenericDao<UsuarioInstancia> daoUsuarioInstancia;
    
    @Autowired
    public void setDaoInstancia(GenericDao<Instancia> daoInstancia)
    {
        this.daoInstancia = daoInstancia;
        daoInstancia.setClass(Instancia.class);
    }
    
    @Autowired
    public void setDaoCodigosPostales(GenericDao<CodigosPostales> daoCodigosPostales)
    {
        this.daoCodigosPostales = daoCodigosPostales;
        daoCodigosPostales.setClass(CodigosPostales.class);
    }
    
    @Autowired
    public void setDaoTipoOrganizacion(GenericDao<TipoOrganizacion> daoTipoOrganizacion)
    {
        this.daoTipoOrganizacion = daoTipoOrganizacion;
        daoTipoOrganizacion.setClass(TipoOrganizacion.class);
    }
    
    @Autowired
    public void setDaoEstadosSia(GenericDao<EstadosSia> daoEstadosSia)
    {
        this.daoEstadosSia = daoEstadosSia;
        daoEstadosSia.setClass(EstadosSia.class);
    }
    
    @Autowired
    public void setDaoVistaAlumno(GenericDao<VistaAlumno> daoVistaAlumno)
    {
        this.daoVistaAlumno = daoVistaAlumno;
        daoVistaAlumno.setClass(VistaAlumno.class);
    }
    
    @Autowired
    public void setDaoNoticias(GenericDao<Noticias> daoNoticias)
    {
        this.daoNoticias = daoNoticias;
        daoNoticias.setClass(Noticias.class);
    }
    
    @Autowired
    public void setDaoUsuarioInstancia(GenericDao<UsuarioInstancia> daoUsuarioInstancia)
    {
        this.daoUsuarioInstancia = daoUsuarioInstancia;
        daoUsuarioInstancia.setClass(UsuarioInstancia.class);
    }
    
    // <editor-fold defaultstate="collapsed" desc="EJB Facades">
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
    
    @EJB(mappedName = "java:global/ServicioSocial/NoticiasFacade")
    public NoticiasFacade noticiasFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/UsuarioInstanciaFacade")
    public UsuarioInstanciaFacade uInstanciaFacade;
    // </editor-fold>

    @RequestMapping(method = RequestMethod.GET, value = "/index.do")
    public String index(Model modelo)
    {
        ConsultasNoticias noticiasBean = new ConsultasNoticias(daoNoticias);
        modelo.addAttribute("Noticias", noticiasBean.consultaNoticiasPrincipales("desc"));
        return "/NavegacionPrincipal/index";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/mostrarNoticiaCompleta.do")
    @ResponseBody
    public NoticiaJson mostarNoticiaCompleta(Model modelo, String idNoticia)
    {
        NoticiaJson noticia = new NoticiaJson();
        ConsultasNoticias noticiasBean = new ConsultasNoticias(daoNoticias);
        noticia.setTitulo(noticiasBean.consultaNoticiaPrincipal(Integer.parseInt(idNoticia)).getTitulo());
        noticia.setDetalle(noticiasBean.consultaNoticiaPrincipal(Integer.parseInt(idNoticia)).getDetalle());
        System.out.println("descrpcion" + noticia.getDetalle());
        return noticia;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/convocatorias.do")
    public String convocatorias(Model a)
    {
        return "/NavegacionPrincipal/convocatorias";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/muestraReglamento.do")
    public String muestraReglamento(Model modelo, String alumno_id)
    {
        return "/NavegacionPrincipal/muestraReglamento";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/muestraReglamentoFinal.do")
    public String muestraReglamentoFinal(Model modelo, String alumno_id)
    {
        return "/NavegacionPrincipal/muestraReglamentoFinal";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/manualProcedimiento.do")
    public String manualProcedimiento(Model a)
    {
        return "/NavegacionPrincipal/manualProcedimiento";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/organizaciones.do")
    public String organizaciones(Model a)
    {
        return "/NavegacionPrincipal/organizaciones";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/acercaDe.do")
    public String acercaDe(Model a)
    {
        return "/NavegacionPrincipal/acercaDe";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/acercaDeAdmin.do")
    public String acercaDeAdmin(Model a)
    {
        return "/NavegacionPrincipal/acercaDeAdmin";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/loginOrganizaciones.do")
    public String loginOrganizaciones(Model a)
    {
        return "/NavegacionPrincipal/loginOrganizaciones";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/registroOrganizaciones.do")
    public String registroOrganizaciones(Model model)
    {
        model.addAttribute("preOrganizaciones", daoInstancia.findBySpecificField("status", "2", "equal", null, null));
        model.addAttribute("instancia", new Instancia());
        model.addAttribute("tipoOrganizaciones", daoTipoOrganizacion.findBySpecificField("estatus", "1", "equal", null, null));
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("nombre", "asc");
        model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
        return "/Organizaciones/registroOrganizaciones";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login.do")
    public String loginAlumnos(Model a)
    {
        return "/NavegacionPrincipal/loginPrincipal";
    }

    @RequestMapping(method = RequestMethod.GET, value = "cerrarSesion.do")
    public String cerrarSesion(Model model, HttpSession session, HttpServletRequest request)
    {
        session = request.getSession();
        session.invalidate();
        return "redirect:index.do";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/validaLogin.do")
    public String validaLogin(Model model, String usuario, String pass, HttpSession session, HttpServletRequest request)
    {
        session = request.getSession();

        ValidaLogin login = new ValidaLogin();
        SesionBean sesionBean = login.validaLogin(usuario, pass, 
                daoVistaAlumno, daoInstancia, daoUsuarioInstancia, session);

        if(sesionBean.getMensaje() != null)
        {
            model.addAttribute("error", sesionBean.getMensaje());
            model.addAttribute("MENSAJE", session.getAttribute("MENSAJE"));
        }
        System.out.println("retorna:" + sesionBean.getPagReturn());
        return sesionBean.getPagReturn();

    }
}
