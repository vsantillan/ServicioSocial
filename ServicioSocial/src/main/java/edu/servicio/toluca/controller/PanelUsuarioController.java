/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.model.ValidaSesion;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author roy
 */
@Controller
public class PanelUsuarioController {
    @RequestMapping(method = RequestMethod.GET, value = "/panelUsuario.do")
    public String formatoUnico(Model model, HttpSession session, HttpServletRequest request) {
        if(new ValidaSesion().validaAdmin(session, request)){
            return "/PanelUsuario/panelUsuario";
        }else{
            model.addAttribute("error", "<div class='error'>Debes iniciar sesió para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        
    }
    
}
