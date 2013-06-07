/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

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
    @RequestMapping(method = RequestMethod.GET, value = "/administrarOrganizaciones.do")
    public String administradorOrganizaciones(Model a){
        return "/Organizaciones/administrarOrganizaciones";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/administrarProyectos.do")
    public String administradorProyectos(Model a){
        return "/Organizaciones/administrarProyectos";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/validarOrganizaciones.do")
    public String panelAdministradorOrganizaciones(Model a){
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
    public String detalleOrganizacion(Model a){
        return "/Organizaciones/detalleOrganizacion";
    }
    
    
}
