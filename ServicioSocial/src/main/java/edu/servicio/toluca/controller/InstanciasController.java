/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.servicio.toluca.controller;

import edu.servicio.toluca.entidades.Actividades;
import edu.servicio.toluca.entidades.Colonia;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.Perfil;
import edu.servicio.toluca.entidades.Programa;
import edu.servicio.toluca.entidades.ProyectoPerfil;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.entidades.TipoOrganizacion;
import edu.servicio.toluca.entidades.TipoProyecto;
import edu.servicio.toluca.entidades.UsuarioInstancia;
import edu.servicio.toluca.sesion.ActividadesFacade;
import edu.servicio.toluca.sesion.ColoniaFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.PerfilFacade;
import edu.servicio.toluca.sesion.ProgramaFacade;
import edu.servicio.toluca.sesion.ProyectoPerfilFacade;
import edu.servicio.toluca.sesion.ProyectosFacade;
import edu.servicio.toluca.sesion.TipoOrganizacionFacade;
import edu.servicio.toluca.sesion.TipoProyectoFacade;
import edu.servicio.toluca.sesion.UsuarioInstanciaFacade;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author giovanni
 */
@Controller
public class InstanciasController
{
    @EJB(mappedName = "java:global/ServicioSocial/TipoOrganizacionFacade")
    private TipoOrganizacionFacade tipoOrgFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/ColoniaFacade")
    private ColoniaFacade coloniaFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
    private InstanciaFacade instanciaFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/ProyectosFacade")
    private ProyectosFacade proyectosFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/TipoProyectoFacade")
    private TipoProyectoFacade tiposPFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/PerfilFacade")
    private PerfilFacade perfilFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/ProgramaFacade")
    private ProgramaFacade programaFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/ActividadesFacade")
    private ActividadesFacade actividadesFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/ProyectoPerfilFacade")
    private ProyectoPerfilFacade pPerfilFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/UsuarioInstanciaFacade")
    private UsuarioInstanciaFacade usuarioInstanciaFacade;
    
    @RequestMapping( value="verificarinstancia.do", method=RequestMethod.GET )
    public String verificarInstancia(Model model)
    {
        return "/Instancias/verificarInstancia";
    }
    
    @RequestMapping( value="preregistrarinstancia.do", method=RequestMethod.GET)
    public String preregistro(HttpSession session, Model model)
    {
        String rol = null;
        if(session.getAttribute("ROL") != null)
        {
            rol = session.getAttribute("ROL").toString();
        }
        
        if(rol != null && rol.equals("ORGANIZACION"))
        {
            List<TipoOrganizacion> tiposOrg = tipoOrgFacade.findAll();
            Instancia nvaInstancia = new Instancia();
            nvaInstancia.setTipoOrganizacion(tiposOrg.get(0)); // Default in radio buttons

            model.addAttribute("tiposOrganizacion", tiposOrg);
            model.addAttribute("instancia", nvaInstancia);
            model.addAttribute("rfcError", "");

            return "/Instancias/preregistro";
        }
        else
        {
            return preregUsuarioInstancia(model);
        }
        
    }
    
