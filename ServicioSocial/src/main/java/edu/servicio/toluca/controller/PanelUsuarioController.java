/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.ReportesBean;
import edu.servicio.toluca.beans.ReportesFinalesBean;
import edu.servicio.toluca.beans.SancionesBean;
import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.beans.formatoUnico.FormatoUnicoPanelUsuarioBean;
import edu.servicio.toluca.beans.platica.FoliosPlaticaBean;
import edu.servicio.toluca.model.documentosFinales.ValidaDocumentosFinalesModel;
import edu.servicio.toluca.model.vistaalumno.ConsultasVistaAlumno;
import edu.servicio.toluca.model.formatoUnico.ValidacionPanelUsuarioFU;
import edu.servicio.toluca.model.historialservicio.HistorialServicioModel;
import edu.servicio.toluca.model.noticias.ConsultasNoticias;
import edu.servicio.toluca.model.observaciones.ObservacionesModel;
import edu.servicio.toluca.model.panelUsuario.ValidacionStatusServicio;
import edu.servicio.toluca.model.platica.ConsultasPlatica;
import edu.servicio.toluca.model.reportesBimestrales.ValidaReportesBimestralesModel;
import edu.servicio.toluca.model.sanciones.ConsultasPanelUsuarioSanciones;
import edu.servicio.toluca.sesion.FoliosPlaticaFacade;
import edu.servicio.toluca.sesion.LogServicioFacade;
import edu.servicio.toluca.sesion.NoticiasFacade;
import edu.servicio.toluca.sesion.RegObservacionesFacade;
import edu.servicio.toluca.sesion.SancionesFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * Panel de Usuario Autor: Jose Manuel Nieto Gomez
 */
@Controller
public class PanelUsuarioController
{

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
    @EJB(mappedName = "java:global/ServicioSocial/LogServicioFacade")
    public LogServicioFacade logServicioFacade;
    
