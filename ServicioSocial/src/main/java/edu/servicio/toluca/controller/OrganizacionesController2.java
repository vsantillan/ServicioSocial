/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.MetodosValidacion;
import edu.servicio.toluca.beans.PerfilJSON;
import edu.servicio.toluca.beans.StringMD;
import edu.servicio.toluca.beans.organizaciones.PropAluInstProyBean;
import edu.servicio.toluca.model.organizaciones.prueba;
import edu.servicio.toluca.entidades.Actividades;
import edu.servicio.toluca.entidades.Colonia;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.Perfil;
import edu.servicio.toluca.entidades.Programa;
import edu.servicio.toluca.entidades.ProyectoPerfil;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.entidades.TipoOrganizacion;
import edu.servicio.toluca.entidades.TipoProyecto;
import edu.servicio.toluca.model.ActividadesModel;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.beans.organizaciones.ValidacionesOrganizaciones;
import edu.servicio.toluca.dao.GenericDao;
import edu.servicio.toluca.entidades.Ciudades;
import edu.servicio.toluca.entidades.CodigosPostales;
import edu.servicio.toluca.entidades.EstadosSia;
import edu.servicio.toluca.entidades.MunicipiosSia;
import edu.servicio.toluca.entidades.TipoLocalidad;
import edu.servicio.toluca.entidades.UsuarioInstancia;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.model.codigospostales.CodigosPostalesModel;
import edu.servicio.toluca.sesion.ActividadesFacade;
import edu.servicio.toluca.sesion.CiudadesFacade;
import edu.servicio.toluca.sesion.CodigosPostalesFacade;
import edu.servicio.toluca.sesion.ColoniaFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.MunicipiosSiaFacade;
import edu.servicio.toluca.sesion.PerfilFacade;
import edu.servicio.toluca.sesion.ProgramaFacade;
import edu.servicio.toluca.sesion.ProyectoPerfilFacade;
import edu.servicio.toluca.sesion.ProyectosFacade;
import edu.servicio.toluca.sesion.TipoLocalidadFacade;
import edu.servicio.toluca.sesion.TipoOrganizacionFacade;
import edu.servicio.toluca.sesion.TipoProyectoFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bustedvillain
 */
@Controller
public class OrganizacionesController2
{

    private GenericDao<TipoOrganizacion> daoTipoOrganizacion;
    private GenericDao<Instancia> daoInstancia;
    private GenericDao<Proyectos> daoProyectos;
    private GenericDao<Perfil> daoPerfil;
    private GenericDao<Colonia> daoColonia;
    private GenericDao<TipoProyecto> daoTipoProyecto;
    private GenericDao<EstadosSia> daoEstadosSia;
    private GenericDao<Programa> daoPrograma;
    private GenericDao<ProyectoPerfil> daoProyectoPerfil;
    private GenericDao<Actividades> daoActividades;
    private GenericDao<FormatoUnico> daoFormatoUnico;
    private GenericDao<DatosPersonales> daoDatosPersonales;
    private GenericDao<CodigosPostales> daoCodigosPostales;
    private GenericDao<MunicipiosSia> daoMunicipiosSia;
    private GenericDao<Ciudades> daoCiudades;
    private GenericDao<VistaAlumno> daoVistaAlumno;
    private GenericDao<TipoLocalidad> daoTipoLocalidad;
    private GenericDao<UsuarioInstancia> daoUsuarioInstancia;

    @Autowired
    public void setDaoUsuarioInstancia(GenericDao<UsuarioInstancia> daoUsuarioInstancia)
    {
        this.daoUsuarioInstancia = daoUsuarioInstancia;
        daoUsuarioInstancia.setClass(UsuarioInstancia.class);
    }

    @Autowired
    public void setDaoTipoOrganizacion(GenericDao<TipoOrganizacion> daoTipoOrganizacion)
    {
        this.daoTipoOrganizacion = daoTipoOrganizacion;
        daoTipoOrganizacion.setClass(TipoOrganizacion.class);
    }

    @Autowired
    public void setDaoInstancia(GenericDao<Instancia> daoInstancia)
    {
        this.daoInstancia = daoInstancia;
        daoInstancia.setClass(Instancia.class);
    }

    @Autowired
    public void setDaoProyectos(GenericDao<Proyectos> daoProyectos)
    {
        this.daoProyectos = daoProyectos;
        daoProyectos.setClass(Proyectos.class);
    }

    @Autowired
    public void setDaoColonia(GenericDao<Colonia> daoColonia)
    {
        this.daoColonia = daoColonia;
        daoColonia.setClass(Colonia.class);
    }

    @Autowired
    public void setDaoPerfil(GenericDao<Perfil> daoPerfil)
    {
        this.daoPerfil = daoPerfil;
        daoPerfil.setClass(Perfil.class);
    }

    @Autowired
    public void setDaoTipoProyecto(GenericDao<TipoProyecto> daoTipoProyecto)
    {
        this.daoTipoProyecto = daoTipoProyecto;
        daoTipoProyecto.setClass(TipoProyecto.class);
    }

    @Autowired
    public void setDaoEstadosSia(GenericDao<EstadosSia> daoEstadosSia)
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
    public void setDaoProyectoPerfil(GenericDao<ProyectoPerfil> daoProyectoPerfil)
    {
        this.daoProyectoPerfil = daoProyectoPerfil;
        daoProyectoPerfil.setClass(ProyectoPerfil.class);
    }

    @Autowired
    public void setDaoActividades(GenericDao<Actividades> daoActividades)
    {
        this.daoActividades = daoActividades;
        daoActividades.setClass(Actividades.class);
    }

    @Autowired
    public void setDaoFormatoUnico(GenericDao<FormatoUnico> daoFormatoUnico)
    {
        this.daoFormatoUnico = daoFormatoUnico;
        daoFormatoUnico.setClass(FormatoUnico.class);
    }

