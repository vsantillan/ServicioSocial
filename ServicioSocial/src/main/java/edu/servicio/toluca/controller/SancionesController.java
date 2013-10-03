/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.entidades.CatalogoSanciones;
import edu.servicio.toluca.entidades.Sanciones;
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

/**
 *
 * @author Regules
 */
@Controller
public class SancionesController 
{
    @EJB(mappedName = "java:global/ServicioSocial/CatalogoSancionesFacade")
    private CatalogoSancionesFacade catalogoSancionesFacade;
    
    @RequestMapping(method = RequestMethod.GET, value = "/sancionesAlumno.do")
    public String sancionesAlumno(Model modelo)
    {
        return "/Sanciones/sancionesAlumno";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/pagoSancionAlumno.do")
    public String pagoSancionAlumno(String nombre, String noControl, Model modelo)
    {
        modelo.addAttribute("nombre", nombre);
        modelo.addAttribute("noControl", noControl);
        return "/Sanciones/pagoSancionAlumno";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/detalleSancionAlumno.do")
    public String detalleSancionAlumno(String nombre, String noControl, Model modelo)
    {
        modelo.addAttribute("nombre", nombre);
        modelo.addAttribute("noControl", noControl);
        return "/Sanciones/detalleSancionAlumno";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/catalogoSanciones.do")
    public String catalogoSanciones(Model model)
    {
        CatalogoSanciones cs=new CatalogoSanciones();
//        cs.setHorasSancion(BigInteger.valueOf(10));
//        cs.setTolerancia(BigInteger.valueOf(10));
//        cs.setDetalle("Es la tercera sancion");        
        //catalogoSancionesFacade.create(cs);
        System.out.println("Conteo de registros Catalogo Sanciones:"+catalogoSancionesFacade.count()); 
        List<CatalogoSanciones> listaAllSanciones = catalogoSancionesFacade.findAll();
        List<CatalogoSanciones> listaSanciones =  new ArrayList<CatalogoSanciones>();
        List<CatalogoSanciones> listaPagoSanciones =  new ArrayList<CatalogoSanciones>();
        for(CatalogoSanciones sancion : catalogoSancionesFacade.findAll())
        {
            
            if(sancion.getHorasSancion().compareTo(BigInteger.ZERO) > 0)
            {
                listaSanciones.add(sancion);
            } 
            else
            {
                listaPagoSanciones.add(sancion);
            }  
        }
        
        model.addAttribute("sanciones", listaSanciones);
        model.addAttribute("pagoSanciones", listaPagoSanciones);
        return "/Sanciones/catalogoSanciones";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/editaSancion.do")
    public String editaSancion(String descripcion,String horas,Model modelo)
    {
        modelo.addAttribute("descripcion", descripcion);
        modelo.addAttribute("horas", horas);
        return "/Sanciones/editaSancion";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/nuevaSancion.do")
    public String nuevaSancion(@Valid CatalogoSanciones catalogoSanciones, BindingResult result, Model model, String descripcion,String horas,Model modelo)
    {
        
        if(result.hasErrors())
        {
            System.out.println("Bindiing" + result.toString());
        }
        modelo.addAttribute("descripcion", descripcion);
        modelo.addAttribute("horas", horas);
        System.out.println("desc: "+descripcion+"\n horas: "+horas);
        return "/Sanciones/catalogoSanciones";
    }
}
