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
 * @author Héctor
 */
@Controller
public class Controladores {
    
     @RequestMapping(method = RequestMethod.GET, value = "/formulario.do")
    public String prueba2(Model a) {
        return "formulario";
    }
}
