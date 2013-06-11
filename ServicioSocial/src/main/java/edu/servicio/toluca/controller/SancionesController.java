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
    public String sancionesAlumno(Model modelo)
    {
        return "/Sanciones/sancionesAlumno";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/pagoSancionAlumno.do")
    public String pagoSancionAlumno(Model modelo)
    {
        System.out.println("Si pasaaaa");
        
        return "/Sanciones/pagoSancionAlumno";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/detalleSancionAlumno.do")
    public String detalleSancionAlumno(Model a)
    {
        return "/Sanciones/detalleSancionAlumno";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/catalogoSanciones.do")
    public String catalogoSanciones(Model a)
    {
        return "/Sanciones/catalogoSanciones";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/editaSancion.do")
    public String editaSancion(Model a)
    {
        return "/Sanciones/editaSancion";
    }
}
