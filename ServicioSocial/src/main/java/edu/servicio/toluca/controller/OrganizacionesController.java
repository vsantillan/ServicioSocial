/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.EnviarCorreo;
import edu.servicio.toluca.beans.MetodosValidacion;
import edu.servicio.toluca.beans.StringMD;
import edu.servicio.toluca.beans.organizaciones.BorrarInstancia;
import edu.servicio.toluca.beans.organizaciones.BorrarProyecto;
import edu.servicio.toluca.entidades.Actividades;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.Perfil;
import edu.servicio.toluca.entidades.ProyectoPerfil;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.entidades.RetroalimentacionInstancia2;
import edu.servicio.toluca.entidades.RetroalimentacionProyecto2;
import edu.servicio.toluca.model.ActividadesModel;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.beans.organizaciones.ValidacionesOrganizaciones;
import edu.servicio.toluca.beans.organizaciones.ValidarProyectos;
import edu.servicio.toluca.entidades.Ciudades;
import edu.servicio.toluca.entidades.CodigosPostales;
import edu.servicio.toluca.entidades.Colonia;
import edu.servicio.toluca.entidades.EstadosSia;
import edu.servicio.toluca.entidades.MunicipiosSia;
import edu.servicio.toluca.entidades.TipoLocalidad;
import edu.servicio.toluca.sesion.ActividadesFacade;
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
import edu.servicio.toluca.sesion.RetroalimentacionInstancia2Facade;
import edu.servicio.toluca.sesion.RetroalimentacionProyecto2Facade;
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
import javax.validation.Valid;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    @EJB(mappedName = "java:global/ServicioSocial/ActividadesFacade")
    private ActividadesFacade actividadesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/RetroalimentacionInstancia2Facade")
    private RetroalimentacionInstancia2Facade retroalimentacionInstanciaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/RetroalimentacionProyecto2Facade")
    private RetroalimentacionProyecto2Facade retroalimentacionProyectoFacade;
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
    MetodosValidacion limpiar = new MetodosValidacion();

    @RequestMapping(method = RequestMethod.GET, value = "/administrarOrganizaciones.do")
    public String administradorOrganizaciones(Model model, HttpSession session, HttpServletRequest request) {
        List<Instancia> listaInstancias = instanciaFacade.findBySpecificField("validacionAdmin", "1", "equal", null, null);
        ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();
        System.out.println("Instancias");
        for (int i = 0; i < listaInstancias.size(); i++) {
            String estatus = listaInstancias.get(i).getEstatus().toString();
            if ((estatus.equals("1")) || (estatus.equals("2"))) {
                filtroInstancias.add(listaInstancias.get(i));
            }
        }
        model.addAttribute("organizaciones", filtroInstancias);
        model.addAttribute("retroalimentacionInstancia", new BorrarInstancia());
        return "/Organizaciones/administrarOrganizaciones";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/administrarProyectos.do")
    public String administradorProyectos(Model model, HttpSession session, HttpServletRequest request) {
        List<Proyectos> listaProyectos = proyectosFacade.findBySpecificField("estatus", "1", "equal", null, null);
        ArrayList<Proyectos> filtroDeProyectos = new ArrayList<Proyectos>();
        for (int i = 0; i < listaProyectos.size(); i++) {
            int validacionAdmin = Integer.parseInt(listaProyectos.get(i).getValidacionAdmin().toString());
            int estatus = Integer.parseInt(listaProyectos.get(i).getIdInstancia().getEstatus().toString());
            if ((validacionAdmin == 1) && (estatus == 1) && ((validacionAdmin == 1) || (validacionAdmin == 2))) {
                filtroDeProyectos.add(listaProyectos.get(i));

            }
        }
        model.addAttribute("proyectos", filtroDeProyectos);
        model.addAttribute("retroalimentacionProyecto", new BorrarProyecto());
        return "/Organizaciones/administrarProyectos";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/validarOrganizaciones.do")
    public String panelAdministradorOrganizaciones(Model model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("organizacion", instanciaFacade.findBySpecificField("validacionAdmin", "0", "equal", null, null));
        model.addAttribute("retroalimentacionInstancia", new BorrarInstancia());
        return "/Organizaciones/validarOrganizaciones";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateStatus.do")
    public @ResponseBody
    String actualizarStatusOrganizaciones(int id, Model model, HttpSession session, HttpServletRequest request) {
        Instancia instancia;
        instancia = instanciaFacade.find(BigDecimal.valueOf(id));
        instancia.setValidacionAdmin(BigInteger.valueOf(1));
        System.out.println("Ya actualizo");
        instanciaFacade.edit(instancia);

        return "ok";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateProyecto.do")
    public @ResponseBody
    String actualizarStatusProyecto(int id, Model model, HttpSession session, HttpServletRequest request) {
        Proyectos proyecto;
        proyecto = proyectosFacade.find(BigDecimal.valueOf(id));
        proyecto.setValidacionAdmin(BigInteger.valueOf(1));
        proyectosFacade.edit(proyecto);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/validarProyectos.do")
    public String panelAdministradorProyectos(Model model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("proyecto", proyectosFacade.findBySpecificField("validacionAdmin", "0", "equal", null, null));
        model.addAttribute("borrarProyecto", new BorrarProyecto());
        return "/Organizaciones/validarProyectos";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/retroalimentacionInstancia.do")
    public String retroalimentacionInstancia(int id, Model model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("instancia", instanciaFacade.find(BigDecimal.valueOf(id)));
        model.addAttribute("retroalimentacionInstancia", new BorrarInstancia());
        return "/Organizaciones/retroalimentacionInstancia";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/retroalimentacionProyecto.do")
    public String retoalimentacionProyectos(int id, Model model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("proyectos", proyectosFacade.find(BigDecimal.valueOf(id)));
        model.addAttribute("borrarProyecto", new BorrarProyecto());
        return "/Organizaciones/retroalimentacionProyectos";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detalleProyecto.do")
    public String detalleProyecto(BigDecimal id, Model model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("proyectoDetalle", proyectosFacade.find(id));
        return "/Organizaciones/detalleProyecto";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detalleOrganizacion.do")
    public String detalleOrganizacion(BigDecimal id, Model model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("instancia", instanciaFacade.find(id));
        return "/Organizaciones/detalleOrganizacion";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mensajeOrganizacion.do")
    public String mensajeOrganizacion(Model model, HttpSession session, HttpServletRequest request) {
        //Valida sesion
        if (new ValidaSesion().validaOrganizacion(session, request)) {
            return "/Organizaciones/mensajeOrganizacion";
        } else {
            model.addAttribute("error", "<div class='alert alert-danger'>Debes iniciar sesió para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
    }

    //Editar Organizacion
    @RequestMapping(method = RequestMethod.GET, value = "/editarOrganizacion.do")
    public String editarOrganizacion(int id, Model model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("instancia", instanciaFacade.find(BigDecimal.valueOf(id)));
        model.addAttribute("instanciaDireccion", instanciaFacade.find(BigDecimal.valueOf(id)));
        model.addAttribute("estados", estadosFacade.findAll());
        model.addAttribute("tipoOrganizaciones", tipoOrganizacionFacade.findBySpecificField("estatus", "1", "equal", null, null));
        return "/Organizaciones/editarOrganizacion";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modificarOrganizacion.do")
    public String modificarOrganizacion(@Valid Instancia instancia, BindingResult result, Model model, String confirma_password, int valid_pass, HttpSession session, HttpServletRequest request, String codigo_postal, String otra_colonia, String existeCP, String estado, String municipio, String ciudad) {
        System.out.println("contraseña:" + instancia.getPassword());
        System.out.println("confirma_contraseña:" + confirma_password);

        new ValidacionesOrganizaciones().valGdaEditaInst(instancia, result, model, codigo_postal, otra_colonia, existeCP, confirma_password);

        if (valid_pass == 1) {
            if (!confirma_password.equals(instancia.getPassword())) {
                result.addError(new ObjectError("confirma_passowrd", "Las contraseñas no coinciden"));
                model.addAttribute("confirma_password", "<div class='alert alert-danger'>Las contraseñas no coinciden</div><script>document.getElementById('cambiaPass').style.display = 'block';</script>");
            }
        }

        if (result.hasErrors()) {
            System.out.println("Con errores");
            System.out.println("Los errores son: " + result.toString());
            model.addAttribute("instanciaDireccion", instanciaFacade.find(instancia.getIdInstancia()));
            model.addAttribute("otra_colonia", otra_colonia);
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("nombre", "asc");
            model.addAttribute("estados", estadosFacade.findAll(ordenamiento));
            //Regresar codigo postal
            model.addAttribute("cp", codigo_postal);
            try {
                model.addAttribute("idColonia", instancia.getIdColonia().getIdColonia());
            } catch (Exception e) {
            }
            model.addAttribute("tipoOrganizaciones", tipoOrganizacionFacade.findBySpecificField("estatus", "1", "equal", null, null));
            return "/Organizaciones/editarOrganizacion";
        } else {
            //---------------------------A continuación código para agregar nueva colonia****************************************
            if (existeCP.equals("true")) {
                if (instancia.getIdColonia().getIdColonia().toString().equals("0")) {
                    //Agregar colonia                   
//                    instancia.setIdColonia(new CodigosPostalesController().agregaColonia(model, codigo_postal, otra_colonia));
                    System.out.println("AgregarColonia");
                    System.out.println("codigo postal:" + codigo_postal.toString());
                    List<CodigosPostales> codigosPostales = codigosPostalesFacade.findBySpecificField("cp", codigo_postal, "equal", null, null);
                    CodigosPostales codigoPostal = codigosPostales.get(0);
                    Colonia nvaColonia = new Colonia();
                    otra_colonia = limpiar.tuneaStringParaBD(otra_colonia);
                    nvaColonia.setNombre(otra_colonia);
                    nvaColonia.setIdCp(codigoPostal);
                    nvaColonia.setStatus(BigInteger.ONE);
                    coloniaFacade.create(nvaColonia);

                    //Obtenemos la ultima colonia
                    LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
                    ordenamiento.put("idColonia", "desc");
                    Colonia colonia = coloniaFacade.findAll(ordenamiento).get(0);
                    instancia.setIdColonia(colonia);
                    System.out.println("Nueva colonia agregada!");
                }
            } else {
                //Agregar codigo postal + colonia
//                instancia.setIdColonia(new CodigosPostalesController().agregarCodigoPostal(codigo_postal, otra_colonia, estado, municipio, ciudad));
                EstadosSia estadoP = estadosFacade.find(BigDecimal.valueOf(Double.parseDouble(estado)));
                MunicipiosSia municipioP = municipiosFacade.find(BigDecimal.valueOf(Double.parseDouble(municipio)));
                TipoLocalidad localidad = tipoLocalidadFacade.find(BigDecimal.ONE);
                Ciudades ciudadP = null;
                try {
                    ciudadP = ciudadesFacade.find(BigDecimal.valueOf(Double.parseDouble(ciudad)));
                } catch (Exception e) {
                    System.out.println("No tiene ciudad");
                }

                CodigosPostales codigoPostal = new CodigosPostales();
                codigoPostal.setCp(Integer.parseInt(codigo_postal));
                codigoPostal.setIdMunicipio(municipioP);
                codigoPostal.setIdEstado(estadoP);
                codigoPostal.setIdTipoLocalidad(localidad);
                if (ciudad != null) {
                    codigoPostal.setIdCiudad(ciudadP);
                }
                codigosPostalesFacade.create(codigoPostal);

                //Obtenemos el Ultimo codigo postal
                LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
                ordenamiento.put("idCp", "desc");
                CodigosPostales codigoPostalNew = codigosPostalesFacade.findAll(ordenamiento).get(0);

                Colonia colonia = new Colonia();
                colonia.setIdCp(codigoPostal);
                otra_colonia = limpiar.tuneaStringParaBD(otra_colonia);
                colonia.setNombre(otra_colonia);
                colonia.setStatus(BigInteger.ONE);

                coloniaFacade.create(colonia);

                //Obtenemos la ultima colonia
                ordenamiento = new LinkedHashMap<String, String>();
                ordenamiento.put("idColonia", "desc");
                Colonia coloniaNew = coloniaFacade.findAll(ordenamiento).get(0);
                instancia.setIdColonia(coloniaNew);
                System.out.println("Nuevo codigo postal + colonia agregado!");
            }
            //---------------------------Fin código para agregar nueva colonia****************************************

            //Encriptar contraseña de la instancia
            instancia.setPassword(StringMD.getStringMessageDigest(instancia.getPassword(), StringMD.SHA1));
            //Convirtiendo a mayusculas
            instancia.setDomicilio(instancia.getDomicilio().toUpperCase());
            instancia.setNombre(instancia.getNombre().toUpperCase());
            instancia.setPuesto(instancia.getPuesto().toUpperCase());
            instancia.setRfc(instancia.getRfc().toUpperCase());
            instancia.setTitular(instancia.getTitular().toUpperCase());
            //try-catch edita instancia
            try {
                instanciaFacade.edit(instancia);
            } catch (Exception e) {
                result.addError(new ObjectError("error_sql", "Error de llave unica"));
                model.addAttribute("error_sql", "<div class='alert alert-danger'>Error de llave unica</div>");

                return "/Organizaciones/editarOrganizacion";
            }
            System.out.println("Sin errores");

            //Consulta para la administracion de organizaciones
            List<Instancia> listaInstancias = instanciaFacade.findBySpecificField("validacionAdmin", "1", "equal", null, null);
            ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();
            for (int i = 0; i < listaInstancias.size(); i++) {
                int estatus = Integer.parseInt(listaInstancias.get(i).getEstatus().toString());
                if ((estatus == 1) || (estatus == 2)) {
                    filtroInstancias.add(listaInstancias.get(i));
                }
            }
            model.addAttribute("organizaciones", filtroInstancias);
            model.addAttribute("retroalimentacionInstancia", new BorrarInstancia());
            return "/Organizaciones/administrarOrganizaciones";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editarProyecto.do")
    public String editarProyectos(int id, Model model, HttpSession session, HttpServletRequest request) {
        Proyectos proyecto = proyectosFacade.find(BigDecimal.valueOf(id));
        model.addAttribute("proyecto", proyecto);
        model.addAttribute("proyectoDireccion", proyecto);
        List<Instancia> listaInstancias = instanciaFacade.findBySpecificField("estatus", "1", "equal", null, null);
        ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();
        for (int i = 0; i < listaInstancias.size(); i++) {
            int validacionAdmin = Integer.parseInt(listaInstancias.get(i).getValidacionAdmin().toString());
            if ((validacionAdmin == 1) || (validacionAdmin == 2)) {
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
        listaPerfil = perfilFacade.findAll();
        boolean agregar;
        String nombrePerfilCollection;
        for (int i = 0; i < listaPerfil.size(); i++) {
            agregar = true;
            iteratorProyectosPerfilCollection = proyectosFacade.find(BigDecimal.valueOf(id)).getProyectoPerfilCollection().iterator();
            while (iteratorProyectosPerfilCollection.hasNext()) {
                nombrePerfilCollection = iteratorProyectosPerfilCollection.next().getIdPerfil().getNombre();
                if (!listaPerfil.get(i).getNombre().equals(nombrePerfilCollection) && agregar) {
                    agregar = true;
                } else {
                    agregar = false;
                }
            }
            if (agregar) {
                perfilesNoSonDelProyecto.add(listaPerfil.get(i));
            }
        }
        model.addAttribute("perfilesProyectoEx", perfilesNoSonDelProyecto);
        return "/Organizaciones/editarProyecto";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modificarProyecto.do")
    public String modificarProyecto(@Valid Proyectos proyecto, BindingResult result, Model model, String selectfrom, String nActividades, String cadenaActividades, String codigo_postal, HttpSession session, HttpServletRequest request) {
        proyecto.setFechaAlta(new Date());
        //Validaciones
        System.out.println("Validarr");
        new ValidarProyectos().valAltaAdminProy(proyecto, result, model, codigo_postal);

        //Desglose de Actividades
        ActividadesModel actividadesModel = new ActividadesModel(cadenaActividades);

        //Valida Actividades
        if (!actividadesModel.validarInsercionActividades().isSuccess()) {
            result.addError(new ObjectError("actividades", actividadesModel.validarInsercionActividades().getMensaje()));
        }
        model.addAttribute("validacion_actividades", actividadesModel.validarInsercionActividades().getMensaje());
        //++++++++++++++++++++++++++++++++Si hubo un error+++++++++++++++++++++++++++++++++++
        if (result.hasErrors()) {
            System.out.println("Entroooooooooo aquiiiiiiiiiiiiiiiiiiiiiiiiiiii");
            //Regresar codigo postal
            model.addAttribute("cp", codigo_postal);
            try {
                model.addAttribute("idColonia", proyecto.getIdColonia().getIdColonia());
            } catch (Exception e) {
            }
            List<Instancia> listaInstancias = instanciaFacade.findBySpecificField("estatus", "1", "equal", null, null);
            ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();
            for (int i = 0; i < listaInstancias.size(); i++) {
                int validacionAmin = Integer.parseInt(listaInstancias.get(i).getValidacionAdmin().toString());
                if ((validacionAmin == 1) || (validacionAmin == 2)) {
                    filtroInstancias.add(listaInstancias.get(i));
                }
            }
            model.addAttribute("instancia", filtroInstancias);
            model.addAttribute("estados", estadosFacade.findAll());
            model.addAttribute("perfil", perfilFacade.findBySpecificField("estatus", "1", "equal", null, null));
            model.addAttribute("tipoProyecto", tipoProyectoFacade.findBySpecificField("status", "1", "equal", null, null));
            model.addAttribute("programas", programaFacade.findBySpecificField("status", "1", "equal", null, null));
            List<Perfil> perfilesNoSonDelProyecto = new ArrayList<Perfil>();
            List<Perfil> perfilesSonDelProyecto = new ArrayList<Perfil>();
            List<Perfil> listaPerfil;
            Iterator<ProyectoPerfil> iteratorProyectosPerfilCollection;
            listaPerfil = perfilFacade.findAll();
            boolean agregar;
            String nombrePerfilCollection;
            for (int i = 0; i < listaPerfil.size(); i++) {
                agregar = true;
                iteratorProyectosPerfilCollection = proyectosFacade.find(proyecto.getIdProyecto()).getProyectoPerfilCollection().iterator();
                while (iteratorProyectosPerfilCollection.hasNext()) {
                    nombrePerfilCollection = iteratorProyectosPerfilCollection.next().getIdPerfil().getNombre();
                    if (!listaPerfil.get(i).getNombre().equals(nombrePerfilCollection) && agregar) {
                        agregar = true;
                    } else {
                        agregar = false;
                    }
                }
                if (agregar) {
                    perfilesNoSonDelProyecto.add(listaPerfil.get(i));
                } else {
                    perfilesSonDelProyecto.add(listaPerfil.get(i));
                }
            }
            model.addAttribute("perfilesProyectoEx", perfilesNoSonDelProyecto);
            model.addAttribute("perfilesSonProyecto", perfilesSonDelProyecto);
            //Regresar actividades
            model.addAttribute("nActividades", nActividades.substring(0, 1));
            System.out.println("nActividades:" + nActividades.substring(0, 1));

            for (int i = 0; i < actividadesModel.actividades.size(); i++) {
                model.addAttribute("actividad" + i, actividadesModel.actividades.get(i));
                System.out.println("Regresando Actividad:" + actividadesModel.actividades.get(i));
            }
            model.addAttribute("actividadAux", actividadesModel.actividades);
            model.addAttribute("proyectoDireccion", proyectosFacade.find(proyecto.getIdProyecto()));
            model.addAttribute("proyecto", proyecto);
            return "/Organizaciones/editarProyecto";
        } else {
            //**********************Insertar los Perfiles del proyecto**********************************
            List<ProyectoPerfil> listaProyectosPerfil = proyectoPerfilFacade.findBySpecificField("idProyecto", proyecto, "equal", null, null);
            Iterator<ProyectoPerfil> recorreProyectosPerfil = listaProyectosPerfil.iterator();
            //while para borrar los perfiles que tiene el proyecto
            while (recorreProyectosPerfil.hasNext()) {
                ProyectoPerfil borrarPerfilDeProyecto;
                borrarPerfilDeProyecto = recorreProyectosPerfil.next();
                proyectoPerfilFacade.remove(borrarPerfilDeProyecto);
            }
            if (selectfrom != null) {
                List<String> listaIds = new ArrayList<String>();
                StringTokenizer palabra = new StringTokenizer(selectfrom, ",");
                while (palabra.hasMoreTokens()) {
                    listaIds.add(palabra.nextToken());
                }
                Iterator inserta = listaIds.iterator();
                //while que inserta la lista de los perfiles para el proyecto
                while (inserta.hasNext()) {
                    ProyectoPerfil proyectoPerfil = new ProyectoPerfil();
                    proyectoPerfil.setIdPerfil(perfilFacade.find(BigDecimal.valueOf(Integer.parseInt(inserta.next().toString())))); //Perfil
                    proyectoPerfil.setIdProyecto(proyecto); //Proyecto
                    proyectoPerfilFacade.create(proyectoPerfil);
                }
            }
            //****************************Insertar las Actividades**************************
            if (Integer.parseInt(nActividades) > 2 || nActividades != null) {
                List<Actividades> listaActividadesProyecto = actividadesFacade.findBySpecificField("idProyecto", proyecto, "equal", null, null);
                Iterator<Actividades> recorreActividades = listaActividadesProyecto.iterator();
                //while para borrar las actividades del proyecto
                while (recorreActividades.hasNext()) {
                    Actividades borrarActividadesProyecto;
                    borrarActividadesProyecto = recorreActividades.next();
                    actividadesFacade.remove(borrarActividadesProyecto);
                }
                List<String> listaActividades = new ArrayList<String>();
                StringTokenizer actividades = new StringTokenizer(cadenaActividades, ";");
                while (actividades.hasMoreTokens()) {
                    listaActividades.add(actividades.nextToken());
                }
                Iterator insertaActividades = listaActividades.iterator();
                //while que inserta la lista de actividades para el proyecto
                while (insertaActividades.hasNext()) {
                    Actividades actividadesObj = new Actividades();
                    actividadesObj.setDetalle(insertaActividades.next().toString());//String
                    actividadesObj.setEstatus(BigInteger.ONE);//BigInteger
                    actividadesObj.setIdProyecto(proyecto);//Proyectos
                    actividadesFacade.create(actividadesObj);
                }
            }
            //Pasar todo a mayusculas
            proyecto.setNombre(proyecto.getNombre().toUpperCase());
            proyecto.setDomicilio(proyecto.getDomicilio().toUpperCase());
            proyecto.setModalidad(proyecto.getModalidad().toUpperCase());
            proyecto.setNombreResponsable(proyecto.getNombreResponsable().toUpperCase());
            proyecto.setResponsablePuesto(proyecto.getResponsablePuesto().toUpperCase());
            //******************************try-catch para editar un proyecto**************************
            try {
                proyectosFacade.edit(proyecto);
            } catch (Exception e) {
                result.addError(new ObjectError("error_sql", "Error de llave unica"));
                model.addAttribute("error_sql", "<div class='alert alert-danger'>Error de llave unica</div>");

                return "/Organizaciones/editarProyecto";
            }

            System.out.println("Sin errores");
            List<Proyectos> listaProyectos = proyectosFacade.findBySpecificField("estatus", "1", "equal", null, null);
            ArrayList<Proyectos> filtroDeProyectos = new ArrayList<Proyectos>();
            for (int i = 0; i < listaProyectos.size(); i++) {
                int validacionAdmin = Integer.parseInt(listaProyectos.get(i).getValidacionAdmin().toString());
                if (validacionAdmin == 1) {
                    filtroDeProyectos.add(listaProyectos.get(i));
                }
            }
            model.addAttribute("proyectos", filtroDeProyectos);
            model.addAttribute("retroalimentacionProyecto", new BorrarProyecto());
            return "/Organizaciones/administrarProyectos";
        }
    }

    //Borrar Organizacion & Proyecto
    @RequestMapping(method = RequestMethod.POST, value = "/borrarInstancia.do")
    public @ResponseBody
    String borrarInstancia(BorrarInstancia retroalimentacionInstancia, BindingResult resultado, HttpSession session, HttpServletRequest request) {
        if (resultado.hasErrors()) {
            for (ObjectError error : resultado.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "<script>alert('¡Error al intentar enviar!, verifica los datos')</script>";
        } else {
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
                //Prepara retroalimentacion
                EnviarCorreo correo = new EnviarCorreo("Retroalimentacion de Instancia Rechazada", retroalimentacionInstancia.getDescripcion(), instancia.getCorreo());
                RetroalimentacionInstancia2 retro = new RetroalimentacionInstancia2();
                retro.setEstatus(BigInteger.ONE);
                retro.setFecha(new Date());
                retro.setDetalle(retroalimentacionInstancia.getDescripcion());
                retro.setIdInstancia(instancia);
                retroalimentacionInstanciaFacade.create(retro);

                instanciaFacade.edit(instancia);
                correo.enviaCorreo();
                return "<script>"
                        + "alert('¡Correo enviado exitosamente a: " + retroalimentacionInstancia.getCorreo() + "!');"
                        + "location.href='validarOrganizaciones.do';"
                        + "</script>";
            }




        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/borrarProyecto.do")
    public @ResponseBody
    String borrarProyecto(BorrarProyecto retroalimentacionProyecto, BindingResult resultado, HttpSession session, HttpServletRequest request) {
        if (resultado.hasErrors()) {
            for (ObjectError error : resultado.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "<script>alert('¡Error al intentar enviar!, verifica los datos')</script>";
        } else {

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

                //Prepara retroalimentacion
                EnviarCorreo correo = new EnviarCorreo("Retroalimentacion de Proyecto Rechazado", proyecto.getIdInstancia().getCorreo(), retroalimentacionProyecto.getDescripcion());
                RetroalimentacionProyecto2 retro = new RetroalimentacionProyecto2();
                retro.setDetalle(retroalimentacionProyecto.getDescripcion());
                retro.setEstatus(BigInteger.ONE);
                retro.setFecha(new Date());
                retro.setIdProyecto(proyecto);
                retroalimentacionProyectoFacade.create(retro);

                proyectosFacade.edit(proyecto);
                correo.enviaCorreo();

                return "<script>alert('¡Correo enviado exitosamente a: " + retroalimentacionProyecto.getEmail() + "!');"
                        + "location.href='validarProyectos.do';"
                        + "</script>";
            }

        }
    }

    //Eliminar instancia y proyecto (solo cambia el estatus a 0)
    @RequestMapping(method = RequestMethod.POST, value = "/cambiaStatusInstancia.do")
    public @ResponseBody
    String cambiaStatusInstancia(int id, Model model, HttpSession session, HttpServletRequest request) {
        Instancia instancia;
        instancia = instanciaFacade.find(BigDecimal.valueOf(id));
        Iterator<Proyectos> proyectos = instancia.getProyectosCollection().iterator();
        while (proyectos.hasNext()) {
            Proyectos proyectoEdit = proyectos.next();
            proyectoEdit.setEstatus(BigInteger.ZERO);
            proyectosFacade.edit(proyectoEdit);
        }
        instancia.setEstatus(BigInteger.ZERO);
        instanciaFacade.edit(instancia);
        System.out.println("Ya actualizo");
        return "ok";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cambiaStatusProyecto.do")
    public @ResponseBody
    String cambiaStatusProyecto(int id, Model model, HttpSession session, HttpServletRequest request) {
        Proyectos proyecto;
        proyecto = proyectosFacade.find(BigDecimal.valueOf(id));
        proyecto.setEstatus(BigInteger.ZERO);
        proyectosFacade.edit(proyecto);
        System.out.println("Ya actualizo");
        return "ok";
    }

    //Alta Organizaicon visitante
    @RequestMapping(method = RequestMethod.POST, value = "/gdaAltaOrganizacionVisitante.do")
    public String gdaOrganizacionVisitante(Model a) {

        return "/Organizaciones/editarOrganizacion";
    }
}
