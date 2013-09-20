/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.ValidaSesion;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ekt
 */
@Controller
public class PanelAdministradorController 
{
    @RequestMapping(method = RequestMethod.GET, value = "/panelAdministrador.do")
    public String panelAdministrador(Model model, HttpSession session, HttpServletRequest request) 
    {
        //Valida sesion
        ValidaSesion valSession = new ValidaSesion(session, request);
        if (valSession.accesaPanelAdministrador()) {
            return "/PanelAdministrador/panelAdministrador";
        }else{
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }      
        
        
        
    }
}
