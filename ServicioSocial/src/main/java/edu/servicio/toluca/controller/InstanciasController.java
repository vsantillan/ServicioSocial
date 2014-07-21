/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.servicio.toluca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author giovanni
 */
@Controller
public class InstanciasController
{
    
    @RequestMapping( value="preregistrarinstancia.do", method=RequestMethod.GET)
    public String preregistro(Model model)
    {
        return "/Instancias/preregistro";
    }
    
}
