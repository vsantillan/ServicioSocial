/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.organizaciones.BorrarProyecto;
import edu.servicio.toluca.beans.organizaciones.EditarOrganizacion;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.sesion.ColoniaFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.PerfilFacade;
import edu.servicio.toluca.sesion.ProyectosFacade;
import edu.servicio.toluca.sesion.TipoOrganizacionFacade;
import edu.servicio.toluca.sesion.TipoProyectoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.validation.Valid;

import javax.ejb.EJB;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author roy
 */
@Controller
public class OrganizacionesController {
//    @Resource
//    private UserTransaction utx;

    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
    private InstanciaFacade instanciaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/ProyectosFacade")
    private ProyectosFacade proyectosFacade;
    @EJB(mappedName = "java:global/ServicioSocial/TipoOrganizacionFacade")
    private TipoOrganizacionFacade tipoOrganizacionFacade;
    @EJB(mappedName = "java:global/ServicioSocial/PerfilFacade")
    private PerfilFacade perfilFacade;
    @EJB(mappedName = "java:global/ServicioSocial/ColoniaFacade")
    private ColoniaFacade coloniaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/TipoProyectoFacade")
    private TipoProyectoFacade tipoProyectoFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/administrarOrganizaciones.do")
    public String administradorOrganizaciones(Model model)
    {
        model.addAttribute("organizaciones", instanciaFacade.findAll());
        System.out.println("Despues del Js");
        return "/Organizaciones/administrarOrganizaciones";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/administrarProyectos.do")
    public String administradorProyectos(Model model) {
        model.addAttribute("proyectos", proyectosFacade.findAll());
        return "/Organizaciones/administrarProyectos";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/validarOrganizaciones.do")
    public String panelAdministradorOrganizaciones(Model model) {
        model.addAttribute("organizacion", instanciaFacade.findAll());
        return "/Organizaciones/validarOrganizaciones";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/updateStatus.do")  
    public @ResponseBody  String actualizarStatusOrganizaciones(int id,Model model){
        
     return "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/validarProyectos.do")
    public String panelAdministradorProyectos(Model model) {
        model.addAttribute("proyecto", proyectosFacade.findBySpecificField("validacionAdmin", "0", "equal", null, null));
        return "/Organizaciones/validarProyectos";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/retroalimentacionOrganizacion.do")
    public String retoalimentacionOrganizaciones(Model a) {
        return "/Organizaciones/retroalimentacionOrganizacion";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/retroalimentacionProyecto.do")
    public String retoalimentacionProyectos(Model a) {
        return "/Organizaciones/retroalimentacionProyectos";
    }

    //Panel de organizaciones (usuarios)
    @RequestMapping(method = RequestMethod.GET, value = "/panelOrganizacion.do")
    public String panelOrganizacion(Model a) {
        return "/PanelOrganizacion/panelOrganizacion";
    }

    //Alta de Organizacion
    @RequestMapping(method = RequestMethod.GET, value = "/altaOrganizacion.do")
    public String altaOrganizacion(Model a) {
        return "/Organizaciones/altaOrganizacion";
    }

    //Alta de Proyecto
    @RequestMapping(method = RequestMethod.GET, value = "/altaProyecto.do")
    public String altaProyecto(Model a) {
        return "/Organizaciones/altaProyecto";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detalleProyecto.do")
    public String detalleProyecto(BigDecimal id, Model model) {
        model.addAttribute("proyectoDetalle", proyectosFacade.find(id));
        return "/Organizaciones/detalleProyecto";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detalleOrganizacion.do")
    public String detalleOrganizacion(BigDecimal id, Model model) {
        model.addAttribute("instancia", instanciaFacade.find(id));
        return "/Organizaciones/detalleOrganizacion";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/altaAdminOrganizacion.do")
    public String altaAdminOrganizacion(Model a) {
        return "/Organizaciones/altaAdminOrganizacion";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/altaAdminProyectos.do")
    public String altaAdminProyectos(Model a) {
        return "/Organizaciones/altaAdminProyecto";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mensajeOrganizacion.do")
    public String mensajeOrganizacion(Model a) {
        return "/Organizaciones/mensajeOrganizacion";
    }

    //Editar Organizacion
    @RequestMapping(method = RequestMethod.GET, value = "/editarOrganizacion.do")
    public String editarOrganizacion(int id, Model model) {
        model.addAttribute("tipoOrg", tipoOrganizacionFacade.findAll());
        model.addAttribute("instancia", instanciaFacade.find(BigDecimal.valueOf(id)));
        model.addAttribute("editaOrganizacion", new EditarOrganizacion());
        return "/Organizaciones/editarOrganizacion";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/modificarOrganizacion.do")
    public String modificarOrganizacion(EditarOrganizacion editaOrganizacion,BindingResult result)
    {
        if(result.hasErrors())
        {
            System.out.println("Con errores");
            return "/Organizaciones/editarOrganizacion";
        }else{
            //instanciaFacade.edit(instancia);
            System.out.println("Sin errores");
            System.out.println(editaOrganizacion.getEstatus());
            return "/Organizaciones/administrarOrganizaciones";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editarProyecto.do")
    public String editarProyectos(int id,Model model)
    {
        model.addAttribute("proyectos", proyectosFacade.find(BigDecimal.valueOf(id)));
        model.addAttribute("instancias", instanciaFacade.findAll());
        model.addAttribute("perfil", perfilFacade.findAll());
        model.addAttribute("tipoProyecto", tipoProyectoFacade.findAll());
        return "/Organizaciones/editarProyecto";
    }

    //Borrar Organizacion & Proyecto
    @RequestMapping(method = RequestMethod.GET, value = "/borrarInstancia.do")
    public @ResponseBody String borrarInstancia(int id,Model model)
    {
        String returnText="Se modifico objeto instancia, con un id de: "+id;
        Instancia instancia=instanciaFacade.find(BigDecimal.valueOf(id));
        instancia.setIdInstancia(BigDecimal.valueOf(id));
        instancia.setEstatus(BigInteger.valueOf(0));
        System.out.println("Antes del update");
        //instanciaFacade.edit(instancia);
        System.out.println("Despues del update"); 
        return returnText;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/borrarProyecto.do")
    public @ResponseBody String borrarProyecto(BorrarProyecto borrarProyecto,Model model)
    {
        String returnText="Correo enviado exitosamente a: "+borrarProyecto.getEmail()+".";
        System.out.println("Antes del update");
        //instanciaFacade.edit(instancia);
        //EnviaRetroalimentacion obj = new EnviaRetroalimentacion(Integer.toString(i),"",borrarProyecto.getEmail(),borrarProyecto.getDescripcion());
        //obj.enviarCorreo();
        System.out.println("Despues del update"); 
        return returnText;
    }

    //Alta Organizaicon visitante
    @RequestMapping(method = RequestMethod.POST, value = "/gdaAltaOrganizacionVisitante.do")
    public String gdaOrganizacionVisitante(Model a) {


        return "/Organizaciones/editarOrganizacion";
    }

    //Alta de organizacion por pre-registro
    @RequestMapping(method = RequestMethod.GET, value = "/confirmaOrganizacionVisitante.do")
    public String confirmaOrganizacionVisitante(Model model) {


        return "/Organizaciones/editarOrganizacion";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/gdaAltaOrganizacion.do")
    public String gdaAtalaOrganizacion(@Valid Instancia instancia, BindingResult result, Model model) {     
//          binder.registerCustomEditor(Colonia.class, new ColoniaEditor());
//          result.
//        System.out.println("Tipo Organizacion:"+tipoOrganizacion);
//        instancia.setTipoOrganizacion(tipoOrganizacionFacade.find(BigDecimal.valueOf(Double.parseDouble(tipoOrganizacion))));
        System.out.println("idColonia:"+instancia.getIdColonia());
//        instancia.setIdColonia(coloniaFacade.find(BigDecimal.valueOf(Double.parseDouble(idColonia))));
        if (result.hasErrors()) {
            System.out.print("hubo errores");
            System.out.println("Datos: Nombre:"+instancia.getNombre());
            System.out.println(result.toString());
//            model.addAttribute("preOrganizaciones", instanciaFacade.findBySpecificField("estatus", "2", "equal", null, null));
//            model.addAttribute("instancia", new Instancia());
//            model.addAttribute("tipoOrganizaciones", tipoOrganizacionFacade.findBySpecificField("estatus", "1", "equal", null, null));
//            model.addAttribute("colonia", new Colonia());
//            model.addAttribute("tipoOrganizacionesObj", new TipoOrganizacion());
            return "/Organizaciones/registroOrganizaciones";

        } else {
            System.out.print("no hubo errores");
            instanciaFacade.create(instancia);
            return "/Organizacion/confirmaRegOrganizacion";
        }


    }
}
