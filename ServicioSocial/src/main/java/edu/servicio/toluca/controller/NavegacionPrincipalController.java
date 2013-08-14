/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

/**
 *
 * @author bustedvillain
 */

import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.login.Login;
import edu.servicio.toluca.sesion.CodigosPostalesFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.TipoOrganizacionFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    
    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    public VistaAlumnoFacade vistaAlumnoFacade;
    
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
    
    @RequestMapping(method = RequestMethod.POST, value = "/validaLogin.do")
    public String validaLogin(Model model, String usuario, String pass){
        System.out.println("Usuario:"+ usuario);
        System.out.println("Pass:"+pass);    
        
        if(usuario.equals("") || pass.equals("")){
            model.addAttribute("error", "<div class='error'>Datos de acceso inválidos</div>");
            return "/NavegacionPrincipal/loginPrincipal";
        }
        try{
            String rol= new Login().ValidarUsuario(usuario, pass);
            System.out.println("rol:"+rol);
            
            //ALUMNOS
            if(rol.equals("ROLE_ALUMNOS")){
                System.out.println("buscar:"+usuario.substring(4));
                List<VistaAlumno> alumno = vistaAlumnoFacade.findBySpecificField("id", usuario.substring(4), "equal", null, null);
                System.out.println("tamaño lista:"+alumno.size());
                Double porcentaje= Double.parseDouble(alumno.get(0).getPorcentaje());
                System.out.println("Porcentaje del alumno:"+porcentaje);
                if( porcentaje >= 70){
                    return "redirect:panelUsuario.do";
                }else{
                    model.addAttribute("error", "<div class='error'>Lo sentimos no cumples con el minimo de 70% de créditos para tramitar tu servicio social</div>");
                    return "/NavegacionPrincipal/loginPrincipal";
                }                
            }
            //JOELITO
            if(rol.equals("ROLE_GESVIN_OPERACION")){
                return "redirect:panelAdministrador.do";
            }
            //DIRECTIVOS
            if(rol.equals("ROLE_GESVIN_CONSULTAS")){
                
            }
            //BACKDOOR
            if(rol.equals("ROLE_GESVIN_ADMIN")){
                
            }
            //ASISTENTE
            if(rol.equals("ROLE_GESVIN_REGISTRO")){
                
            }
            //OTRO
            if(rol.equals("OTRO")){
              model.addAttribute("error", "<div class='error'>Lo sentimos no tiene los permisos necesarios para accesar al sistema.</div>");  
            }
             
            return "/NavegacionPrincipal/loginPrincipal";
            
        }catch(Exception e) {
            System.out.println(e.toString());
            System.out.println("Error al conectar!");
            model.addAttribute("error", "<div class='error'>Usuario o contraseña incorrecta</div>");
            
            return "/NavegacionPrincipal/loginPrincipal";
        }        
        
    }
}
