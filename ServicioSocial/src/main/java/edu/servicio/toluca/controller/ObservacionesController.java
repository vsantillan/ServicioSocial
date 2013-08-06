/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.NuevaObservacion;
import edu.servicio.toluca.entidades.CatalogoObservaciones;
import edu.servicio.toluca.sesion.CatalogoObservacionesFacade;
import edu.servicio.toluca.sesion.CatalogoSancionesFacade;
import java.math.BigDecimal;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        modelo.addAttribute("Observacion", new NuevaObservacion());
        modelo.addAttribute("Observaciones", catalogoObservacionesFacade.findAll());
        return "/Observaciones/catalogoObservaciones";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/nuevaObservacion.do")
    public @ResponseBody
    String nuevaObservacion(Model modelo, NuevaObservacion observacion) {
        CatalogoObservaciones catalogo = new CatalogoObservaciones();
        catalogo.setDetalle(observacion.getDescripcion());
        System.out.println("la observacion" + observacion.getDescripcion());
        catalogoObservacionesFacade.create(catalogo);
        System.out.println("Inserto Observacion");
        return "<script>"
                + "alert('¡Observacion Agregada Correctamente!');"
                + "location.href='catalogoObservaciones.do';"
                + "</script>";
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
    String actualizaObservacion(Model modelo, NuevaObservacion observacion) {
        CatalogoObservaciones catalogo;
        catalogo= catalogoObservacionesFacade.find(BigDecimal.valueOf(observacion.getId()));
        catalogo.setDetalle(observacion.getDescripcion());
        System.out.println("la observacion" + observacion.getDescripcion());
        catalogoObservacionesFacade.edit(catalogo);
        System.out.println("Actualizo Observacion");
        return "<script>"
                + "alert('¡Observacion Actualizada  Correctamente!');"
                + "location.href='catalogoObservaciones.do';"
                + "</script>";
    }
}
