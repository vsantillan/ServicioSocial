/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.MetodosValidacion;
import edu.servicio.toluca.beans.NuevaObservacion;
import edu.servicio.toluca.beans.ObservacionesBean;
import edu.servicio.toluca.entidades.CatalogoObservaciones;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.servicio.toluca.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rodrigo
 */
@Controller
public class ObservacionesController {
    
    private GenericDao<CatalogoObservaciones> daoCatalogoObservaciones;
    
     @Autowired
        public void setCatalogoObservaciones(GenericDao<CatalogoObservaciones> daoCatalogoObservaciones)
    {
        this.daoCatalogoObservaciones = daoCatalogoObservaciones;
        daoCatalogoObservaciones.setClass(CatalogoObservaciones.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/catalogoObservaciones.do")
    public String catalogoObservaciones(Model modelo) {
        ObservacionesBean consultas = new ObservacionesBean(daoCatalogoObservaciones);
        modelo.addAttribute("Observacion", new CatalogoObservaciones());
        modelo.addAttribute("Observaciones", consultas.ConsultaTodas());
        return "/Observaciones/catalogoObservaciones";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/nuevaObservacion.do")
    public String nuevaObservacion(@Valid CatalogoObservaciones Observacion, BindingResult resultado, Model modelo) {
        if (!resultado.hasErrors()) {
            Observacion.setId(null);
            MetodosValidacion cleaner = new MetodosValidacion();
            Observacion.setDetalle(cleaner.tuneaStringParaBD(Observacion.getDetalle()));
            daoCatalogoObservaciones.create(Observacion);
            modelo.addAttribute("Observaciones", daoCatalogoObservaciones.findAll());
            modelo.addAttribute("Observacion", new CatalogoObservaciones());
            return "/Observaciones/catalogoObservaciones";
        } else {
            modelo.addAttribute("Observaciones", daoCatalogoObservaciones.findAll());
            modelo.addAttribute("Observacion", Observacion);
            modelo.addAttribute("errorBlanco", "<div class=\"alert alert-danger\">Error la descripcion esta vacia</div>");
            return "/Observaciones/catalogoObservaciones";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteObservacion.do")
    public @ResponseBody
    String eliminaObservacion(int id, Model model) {
        CatalogoObservaciones catalogo;
        catalogo = (CatalogoObservaciones) daoCatalogoObservaciones.find(BigDecimal.valueOf(id));
        catalogo.setTipo(BigInteger.ZERO);
        daoCatalogoObservaciones.edit(catalogo);
        //catalogo.setValidacionAdmin(BigInteger.valueOf(1));
        System.out.println("Ya actualizo");
        // instanciaFacade.edit(instancia);

        return "ok";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/actualizaObservacion.do")
    public @ResponseBody
    String actualizaObservacion(Model modelo, NuevaObservacion Observacion) {
        CatalogoObservaciones catalogo;
        catalogo = (CatalogoObservaciones) daoCatalogoObservaciones.find(BigDecimal.valueOf(Observacion.getId()));
        catalogo.setDetalle(Observacion.getDetalle());
        catalogo.setTipo(BigInteger.valueOf(Observacion.getTipo()));
        daoCatalogoObservaciones.edit(catalogo);
        return "<script>"
                + "alert('¡Observacion Actualizada  Correctamente!');"
                + "location.href='catalogoObservaciones.do';"
                + "</script>";

    }
}
