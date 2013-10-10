/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.beans.bimestrales.fechas;
import edu.servicio.toluca.beans.bimestrales.reporteBimestral;
import edu.servicio.toluca.entidades.Actividad;
import edu.servicio.toluca.entidades.Actividades;
import edu.servicio.toluca.entidades.BimestralesActividades;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.ProyectoPerfil;
import edu.servicio.toluca.entidades.Proyectos;
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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author roy
 */
@Controller
public class ReporteBimestralController {

    @EJB(mappedName = "java:global/ServicioSocial/DatosPersonalesFacade")
    private DatosPersonalesFacade datosPersonalesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    private VistaAlumnoFacade vistaAlumnoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
    private FormatoUnicoFacade formatoUnicoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/ReportesFacade")
    private ReportesFacade reportesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/BimestralesActividadesFacade")
    private BimestralesActividadesFacade actividadesBimestralesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/ActividadesFacade")
    private ActividadesFacade actividadesFacade;

//    @RequestMapping(method = RequestMethod.GET, value = "/reporteBimestralAdministrador.do")
//    public String reporteBimestralAdministrador(Model modelo) {
//        return "/ReporteBimestral/reporteBimestralAdministrador";
//    }
    @RequestMapping(method = RequestMethod.GET, value = "/formatoReporteBimestral.do")
    public String reporteBimestralUsuario(Model modelo, String alumno_id, HttpSession session, HttpServletRequest request) throws ParseException {
        FormatoUnico fechaInicioFU = null;



        if (!new ValidaSesion().validaAlumno(session, request)) {
            modelo.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        alumno_id = session.getAttribute("NCONTROL").toString();
        reporteBimestral RBObjeto = new reporteBimestral();
        ///////////BUSCAR ALUMNO///////////
        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", alumno_id, "equal", null, null);
        VistaAlumno alumno = listaAlumnos.get(0);
        List<DatosPersonales> datosPersonales = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
        if (!datosPersonales.isEmpty()) {
            DatosPersonales DP = datosPersonales.get(0);
            modelo.addAttribute("datosPersonales", datosPersonales);
            List<FormatoUnico> formatoUnico = formatoUnicoFacade.findBySpecificField("datosPersonalesId", DP.getId(), "equal", null, null);
            fechaInicioFU = formatoUnico.get(0);

            /////////////Validamos si es su primer reporte//////////////
            List<Reportes> RB = reportesFacade.findBySpecificField("datosPersonalesId", DP.getId(), "equal", null, null);
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
                //Buscar el ultimo reporte Bimestral con status aprobado
                //Y sacar esa fecha fin
                //Verificar el status para en correccion  o para aceptado
                RBObjeto.setFechaInicio(fechas.convierteDate(ultimoReporte.getFechaFin()));
                //Sumar los dos meses a fecha FIn
                RBObjeto.setFechaFin(fechas.dameFechaFin(ultimoReporte.getFechaFin()));
                RBObjeto.setHorasAcumuladas(fechaInicioFU.getHorasAcumuladas());
                if(ultimoReporte.getStatus()==BigInteger.valueOf(0) || ultimoReporte.getStatus()==BigInteger.valueOf(3)){
                     RBObjeto.setHoras(Integer.parseInt(ultimoReporte.getHoras().toString()));
                     RBObjeto.setCalificacion(Integer.parseInt(ultimoReporte.getCalificacion().toString()));
                }
                else{
                    RBObjeto.setHoras(0);
                    RBObjeto.setCalificacion(0);
                }
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
        selectfrom+="";
        //Obtenemos Objetos del Alumno
        ConsultasVistaAlumno consultaVistaAlumno = new ConsultasVistaAlumno(vistaAlumnoFacade);
        VistaAlumno alumnoB = consultaVistaAlumno.getAlumnoSesion(session);
        ValidacionStatusServicio validaServicio = new ValidacionStatusServicio();
        StatusServicioBean servicioBean = validaServicio.validaServicio(alumnoB);

        String alumno_id = session.getAttribute("NCONTROL").toString();
        List<String> listaIds = null;
        if (!selectfrom.isEmpty() || selectfrom != null) {
            listaIds = new ArrayList<String>();
            StringTokenizer palabra = new StringTokenizer(selectfrom, ",");
            while (palabra.hasMoreTokens()) {
                listaIds.add(palabra.nextToken());
            }
            System.out.println("tamaño de la lista:" + listaIds.size());
            if (listaIds.size() <= 1 || listaIds.isEmpty()) {
                modelo.addAttribute("errorActividades", "<div class='error'>Seleccione como minimo 2 Actividades</div>");
                //---------------------------------------------------------//
                //Agregamos el error de las actividaes para regresarlos    //
                //todos de una sola vez                                    //
                //---------------------------------------------------------//
                ObjectError ao = new ObjectError("Actividaes", "hola");
                resultado.addError(ao);
            }
        }
        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", alumno_id, "equal", null, null);
        VistaAlumno alumno = listaAlumnos.get(0);
        List<DatosPersonales> datosPersonales = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
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

            List<Reportes> bimestralesUltimos = reportesFacade.findBySpecificField("datosPersonalesId", servicioBean.getDatosPersonales().getId(), "equal", null, null);

            if (!bimestralesUltimos.isEmpty()) {
                Reportes bimestralU = bimestralesUltimos.get(bimestralesUltimos.size() - 1);
                if (bimestralU.getStatus() == BigInteger.valueOf(0) || bimestralU.getStatus() == BigInteger.valueOf(3)) {
                    //Actualizamos las Horas Acumuladas del Formato Bimestral
                    FormatoUnico actualizaHoras = servicioBean.getFormatoUnico();
                    actualizaHoras.setHorasAcumuladas(actualizaHoras.getHorasAcumuladas().subtract(bimestralU.getHoras()));
                    actualizaHoras.setHorasAcumuladas(BigInteger.valueOf(reporte.getHoras()).add(actualizaHoras.getHorasAcumuladas()));
                    formatoUnicoFacade.edit(actualizaHoras);
                        
                    //Actualizamos La informacion del Reporte
                    bimestralU.setHoras(BigInteger.valueOf(reporte.getHoras()));
                    bimestralU.setCalificacion(BigInteger.valueOf(reporte.getCalificacion()));
                    reportesFacade.edit(bimestralU);


                    //while para eliminar actividades antiguass
                    List<BimestralesActividades> actividadesEliminar = actividadesBimestralesFacade.findBySpecificField("idReporte", bimestralU.getId(), "equal", null, null);
                    Iterator<BimestralesActividades> recorreActividades = actividadesEliminar.iterator();
                    while (recorreActividades.hasNext()) {
                        BimestralesActividades borraActividades;
                        borraActividades = recorreActividades.next();
                        actividadesBimestralesFacade.remove(borraActividades);
                    }
                    Iterator inserta = listaIds.iterator();
                    //while que inserta la lista de los perfiles para el proyecto
                    while (inserta.hasNext()) {
                        BimestralesActividades actividadesB = new BimestralesActividades();
                        actividadesB.setIdReporte(bimestralU);
                        List<Actividades> actividades = actividadesFacade.findBySpecificField("idActividad", inserta.next(), "equal", null, null);
                        actividadesB.setIdActividades(actividades.get(0));
                        actividadesBimestralesFacade.create(actividadesB);
                    }
                    System.out.println("Actualizo La Informacion Correctamente");
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
                    reportesFacade.create(reporteBimestral);

                    //Actualizamos las horas acumuladas en el formato Unico
                    FormatoUnico actualizaHoras = servicioBean.getFormatoUnico();
                    actualizaHoras.setHorasAcumuladas(BigInteger.valueOf(reporte.getHoras()).add(actualizaHoras.getHorasAcumuladas()));
                    formatoUnicoFacade.edit(actualizaHoras);
                    System.out.println("Primera Insercion");
                    //---------------------------------------------------------//
                    //Insertamos las actividades del reporte                   //
                    //---------------------------------------------------------//


                    //Buscamos el reporte recien insertado
                    //DatosPersonales dp = datosPersonales.get(0);
                    List<Reportes> bimestrales = reportesFacade.findBySpecificField("datosPersonalesId", servicioBean.getDatosPersonales().getId(), "equal", null, null);
                    Reportes bimestralInsertado = bimestrales.get(bimestrales.size() - 1);

                    Iterator inserta = listaIds.iterator();
                    //while que inserta la lista de los perfiles para el proyecto
                    while (inserta.hasNext()) {
                        BimestralesActividades actividadesB = new BimestralesActividades();
                        actividadesB.setIdReporte(bimestralInsertado);
                        List<Actividades> actividades = actividadesFacade.findBySpecificField("idActividad", inserta.next(), "equal", null, null);
                        actividadesB.setIdActividades(actividades.get(0));
                        actividadesBimestralesFacade.create(actividadesB);
                    }
                    System.out.println("Inserto Segundo Reporte Correctamente");

                    return "/ReporteBimestral/formatoReporteBimestral";

                }
                return "/ReporteBimestral/formatoReporteBimestral";
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
            reportesFacade.create(reporteBimestral);

            //Actualizamos las horas acumuladas en el formato Unico
            FormatoUnico actualizaHoras = servicioBean.getFormatoUnico();
            actualizaHoras.setHorasAcumuladas(BigInteger.valueOf(reporte.getHoras()).add(actualizaHoras.getHorasAcumuladas()));
            formatoUnicoFacade.edit(actualizaHoras);
            //---------------------------------------------------------//
            //Insertamos las actividades del reporte                   //
            //---------------------------------------------------------//


            //Buscamos el reporte recien insertado
            //DatosPersonales dp = datosPersonales.get(0);
            List<Reportes> bimestrales = reportesFacade.findBySpecificField("datosPersonalesId", servicioBean.getDatosPersonales().getId(), "equal", null, null);
            Reportes bimestralInsertado = bimestrales.get(bimestrales.size() - 1);

            Iterator inserta = listaIds.iterator();
            //while que inserta la lista de los perfiles para el proyecto
            while (inserta.hasNext()) {
                BimestralesActividades actividadesB = new BimestralesActividades();
                actividadesB.setIdReporte(bimestralInsertado);
                List<Actividades> actividades = actividadesFacade.findBySpecificField("idActividad", inserta.next(), "equal", null, null);
                actividadesB.setIdActividades(actividades.get(0));
                actividadesBimestralesFacade.create(actividadesB);
            }
            System.out.println("Inserto Por Primera Vez");

            return "/ReporteBimestral/formatoReporteBimestral";
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