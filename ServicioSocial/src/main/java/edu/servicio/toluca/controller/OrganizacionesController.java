/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.PerfilJSON;
import edu.servicio.toluca.beans.StringMD;
import edu.servicio.toluca.beans.organizaciones.BorrarInstancia;
import edu.servicio.toluca.beans.organizaciones.BorrarProyecto;
import edu.servicio.toluca.beans.organizaciones.ConsultasOrganizaciones;
import edu.servicio.toluca.beans.organizaciones.EditarOrganizacion;
import edu.servicio.toluca.entidades.Estados;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.Perfil;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.sesion.ColoniaFacade;
import edu.servicio.toluca.sesion.EstadosFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.PerfilFacade;
import edu.servicio.toluca.sesion.ProyectosFacade;
import edu.servicio.toluca.sesion.TipoOrganizacionFacade;
import edu.servicio.toluca.sesion.TipoProyectoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.validation.Valid;

import javax.ejb.EJB;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
    @EJB(mappedName = "java:global/ServicioSocial/EstadosSiaFacade")
    private EstadosSiaFacade estadosFacade;
    

    @RequestMapping(method = RequestMethod.GET, value = "/administrarOrganizaciones.do")
    public String administradorOrganizaciones(Model model)
    {
        model.addAttribute("organizaciones", instanciaFacade.findAll());
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

    @RequestMapping(method = RequestMethod.GET, value = "/retroalimentacionInstancia.do")
    public String retroalimentacionInstancia(int id,Model model) 
    {
        model.addAttribute("instancia", instanciaFacade.find(BigDecimal.valueOf(id)));
        model.addAttribute("retroalimentacionInstancia", new BorrarInstancia());
        return "/Organizaciones/retroalimentacionInstancia";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/retroalimentacionProyecto.do")
    public String retoalimentacionProyectos(int id,Model model)
    {
        model.addAttribute("proyectos", proyectosFacade.find(BigDecimal.valueOf(id)));
        model.addAttribute("borrarProyecto", new BorrarProyecto());
        return "/Organizaciones/retroalimentacionProyectos";
    }

    //Panel de organizaciones (usuarios)
    @RequestMapping(method = RequestMethod.GET, value = "/panelOrganizacion.do")
    public String panelOrganizacion(Model a) {
        return "/PanelOrganizacion/panelOrganizacion";
    }

    //Alta de Organizacion
    @RequestMapping(method = RequestMethod.GET, value = "/altaOrganizacion.do")
    public String altaOrganizacion(Model model) {
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("nombre", "asc");
        model.addAttribute("estados", estadosFacade.findAll(ordenamiento));
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
    public String altaAdminOrganizacion(Model model) {
        model.addAttribute("instancia", new Instancia());
        model.addAttribute("tipoOrganizaciones", tipoOrganizacionFacade.findBySpecificField("estatus", "1", "equal", null, null));

        //model.addAttribute("estados", estadosFacade.findAll());
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("nombre", "asc");
        model.addAttribute("estados", estadosFacade.findAll(ordenamiento));
        return "/Organizaciones/altaAdminOrganizacion";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/altaAdminProyectos.do")
    public String altaAdminProyectos(Model model) {

        //Organizacion
        List<Instancia> listaInstancias = instanciaFacade.findBySpecificField("estatus", "1", "equal", null, null);
        ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();

        for (int i = 0; i < listaInstancias.size(); i++) {
            if (listaInstancias.get(i).getValidacionAdmin() == BigInteger.ONE) {
                filtroInstancias.add(listaInstancias.get(i));
            }
        }
        model.addAttribute("instancias", filtroInstancias);
        //Objeto proyecto para el commandAttribute
        model.addAttribute("proyecto", new Proyectos());
        //Estados
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("nombre", "asc");
        model.addAttribute("estados", estadosFacade.findAll(ordenamiento));
        //TipoProyecto
        model.addAttribute("tipoProyecto", tipoProyectoFacade.findBySpecificField("status", "1", "equal", null, null));
        //Perfil
        model.addAttribute("perfiles", perfilFacade.findBySpecificField("estatus", "1", "equal", null, null));

        return "/Organizaciones/altaAdminProyecto";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mensajeOrganizacion.do")
    public String mensajeOrganizacion(Model a) {
        return "/Organizaciones/mensajeOrganizacion";
    }

    //Editar Organizacion
    @RequestMapping(method = RequestMethod.GET, value = "/editarOrganizacion.do")
    public String editarOrganizacion(int id, Model model) {
        model.addAttribute("instancia", instanciaFacade.find(BigDecimal.valueOf(id)));
        model.addAttribute("editaOrganizacion", new EditarOrganizacion()); 
        //model.addAttribute("instancia", new Instancia()); 
        model.addAttribute("estados", estadosFacade.findAll());
        //model.addAttribute("tipoOrganizaciones", tipoOrganizacionFacade.findBySpecificField("estatus", "1", "equal", null, null));
        model.addAttribute("tipoOrganizaciones", tipoOrganizacionFacade.findAll());
        
        return "/Organizaciones/editarOrganizacion";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/modificarOrganizacion.do")
    public String modificarOrganizacion(int id,BindingResult result)
    {
        if(result.hasErrors())
        {
            System.out.println("Con errores");
            return "/Organizaciones/editarOrganizacion";
        }else{
            Instancia instancia;
            instancia=instanciaFacade.find(id);
            instancia.setEstatus(BigInteger.valueOf(0));
            instanciaFacade.edit(instancia);
            System.out.println("Sin errores");
            //System.out.println(editaOrganizacion.getEstatus());
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
    @RequestMapping(method = RequestMethod.POST, value = "/borrarInstancia.do")
    public @ResponseBody String borrarInstancia(@Valid BorrarInstancia retroalimentacionInstancia,BindingResult resultado)
    {
        if(resultado.hasErrors())
        {
            for (ObjectError error : resultado.getAllErrors()) 
            {
                System.out.println(error.getDefaultMessage());
            }
            return "<script>alert('¡Error al intentar enviar!, verifica los datos')</script>";
        }else{
            System.out.println("Antes del update");
            Instancia instancia;
            instancia=instanciaFacade.find(BigDecimal.valueOf(retroalimentacionInstancia.getId()));
            instancia.setEstatus(BigInteger.valueOf(0));
            //instanciaFacade.edit(instancia);
            System.out.println("Despues del update"); 
            return "<script>alert('¡Correo enviado exitosamente a: "+retroalimentacionInstancia.getCorreo()+"!');window.parent.Shadowbox.close();</script>";
        }
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/borrarProyecto.do")
    public @ResponseBody String borrarProyecto(BorrarProyecto retroalimentacionProyecto,BindingResult resultado)
    {
        if(resultado.hasErrors())
        {
            for (ObjectError error : resultado.getAllErrors()) 
            {
                System.out.println(error.getDefaultMessage());
            }
            return "<script>alert('¡Error al intentar enviar!, verifica los datos')</script>";
        }else{
            System.out.println("Antes del update");
            //instanciaFacade.edit(instancia);
            System.out.println("Despues del update"); 
            return "<script>alert('¡Correo enviado exitosamente a: "+retroalimentacionProyecto.getEmail()+"!');window.parent.Shadowbox.close();</script>";
        }
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
    public String gdaAltaOrganizacion(@Valid Instancia instancia, BindingResult result, Model model, String confirma_password) {

        System.out.println("contraseña:" + instancia.getPassword());
        System.out.println("confirma_contraseña:" + confirma_password);

        if (!confirma_password.equals(instancia.getPassword())) {
            result.addError(new ObjectError("confirma_passowrd", "Las contraseñas no coinciden"));
            model.addAttribute("confirma_password", "<div class='error'>Las contraseñas no coinciden</div>");
        }

        if (result.hasErrors()) {
            System.out.print("hubo errores");
            System.out.println(instancia.toString());
            System.out.println(result.toString());

            //Agregamos atributos al formulario
            model.addAttribute("preOrganizaciones", instanciaFacade.findBySpecificField("estatus", "2", "equal", null, null));
//            model.addAttribute("instancia", new Instancia());
            model.addAttribute("tipoOrganizaciones", tipoOrganizacionFacade.findBySpecificField("estatus", "1", "equal", null, null));
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("nombre", "asc");
            model.addAttribute("estados", estadosFacade.findAll(ordenamiento));

            return "/Organizaciones/registroOrganizaciones";

        } else {
            System.out.print("no hubo errores");
            instancia.setValidacionAdmin(BigInteger.ZERO);
            instancia.setEstatus(BigInteger.ONE);
            instancia.setPassword(StringMD.getStringMessageDigest(instancia.getPassword(), StringMD.SHA1));
            instanciaFacade.create(instancia);
            return "/Organizaciones/confirmaRegOrganizacion";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/gdaAdminAltaOrganizacion.do")
    public String gdaAdminAltaOrganizacion(@Valid Instancia instancia, BindingResult result, Model model) {
        System.out.println("hola admin gda alta organizacion");

        if (result.hasErrors()) {
            System.out.print("hubo errores");
            System.out.println(instancia.toString());
            System.out.println(result.toString());

            //Agregamos atributos al formulario
            model.addAttribute("tipoOrganizaciones", tipoOrganizacionFacade.findBySpecificField("estatus", "1", "equal", null, null));
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("nombre", "asc");
            model.addAttribute("estados", estadosFacade.findAll(ordenamiento));

            return "/Organizaciones/altaAdminOrganizacion";
        } else {
            System.out.print("no hubo errores");
            instancia.setValidacionAdmin(BigInteger.ZERO);
            instancia.setEstatus(BigInteger.valueOf(2));
            instancia.setPassword(StringMD.getStringMessageDigest(instancia.getPassword(), StringMD.SHA1));
            instanciaFacade.create(instancia);
            System.out.println("Insercion correcta!");
            return "/Organizaciones/confirmaAdminRegOrganizacion";
        }
    }

    //Alta de organizacion por pre-registro
    @RequestMapping(method = RequestMethod.GET, value = "/confirmaRegOrganizacion.do")
    public String confirmaRegOrganizacion(Model model) {
        return "/Organizaciones/confirmaRegOrganizacion";
    }

    //Alta de organizacion por pre-registro
    @RequestMapping(method = RequestMethod.GET, value = "/confirmaAdminRegOrganizacion.do")
    public String confirmaAdminRegOrganizacion(Model model) {
        return "/Organizaciones/confirmaAdminRegOrganizacion";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/gdaAltaAdminProyecto.do")
    public String gdaAdminAltaProyecto(@Valid Proyectos proyecto, BindingResult result, Model model) {
        System.out.println("hola admin gda alta organizacion");

        if (result.hasErrors()) {
            System.out.print("hubo errores");


            return "/Organizaciones/altaAdminProyecto";
        } else {
            System.out.print("no hubo errores");

            System.out.println("Insercion correcta!");
            return "/Organizaciones/confirmaAltaAdminProyectos";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cargarPerfiles.do")
    public @ResponseBody
    PerfilJSON cargarColonias(Model model, String cp) {

        //Fabricacion de objeto
        List<Perfil> perfiles = perfilFacade.findBySpecificField("estatus", "1", "equal", null, null);
        PerfilJSON perfilJSON = new PerfilJSON();
        System.out.println("Perfiles:");
        for (int i = 0; i < perfiles.size(); i++) {
            System.out.println(perfiles.get(i).getNombre());
            perfilJSON.getIdPerfil().add(perfiles.get(i).getIdPerfil()+"");
            perfilJSON.getNombre().add(perfiles.get(i).getNombre());
        }
        return perfilJSON;
    }
}
