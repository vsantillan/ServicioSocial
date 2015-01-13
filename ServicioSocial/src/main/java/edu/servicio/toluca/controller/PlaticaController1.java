/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.MetodosValidacion;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.dao.GenericDao;
import edu.servicio.toluca.entidades.LugaresPlatica;
import edu.servicio.toluca.sesion.LugaresPlaticaFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.ui.Model;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jesus
 */
@Controller
public class PlaticaController1 {

    
    private GenericDao<LugaresPlatica> daoLugaresPlatica;
    
    @Autowired
    public void setDaoLugaresPlatica(GenericDao<LugaresPlatica> daoLugaresPlatica)
    {
        this.daoLugaresPlatica = daoLugaresPlatica;
        daoLugaresPlatica.setClass(LugaresPlatica.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/altaLugares.do")
    public String obtieneLugares(Model modelo, HttpSession session, HttpServletRequest request) {
        if (new ValidaSesion().validaOperador(session, request)) {
            modelo.addAttribute("error", "<div class='alert alert-danger'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        LinkedHashMap ordenarDesc = new LinkedHashMap();
        ordenarDesc.put("lugar", "desc");
        modelo.addAttribute("lugar_i", new LugaresPlatica());
        modelo.addAttribute("lugares", daoLugaresPlatica.findBySpecificField("status", "1", "equal", ordenarDesc, null));
        return "/Platicas/lugaresPlatica";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/nuevoLugar.do")
    //public @ResponseBody
    String nuevoLugar(Model modelo, @ModelAttribute("LugaresPlatica") @Valid LugaresPlatica lugar_i, BindingResult resultado) {
        if (!resultado.hasErrors()) {
            lugar_i.setStatus(BigInteger.valueOf(1));
            lugar_i.setLugar(lugar_i.getLugar().toUpperCase());
            daoLugaresPlatica.create(lugar_i);
        } else {
            System.out.println("Result" + resultado);
            modelo.addAttribute("Lugar", lugar_i);
        }
        return "redirect:altaLugares.do";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/nuevoLugarAltaPlatica.do")
    //public @ResponseBody
    String nuevoLugarAltaPlatica(Model modelo, @ModelAttribute("LugaresPlatica") @Valid LugaresPlatica lugar_i, BindingResult resultado) {
        if (!resultado.hasErrors()) {
            lugar_i.setStatus(BigInteger.valueOf(1));
            lugar_i.setLugar(lugar_i.getLugar().toUpperCase());
            daoLugaresPlatica.create(lugar_i);
        } else {
            System.out.println("Result" + resultado);
            modelo.addAttribute("Lugar", lugar_i);
        }
        return "redirect:altaPlatica.do";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cambiaStatusLugar.do")
    public @ResponseBody
    String actualizarStatusLugares(int id, Model model) {
        LugaresPlatica lugar = (LugaresPlatica) daoLugaresPlatica.find(BigDecimal.valueOf(id));
        lugar.setStatus(BigInteger.valueOf(0));
        System.out.println("se edito: ");
        daoLugaresPlatica.edit(lugar);
        return "ok " + lugar.getLugar();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editarLugar.do")
    String editarLugar_r(Model model, @Valid LugaresPlatica lugar_i, BindingResult resultado, HttpSession session, HttpServletRequest request) {
        if (!resultado.hasErrors()) {
            MetodosValidacion metodo = new MetodosValidacion();
            LugaresPlatica lugar_r = (LugaresPlatica) daoLugaresPlatica.find(lugar_i.getId());
            lugar_r.setLugar(metodo.tuneaStringParaBD(lugar_i.getLugar()));
            if (lugar_r.getLugar().length() > 0) {
                daoLugaresPlatica.edit(lugar_r);
                return "redirect:altaLugares.do";
            } else {
                System.out.println("Result has error");
                model.addAttribute("errorBlanco", "<div class='alert alert-danger'>Error la descripción esta vacia</div>");
                LinkedHashMap ordenarDesc = new LinkedHashMap();
                ordenarDesc.put("lugar", "desc");
                model.addAttribute("lugar_i", new LugaresPlatica());
                model.addAttribute("lugares", daoLugaresPlatica.findBySpecificField("status", "1", "equal", ordenarDesc, null));
                return "/Platicas/lugaresPlatica";
            }
        } else {
            System.out.println("Result has error");
            model.addAttribute("errorBlanco", "<div class='alert alert-danger'>Error la descripción esta vacia</div>");
            LinkedHashMap ordenarDesc = new LinkedHashMap();
            ordenarDesc.put("lugar", "desc");
            model.addAttribute("lugar_i", new LugaresPlatica());
            model.addAttribute("lugares", daoLugaresPlatica.findBySpecificField("status", "1", "equal", ordenarDesc, null));
            return "/Platicas/lugaresPlatica";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/validaLugares.do")
    public @ResponseBody
    String validaLugares(String Lugar) {
        List<LugaresPlatica> lugarPlatica = daoLugaresPlatica.findBySpecificField("lugar", Lugar.toUpperCase(), "equal", null, null);
        return (!lugarPlatica.isEmpty())?"ESTA":"OK";
            
        
    }
}
