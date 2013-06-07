/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author roy
 */
@Controller
public class ReporteBimestralController {
    
     @RequestMapping(method = RequestMethod.GET, value = "/reporteBimestralAdministrador.do")
    public String reporteBimestralAdministrador(Model a)
    {
        
        return "/ReporteBimestral/reporteBimestralAdministrador";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/formatoReporteBimestral.do")
    public String reporteBimestralUsuario(Model a)
    {
        
        return "/ReporteBimestral/formatoReporteBimestral";
    }
    
}