    @RequestMapping( value="preregistrarinstancia.do", method=RequestMethod.POST)
    public String preregistrar(Model model, @Valid Instancia instancia, 
            BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()) // Showing error in form
        {
            List<TipoOrganizacion> tiposOrg = tipoOrgFacade.findAll();
            model.addAttribute("tiposOrganizacion", tiposOrg);
            
            return "/Instancias/preregistro";
        }
        else
        {
            // Check if instance is yet registered
            List<Instancia> instancias = 
                    instanciaFacade.findBySpecificField("rfc", instancia.getRfc().toUpperCase(), "equal", null, null);
            if(instancias.size() > 0)
            {
                String rfcError = "<div class='alert alert-danger'>Este RFC ya está registrado</div>";
                List<TipoOrganizacion> tiposOrg = tipoOrgFacade.findAll();
                model.addAttribute("tiposOrganizacion", tiposOrg);
                model.addAttribute("rfcError", rfcError);

                return "/Instancias/preregistro";
            }
            else
            {
                // Configurar Entity y persistir
                Colonia col = coloniaFacade.find(instancia.getIdColonia().getIdColonia());
                instancia.setIdColonia(col);

                TipoOrganizacion tipoOrg = tipoOrgFacade.find(
                        instancia.getTipoOrganizacion().getIdTipoOrganizacion());
                instancia.setTipoOrganizacion(tipoOrg);

                // To UpperCase
                instancia.setNombre(instancia.getNombre().toUpperCase());
                instancia.setRfc(instancia.getRfc().toUpperCase());
                instancia.setStatus((short) 0);
                
                // Asignar usuario a instancia
                UsuarioInstancia uInstancia = usuarioInstanciaFacade.findAll().get(0);
                instancia.setUsuarioInstancia(uInstancia);

                instanciaFacade.create(instancia);

                return "/Instancias/preregistroexitoso";
            }
        }
    }
    
    @RequestMapping( value="buscarinstancias.do", method=RequestMethod.GET )
    public @ResponseBody List<HashMap> buscarInstancias(Model model, String field, String value)
    {
        List<Instancia> resultado = (field.equals("rfc")) ? 
                instanciaFacade.findBySpecificField("rfc", value, "like", null, null) : 
                instanciaFacade.findBySpecificField("nombre", value, "like", null, null);
        
        List<HashMap> instancias = new ArrayList<HashMap>();
        for(Instancia instancia : resultado)
        {
            HashMap mapa = new HashMap();
            mapa.put("nombre", instancia.getNombre());
            mapa.put("email", instancia.getUsuarioInstancia().getEmail());
            mapa.put("titular", instancia.getUsuarioInstancia().getNombre() + " " + instancia.getUsuarioInstancia().getApellidoPat());
            mapa.put("rfc", instancia.getRfc());
            
            instancias.add(mapa);
        }
        
        return instancias;
    }
    
    /* --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- */
    /* --- --- --- --- --- --- USUARIOS -- --- --- --- --- --- --- --- --- --- */
    
    @RequestMapping( value="preregistrarusuario.do", method=RequestMethod.GET)
    public String preregUsuarioInstancia(Model model)
    {
        return "/UsuarioInstancia/preregusuario";
    }
    
    
    /* --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- */
    /* --- --- --- --- --- --- PROYECTOS   --- --- --- --- --- --- --- --- --- */
    
    @RequestMapping( value="registrarproyecto.do", method=RequestMethod.GET )
    public String registrarProyecto(Model model)
    {
        Proyectos proyecto = new Proyectos();
        List<TipoProyecto> tiposP = tiposPFacade.findAll();
        List<String> modalidades = new ArrayList<String>();
        modalidades.add("INTERNO");
        modalidades.add("EXTERNO");
        
        List<Perfil> perfiles = perfilFacade.findAll();
        List<Programa> programas = programaFacade.findAll();
        
        model.addAttribute("proyecto", proyecto);
        model.addAttribute("tiposP", tiposP);
        model.addAttribute("modalidades", modalidades);
        model.addAttribute("perfiles", perfiles);
        model.addAttribute("perfilesproyecto", "");
        model.addAttribute("programas", programas);
        model.addAttribute("codigop", "");
        
        return "/Instancias/regproyecto";
    }
    
    @RequestMapping( value="registrarproyecto.do", method=RequestMethod.POST )
    public String insertarProyecto(HttpSession session, String actividad1, String actividad2, String actividad3,
            String actividad4, String actividad5, String cp, String perfilesproyecto,
            Model model,@ModelAttribute("proyecto") @Valid Proyectos proyecto, BindingResult bindingResult)
    {
        
        if(bindingResult.hasErrors() || perfilesproyecto.length() < 1)
        {
            List<TipoProyecto> tiposP = tiposPFacade.findAll();
            List<String> modalidades = new ArrayList<String>();
            modalidades.add("INTERNO");
            modalidades.add("EXTERNO");

            List<Perfil> perfiles = perfilFacade.findAll();
            List<Programa> programas = programaFacade.findAll();

            model.addAttribute("tiposP", tiposP);
            model.addAttribute("modalidades", modalidades);
            model.addAttribute("perfiles", perfiles);
            model.addAttribute("programas", programas);
            model.addAttribute("codigop", cp);
            
            model.addAttribute("actividad1", actividad1);
            model.addAttribute("actividad2", actividad2);
            model.addAttribute("actividad3", actividad3);
            model.addAttribute("actividad4", actividad4);
            model.addAttribute("actividad5", actividad5);
            
            model.addAttribute("perfilesproyecto", perfilesproyecto);
            
            if(perfilesproyecto.length() < 1)
            {
                model.addAttribute("errorperfiles", "<div class='alert alert-danger'>Agrege al menos un perfil al proyecto</div>");
            }

            return "/Instancias/regproyecto";
        }
        else
        {
          // Formatear datos de la instancia
            proyecto.setNombre(proyecto.getNombre().toUpperCase());
            proyecto.setNombreResponsable(proyecto.getNombreResponsable().toUpperCase());
            proyecto.setResponsablePuesto(proyecto.getResponsablePuesto().toUpperCase());
            proyecto.setDomicilio(proyecto.getDomicilio().toUpperCase());
            proyecto.setEstatus(BigInteger.valueOf(2L));
            proyecto.setValidacionAdmin(BigInteger.ZERO);
            proyecto.setFechaAlta(Calendar.getInstance().getTime());
            proyecto.setVacantesDisponibles(proyecto.getVacantes());
            
            if(proyecto.getModalidad().trim().equals("INTERNO"))
            {
                proyecto.setModalidad("I");
            }
            else
            {
                proyecto.setModalidad("E");
            }
            
            proyecto.setIdTipoProyecto(tiposPFacade.find(proyecto.getIdTipoProyecto().getIdTipoProyecto()));
            proyecto.setIdPrograma(programaFacade.find(proyecto.getIdPrograma().getIdPrograma()));
            proyecto.setIdColonia(coloniaFacade.find(proyecto.getIdColonia().getIdColonia()));
            
            Instancia instance = instanciaFacade.findBySpecificField("nombre", session.getAttribute("NOMBRE").toString(), "equal", null, null).get(0);
            //System.out.println("SE ENCONTRO INSTANCIA: " + instance.getNombre());
            proyecto.setIdInstancia(instance);
            proyectosFacade.create(proyecto);
            
          // Registrar perfiles
            StringTokenizer stPerfiles = new StringTokenizer(perfilesproyecto, ";");
            while(stPerfiles.hasMoreTokens())
            {
                Perfil perfil = perfilFacade.findBySpecificField("nombre", stPerfiles.nextToken().trim(), "equal", null, null).get(0);
                //System.out.println("Perfil encontrado: " + perfil.getNombre());
                ProyectoPerfil pPerfil = new ProyectoPerfil();
                pPerfil.setIdPerfil(perfil);
                pPerfil.setIdProyecto(proyecto);
                pPerfilFacade.create(pPerfil);
            }
            
          // Registrar actividades
            Actividades actividad01 = new Actividades();
            Actividades actividad02 = new Actividades();
            
            actividad01.setIdProyecto(proyecto);
            actividad01.setEstatus(BigInteger.ONE);
            actividad01.setDetalle(actividad1);
            actividadesFacade.create(actividad01);
            
            actividad02.setIdProyecto(proyecto);
            actividad02.setEstatus(BigInteger.ONE);
            actividad02.setDetalle(actividad2);
            actividadesFacade.create(actividad02);
            
            if(actividad3.trim().length() > 0)
            {
                Actividades actividad03 = new Actividades();
                actividad03.setIdProyecto(proyecto);
                actividad03.setEstatus(BigInteger.ONE);
                actividad03.setDetalle(actividad3);
                actividadesFacade.create(actividad03);
            }
            if(actividad4.trim().length() > 0)
            {
                Actividades actividad04 = new Actividades();
                actividad04.setIdProyecto(proyecto);
                actividad04.setEstatus(BigInteger.ONE);
                actividad04.setDetalle(actividad4);
                actividadesFacade.create(actividad04);
            }
            if(actividad5.trim().length() > 0)
            {
                Actividades actividad05 = new Actividades();
                actividad05.setIdProyecto(proyecto);
                actividad05.setEstatus(BigInteger.ONE);
                actividad05.setDetalle(actividad5);
                actividadesFacade.create(actividad05);
            }
            
            return "/Instancias/proyectoregistrado";
        }
        
    }
    
    @RequestMapping( value="instanciaproyectos.do", method=RequestMethod.GET)
    public String administrarProyectos(HttpSession session, Model model)
    {
        if(session.getAttribute("NOMBRE") != null)
        {
            Instancia instancia;
            String instanciaNom = session.getAttribute("NOMBRE").toString();
            
            instancia = instanciaFacade.findBySpecificField("nombre", 
                    instanciaNom, "equal", null, null).get(0);
            
            if(instancia != null)
            {
                return "/Instancias/administrarproyectos";
            }
        }
        
        return "/NavegacionPrincipal/index";
    }
}