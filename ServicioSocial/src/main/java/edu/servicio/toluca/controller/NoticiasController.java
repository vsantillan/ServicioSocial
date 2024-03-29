/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.dao.GenericDao;
import edu.servicio.toluca.entidades.Noticias;
import edu.servicio.toluca.model.noticias.ConsultasNoticias;
import java.util.Date;
import org.springframework.ui.Model;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jesus
 */
@Controller
public class NoticiasController
{

    private GenericDao<Noticias> daoNoticias;

    @Autowired
    public void setDaoNoticias(GenericDao<Noticias> daoNoticias)
    {
        this.daoNoticias = daoNoticias;
        daoNoticias.setClass(Noticias.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/noticia.do")
    public String obtenerNoticiaGeneral(Model modelo, int id)
    {
        ConsultasNoticias noticias = new ConsultasNoticias(daoNoticias);
        Noticias not = noticias.consultaNoticiaPrincipal(id);
        if (not != null)
        {
            modelo.addAttribute("noticia", not);
            return "/Noticias/noticiaUnica";
        } else
        {
            return "redirect:index.do";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/altaNoticia.do")
    public String altaNoticia(Model modelo, boolean editar)
    {
        modelo.addAttribute("Noticias", new Noticias());
        return "/Noticias/altaNoticia";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/altaNoticia.do")
    public String altaNoticiaPOST(@ModelAttribute("Noticias") @Valid Noticias noticia, BindingResult result, Model modelo)
    {
        if (result.hasErrors())
        {
            modelo.addAttribute("Noticias", noticia);
            return "/Noticias/altaNoticia";
        }
        noticia.setId(null);
        noticia.setFecha(new Date());
        ConsultasNoticias noticias = new ConsultasNoticias(daoNoticias);
        if (noticias.nuevaNoticia(noticia))
        {
            modelo.addAttribute("Noticias", new Noticias());
            return "redirect:consultaNoticias.do";
        } else
        {
            return "404";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "editarNoticia-{id}.do")
    public String editarNoticia(Model modelo, @PathVariable int id)
    {
        ConsultasNoticias noticiasModel = new ConsultasNoticias(daoNoticias);
        Noticias noticia = noticiasModel.obtenerNoticia(id);

        if (noticia != null)
        {
            //System.out.println(noticia.getDetalle());
            modelo.addAttribute("id", id);
            modelo.addAttribute("Noticias", noticia);
            return "/Noticias/editarNoticia";
        }
        return "404";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/editarNoticia-{id2}.do")
    public String editarNoticiaPOST(@PathVariable int id2, @ModelAttribute("Noticias") @Valid Noticias noticia, BindingResult result, Model modelo)
    {
        if (result.hasErrors())
        {
            modelo.addAttribute("id", id2);
            modelo.addAttribute("Noticias", noticia);
            return "/Noticias/editarNoticia";
        }

        ConsultasNoticias noticias = new ConsultasNoticias(daoNoticias);
        if (noticias.editarNoticia(noticia))
        {
            return "redirect:consultaNoticias.do";
        } else
        {
            return "404";
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/consultaNoticias.do")
    public String listadoNoticias(Model modelo)
    {
        ConsultasNoticias noticias = new ConsultasNoticias(daoNoticias);
        modelo.addAttribute("Noticias", noticias.listadoNoticias());
        return "/Noticias/consultaNoticias";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/eliminarNoticia.do")
    public @ResponseBody
    String eliminarNoticia(int id, Model modelo)
    {
        ConsultasNoticias noticias = new ConsultasNoticias(daoNoticias);
        Noticias noticia = noticias.obtenerNoticia(id);
        noticias.eliminarNoticia(noticia);
        return "ok ";
    }
}
