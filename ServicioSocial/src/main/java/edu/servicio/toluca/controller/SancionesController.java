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
 * @author Regules
 */
@Controller
public class SancionesController 
{
    @RequestMapping(method = RequestMethod.GET, value = "/sancionesAlumno.do")
    public String sancionesAlumno(Model a)
    {
        return "/Sanciones/sancionesAlumno";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/pagoSancionAlumno.do")
    public String pagoSancionAlumno(Model a)
    {
        return "/Sanciones/pagoSancionAlumno";
    }
}
