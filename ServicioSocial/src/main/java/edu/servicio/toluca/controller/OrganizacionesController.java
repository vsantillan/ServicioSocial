/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.MetodosValidacion;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.beans.organizaciones.BorrarInstancia;
import edu.servicio.toluca.beans.organizaciones.BorrarProyecto;
import edu.servicio.toluca.beans.organizaciones.ValidacionesOrganizaciones;
import edu.servicio.toluca.beans.organizaciones.ValidarProyectos;
import edu.servicio.toluca.dao.GenericDao;
import edu.servicio.toluca.entidades.Actividades;
import edu.servicio.toluca.entidades.CatalogoObservaciones;
import edu.servicio.toluca.entidades.Ciudades;
import edu.servicio.toluca.entidades.CodigosPostales;
import edu.servicio.toluca.entidades.Colonia;
import edu.servicio.toluca.entidades.EstadosSia;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.MunicipiosSia;
import edu.servicio.toluca.entidades.Perfil;
import edu.servicio.toluca.entidades.Programa;
import edu.servicio.toluca.entidades.ProyectoPerfil;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.entidades.RegObservacionGeneral;
import edu.servicio.toluca.entidades.TipoLocalidad;
import edu.servicio.toluca.entidades.TipoOrganizacion;
import edu.servicio.toluca.entidades.TipoProyecto;
import edu.servicio.toluca.entidades.UsuarioInstancia;
import edu.servicio.toluca.model.ActividadesModel;
import edu.servicio.toluca.sesion.ActividadesFacade;
import edu.servicio.toluca.sesion.CatalogoObservacionesFacade;
import edu.servicio.toluca.sesion.CiudadesFacade;
import edu.servicio.toluca.sesion.CodigosPostalesFacade;
import edu.servicio.toluca.sesion.ColoniaFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.MunicipiosSiaFacade;
import edu.servicio.toluca.sesion.PerfilFacade;
import edu.servicio.toluca.sesion.ProgramaFacade;
import edu.servicio.toluca.sesion.ProyectoPerfilFacade;
import edu.servicio.toluca.sesion.ProyectosFacade;
import edu.servicio.toluca.sesion.RegObservacionGeneralFacade;
import edu.servicio.toluca.sesion.TipoLocalidadFacade;
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
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author roy
 */
@Controller
public class OrganizacionesController
{
//    @Resource
//    private UserTransaction utx;

    // <editor-fold defaultstate="collapsed" desc="EJB Facades Formato Único">
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
    @EJB(mappedName = "java:global/ServicioSocial/ActividadesFacade")
    private ActividadesFacade actividadesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CodigosPostalesFacade")
    private CodigosPostalesFacade codigosPostalesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/MunicipiosSiaFacade")
    private MunicipiosSiaFacade municipiosFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CiudadesFacade")
    private CiudadesFacade ciudadesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/TipoLocalidadFacade")
    private TipoLocalidadFacade tipoLocalidadFacade;
    @EJB(mappedName = "java:global/ServicioSocial/ColoniaFacade")
    private ColoniaFacade coloniaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CatalogoObservacionesFacade")
    private CatalogoObservacionesFacade observacionesCatalogoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/RegObservacionGeneralFacade")
    private RegObservacionGeneralFacade regObservacionGeneralFacade;
    // </editor-fold>

    private GenericDao<Instancia> daoInstancia;
    private GenericDao<Proyectos> daoProyectos;
    private GenericDao<TipoOrganizacion> daoTipoOrganizacion;
    private GenericDao<Perfil> daoPerfil;
    private GenericDao<ProyectoPerfil> daoProyectoPerfil;
    private GenericDao<TipoProyecto> daoTipoProyecto;
    private GenericDao<EstadosSia> daoEstadosSia;
    private GenericDao<Programa> daoPrograma;
    private GenericDao<Actividades> daoActividades;
    private GenericDao<CodigosPostales> daoCodigosPostales;
    private GenericDao<MunicipiosSia> daoMunicipiosSia;
    private GenericDao<Ciudades> daoCiudades;
    private GenericDao<TipoLocalidad> daoTipoLocalidad;
    private GenericDao<Colonia> daoColonia;
    private GenericDao<CatalogoObservaciones> daoCatalogoObservaciones;
    private GenericDao<RegObservacionGeneral> daoRegObservacionGeneral;
    private GenericDao<UsuarioInstancia> daoUsuarioInstancia;

    @Autowired
    public void setDaoInstancia(GenericDao<Instancia> daoInstancia)
    {
        this.daoInstancia = daoInstancia;
        daoInstancia.setClass(Instancia.class);
    }

    @Autowired
    public void setDaoUsuarioInstancia(GenericDao<UsuarioInstancia> daoUsuarioInstancia)
    {
        this.daoUsuarioInstancia = daoUsuarioInstancia;
        daoUsuarioInstancia.setClass(UsuarioInstancia.class);
    }

    @Autowired
    public void setDaoProyectos(GenericDao<Proyectos> daoProyectos)
    {
        this.daoProyectos = daoProyectos;
        daoProyectos.setClass(Proyectos.class);
    }

    @Autowired
    public void setDaoTipoOrganizacion(GenericDao<TipoOrganizacion> daoTipoOrganizacion)
    {
        this.daoTipoOrganizacion = daoTipoOrganizacion;
        daoTipoOrganizacion.setClass(TipoOrganizacion.class);
    }

    @Autowired
    public void setDaoPerfil(GenericDao<Perfil> daoPerfil)
    {
        this.daoPerfil = daoPerfil;
        daoPerfil.setClass(Perfil.class);
    }

    @Autowired
    public void setDaoProyectoPerfil(GenericDao<ProyectoPerfil> daoProyectoPerfil)
    {
        this.daoProyectoPerfil = daoProyectoPerfil;
        daoProyectoPerfil.setClass(ProyectoPerfil.class);
    }

