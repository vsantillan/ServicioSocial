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
    String nuevoLugar(Model modelo,@Valid LugaresPlatica lugar_i,BindingResult resultado) {
        if (!resultado.hasErrors()) {
            System.out.println("Result has no error");
            MetodosValidacion metodo = new MetodosValidacion();
            lugar_i.setStatus(BigInteger.valueOf(1));
//            lugar_i.setLugar(metodo.tuneaStringParaBD(lugar_i.getLugar()));
            LugaresPlaticaFacade.create(lugar_i);
            return "redirect:altaLugares.do";
        } else{
            System.out.println("Result has error");
            modelo.addAttribute("errorBlanco", "<div class='error'>Error la descripcion esta vacia</div>");
            LinkedHashMap ordenarDesc = new LinkedHashMap();
            ordenarDesc.put("lugar","desc");        
            modelo.addAttribute("lugar_i", new LugaresPlatica());
            modelo.addAttribute("lugares", LugaresPlaticaFacade.findBySpecificField("status", "1", "equal", ordenarDesc, null));
            return "/Platicas/lugaresPlatica";
        }
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
    String editarLugar_r(LugaresPlatica lugar_i,String lugar,int id, Model model) {
        MetodosValidacion metodo = new MetodosValidacion();
        LugaresPlatica lugar_r = LugaresPlaticaFacade.find(BigDecimal.valueOf(id));
        lugar_r.setLugar(metodo.tuneaStringParaBD(lugar));
        LugaresPlaticaFacade.edit(lugar_r);
        return "redirect:altaLugares.do";
    }

}
