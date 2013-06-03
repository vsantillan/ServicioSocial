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
 * @author ekt
 */
@Controller
public class PanelAdministradorController 
{
    @RequestMapping(method = RequestMethod.GET, value = "/panelAdministrador.do")
    public String panelAdministrador(Model a) 
    {
        return "/panelAdministrador/panelAdministrador";
    }
}
