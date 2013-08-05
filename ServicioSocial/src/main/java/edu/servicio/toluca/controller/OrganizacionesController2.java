/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.PerfilJSON;
import edu.servicio.toluca.beans.StringMD;
import edu.servicio.toluca.beans.organizaciones.ConsultasOrganizaciones;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.Perfil;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.model.ActividadesModel;
import edu.servicio.toluca.model.ProyectoPerfilModel;
import edu.servicio.toluca.sesion.ColoniaFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.PerfilFacade;
import edu.servicio.toluca.sesion.ProgramaFacade;
import edu.servicio.toluca.sesion.ProyectosFacade;
import edu.servicio.toluca.sesion.TipoOrganizacionFacade;
import edu.servicio.toluca.sesion.TipoProyectoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
    @EJB(mappedName = "java:global/ServicioSocial/ProgramaFacade")
    private ProgramaFacade programaFacade;

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
        //Programa
        model.addAttribute("programas", programaFacade.findBySpecificField("status", "1", "equal", null, null));

        return "/Organizaciones/altaAdminProyecto";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/gdaAltaOrganizacion.do")
    public String gdaAltaOrganizacion(@Valid Instancia instancia, BindingResult result, Model model, String confirma_password, String otra_colonia, String existe_colonia) {


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
            
            ///Convirtiendo a mayusculas
            instancia.setDomicilio(instancia.getDomicilio().toUpperCase());
            instancia.setNombre(instancia.getNombre().toUpperCase());
            instancia.setPuesto(instancia.getPuesto().toUpperCase());
            instancia.setRfc(instancia.getRfc().toUpperCase());
            instancia.setTitular(instancia.getTitular().toUpperCase());
            
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
            
            //Convirtiendo a mayusculas
            instancia.setDomicilio(instancia.getDomicilio().toUpperCase());
            instancia.setNombre(instancia.getNombre().toUpperCase());
            instancia.setPuesto(instancia.getPuesto().toUpperCase());
            instancia.setRfc(instancia.getRfc().toUpperCase());
            instancia.setTitular(instancia.getTitular().toUpperCase());
            
            instanciaFacade.create(instancia);
            System.out.println("Insercion correcta!");
            return "/Organizaciones/confirmaAdminRegOrganizacion";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/gdaAltaAdminProyecto.do")
    public String gdaAdminAltaProyecto(@Valid Proyectos proyecto, BindingResult result, Model model, String nActividades, String nPerfiles, String cadenaPerfiles, String cadenaActividades, boolean ningunPerfil) {
        System.out.println("hola admin gda alta organizacion");
        //Mexican Debugger
        try {
            System.out.println("Nombre:" + proyecto.getNombre());
        } catch (Exception e) {
            System.out.println("No hay nombre de proyecto");
        }
        try {
            System.out.println("No Vacantes:" + proyecto.getVacantes());
        } catch (Exception e) {
            System.out.println("No hay vacantes de proyecto");
        }
        try {
            System.out.println("Instancia:" + proyecto.getIdInstancia().getIdInstancia());
        } catch (Exception e) {
            System.out.println("No hay id de instancia");
        }
        try {
            System.out.println("Nombre responsable:" + proyecto.getNombreResponsable());
        } catch (Exception e) {
            System.out.println("No hay nombre de responsable");
        }
        try {
            System.out.println("Puesto responsable:" + proyecto.getResponsablePuesto());
        } catch (Exception e) {
            System.out.println("No hay nombre de responsable");
        }
        try {
            System.out.println("Telefono Responsable:" + proyecto.getTelefonoResponsable());
        } catch (Exception e) {
            System.out.println("No hay telefono del responsable");
        }
        try {
            System.out.println("Domicilio:" + proyecto.getDomicilio());
        } catch (Exception e) {
            System.out.println("No hay domicilio");
        }
        try {
            System.out.println("Colonia:" + proyecto.getIdColonia().getIdColonia());
        } catch (Exception e) {
            System.out.println("No hay colonia");
            model.addAttribute("error_codigo_postal", "Ingresar un código postal válido");
            result.addError(new ObjectError("codigo_postal", "Error en codigo postal"));
        }
        try {
            System.out.println("Tipo Proyecto:" + proyecto.getIdTipoProyecto().getIdTipoProyecto());
        } catch (Exception e) {
            System.out.println("No hay tipo de proyecto");
        }

        System.out.println("nPerfiles:" + nPerfiles.charAt(0));
        System.out.println("nActividades:" + nActividades.charAt(0));
        System.out.println("Perfiles:" + cadenaPerfiles);
        System.out.println("Actividades:" + cadenaActividades);

        //Desglose de perfiles
        if (!ningunPerfil) {
            //        ProyectoPerfilModel proyectoPerfilModel = new ProyectoPerfilModel(cadenaPerfiles);
            //Valida perfiles
//        if(!proyectoPerfilModel.validarInsercionProyectoPerfil().isSuccess()){
//            result.addError(new ObjectError("perfiles", proyectoPerfilModel.validarInsercionProyectoPerfil().getMensaje()));
//            model.addAttribute("validacion_perfiles", proyectoPerfilModel.validarInsercionProyectoPerfil().getMensaje());
//        }
        } else {
            System.out.println("No se agregaran perfiles");
        }


        //Desglose de Actividades
        ActividadesModel actividadesModel = new ActividadesModel(cadenaActividades);

        //Valida Actividades
        if (!actividadesModel.validarInsercionActividades().isSuccess()) {
            result.addError(new ObjectError("actividades", actividadesModel.validarInsercionActividades().getMensaje()));
        }
        model.addAttribute("validacion_actividades", actividadesModel.validarInsercionActividades().getMensaje());

        if (result.hasErrors()) {
            System.out.print("hubo errores");
            System.out.println(proyecto.toString());
            System.out.println("Error:" + result.toString());

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
            //Programa
            model.addAttribute("programas", programaFacade.findBySpecificField("status", "1", "equal", null, null));

            //return "redirect:altaAdminProyectos.do";
            return "/Organizaciones/altaAdminProyecto";
        } else {

            System.out.print("no hubo errores");
            proyecto.setValidacionAdmin(BigInteger.ONE);
            proyecto.setEstatus(BigInteger.ONE);
            proyecto.setFechaAlta(new Date());
            proyecto.setVacantesDisponibles(proyecto.getVacantes());
            
            //Convertir a mayuscular
            proyecto.setDomicilio(proyecto.getDomicilio().toUpperCase());
            proyecto.setNombre(proyecto.getNombre().toUpperCase());
            proyecto.setNombreResponsable(proyecto.getNombreResponsable().toUpperCase());
            proyecto.setResponsablePuesto(proyecto.getResponsablePuesto().toUpperCase());
            
            proyectosFacade.create(proyecto);
            System.out.println("Insercion correcta!");
            return "/Organizaciones/confirmaAltaAdminProyectos";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cargarPerfiles.do")
    public @ResponseBody
    PerfilJSON cargarPerfiles(Model model, String cp) {

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
    @RequestMapping(method = RequestMethod.POST, value = "/confirmaOrganizacionVisitante.do")
    public void confirmaOrganizacionVisitante(Model model, String instancia) {
        System.out.println("Id instancia:"+instancia);

        //return "/Organizaciones/editarOrganizacion";
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

    //Alta de organizacion por pre-registro
    @RequestMapping(method = RequestMethod.GET, value = "/pruebaFacade.do")
    public String pruebaFacade(Model model) {
        ConsultasOrganizaciones consulta = new ConsultasOrganizaciones();
        //model.addAttribute("organizaciones", consulta.getOrganizacionesPreRegistradas());
        return "/paginaPrueba";
    }
}
