/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.PerfilFacade;
import edu.servicio.toluca.sesion.ProyectosFacade;
import edu.servicio.toluca.sesion.TipoOrganizacionFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author roy
 */
@Controller
public class OrganizacionesController
{
    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
    private InstanciaFacade instanciaFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/ProyectosFacade")
    private ProyectosFacade proyectosFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/TipoOrganizacionFacade")
    private TipoOrganizacionFacade tipoOrganizacionFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/PerfilFacade")
    private PerfilFacade perfilFacade;
    
    @RequestMapping(method = RequestMethod.GET, value = "/administrarOrganizaciones.do")
    public String administradorOrganizaciones(Model model)
    {
        model.addAttribute("organizaciones", instanciaFacade.findAll());
        return "/Organizaciones/administrarOrganizaciones";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/administrarProyectos.do")
    public String administradorProyectos(Model model)
    {
        model.addAttribute("proyectos", proyectosFacade.findAll());
        return "/Organizaciones/administrarProyectos";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/validarOrganizaciones.do")
    public String panelAdministradorOrganizaciones(Model model){
        model.addAttribute("organizacion", instanciaFacade.findAll());
        return "/Organizaciones/validarOrganizaciones";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/validarProyectos.do")
    public String panelAdministradorProyectos(Model model){
        model.addAttribute("proyecto", proyectosFacade.findAll());
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
    public String detalleProyecto(BigDecimal id,Model model){
        model.addAttribute("proyectoDetalle", proyectosFacade.find(id));
        return "/Organizaciones/detalleProyecto";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/detalleOrganizacion.do")
    public String detalleOrganizacion(BigDecimal id,Model model)
    {
        model.addAttribute("instancia", instanciaFacade.find(id));
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
    
   //Editar Organizacion
    @RequestMapping(method = RequestMethod.GET, value = "/editarOrganizacion.do")
    public String editarOrganizacion(int id,Model model)
    {
        model.addAttribute("tipoOrg", tipoOrganizacionFacade.findAll());
        model.addAttribute("instancia", instanciaFacade.find(BigDecimal.valueOf(id)));
        model.addAttribute("perfil", perfilFacade.findAll());
        return "/Organizaciones/editarOrganizacion";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/editarProyecto.do")
    public String editarProyectos(int id,Model model)
    {
        model.addAttribute("proyectos", proyectosFacade.find(BigDecimal.valueOf(id)));
        model.addAttribute("instancias", instanciaFacade.findAll());
        return "/Organizaciones/editarProyecto";
    }
    
    //Borrar Organizacion & Proyecto
    @RequestMapping(method = RequestMethod.GET, value = "/borrarOrganizacion.do")
    public @ResponseBody String borrarOrganizacion(int id,Model model)
    {
        Instancia instancia=new Instancia();
        instancia.setIdInstancia(BigDecimal.valueOf(id));
        instancia.setEstatus(BigInteger.valueOf(0));
        System.out.println("Antes del update");
        instanciaFacade.edit(instancia);
        System.out.println("Despues del update");
        String returnText="Se modifico objeto instancia, con un id de: "+id;
        System.out.println(returnText);
        return returnText;
    }
    
    //Alta Organizaicon visitante
    @RequestMapping(method = RequestMethod.POST, value = "/gdaAltaOrganizacionVisitante.do")
    public String gdaOrganizacionVisitante(Model a){
        
        
        return "/Organizaciones/editarOrganizacion";
    }
    
    //Alta de organizacion por pre-registro
    @RequestMapping(method = RequestMethod.GET, value = "/confirmaOrganizacionVisitante.do")
    public String confirmaOrganizacionVisitante(Model model){        
        
      
        return "/Organizaciones/editarOrganizacion";
    }
    
     @RequestMapping(method = RequestMethod.GET, value = "/pruebaUpdate.do")
    public String pruebaUpdate(int id,Model model)
    {            
        Instancia instancia = new Instancia();
        instancia.setIdInstancia(BigDecimal.valueOf(id));
        instancia.setEstatus(BigInteger.valueOf(0));
        System.out.println("Antes del update");
        instanciaFacade.edit(instancia);
        System.out.println("Despues del update");
        model.addAttribute("instancias", instanciaFacade.findAll());
        return "/Organizaciones/pruebaUpdate";
    }
}
