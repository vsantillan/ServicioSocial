/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

/**
 *
 * @author bustedvillain
 */

import edu.servicio.toluca.entidades.Colonia;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.TipoOrganizacion;
import edu.servicio.toluca.sesion.CodigosPostalesFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.TipoOrganizacionFacade;
import java.util.LinkedHashMap;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavegacionPrincipalController {       
    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
    public InstanciaFacade instanciaFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/CodigosPostalesFacade")
    public CodigosPostalesFacade codigosPostalesFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/TipoOrganizacionFacade")
    public TipoOrganizacionFacade tipoOrganizacionFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/EstadosSiaFacade")
    public EstadosSiaFacade estadosFacade;
    
    @RequestMapping(method = RequestMethod.GET, value = "/index.do")
    public String index(Model a){
        return "/NavegacionPrincipal/index";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/convocatorias.do")
    public String convocatorias(Model a){
        return "/NavegacionPrincipal/convocatorias";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/manualProcedimiento.do")
    public String manualProcedimiento(Model a){
        return "/NavegacionPrincipal/manualProcedimiento";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/organizaciones.do")
    public String organizaciones(Model a){
        return "/NavegacionPrincipal/organizaciones";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/loginOrganizaciones.do")
    public String loginOrganizaciones(Model a){
        return "/NavegacionPrincipal/loginOrganizaciones";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/registroOrganizaciones.do")
    public String registroOrganizaciones(Model model){ 

        model.addAttribute("preOrganizaciones", instanciaFacade.findBySpecificField("estatus", "2", "equal", null, null));      
        model.addAttribute("instancia", new Instancia()); 
        model.addAttribute("tipoOrganizaciones", tipoOrganizacionFacade.findBySpecificField("estatus", "1", "equal", null, null));
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("nombre", "asc");
        model.addAttribute("estados", estadosFacade.findAll(ordenamiento));
        return "/Organizaciones/registroOrganizaciones";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/login.do")
    public String loginAlumnos(Model a){
        return "/NavegacionPrincipal/loginPrincipal";
    }
}
