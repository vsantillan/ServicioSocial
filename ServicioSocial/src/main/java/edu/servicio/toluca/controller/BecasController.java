/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.Becado;
import edu.servicio.toluca.beans.Fecha;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.text.ParseException;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
     
      @ModelAttribute("alumnoP")
    public Becado prueba() {
         return new Becado(); // creamos el bean para que se pueda popular
    }

    @RequestMapping(method = RequestMethod.GET, value = "/preseleccionAlumnos.do")
    public String preseleccionAlumnos(Model model) {
        Fecha fecha= new Fecha ();
        model.addAttribute("alumno",formatoUnico.findAll());    
        return "/Becas/preseleccionAlumnos";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/administracionAlumnosBecados.do")
    public String administracionAlumnosBecados(Model model) {
        FormatoUnico form = new FormatoUnico();
        //form.setTipoServicio(6);
        //formatoUnico.edit(form);
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
    
     @RequestMapping(method = RequestMethod.GET, value = "/excel.do")
     public String generaExcel(Model model) {
        return "/Becas/excel";
    }
     
@RequestMapping(method = RequestMethod.POST, value = "/preseleccionadoBD.do")
    public String updateBecados(Becado alumnoP) {

       System.out.print(alumnoP);
        
        return "/Becas/admistracionAlumnosBecados";
    }

    
}
