/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.sesion.InstanciaFacade;
import java.math.BigDecimal;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author bustedvillain
 */
@Controller
public class CodigosPostalesController {
    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
    private InstanciaFacade instanciaFacade;
    
    @RequestMapping(method = RequestMethod.GET, value = "/cargarColonias.do")
    public String administradorOrganizaciones(Model model, int idCp)
    {
        
        return "/Organizaciones/administrarOrganizaciones";
    }
}


