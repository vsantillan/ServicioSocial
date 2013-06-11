/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

/**
 *
 * @author bustedvillain
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavegacionPrincipalController {
    
    @RequestMapping(method = RequestMethod.GET, value = "/index.do")
    public String index(Model a){
        return "/NavegacionPrincipal/index";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/convocatorias.do")
    public String convocatorias(Model a){
        return "/NavegacionPrincipal/convocatorias";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/manualProcedimiento.do")
    public String manualProcedimiento(Model a){
        return "/NavegacionPrincipal/manualProcedimiento";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/organizaciones.do")
    public String organizaciones(Model a){
        return "/NavegacionPrincipal/organizaciones";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/loginOrganizaciones.do")
    public String loginOrganizaciones(Model a){
        return "/NavegacionPrincipal/loginOrganizaciones";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/registroOrganizaciones.do")
    public String registroOrganizaciones(Model a){
        return "/Organizaciones/registroOrganizaciones";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/login.do")
    public String loginAlumnos(Model a){
        return "/NavegacionPrincipal/loginPrincipal";
    }
}
