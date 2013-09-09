/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.MetodosValidacion;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.LugaresPlatica;
import edu.servicio.toluca.sesion.LugaresPlaticaFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import org.springframework.ui.Model;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    
    @RequestMapping(method = RequestMethod.GET, value = "/altaLugares.do")
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
        MetodosValidacion metodo = new MetodosValidacion();
        lugar_i.setStatus(BigInteger.valueOf(1));
        //lugar.setLugar(lugar);
        lugar_i.setLugar(metodo.tuneaStringParaBD(lugar_i.getLugar()));
        LugaresPlaticaFacade.create(lugar_i);
        //System.out.println("Inserto Lugar");
        return "redirect:altaLugares.do";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cambiaStatusLugar.do")
    public @ResponseBody
    String actualizarStatusOrganizaciones(int id, Model model) {
    
        LugaresPlatica lugar = LugaresPlaticaFacade.find(BigDecimal.valueOf(id));
        lugar.setStatus(BigInteger.valueOf(0));
        LugaresPlaticaFacade.edit(lugar);
        
        return "ok";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/editarLugar.do")
    public @ResponseBody
    String editarLugar_r(LugaresPlatica lugar_i,String lugar_s, Model model) {
        return "redirect:altaLugares.do";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editarLugar1.do")
    public @ResponseBody
    String editarLugar(String lugar_s, int id, Model model) {
        MetodosValidacion metodo = new MetodosValidacion();
        LugaresPlatica lugar = LugaresPlaticaFacade.find(BigDecimal.valueOf(id));
        lugar.setLugar(metodo.tuneaStringParaBD(lugar_s));
        LugaresPlaticaFacade.edit(lugar);
        return "ok";
    }
}
