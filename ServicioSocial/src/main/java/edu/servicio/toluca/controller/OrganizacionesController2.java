/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.PerfilJSON;
import edu.servicio.toluca.beans.StringMD;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.Perfil;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.sesion.ColoniaFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.PerfilFacade;
import edu.servicio.toluca.sesion.ProyectosFacade;
import edu.servicio.toluca.sesion.TipoOrganizacionFacade;
import edu.servicio.toluca.sesion.TipoProyectoFacade;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author bustedvillain
 */
@Controller
public class OrganizacionesController2 {
    
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
    
    
    @RequestMapping(method = RequestMethod.POST, value = "/gdaAltaAdminProyecto.do")
    public String gdaAdminAltaProyecto(@Valid Proyectos proyecto, BindingResult result, Model model) {
        System.out.println("hola admin gda alta organizacion");
        System.out.println("Nombre:"+proyecto.getNombre());
        System.out.println("No Vacantes:"+proyecto.getVacantes());
        if (result.hasErrors()) {
            System.out.print("hubo errores");
            //Organizacion
            List<Instancia> listaInstancias = instanciaFacade.findBySpecificField("estatus", "1", "equal", null, null);
            ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();

            for (int i = 0; i < listaInstancias.size(); i++) {
                if (listaInstancias.get(i).getValidacionAdmin() == BigInteger.ONE) {
                    filtroInstancias.add(listaInstancias.get(i));
                }
            }
            model.addAttribute("instancias", filtroInstancias);

            //Estados
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("nombre", "asc");
            model.addAttribute("estados", estadosFacade.findAll(ordenamiento));
            //TipoProyecto
            model.addAttribute("tipoProyecto", tipoProyectoFacade.findBySpecificField("status", "1", "equal", null, null));
            //Perfil
            model.addAttribute("perfiles", perfilFacade.findBySpecificField("estatus", "1", "equal", null, null));


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
            perfilJSON.getIdPerfil().add(perfiles.get(i).getIdPerfil() + "");
            perfilJSON.getNombre().add(perfiles.get(i).getNombre());
        }
        return perfilJSON;
    }
    
    
    //Alta de organizacion por pre-registro
    @RequestMapping(method = RequestMethod.GET, value = "/confirmaOrganizacionVisitante.do")
    public String confirmaOrganizacionVisitante(Model model) {


        return "/Organizaciones/editarOrganizacion";
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
}
