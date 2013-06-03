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
public class PlaticaController {
    @RequestMapping(method = RequestMethod.GET, value = "/altaPlatica.do")
    public String altaPlatica(Model a) {
        return "/Platicas/altaPlatica";
    }

   
}
