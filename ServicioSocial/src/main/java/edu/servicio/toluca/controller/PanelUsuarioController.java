/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.ReportesBean;
import edu.servicio.toluca.beans.SancionesBean;
import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.beans.formatoUnico.FormatoUnicoPanelUsuarioBean;
import edu.servicio.toluca.beans.platica.FoliosPlaticaBean;
import edu.servicio.toluca.model.vistaalumno.ConsultasVistaAlumno;
import edu.servicio.toluca.model.formatoUnico.ValidacionPanelUsuarioFU;
import edu.servicio.toluca.model.noticias.ConsultasNoticias;
import edu.servicio.toluca.model.observaciones.ObservacionesModel;
import edu.servicio.toluca.model.panelUsuario.ValidacionStatusServicio;
import edu.servicio.toluca.model.platica.ConsultasPlatica;
import edu.servicio.toluca.model.reportesBimestrales.ValidaReportesBimestralesModel;
import edu.servicio.toluca.model.sanciones.ConsultasPanelUsuarioSanciones;
import edu.servicio.toluca.sesion.FoliosPlaticaFacade;
import edu.servicio.toluca.sesion.NoticiasFacade;
import edu.servicio.toluca.sesion.RegObservacionesFacade;
import edu.servicio.toluca.sesion.SancionesFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author roy
 */
