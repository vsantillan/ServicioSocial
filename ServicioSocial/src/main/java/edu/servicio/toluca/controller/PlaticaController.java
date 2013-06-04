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

   @RequestMapping(method = RequestMethod.GET, value = "/consultasBajas.do")
    public String consultasBajas(Model a) {
        return "/Platicas/consultasBajas";
    }
   
    @RequestMapping(method = RequestMethod.GET, value = "/capturarAsistencia.do")
    public String capturarAsistencia(Model a) {
        return "/Platicas/capturarAsistencia";
    }
    
     @RequestMapping(method = RequestMethod.GET, value = "/asistenciaPosteriorEspecial.do")
    public String AsistenciaPosteriorEspecial(Model a) {
        return "/Platicas/asistenciaPosteriorEspecial";
    }
}
