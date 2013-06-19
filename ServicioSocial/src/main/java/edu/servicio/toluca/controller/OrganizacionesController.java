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
 * @author roy
 */
@Controller
public class OrganizacionesController
{
    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
    private InstanciaFacade instanciaFacade;
    
    @RequestMapping(method = RequestMethod.GET, value = "/administrarOrganizaciones.do")
    public String administradorOrganizaciones(Model model)
    {
        model.addAttribute("organizaciones", instanciaFacade.findAll());
        return "/Organizaciones/administrarOrganizaciones";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/administrarProyectos.do")
    public String administradorProyectos(Model a){
        return "/Organizaciones/administrarProyectos";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/validarOrganizaciones.do")
    public String panelAdministradorOrganizaciones(Model model){
        model.addAttribute("organizacion", instanciaFacade.findAll());
        return "/Organizaciones/validarOrganizaciones";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/validarProyectos.do")
    public String panelAdministradorProyectos(Model a){
        return "/Organizaciones/validarProyectos";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/retroalimentacionOrganizacion.do")
    public String retoalimentacionOrganizaciones(Model a)
    {
        return "/Organizaciones/retroalimentacionOrganizacion";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/retroalimentacionProyecto.do")
    public String retoalimentacionProyectos(Model a)
    {
        return "/Organizaciones/retroalimentacionProyectos";
    }
    
    //Panel de organizaciones (usuarios)
    @RequestMapping(method = RequestMethod.GET, value = "/panelOrganizacion.do")
    public String panelOrganizacion(Model a)
    {
        return "/PanelOrganizacion/panelOrganizacion";
    }
    
    //Alta de Organizacion
    @RequestMapping(method = RequestMethod.GET, value = "/altaOrganizacion.do")
    public String altaOrganizacion(Model a)
    {
        return "/Organizaciones/altaOrganizacion";
    }
    
    //Alta de Proyecto
    @RequestMapping(method = RequestMethod.GET, value = "/altaProyecto.do")
    public String altaProyecto(Model a)
    {
        return "/Organizaciones/altaProyecto";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/detalleProyecto.do")
    public String detalleProyecto(Model a){
        return "/Organizaciones/detalleProyecto";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/detalleOrganizacion.do")
    public String detalleOrganizacion(int id,Model model)
    {
        model.addAttribute("intancia", instanciaFacade.find(id));
        return "/Organizaciones/detalleOrganizacion";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/altaAdminOrganizacion.do")
    public String altaAdminOrganizacion(Model a){
        return "/Organizaciones/altaAdminOrganizacion";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/altaAdminProyectos.do")
    public String altaAdminProyectos(Model a){
        return "/Organizaciones/altaAdminProyecto";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/mensajeOrganizacion.do")
    public String mensajeOrganizacion(Model a){
        return "/Organizaciones/mensajeOrganizacion";
    }
    
    
}
