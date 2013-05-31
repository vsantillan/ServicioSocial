/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.serviciosocial.controller;

import edu.servicio.toluca.serviciosocial.beans.Calculo;
import edu.servicio.toluca.serviciosocial.beans.Datos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Héctor
 */
@Controller
public class Prueba {

    @RequestMapping(method = RequestMethod.POST, value = "/login.do")
    public String prueba(Datos datos, Model a) {

        a.addAttribute("correo", datos.getCorreo());
        a.addAttribute("pass", datos.getPass());
        return "paginaPrueba";
    }

   @RequestMapping(method = RequestMethod.GET, value = "/formulario.do")
    public String prueba2(Model a) {

        a.addAttribute("datos", new Datos());
        return "formulario";
    }
}
