/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.entidades.LugaresPlatica;
import edu.servicio.toluca.sesion.LugaresPlaticaFacade;
import java.util.LinkedHashMap;
import org.springframework.ui.Model;
import javax.ejb.EJB;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jesus
 */
@Controller
public class PlaticaController1 {
    @EJB(mappedName = "java:global/ServicioSocial/LugaresPlaticaFacade")
    private LugaresPlaticaFacade LugaresPlaticaFacade;
    
    @RequestMapping(method = RequestMethod.GET, value = "/altaLugares1.do")
    public String obtieneLugares(Model modelo)
    {
        LinkedHashMap ordenarDesc = new LinkedHashMap();
        ordenarDesc.put("lugar","desc");
        modelo.addAttribute("lugares", LugaresPlaticaFacade.findBySpecificField("status", "1", "equal", ordenarDesc, null));
        return "/Platicas/lugaresPlatica";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/altaLugarBD.do")
    public String altaLugaresBD(@Valid LugaresPlatica lugares, BindingResult result, Model modelo) {
        if (result.hasErrors()) {
            return "/Platicas/lugaresPlatica";
        } else {
            LugaresPlaticaFacade.create(lugares);
            modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
            return "/Platicas/lugaresPlatica";
        }
    }
}