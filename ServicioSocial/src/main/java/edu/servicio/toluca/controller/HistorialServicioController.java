/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.ReportesBean;
import edu.servicio.toluca.beans.ReportesFinalesBean;
import edu.servicio.toluca.beans.SancionesBean;
import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.model.historialservicio.HistorialServicioModel;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import java.util.ArrayList;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.beans.formatoUnico.FormatoUnicoPanelUsuarioBean;
import edu.servicio.toluca.beans.platica.FoliosPlaticaBean;
import edu.servicio.toluca.entidades.BajaTemporal;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.LogServicio;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.model.documentosFinales.ValidaDocumentosFinalesModel;
import edu.servicio.toluca.model.formatoUnico.ValidacionPanelUsuarioFU;
import edu.servicio.toluca.model.observaciones.ObservacionesModel;
import edu.servicio.toluca.model.panelUsuario.ValidacionStatusServicio;
import edu.servicio.toluca.model.platica.ConsultasPlatica;
import edu.servicio.toluca.model.reportesBimestrales.ValidaReportesBimestralesModel;
import edu.servicio.toluca.model.sanciones.ConsultasPanelUsuarioSanciones;
import edu.servicio.toluca.model.vistaalumno.ConsultasVistaAlumno;
import edu.servicio.toluca.sesion.BajaTemporalFacade;
import edu.servicio.toluca.sesion.FoliosPlaticaFacade;
import edu.servicio.toluca.sesion.LogServicioFacade;
import edu.servicio.toluca.sesion.NoticiasFacade;
import edu.servicio.toluca.sesion.RegObservacionesFacade;
import edu.servicio.toluca.sesion.SancionesFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador para el historial de servicio social Autor: Jose Manuel Nieto
 * Gomez
 *
 * @author bustedvillain
 */
@Controller
public class HistorialServicioController
{

    @EJB(mappedName = "java:global/ServicioSocial/DatosPersonalesFacade")
    public DatosPersonalesFacade datosPersonalesFacade;
    
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
    
    @EJB(mappedName = "java:global/ServicioSocial/BajaTemporalFacade")
    private BajaTemporalFacade bajaTemporal;

