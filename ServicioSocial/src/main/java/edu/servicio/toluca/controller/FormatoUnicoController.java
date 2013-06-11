/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;
import edu.servicio.toluca.beans.FormatoUnicoBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author WindSaber
 */
@Controller
public class FormatoUnicoController {
    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoUsuario.do")
    public String formatoUnico(Model a) {
        a.addAttribute("datos", new FormatoUnicoBean());
        return "/FormatoUnico/formatoUnicoUsuario";
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
