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
 * @author WindSaber
 */
@Controller
public class FormatoUnicoController {
    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoUsuario.do")
    public String formatoUnico(Model a) {
        return "/FormatoUnico/formatoUnicoUsuario";
    }
   
   
}
