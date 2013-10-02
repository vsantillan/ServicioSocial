/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.MetodosValidacion;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.entidades.LugaresPlatica;
import edu.servicio.toluca.entidades.Noticias;
import edu.servicio.toluca.sesion.LugaresPlaticaFacade;
import edu.servicio.toluca.sesion.NoticiasFacade;
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
public class NoticiasController {
    @EJB(mappedName = "java:global/ServicioSocial/LugaresPlaticaFacade")
    private NoticiasFacade NoticiasFacade;
    
    @RequestMapping(method = RequestMethod.GET, value = "/catalogoNoticias.do")
    public String obtieneNoticias(Model modelo , HttpSession session, HttpServletRequest request)
    { 
        LinkedHashMap ordenarDesc = new LinkedHashMap();
        ordenarDesc.put("lugar","desc");        
        modelo.addAttribute("noticia_n", new Noticias());
        modelo.addAttribute("noticias", NoticiasFacade.findAll());
        return "/Platicas/lugaresPlatica";
    }
}
