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
 * @author Jonny
 */
@Controller
public class BecasController 
{
    @RequestMapping(method = RequestMethod.GET, value = "/preseleccionAlumnos.do")
    public String preseleccionAlumnos(Model a)
    {
        
        return "/Becas/preseleccionAlumnos";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/administracionAlumnosBecados.do")
    public String administracionAlumnosBecados(Model a)
    {
        
        return "/Becas/administracionAlumnosBecados";
    }
    
    
}