    private static final Logger logger = LoggerFactory.getLogger(OrganizacionesController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/panelUsuario.do")
    public String panelUsuario(Model model, HttpSession session, HttpServletRequest request, String mensaje)
    {
        //Valida sesion
        if (!new ValidaSesion().validaAlumno(session, request))
        {
            model.addAttribute("error", "<div class='alert alert-danger'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        
        logger.info("Número de Control: ", session.getAttribute("NCONTROL"));

        //Obtenemos al alumno
        ConsultasVistaAlumno consultaVistaAlumno = new ConsultasVistaAlumno(vistaAlumnoFacade);
        VistaAlumno alumno = consultaVistaAlumno.getAlumnoSesion(session);

        logger.info("Bienvenido al panale de usuario");

        //Cargar noticias noticias
        ConsultasNoticias noticias = new ConsultasNoticias(noticiasFacade);
        model.addAttribute("noticiasAlumnos", noticias.consultaNoticiasGenerales("desc"));

        //Valida estatus del servicio social
        ValidacionStatusServicio validacionServicio = new ValidacionStatusServicio();
        /**
         * servicioBean validara el status del servicio social, y traera en sus atributos: private String mensaje;
         * private int statusServicio; private DatosPersonales datosPersonales; private FormatoUnico formatoUnico;
         * private VistaAlumno vistaAlumno; private FoliosPlaticaBean platicaBean; private int horasServicio=0; private
         * ArrayList<Reportes> reportesBimestrales;
         */
        StatusServicioBean servicioBean = validacionServicio.validaServicio(alumno);

        //Tipo de panel
        model.addAttribute("tipoPanel", servicioBean.getTipoPanel());

        //Hara las validaciones pertinentes si el estatus del servicio esta activo
        if (servicioBean.getStatusServicio() == 1)
        {
            /**
             * El tipo de panel que se le va a mostrar al alumno 0:Interno 1:Egresado 2:Egresado haciendo servicio
             * normal
             */
            //Checa si es egresado, o si es egresado realizando servicio
            if (servicioBean.getTipoPanel() == 1 || servicioBean.getTipoPanel() == 2)
            {
                //Proceso inicial del egresado, sin poder realizar el proceso de servicio social
                model.addAttribute("accesoCartaMotivos", servicioBean.getEgresado().isAccesoCartaMotivos());
                model.addAttribute("mensajeCartaMotivos", servicioBean.getEgresado().getMensajeCartaMotivos());
                model.addAttribute("statusCartaMotivos", servicioBean.getEgresado().getStatusCartaMotivos());
            }
            //Checa si es alumno interno haciendo servicio normal o egresado haciendo servicio normal
            if (servicioBean.getTipoPanel() == 0 || servicioBean.getTipoPanel() == 2)
            {
                //Es alumno interno y tambien puede ser un egresado realizando su proceso de servicio social
                //Checa platica
                ConsultasPlatica platica = new ConsultasPlatica(foliosPlaticaFacade);
                FoliosPlaticaBean beanPlatica = platica.checaAlumnoPlatica(servicioBean);

                model.addAttribute("platica", beanPlatica.isTienePlatica());
                model.addAttribute("accesoPlatica", beanPlatica.isAccesoPanelPlatica());
                model.addAttribute("mensajePlatica", beanPlatica.getMensajeUsuario());

                //Valida Formato Unico
                try
                {
                    if (servicioBean.getDatosPersonales() != null)
                    {
                        ValidacionPanelUsuarioFU valFormatoUnico = new ValidacionPanelUsuarioFU();
                        FormatoUnicoPanelUsuarioBean beanFU = valFormatoUnico.validaPanelUsuario(servicioBean);

                        System.out.println("Val FUI:" + beanFU.getMensaje());
                        model.addAttribute("accesoFormatoUnico", beanFU.isAccesoFormatoUnico());
                        model.addAttribute("statusFui", beanFU.getStatusFui());
                        model.addAttribute("mensajeFormatoUnico", beanFU.getMensaje());
                    } else
                    {
                        model.addAttribute("accesoFormatoUnico", true);
                        model.addAttribute("statusFui", 2);
                        model.addAttribute("mensajeFormatoUnico", "No has dado de alta tu Formato Unico");
                    }
                } catch (Exception e)
                {
                    System.out.println("Error en la validacion del formato unico");
                    System.out.println(e.getCause() + e.getMessage());
                }

                //Mensaje personal
//                if (mensaje != null) {
//                    model.addAttribute("mensajePersonal", "<div class='alert alert-danger'>" + mensaje + "</div>");
//                }
                //Observaciones
                try
                {
                    if (servicioBean.getDatosPersonales() != null)
                    {
                        ObservacionesModel observaciones = new ObservacionesModel();
                        model.addAttribute("observaciones", observaciones.consultaObservaciones(servicioBean.getDatosPersonales(), regObservacionesFacade, "desc"));
                    }
                } catch (Exception e)
                {
                    System.out.println("Eror en observaciones");
                    e.printStackTrace();
                }

                //Reportes Bimestrales
                try
                {
                    if (servicioBean.getDatosPersonales() != null)
                    {
                        ValidaReportesBimestralesModel bimestralesModel = new ValidaReportesBimestralesModel();
                        ReportesBean reporteBimestral = bimestralesModel.validaReportesBimestrales(servicioBean);

                        System.out.println("reporteBimestral:" + reporteBimestral.getMensaje());
                        model.addAttribute("accesoReportesBimestrales", reporteBimestral.isAccesoFormato());
                        model.addAttribute("mensajeReportesBimestrales", reporteBimestral.getMensaje());
                        model.addAttribute("statusReporteBimestrales", reporteBimestral.getStatus());
                    } else
                    {
                        model.addAttribute("accesoReportesBimestrales", false);
                        model.addAttribute("mensajeReportesBimestrales", "No has comenzado tu proceso de servicio social");
                        model.addAttribute("statusReporteBimestrales", 2);
                    }
                } catch (Exception e)
                {
                    System.out.println("Error en validacion de reportes bimestrales");
                    e.printStackTrace();
                }

                //Sanciones
                try
                {
                    if (servicioBean.getDatosPersonales() != null)
                    {
                        ConsultasPanelUsuarioSanciones consultaSanciones = new ConsultasPanelUsuarioSanciones();
                        SancionesBean sancionesBean = consultaSanciones.consultaHorasSancion(servicioBean);

                        model.addAttribute("mensajeSanciones", sancionesBean.getMensaje());
                        model.addAttribute("accesoSanciones", true);
                        model.addAttribute("tieneSancion", sancionesBean.isTieneSancion());
                        model.addAttribute("sanciones", consultaSanciones.listaSanciones(servicioBean.getDatosPersonales(), sancionesFacade, "desc"));
                    } else
                    {
                        model.addAttribute("mensajeSanciones", "No has comenzado tu proceso de servicio social");
                        model.addAttribute("accesoSanciones", false);
                        model.addAttribute("tieneSancion", false);
                    }
                } catch (Exception e)
                {
                    System.out.println("Eror en observaciones");
                    e.printStackTrace();
                }

                //Documentos Finales
                try
                {
                    if (servicioBean.getDatosPersonales() != null)
                    {
                        ValidaDocumentosFinalesModel validaDocFinales = new ValidaDocumentosFinalesModel();
                        ReportesFinalesBean reportesFinales = validaDocFinales.validaDocumentosFinales(servicioBean);

                        model.addAttribute("accesoDocumentosFinales", reportesFinales.isPuedeAccesar());
                        model.addAttribute("mensajeDocumentosFinales", reportesFinales.getMensaje());
                        model.addAttribute("statusDocumentosFinales", reportesFinales.getStatus());

                    } else
                    {
                        model.addAttribute("accesoDocumentosFinales", false);
                        model.addAttribute("mensajeDocumentosFinales", "No has comenzado tu proceso de servicio social");
                        model.addAttribute("statusDocumentosFinales", 2);
                    }
                } catch (Exception e)
                {
                    System.out.println("Eror en observaciones");
                    e.printStackTrace();
                }
            }

        } else
        {
            //Es la primera vez que ingresa al sistema

            //Checa si es alumno interno entrando por primera vez
            if (servicioBean.getTipoPanel() == 0)
            {

                //Accesos
                model.addAttribute("accesoPlatica", false);
                model.addAttribute("accesoFormatoUnico", false);
                model.addAttribute("accesoSanciones", false);
                model.addAttribute("accesoReportesBimestrales", false);
                model.addAttribute("accesoDocumentosFinales", false);

                //Mensajes
                model.addAttribute("mensajeFormatoUnico", servicioBean.getMensaje());
                model.addAttribute("mensajePlatica", servicioBean.getMensaje());
                model.addAttribute("mensajeReportesBimestrales", servicioBean.getMensaje());
                model.addAttribute("mensajeReportesMensuales", servicioBean.getMensaje());
                model.addAttribute("mensajePlaticaBecados", servicioBean.getMensaje());
                model.addAttribute("mensajeDocumentosFinales", servicioBean.getMensaje());
                model.addAttribute("mensajeSanciones", servicioBean.getMensaje());

                //If servicio social terminado            
                if (servicioBean.getStatusServicio() == 4)
                {
                    //Para poner palomas a todos los procesos del servicio
                    model.addAttribute("platica", true);
                    model.addAttribute("statusFui", 1);
                    model.addAttribute("statusReporteBimestrales", 1);
                    model.addAttribute("statusDocumentosFinales", 1);
                    model.addAttribute("tieneSancion", false);

                } else
                {
                    //Para poner taches a todos los procesos del servicio
                    model.addAttribute("platica", false);
                    model.addAttribute("statusFui", 2);
                    model.addAttribute("statusReporteBimestrales", 2);
                    model.addAttribute("statusDocumentosFinales", 2);
                    model.addAttribute("tieneSancion", true);
                }
            }

            //Checa si es egresado entrando por primera vez
            if (servicioBean.getTipoPanel() == 1)
            {
                //Proceso inicial del egresado, sin poder realizar el proceso de servicio social
                model.addAttribute("accesoCartaMotivos", servicioBean.getEgresado().isAccesoCartaMotivos());
                model.addAttribute("mensajeCartaMotivos", servicioBean.getEgresado().getMensajeCartaMotivos());
                model.addAttribute("statusCartaMotivos", servicioBean.getEgresado().getStatusCartaMotivos());
            }
        }

        return "/PanelUsuario/panelUsuario";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/pruebaPopover.do")
    public String pruebaPopover(Model model, HttpSession session, HttpServletRequest request, String mensaje)
    {
        return "/PanelUsuario/pruebaPopover";
    }
}
