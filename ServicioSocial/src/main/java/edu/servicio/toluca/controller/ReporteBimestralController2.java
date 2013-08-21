/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.entidades.Reportes;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.ReportesFacade;
import java.math.BigDecimal;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        modelo.addAttribute("formatoUnico", formatoUnicoFacade.findAll());
        return "/ReporteBimestral/reporteBimestralAdministrador";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/detalleReporteBimestral.do")
    public String detalleReporteBimestral(int id,Model modelo) 
    {
        Reportes reporte=reportesFacade.find(BigDecimal.valueOf(id));
        modelo.addAttribute("reportes", reporte);
        return "/ReporteBimestral/detalleReporteBimestral";
    }
}