@Controller
public class PanelUsuarioController {

    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    public VistaAlumnoFacade vistaAlumnoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/FoliosPlaticaFacade")
    public FoliosPlaticaFacade foliosPlaticaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/NoticiasFacade")
    public NoticiasFacade noticiasFacade;
    @EJB(mappedName = "java:global/ServicioSocial/RegObservacionesFacade")
    public RegObservacionesFacade regObservacionesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/SancionesFacade")
    public SancionesFacade sancionesFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/panelUsuario.do")
    public String panelUsuario(Model model, HttpSession session, HttpServletRequest request, String mensaje) {
        //Valida sesion
        if (!new ValidaSesion().validaAlumno(session, request)) {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        System.out.println("NCONTROL:" + session.getAttribute("NCONTROL").toString());

        //Obtenemos al alumno
        ConsultasVistaAlumno consultaVistaAlumno = new ConsultasVistaAlumno(vistaAlumnoFacade);
        VistaAlumno alumno = consultaVistaAlumno.getAlumnoSesion(session);

        System.out.println("Bienvenido al panel de usuario " + alumno.getNombre());

        //Cargar noticias noticias
        ConsultasNoticias noticias = new ConsultasNoticias(noticiasFacade);
        model.addAttribute("noticiasAlumnos", noticias.consultaNoticiasGenerales("desc"));

        //Valida estatus del servicio social
        ValidacionStatusServicio validacionServicio = new ValidacionStatusServicio();
        /**
         * servicioBean validara el status del servicio social, y traera en sus
         * atributos: DatosPersonales FormatoUnico ...
         */
        StatusServicioBean servicioBean = validacionServicio.validaServicio(alumno);

        //Hara las validaciones pertinentes si el estatus del servicio esta activo
        if (servicioBean.getStatusServicio() == 1) {
            //Checa platica
            ConsultasPlatica platica = new ConsultasPlatica(foliosPlaticaFacade);
            FoliosPlaticaBean beanPlatica = platica.checaAlumnoPlatica(servicioBean);

            model.addAttribute("platica", beanPlatica.isTienePlatica());
            model.addAttribute("accesoPlatica", beanPlatica.isAccesoPanelPlatica());
            model.addAttribute("mensajePlatica", beanPlatica.getMensajeUsuario());

            //Valida Formato Unico
            try {
                if (servicioBean.getDatosPersonales() != null) {
                    ValidacionPanelUsuarioFU valFormatoUnico = new ValidacionPanelUsuarioFU();
                    FormatoUnicoPanelUsuarioBean beanFU = valFormatoUnico.validaPanelUsuario(servicioBean);
                    
                    System.out.println("Val FUI:"+beanFU.getMensaje());
                    model.addAttribute("accesoFormatoUnico", beanFU.isAccesoFormatoUnico());
                    model.addAttribute("statusFui", beanFU.getStatusFui());
                    model.addAttribute("mensajeFormatoUnico", beanFU.getMensaje());
                } else {
                    model.addAttribute("accesoFormatoUnico", true);
                    model.addAttribute("statusFui", 2);
                    model.addAttribute("mensajeFormatoUnico", "No has dado de alta tu Formato Unico");
                }
            } catch (Exception e) {
                System.out.println("Error en la validacion del formato unico");
                e.printStackTrace();
            }

            //Mensaje personal
            if (mensaje != null) {
                model.addAttribute("mensajePersonal", "<div class='error'>" + mensaje + "</div>");
            }

            //Observaciones
            try {
                if (servicioBean.getDatosPersonales() != null) {
                    ObservacionesModel observaciones = new ObservacionesModel();
                    model.addAttribute("observaciones", observaciones.consultaObservaciones(servicioBean.getDatosPersonales(), regObservacionesFacade, "desc"));
                }
            } catch (Exception e) {
                System.out.println("Eror en observaciones");
                e.printStackTrace();
            }

            //Reportes Bimestrales
            try{
                if (servicioBean.getDatosPersonales() != null) {
                    ValidaReportesBimestralesModel bimestralesModel = new ValidaReportesBimestralesModel();
                    ReportesBean reporteBimestral =  bimestralesModel.validaReportesBimestrales(servicioBean);
                    
                    System.out.println("reporteBimestral:"+reporteBimestral.getMensaje());
                    model.addAttribute("accesoReportesBimestrales", reporteBimestral.isAccesoFormato());
                    model.addAttribute("mensajeReportesBimestrales", reporteBimestral.getMensaje());
                    model.addAttribute("statusReporteBimestrales", reporteBimestral.getStatus());
                }
            }catch(Exception e){
                System.out.println("Error en validacion de reportes bimestrales");
                e.printStackTrace();                
            }

            //Sanciones
            try {
                if (servicioBean.getDatosPersonales() != null) {
                    ConsultasPanelUsuarioSanciones consultaSanciones = new ConsultasPanelUsuarioSanciones();
                    SancionesBean sancionesBean = consultaSanciones.consultaHorasSancion(servicioBean);

                    model.addAttribute("mensajeSanciones", sancionesBean.getMensaje());
                    model.addAttribute("accesoSanciones", true);
                    model.addAttribute("tieneSancion", sancionesBean.isTieneSancion());
                    model.addAttribute("sanciones", consultaSanciones.listaSanciones(servicioBean.getDatosPersonales(), sancionesFacade, "desc"));
                }
            } catch (Exception e) {
                System.out.println("Eror en observaciones");
                e.printStackTrace();
            }

        } else {

            //Accesos
            model.addAttribute("accesoPlatica", false);
            model.addAttribute("accesoFormatoUnico", false);
            model.addAttribute("accesoSanciones", false);

            //If servicio social terminado
            if (servicioBean.getStatusServicio() == 4) {
                model.addAttribute("platica", true);
                model.addAttribute("statusFui", 1);
            } else {
                model.addAttribute("platica", false);
                model.addAttribute("statusFui", 2);
            }

            //Mensajes
            model.addAttribute("mensajeFormatoUnico", servicioBean.getMensaje());
            model.addAttribute("mensajePlatica", servicioBean.getMensaje());
            model.addAttribute("mensajeReportesBimestrales", servicioBean.getMensaje());
            model.addAttribute("mensajeReportesMensuales", servicioBean.getMensaje());
            model.addAttribute("mensajePlaticaBecados", servicioBean.getMensaje());
            model.addAttribute("mensajeDocumentosFinales", servicioBean.getMensaje());
            model.addAttribute("mensajeSanciones", servicioBean.getMensaje());
        }


        return "/PanelUsuario/panelUsuario";


    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/pruebaPopover.do")
    public String pruebaPopover(Model model, HttpSession session, HttpServletRequest request, String mensaje) {
        return "/PanelUsuario/pruebaPopover";
    }
        
}
