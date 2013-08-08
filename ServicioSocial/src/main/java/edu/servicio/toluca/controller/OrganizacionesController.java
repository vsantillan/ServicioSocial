/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.EnviarCorreo;
import edu.servicio.toluca.beans.PerfilJSON;
import edu.servicio.toluca.beans.StringMD;
import edu.servicio.toluca.beans.organizaciones.BorrarInstancia;
import edu.servicio.toluca.beans.organizaciones.BorrarProyecto;
import edu.servicio.toluca.beans.organizaciones.ConsultasOrganizaciones;
import edu.servicio.toluca.beans.organizaciones.EditarOrganizacion;
import edu.servicio.toluca.entidades.Estados;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.Perfil;
import edu.servicio.toluca.entidades.ProyectoPerfil;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.sesion.ColoniaFacade;
import edu.servicio.toluca.sesion.EstadosFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.PerfilFacade;
import edu.servicio.toluca.sesion.ProgramaFacade;
import edu.servicio.toluca.sesion.ProyectoPerfilFacade;
import edu.servicio.toluca.sesion.ProyectosFacade;
import edu.servicio.toluca.sesion.TipoOrganizacionFacade;
import edu.servicio.toluca.sesion.TipoProyectoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;
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
    @EJB(mappedName = "java:global/ServicioSocial/ProyectoPerfilFacade")
    private ProyectoPerfilFacade proyectoPerfilFacade;
    @EJB(mappedName = "java:global/ServicioSocial/TipoProyectoFacade")
    private TipoProyectoFacade tipoProyectoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/EstadosSiaFacade")
    private EstadosSiaFacade estadosFacade;
    @EJB(mappedName = "java:global/ServicioSocial/ProgramaFacade")
    private ProgramaFacade programaFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/administrarOrganizaciones.do")
    public String administradorOrganizaciones(Model model)
    {
        List<Instancia> listaInstancias = instanciaFacade.findBySpecificField("estatus", "1", "equal", null, null);
        ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();
        for (int i = 0; i < listaInstancias.size(); i++) 
        {
            if ((listaInstancias.get(i).getValidacionAdmin() == BigInteger.ONE) || (listaInstancias.get(i).getValidacionAdmin() == BigInteger.valueOf(2)))
            {
                filtroInstancias.add(listaInstancias.get(i));
            }
        }        
        model.addAttribute("organizaciones", filtroInstancias);
        model.addAttribute("retroalimentacionInstancia", new BorrarInstancia());
        return "/Organizaciones/administrarOrganizaciones";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/administrarProyectos.do")
    public String administradorProyectos(Model model) 
    {
        List<Proyectos> listaProyectos = proyectosFacade.findBySpecificField("estatus", "1", "equal", null, null);
        ArrayList<Proyectos> filtroDeProyectos = new ArrayList<Proyectos>();
        for (int i = 0; i < listaProyectos.size(); i++) 
        {
            if (listaProyectos.get(i).getValidacionAdmin() == BigInteger.ONE)
            {
                filtroDeProyectos.add(listaProyectos.get(i));
            }
        }
        model.addAttribute("proyectos", filtroDeProyectos);
        model.addAttribute("retroalimentacionProyecto", new BorrarProyecto());
        return "/Organizaciones/administrarProyectos";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/validarOrganizaciones.do")
    public String panelAdministradorOrganizaciones(Model model) {
        model.addAttribute("organizacion", instanciaFacade.findBySpecificField("validacionAdmin", "0", "equal", null, null));
        model.addAttribute("retroalimentacionInstancia", new BorrarInstancia());
        return "/Organizaciones/validarOrganizaciones";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateStatus.do")
    public @ResponseBody
    String actualizarStatusOrganizaciones(int id, Model model) {
        Instancia instancia;
        instancia = instanciaFacade.find(BigDecimal.valueOf(id));
        instancia.setValidacionAdmin(BigInteger.valueOf(1));
        System.out.println("Ya actualizo");
        // instanciaFacade.edit(instancia);

        return "ok";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateProyecto.do")
    public @ResponseBody
    String actualizarStatusProyecto(int id, Model model) {
        Proyectos proyecto;
        proyecto = proyectosFacade.find(BigDecimal.valueOf(id));
        proyecto.setValidacionAdmin(BigInteger.valueOf(1));
        // proyectosFacade.edit(proyecto);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/validarProyectos.do")
    public String panelAdministradorProyectos(Model model) {
        model.addAttribute("proyecto", proyectosFacade.findBySpecificField("validacionAdmin", "0", "equal", null, null));
        model.addAttribute("borrarProyecto", new BorrarProyecto());
        return "/Organizaciones/validarProyectos";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/retroalimentacionInstancia.do")
    public String retroalimentacionInstancia(int id, Model model) {
        model.addAttribute("instancia", instanciaFacade.find(BigDecimal.valueOf(id)));
        model.addAttribute("retroalimentacionInstancia", new BorrarInstancia());
        return "/Organizaciones/retroalimentacionInstancia";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/retroalimentacionProyecto.do")
    public String retoalimentacionProyectos(int id, Model model) {
        model.addAttribute("proyectos", proyectosFacade.find(BigDecimal.valueOf(id)));
        model.addAttribute("borrarProyecto", new BorrarProyecto());
        return "/Organizaciones/retroalimentacionProyectos";
    }

    //Panel de organizaciones (usuarios)
    @RequestMapping(method = RequestMethod.GET, value = "/panelOrganizacion.do")
    public String panelOrganizacion(Model a) {
        return "/PanelOrganizacion/panelOrganizacion";
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

    @RequestMapping(method = RequestMethod.GET, value = "/mensajeOrganizacion.do")
    public String mensajeOrganizacion(Model a) {
        return "/Organizaciones/mensajeOrganizacion";
    }

    //Editar Organizacion
    @RequestMapping(method = RequestMethod.GET, value = "/editarOrganizacion.do")
    public String editarOrganizacion(int id, Model model) 
    {
        model.addAttribute("instancia", instanciaFacade.find(BigDecimal.valueOf(id)));
        model.addAttribute("instanciaDireccion", instanciaFacade.find(BigDecimal.valueOf(id)));
        model.addAttribute("estados", estadosFacade.findAll());
        model.addAttribute("tipoOrganizaciones", tipoOrganizacionFacade.findBySpecificField("estatus", "1", "equal", null, null));
        return "/Organizaciones/editarOrganizacion";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/modificarOrganizacion.do")
    public String modificarOrganizacion(@Valid Instancia instancia,BindingResult result,Model model,String confirma_password,int valid_pass)
    {
        System.out.println("contraseña:" + instancia.getPassword());
        System.out.println("confirma_contraseña:" + confirma_password);

        if(valid_pass==1)
        {
            if (!confirma_password.equals(instancia.getPassword())) 
            {
                result.addError(new ObjectError("confirma_passowrd", "Las contraseñas no coinciden"));
                model.addAttribute("confirma_password", "<div class='error'>Las contraseñas no coinciden</div><script>document.getElementById('cambiaPass').style.display = 'block';</script>");
            }
        }
        
        if(result.hasErrors())
        {
            System.out.println("Con errores");
            System.out.println("Los errores son: "+result.toString());
            model.addAttribute("instanciaDireccion", instanciaFacade.find(instancia.getIdInstancia()));
            model.addAttribute("estados", estadosFacade.findAll());
            model.addAttribute("tipoOrganizaciones", tipoOrganizacionFacade.findBySpecificField("estatus", "1", "equal", null, null));
            return "/Organizaciones/editarOrganizacion";
            
        }else{
            instanciaFacade.edit(instancia);
            System.out.println("Sin errores");
            //System.out.println(editaOrganizacion.getEstatus());
            model.addAttribute("organizaciones", instanciaFacade.findAll());
            model.addAttribute("retroalimentacionInstancia", new BorrarInstancia());
            return "/Organizaciones/administrarOrganizaciones";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editarProyecto.do")
    public String editarProyectos(int id,Model model)
    {
        Proyectos proyecto=proyectosFacade.find(BigDecimal.valueOf(id));
        model.addAttribute("proyecto", proyecto);
        List<Instancia> listaInstancias = instanciaFacade.findBySpecificField("estatus", "1", "equal", null, null);
        ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();
        for (int i = 0; i < listaInstancias.size(); i++) {
            if (listaInstancias.get(i).getValidacionAdmin() == BigInteger.ONE) {
                filtroInstancias.add(listaInstancias.get(i));
            }
        }        
        model.addAttribute("instancia", filtroInstancias);
        model.addAttribute("estados", estadosFacade.findAll());
        model.addAttribute("perfil", perfilFacade.findBySpecificField("estatus", "1", "equal", null, null));
        model.addAttribute("tipoProyecto", tipoProyectoFacade.findBySpecificField("status", "1", "equal", null, null));
        model.addAttribute("programas", programaFacade.findBySpecificField("status", "1", "equal", null, null));
        List<Perfil> perfilesNoSonDelProyecto = new ArrayList<Perfil>();
        List<Perfil> listaPerfil;
        Iterator<ProyectoPerfil> iteratorProyectosPerfilCollection;
        listaPerfil=perfilFacade.findAll();
        boolean agregar;
        String nombrePerfilCollection;
        for(int i=0;i<listaPerfil.size();i++)
        {
            agregar=true;
            iteratorProyectosPerfilCollection=proyectosFacade.find(BigDecimal.valueOf(id)).getProyectoPerfilCollection().iterator();
            while(iteratorProyectosPerfilCollection.hasNext())
            {
                nombrePerfilCollection=iteratorProyectosPerfilCollection.next().getIdPerfil().getNombre();
                if(!listaPerfil.get(i).getNombre().equals(nombrePerfilCollection) && agregar)
                    agregar=true;
                else
                    agregar=false;
            }
            if(agregar)
                perfilesNoSonDelProyecto.add(listaPerfil.get(i));
        }
        model.addAttribute("perfilesProyectoEx", perfilesNoSonDelProyecto);
        return "/Organizaciones/editarProyecto";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/modificarProyecto.do")
    public String modificarProyecto(@Valid Proyectos proyecto,BindingResult  result, Model model, String selectfrom)
    {
        proyecto.setFechaAlta(new Date());
        System.out.println("select de perfiles "+selectfrom);
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
        
        if(result.hasErrors())
        {
            System.out.println("Con errores");
            System.out.println("Los errores son: "+result.toString());
            //model.addAttribute("proyecto", proyectosFacade.find(proyecto.getIdProyecto()));
            model.addAttribute("proyectoAux", proyectosFacade.find(proyecto.getIdProyecto()));
            model.addAttribute("instancia", instanciaFacade.findAll());
            model.addAttribute("estados", estadosFacade.findAll());
            //model.addAttribute("perfil", perfilFacade.findAll());
            model.addAttribute("tipoProyecto", tipoProyectoFacade.findBySpecificField("status", "1", "equal", null, null));
            //model.addAttribute("proyectos", proyectosFacade.findAll());
            return "/Organizaciones/editarProyecto";
        }else{
            
            List<ProyectoPerfil> listaProyectosPerfil=proyectoPerfilFacade.findBySpecificField("idProyecto", proyecto, "equal", null, null);
            Iterator<ProyectoPerfil> recorreProyectosPerfil=listaProyectosPerfil.iterator();
            while(recorreProyectosPerfil.hasNext())
            {
                ProyectoPerfil borrarPerfilDeProyecto;
                borrarPerfilDeProyecto=recorreProyectosPerfil.next();
                proyectoPerfilFacade.remove(borrarPerfilDeProyecto);
            }
            if(selectfrom!=null)
            {
                List<String> listaIds=new ArrayList<String>();
                StringTokenizer palabra=new StringTokenizer(selectfrom,",");
                while(palabra.hasMoreTokens())
                {
                    listaIds.add(palabra.nextToken());
                }
                Iterator inserta=listaIds.iterator();
                while(inserta.hasNext())
                {
                    ProyectoPerfil proyectoPerfil=new ProyectoPerfil();
                    proyectoPerfil.setIdPerfil(perfilFacade.find(BigDecimal.valueOf(Integer.parseInt(inserta.next().toString())))); //Perfil
                    proyectoPerfil.setIdProyecto(proyecto); //Proyecto
                    proyectoPerfilFacade.create(proyectoPerfil);
                }
            }
            proyectosFacade.edit(proyecto);
            System.out.println("Sin errores");
            model.addAttribute("proyectos", proyectosFacade.findAll());
            model.addAttribute("retroalimentacionProyecto", new BorrarProyecto());
            return "/Organizaciones/administrarProyectos";
        }
    }

    //Borrar Organizacion & Proyecto
    @RequestMapping(method = RequestMethod.POST, value = "/borrarInstancia.do")
    public @ResponseBody
    String borrarInstancia(BorrarInstancia retroalimentacionInstancia, BindingResult resultado) {
        if (resultado.hasErrors()) {
            for (ObjectError error : resultado.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "<script>alert('¡Error al intentar enviar!, verifica los datos')</script>";
        } else {
           // EnviarCorreo correo = new EnviarCorreo("alguien@gmail.com", retroalimentacionInstancia.getCorreo(), retroalimentacionInstancia.getDescripcion(), "Servicio Social", "pass");
            Instancia instancia;
            instancia = instanciaFacade.find(BigDecimal.valueOf(retroalimentacionInstancia.getId()));
//            instancia.setEstatus(BigInteger.valueOf(0));
            if (retroalimentacionInstancia.getControl() == 0) {
                instancia.setEstatus(BigInteger.valueOf(0));
                instanciaFacade.edit(instancia);
                return "<script>"
                        + "alert('¡Correo enviado exitosamente a: " + retroalimentacionInstancia.getCorreo() + "!');"
                        + "location.href='administrarOrganizaciones.do';"
                        + "</script>";
            } else {
                instancia.setValidacionAdmin(BigInteger.valueOf(2));
                instanciaFacade.edit(instancia);
             // correo.enviaCorreo();
                return "<script>"
                        + "alert('¡Correo enviado exitosamente a: " + retroalimentacionInstancia.getCorreo() + "!');"
                        + "location.href='validarOrganizaciones.do';"
                        + "</script>";
            }




        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/borrarProyecto.do")
    public @ResponseBody
    String borrarProyecto(BorrarProyecto retroalimentacionProyecto, BindingResult resultado) {
        if (resultado.hasErrors()) {
            for (ObjectError error : resultado.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "<script>alert('¡Error al intentar enviar!, verifica los datos')</script>";
        } else {
         // EnviarCorreo correo = new EnviarCorreo("alguien@gmail.com", retroalimentacionInstancia.getCorreo(), retroalimentacionInstancia.getDescripcion(), "Servicio Social", "pass");
            Proyectos proyecto;
            proyecto = proyectosFacade.find(BigDecimal.valueOf(retroalimentacionProyecto.getId()));

            if (retroalimentacionProyecto.getControl() == 0) {
                proyecto.setEstatus(BigInteger.valueOf(0));
                proyectosFacade.edit(proyecto);
                return "<script>alert('¡Correo enviado exitosamente a: " + retroalimentacionProyecto.getEmail() + "!');"
                        + "location.href='administrarProyectos.do';"
                        + "</script>";
            } else {
                proyecto.setValidacionAdmin(BigInteger.valueOf(2));
                proyectosFacade.edit(proyecto);
             // correo.enviaCorreo();
                return "<script>alert('¡Correo enviado exitosamente a: " + retroalimentacionProyecto.getEmail() + "!');"
                        + "location.href='validarProyectos.do';"
                        + "</script>";
            }

        }
    }

    //Alta Organizaicon visitante
    @RequestMapping(method = RequestMethod.POST, value = "/gdaAltaOrganizacionVisitante.do")
    public String gdaOrganizacionVisitante(Model a) {


        return "/Organizaciones/editarOrganizacion";
    }
}
