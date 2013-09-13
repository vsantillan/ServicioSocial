/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.MetodosValidacion;
import edu.servicio.toluca.beans.NuevaObservacion;
import edu.servicio.toluca.entidades.CatalogoObservaciones;
import edu.servicio.toluca.sesion.CatalogoObservacionesFacade;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rodrigo
 */
@Controller
public class ObservacionesController {

    @EJB(mappedName = "java:global/ServicioSocial/CatalogoObservacionesFacade")
    private CatalogoObservacionesFacade catalogoObservacionesFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/catalogoObservaciones.do")
    public String catalogoObservaciones(Model modelo) {
        modelo.addAttribute("Observacion",new CatalogoObservaciones());
        modelo.addAttribute("Observaciones", catalogoObservacionesFacade.findAll());
        return "/Observaciones/catalogoObservaciones";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/nuevaObservacion.do")
    public 
    String nuevaObservacion(@Valid CatalogoObservaciones Observacion, BindingResult resultado,Model modelo) {
        if (!resultado.hasErrors()) {
            MetodosValidacion cleaner = new MetodosValidacion();
            Observacion.setDetalle(cleaner.tuneaStringParaBD(Observacion.getDetalle()));
            catalogoObservacionesFacade.create(Observacion);
            modelo.addAttribute("Observaciones", catalogoObservacionesFacade.findAll());
            modelo.addAttribute("Observacion", new CatalogoObservaciones());
             return "/Observaciones/catalogoObservaciones";
        }else{
            modelo.addAttribute("Observaciones", catalogoObservacionesFacade.findAll());
             modelo.addAttribute("Observacion",Observacion);
             modelo.addAttribute("errorBlanco", "<div class='error'>Error la descripcion esta vacia</div>");
           return "/Observaciones/catalogoObservaciones";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteObservacion.do")
    public @ResponseBody
    String eliminaObservacion(int id, Model model) {
        CatalogoObservaciones catalogo;
        catalogo = catalogoObservacionesFacade.find(BigDecimal.valueOf(id));
        //catalogo.setValidacionAdmin(BigInteger.valueOf(1));
        //System.out.println("Ya actualizo");
        // instanciaFacade.edit(instancia);

        return "ok";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/actualizaObservacion.do")
    public @ResponseBody
    String actualizaObservacion(Model modelo, NuevaObservacion Observacion) {

        CatalogoObservaciones catalogo;
        catalogo = catalogoObservacionesFacade.find(BigDecimal.valueOf(Observacion.getId()));
        catalogo.setDetalle(Observacion.getDetalle());
        catalogoObservacionesFacade.edit(catalogo);
        return "<script>"
                + "alert('¡Observacion Actualizada  Correctamente!');"
                + "location.href='catalogoObservaciones.do';"
                + "</script>";


    }
}
