/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.DocumentosFacade;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author regules
 */
@Controller
public class CartasLiberacionController 
{
    @EJB(mappedName = "java:global/ServicioSocial/DocumentosFacade")
    private DocumentosFacade documentosFacade;
    
    @RequestMapping(method = RequestMethod.GET, value = "/alumnosCartasLiberacion.do")
    public String alumnosCartasLiberacion(Model modelo) 
    {
        modelo.addAttribute("cartaDocumento", documentosFacade.findAll());
        return "/CartasLiberacion/alumnosCartasLiberacion";
    }
}
