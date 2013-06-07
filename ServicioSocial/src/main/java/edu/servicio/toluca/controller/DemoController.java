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
 * @author bustedvillain
 */
@Controller
public class DemoController {

    @RequestMapping(method = RequestMethod.GET, value = "/demoAdministrador.do")
    public String demoAdministrador(Model a) {

        return "/Plantillas/demoAdministrador";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/demoUsuario.do")
    public String demoUsuario(Model a) {

        return "/Plantillas/demoUsuario";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/demoOrganizacion.do")
    public String demoOrganizacion(Model a) {

        return "/Plantillas/demoOrganizacion";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/demoFormulario.do")
    public String demoFormulario(Model a) {
        return "/Plantillas/demoFormulario";
    }
}
