/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.bimestrales.RetroalimentacionReporte;
import edu.servicio.toluca.beans.organizaciones.BorrarProyecto;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.entidades.Reportes;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.ReportesFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * @author ekt
 */
@Controller
public class ReporteBimestralController2 
{
    @EJB(mappedName = "java:global/ServicioSocial/DatosPersonalesFacade")
    private DatosPersonalesFacade datosPersonalesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/ReportesFacade")
    private ReportesFacade reportesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
    private FormatoUnicoFacade formatoUnicoFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/reporteBimestralAdministrador.do")
    public String reporteBimestralAdministrador(Model modelo) 
    {
        modelo.addAttribute("datosPersonales", datosPersonalesFacade.findAll());
        modelo.addAttribute("reportes", reportesFacade.findAll());
        modelo.addAttribute("retroalimentacionReporte", new RetroalimentacionReporte());
        return "/ReporteBimestral/reporteBimestralAdministrador";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/detalleReporteBimestral.do")
    public String detalleReporteBimestral(int id,Model modelo) 
    {
        Reportes reporte=reportesFacade.find(BigDecimal.valueOf(id));
        modelo.addAttribute("reportes", reporte);
        return "/ReporteBimestral/detalleReporteBimestral";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/actualizarStatusReporte.do")
    public @ResponseBody
    String aceptarRactualizarStatusReporteporte(RetroalimentacionReporte retroalimentacionReporte,Model model, HttpSession session, HttpServletRequest request) {
        Reportes reporte;
        //reporte=reportesFacade.find(BigDecimal.valueOf(id));
        //reporte.setStatus(BigInteger);
        //reportesFacade.edit(reporte);
        System.out.println("Reporte Alterado con Status a: "+retroalimentacionReporte.getStatus());
        return "ok";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/aceptarReporte.do")
    public @ResponseBody
    String aceptarReporte(int id,int status,Model model, HttpSession session, HttpServletRequest request) {
        Reportes reporte;
        //reporte=reportesFacade.find(BigDecimal.valueOf(id));
        //reporte.setStatus(BigInteger);
        //reportesFacade.edit(reporte);
        System.out.println("Reporte Alterado con Status a: "+status);
        return "ok";
    }
    
    
}
