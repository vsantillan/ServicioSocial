/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.entidades.CatalogoSanciones;
import edu.servicio.toluca.entidades.Sanciones;
import edu.servicio.toluca.model.sanciones.CatalogoSancionesModel;
import edu.servicio.toluca.sesion.CatalogoSancionesFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
 * @author Regules
 */
@Controller
public class SancionesController {

    @EJB(mappedName = "java:global/ServicioSocial/CatalogoSancionesFacade")
    private CatalogoSancionesFacade catalogoSancionesFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/sancionesAlumno.do")
    public String sancionesAlumno(Model modelo) {
        return "/Sanciones/sancionesAlumno";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pagoSancionAlumno.do")
    public String pagoSancionAlumno(String nombre, String noControl, Model modelo) {
        modelo.addAttribute("nombre", nombre);
        modelo.addAttribute("noControl", noControl);
        return "/Sanciones/pagoSancionAlumno";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detalleSancionAlumno.do")
    public String detalleSancionAlumno(String nombre, String noControl, Model modelo) {
        modelo.addAttribute("nombre", nombre);
        modelo.addAttribute("noControl", noControl);
        return "/Sanciones/detalleSancionAlumno";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/catalogoSanciones.do")
    public String catalogoSanciones(Model model) {

        System.out.println("Conteo de registros Catalogo Sanciones:" + catalogoSancionesFacade.count());
        List<CatalogoSanciones> listaSanciones = new ArrayList<CatalogoSanciones>();
        List<CatalogoSanciones> listaPagoSanciones = new ArrayList<CatalogoSanciones>();
        for (CatalogoSanciones sancion : catalogoSancionesFacade.findAll()) {

            if (sancion.getHorasSancion().compareTo(BigInteger.ZERO) > 0) {
                listaSanciones.add(sancion);
            } else {
                listaPagoSanciones.add(sancion);
            }
        }

        model.addAttribute("sanciones", listaSanciones);
        model.addAttribute("pagoSanciones", listaPagoSanciones);
        return "/Sanciones/catalogoSanciones";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editaSancion.do")
    public String editaSancion(String descripcion, String horas, Model modelo, BigDecimal id) {
        CatalogoSanciones sancion = catalogoSancionesFacade.find(id);
        modelo.addAttribute("idSancion", sancion.getId());
        modelo.addAttribute("descripcion", sancion.getDetalle());
        modelo.addAttribute("horas", sancion.getHorasSancion());
        modelo.addAttribute("tolerancia", sancion.getTolerancia());
        return "/Sanciones/editaSancion";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/editaPagoSancion.do")
    public String editaPagoSancion(String descripcion, String horas, Model modelo, BigDecimal id) {
        CatalogoSanciones sancion = catalogoSancionesFacade.find(id);
        modelo.addAttribute("idSancion", sancion.getId());
        modelo.addAttribute("descripcion", sancion.getDetalle());
        return "/Sanciones/editaPagoSancion";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/nuevaSancion.do")
    public @ResponseBody
    String nuevaSancion(Model model, BigDecimal idSancion, String descripcion, BigInteger horas, BigInteger tolerancia, Model modelo, String tipo) {
        CatalogoSancionesModel csm = new CatalogoSancionesModel(descripcion, horas, tolerancia);
        String arrJSON = "[";
        csm.arregla();
        ArrayList<String> listaErrores = csm.valida();
        if (listaErrores.isEmpty()) {
            CatalogoSanciones sancion = null;
            if(tipo.equals("nuevo"))
                 sancion = new CatalogoSanciones();
            else
                sancion = catalogoSancionesFacade.find(idSancion);
            sancion.setDetalle(descripcion);
            sancion.setHorasSancion(horas);
            sancion.setTolerancia(tolerancia);
            try {
                if (tipo.equals("nuevo")) {
                    catalogoSancionesFacade.create(sancion);
                }
                else
                {
                    catalogoSancionesFacade.edit(sancion);
                }

            } catch (Exception e) {
                arrJSON = arrJSON + "{\"observacion\":\"" + e.getMessage() + "\"},";
            }

        } else {
            int i = 1;
            for (String s : listaErrores) {
                arrJSON = arrJSON + "{\"observacion\":\"" + s + "\"},";
                System.out.println("Error " + i + " " + s);
                i++;
            }
        }
        if (arrJSON.equals("[")) {
            arrJSON = "noInfo";
        } else {
            arrJSON = arrJSON.substring(0, arrJSON.length() - 1) + "]";
        }


        System.out.println("Arrjson" + arrJSON);
        return arrJSON;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/nuevoPagoSancion.do")
    public @ResponseBody
    String nuevoPagoSancion(Model model, BigDecimal idSancion, String descripcion, Model modelo, String tipo) {
        CatalogoSancionesModel csm = new CatalogoSancionesModel(descripcion, BigInteger.ZERO, BigInteger.ZERO);
        String arrJSON = "[";
        csm.arregla();
        ArrayList<String> listaErrores = csm.valida2();

        if (listaErrores.isEmpty()) {
            CatalogoSanciones sancion = null;
            if(tipo.equals("nuevo"))
                sancion = new CatalogoSanciones();
            else
                sancion = catalogoSancionesFacade.find(idSancion);
            sancion.setDetalle(descripcion);
            sancion.setHorasSancion(BigInteger.ZERO);
            sancion.setTolerancia(BigInteger.ZERO);
            try {
                if(tipo.equals("nuevo"))
                    catalogoSancionesFacade.create(sancion);
                else
                    catalogoSancionesFacade.edit(sancion);
            } catch (Exception e) {
                arrJSON = arrJSON + "{\"observacion\":\"" + e.getMessage() + "\"},";
            }

        } else {
            int i = 1;
            for (String s : listaErrores) {
                arrJSON = arrJSON + "{\"observacion\":\"" + s + "\"},";
                System.out.println("Error " + i + " " + s);
                i++;
            }
        }
        if (arrJSON.equals("[")) {
            arrJSON = "noInfo";
        } else {
            arrJSON = arrJSON.substring(0, arrJSON.length() - 1) + "]";
        }


        System.out.println("Arrjson" + arrJSON);
        return arrJSON;


    }
}
