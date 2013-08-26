/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.NuevoLugar;
import edu.servicio.toluca.entidades.LugaresPlatica;
import edu.servicio.toluca.sesion.LugaresPlaticaFacade;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import org.springframework.ui.Model;
import javax.ejb.EJB;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        modelo.addAttribute("lugar_i", new LugaresPlatica());
        modelo.addAttribute("lugares", LugaresPlaticaFacade.findBySpecificField("status", "1", "equal", ordenarDesc, null));
        return "/Platicas/lugaresPlatica";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/nuevoLugar.do")
    String nuevoLugar(Model modelo, LugaresPlatica lugar_i) {
        lugar_i.setStatus(BigInteger.valueOf(1));
        //lugar.setLugar(lugar);
        LugaresPlaticaFacade.create(lugar_i);
        System.out.println("Inserto Lugar");
        LinkedHashMap ordenarDesc = new LinkedHashMap();
        ordenarDesc.put("lugar","desc");        
        modelo.addAttribute("lugar_i", new LugaresPlatica());
        modelo.addAttribute("lugares", LugaresPlaticaFacade.findBySpecificField("status", "1", "equal", ordenarDesc, null));
        return "/Platicas/lugaresPlatica";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editarLugar.do")
    String editarLugar(Model modelo, LugaresPlatica lugar_i) {
        
        return "/Platicas/lugaresPlatica";
    }
}