    @Autowired
    public void setDaoTipoProyecto(GenericDao<TipoProyecto> daoTipoProyecto)
    {
        this.daoTipoProyecto = daoTipoProyecto;
        daoTipoProyecto.setClass(TipoProyecto.class);
    }

    @Autowired
    public void setDaoEstadosSiaa(GenericDao<EstadosSia> daoEstadosSia)
    {
        this.daoEstadosSia = daoEstadosSia;
        daoEstadosSia.setClass(EstadosSia.class);
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
    public void setDaoCodigosPostales(GenericDao<CodigosPostales> daoCodigosPostales)
    {
        this.daoCodigosPostales = daoCodigosPostales;
        daoCodigosPostales.setClass(CodigosPostales.class);
    }

    @Autowired
    public void setDaoMunicipiosSia(GenericDao<MunicipiosSia> daoMunicipiosSia)
    {
        this.daoMunicipiosSia = daoMunicipiosSia;
        daoMunicipiosSia.setClass(MunicipiosSia.class);
    }

    @Autowired
    public void setDaoCiudades(GenericDao<Ciudades> daoCiudades)
    {
        this.daoCiudades = daoCiudades;
        daoCiudades.setClass(Ciudades.class);
    }

    @Autowired
    public void setDaoTipoLocalidad(GenericDao<TipoLocalidad> daoTipoLocalidad)
    {
        this.daoTipoLocalidad = daoTipoLocalidad;
        daoTipoLocalidad.setClass(TipoLocalidad.class);
    }

    @Autowired
    public void setDaoColonia(GenericDao<Colonia> daoColonia)
    {
        this.daoColonia = daoColonia;
        daoColonia.setClass(Colonia.class);
    }

    @Autowired
    public void setDaoCatalogoObservaciones(GenericDao<CatalogoObservaciones> daoCatalogoObservaciones)
    {
        this.daoCatalogoObservaciones = daoCatalogoObservaciones;
        daoCatalogoObservaciones.setClass(CatalogoObservaciones.class);
    }

    @Autowired
    public void setDaoRegObservacionGeneral(GenericDao<RegObservacionGeneral> daoRegObservacionGeneral)
    {
        this.daoRegObservacionGeneral = daoRegObservacionGeneral;
        daoRegObservacionGeneral.setClass(RegObservacionGeneral.class);
    }

    MetodosValidacion limpiar = new MetodosValidacion();

    private static final Logger logger = LoggerFactory.getLogger(OrganizacionesController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/administrarOrganizaciones.do")
    public String administradorOrganizaciones(Model model, HttpSession session, HttpServletRequest request)
    {
        List<Instancia> listaInstancias = daoInstancia.findBySpecificField("status", "1", "equal", null, null);
        ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();
        System.out.println("Instancias");
        for (int i = 0; i < listaInstancias.size(); i++)
        {
//            String estatus = listaInstancias.get(i).getEstatus().toString();-..........Correccion de error...................................................
            short listStatus = (short) listaInstancias.get(i).getStatus();
            String estatus = Short.toString(listStatus);
            if ((estatus.equals("1")))
            {
                filtroInstancias.add(listaInstancias.get(i));
            }
        }
        model.addAttribute("organizaciones", filtroInstancias);
        model.addAttribute("listadoObservaciones", daoCatalogoObservaciones.findBySpecificField("tipo", "4", "equal", null, null));
        return "/Organizaciones/administrarOrganizaciones";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/administrarProyectos.do")
    public String administradorProyectos(Model model, HttpSession session, HttpServletRequest request)
    {
        List<Proyectos> listaProyectos = daoProyectos.findBySpecificField("estatus", "1", "equal", null, null);
        ArrayList<Proyectos> filtroDeProyectos = new ArrayList<Proyectos>();
        for (Proyectos proyecto : listaProyectos)
        {
            if (proyecto.getEstatus() == BigInteger.ONE
                    && proyecto.getValidacionAdmin() == BigInteger.ONE
                    && proyecto.getIdInstancia().getStatus() == 1)
            {
                filtroDeProyectos.add(proyecto);
            }
        }

        model.addAttribute("proyectos", filtroDeProyectos);
        model.addAttribute("listadoObservaciones", daoCatalogoObservaciones.findBySpecificField("tipo", "5", "equal", null, null));
        return "/Organizaciones/administrarProyectos";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/validarOrganizaciones.do")
    public String panelAdministradorOrganizaciones(Model model, HttpSession session, HttpServletRequest request)
    {
        model.addAttribute("organizacion", daoInstancia.findBySpecificField("status", "0", "equal", null, null));
        model.addAttribute("retroalimentacionInstancia", new BorrarInstancia());
        model.addAttribute("listadoObservaciones", daoCatalogoObservaciones.findBySpecificField("tipo", "4", "equal", null, null));
        return "/Organizaciones/validarOrganizaciones";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateStatus.do")
    public @ResponseBody
    String actualizarStatusOrganizaciones(int id, Model model, HttpSession session, HttpServletRequest request)
    {
        Instancia instancia;
        instancia = (Instancia) daoInstancia.find(BigDecimal.valueOf(id));
        instancia.setStatus((short) 1);
        System.out.println("Ya actualizo");
        daoInstancia.edit(instancia);

        return "ok";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateProyecto.do")
    public @ResponseBody
    String actualizarStatusProyecto(int id, Model model, HttpSession session, HttpServletRequest request)
    {
        Proyectos proyecto;
        proyecto = (Proyectos) daoProyectos.find(BigDecimal.valueOf(id));
        proyecto.setValidacionAdmin(BigInteger.valueOf(1));
        daoProyectos.edit(proyecto);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/validarProyectos.do")
    public String panelAdministradorProyectos(Model model, HttpSession session, HttpServletRequest request)
    {
        model.addAttribute("proyecto", daoProyectos.findBySpecificField("validacionAdmin", "0", "equal", null, null));
        model.addAttribute("borrarProyecto", new BorrarProyecto());
        return "/Organizaciones/validarProyectos";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detalleProyecto.do")
    public String detalleProyecto(BigDecimal id, Model model, HttpSession session, HttpServletRequest request)
    {
        logger.info("ID Proyecto " + id);
        model.addAttribute("proyectoDetalle", daoProyectos.find(id));
        return "/Organizaciones/detalleProyecto";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detalleOrganizacion.do")
    public String detalleOrganizacion(BigDecimal id, Model model, HttpSession session, HttpServletRequest request)
    {
        model.addAttribute("instancia", daoInstancia.find(id));
        return "/Organizaciones/detalleOrganizacion";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detalleUsuario.do")
    public String detalleUusario(BigDecimal id, Model model, HttpSession session, HttpServletRequest request)
    {
        System.out.println("ID Usuario " + id);

        model.addAttribute("usuario", daoUsuarioInstancia.find(id));
        return "/Usuarios/detalleUsuario";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mensajeOrganizacion.do")
    public String mensajeOrganizacion(Model model, HttpSession session, HttpServletRequest request)
    {
        //Valida sesion
        if (new ValidaSesion().validaOrganizacion(session, request))
        {
            List<String> listaObservaciones = new ArrayList<String>();
            String idInstancia = session.getAttribute("NCONTROL").toString();
            System.out.println("el id instancia es: " + idInstancia);
            List<RegObservacionGeneral> list = daoRegObservacionGeneral.findBySpecificField("idLlaveUnica", idInstancia, "equal", null, null);
            for (int i = 0; i < list.size(); i++)
            {
                if (list.get(i).getCatalogoObservacionId().getTipo() == BigInteger.valueOf(4))
                {
                    System.out.println("La observacion es: " + list.get(i).getCatalogoObservacionId().getDetalle());
                    listaObservaciones.add(list.get(i).getCatalogoObservacionId().getDetalle());
                }
            }
            Instancia instanciaObj = new Instancia(BigDecimal.valueOf(Integer.parseInt(idInstancia)));
            List<Proyectos> listProyectos = daoProyectos.findBySpecificField("idInstancia", instanciaObj, "equal", null, null);
            for (int i = 0; i < listProyectos.size(); i++)
            {
                list = daoRegObservacionGeneral.findBySpecificField("idLlaveUnica", listProyectos.get(i).getIdProyecto().toString(), "equal", null, null);
                for (int j = 0; j < list.size(); j++)
                {
                    if (list.get(j).getCatalogoObservacionId().getTipo() == BigInteger.valueOf(5))
                    {
                        listaObservaciones.add("El Proyecto: " + listProyectos.get(i).getNombre() + " tiene la observación: " + list.get(j).getCatalogoObservacionId().getDetalle());
                    }
                }
            }
            model.addAttribute("observaciones", listaObservaciones);
            return "/Organizaciones/mensajeOrganizacion";
        } else
        {
            model.addAttribute("error", "<div class='alert alert-danger'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
    }

    //Editar Organizacion
    @RequestMapping(method = RequestMethod.GET, value = "/editarOrganizacion.do")
    public String editarOrganizacion(int id, Model model, HttpSession session, HttpServletRequest request)
    {
        model.addAttribute("instancia", daoInstancia.find(BigDecimal.valueOf(id)));
        model.addAttribute("instanciaDireccion", daoInstancia.find(BigDecimal.valueOf(id)));
        model.addAttribute("estados", daoEstadosSia.findAll());
        model.addAttribute("tipoOrganizaciones", daoTipoOrganizacion.findBySpecificField("estatus", "1", "equal", null, null));
        return "/Organizaciones/editarOrganizacion";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modificarOrganizacion.do")
    public String modificarOrganizacion(@Valid Instancia instancia, BindingResult result, Model model,
            String confirma_password, int valid_pass, HttpSession session, HttpServletRequest request,
            String codigo_postal, String otra_colonia, String existeCP, String estado, String municipio, String ciudad)
    {
        System.out.println("nombre: " + instancia.getNombre());
        System.out.println("con id: " + instancia.getIdInstancia());
//        System.out.println("contraseña:" + instancia.getPassword());-..........Comentario de line password.....................................................
        System.out.println("confirma_contraseña:" + confirma_password);

        new ValidacionesOrganizaciones().valGdaEditaInst(instancia, result, model, codigo_postal, otra_colonia, existeCP, confirma_password);
//
//        if (valid_pass == 1)
//        {
//            if (!confirma_password.equals(instancia.getPassword()))
//            {
//                result.addError(new ObjectError("confirma_passowrd", "Las contraseñas no coinciden"));
//                model.addAttribute("confirma_password", "<div class='alert alert-danger'>Las contraseñas no coinciden</div><script>document.getElementById('cambiaPass').style.display = 'block';</script>");
//            }
//        }

        if (result.hasErrors())
        {
            System.out.println("Con errores");
            System.out.println("Los errores son: " + result.toString());
            model.addAttribute("instanciaDireccion", daoInstancia.find(instancia.getIdInstancia()));
            model.addAttribute("otra_colonia", otra_colonia);
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("nombre", "asc");
            model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
            //Regresar codigo postal
            model.addAttribute("cp", codigo_postal);
//            model.addAttribute("ext", instancia.getExt()); ******************************************** REVISAR POR QUE HACE FALTA PARA LOS ENTITIES *************
            try
            {
                model.addAttribute("idColonia", instancia.getIdColonia().getIdColonia());
            } catch (Exception e)
            {
            }
            model.addAttribute("tipoOrganizaciones", daoTipoOrganizacion.findBySpecificField("estatus", "1", "equal", null, null));
            return "/Organizaciones/editarOrganizacion";
        } else
        {
            //---------------------------A continuación código para agregar nueva colonia
            if (existeCP.equals("true"))
            {
                if (instancia.getIdColonia().getIdColonia().toString().equals("0"))
                {
                    //Agregar colonia                   
//                    instancia.setIdColonia(new CodigosPostalesController().agregaColonia(model, codigo_postal, otra_colonia));
                    System.out.println("AgregarColonia");
                    System.out.println("codigo postal:" + codigo_postal.toString());
                    List<CodigosPostales> codigosPostales = daoCodigosPostales.findBySpecificField("cp", codigo_postal, "equal", null, null);
                    CodigosPostales codigoPostal = codigosPostales.get(0);
                    Colonia nvaColonia = new Colonia();
                    otra_colonia = limpiar.tuneaStringParaBD(otra_colonia);
                    nvaColonia.setNombre(otra_colonia);
                    nvaColonia.setIdCp(codigoPostal);
                    nvaColonia.setStatus(BigInteger.ONE);
                    daoColonia.create(nvaColonia);

                    //Obtenemos la ultima colonia
                    LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
                    ordenamiento.put("idColonia", "desc");
                    Colonia colonia = (Colonia) daoColonia.findAll(ordenamiento).get(0);
                    instancia.setIdColonia(colonia);
                    System.out.println("Nueva colonia agregada!");
                }
            } else
            {
                //Agregar codigo postal + colonia
//                instancia.setIdColonia(new CodigosPostalesController().agregarCodigoPostal(codigo_postal, otra_colonia, estado, municipio, ciudad));
                EstadosSia estadoP = (EstadosSia) daoEstadosSia.find(BigDecimal.valueOf(Double.parseDouble(estado)));
                MunicipiosSia municipioP = (MunicipiosSia) daoMunicipiosSia.find(BigDecimal.valueOf(Double.parseDouble(municipio)));
                TipoLocalidad localidad = (TipoLocalidad) daoTipoLocalidad.find(BigDecimal.ONE);
                Ciudades ciudadP = null;
                try
                {
                    ciudadP = (Ciudades) daoCiudades.find(BigDecimal.valueOf(Double.parseDouble(ciudad)));
                } catch (Exception e)
                {
                    System.out.println("No tiene ciudad");
                }

                CodigosPostales codigoPostal = new CodigosPostales();
                codigoPostal.setCp(Integer.parseInt(codigo_postal));
                codigoPostal.setIdMunicipio(municipioP);
                codigoPostal.setIdEstado(estadoP);
                codigoPostal.setIdTipoLocalidad(localidad);
                if (ciudad != null)
                {
                    codigoPostal.setIdCiudad(ciudadP);
                }
                daoCodigosPostales.create(codigoPostal);

                //Obtenemos el Ultimo codigo postal
                LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
                ordenamiento.put("idCp", "desc");
                CodigosPostales codigoPostalNew = (CodigosPostales) daoCodigosPostales.findAll(ordenamiento).get(0);

                Colonia colonia = new Colonia();
                colonia.setIdCp(codigoPostal);
                otra_colonia = limpiar.tuneaStringParaBD(otra_colonia);
                colonia.setNombre(otra_colonia);
                colonia.setStatus(BigInteger.ONE);

                daoColonia.create(colonia);

                //Obtenemos la ultima colonia
                ordenamiento = new LinkedHashMap<String, String>();
                ordenamiento.put("idColonia", "desc");
                Colonia coloniaNew = (Colonia) daoColonia.findAll(ordenamiento).get(0);
                instancia.setIdColonia(coloniaNew);
                System.out.println("Nuevo codigo postal + colonia agregado!");
            }
            //---------------------------Fin código para agregar nueva colonia

            //Encriptar contraseña de la instancia
//            instancia.setPassword(StringMD.getStringMessageDigest(instancia.getPassword(), StringMD.SHA1));.................................................Coreccion de password...........................
            //Convirtiendo a mayusculas
            instancia.setDomicilio(instancia.getDomicilio().toUpperCase());
            instancia.setNombre(instancia.getNombre().toUpperCase());
//            instancia.setPuesto(instancia.getPuesto().toUpperCase());.................................................Comentario de line puesto........................
            instancia.setRfc(instancia.getRfc().toUpperCase());
//            instancia.setTitular(instancia.getTitular().toUpperCase());.................................................Comentario de line titulas...........................
            //try-catch edita instancia
            try
            {
                daoInstancia.edit(instancia);
            } catch (Exception e)
            {
                result.addError(new ObjectError("error_sql", "¡Error interno! Imposible editar organización."));
                System.out.println(result.getGlobalError().toString());
                model.addAttribute("error_sql", "<div class='alert alert-danger'>¡Error interno! Imposible editar oirganización.</div>");

                return "/Organizaciones/editarOrganizacion";
            }
            System.out.println("Sin errores");
            return "redirect:administrarOrganizaciones.do";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editarProyecto.do")
    public String editarProyectos(int id, Model model, HttpSession session, HttpServletRequest request)
    {
        Proyectos proyecto = (Proyectos) daoProyectos.find(BigDecimal.valueOf(id));
        model.addAttribute("proyecto", proyecto);
        model.addAttribute("proyectoDireccion", proyecto);
        List<Instancia> listaInstancias = daoInstancia.findBySpecificField("status", "1", "equal", null, null);
        ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();
        System.out.println("Instancias");
        for (int i = 0; i < listaInstancias.size(); i++)
        {
//            String estatus = listaInstancias.get(i).getEstatus().toString();
            short listStatus = (short) listaInstancias.get(i).getStatus();//.................................................Coreccion de error...........................................
            String estatus = Short.toString(listStatus);  //.................................................Coreccion de error.........................................................
            if ((estatus.equals("1")) || (estatus.equals("2")))
            {
                filtroInstancias.add(listaInstancias.get(i));
            }
        }
        model.addAttribute("instancia", filtroInstancias);
        model.addAttribute("estados", daoEstadosSia.findAll());
        model.addAttribute("perfil", daoPerfil.findBySpecificField("estatus", "1", "equal", null, null));
        model.addAttribute("tipoProyecto", daoTipoProyecto.findBySpecificField("status", "1", "equal", null, null));
        model.addAttribute("programas", daoPrograma.findBySpecificField("status", "1", "equal", null, null));
        List<Perfil> perfilesNoSonDelProyecto = new ArrayList<Perfil>();
        List<Perfil> perfilesSonDelProyecto = new ArrayList<Perfil>();
        List<Perfil> listaPerfil = daoPerfil.findAll();
        Iterator<ProyectoPerfil> iteratorProyectosPerfilCollection;
        boolean agregar;
        for (int i = 0; i < listaPerfil.size(); i++)
        {
            agregar = true;
            //TODO aquí falta cambiar al DAO, pero marca error con el método getProyectoPerfilCollection()
            iteratorProyectosPerfilCollection = proyectosFacade.find(BigDecimal.valueOf(id)).getProyectoPerfilCollection().iterator();
            while (iteratorProyectosPerfilCollection.hasNext())
            {
                if (!listaPerfil.get(i).getNombre().equals(iteratorProyectosPerfilCollection.next().getIdPerfil().getNombre()) && agregar)
                {
                    agregar = true;
                } else
                {
                    agregar = false;
                }
            }
            if (agregar && listaPerfil.get(i).getEstatus().intValue() == 1)
            {
                perfilesNoSonDelProyecto.add(listaPerfil.get(i));
            } else if (listaPerfil.get(i).getEstatus().intValue() == 1)
            {
                perfilesSonDelProyecto.add(listaPerfil.get(i));
            }
        }
        model.addAttribute("perfilesProyectoEx", perfilesNoSonDelProyecto);
        //List<Actividades> dameActividades=actividadesFacade.findBySpecificField("ID_PROYECTO", 12, "equal", null, null);
        model.addAttribute("damePerfilesDelProyecto", perfilesSonDelProyecto);
        return "/Organizaciones/editarProyecto";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modificarProyecto.do")
    public String modificarProyecto(@Valid Proyectos proyecto, BindingResult result, Model model, String selectfrom, String nActividades, String cadenaActividades, String codigo_postal, HttpSession session, HttpServletRequest request)
    {
        proyecto.setFechaAlta(new Date());
        //Validaciones
        System.out.println("Validarr");
        new ValidarProyectos().valAltaAdminProy(proyecto, result, model, codigo_postal);

        //Desglose de Actividades
        ActividadesModel actividadesModel = new ActividadesModel(cadenaActividades);

        //Valida Actividades
        if (!actividadesModel.validarInsercionActividades().isSuccess())
        {
            result.addError(new ObjectError("actividades", actividadesModel.validarInsercionActividades().getMensaje()));
        }
        model.addAttribute("validacion_actividades", actividadesModel.validarInsercionActividades().getMensaje());
        //++++++++++++++++++++++++++++++++Si hubo un error+++++++++++++++++++++++++++++++++++
        if (result.hasErrors())
        {
            System.out.println("Entroooooooooo aquiiiiiiiiiiiiiiiiiiiiiiiiiiii");
            //Regresar codigo postal
            model.addAttribute("cp", codigo_postal);
            try
            {
                model.addAttribute("idColonia", proyecto.getIdColonia().getIdColonia());
            } catch (Exception e)
            {
            }
            List<Instancia> listaInstancias = daoInstancia.findBySpecificField("status", "1", "equal", null, null);
            ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();
            System.out.println("Instancias");
            for (int i = 0; i < listaInstancias.size(); i++)
            {
//                String estatus = listaInstancias.get(i).getEstatus().toString();
                short listStatus = (short) listaInstancias.get(i).getStatus();//.................................................Coreccion de error...........................................
                String estatus = Short.toString(listStatus);  //.................................................Coreccion de error.........................................................
                if ((estatus.equals("1")) || (estatus.equals("2")))
                {
                    filtroInstancias.add(listaInstancias.get(i));
                }
            }
            model.addAttribute("instancia", filtroInstancias);
            model.addAttribute("estados", daoEstadosSia.findAll());
            model.addAttribute("perfil", daoPerfil.findBySpecificField("estatus", "1", "equal", null, null));
            model.addAttribute("tipoProyecto", daoTipoProyecto.findBySpecificField("status", "1", "equal", null, null));
            model.addAttribute("programas", daoPrograma.findBySpecificField("status", "1", "equal", null, null));
            List<Perfil> perfilesNoSonDelProyecto = new ArrayList<Perfil>();
            List<Perfil> perfilesSonDelProyecto = new ArrayList<Perfil>();
            List<Perfil> listaPerfil;
            Iterator<ProyectoPerfil> iteratorProyectosPerfilCollection;
            listaPerfil = daoPerfil.findAll();
            boolean agregar;
            String nombrePerfilCollection;
            for (int i = 0; i < listaPerfil.size(); i++)
            {
                agregar = true;
                //TODO falta corregir esto, marca error con el dao en el método getProyectoPerfilCollection()
                iteratorProyectosPerfilCollection = proyectosFacade.find(proyecto.getIdProyecto()).getProyectoPerfilCollection().iterator();
                while (iteratorProyectosPerfilCollection.hasNext())
                {
                    nombrePerfilCollection = iteratorProyectosPerfilCollection.next().getIdPerfil().getNombre();
                    if (!listaPerfil.get(i).getNombre().equals(nombrePerfilCollection) && agregar)
                    {
                        agregar = true;
                    } else
                    {
                        agregar = false;
                    }
                }
                if (agregar && listaPerfil.get(i).getEstatus().intValue() == 1)
                {
                    perfilesNoSonDelProyecto.add(listaPerfil.get(i));
                } else if (listaPerfil.get(i).getEstatus().intValue() == 1)
                {
                    perfilesSonDelProyecto.add(listaPerfil.get(i));
                }
            }
            model.addAttribute("perfilesProyectoEx", perfilesNoSonDelProyecto);
            model.addAttribute("perfilesSonProyecto", perfilesSonDelProyecto);
            //Regresar actividades
            model.addAttribute("nActividades", nActividades.substring(0, 1));
            System.out.println("nActividades:" + nActividades.substring(0, 1));

            for (int i = 0; i < actividadesModel.actividades.size(); i++)
            {
                model.addAttribute("actividad" + i, actividadesModel.actividades.get(i));
                System.out.println("Regresando Actividad:" + actividadesModel.actividades.get(i));
            }
            model.addAttribute("actividadAux", actividadesModel.actividades);
            model.addAttribute("proyectoDireccion", daoProyectos.find(proyecto.getIdProyecto()));
            model.addAttribute("proyecto", proyecto);
            return "/Organizaciones/editarProyecto";
        } else
        {
            //**********************Insertar los Perfiles del proyecto**********************************
            List<ProyectoPerfil> listaProyectosPerfil = daoProyectoPerfil.findBySpecificField("idProyecto", proyecto, "equal", null, null);
            Iterator<ProyectoPerfil> recorreProyectosPerfil = listaProyectosPerfil.iterator();
            //while para borrar los perfiles que tiene el proyecto
            while (recorreProyectosPerfil.hasNext())
            {
                ProyectoPerfil borrarPerfilDeProyecto;
                borrarPerfilDeProyecto = recorreProyectosPerfil.next();
                daoProyectoPerfil.remove(borrarPerfilDeProyecto);
            }
            if (selectfrom != null)
            {
                List<String> listaIds = new ArrayList<String>();
                StringTokenizer palabra = new StringTokenizer(selectfrom, ",");
                while (palabra.hasMoreTokens())
                {
                    listaIds.add(palabra.nextToken());
                }
                Iterator inserta = listaIds.iterator();
                //while que inserta la lista de los perfiles para el proyecto
                while (inserta.hasNext())
                {
                    ProyectoPerfil proyectoPerfil = new ProyectoPerfil();
                    proyectoPerfil.setIdPerfil((Perfil) daoPerfil.find(BigDecimal.valueOf(Integer.parseInt(inserta.next().toString())))); //Perfil
                    proyectoPerfil.setIdProyecto(proyecto); //Proyecto
                    daoProyectoPerfil.create(proyectoPerfil);
                }
            }
            //****************************Insertar las Actividades**************************
            if (Integer.parseInt(nActividades) > 2 || nActividades != null)
            {
                List<Actividades> listaActividadesProyecto = daoActividades.findBySpecificField("idProyecto", proyecto, "equal", null, null);
                Iterator<Actividades> recorreActividades = listaActividadesProyecto.iterator();
                //while para borrar las actividades del proyecto
                while (recorreActividades.hasNext())
                {
                    Actividades borrarActividadesProyecto;
                    borrarActividadesProyecto = recorreActividades.next();
                    borrarActividadesProyecto.setEstatus(BigInteger.ZERO);
                    daoActividades.edit(borrarActividadesProyecto);
                }
                List<String> listaActividades = new ArrayList<String>();
                StringTokenizer actividades = new StringTokenizer(cadenaActividades, ";");
                while (actividades.hasMoreTokens())
                {
                    listaActividades.add(actividades.nextToken());
                }
                Iterator insertaActividades = listaActividades.iterator();
                //while que inserta la lista de actividades para el proyecto
                while (insertaActividades.hasNext())
                {
                    Actividades actividadesObj = new Actividades();
                    actividadesObj.setDetalle(insertaActividades.next().toString());//String
                    actividadesObj.setEstatus(BigInteger.ONE);//BigInteger
                    actividadesObj.setIdProyecto(proyecto);//Proyectos
                    daoActividades.create(actividadesObj);
                }
            }
            //Pasar todo a mayusculas
            proyecto.setNombre(proyecto.getNombre().toUpperCase());
            proyecto.setDomicilio(proyecto.getDomicilio().toUpperCase());
            proyecto.setModalidad(proyecto.getModalidad().toUpperCase());
            proyecto.setNombreResponsable(proyecto.getNombreResponsable().toUpperCase());
            proyecto.setResponsablePuesto(proyecto.getResponsablePuesto().toUpperCase());
            //******************************try-catch para editar un proyecto**************************
            try
            {
                daoProyectos.edit(proyecto);
            } catch (Exception e)
            {
                result.addError(new ObjectError("error_sql", "¡Error interno! Imposible editar proyecto."));
                model.addAttribute("error_sql", "<div class='alert alert-danger'>¡Error interno! Imposible editar proyecto.</div>");
                model.addAttribute("cp", codigo_postal);
                try
                {
                    model.addAttribute("idColonia", proyecto.getIdColonia().getIdColonia());
                } catch (Exception ex)
                {
                }
                List<Instancia> listaInstancias = daoInstancia.findBySpecificField("validacionAdmin", "1", "equal", null, null);
                ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();
                System.out.println("Instancias");
                for (int i = 0; i < listaInstancias.size(); i++)
                {
//                    String estatus = listaInstancias.get(i).getEstatus().toString();
                    short listStatus = (short) listaInstancias.get(i).getStatus();//.................................................Coreccion de error...........................................
                    String estatus = Short.toString(listStatus);  //.................................................Coreccion de error.........................................................
                    if ((estatus.equals("1")) || (estatus.equals("2")))
                    {
                        filtroInstancias.add(listaInstancias.get(i));
                    }
                }
                model.addAttribute("instancia", filtroInstancias);
                model.addAttribute("estados", daoEstadosSia.findAll());
                model.addAttribute("perfil", daoPerfil.findBySpecificField("estatus", "1", "equal", null, null));
                model.addAttribute("tipoProyecto", daoTipoProyecto.findBySpecificField("status", "1", "equal", null, null));
                model.addAttribute("programas", daoPrograma.findBySpecificField("status", "1", "equal", null, null));
                List<Perfil> perfilesNoSonDelProyecto = new ArrayList<Perfil>();
                List<Perfil> perfilesSonDelProyecto = new ArrayList<Perfil>();
                List<Perfil> listaPerfil;
                Iterator<ProyectoPerfil> iteratorProyectosPerfilCollection;
                listaPerfil = daoPerfil.findAll();
                boolean agregar;
                String nombrePerfilCollection;
                for (int i = 0; i < listaPerfil.size(); i++)
                {
                    agregar = true;
                    //TODO lo mismo con el método getProyectoPerfilCollection()
                    iteratorProyectosPerfilCollection = proyectosFacade.find(proyecto.getIdProyecto()).getProyectoPerfilCollection().iterator();
                    while (iteratorProyectosPerfilCollection.hasNext())
                    {
                        nombrePerfilCollection = iteratorProyectosPerfilCollection.next().getIdPerfil().getNombre();
                        if (!listaPerfil.get(i).getNombre().equals(nombrePerfilCollection) && agregar)
                        {
                            agregar = true;
                        } else
                        {
                            agregar = false;
                        }
                    }
                    if (agregar && listaPerfil.get(i).getEstatus().intValue() == 1)
                    {
                        perfilesNoSonDelProyecto.add(listaPerfil.get(i));
                    } else if (listaPerfil.get(i).getEstatus().intValue() == 1)
                    {
                        perfilesSonDelProyecto.add(listaPerfil.get(i));
                    }
                }
                model.addAttribute("perfilesProyectoEx", perfilesNoSonDelProyecto);
                model.addAttribute("perfilesSonProyecto", perfilesSonDelProyecto);
                //Regresar actividades
                model.addAttribute("nActividades", nActividades.substring(0, 1));
                System.out.println("nActividades:" + nActividades.substring(0, 1));

                for (int i = 0; i < actividadesModel.actividades.size(); i++)
                {
                    model.addAttribute("actividad" + i, actividadesModel.actividades.get(i));
                    System.out.println("Regresando Actividad:" + actividadesModel.actividades.get(i));
                }
                model.addAttribute("actividadAux", actividadesModel.actividades);
                model.addAttribute("proyectoDireccion", daoProyectos.find(proyecto.getIdProyecto()));
                model.addAttribute("proyecto", proyecto);
                return "/Organizaciones/editarProyecto";
            }

            System.out.println("Sin errores");
            List<Proyectos> listaProyectos = daoProyectos.findBySpecificField("estatus", "1", "equal", null, null);
            ArrayList<Proyectos> filtroDeProyectos = new ArrayList<Proyectos>();
            for (int i = 0; i < listaProyectos.size(); i++)
            {
                int validacionAdmin = Integer.parseInt(listaProyectos.get(i).getValidacionAdmin().toString());
                if (validacionAdmin == 1)
                {
                    filtroDeProyectos.add(listaProyectos.get(i));
                }
            }
            model.addAttribute("proyectos", filtroDeProyectos);
            model.addAttribute("retroalimentacionProyecto", new BorrarProyecto());
            return "/Organizaciones/administrarProyectos";
        }
    }

    //Eliminar instancia y proyecto (solo cambia el estatus a 0)
    @RequestMapping(method = RequestMethod.POST, value = "/cambiaStatusInstancia.do")
    public @ResponseBody
    String cambiaStatusInstancia(@RequestParam(value = "observaciones[]", required = false) String[] observaciones,
            int id, int status, int val_admin, Model model, HttpSession session, HttpServletRequest request)
    {

        Instancia instancia;
        instancia = (Instancia) daoInstancia.find(BigDecimal.valueOf(id));
        List<String> listaOb = new ArrayList<String>();
        for (String idObservacion : observaciones)
        {
            CatalogoObservaciones catObser = (CatalogoObservaciones) daoCatalogoObservaciones.find(BigDecimal.valueOf(Integer.parseInt(idObservacion)));
            //Objeto a Registrar
            RegObservacionGeneral registro = new RegObservacionGeneral();
            //Buscar Objeto Pertenciente al CatalogoObservaciones con el id recibido y asignarlo
            registro.setCatalogoObservacionId(catObser);
            //Buscar Objeto Pertenciente a la Tabla de DatosPersonales con el id recibido y asignarlo
            registro.setIdLlaveUnica(BigInteger.valueOf(instancia.getIdInstancia().intValue()));
            //Asignar Fecha Actual al momento para registro 
            registro.setFecha(new Date());
            //Creacion de Registro
            daoRegObservacionGeneral.create(registro);
            //pendiente por modificar Registro de Observaciones!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            listaOb.add(catObser.getDetalle());
        }

        Iterator<Proyectos> proyectos = instancia.getProyectosCollection().iterator();
        while (proyectos.hasNext())
        {
            Proyectos proyectoEdit = proyectos.next();
            proyectoEdit.setEstatus(BigInteger.valueOf(status));
            proyectoEdit.setValidacionAdmin(BigInteger.valueOf(val_admin));
            daoProyectos.edit(proyectoEdit);
        }
//        instancia.setStatus(BigInteger.valueOf(status));
        instancia.setStatus((short) status);//.......................................correccion  de error..........................................
//        instancia.setValidacionAdmin(BigInteger.valueOf(val_admin));:::::::::::::::::::::::::::::::::::::::::::::::::: REVISION DE VALIDACION DEL ADMINISTRADOR PARA INSTANCIAS ::::::::::::::::::::::::::::::::::
        daoInstancia.edit(instancia);

        String mensaje;
        switch (status)
        {
            case 0://Dada de baja
                mensaje = "<h1>Notificación Servicio Social</h1>\n"
                        + "<h2>Estimado(a)  <b>" + instancia.getNombre() + "</b>:</h2> \n"
                        + "<p>\n"
                        + "Te informamos que tu Organización tiene las siguientes <b>observaciones</b> en el Sistemade de Servicio Social del Instituto Tecnológico de Toluca.\n"
                        + "</p>\n"
                        + "<p>\n"
                        + dameObservaciones(listaOb)
                        + "</p>\n"
                        + "<p>\n"
                        + "Para mayor información presentarse en la Oficina de Servicio Social.  \n"
                        + "</p>\n"
                        + "<p>\n"
                        + "Oficina de Servicio Social <br>\n"
                        + "Instituto Tecnológico de Toluca\n"
                        + "</p>";
                break;
            case 1://No aceptados
                mensaje = "<h1>Notificación Servicio Social</h1>\n"
                        + "<h2>Estimado(a)  <b>" + instancia.getNombre() + "</b>:</h2> \n"
                        + "<p>\n"
                        + "Te informamos que tu  Organización ha sido <b>dada de baja</b> del Sistemade de Servicio Social del Instituto Tecnológico de Toluca.\n"
                        + "</p>\n"
                        + "<p>\n"
                        + dameObservaciones(listaOb)
                        + "</p>\n"
                        + "<p>\n"
                        + "Para mayor información  presentarse en la Oficina de Servicio Social.  \n"
                        + "</p>\n"
                        + "<p>\n"
                        + "Oficina de Servicio Social <br>\n"
                        + "Instituto Tecnológico  de Toluca\n"
                        + "</p>";
                break;
            default:
                return "";
        }
//        Thread hiloCorreo = new Thread(new EnviarCorreo(instancia.getNombre(), instancia.getCorreo(), mensaje));
//        hiloCorreo.start(); ..................................................................... CAMBIAR EL CORREO PARA QUE LO MANDE EL USUARIO Y NO LA INSTANCIA..................................................................

        return "ok";
    }

    public String dameObservaciones(List<String> lista)
    {
        String observaciones = "";
        for (int i = 0; i < lista.size(); i++)
        {
            observaciones += " * " + lista.get(i) + "\n";
        }
        return observaciones;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cambiaStatusProyecto.do")
    public @ResponseBody
    String cambiaStatusProyecto(@RequestParam(value = "observaciones[]", required = false) String[] observaciones,
            int id, int estatus, int val_admin, Model model, HttpSession session, HttpServletRequest request)
    {
        Proyectos proyecto;
        proyecto = (Proyectos) daoProyectos.find(BigDecimal.valueOf(id));
        List<String> listaOb = new ArrayList<String>();
        for (String idObservacion : observaciones)
        {
            CatalogoObservaciones catObser = (CatalogoObservaciones) daoCatalogoObservaciones.find(BigDecimal.valueOf(Integer.parseInt(idObservacion)));
            //Objeto a Registrar
            RegObservacionGeneral registro = new RegObservacionGeneral();
            //Buscar Objeto Pertenciente al CatalogoObservaciones con el id recibido y asignarlo
            registro.setCatalogoObservacionId(catObser);
            //Buscar Objeto Pertenciente a la Tabla de DatosPersonales con el id recibido y asignarlo
            registro.setIdLlaveUnica(BigInteger.valueOf(proyecto.getIdProyecto().intValue()));
            //Asignar Fecha Actual al momento para registro 
            registro.setFecha(new Date());
            //Creacion de Registro
            daoRegObservacionGeneral.create(registro);
            System.out.println("las observaciones son: " + idObservacion);
            //pendiente por modificar Registro de Observaciones!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            listaOb.add(catObser.getDetalle());
        }

        proyecto.setEstatus(BigInteger.valueOf(estatus));
        proyecto.setValidacionAdmin(BigInteger.valueOf(val_admin));
        daoProyectos.edit(proyecto);
        String mensaje;
        switch (estatus)
        {
            case 0://Dada de baja
                mensaje = "<h1>Notificación Servicio Social</h1>\n"
                        + "<h2>Estimado(a)  <b>" + proyecto.getNombre() + "</b>:</h2> \n"
                        + "<p>\n"
                        + "Te informamos que tu  Organización ha sido <b>dada de baja</b> del Sistemade de Servicio Social del Instituto Tecnológico de Toluca.\n"
                        + "</p>\n"
                        + "<p>\n"
                        + dameObservaciones(listaOb)
                        + "</p>\n"
                        + "<p>\n"
                        + "Para mayor información  presentarse en la Oficina de Servicio Social.  \n"
                        + "</p>\n"
                        + "<p>\n"
                        + "Oficina de Servicio Social <br>\n"
                        + "Instituto Tecnológico  de Toluca\n"
                        + "</p>";
                break;
            case 1://No aceptados
                mensaje = "<h1>Notificación Servicio Social</h1>\n"
                        + "<h2>Estimado(a)  <b>" + proyecto.getNombre() + "</b>:</h2> \n"
                        + "<p>\n"
                        + "Te informamos que tu  Organización ha sido <b>dada de baja</b> del Sistemade de Servicio Social del Instituto Tecnológico de Toluca.\n"
                        + "</p>\n"
                        + "<p>\n"
                        + dameObservaciones(listaOb)
                        + "</p>\n"
                        + "<p>\n"
                        + "Para mayor información  presentarse en la Oficina de Servicio Social.  \n"
                        + "</p>\n"
                        + "<p>\n"
                        + "Oficina de Servicio Social <br>\n"
                        + "Instituto Tecnológico  de Toluca\n"
                        + "</p>";
                break;
            default:
                return "";
        }

//        Thread hiloCorreo = new Thread(new EnviarCorreo(proyecto.getNombre(), proyecto.getIdInstancia().getCorreo(), mensaje));
//        hiloCorreo.start();..................................................................... CAMBIAR EL CORREO PARA QUE LO MANDE EL USUARIO Y NO LA INSTANCIA..................................................................
        return "ok";
    }

    //Alta Organizaicon visitante
    @RequestMapping(method = RequestMethod.POST, value = "/gdaAltaOrganizacionVisitante.do")
    public String gdaOrganizacionVisitante(Model a)
    {

        return "/Organizaciones/editarOrganizacion";
    }
}