    @RequestMapping(method = RequestMethod.GET, value = "/historialServicio.do")
    public String historialServicio(Model model, HttpSession session, HttpServletRequest request)
    {
        //Valida sesion
        ValidaSesion valSession = new ValidaSesion(session, request);
        if(valSession.accesaPanelAdministrador())
        {
            //Modelo para procesar el historial de alumnos
            HistorialServicioModel historialModel = new HistorialServicioModel(datosPersonalesFacade);
            
            //Obtener todos los alumnos procesados en el sistema y validandolos
            List<StatusServicioBean> alumnos = new ArrayList<StatusServicioBean>();
            try
            {
                alumnos = historialModel.getHistorialAlumnos();
            } 
            catch(Exception e)
            {
                System.err.println("Error al cargar alumnos en el servicio social");
            }

            //Inyectando alumnos
            List<BajaTemporal> bajasTemporales = bajaTemporal.findAll();
            model.addAttribute("alumnos", alumnos);
            model.addAttribute("bajasTemporales", bajasTemporales);

            return "/HistorialServicio/historialServicio";
        } 
        else
        {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/verProcesoAlumno.do")
    public String verProcesoAlumno(Model model, HttpSession session, HttpServletRequest request, @RequestParam String id)
    {
        //Valida sesion
        ValidaSesion valSession = new ValidaSesion(session, request);
        if(valSession.accesaPanelAdministrador())
        {
            try
            {
                //Obtenemos al alumno
                ConsultasVistaAlumno consultaVistaAlumno = new ConsultasVistaAlumno(vistaAlumnoFacade);
                VistaAlumno alumno = consultaVistaAlumno.getAlumno(id);

                //Valida el servicio social
                ValidacionStatusServicio validacionServicio = new ValidacionStatusServicio();
                StatusServicioBean servicioBean = validacionServicio.validaServicio(alumno);

                //Tipo de usuario
                model.addAttribute("tipoPanel", servicioBean.getTipoPanel());

                //Hara las validaciones pertinentes si el estatus del servicio esta activo
                if(servicioBean.getStatusServicio() == 1)
                {
                    /**
                     * El tipo de panel que se le va a mostrar al alumno
                     * 0:Interno 1:Egresado 2:Egresado haciendo servicio normal
                     */
                    //Checa si es egresado, o si es egresado realizando servicio
                    if(servicioBean.getTipoPanel() == 1 || servicioBean.getTipoPanel() == 2)
                    {
                        //Proceso inicial del egresado, sin poder realizar el proceso de servicio social
                        model.addAttribute("accesoCartaMotivos", servicioBean.getEgresado().isAccesoCartaMotivos());
                        model.addAttribute("mensajeCartaMotivos", servicioBean.getEgresado().getMensajeCartaMotivos());
                        model.addAttribute("statusCartaMotivos", servicioBean.getEgresado().getStatusCartaMotivos());
                    }
                    //Checa si es alumno interno haciendo servicio normal o egresado haciendo servicio normal
                    if(servicioBean.getTipoPanel() == 0 || servicioBean.getTipoPanel() == 2)
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
                            if(servicioBean.getDatosPersonales() != null)
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
                                model.addAttribute("mensajeFormatoUnico", "No has dado de alta tu Formato Único");
                            }
                        } catch(Exception e)
                        {
                            System.out.println("Error en la validacion del formato unico");
                            e.printStackTrace();
                        }

                        //Observaciones
                        try
                        {
                            if(servicioBean.getDatosPersonales() != null)
                            {
                                ObservacionesModel observaciones = new ObservacionesModel();
                                model.addAttribute("observaciones", observaciones.consultaObservaciones(servicioBean.getDatosPersonales(), regObservacionesFacade, "desc"));
                            }
                        } catch(Exception e)
                        {
                            System.out.println("Eror en observaciones");
                            e.printStackTrace();
                        }

                        //Reportes Bimestrales
                        try
                        {
                            if(servicioBean.getDatosPersonales() != null)
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
                        } catch(Exception e)
                        {
                            System.out.println("Error en validacion de reportes bimestrales");
                            e.printStackTrace();
                        }

                        //Sanciones
                        try
                        {
                            if(servicioBean.getDatosPersonales() != null)
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
                        } catch(Exception e)
                        {
                            System.out.println("Eror en observaciones");
                            e.printStackTrace();
                        }

                        //Documentos Finales
                        try
                        {
                            if(servicioBean.getDatosPersonales() != null)
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
                        } catch(Exception e)
                        {
                            System.out.println("Eror en observaciones");
                            e.printStackTrace();
                        }

                        //Historial de servicio social
                        HistorialServicioModel historialModel = new HistorialServicioModel(logServicioFacade);
                        List<LogServicio> historialServicio = new ArrayList<LogServicio>();
                        historialServicio = historialModel.getHistorialEventos(servicioBean.getDatosPersonales());
                        model.addAttribute("historialEventos", historialServicio);
                    }

                } else
                {
                    //Es la primera vez que ingresa al sistema

                    //Checa si es alumno interno entrando por primera vez
                    if(servicioBean.getTipoPanel() == 0)
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
                        if(servicioBean.getStatusServicio() == 4)
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
                    if(servicioBean.getTipoPanel() == 1)
                    {
                        //Proceso inicial del egresado, sin poder realizar el proceso de servicio social
                        model.addAttribute("accesoCartaMotivos", servicioBean.getEgresado().isAccesoCartaMotivos());
                        model.addAttribute("mensajeCartaMotivos", servicioBean.getEgresado().getMensajeCartaMotivos());
                        model.addAttribute("statusCartaMotivos", servicioBean.getEgresado().getStatusCartaMotivos());
                    }
                }

            } catch(Exception e)
            {
                e.printStackTrace();
            }

            return "/HistorialServicio/verProcesoAlumno";
        } else
        {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/verInfoAlumno.do")
    public String historialServicio(Model model, HttpSession session, HttpServletRequest request, @RequestParam String id)
    {
        //Valida sesion
        ValidaSesion valSession = new ValidaSesion(session, request);
        if(valSession.accesaPanelAdministrador())
        {
            //Obtenemos al alumno
            ConsultasVistaAlumno consultaVistaAlumno = new ConsultasVistaAlumno(vistaAlumnoFacade);
            VistaAlumno alumno = consultaVistaAlumno.getAlumno(id);

            try
            {
                List<DatosPersonales> datosPersonales = new ArrayList<DatosPersonales>(alumno.getDatosPersonalesCollection());
                model.addAttribute("alumno", datosPersonales.get(0));
                return "/HistorialServicio/verInfoAlumno";
            } 
            catch(Exception e)
            {
                System.err.println("Error al cargar datos personales");
                return "error";
            }

        } 
        else
        {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
    }
}