    @Autowired
    public void setDaoDatosPersonales(GenericDao<DatosPersonales> daoDatosPersonales)
    {
        this.daoDatosPersonales = daoDatosPersonales;
        daoDatosPersonales.setClass(DatosPersonales.class);
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
    public void setDaoVistaAlumno(GenericDao<VistaAlumno> daoVistaAlumno)
    {
        this.daoVistaAlumno = daoVistaAlumno;
        daoVistaAlumno.setClass(VistaAlumno.class);
    }

    // <editor-fold defaultstate="collapsed" desc="EJB Facades">
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

    @EJB(mappedName = "java:global/ServicioSocial/ProyectoPerfilFacade")
    private ProyectoPerfilFacade proyectoPerfilFacade;

    @EJB(mappedName = "java:global/ServicioSocial/ActividadesFacade")
    private ActividadesFacade actividadesFacade;

    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
    private FormatoUnicoFacade formatoUnicoFacade;

    @EJB(mappedName = "java:global/ServicioSocial/DatosPersonalesFacade")
    private DatosPersonalesFacade datosPersonalesFacade;

    @EJB(mappedName = "java:global/ServicioSocial/CodigosPostalesFacade")
    private CodigosPostalesFacade codigosPostalesFacade;

    @EJB(mappedName = "java:global/ServicioSocial/MunicipiosSiaFacade")
    private MunicipiosSiaFacade municipiosFacade;

    @EJB(mappedName = "java:global/ServicioSocial/CiudadesFacade")
    private CiudadesFacade ciudadesFacade;

    @EJB(mappedName = "java:global/ServicioSocial/TipoLocalidadFacade")
    private TipoLocalidadFacade tipoLocalidadFacade;

    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    private VistaAlumnoFacade vistaAlumnoFacade;
    // </editor-fold>

    MetodosValidacion limpiar = new MetodosValidacion();
    //Alta de Organizacion

    private static final Logger logger = LoggerFactory.getLogger(OrganizacionesController2.class);

    @RequestMapping(method = RequestMethod.GET, value = "/altaOrganizacion.do")
    public String altaOrganizacion(Model model, HttpSession session)
    {
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("nombre", "asc");
        model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
        return "/Organizaciones/altaOrganizacion";
    }

    //Alta de Proyecto
    @RequestMapping(method = RequestMethod.GET, value = "/altaProyecto.do")
    public String altaProyecto(Model model, HttpSession session, HttpServletRequest request)
    {

        if (new ValidaSesion().validaOrganizacion(session, request))
        {
            String idInstancia = session.getAttribute("NCONTROL") + "";
            System.out.println("idInstancia:" + idInstancia);
            Instancia instancia = (Instancia) daoInstancia.find(BigDecimal.valueOf(Double.parseDouble(idInstancia)));
            Proyectos proyecto = new Proyectos();
            proyecto.setIdInstancia(instancia);

            //Objeto proyecto para el commandAttribute
            model.addAttribute("proyecto", proyecto);
            //Estados
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("nombre", "asc");
            model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
            //TipoProyecto
            model.addAttribute("tipoProyecto", daoTipoProyecto.findBySpecificField("status", "1", "equal", null, null));
            //Perfil
            model.addAttribute("perfiles", daoPerfil.findBySpecificField("estatus", "1", "equal", null, null));
            //Programa
            model.addAttribute("programas", daoPrograma.findBySpecificField("status", "1", "equal", null, null));

            return "/Organizaciones/altaProyecto";
        } else
        {
            model.addAttribute("error", "<div class='alert alert-danger'>Debes iniciar sesió para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/altaAdminOrganizacion.do")
    public String altaAdminOrganizacion(Model model, HttpSession session, HttpServletRequest request)
    {
        if (session.getAttribute("ROL").equals("ADMIN"))
        {
            logger.debug("BIENVENIDO {}", session.getAttribute("ROL"));
        }

        model.addAttribute("instancia", new Instancia());
        model.addAttribute("tipoOrganizaciones", daoTipoOrganizacion.findBySpecificField("estatus", "1", "equal", null, null));

        //model.addAttribute("estados", estadosFacade.findAll());
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("nombre", "asc");
        model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
        return "/Organizaciones/altaAdminOrganizacion";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/altaAdminProyectos.do")
    public String altaAdminProyectos(Model model, HttpSession session, HttpServletRequest request)
    {

        //Organizacion
        List<Instancia> listaInstancias = daoInstancia.findBySpecificField("status", "1", "equal", null, null);

        model.addAttribute("instancias", listaInstancias);

        //Objeto proyecto para el commandAttribute
        model.addAttribute("proyecto", new Proyectos());

        //Estados
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("nombre", "asc");
        model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));

        //TipoProyecto
        model.addAttribute("tipoProyecto", daoTipoProyecto.findBySpecificField("status", "1", "equal", null, null));

        //Perfil
        model.addAttribute("perfiles", daoPerfil.findBySpecificField("estatus", "1", "equal", null, null));

        //Programa
        model.addAttribute("programas", daoPrograma.findBySpecificField("status", "1", "equal", null, null));

        return "/Organizaciones/altaAdminProyecto";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/gdaAltaOrganizacion.do")
    public String gdaAltaOrganizacion(@Valid Instancia instancia, BindingResult result, Model model, String confirma_password, String codigo_postal, String otra_colonia, String existeCP, String estado, String municipio, String ciudad, HttpSession session, HttpServletRequest request)
    {

        //Validacion
        new ValidacionesOrganizaciones().valGdaAltaInst(instancia, result, model, codigo_postal, otra_colonia, existeCP, confirma_password);
        System.out.println("Codigo Postal" + codigo_postal);
        System.out.println("Otra Colonia:" + otra_colonia);
        System.out.println("Existe Colonia:" + existeCP);
//        System.out.println("idColonia:" + instancia.getIdColonia().getIdColonia());
        if (result.hasErrors())
        {
            System.out.print("hubo errores");
            System.out.println(instancia.toString());
            System.out.println(result.toString());

            //Inyectamos lo que traia en la colonia
            model.addAttribute("otra_colonia", otra_colonia);
            //Agregamos atributos al formulario
            model.addAttribute("preOrganizaciones", daoInstancia.findBySpecificField("estatus", "2", "equal", null, null));
            model.addAttribute("tipoOrganizaciones", daoTipoOrganizacion.findBySpecificField("estatus", "1", "equal", null, null));

            //Regresar codigo postal
            model.addAttribute("cp", codigo_postal);
            try
            {
                model.addAttribute("idColonia", instancia.getIdColonia().getIdColonia());
            } catch (Exception e)
            {
            }

            model.addAttribute("estados", daoEstadosSia.findAll());
            model.addAttribute("tipoOrganizaciones", daoTipoOrganizacion.findBySpecificField("estatus", "1", "equal", null, null));
            model.addAttribute("idInstancia", instancia.getIdInstancia().intValue());
            model.addAttribute("instanciaDireccion", daoInstancia.find(instancia.getIdInstancia()));

            return "/Organizaciones/registroOrganizaciones";

        } else
        {
            //Checa codigo postal
            CodigosPostalesModel codigosPostales = new CodigosPostalesModel(daoColonia, daoCodigosPostales, daoEstadosSia,
                    daoMunicipiosSia, daoCiudades, daoTipoLocalidad);
            if (existeCP.equals("true"))
            {
                if (instancia.getIdColonia().getIdColonia().toString().equals("0"))
                {
                    //Agregar colonia                   
                    instancia.setIdColonia(codigosPostales.agregaColonia(codigo_postal, otra_colonia));
                }
            } else
            {
                //Agregar codigo postal + colonia
                instancia.setIdColonia(codigosPostales.agregarCodigoPostal(codigo_postal, otra_colonia, estado, municipio, ciudad));
            }

            System.out.print("no hubo errores .......  preparando actualizacion de DB");
//            instancia.setValidacionAdmin(BigInteger.ZERO);   ................................................. Comentario a la validacion de admiistrador.............................................................
//            instancia.setEstatus(BigInteger.ONE);
//              instancia.setEstatus(BigInteger.ONE);// .......................................................................................................Correción de convarsion de staus..............................................
            instancia.setStatus((short) BigInteger.ONE.intValue());
//            instancia.setPassword(StringMD.getStringMessageDigest(instancia.getPassword(), StringMD.SHA1));  ................................................. Comentario a la validacion de password.........................................................
//            System.out.println("Pass encriptado de la nueva instancia:" + instancia.getPassword());  ................................................. Comentario a la validacion de password.............................................................

//            ///Limpiando codigo
//            instancia.setDomicilio(limpiar.tuneaStringParaBD(instancia.getDomicilio()));
//            instancia.setNombre(limpiar.tuneaStringParaBD(instancia.getNombre()));
//            instancia.setPuesto(limpiar.tuneaStringParaBD(instancia.getPuesto()));
//            instancia.setRfc(limpiar.tuneaStringParaBD(instancia.getRfc()));
//            instancia.setTitular(limpiar.tuneaStringParaBD(instancia.getTitular()));
            List<Instancia> Unicos = daoInstancia.findBySpecificField("nombre", instancia.getNombre(), "equal", null, null);
            if (!Unicos.isEmpty())
            {
                //Inyectamos lo que traia en la colonia
                model.addAttribute("otra_colonia", otra_colonia);
                //Agregamos atributos al formulario
                model.addAttribute("preOrganizaciones", daoInstancia.findBySpecificField("estatus", "2", "equal", null, null));
//            model.addAttribute("instancia", new Instancia());
                model.addAttribute("tipoOrganizaciones", daoTipoOrganizacion.findBySpecificField("estatus", "1", "equal", null, null));
                LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
                ordenamiento.put("nombre", "asc");
                model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
                //Regresar codigo postal
                model.addAttribute("cp", codigo_postal);
                try
                {
                    model.addAttribute("idColonia", instancia.getIdColonia().getIdColonia());
                } catch (Exception e)
                {
                }
                model.addAttribute("error_sql", "<div class='alert alert-danger'>Lo sentimos ya existe una organización con el nombre" + instancia.getNombre() + "</div>");
                return "/Organizaciones/registroOrganizaciones";

            }

            try
            {
                daoInstancia.edit(instancia);
                System.out.println("Instancia Creada");
            } catch (Exception e)
            {
                result.addError(new ObjectError("error_sql", "Error de llave unica"));
                model.addAttribute("error_sql", "<div class='alert alert-danger'>Error de llave unica</div>");

                return "/Organizaciones/registroOrganizaciones";
            }
            return "/Organizaciones/confirmaRegOrganizacion";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/gdaAltaPreOrganizacion.do")
    public String gdaAltaPreOrganizacion(@Valid Instancia instancia, BindingResult result, Model model, String confirma_password, String codigo_postal, String otra_colonia, String existeCP, String existe_colonia, String idInstancia)
    {
        System.out.println("idInstancia:" + idInstancia);
        //Validacion
        new ValidacionesOrganizaciones().valGdaEditaInst(instancia, result, model, codigo_postal, otra_colonia, existeCP, confirma_password);

//        if (!confirma_password.equals(instancia.getPassword()))
//        {
//            result.addError(new ObjectError("confirma_passowrd", "Las contraseñas no coinciden"));
//            model.addAttribute("confirma_password", "<div class='alert alert-danger'>Las contraseñas no coinciden</div><script>document.getElementById('cambiaPass').style.display = 'block';</script>");
//        }                      ......................................................................................................................... Comentario a la validacion de password.............................................................
        if (result.hasErrors())
        {
            System.out.print("hubo errores");
            System.out.println(instancia.toString());
            System.out.println(result.toString());

            //Agregamos atributos al formulario
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("nombre", "asc");
            model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
            model.addAttribute("tipoOrganizaciones", daoTipoOrganizacion.findBySpecificField("estatus", "1", "equal", null, null));
            model.addAttribute("idInstancia", idInstancia);
            model.addAttribute("instanciaDireccion", daoInstancia.find(instancia.getIdInstancia()));
            //Regresar codigo postal
            model.addAttribute("cp", codigo_postal);
            model.addAttribute("otra_colonia", otra_colonia);
            try
            {
                model.addAttribute("idColonia", instancia.getIdColonia().getIdColonia());
            } catch (Exception e)
            {
            }
            return "/Organizaciones/confirmaOrganizacionVisitante";

        } else
        {

//             List<Instancia> Unicos = instanciaFacade.findBySpecificField("nombre", instancia.getNombre(), "equal", null, null);
//            if (!Unicos.isEmpty()) {
//                //Inyectamos lo que traia en la colonia
//                model.addAttribute("otra_colonia", otra_colonia);
//                //Agregamos atributos al formulario
//                model.addAttribute("preOrganizaciones", instanciaFacade.findBySpecificField("estatus", "2", "equal", null, null));
////            model.addAttribute("instancia", new Instancia());
//                model.addAttribute("tipoOrganizaciones", tipoOrganizacionFacade.findBySpecificField("estatus", "1", "equal", null, null));
//                LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
//                ordenamiento.put("nombre", "asc");
//                model.addAttribute("estados", estadosFacade.findAll(ordenamiento));
//                //Regresar codigo postal
//                model.addAttribute("cp", codigo_postal);
//                try {
//                    model.addAttribute("idColonia", instancia.getIdColonia().getIdColonia());
//                } catch (Exception e) {
//                }
//                model.addAttribute("error_sql", "<div class='alert alert-danger'>Lo sentimos el nombre " + instancia.getNombre() + " no esta dispobible</div>");
//                return "/Organizaciones/registroOrganizaciones";
//            }
//            .....................................................................................................REVISION DE SI DEBE DE TENER UN USUARIO LA INSTANCIA.DE.............................................................................................
//            List<Instancia> lista = instanciaFacade.findBySpecificField("usuario", instancia.getUsuario().toString(), "equal", null, null);
//            if (!lista.isEmpty())
//            {
//                //Agregamos atributos al formulario
//                LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
//                ordenamiento.put("nombre", "asc");
//                model.addAttribute("estados", estadosFacade.findAll(ordenamiento));
//                model.addAttribute("tipoOrganizaciones", tipoOrganizacionFacade.findBySpecificField("estatus", "1", "equal", null, null));
//                model.addAttribute("idInstancia", idInstancia);
//                model.addAttribute("instanciaDireccion", instanciaFacade.find(instancia.getIdInstancia()));
//                //Regresar codigo postal
//                model.addAttribute("cp", codigo_postal);
//                model.addAttribute("otra_colonia", otra_colonia);
//                model.addAttribute("error_usuario", "<div class='alert alert-danger'>Este usuario no esta disponible, introduzca otro nombre de usuraio</div>");
//                try
//                {
//                    model.addAttribute("idColonia", instancia.getIdColonia().getIdColonia());
//                } catch (Exception e)
//                {
//                }
//                return "/Organizaciones/confirmaOrganizacionVisitante";
//            }
//               .....................................................................................................REVISION DE SI DEBE DE TENER UN USUARIO LA INSTANCIA.DE.............................................................................................
//             .....................................................................................................REVISION DE SI DEBE DE TENER UN CORREO LA INSTANCIA.DE.............................................................................................
//            List<Instancia> lista2 = instanciaFacade.findBySpecificField("correo", instancia.getCorreo().toString(), "equal", null, null);
//            if (!lista2.isEmpty())
//            {
//                //Agregamos atributos al formulario
//                LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
//                ordenamiento.put("nombre", "asc");
//                model.addAttribute("estados", estadosFacade.findAll(ordenamiento));
//                model.addAttribute("tipoOrganizaciones", tipoOrganizacionFacade.findBySpecificField("estatus", "1", "equal", null, null));
//                model.addAttribute("idInstancia", idInstancia);
//                model.addAttribute("instanciaDireccion", instanciaFacade.find(instancia.getIdInstancia()));
//                //Regresar codigo postal
//                model.addAttribute("cp", codigo_postal);
//                model.addAttribute("otra_colonia", otra_colonia);
//                model.addAttribute("error_correo", "<div class='alert alert-danger'>Este correo ya ha sido registrado</div>");
//                try
//                {
//                    model.addAttribute("idColonia", instancia.getIdColonia().getIdColonia());
//                } catch (Exception e)
//                {
//                }
//                return "/Organizaciones/confirmaOrganizacionVisitante";
//            }
//             .....................................................................................................REVISION DE SI DEBE DE TENER UN CORREO LA INSTANCIA.DE.............................................................................................
            System.out.print("no hubo errores");
            instancia.setIdInstancia(BigDecimal.valueOf(Double.parseDouble(idInstancia)));
//            instancia.setValidacionAdmin(BigInteger.ZERO);    .....................................................................................................COMENTARIO A LA LINEA DE VALIDACION ADMINISTRADOR  .............................................................................................
//              instancia.setEstatus(BigInteger.ONE);// .......................................................................................................Correción de convarsion de staus..............................................
            instancia.setStatus((short) BigInteger.ONE.intValue());
//            instancia.setPassword(StringMD.getStringMessageDigest(instancia.getPassword(), StringMD.SHA1));// .....................................................................................................COMENTARIO A LA LINEA DE VALIDACION PASSWORD .............................................................................................

            ///Limpiando codigo
//            instancia.setDomicilio(limpiar.tuneaStringParaBD(instancia.getDomicilio()));
//            instancia.setPassword(StringMD.getStringMessageDigest(instancia.getPassword(), StringMD.SHA1));//.....................................................................................................COMENTARIO A LA LINEA DE VALIDACION PASSWORD .............................................................................................
//            instancia.setNombre(limpiar.tuneaStringParaBD(instancia.getNombre()));
//            instancia.setPuesto(limpiar.tuneaStringParaBD(instancia.getPuesto()));
//            instancia.setRfc(limpiar.tuneaStringParaBD(instancia.getRfc()));
//            instancia.setTitular(limpiar.tuneaStringParaBD(instancia.getTitular()));
            try
            {
                daoInstancia.edit(instancia);
            } catch (Exception e)
            {
                System.out.println(e);
                result.addError(new ObjectError("error_sql", "error de llave unica"));
                model.addAttribute("error_sql", "<div class='alert alert-danger'>Este usuario no esta disponible, introduzca otro nombre de usuraio</div>");

                return "/Organizaciones/registroOrganizaciones";
            }
            return "/Organizaciones/confirmaRegOrganizacion";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/gdaAdminAltaOrganizacion.do")
    public String gdaAdminAltaOrganizacion(@Valid Instancia instancia, BindingResult result, Model model, String codigo_postal, String otra_colonia, String existeCP, String estado, String municipio, String ciudad, HttpSession session, HttpServletRequest request)
    {
        System.out.println("hola admin gda alta organizacion");

        //Validacion
        new ValidacionesOrganizaciones().valAltaAdminInst(instancia, result, model, codigo_postal, existeCP, otra_colonia);
        try
        {
            Integer.parseInt(codigo_postal);
        } catch (NumberFormatException e)
        {
            model.addAttribute("error_codigo_postal", "<div class='alert alert-danger'>Lo codigo postal debe de ser numerico</div>");
            //Agregamos atributos al formulario
            model.addAttribute("tipoOrganizaciones", daoTipoOrganizacion.findBySpecificField("estatus", "1", "equal", null, null));
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("nombre", "asc");
            model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
            //Regresar codigo postal
            model.addAttribute("cp", codigo_postal);
            model.addAttribute("otra_colonia", otra_colonia);
            try
            {
                model.addAttribute("idColonia", instancia.getIdColonia().getIdColonia());
            } catch (Exception ex)
            {
            }
            return "/Organizaciones/altaAdminOrganizacion";
        }

        if (result.hasErrors())
        {
            System.out.print("hubo errores .... preparando actualizacion BD(Instancia)");
            System.out.println(instancia.toString());
            System.out.println(result.toString());

            //Agregamos atributos al formulario
            model.addAttribute("tipoOrganizaciones", daoTipoOrganizacion.findBySpecificField("estatus", "1", "equal", null, null));
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("nombre", "asc");
            model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
            //Regresar codigo postal
            model.addAttribute("cp", codigo_postal);
            model.addAttribute("otra_colonia", otra_colonia);
            try
            {
                model.addAttribute("idColonia", instancia.getIdColonia().getIdColonia());
            } catch (Exception e)
            {
            }
            return "/Organizaciones/altaAdminOrganizacion";
        } else
        {
            System.out.print("No hubo errores....se procede a insertar en Instancia");
//            instancia.setValidacionAdmin(BigInteger.ONE);//.....................................................................................................COMENTARIO A LA LINEA DE VALIDACION ADMINISTRADOR  .............................................................................................
//              instancia.setEstatus(BigInteger.ONE);// .......................................................................................................Correción de convarsion de staus..............................................
            instancia.setStatus((short) BigInteger.ONE.intValue());
            ///Limpiando codigo
            instancia.setDomicilio(limpiar.tuneaStringParaBD(instancia.getDomicilio()));
            instancia.setNombre(limpiar.tuneaStringParaBD(instancia.getNombre()));
//            instancia.setPuesto(limpiar.tuneaStringParaBD(instancia.getPuesto()));//.....................................................................................................COMENTARIO A LA LINEA DE VALIDACION PUESTO  .............................................................................................
            instancia.setRfc(limpiar.tuneaStringParaBD(instancia.getRfc()));
            UsuarioInstancia usuario = (UsuarioInstancia) daoUsuarioInstancia.find(BigDecimal.valueOf(1));
            System.out.println(usuario.getApellidoMat());
            System.out.println(usuario.getIdUsuarioInstancia());
            instancia.setUsuarioInstancia(usuario);
//            instancia.setTitular(limpiar.tuneaStringParaBD(instancia.getTitular()));//.....................................................................................................COMENTARIO A LA LINEA DE VALIDACION TITULAR  .............................................................................................
//            instancia.setPassword(StringMD.getStringMessageDigest(instancia.getPassword(), StringMD.SHA1));//.....................................................................................................COMENTARIO A LA LINEA DE VALIDACION  PASSWORD  .............................................................................................

            List<Instancia> Unicos = daoInstancia.findBySpecificField("nombre", instancia.getNombre(), "equal", null, null);
            if (!Unicos.isEmpty())
            {
                //Inyectamos lo que traia en la colonia
                model.addAttribute("otra_colonia", otra_colonia);
                //Agregamos atributos al formulario
                model.addAttribute("preOrganizaciones", daoInstancia.findBySpecificField("estatus", "2", "equal", null, null));
//            model.addAttribute("instancia", new Instancia());
                model.addAttribute("tipoOrganizaciones", daoTipoOrganizacion.findBySpecificField("estatus", "1", "equal", null, null));
                LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
                ordenamiento.put("nombre", "asc");
                model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
                //Regresar codigo postal
                model.addAttribute("cp", codigo_postal);
                try
                {
                    model.addAttribute("idColonia", instancia.getIdColonia().getIdColonia());
                } catch (Exception e)
                {
                }
                model.addAttribute("error_sql", "<div class='alert alert-danger'>Lo sentimos ya existe una organización con el nombre" + instancia.getNombre() + "</div>");
                return "/Organizaciones/altaAdminOrganizacion";

            }

            daoInstancia.create(instancia);
            System.out.println("Insercion correcta!");
            return "/Organizaciones/confirmaAdminRegOrganizacion";
        }
    }
    //Una organizacion da de alta un proyecto

    @RequestMapping(method = RequestMethod.POST, value = "/gdaAltaProyecto.do")
    public String gdaAltaProyecto(@Valid Proyectos proyecto, BindingResult result, Model model, String nActividades, String nPerfiles, String cadenaActividades, String selectto, String codigo_postal, String otra_colonia, String existeCP, String estado, String municipio, String ciudad, HttpSession session, HttpServletRequest request)
    {
        if (new ValidaSesion().validaOrganizacion(session, request))
        {
            System.out.println("hola gda alta organizacion");

            //Validaciones
            System.out.println("Validar");
            new ValidacionesOrganizaciones().valAltaAdminProy(proyecto, result, model, codigo_postal, existeCP, otra_colonia);

            //Desglose de Actividades
            ActividadesModel actividadesModel = new ActividadesModel(cadenaActividades);

            //Valida Actividades
            if (!actividadesModel.validarInsercionActividades().isSuccess())
            {
                result.addError(new ObjectError("actividades", actividadesModel.validarInsercionActividades().getMensaje()));
            }
            model.addAttribute("validacion_actividades", actividadesModel.validarInsercionActividades().getMensaje());

            if (result.hasErrors())
            {
                System.out.print("hubo errores");
                System.out.println(proyecto.toString());
                System.out.println("Error:" + result.toString());

                //Estados
                LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
                ordenamiento.put("nombre", "asc");
                model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
                //TipoProyecto
                model.addAttribute("tipoProyecto", daoTipoProyecto.findBySpecificField("status", "1", "equal", null, null));
                //Perfil
                model.addAttribute("perfiles", daoPerfil.findBySpecificField("estatus", "1", "equal", null, null));
                //Programa
                model.addAttribute("programas", daoPrograma.findBySpecificField("status", "1", "equal", null, null));
                //Regresar codigo postal
                model.addAttribute("cp", codigo_postal);
                try
                {
                    model.addAttribute("idColonia", proyecto.getIdColonia().getIdColonia());
                } catch (Exception e)
                {
                }
                //Regresar codigo postal
                model.addAttribute("otra_colonia", otra_colonia);

                //Regresa las Organizaciones
                List<Instancia> listaInstancias = daoInstancia.findBySpecificField("validacionAdmin", "1", "equal", null, null);
                ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();

                for (int i = 0; i < listaInstancias.size(); i++)
                {
//                    int estatus = Integer.parseInt(listaInstancias.get(i).getEstatus().toString());//.....................................................................................................Corrección Status conversión  .............................................................................................
                    int estatus = (int) listaInstancias.get(i).getStatus();
                    if (estatus == 1 || estatus == 2)
                    {
                        filtroInstancias.add(listaInstancias.get(i));
                    }
                }
                model.addAttribute("instancias", filtroInstancias);

                //Regresar actividades
                model.addAttribute("nActividades", nActividades.substring(0, 1));
                System.out.println("nActividades:" + nActividades.substring(0, 1));

                for (int i = 0; i < actividadesModel.actividades.size(); i++)
                {
                    model.addAttribute("actividad" + i, actividadesModel.actividades.get(i));
                    System.out.println("Regresando Actividad:" + actividadesModel.actividades.get(i));
                }
                model.addAttribute("proyecto", proyecto);

                return "/Organizaciones/altaProyecto";
            } else
            {

                System.out.print("no hubo errores");

                //Checa codigo postal
                CodigosPostalesModel codigosPostales = new CodigosPostalesModel(daoColonia, daoCodigosPostales, daoEstadosSia,
                        daoMunicipiosSia, daoCiudades, daoTipoLocalidad);
                if (existeCP.equals("true"))
                {
                    if (proyecto.getIdColonia().getIdColonia().toString().equals("0"))
                    {
                        //Agregar colonia                   
                        proyecto.setIdColonia(codigosPostales.agregaColonia(codigo_postal, otra_colonia));
                    }
                } else
                {
                    //Agregar codigo postal + colonia
                    proyecto.setIdColonia(codigosPostales.agregarCodigoPostal(codigo_postal, otra_colonia, estado, municipio, ciudad));
                }

                proyecto.setValidacionAdmin(BigInteger.ZERO);
                proyecto.setEstatus(BigInteger.ONE);
                proyecto.setFechaAlta(new Date());
                proyecto.setVacantesDisponibles(proyecto.getVacantes());
                System.out.println("idInstancia:" + proyecto.getIdInstancia().getIdInstancia());
                //Convertir a mayuscular
                proyecto.setDomicilio(limpiar.tuneaStringParaBD(proyecto.getDomicilio()));
                proyecto.setNombre(limpiar.tuneaStringParaBD(proyecto.getNombre()));
                proyecto.setNombreResponsable(limpiar.tuneaStringParaBD(proyecto.getNombreResponsable()));
                proyecto.setResponsablePuesto(limpiar.tuneaStringParaBD(proyecto.getResponsablePuesto()));
                //Imprimir todo
                System.out.println("Datos del alumno");
                System.out.println("Nombre:" + proyecto.getNombre() + " len:" + proyecto.getNombre().length());
                System.out.println("Vacantes:" + proyecto.getVacantes() + " len:" + proyecto.getVacantes().toString().length());
                System.out.println("Vacantes disponibles:" + proyecto.getVacantesDisponibles() + " len:" + proyecto.getVacantesDisponibles().toString().length());
                System.out.println("Responsable puesto:" + proyecto.getResponsablePuesto() + " len:" + proyecto.getResponsablePuesto().length());
                System.out.println("Nombre Responsable:" + proyecto.getNombreResponsable() + " len:" + proyecto.getNombreResponsable().length());
                System.out.println("Telefono responsable:" + proyecto.getTelefonoResponsable() + " len:" + (proyecto.getTelefonoResponsable() + "").length());
                System.out.println("Domicilio:" + proyecto.getDomicilio() + " len:" + proyecto.getDomicilio().length());
                System.out.println("Id colonia:" + proyecto.getIdColonia().getIdColonia() + " len:" + proyecto.getIdColonia().getIdColonia().toString().length());
                System.out.println("Id tipo proyecto:" + proyecto.getIdTipoProyecto().getIdTipoProyecto() + " len:" + proyecto.getIdTipoProyecto().getIdTipoProyecto().toString().length());
                System.out.println("Id programa:" + proyecto.getIdPrograma().getIdPrograma() + " len:" + proyecto.getIdPrograma().getIdPrograma().toString().length());
                System.out.println("Modalidad:" + proyecto.getModalidad() + " len:" + proyecto.getModalidad().length());
                System.out.println("fin");
                //
                daoProyectos.create(proyecto);
                System.out.println("Insercion correcta!");

                //Obtenemos el proyecto creado
                LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
                ordenamiento.put("idProyecto", "desc");
                Proyectos newProyecto = (Proyectos) daoProyectos.findAll(ordenamiento).get(0);

                //Insercion de Actividades
                for (int i = 0; i < actividadesModel.actividades.size(); i++)
                {
                    Actividades actividad = new Actividades();
                    actividad.setDetalle(limpiar.tuneaStringParaBD(actividadesModel.actividades.get(i)));
                    actividad.setEstatus(BigInteger.ONE);
                    actividad.setIdProyecto(newProyecto);
                    daoActividades.create(actividad);
                    System.out.println("Se inserto la actividad: " + actividad.getDetalle() + " en el proyecto: " + actividad.getIdProyecto().getNombre());
                }
                //Insercion de Perfiles
                //ProyectoPerfilModel proyectoPerfilModel;
                if (selectto != null)
                {
                    //proyectoPerfilModel = new ProyectoPerfilModel(selectto);                
                    //Analisis de la cadena
                    StringTokenizer token = new StringTokenizer(selectto, ",");
                    ArrayList<Perfil> perfiles = new ArrayList<Perfil>();

                    System.out.println("Analizar cadena:" + selectto);
                    System.out.println("No de tokens:" + token.countTokens());
                    while (token.hasMoreTokens())
                    {
                        String perfil = token.nextToken();
                        System.out.println("Token:" + perfil);
                        if (perfil != null && !perfil.equals(""))
                        {
                            perfiles.add((Perfil) daoPerfil.find(BigDecimal.valueOf(Double.parseDouble(perfil))));
                        }
                    }
                    for (int i = 0; i < perfiles.size(); i++)
                    {
                        ProyectoPerfil proyectoPerfil = new ProyectoPerfil();
                        proyectoPerfil.setIdPerfil(perfiles.get(i));
                        proyectoPerfil.setIdProyecto(newProyecto);
                        daoProyectoPerfil.create(proyectoPerfil);
                        System.out.println("Perfil insertado: " + proyectoPerfil.getIdPerfil().getNombre() + " En proyecto :" + proyectoPerfil.getIdProyecto().getNombre());
                    }
                } else
                {
                    System.out.println("No se agregaran perfiles");
                }

                return "/Organizaciones/confirmaAltaProyectos";
            }
        } else
        {
            model.addAttribute("error", "<div class='alert alert-danger'>Debes iniciar sesió para acceder a esta sección.</div>");
            return "redirect:login.do";
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/gdaAltaAdminProyecto.do")
    public String gdaAdminAltaProyecto(@Valid Proyectos proyecto, BindingResult result, Model model,
            String nActividades, String cadenaActividades, String cadenaPerfiles, String codigo_postal,
            String otra_colonia, String existeCP, String estado, String municipio, String ciudad, HttpSession session, HttpServletRequest request)
    {
        System.err.println("Preparando para insertar nuevo proyecto");

        //Validaciones
        System.err.println("Validando");
        new ValidacionesOrganizaciones().valAltaAdminProy(proyecto, result, model, codigo_postal, existeCP, otra_colonia);

        //Desglose de Actividades
        ActividadesModel actividadesModel = new ActividadesModel(cadenaActividades);

        //Valida Actividades
        if (!actividadesModel.validarInsercionActividades().isSuccess())
        {
            result.addError(new ObjectError("actividades", actividadesModel.validarInsercionActividades().getMensaje()));
        }        
        model.addAttribute("validacion_actividades", actividadesModel.validarInsercionActividades().getMensaje());

        if (result.hasErrors())
        {
            System.out.print("hubo errores");
            System.out.println(proyecto.toString());
            System.out.println("Error:" + result.toString());

            //Organizacion
            List<Instancia> listaInstancias = daoInstancia.findBySpecificField("status", "1", "equal", null, null);
            ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();
            for (int i = 0; i < listaInstancias.size(); i++)
            {
//                 int estatus = Integer.parseInt(listaInstancias.get(i).getEstatus().toString());//.....................................................................................................Corrección Status conversión  .............................................................................................
                int estatus = (int) listaInstancias.get(i).getStatus();
                if ((estatus == 1) || (estatus == 2))
                {
                    filtroInstancias.add(listaInstancias.get(i));
                }
            }
            model.addAttribute("instancias", filtroInstancias);

            //Estados
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("nombre", "asc");
            model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
            //TipoProyecto
            model.addAttribute("tipoProyecto", daoTipoProyecto.findBySpecificField("status", "1", "equal", null, null));
            //Perfil
            model.addAttribute("perfiles", daoPerfil.findBySpecificField("estatus", "1", "equal", null, null));
            //Programa
            model.addAttribute("programas", daoPrograma.findBySpecificField("status", "1", "equal", null, null));
            //Regresar codigo postal
            model.addAttribute("cp", codigo_postal);
            model.addAttribute("otra_colonia", otra_colonia);
            try
            {
                model.addAttribute("idColonia", proyecto.getIdColonia().getIdColonia());
            } catch (Exception e)
            {
            }

            //Regresar actividades
            model.addAttribute("nActividades", nActividades.substring(0, 1));
            System.out.println("nActividades:" + nActividades.substring(0, 1));

            for (int i = 0; i < actividadesModel.actividades.size(); i++)
            {
                model.addAttribute("actividad" + i, actividadesModel.actividades.get(i));
                System.out.println("Regresando Actividad:" + actividadesModel.actividades.get(i));
            }
            model.addAttribute("proyecto", proyecto);

            return "/Organizaciones/altaAdminProyecto";
        } else
        {

            System.out.print("no hubo errores");
            proyecto.setValidacionAdmin(BigInteger.ONE);
            proyecto.setEstatus(BigInteger.ONE);
            proyecto.setFechaAlta(new Date());
            proyecto.setVacantesDisponibles(proyecto.getVacantes());

            //Convertir a mayusculas
            proyecto.setDomicilio(limpiar.tuneaStringParaBD(proyecto.getDomicilio()));
            proyecto.setNombre(limpiar.tuneaStringParaBD(proyecto.getNombre()));
            proyecto.setNombreResponsable(limpiar.tuneaStringParaBD(proyecto.getNombreResponsable()));
            proyecto.setResponsablePuesto(limpiar.tuneaStringParaBD(proyecto.getResponsablePuesto()));
            proyecto.setIdInstancia(instanciaFacade.find(proyecto.getIdInstancia().getIdInstancia()));

            System.out.println("el nombre del proyecto es: " + proyecto.getNombre());
            daoProyectos.create(proyecto);
            System.out.println("Insercion correcta!");

            List<Proyectos> listaProyectos = daoProyectos.findAll();
            for (int i = 0; i < listaProyectos.size(); i++)
            {
                System.out.println("el id del proyecto es: " + listaProyectos.get(i).getIdProyecto() + " y el nombre del proyecto es: " + listaProyectos.get(i).getNombre());
            }
            //Obtenemos el proyecto creado
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("idProyecto", "desc");
            Proyectos newProyecto = (Proyectos) daoProyectos.findAll(ordenamiento).get(0);

            //Insercion de Actividades
            for (int i = 0; i < actividadesModel.actividades.size(); i++)
            {
                Actividades actividad = new Actividades();
                actividad.setDetalle(limpiar.tuneaStringParaBD(actividadesModel.actividades.get(i)));
                actividad.setEstatus(BigInteger.ONE);
                actividad.setIdProyecto(newProyecto);
                daoActividades.create(actividad);
                System.out.println("Se inserto la actividad: " + actividad.getDetalle() + " en el proyecto: " + actividad.getIdProyecto().getNombre());
            }

            //Insercion de Perfiles
            if (cadenaPerfiles != null)
            {
                //Analisis de la cadena
                StringTokenizer token = new StringTokenizer(cadenaPerfiles, ",");
                ArrayList<Perfil> perfiles = new ArrayList<Perfil>();

                System.out.println("Analizar cadena:" + cadenaPerfiles);
                System.out.println("No de tokens:" + token.countTokens());
                while (token.hasMoreTokens())
                {
                    String perfil = token.nextToken();
                    System.out.println("Token:" + perfil);
                    if (perfil != null && !perfil.equals(""))
                    {
                        perfiles.add((Perfil) daoPerfil.find(BigDecimal.valueOf(Double.parseDouble(perfil))));
                    }
                }
                for (int i = 0; i < perfiles.size(); i++)
                {
                    ProyectoPerfil proyectoPerfil = new ProyectoPerfil();
                    proyectoPerfil.setIdPerfil(perfiles.get(i));
                    proyectoPerfil.setIdProyecto(newProyecto);
                    daoProyectoPerfil.create(proyectoPerfil);
                    System.out.println("Perfil insertado: " + proyectoPerfil.getIdPerfil().getNombre() + " En proyecto :" + proyectoPerfil.getIdProyecto().getNombre());
                }
            } else
            {
                System.out.println("No se agregaran perfiles");
            }

            return "redirect:administrarProyectos.do";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cargarPerfiles.do")
    public @ResponseBody
    PerfilJSON cargarPerfiles(Model model, String cp)
    {

        //Fabricacion de objeto
        List<Perfil> perfiles = daoPerfil.findBySpecificField("estatus", "1", "equal", null, null);
        PerfilJSON perfilJSON = new PerfilJSON();
        System.out.println("Perfiles:");
        for (int i = 0; i < perfiles.size(); i++)
        {
            System.out.println(perfiles.get(i).getNombre());
            perfilJSON.getIdPerfil().add(perfiles.get(i).getIdPerfil() + "");
            perfilJSON.getNombre().add(perfiles.get(i).getNombre());
        }
        return perfilJSON;
    }

    //Alta de organizacion por pre-registro
    @RequestMapping(method = RequestMethod.POST, value = "/confirmaOrganizacionVisitante.do")
    public String confirmaOrganizacionVisitante(Model model, String idInstancia)
    {
        System.out.println("Id instancia:" + idInstancia);
        model.addAttribute("estados", daoEstadosSia.findAll());
        model.addAttribute("tipoOrganizaciones", daoTipoOrganizacion.findBySpecificField("estatus", "1", "equal", null, null));
        model.addAttribute("idInstancia", idInstancia);
        model.addAttribute("instanciaDireccion", daoInstancia.find(BigDecimal.valueOf(Integer.parseInt(idInstancia))));
        model.addAttribute("instancia", daoInstancia.find(BigDecimal.valueOf(Integer.parseInt(idInstancia))));

        return "/Organizaciones/confirmaOrganizacionVisitante";
    }

    //Alta de organizacion por pre-registro
    @RequestMapping(method = RequestMethod.GET, value = "/confirmaRegOrganizacion.do")
    public String confirmaRegOrganizacion(Model model)
    {
        return "/Organizaciones/confirmaRegOrganizacion";
    }

    //Alta de organizacion por pre-registro
    @RequestMapping(method = RequestMethod.GET, value = "/confirmaAdminRegOrganizacion.do")
    public String confirmaAdminRegOrganizacion(Model model)
    {
        return "/Organizaciones/confirmaAdminRegOrganizacion";
    }

    //Alta de organizacion por pre-registro
    @RequestMapping(method = RequestMethod.GET, value = "/pruebaFacade.do")
    public String pruebaFacade(Model model)
    {
        prueba pruebaa = new prueba();
        pruebaa.prueba(instanciaFacade);
        //model.addAttribute("organizaciones", consulta.getOrganizacionesPreRegistradas());
        return "/paginaPrueba";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/perfilOrganizacion.do")
    public String perfilOrganizacion(Model model, HttpSession session, HttpServletRequest request, String mensaje)
    {
        return "/Organizaciones/perfilOrganizaciones";
    }

    //Panel de organizaciones (usuarios)
    @RequestMapping(method = RequestMethod.GET, value = "/panelOrganizacion.do")
    public String panelOrganizacion(Model model, HttpSession session, HttpServletRequest request, String mensaje)
    {
        if (new ValidaSesion().validaOrganizacion(session, request))
        {
            String idUsuarioInstancia = session.getAttribute("NCONTROL").toString();
            UsuarioInstancia uInstancia = (UsuarioInstancia) daoUsuarioInstancia
                    .find(BigDecimal.valueOf(Double.valueOf(idUsuarioInstancia)));
            List<Instancia> instanciasu = new ArrayList<Instancia>(uInstancia.getInstancias());

            System.err.println("Hay tantas intancias: " + instanciasu.size());
            model.addAttribute("numinstancias", instanciasu.size());
            model.addAttribute("instanciasu", instanciasu);
            model.addAttribute("nombre", session.getAttribute("NOMBRE"));
            if (session.getAttribute("MENSAJE") != null)
            {
                model.addAttribute("mensaje1", session.getAttribute("MENSAJE").toString());
            }
            return "/PanelOrganizacion/panelOrganizacion";
        }
        else
        {
            model.addAttribute("error", "<div class='alert alert-danger'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/gdaEdicionOrganizacion.do")
    public String gdaEdicionOrganizacion(@Valid Instancia instancia, BindingResult result, Model model, String confirma_password, String codigo_postal, String otra_colonia, String existeCP, String estado, String municipio, String ciudad, String idInstancia, String antiguoPass, HttpSession session, HttpServletRequest request)
    {
        System.out.println("idInstancia:" + idInstancia);
        //Validacion
        new ValidacionesOrganizaciones().valGdaEditaInst(instancia, result, model, codigo_postal, otra_colonia, existeCP, confirma_password);

        //Agregamos atributos al formulario
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("nombre", "asc");
        model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
        model.addAttribute("tipoOrganizaciones", daoTipoOrganizacion.findBySpecificField("estatus", "1", "equal", null, null));
        model.addAttribute("idInstancia", idInstancia);
        model.addAttribute("cp", codigo_postal);
        model.addAttribute("instancia", instancia);

        if (result.hasErrors())
        {
            System.out.print("hubo errores");
            System.out.println(instancia.toString());
            System.out.println(result.toString());

            return "/PanelOrganizacion/panelOrganizacion";

        } else
        {
            System.out.print("no hubo errores");
            instancia.setIdInstancia(BigDecimal.valueOf(Double.parseDouble(idInstancia)));
//            instancia.setValidacionAdmin(BigInteger.ZERO);()));//.........................................................................................comentario a validación de administrador...................................................
//            instancia.setEstatus(BigInteger.ONE);// .......................................................................................................Correción de convarsion de staus..............................................
            instancia.setStatus((short) BigInteger.ONE.intValue());
//            if (!instancia.getPassword().equals(""))
//            {
//                instancia.setPassword(StringMD.getStringMessageDigest(instancia.getPassword(), StringMD.SHA1));
//            } else
//            {
//                instancia.setPassword(antiguoPass);
//            }.....................................................................................................................comentario a validación de password.......................................................................

            ///Limpiando codigo
            instancia.setDomicilio(limpiar.tuneaStringParaBD(instancia.getDomicilio()));
            instancia.setNombre(limpiar.tuneaStringParaBD(instancia.getNombre()));
//            instancia.setPuesto(limpiar.tuneaStringParaBD(instancia.getPuesto()));//.........................................................................................comentario a validación de puesto...................................................
            instancia.setRfc(limpiar.tuneaStringParaBD(instancia.getRfc()));
//            instancia.setTitular(limpiar.tuneaStringParaBD(instancia.getTitular()));//.........................................................................................comentario a validación de TITULAr...................................................

            try
            {
                daoInstancia.edit(instancia);
                model.addAttribute("mensaje", "<p><span class='glyphicon glyphicon-ok-circle sizeIconValid'></span></p><h2>Información editada correctamente</h2>");
                model.addAttribute("idInstancia", idInstancia);
                model.addAttribute("instancia", instancia);

            } catch (Exception e)
            {
                result.addError(new ObjectError("error_sql", "Error de llave unica"));
                model.addAttribute("error_sql", "<div class='alert alert-danger'>Error de llave unica</div>");
            }
            return "/PanelOrganizacion/panelOrganizacion";
        }
    }

    //Propuesta del alumno para dar de alta Instancia/Proyecto
    @RequestMapping(method = RequestMethod.GET, value = "/propAlInstancia.do")
    public String propAlInstancia(Model model, String datos_personales, HttpSession session, HttpServletRequest request)
    {
        System.out.println("idDatosPersonales:" + datos_personales);

        //Formato Unico
        model.addAttribute("datos_personales", datos_personales);
        //Tipo organizacion
        model.addAttribute("tipoOrganizaciones", daoTipoOrganizacion.findBySpecificField("estatus", "1", "equal", null, null));
        //Estados
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("nombre", "asc");
        model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
        //TipoProyecto
        model.addAttribute("tipoProyecto", daoTipoProyecto.findBySpecificField("status", "1", "equal", null, null));
        //Perfil
        model.addAttribute("perfiles", daoPerfil.findBySpecificField("estatus", "1", "equal", null, null));
        //Programa
        model.addAttribute("programas", daoPrograma.findBySpecificField("status", "1", "equal", null, null));
        //Command
        model.addAttribute("propuesta", new PropAluInstProyBean());
        return "/Organizaciones/propAlInstancia";
    }

    //Propuesta del alumno para dar de alta Instancia/Proyecto
    @RequestMapping(method = RequestMethod.GET, value = "/propAlProyecto.do")
    public String propAlProyecto(Model model, String datos_personales, String idInstancia, HttpSession session, HttpServletRequest request)
    {
        System.out.println("idDatosPersonales:" + datos_personales);
        System.out.println("idInstancia:" + idInstancia);

        Instancia instancia = (Instancia) daoInstancia.find(BigDecimal.valueOf(Double.parseDouble(idInstancia)));
        model.addAttribute("nombreInstancia", instancia.getNombre());
        //Formato Unico
        model.addAttribute("datos_personales", datos_personales);
        //Estados
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("nombre", "asc");
        model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
        //TipoProyecto
        model.addAttribute("tipoProyecto", daoTipoProyecto.findBySpecificField("status", "1", "equal", null, null));
        //Perfil
        model.addAttribute("perfiles", daoPerfil.findBySpecificField("estatus", "1", "equal", null, null));
        //Programa
        model.addAttribute("programas", daoPrograma.findBySpecificField("status", "1", "equal", null, null));
        //Command
        Proyectos proyecto = new Proyectos();
        proyecto.setIdInstancia(instancia);
        model.addAttribute("proyecto", proyecto);

        return "/Organizaciones/propAlProyecto";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/gdaPropAlInstancia.do")
    public String gdaPropAlInstancia(@Valid PropAluInstProyBean propuesta, BindingResult result, Model model, String codigo_postal, String otra_colonia, String existeCP, String estado, String municipio, String ciudad, String selectfrom, String cadenaActividades, String codigo_postal2, String otra_colonia2, String existeCP2, String estado2, String municipio2, String ciudad2, String datos_personales, String nActividades, String selectto, HttpSession session, HttpServletRequest request)
    {
        System.out.println("Guardando propuesta de alumno de instancia");
        System.out.println("idDatos_personales:" + datos_personales);
        //Validacion
        new ValidacionesOrganizaciones().valPropAlInstancia(propuesta, result, model, codigo_postal, otra_colonia, existeCP, selectfrom, cadenaActividades, codigo_postal2, existeCP2, otra_colonia2);

        //Desglose de Actividades
        ActividadesModel actividadesModel = new ActividadesModel(cadenaActividades);

        //Valida Actividades
        if (!actividadesModel.validarInsercionActividades().isSuccess())
        {
            result.addError(new ObjectError("actividades", actividadesModel.validarInsercionActividades().getMensaje()));
            model.addAttribute("validacion_actividades", actividadesModel.validarInsercionActividades().getMensaje());
        }

        if (result.hasErrors())
        {
            System.out.println(result.toString());
            //Formato Unico
            model.addAttribute("datos_personales", datos_personales);
            //Command
            model.addAttribute("propuesta", propuesta);
            //Tipo organizacion
            model.addAttribute("tipoOrganizaciones", daoTipoOrganizacion.findBySpecificField("estatus", "1", "equal", null, null));
            //Estados
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("nombre", "asc");
            model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
            //TipoProyecto
            model.addAttribute("tipoProyecto", daoTipoProyecto.findBySpecificField("status", "1", "equal", null, null));
            //Perfil
            model.addAttribute("perfiles", daoPerfil.findBySpecificField("estatus", "1", "equal", null, null));
            //Programa
            model.addAttribute("programas", daoPrograma.findBySpecificField("status", "1", "equal", null, null));
            //Regresar actividades
            model.addAttribute("nActividades", nActividades.substring(0, 1));
            System.out.println("nActividades:" + nActividades.substring(0, 1));

            //Inyectamos lo que traia en la colonia1
            model.addAttribute("otra_colonia", otra_colonia);
            //Regresar codigo postal
            model.addAttribute("cp", codigo_postal);
            try
            {
                model.addAttribute("idColonia", propuesta.getIdColonia_instancia().getIdColonia());
            } catch (Exception e)
            {
            }
            //Inyectamos lo que traia en la colonia2
            model.addAttribute("otra_colonia2", otra_colonia2);
            //Regresar codigo postal
            model.addAttribute("cp2", codigo_postal2);
            try
            {
                model.addAttribute("idColonia2", propuesta.getIdColonia_proyecto().getIdColonia());
            } catch (Exception e)
            {
            }

            for (int i = 0; i < actividadesModel.actividades.size(); i++)
            {
                model.addAttribute("actividad" + i, actividadesModel.actividades.get(i));
                System.out.println("Regresando Actividad:" + actividadesModel.actividades.get(i));
            }

            return "/Organizaciones/propAlInstancia";

        } else
        {
            System.out.println("No hubo errores");
            //Checa codigo postal instancia
            CodigosPostalesModel codigosPostales = new CodigosPostalesModel(daoColonia, daoCodigosPostales, daoEstadosSia,
                    daoMunicipiosSia, daoCiudades, daoTipoLocalidad);
            if (existeCP.equals("true"))
            {
                if (propuesta.getIdColonia_instancia().getIdColonia().toString().equals("0"))
                {
                    //Agregar colonia                   
                    propuesta.setIdColonia_instancia(codigosPostales.agregaColonia(codigo_postal, otra_colonia));
                }
            } else
            {
                //Agregar codigo postal + colonia
                propuesta.setIdColonia_instancia(codigosPostales.agregarCodigoPostal(codigo_postal, otra_colonia, estado, municipio, ciudad));
            }
            //Colonia proyecto
            //Checa codigo postal
            if (existeCP2.equals("true"))
            {
                if (propuesta.getIdColonia_proyecto().getIdColonia().toString().equals("0"))
                {
                    //Agregar colonia                   
                    propuesta.setIdColonia_proyecto(codigosPostales.agregaColonia(codigo_postal, otra_colonia));
                }
            } else
            {
                //Agregar codigo postal + colonia
                propuesta.setIdColonia_proyecto(codigosPostales.agregarCodigoPostal(codigo_postal, otra_colonia, estado, municipio, ciudad));
            }
            //Se crea instancia
            Instancia instancia = new Instancia();
            instancia.setNombre(limpiar.tuneaStringParaBD(propuesta.getNombre_instancia()));
            instancia.setRfc(limpiar.tuneaStringParaBD(propuesta.getRfc()));
//            instancia.setTitular(limpiar.tuneaStringParaBD(propuesta.getTitular()));//.........................................................................................comentario a validación titular...................................................
//            instancia.setPuesto(limpiar.tuneaStringParaBD(propuesta.getPuesto_titular()));//.........................................................................................comentario a validación puesto...................................................
//            instancia.setTelefono(propuesta.getTelefono_titular());//.........................................................................................comentario a validación telefono...................................................
            instancia.setDomicilio(limpiar.tuneaStringParaBD(propuesta.getDomicilio_instancia()));
//            instancia.setValidacionAdmin(BigInteger.valueOf(0)); //No validado//.........................................................................................comentario a validación de puesto...................................................
//            instancia.setEstatus(BigInteger.valueOf(3)); //Propuesta de alumno//..........................................................................................correción de error de conversión.......................................................
            instancia.setStatus((short) BigInteger.valueOf(3).intValue());
            instancia.setTipoOrganizacion(new TipoOrganizacion());
            instancia.getTipoOrganizacion().setIdTipoOrganizacion(propuesta.getTipoOrganizacion().getIdTipoOrganizacion());
            instancia.setIdColonia(new Colonia());
            instancia.getIdColonia().setIdColonia(propuesta.getIdColonia_instancia().getIdColonia());
//            instancia.setExt(propuesta.getExt());//.........................................................................................comentario a validación de extension...................................................

            daoInstancia.create(instancia);
            System.out.println("Insercion  de intancia correcta!");

            //Obtenemos la instancia creada
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("idInstancia", "desc");
            Instancia newInstancia = (Instancia) daoInstancia.findAll(ordenamiento).get(0);

            //Creamos el proyecto
            Proyectos proyecto = new Proyectos();
            proyecto.setNombre(limpiar.tuneaStringParaBD(propuesta.getNombre_proyecto()));
            proyecto.setDomicilio(limpiar.tuneaStringParaBD(propuesta.getDomicilio_proyecto()));
            proyecto.setNombreResponsable(limpiar.tuneaStringParaBD(propuesta.getNombreResponsable()));
            proyecto.setResponsablePuesto(limpiar.tuneaStringParaBD(propuesta.getResponsablePuesto()));
            proyecto.setTelefonoResponsable(propuesta.getTelefonoResponsable());
            proyecto.setValidacionAdmin(BigInteger.ZERO); //NO validado
            proyecto.setEstatus(BigInteger.valueOf(2)); //Propuesto por el alumno
            proyecto.setModalidad(limpiar.tuneaStringParaBD(propuesta.getModalidad()));
            proyecto.setFechaAlta(new Date());
            proyecto.setVacantes(propuesta.getVacantes());
            proyecto.setVacantesDisponibles(propuesta.getVacantes());
            proyecto.setIdTipoProyecto(new TipoProyecto());
            proyecto.getIdTipoProyecto().setIdTipoProyecto(propuesta.getIdTipoProyecto().getIdTipoProyecto());
            proyecto.setIdPrograma(new Programa());
            proyecto.getIdPrograma().setIdPrograma(propuesta.getIdPrograma().getIdPrograma());
            proyecto.setIdColonia(new Colonia());
            proyecto.getIdColonia().setIdColonia(propuesta.getIdColonia_proyecto().getIdColonia());
            proyecto.setIdInstancia(newInstancia);

            daoProyectos.create(proyecto);
            System.out.println("Insercion de proyecto correcta");

            //Obtenemos el proyecto creado
            LinkedHashMap<String, String> ordenamiento2 = new LinkedHashMap<String, String>();
            ordenamiento2.put("idProyecto", "desc");
            Proyectos newProyecto = (Proyectos) daoProyectos.findAll(ordenamiento).get(0);

            //Insercion de Actividades
            for (int i = 0; i < actividadesModel.actividades.size(); i++)
            {
                Actividades actividad = new Actividades();
                actividad.setDetalle(limpiar.tuneaStringParaBD(actividadesModel.actividades.get(i)));
                actividad.setEstatus(BigInteger.ONE);
                actividad.setIdProyecto(newProyecto);
                daoActividades.create(actividad);
                System.out.println("Se inserto la actividad: " + actividad.getDetalle() + " en el proyecto: " + actividad.getIdProyecto().getNombre());
            }
            //Preparacion de usuario
            DatosPersonales datosPersonales = (DatosPersonales) daoDatosPersonales.find(BigDecimal.valueOf(Double.parseDouble(datos_personales)));
            System.out.println("Datos per" + datosPersonales.getNombre());
            List<FormatoUnico> listaFormatoUnico = daoFormatoUnico.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
            FormatoUnico formatoUnico = listaFormatoUnico.get(0);
            int idPerfilAlumno = datosPersonales.getAlumnoId().getCarreraId();
            boolean agregoSuPerfil = false;
            //Insercion de Perfiles
            //ProyectoPerfilModel proyectoPerfilModel;
            if (selectto != null)
            {
                //proyectoPerfilModel = new ProyectoPerfilModel(selectto);                
                //Analisis de la cadena
                StringTokenizer token = new StringTokenizer(selectto, ",");
                ArrayList<Perfil> perfiles = new ArrayList<Perfil>();

                //El perfil del alumno
                System.out.println("Analizar cadena:" + selectto);
                System.out.println("No de tokens:" + token.countTokens());
                while (token.hasMoreTokens())
                {
                    String perfil = token.nextToken();
                    System.out.println("Token:" + perfil);
                    if (perfil != null && !perfil.equals(""))
                    {
                        perfiles.add((Perfil) daoPerfil.find(BigDecimal.valueOf(Double.parseDouble(perfil))));
                        if (idPerfilAlumno == Integer.parseInt(perfil))
                        {
                            agregoSuPerfil = true;
                        }
                    }
                }
                for (int i = 0; i < perfiles.size(); i++)
                {
                    ProyectoPerfil proyectoPerfil = new ProyectoPerfil();
                    proyectoPerfil.setIdPerfil(perfiles.get(i));
                    proyectoPerfil.setIdProyecto(newProyecto);
                    daoProyectoPerfil.create(proyectoPerfil);
                    System.out.println("Perfil insertado: " + proyectoPerfil.getIdPerfil().getNombre() + " En proyecto :" + proyectoPerfil.getIdProyecto().getNombre());
                }
                //Agregamos su perfil si no lo agrego
                if (!agregoSuPerfil)
                {
                    Perfil suPerfil = (Perfil) daoPerfil.find(BigDecimal.valueOf(idPerfilAlumno));
                    ProyectoPerfil proyectoPerfil = new ProyectoPerfil();
                    proyectoPerfil.setIdPerfil(suPerfil);
                    proyectoPerfil.setIdProyecto(newProyecto);
                    daoProyectoPerfil.create(proyectoPerfil);

                    System.out.println("Perfil insertado: " + proyectoPerfil.getIdPerfil().getNombre() + " En proyecto :" + proyectoPerfil.getIdProyecto().getNombre());
                }
            } else
            {
                System.out.println("No se agregaran perfiles");
            }

            //Relacionar proyecto con formato unico
            formatoUnico.setIdproyecto(newProyecto);
            daoFormatoUnico.edit(formatoUnico);
            System.out.println("Relacion a formato unico correcta");

            return "/Organizaciones/confirmaAltaPropuesta";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/gdaPropAlProyecto.do")
    public String gdaPropAlProyecto(@Valid Proyectos proyecto, BindingResult result, Model model, String nActividades, String nPerfiles, String cadenaActividades, String selectto, String codigo_postal, String otra_colonia, String existeCP, String estado, String municipio, String ciudad, String datos_personales, HttpSession session, HttpServletRequest request)
    {
        System.out.println("hola admin gda alta organizacion");

        //Validaciones
        System.out.println("Validar");
        new ValidacionesOrganizaciones().valAltaAdminProy(proyecto, result, model, codigo_postal, existeCP, otra_colonia);

        //Desglose de Actividades
        ActividadesModel actividadesModel = new ActividadesModel(cadenaActividades);

        //Valida Actividades
        if (!actividadesModel.validarInsercionActividades().isSuccess())
        {
            result.addError(new ObjectError("actividades", actividadesModel.validarInsercionActividades().getMensaje()));
        }
        model.addAttribute("validacion_actividades", actividadesModel.validarInsercionActividades().getMensaje());

        if (result.hasErrors())
        {
            System.out.print("hubo errores");
            System.out.println(proyecto.toString());
            System.out.println("Error:" + result.toString());

            model.addAttribute("datos_personales", datos_personales);
            model.addAttribute("nombreInstancia", proyecto.getIdInstancia().getNombre());
            //Estados
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("nombre", "asc");
            model.addAttribute("estados", daoEstadosSia.findAll(ordenamiento));
            //TipoProyecto
            model.addAttribute("tipoProyecto", daoTipoProyecto.findBySpecificField("status", "1", "equal", null, null));
            //Perfil
            model.addAttribute("perfiles", daoPerfil.findBySpecificField("estatus", "1", "equal", null, null));
            //Programa
            model.addAttribute("programas", daoPrograma.findBySpecificField("status", "1", "equal", null, null));
            //Regresar codigo postal
            model.addAttribute("otra_colonia", otra_colonia);

            //Regresar codigo postal
            model.addAttribute("cp", codigo_postal);
            try
            {
                model.addAttribute("idColonia", proyecto.getIdColonia().getIdColonia());
            } catch (Exception e)
            {
            }

            //Regresar actividades
            model.addAttribute("nActividades", nActividades.substring(0, 1));
            System.out.println("nActividades:" + nActividades.substring(0, 1));

            for (int i = 0; i < actividadesModel.actividades.size(); i++)
            {
                model.addAttribute("actividad" + i, actividadesModel.actividades.get(i));
                System.out.println("Regresando Actividad:" + actividadesModel.actividades.get(i));
            }
            model.addAttribute("proyecto", proyecto);

            return "/Organizaciones/propAlProyecto";
        } else
        {

            System.out.print("no hubo errores");
            //Checa codigo postal
            CodigosPostalesModel codigosPostales = new CodigosPostalesModel(daoColonia, daoCodigosPostales, daoEstadosSia,
                    daoMunicipiosSia, daoCiudades, daoTipoLocalidad);
            if (existeCP.equals("true"))
            {
                if (proyecto.getIdColonia().getIdColonia().toString().equals("0"))
                {
                    //Agregar colonia                   
                    proyecto.setIdColonia(codigosPostales.agregaColonia(codigo_postal, otra_colonia));
                }
            } else
            {
                //Agregar codigo postal + colonia
                proyecto.setIdColonia(codigosPostales.agregarCodigoPostal(codigo_postal, otra_colonia, estado, municipio, ciudad));
            }

            proyecto.setValidacionAdmin(BigInteger.ZERO); //No validado
            proyecto.setEstatus(BigInteger.valueOf(2)); //Proyecto propuesto por alumno
            proyecto.setFechaAlta(new Date());
            proyecto.setVacantesDisponibles(proyecto.getVacantes());

            //Convertir a mayuscular
            proyecto.setDomicilio(limpiar.tuneaStringParaBD(proyecto.getDomicilio()));
            proyecto.setNombre(limpiar.tuneaStringParaBD(proyecto.getNombre()));
            proyecto.setNombreResponsable(limpiar.tuneaStringParaBD(proyecto.getNombreResponsable()));
            proyecto.setResponsablePuesto(limpiar.tuneaStringParaBD(proyecto.getResponsablePuesto()));
            System.out.println("###################");
            proyecto.getInfToBd();
            System.out.println("###################");
            daoProyectos.create(proyecto);
            System.out.println("Insercion correcta!");

            //Obtenemos el proyecto creado
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("idProyecto", "desc");
            Proyectos newProyecto = (Proyectos) daoProyectos.findAll(ordenamiento).get(0);

            //Insercion de Actividades
            for (int i = 0; i < actividadesModel.actividades.size(); i++)
            {
                Actividades actividad = new Actividades();
                actividad.setDetalle(limpiar.tuneaStringParaBD(actividadesModel.actividades.get(i)));
                actividad.setEstatus(BigInteger.ONE);
                actividad.setIdProyecto(newProyecto);
                daoActividades.create(actividad);
                System.out.println("Se inserto la actividad: " + actividad.getDetalle() + " en el proyecto: " + actividad.getIdProyecto().getNombre());
            }
            //Insercion de Perfiles
            //ProyectoPerfilModel proyectoPerfilModel;
            if (selectto != null)
            {
                //proyectoPerfilModel = new ProyectoPerfilModel(selectto);                
                //Analisis de la cadena
                StringTokenizer token = new StringTokenizer(selectto, ",");
                ArrayList<Perfil> perfiles = new ArrayList<Perfil>();

                System.out.println("Analizar cadena:" + selectto);
                System.out.println("No de tokens:" + token.countTokens());
                while (token.hasMoreTokens())
                {
                    String perfil = token.nextToken();
                    System.out.println("Token:" + perfil);
                    if (perfil != null && !perfil.equals(""))
                    {
                        perfiles.add(perfilFacade.find(BigDecimal.valueOf(Double.parseDouble(perfil))));
                    }
                }
                for (int i = 0; i < perfiles.size(); i++)
                {
                    ProyectoPerfil proyectoPerfil = new ProyectoPerfil();
                    proyectoPerfil.setIdPerfil(perfiles.get(i));
                    proyectoPerfil.setIdProyecto(newProyecto);
                    daoProyectoPerfil.create(proyectoPerfil);
                    System.out.println("Perfil insertado: " + proyectoPerfil.getIdPerfil().getNombre() + " En proyecto :" + proyectoPerfil.getIdProyecto().getNombre());
                }
            } else
            {
                System.out.println("No se agregaran perfiles");
            }

            //Relacionar proyecto con formato unico
            DatosPersonales datosPersonales = (DatosPersonales) daoDatosPersonales.find(BigDecimal.valueOf(Double.parseDouble(datos_personales)));
            System.out.println("Datos per" + datosPersonales.getNombre());
            List<FormatoUnico> listaFormatoUnico = daoFormatoUnico.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
            FormatoUnico formatoUnico = listaFormatoUnico.get(0);

            formatoUnico.setIdproyecto(newProyecto);
            daoFormatoUnico.edit(formatoUnico);
            System.out.println("Relacion a formato unico correcta");

            return "/Organizaciones/confirmaAltaPropuesta";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/verProyectos.do")
    public String verProyectos(Model model, HttpSession session, HttpServletRequest request)
    {
        if (new ValidaSesion().validaOrganizacion(session, request))
        {
            String idInstancia = session.getAttribute("NCONTROL").toString();
            Instancia instancia = (Instancia) daoInstancia.find(BigDecimal.valueOf(Double.parseDouble(idInstancia)));
            System.out.println("idInstancia:" + idInstancia);
            //Valida que no sea nula la collection
            ArrayList<Proyectos> listaProyectos = new ArrayList<Proyectos>();
            try
            {
                listaProyectos = new ArrayList<Proyectos>(instancia.getProyectosCollection());
            } catch (Exception e)
            {
                System.out.println("Lista de proyectos vacia");
            }
            System.out.println("proyectos:" + listaProyectos);
            ArrayList<Proyectos> filtroDeProyectos = new ArrayList<Proyectos>();
            //Muestra proyectos que esten activos, validados o no validados
            for (int i = 0; i < listaProyectos.size(); i++)
            {
                if (listaProyectos.get(i).getEstatus().toString().equals("1"))
                {
                    filtroDeProyectos.add(listaProyectos.get(i));
                }
            }

            //List<Proyectos> proyectos = proyectosFacade.findBySpecificField("idInstancia", idInstancia, "equal", null, null);
//            System.out.println("proyectos:"+proyectos);
            model.addAttribute("proyectos", filtroDeProyectos);
            return "/Organizaciones/verProyectos";
        } else
        {
            model.addAttribute("error", "<div class='alert alert-danger'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/verAlumnosProyecto.do")
    public String verAlumnosProyecto(BigDecimal id, Model model, HttpSession session, HttpServletRequest request)
    {
        logger.info("ID Proyecto " + id);
        ValidaSesion valSession = new ValidaSesion(session, request);
        if (valSession.validaOrganizacion() || valSession.validaAdmin() || valSession.validaConsultas() || valSession.validaOperador() || valSession.validaRegistro())
        {
            List<FormatoUnico> alumnos = new ArrayList<FormatoUnico>();
            Proyectos proyecto = (Proyectos) daoProyectos.find(id);
            try
            {
                alumnos = new ArrayList<FormatoUnico>(proyectosFacade.find(id).getFormatoUnicoCollection());
            } catch (Exception e)
            {
                System.out.println("Error cargando la lista");
            }
            model.addAttribute("alumnos", alumnos);
            model.addAttribute("proyecto", proyecto);

            return "/Organizaciones/verAlumnosProyecto";
        } else
        {
            model.addAttribute("error", "<div class='alert alert-danger'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
    }
}
