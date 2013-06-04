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
public class OrganizacionesController {
    @RequestMapping(method = RequestMethod.GET, value = "/administrarOrganizaciones.do")
    public String panelAdministrador(Model a){
        return "/Organizaciones/administrarOrganizaciones";
    }
    
}
