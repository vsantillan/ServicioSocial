/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.beans.bimestrales.fechas;
import edu.servicio.toluca.beans.bimestrales.reporteBimestral;
import edu.servicio.toluca.entidades.Actividades;
import edu.servicio.toluca.entidades.BimestralesActividades;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.Reportes;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.model.panelUsuario.ValidacionStatusServicio;
import edu.servicio.toluca.model.vistaalumno.ConsultasVistaAlumno;
import edu.servicio.toluca.sesion.ActividadesFacade;
import edu.servicio.toluca.sesion.BimestralesActividadesFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.ReportesFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import edu.servicio.toluca.dao.GenericDao;

/**
 *
 * @author roy
 */
@Controller
public class ReporteBimestralController {
    
    private GenericDao<DatosPersonales> daoDatosPersonales;
    private GenericDao<VistaAlumno> daoVistaAlumno;
    private GenericDao<FormatoUnico> daoFormatoUnico;
    private GenericDao<Reportes> daoReportes;
    private GenericDao<BimestralesActividades> daoBimestralesActividades;
    private GenericDao<Actividades> daoActividades;
    

    @Autowired
    public void setdaoDatosPersonales(GenericDao<DatosPersonales> daoDatosPersonales){
        this.daoDatosPersonales = daoDatosPersonales;
        daoDatosPersonales.setClass(DatosPersonales.class);
    }
    
   
    @Autowired
    public void setdaoVistaAlumno(GenericDao<VistaAlumno> daoVistaAlumno){
        this.daoVistaAlumno = daoVistaAlumno;
        daoVistaAlumno.setClass(VistaAlumno.class);
    }
    @Autowired
    public void setdaoFormatoUnico(GenericDao<FormatoUnico> daoFormatoUnico){
        this.daoFormatoUnico = daoFormatoUnico;
        daoFormatoUnico.setClass(FormatoUnico.class);
    }
    
    @Autowired
    public void setdaoReportes(GenericDao<Reportes> daoReportes){
        this.daoReportes = daoReportes;
        daoReportes.setClass(Reportes.class);
    }
    
