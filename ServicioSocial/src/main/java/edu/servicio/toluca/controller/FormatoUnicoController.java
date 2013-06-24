/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;
import edu.servicio.toluca.beans.FormatoUnicoDatosPersoValidaciones;
import edu.servicio.toluca.beans.FormatoUnicoDatosPersonalesBean;
import edu.servicio.toluca.beans.FormatoUnicoErrores;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author WindSaber
 */
@Controller
public class FormatoUnicoController {
    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoUsuario.do")
    public String formatoUnico(Model modelo) {
        modelo.addAttribute("formatoUnicoDatosPersonales", new FormatoUnicoDatosPersonalesBean());
        return "/FormatoUnico/formatoUnicoUsuario";
    }
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new FormatoUnicoDatosPersoValidaciones()); // registramos el validador
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/modificarFormato.do")
    public @ResponseBody FormatoUnicoErrores modificarDatosPersonalesAlumno( @Valid FormatoUnicoDatosPersonalesBean dt,BindingResult resultado){
        System.out.println(dt.getSexo());
        
        if (resultado.hasErrors())
        {
            for(FieldError error: resultado.getFieldErrors())
            {
                System.out.println(error.getRejectedValue());
            }
            System.out.println("Entro");
        }
        
        return new FormatoUnicoErrores();
    }
    
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoUsuarioObservaciones.do")
    public String formatoUnicoObservaciones(Model a) {
        
        return "/FormatoUnico/formatoUnicoUsuarioObservaciones";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoAdministrador.do")
    public String formatoUnicoAdministrador(Model a) {
        
        return "/FormatoUnico/formatoUnicoAdministrador";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/pruebaDT.do")
    public String formatoUnicoPruebaDT(Model a) {
        
        return "/FormatoUnico/pruebaDT";
    }
   
}
