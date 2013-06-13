/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;
import edu.servicio.toluca.beans.Fecha;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author mary
 */
@Controller
public class LiberacionesController {
    
      @RequestMapping(method = RequestMethod.GET, value = "/liberaciones.do")
    public String altaPlatica(Model modelo) {
    
        return "/Liberaciones/liberacionesAdministrador";
    }
}
