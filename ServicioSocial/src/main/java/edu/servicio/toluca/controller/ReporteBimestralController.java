/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.bimestrales.fechas;
import edu.servicio.toluca.beans.bimestrales.reporteBimestral;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.entidades.Reportes;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.ReportesFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

//    @RequestMapping(method = RequestMethod.GET, value = "/reporteBimestralAdministrador.do")
//    public String reporteBimestralAdministrador(Model modelo) {
//        return "/ReporteBimestral/reporteBimestralAdministrador";
//    }
    @RequestMapping(method = RequestMethod.GET, value = "/formatoReporteBimestral.do")
    public String reporteBimestralUsuario(Model modelo, String alumno_id) throws ParseException {
        reporteBimestral RBObjeto = new reporteBimestral();
        alumno_id = "09280531";
        ///////////BUSCAR ALUMNO///////////
        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", alumno_id, "equal", null, null);
        VistaAlumno alumno = listaAlumnos.get(0);
        List<DatosPersonales> datosPersonales = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
        if (!datosPersonales.isEmpty()) {
            DatosPersonales DP = datosPersonales.get(0);
            modelo.addAttribute("datosPersonales", datosPersonales);

            /////////////Validamos si es su primer reporte//////////////
            List<Reportes> RB = reportesFacade.findBySpecificField("datosPersonalesId", DP.getId(), "equal", null, null);
            if (RB.isEmpty()) {
                List<FormatoUnico> formatoUnico = formatoUnicoFacade.findBySpecificField("datosPersonalesId", DP.getId(), "equal", null, null);
                FormatoUnico fechaInicioFU = formatoUnico.get(0);
                modelo.addAttribute("numeroReporte", 1);
                fechas fechas = new fechas();
                //modelo.addAttribute("horasAcumuladas", fechaInicioFU.getHorasAcumuladas());
                //modelo.addAttribute("fechaInicio", fechaInicioFU.getFechaInicio());
                //modelo.addAttribute("fechaFin", fechas.dameFecha(fechaInicioFU.getFechaInicio()));
                RBObjeto.setFechaInicio(fechas.convierteDate(fechaInicioFU.getFechaInicio()));
                RBObjeto.setFechaFin(fechas.dameFecha(fechaInicioFU.getFechaInicio()));
                RBObjeto.setHorasAcumuladas(fechaInicioFU.getHorasAcumuladas());
                RBObjeto.setHoras(10);

                modelo.addAttribute("Reportes", RBObjeto);
            } else {
                int noReportes = 0;
                for (int i = 0; i < RB.size(); i++) {
                    Reportes reporteBimestral = RB.get(i);
                    if (reporteBimestral.getStatus() == BigInteger.valueOf(1)) {//Checar cual el es el status de formato aprobado
                        noReportes++;
                    }

                }

                modelo.addAttribute("numeroReporte", noReportes);
                modelo.addAttribute("fechaInicio", "");
                modelo.addAttribute("fechaFin", "");
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
    public String insertaBimestral(@ModelAttribute("Reportes") @Valid reporteBimestral reporte, BindingResult resultado, Model modelo, String selectfrom) {
        String alumno_id = "09280531";
        if (selectfrom != null) {
            List<String> listaIds = new ArrayList<String>();
            StringTokenizer palabra = new StringTokenizer(selectfrom, ",");
            while (palabra.hasMoreTokens()) {
                listaIds.add(palabra.nextToken());
                //System.out.println("Actividad"+palabra.nextToken());
            }
            System.out.println("tamaño de la lista:" + listaIds.size());
            if (listaIds.size() <= 1) {
                modelo.addAttribute("errorActividades", "<div class='error'>Seleccione como minimo 2 Actividades</div>");
                modelo.addAttribute("Reportes", reporte);
                List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", alumno_id, "equal", null, null);
                VistaAlumno alumno = listaAlumnos.get(0);
                List<DatosPersonales> datosPersonales = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
                if (!datosPersonales.isEmpty()) {
                    DatosPersonales DP = datosPersonales.get(0);
                    modelo.addAttribute("datosPersonales", datosPersonales);
                }
                    System.out.println("Fecha Inicio:" + reporte.getFechaInicio());
                    System.out.println("Fecha Fin: " + reporte.getFechaFin());
                    System.out.println("Horas del Reporte:" + reporte.getHoras());
                    return "/ReporteBimestral/formatoReporteBimestral";
                }
            }
            if (resultado.hasErrors()) {
                modelo.addAttribute("Reportes", reporte);
                System.out.println("Hubo errores" + resultado.toString());
                return "redirect:formatoReporteBimestral.do?alumno_id=09280531";
            } else {
                modelo.addAttribute("Reportes", reporte);
                return "redirect:formatoReporteBimestral.do?alumno_id=09280531";
            }

        }
    }
