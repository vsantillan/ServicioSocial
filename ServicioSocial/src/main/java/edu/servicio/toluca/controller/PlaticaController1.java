/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.MetodosValidacion;
import edu.servicio.toluca.beans.ValidaSesion;
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
    public String obtieneLugares(Model modelo , HttpSession session, HttpServletRequest request)
    { 
        if (! new ValidaSesion().validaOperador(session, request)) {
            modelo.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
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
    String editarLugar_r(Model model, @Valid LugaresPlatica lugar_i,BindingResult resultado, HttpSession session, HttpServletRequest request) {
        if (!resultado.hasErrors()) {
            MetodosValidacion metodo = new MetodosValidacion();
            LugaresPlatica lugar_r = LugaresPlaticaFacade.find(lugar_i.getId());
            
            lugar_r.setLugar(metodo.tuneaStringParaBD(lugar_i.getLugar()));
            if(lugar_r.getLugar().length()>0){
                LugaresPlaticaFacade.edit(lugar_r);
                return "redirect:altaLugares.do";
            } else{
                System.out.println("Result has error");
                model.addAttribute("errorBlanco", "<div class='error'>Error la descripción esta vacia</div>");
                LinkedHashMap ordenarDesc = new LinkedHashMap();
                ordenarDesc.put("lugar","desc");        
                model.addAttribute("lugar_i", new LugaresPlatica());
                model.addAttribute("lugares", LugaresPlaticaFacade.findBySpecificField("status", "1", "equal", ordenarDesc, null));
                return "/Platicas/lugaresPlatica";
            }
        } else{
            System.out.println("Result has error");
            model.addAttribute("errorBlanco", "<div class='error'>Error la descripción esta vacia</div>");
            LinkedHashMap ordenarDesc = new LinkedHashMap();
            ordenarDesc.put("lugar","desc");        
            model.addAttribute("lugar_i", new LugaresPlatica());
            model.addAttribute("lugares", LugaresPlaticaFacade.findBySpecificField("status", "1", "equal", ordenarDesc, null));
            return "/Platicas/lugaresPlatica";
        }
    }

}
