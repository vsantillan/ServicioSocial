/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.StringMD;
import edu.servicio.toluca.dao.GenericDao;
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
import org.springframework.beans.factory.annotation.Autowired;
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

    private GenericDao<TipoOrganizacion> daoTipoOrganizacion;
    private GenericDao<Colonia> daoColonia;
    private GenericDao<Instancia> daoInstancia;
    private GenericDao<Proyectos> daoProyectos;
    private GenericDao<TipoProyecto> daoTipoProyecto;
    private GenericDao<Perfil> daoPerfil;
    private GenericDao<Programa> daoPrograma;
    private GenericDao<Actividades> daoActividades;
    private GenericDao<ProyectoPerfil> daoProyectoPerfil;
    private GenericDao<UsuarioInstancia> daoUsuarioInstancia;

    // <editor-fold defaultstate="collapsed" desc="EJB Facades">
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
    // </editor-fold>

    @Autowired
    public void setDaoUsuarioInstancia(GenericDao<UsuarioInstancia> daoUsuarioInstancia)
    {
        this.daoUsuarioInstancia = daoUsuarioInstancia;
        daoUsuarioInstancia.setClass(UsuarioInstancia.class);
    }

    @Autowired
    public void setDaoColonia(GenericDao<Colonia> daoColonia)
    {
        this.daoColonia = daoColonia;
        daoColonia.setClass(Colonia.class);
    }

    @Autowired
    public void setDaoInstancia(GenericDao<Instancia> daoInstancia)
    {
        this.daoInstancia = daoInstancia;
        daoInstancia.setClass(Instancia.class);
    }

    @Autowired
    public void setDaodaoTipoProyecto(GenericDao<TipoProyecto> daoTipoProyecto)
    {
        this.daoTipoProyecto = daoTipoProyecto;
        daoTipoProyecto.setClass(TipoProyecto.class);
    }

    @Autowired
    public void setDaoPerfil(GenericDao<Perfil> daoPerfil)
    {
        this.daoPerfil = daoPerfil;
        daoPerfil.setClass(Perfil.class);
    }

    @Autowired
    public void setDaoPrograma(GenericDao<Programa> daoPrograma)
    {
        this.daoPrograma = daoPrograma;
        daoPrograma.setClass(Programa.class);
    }

    @Autowired
    public void setDaoActividades(GenericDao<Actividades> daoActividades)
    {
        this.daoActividades = daoActividades;
        daoActividades.setClass(Actividades.class);
    }

    @Autowired
    public void setDaoProyectoPerfil(GenericDao<ProyectoPerfil> daoProyectoPerfil)
    {
        this.daoProyectoPerfil = daoProyectoPerfil;
        daoProyectoPerfil.setClass(ProyectoPerfil.class);
    }

    @Autowired
    public void setDaoTipoOrganizacion(GenericDao<TipoOrganizacion> daoTipoOrganizacion)
    {
        this.daoTipoOrganizacion = daoTipoOrganizacion;
        daoTipoOrganizacion.setClass(TipoOrganizacion.class);
    }

    @RequestMapping(value = "verificarinstancia.do", method = RequestMethod.GET)
    public String verificarInstancia(Model model)
    {
        return "/Instancias/verificarInstancia";
    }

    @RequestMapping(value = "preregistrarinstancia.do", method = RequestMethod.GET)
    public String preregistro(HttpSession session, Model model)
    {
        String rol = null;
        if (session.getAttribute("ROL") != null)
        {
            rol = session.getAttribute("ROL").toString();
        }

        if (rol != null && rol.equals("ORGANIZACION"))
        {
            List<TipoOrganizacion> tiposOrg = daoTipoOrganizacion.findAll();
            Instancia nvaInstancia = new Instancia();
            nvaInstancia.setTipoOrganizacion(tiposOrg.get(0)); // Default in radio buttons

            model.addAttribute("tiposOrganizacion", tiposOrg);
            model.addAttribute("instancia", nvaInstancia);
            model.addAttribute("rfcError", "");

            return "/Instancias/preregistro";
        } else
        {
            return preregUsuarioInstancia(model);
        }

    }

    @RequestMapping(value = "preregistrarinstancia.do", method = RequestMethod.POST)
    public String preregistrar(HttpSession session, Model model,
            @Valid Instancia instancia, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) // Showing error in form
        {
            List<TipoOrganizacion> tiposOrg = daoTipoOrganizacion.findAll();
            model.addAttribute("tiposOrganizacion", tiposOrg);

            return "/Instancias/preregistro";
        } else
        {
            // Check if instance is yet registered
            List<Instancia> instancias
                    = daoInstancia.findBySpecificField("rfc", instancia.getRfc().toUpperCase(), "equal", null, null);
            if (instancias.size() > 0)
            {
                String rfcError = "<div class='alert alert-danger'>Este RFC ya está registrado</div>";
                List<TipoOrganizacion> tiposOrg = daoTipoOrganizacion.findAll();
                model.addAttribute("tiposOrganizacion", tiposOrg);
                model.addAttribute("rfcError", rfcError);

                return "/Instancias/preregistro";
            } else
            {
                // Configurar Entity y persistir
                Colonia col = (Colonia) daoColonia.find(instancia.getIdColonia().getIdColonia());
                instancia.setIdColonia(col);

                TipoOrganizacion tipoOrg = (TipoOrganizacion) daoTipoOrganizacion.find(
                        instancia.getTipoOrganizacion().getIdTipoOrganizacion());
                instancia.setTipoOrganizacion(tipoOrg);

                // To UpperCase
                instancia.setNombre(instancia.getNombre().toUpperCase());
                instancia.setRfc(instancia.getRfc().toUpperCase());
                instancia.setStatus((short) 0);

                // Obtener usuario al que pertenecera la instancia
                String email = session.getAttribute("EMAIL").toString();
                List<UsuarioInstancia> usuarios = daoUsuarioInstancia
                        .findBySpecificField("email", email, "equal", null, null);
                if (usuarios.size() > 0)
                {
                    instancia.setUsuarioInstancia(usuarios.get(0));
                }

                daoInstancia.create(instancia);

                return "/Instancias/preregistroexitoso";
            }
        }
    }

    @RequestMapping(value = "buscarinstancias.do", method = RequestMethod.GET)
    public @ResponseBody
    List<HashMap> buscarInstancias(Model model, String field, String value)
    {
        List<Instancia> resultado = (field.equals("rfc"))
                ? daoInstancia.findBySpecificField("rfc", value, "like", null, null)
                : daoInstancia.findBySpecificField("nombre", value, "like", null, null);

        List<HashMap> instancias = new ArrayList<HashMap>();
        for (Instancia instancia : resultado)
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

    /*
     * --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---
     */
    /*
     * --- --- --- --- --- --- USUARIOS -- --- --- --- --- --- --- --- --- ---
     */
    @RequestMapping(value = "preregistrarusuario.do", method = RequestMethod.GET)
    public String preregUsuarioInstancia(Model model)
    {
        model.addAttribute("usuarioInstancia", new UsuarioInstancia());

        return "/UsuarioInstancia/preregusuario";
    }

    @RequestMapping(value = "registrarUsuario.do", method = RequestMethod.POST)
    public String registrarUsuario(HttpSession session, @Valid UsuarioInstancia usuarioInstancia,
            BindingResult bindingResult, Model model)
    {

        if (bindingResult.hasErrors())
        {
            if (usuarioInstancia.getExtension().length() > 0)
            {
                for (char c : usuarioInstancia.getExtension().toCharArray())
                {
                    try
                    {
                        Integer.parseInt(c + "");
                    } catch (NumberFormatException err)
                    {
                        model.addAttribute("errorExt", "<div class='alert alert-danger'>Ingrese solo números o deje vacio el campo</div>");
                    }
                }
            }
            return "/UsuarioInstancia/preregusuario";
        }

        if (usuarioInstancia.getExtension().length() > 0)
        {
            for (char c : usuarioInstancia.getExtension().toCharArray())
            {
                try
                {
                    Integer.parseInt(c + "");
                } catch (NumberFormatException err)
                {
                    model.addAttribute("errorExt", "<div class='alert alert-danger'>Ingrese solo números o deje vacio el campo</div>");
                    return "/UsuarioInstancia/preregusuario";
                }
            }
        }

        // Verificar si el email ya ha sido registrado con otro usuario
        List<UsuarioInstancia> usuarios = daoUsuarioInstancia
                .findBySpecificField("email", usuarioInstancia.getEmail().toLowerCase(), "equal", null, null);
        List<UsuarioInstancia> usuarios2 = daoUsuarioInstancia.findBySpecificField(
                "email", usuarioInstancia.getEmail().toLowerCase(), "equal", null, null);

        if (usuarios2.size() > 0)
        {
            model.addAttribute("useryetexist", "<div class='alert alert-danger'>Este correo electrónico ya ha sido registrado.</div>");
            return "/UsuarioInstancia/preregusuario";
        }

        // Formatear datos a UPPERCASE y registrar usuario
        usuarioInstancia.setNombre(usuarioInstancia.getNombre().toUpperCase());
        usuarioInstancia.setApellidoPat(usuarioInstancia.getApellidoPat().toUpperCase());
        usuarioInstancia.setApellidoMat(usuarioInstancia.getApellidoMat().toUpperCase());
        usuarioInstancia.setEmail(usuarioInstancia.getEmail().toLowerCase());
        usuarioInstancia.setPassword(StringMD.getStringMessageDigest(usuarioInstancia.getPassword(), StringMD.SHA1));
        usuarioInstancia.setStatus(Short.valueOf("0"));

//        usuarioInstanciaFacade.create(usuarioInstancia);
        daoUsuarioInstancia.create(usuarioInstancia);

        return "/UsuarioInstancia/preregusuexitoso";
    }

    /*
     * --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---
     */
    /*
     * --- --- --- --- --- --- PROYECTOS --- --- --- --- --- --- --- --- ---
     */
    @RequestMapping(value = "registrarproyecto.do", method = RequestMethod.GET)
    public String registrarProyecto(Model model)
    {
        Proyectos proyecto = new Proyectos();
        List<TipoProyecto> tiposP = daoTipoProyecto.findAll();
        List<String> modalidades = new ArrayList<String>();
        modalidades.add("INTERNO");
        modalidades.add("EXTERNO");

        List<Perfil> perfiles = daoPerfil.findAll();
        List<Programa> programas = daoPrograma.findAll();

        model.addAttribute("proyecto", proyecto);
        model.addAttribute("tiposP", tiposP);
        model.addAttribute("modalidades", modalidades);
        model.addAttribute("perfiles", perfiles);
        model.addAttribute("perfilesproyecto", "");
        model.addAttribute("programas", programas);
        model.addAttribute("codigop", "");

        return "/Instancias/regproyecto";
    }

    @RequestMapping(value = "registrarproyecto.do", method = RequestMethod.POST)
    public String insertarProyecto(HttpSession session, String actividad1, String actividad2, String actividad3,
            String actividad4, String actividad5, String cp, String perfilesproyecto,
            Model model, @ModelAttribute("proyecto")
            @Valid Proyectos proyecto, BindingResult bindingResult)
    {

        if (bindingResult.hasErrors() || perfilesproyecto.length() < 1)
        {
            List<TipoProyecto> tiposP = daoTipoProyecto.findAll();
            List<String> modalidades = new ArrayList<String>();
            modalidades.add("INTERNO");
            modalidades.add("EXTERNO");

            List<Perfil> perfiles = daoPerfil.findAll();
            List<Programa> programas = daoPrograma.findAll();

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

            if (perfilesproyecto.length() < 1)
            {
                model.addAttribute("errorperfiles", "<div class='alert alert-danger'>Agrege al menos un perfil al proyecto</div>");
            }

            return "/Instancias/regproyecto";
        } else
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

            if (proyecto.getModalidad().trim().equals("INTERNO"))
            {
                proyecto.setModalidad("I");
            } else
            {
                proyecto.setModalidad("E");
            }

            proyecto.setIdTipoProyecto((TipoProyecto) daoTipoProyecto.find(proyecto.getIdTipoProyecto().getIdTipoProyecto()));
            proyecto.setIdPrograma((Programa) daoPrograma.find(proyecto.getIdPrograma().getIdPrograma()));
            proyecto.setIdColonia((Colonia) daoColonia.find(proyecto.getIdColonia().getIdColonia()));

            Instancia instance = (Instancia) daoInstancia.findBySpecificField("nombre", session.getAttribute("NOMBRE").toString(), "equal", null, null).get(0);
            //System.out.println("SE ENCONTRO INSTANCIA: " + instance.getNombre());
            proyecto.setIdInstancia(instance);
            daoProyectos.create(proyecto);

            // Registrar perfiles
            StringTokenizer stPerfiles = new StringTokenizer(perfilesproyecto, ";");
            while (stPerfiles.hasMoreTokens())
            {
                Perfil perfil = (Perfil) daoPerfil.findBySpecificField("nombre", stPerfiles.nextToken().trim(), "equal", null, null).get(0);
                //System.out.println("Perfil encontrado: " + perfil.getNombre());
                ProyectoPerfil pPerfil = new ProyectoPerfil();
                pPerfil.setIdPerfil(perfil);
                pPerfil.setIdProyecto(proyecto);
                daoPerfil.create(pPerfil);
            }

            // Registrar actividades
            Actividades actividad01 = new Actividades();
            Actividades actividad02 = new Actividades();

            actividad01.setIdProyecto(proyecto);
            actividad01.setEstatus(BigInteger.ONE);
            actividad01.setDetalle(actividad1);
            daoActividades.create(actividad01);

            actividad02.setIdProyecto(proyecto);
            actividad02.setEstatus(BigInteger.ONE);
            actividad02.setDetalle(actividad2);
            daoActividades.create(actividad02);

            if (actividad3.trim().length() > 0)
            {
                Actividades actividad03 = new Actividades();
                actividad03.setIdProyecto(proyecto);
                actividad03.setEstatus(BigInteger.ONE);
                actividad03.setDetalle(actividad3);
                daoActividades.create(actividad03);
            }
            if (actividad4.trim().length() > 0)
            {
                Actividades actividad04 = new Actividades();
                actividad04.setIdProyecto(proyecto);
                actividad04.setEstatus(BigInteger.ONE);
                actividad04.setDetalle(actividad4);
                daoActividades.create(actividad04);
            }
            if (actividad5.trim().length() > 0)
            {
                Actividades actividad05 = new Actividades();
                actividad05.setIdProyecto(proyecto);
                actividad05.setEstatus(BigInteger.ONE);
                actividad05.setDetalle(actividad5);
                daoActividades.create(actividad05);
            }

            return "/Instancias/proyectoregistrado";
        }

    }

    @RequestMapping(value = "instanciaproyectos.do", method = RequestMethod.GET)
    public String administrarProyectos(HttpSession session, Model model)
    {
        if (session.getAttribute("NOMBRE") != null)
        {
            Instancia instancia;
            String instanciaNom = session.getAttribute("NOMBRE").toString();

            instancia = (Instancia) daoInstancia.findBySpecificField("nombre",
                    instanciaNom, "equal", null, null).get(0);

            if (instancia != null)
            {
                return "/Instancias/administrarproyectos";
            }
        }

        return "/NavegacionPrincipal/index";
    }
}
