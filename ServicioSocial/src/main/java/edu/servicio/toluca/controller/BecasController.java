/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jonny
 */
@Controller
public class BecasController {

     @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
     private VistaAlumnoFacade vistaAlumno;
     
     @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
     private FormatoUnicoFacade formatoUnico;

    @RequestMapping(method = RequestMethod.GET, value = "/preseleccionAlumnos.do")
    public String preseleccionAlumnos(Model model) {

        model.addAttribute("alumno",formatoUnico.findAll());    
        return "/Becas/preseleccionAlumnos";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/administracionAlumnosBecados.do")
    public String administracionAlumnosBecados(Model model) {

        return "/Becas/administracionAlumnosBecados";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reporteMensualAdministrador.do")
    public String reporteMensualAdministrador(Model model) {

        return "/Becas/reporteMensualAdministrador";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/correo.do")
    public String correo(Model model) {

        return "/Becas/correo";
    }
}
