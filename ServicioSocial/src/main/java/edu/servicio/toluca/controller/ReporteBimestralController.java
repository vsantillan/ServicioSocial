/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.bimestrales.fechas;
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
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String reporteBimestralUsuario(Model modelo) throws ParseException {
        String alumno_id = "09280437";
        ///////////BUSCAR ALUMNO///////////
        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", alumno_id, "equal", null, null);
        VistaAlumno alumno = listaAlumnos.get(0);
        List<DatosPersonales> datosPersonales = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
        DatosPersonales DP = datosPersonales.get(0);
        modelo.addAttribute("datosPersonales", datosPersonales);
       
        /////////////Validamos si es su primer reporte//////////////
            List<Reportes> RB = reportesFacade.findBySpecificField("datosPersonalesId", DP.getId(), "equal", null, null);
            if (RB.isEmpty()) {
                List<FormatoUnico> formatoUnico =formatoUnicoFacade.findBySpecificField("datosPersonalesId", DP.getId(), "equal", null, null);
                FormatoUnico fechaInicioFU=formatoUnico.get(0);
                fechas fechaFin =new  fechas(fechaInicioFU.getFechaInicio());
               System.out.println("Resultado del metodo"+fechaFin.dameFecha());
                modelo.addAttribute("fechaInicio", fechaInicioFU.getFechaInicio());
                modelo.addAttribute("fechaFin",fechaFin.dameFecha());
            }else{
                modelo.addAttribute("fechaInicio", "");
                modelo.addAttribute("fechaFin","");
            }       
        //////////////////////////////////////////////////////////////

        return "/ReporteBimestral/formatoReporteBimestral";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/retroalimentacionReportesBimestrales.do")
    public String retroalimentacionBimestralUsuario(Model a) {

        return "/ReporteBimestral/retroalimentacionReportesBimestrales";
    }
    
        @RequestMapping(method = RequestMethod.POST, value = "/insertaReporte.do")
    public @ResponseBody
    String insertaBimestral(@Valid Reportes reporte, BindingResult resultado, Model modelo) {

        return "ok";
    }
}
