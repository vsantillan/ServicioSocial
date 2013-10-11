/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jonny
 */
public class ReporteFinal {
    @RequestMapping(method = RequestMethod.GET, value = "/reporteFinal")
    public String reporteFinal(Model modelo) {

        return "ReporteFinal/reporteFinal";
    }
    
}