    @Autowired
    public void setdaoBimestralesActividades(GenericDao<BimestralesActividades> daoBimestralesActividades){
        this.daoBimestralesActividades = daoBimestralesActividades;
        daoBimestralesActividades.setClass(BimestralesActividades.class);
    }
    @Autowired
    public void setdaoActividades(GenericDao<Actividades> daoActividades){
        this.daoActividades = daoActividades;
        daoActividades.setClass(Actividades.class);
    }
    
//    @EJB(mappedName = "java:global/ServicioSocial/ReportesFacade")
////    private ReportesFacade reportesFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/BimestralesActividadesFacade")
//    private BimestralesActividadesFacade actividadesBimestralesFacade;
//    @EJB(mappedName = "java:global/ServicioSocial/ActividadesFacade")
//    private ActividadesFacade actividadesFacade;

//    @RequestMapping(method = RequestMethod.GET, value = "/reporteBimestralAdministrador.do")
//    public String reporteBimestralAdministrador(Model modelo) {
//        return "/ReporteBimestral/reporteBimestralAdministrador";
//    }
    @RequestMapping(method = RequestMethod.GET, value = "/formatoReporteBimestral.do")
    public String reporteBimestralUsuario(Model modelo, String alumno_id, HttpSession session, HttpServletRequest request, String OK) throws ParseException {
        if (OK != null) {
            if (OK.equals("true")) {
                modelo.addAttribute("alertCorrecto", "<script>alert('Informacion guardada correctamente');</script>");
            }else if(OK.equals("false")){
                 modelo.addAttribute("alertCorrecto", "<div class='alert alert-danger'>Error, Primero debe generar su reporte</div>");
            }
        }

        FormatoUnico fechaInicioFU = null;

        //Obtenemos Objetos del Alumno
        ConsultasVistaAlumno consultaVistaAlumno = new ConsultasVistaAlumno(daoVistaAlumno);
        VistaAlumno alumnoB = consultaVistaAlumno.getAlumnoSesion(session);
        ValidacionStatusServicio validaServicio = new ValidacionStatusServicio();
        StatusServicioBean servicioBean = validaServicio.validaServicio(alumnoB);



        if (!new ValidaSesion().validaAlumno(session, request)) {
            modelo.addAttribute("error", "<div class='alert alert-danger''>Debes iniciar sesiÃ³n para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        ///////////MUESTRA REPORTES/////////////
        List<Reportes> listaReportes = daoReportes.findBySpecificField("datosPersonalesId", servicioBean.getDatosPersonales().getId(), "equal", null, null);
        List<FormatoUnico> listaFormatoUnicos = (List) servicioBean.getDatosPersonales().getFormatoUnicoCollection();
        modelo.addAttribute("Plan", listaFormatoUnicos.get(0).getCatalogoPlanId().getDetalle());
        modelo.addAttribute("listaReportes", listaReportes);
        ////////////////////////////////////////
        alumno_id = session.getAttribute("NCONTROL").toString();
        reporteBimestral RBObjeto = new reporteBimestral();
        ///////////BUSCAR ALUMNO///////////
        List<VistaAlumno> listaAlumnos = daoVistaAlumno.findBySpecificField("id", alumno_id, "equal", null, null);
        VistaAlumno alumno = listaAlumnos.get(0);
        List<DatosPersonales> datosPersonales = daoDatosPersonales.findBySpecificField("alumnoId", alumno, "equal", null, null);
        if (!datosPersonales.isEmpty()) {
            DatosPersonales DP = datosPersonales.get(0);
            modelo.addAttribute("datosPersonales", datosPersonales);
            List<FormatoUnico> formatoUnico = daoFormatoUnico.findBySpecificField("datosPersonalesId", DP.getId(), "equal", null, null);
            fechaInicioFU = formatoUnico.get(0);

            /////////////Validamos si es su primer reporte//////////////
            LinkedHashMap ordenarAsc = new LinkedHashMap();
            ordenarAsc.put("id", "asc");
            List<Reportes> RB = daoReportes.findBySpecificField("datosPersonalesId", DP.getId(), "equal", ordenarAsc, null);
            if (RB.isEmpty()) {

                modelo.addAttribute("numeroReporte", 1);
                modelo.addAttribute("noReviciones", 0);
                fechas fechas = new fechas();
                RBObjeto.setCalificacion(0);
                RBObjeto.setFechaInicio(fechas.convierteDate(fechaInicioFU.getFechaInicio()));
                RBObjeto.setFechaFin(fechas.dameFechaFin(fechaInicioFU.getFechaInicio()));
                RBObjeto.setHorasAcumuladas(fechaInicioFU.getHorasAcumuladas());
                RBObjeto.setHoras(0);

                modelo.addAttribute("Reportes", RBObjeto);
            } else {
                fechas fechas = new fechas();
                int noReportes = 1;
                for (int i = 0; i < RB.size(); i++) {
                    Reportes reporteBimestral = RB.get(i);
                    if (reporteBimestral.getStatus() == BigInteger.valueOf(1)) {//Checar cual el es el status de formato aprobado
                        noReportes++;
                    }

                }
                Reportes ultimoReporte = RB.get(RB.size() - 1);
                RBObjeto.setNumeroReporte(noReportes);
                if (noReportes == Integer.parseInt(String.valueOf(ultimoReporte.getNumeroReporte()))) {
                    modelo.addAttribute("noReviciones", ultimoReporte.getNumeroRevisiones());
                } else {
                    modelo.addAttribute("noReviciones", "0");
                }
                //Buscar el ultimo reporte Bimestral con status aprobado
                //Y sacar esa fecha finwt
                //Verificar el status para en correccion  o para aceptado
                if (ultimoReporte.getNumeroRevisiones().compareTo(BigInteger.ZERO) > 0) {
                    RBObjeto.setFechaInicio(fechas.convierteDate(ultimoReporte.getFechaFin()));
                    //Sumar los dos meses a fecha FIn
                    RBObjeto.setFechaFin(fechas.dameFechaFin(ultimoReporte.getFechaFin()));
                    System.out.println("Es mayor que cero el numero de revisiones");
                } else {
                    if (ultimoReporte.getNumeroReporte().compareTo(BigInteger.ONE) == 1) {
                        RBObjeto.setFechaInicio(fechas.convierteDate(ultimoReporte.getFechaFin()));
                        //Sumar los dos meses a fecha FIn
                        RBObjeto.setFechaFin(fechas.dameFechaFin(ultimoReporte.getFechaFin()));
                        System.out.println("Es mayor que uno el numero de reportes");
                    } else {
                        RBObjeto.setFechaInicio(fechas.convierteDate(fechaInicioFU.getFechaInicio()));
                        RBObjeto.setFechaFin(fechas.dameFechaFin(fechaInicioFU.getFechaInicio()));
                        System.out.println("No es mayor que uno el numero de reportes");
                    }
                    RBObjeto.setFechaInicio(fechas.convierteDate(fechaInicioFU.getFechaInicio()));
                    RBObjeto.setFechaFin(fechas.dameFechaFin(fechaInicioFU.getFechaInicio()));
                    System.out.println("No es mayor que cero el numero de revisiones");
                }

                RBObjeto.setHorasAcumuladas(fechaInicioFU.getHorasAcumuladas());
                if (ultimoReporte.getStatus() == BigInteger.valueOf(0) || ultimoReporte.getStatus() == BigInteger.valueOf(3)) {
                    RBObjeto.setHoras(Integer.parseInt(ultimoReporte.getHoras().toString()));
                    RBObjeto.setCalificacion(Integer.parseInt(ultimoReporte.getCalificacion().toString()));
                } else {
                    RBObjeto.setHoras(0);
                    RBObjeto.setCalificacion(0);
                }
                System.out.println("Horas" + Integer.parseInt(ultimoReporte.getHoras().toString()));
                System.out.println("Calificacion" + Integer.parseInt(ultimoReporte.getCalificacion().toString()));
                modelo.addAttribute("Reportes", RBObjeto);

            }
            //////////////////////////////////////////////////////////////

            return "/ReporteBimestral/formatoReporteBimestral";
        } else {
            return "/PanelUsuario/panelUsuario";
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/retroalimentacionReportesBimestrales.do")
    public String retroalimentacionBimestralUsuario(Model a) {
        return "/ReporteBimestral/retroalimentacionReportesBimestrales";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insertaReporte.do")
    public String insertaBimestral(@ModelAttribute("Reportes") @Valid reporteBimestral reporte, BindingResult resultado, Model modelo, String selectfrom, HttpSession session, HttpServletRequest request) {
        LinkedHashMap ordenarAsc = new LinkedHashMap();
        ordenarAsc.put("id", "asc");
        selectfrom += "";
        //Obtenemos Objetos del Alumno
        ConsultasVistaAlumno consultaVistaAlumno = new ConsultasVistaAlumno(daoVistaAlumno);
        VistaAlumno alumnoB = consultaVistaAlumno.getAlumnoSesion(session);
        ValidacionStatusServicio validaServicio = new ValidacionStatusServicio();
        StatusServicioBean servicioBean = validaServicio.validaServicio(alumnoB);

        ///////////MUESTRA REPORTES/////////////
        List<Reportes> listaReportes = daoReportes.findBySpecificField("datosPersonalesId", servicioBean.getDatosPersonales().getId(), "equal", null, null);
        List<FormatoUnico> listaFormatoUnicos = (List) servicioBean.getDatosPersonales().getFormatoUnicoCollection();
        //modelo.addAttribute("Plan", listaFormatoUnicos.get(0).getCatalogoPlanId().getDetalle());
        modelo.addAttribute("listaReportes", listaReportes);
        ////////////////////////////////////////

        String alumno_id = session.getAttribute("NCONTROL").toString();
        List<String> listaIds = null;
        if (!selectfrom.isEmpty() || selectfrom != null) {
            listaIds = new ArrayList<String>();
            StringTokenizer palabra = new StringTokenizer(selectfrom, ",");
            while (palabra.hasMoreTokens()) {
                listaIds.add(palabra.nextToken());
            }
            System.out.println("tamaÃ±o de la lista:" + listaIds.size());
            if (listaIds.size() <= 1 || listaIds.isEmpty()) {
                modelo.addAttribute("errorActividades", "<div class='alert alert-danger'>Seleccione como minimo 2 Actividades</div>");
                //---------------------------------------------------------//
                //Agregamos el error de las actividaes para regresarlos    //
                //todos de una sola vez                                    //
                //---------------------------------------------------------//
                ObjectError ao = new ObjectError("Actividaes", "hola");
                resultado.addError(ao);
            }
        }
        List<VistaAlumno> listaAlumnos = daoVistaAlumno.findBySpecificField("id", alumno_id, "equal", null, null);
        VistaAlumno alumno = listaAlumnos.get(0);
        List<DatosPersonales> datosPersonales = daoDatosPersonales.findBySpecificField("alumnoId", alumno, "equal", null, null);

        //------------------------------------------------------------------------//
        //Validacion cuando entra String en tipo Number campo Hora----------------//
        //------------------------------------------------------------------------//
        if (reporte.getHoras() == null) {
            if (!datosPersonales.isEmpty()) {
                modelo.addAttribute("datosPersonales", datosPersonales);
            }
            modelo.addAttribute("errorHoras", "<div class='alert alert-danger'>El campo horas debe de ser n&uacute;merico</div>");
            modelo.addAttribute("Reportes", reporte);
            return "/ReporteBimestral/formatoReporteBimestral";
        }
        modelo.addAttribute("errorHoras", "");
        //------------------------------------------------------------------------//
        //------Validacion cuando entra String en tipo Number campo Calificacion--//
        //------------------------------------------------------------------------//
        if (reporte.getCalificacion() == null) {
            if (!datosPersonales.isEmpty()) {
                modelo.addAttribute("datosPersonales", datosPersonales);
            }
            modelo.addAttribute("errorCalificacion", "<div class='alert alert-danger'>El campo calificaci&oacute;n debe de ser n&uacute;merico</div>");
            modelo.addAttribute("Reportes", reporte);
            return "/ReporteBimestral/formatoReporteBimestral";
        }
        modelo.addAttribute("errorCalificacion", "");
        //------------------------------------------------------------------------//
        //------Validacion de Errores con el bean---------------------------------//
        //------------------------------------------------------------------------//
        if (resultado.hasErrors()) {
            System.out.println("Hubo errores:" + resultado.toString());
            if (!datosPersonales.isEmpty()) {
                modelo.addAttribute("datosPersonales", datosPersonales);
            }
            modelo.addAttribute("Reportes", reporte);
            return "/ReporteBimestral/formatoReporteBimestral";
        } else {
            //---------------------------------------------------------//
            //Insertamos el Reporte Bimestral                          //
            //---------------------------------------------------------//

            //Verificar si el status del utimo reporte es rechazado
            //Se borran las Actividades que hay con este

            List<Reportes> bimestralesUltimos = daoReportes.findBySpecificField("datosPersonalesId", servicioBean.getDatosPersonales().getId(), "equal",ordenarAsc, null);

            if (!bimestralesUltimos.isEmpty()) {
                Reportes bimestralU = bimestralesUltimos.get(bimestralesUltimos.size() - 1);
                if (bimestralU.getStatus() == BigInteger.valueOf(0) || bimestralU.getStatus() == BigInteger.valueOf(3)) {
                    //Actualizamos las Horas Acumuladas del Formato Bimestral
                    FormatoUnico actualizaHoras = servicioBean.getFormatoUnico();
                    actualizaHoras.setHorasAcumuladas(actualizaHoras.getHorasAcumuladas().subtract(bimestralU.getHoras()));
                    actualizaHoras.setHorasAcumuladas(BigInteger.valueOf(reporte.getHoras()).add(actualizaHoras.getHorasAcumuladas()));
                    daoFormatoUnico.edit(actualizaHoras);
                    

                    //Actualizamos La informacion del Reporte
                    bimestralU.setHoras(BigInteger.valueOf(reporte.getHoras()));
                    bimestralU.setCalificacion(BigInteger.valueOf(reporte.getCalificacion()));
                    daoReportes.edit(bimestralU);


                    //while para eliminar actividades antiguass
                    List<BimestralesActividades> actividadesEliminar = daoBimestralesActividades.findBySpecificField("idReporte", bimestralU.getId(), "equal", null, null);
                    Iterator<BimestralesActividades> recorreActividades = actividadesEliminar.iterator();
                    while (recorreActividades.hasNext()) {
                        BimestralesActividades borraActividades;
                        borraActividades = recorreActividades.next();
                        daoBimestralesActividades.remove(borraActividades);
                    }
                    Iterator inserta = listaIds.iterator();
                    //while que inserta la lista de las actividades
                    while (inserta.hasNext()) {
                        BimestralesActividades actividadesB = new BimestralesActividades();
                        actividadesB.setIdReporte(bimestralU);
                        List<Actividades> actividades = daoActividades.findBySpecificField("idActividad", inserta.next(), "equal", null, null);
                        actividadesB.setIdActividades(actividades.get(0));
                        daoBimestralesActividades.create(actividadesB);
                    }
                    System.out.println("Actualizo La Informacion Correctamente");
                    //return "/ReporteBimestral/formatoReporteBimestral";
                    return "redirect:formatoReporteBimestral.do?OK=true";
                } else {
                    fechas fecha = new fechas();
                    Reportes reporteBimestral = new Reportes();
                    reporteBimestral.setDatosPersonalesId(datosPersonales.get(0));
                    reporteBimestral.setNumeroReporte(BigInteger.valueOf(reporte.getNumeroReporte()));
                    reporteBimestral.setHoras(BigInteger.valueOf(reporte.getHoras()));
                    reporteBimestral.setCalificacion(BigInteger.valueOf(reporte.getCalificacion()));
                    reporteBimestral.setFechaInicio(fecha.covierteString(reporte.getFechaInicio()));
                    Date fechaFin = fecha.covierteString(reporte.getFechaFin());
                    reporteBimestral.setFechaFin(fechaFin);
                    reporteBimestral.setStatus(BigInteger.ZERO);
                    reporteBimestral.setFechaEntregaMax(fecha.covierteString(fecha.fechaEntrgaMax(fechaFin)));
                    reporteBimestral.setNumeroRevisiones(BigInteger.ZERO);
                    //Creamos el nuevo Reporte Bimestral
                    daoReportes.create(reporteBimestral);

                    //Actualizamos las horas acumuladas en el formato Unico
                    FormatoUnico actualizaHoras = servicioBean.getFormatoUnico();
                    actualizaHoras.setHorasAcumuladas(BigInteger.valueOf(reporte.getHoras()).add(actualizaHoras.getHorasAcumuladas()));
                    daoFormatoUnico.edit(actualizaHoras);
                    System.out.println("Primera Insercion");
                    //---------------------------------------------------------//
                    //Insertamos las actividades del reporte                   //
                    //---------------------------------------------------------//


                    //Buscamos el reporte recien insertado
                    //DatosPersonales dp = datosPersonales.get(0);

                    List<Reportes> bimestrales = daoReportes.findBySpecificField("datosPersonalesId", servicioBean.getDatosPersonales().getId(), "equal", ordenarAsc, null);
                    Reportes bimestralInsertado = bimestrales.get(bimestrales.size() - 1);//tenia -1
                    for (int i = 0; i < bimestrales.size(); i++) {
                        System.out.println("*********************** el num de reporte es: " + bimestrales.get(i).getNumeroReporte());
                    }
                    //System.out.println("*********************** el num de reporte es: "+bimestralInsertado.getNumeroReporte());
                    Iterator inserta = listaIds.iterator();
                    //while que inserta la lista de los perfiles para el proyecto
                    while (inserta.hasNext()) {
                        BimestralesActividades actividadesB = new BimestralesActividades();
                        actividadesB.setIdReporte(bimestralInsertado);
                        List<Actividades> actividades = daoActividades.findBySpecificField("idActividad", inserta.next(), "equal", null, null);
                        actividadesB.setIdActividades(actividades.get(0));
                        daoBimestralesActividades.create(actividadesB);
                    }
                    System.out.println("Inserto N Reporte Correctamente");
                    return "redirect:formatoReporteBimestral.do?OK=true";

                }
                //return "/ReporteBimestral/formatoReporteBimestral";
            }

            fechas fecha = new fechas();
            Reportes reporteBimestral = new Reportes();
            reporteBimestral.setDatosPersonalesId(datosPersonales.get(0));
            reporteBimestral.setNumeroReporte(BigInteger.valueOf(reporte.getNumeroReporte()));
            reporteBimestral.setHoras(BigInteger.valueOf(reporte.getHoras()));
            reporteBimestral.setCalificacion(BigInteger.valueOf(reporte.getCalificacion()));
            reporteBimestral.setFechaInicio(fecha.covierteString(reporte.getFechaInicio()));
            Date fechaFin = fecha.covierteString(reporte.getFechaFin());
            reporteBimestral.setFechaFin(fechaFin);
            reporteBimestral.setStatus(BigInteger.ZERO);
            reporteBimestral.setFechaEntregaMax(fecha.covierteString(fecha.fechaEntrgaMax(fechaFin)));
            reporteBimestral.setNumeroRevisiones(BigInteger.ZERO);
            //Creamos el nuevo Reporte Bimestral
            daoReportes.create(reporteBimestral);

            //Actualizamos las horas acumuladas en el formato Unico
            FormatoUnico actualizaHoras = servicioBean.getFormatoUnico();
            actualizaHoras.setHorasAcumuladas(BigInteger.valueOf(reporte.getHoras()).add(actualizaHoras.getHorasAcumuladas()));
            daoFormatoUnico.edit(actualizaHoras);
            //---------------------------------------------------------//
            //Insertamos las actividades del reporte                   //
            //---------------------------------------------------------//


            //Buscamos el reporte recien insertado
            //DatosPersonales dp = datosPersonales.get(0);
            List<Reportes> bimestrales = daoReportes.findBySpecificField("datosPersonalesId", servicioBean.getDatosPersonales().getId(), "equal", null, null);
            Reportes bimestralInsertado = bimestrales.get(bimestrales.size() - 1);

            Iterator inserta = listaIds.iterator();
            //while que inserta la lista de los perfiles para el proyecto
            while (inserta.hasNext()) {
                BimestralesActividades actividadesB = new BimestralesActividades();
                actividadesB.setIdReporte(bimestralInsertado);
                List<Actividades> actividades =daoActividades.findBySpecificField("idActividad", inserta.next(), "equal", null, null);
                actividadesB.setIdActividades(actividades.get(0));
                daoBimestralesActividades.create(actividadesB);
            }
            System.out.println("Inserto por Primera vez");
            return "redirect:formatoReporteBimestral.do?OK=true";
        }

    }
}
//caundo sean 480 horas sumar 15 dias de la fecha final del ultimo reporte y se asigna en fecha_entrega_fuf de formato unico
//Obtenemos Objetos del Alumno
//        ConsultasVistaAlumno consultaVistaAlumno = new ConsultasVistaAlumno(vistaAlumnoFacade);
//        VistaAlumno alumnoB = consultaVistaAlumno.getAlumnoSesion(session);
//        ValidacionStatusServicio validaServicio = new ValidacionStatusServicio();
//        StatusServicioBean servicioBean = validaServicio.validaServicio(alumnoB);
//
//        List<Reportes> bimestralesUltimos = reportesFacade.findBySpecificField("datosPersonalesId", servicioBean.getDatosPersonales().getId(), "equal", null, null);
//
//        if (!bimestralesUltimos.isEmpty()) {
//            Reportes bimestralU = bimestralesUltimos.get(bimestralesUltimos.size() - 1);
//            
//            
//        }else{
//            return "redirect:panelUsuario.do?mensaje=Aun no ha generado Reporte" ;
//        }