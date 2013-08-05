/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.FormatoUnicoDatosAcademicosBean;
import edu.servicio.toluca.beans.FormatoUnicoDatosContactoBean;
import edu.servicio.toluca.beans.FormatoUnicoDatosPersoValidaciones;
import edu.servicio.toluca.beans.FormatoUnicoDatosPersonalesBean;
import edu.servicio.toluca.beans.FormatoUnicoErrores;
import edu.servicio.toluca.beans.formatoUnico.FormatoUnicoProyectosJSON;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.ProyectosFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author WindSaber
 */
@Controller
public class FormatoUnicoController {

    @EJB(mappedName = "java:global/ServicioSocial/DatosPersonalesFacade")
    private DatosPersonalesFacade datosPersonalesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    private VistaAlumnoFacade vistaAlumnoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
    private FormatoUnicoFacade formatoUnicoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/EstadosSiaFacade")
    private EstadosSiaFacade estadosFacade;
    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
    private InstanciaFacade instanciaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/ProyectosFacade")
    private ProyectosFacade proyectoFacade;


    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoUsuario.do")
    public String formatoUnico(Model modelo, String alumno_id) {
        modelo.addAttribute("formatoUnicoDatosPersonales", new FormatoUnicoDatosPersonalesBean());
        FormatoUnicoDatosPersonalesBean formatoUnicoDatosPersonalesbean = new FormatoUnicoDatosPersonalesBean();
        FormatoUnicoDatosContactoBean formatoUnicoDatosContacoBean = new FormatoUnicoDatosContactoBean();
        //id de alumno provisional en lo que nos dan lo de sesión
        //String alumno_id = "09280531";
        //select * from ...where
        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", alumno_id, "equal", null, null);
        //objeto que voy a insertar
        VistaAlumno alumno = listaAlumnos.get(0);
        if (Float.parseFloat(alumno.getPorcentaje()) < 70) {
            return "PanelUsuario/panelUsuario";
        }
        DatosPersonales datosPersonales = new DatosPersonales();
        datosPersonales.setAlumnoId(alumno);
        FormatoUnico formatoUnico = new FormatoUnico();
        //verificar si ya está en datos personales
        List<DatosPersonales> listaDatosPersonales = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
        BigDecimal idDatosPersonales;
        if (listaDatosPersonales.isEmpty()) {
            datosPersonales.setNombre(alumno.getNombre());
            datosPersonales.setApellidoP(alumno.getApellidoPat());
            datosPersonales.setApellidoM(alumno.getApellidoMat());
            datosPersonales.setCurp(alumno.getCurp());
            datosPersonales.setSexo(alumno.getSexo());
            datosPersonales.setTelefonoCasa(alumno.getTelefono());
            datosPersonales.setCorreoElectronico(alumno.getEMail());
            datosPersonales.setEstadoCivil("SOLTERO");
            datosPersonales.setOcupacion("");
            datosPersonales.setClaveDocIdentificacion("");
            datosPersonales.setFolioDocIdentificaciin(BigInteger.ZERO);
            ///Setea en vacío datos contactos
            datosPersonales.setCalle("");
            datosPersonales.setNumeroI("");
            datosPersonales.setNumeroE("");
            //datosPersonales.setIdColonia(null);
            datosPersonales.setEntreCalles("");
            datosPersonales.setReferencia("");
            datosPersonales.setTelefonoCasa("");
            datosPersonales.setTelefonoCel("");
            datosPersonales.setTelefonoOficina("");
            datosPersonales.setTwitter("");
            datosPersonales.setFacebook("");
            
            //inserción del objeto en el facade

            datosPersonalesFacade.create(datosPersonales);
            idDatosPersonales = datosPersonalesFacade.find(datosPersonales.getId()).getId();
            System.out.println("No estuvo");


            formatoUnico.setDatosPersonalesId(datosPersonales);
            formatoUnico.setNumeroCreditos(alumno.getCreditosAcumulados());
            formatoUnico.setPorcentajeCreditos(Double.valueOf(alumno.getPorcentaje()));
            //Setea en vació el dato personal
            Proyectos proyecto = new Proyectos();
            proyecto.setIdProyecto(BigDecimal.ONE);
            formatoUnico.setIdproyecto(proyecto);
            formatoUnicoFacade.create(formatoUnico);


        } else {
            idDatosPersonales = listaDatosPersonales.get(0).getId();
            DatosPersonales dp2 = listaDatosPersonales.get(0);
            List<FormatoUnico> listaFormatoUnico = formatoUnicoFacade.findBySpecificField("datosPersonalesId", dp2, "equal", null, null);
            System.out.println("Tu alumno ya está, su id de datos es " + listaDatosPersonales.get(0).getId());// + idDatosPersonales);
            datosPersonales = listaDatosPersonales.get(0);
            formatoUnico = listaFormatoUnico.get(0);
            


        }
        formatoUnicoDatosPersonalesbean.setId(datosPersonales.getId());
        formatoUnicoDatosPersonalesbean.setNombre(datosPersonales.getNombre());
        formatoUnicoDatosPersonalesbean.setApellidoP(datosPersonales.getApellidoP());
        formatoUnicoDatosPersonalesbean.setApellidoM(datosPersonales.getApellidoM());
        formatoUnicoDatosPersonalesbean.setSexo(datosPersonales.getSexo());
        formatoUnicoDatosPersonalesbean.setCurp(datosPersonales.getCurp());
        formatoUnicoDatosPersonalesbean.setEstado_civil(datosPersonales.getEstadoCivil());
        formatoUnicoDatosPersonalesbean.setOcupacion(datosPersonales.getOcupacion());
        formatoUnicoDatosPersonalesbean.setClaveDocIdentificacion(datosPersonales.getClaveDocIdentificacion());
        formatoUnicoDatosPersonalesbean.setFolioDocIdentificacion(datosPersonales.getFolioDocIdentificaciin().toString());

        modelo.addAttribute("formatoUnicoDatosPersonales", formatoUnicoDatosPersonalesbean);
///////////////////////
        formatoUnicoDatosContacoBean.setCalle(datosPersonales.getCalle());
        System.out.println("Numero i " + datosPersonales.getNumeroI());
        //formatoUnicoDatosContacoBean.setNumeroI(datosPersonales.getNumeroI());
        formatoUnicoDatosContacoBean.setId(datosPersonales.getId());
        formatoUnicoDatosContacoBean.setNumeroE(datosPersonales.getNumeroE());
        formatoUnicoDatosContacoBean.setNumeroI(datosPersonales.getNumeroI());
        //formatoUnicoDatosContacoBean.setColonia(datosPersonales.getIdColonia());
        formatoUnicoDatosContacoBean.setEntreCalles(datosPersonales.getEntreCalles());
        formatoUnicoDatosContacoBean.setReferencias(datosPersonales.getReferencia());
        formatoUnicoDatosContacoBean.setTelefono_casa(datosPersonales.getTelefonoCasa());
        formatoUnicoDatosContacoBean.setTelefono_cel(datosPersonales.getTelefonoCel());
        formatoUnicoDatosContacoBean.setTelefono_oficina(datosPersonales.getTelefonoOficina());
        formatoUnicoDatosContacoBean.setTwitter(datosPersonales.getTwitter());
        formatoUnicoDatosContacoBean.setFacebook(datosPersonales.getFacebook());
        modelo.addAttribute("formatoUnicoDatosContacto", formatoUnicoDatosContacoBean);


        //Llenado del bean de datos de contacto para mostrarlo con los jstl en la vista 
        FormatoUnicoDatosAcademicosBean formatoUnicoDatosAcademicos = new FormatoUnicoDatosAcademicosBean();
        formatoUnicoDatosAcademicos.setNcontrol(alumno.getId());
        formatoUnicoDatosAcademicos.setCarrera(alumno.getCarrera());
        formatoUnicoDatosAcademicos.setPeriodo("Ago-Dic");
        formatoUnicoDatosAcademicos.setSemestre(alumno.getSemActual());
        formatoUnicoDatosAcademicos.setCc(alumno.getCreditosAcumulados());
        formatoUnicoDatosAcademicos.setPcc(alumno.getPorcentaje());
        modelo.addAttribute("academicos", formatoUnicoDatosAcademicos);


        FormatoUnicoProyectosJSON formatoUnicoProyectosJON = new FormatoUnicoProyectosJSON();
        formatoUnicoProyectosJON.setId(datosPersonales.getId());
        formatoUnicoProyectosJON.setIdProyecto(formatoUnico.getIdproyecto().getIdProyecto());
        modelo.addAttribute("formatoUnicoDatosOrganizaciones", formatoUnicoProyectosJON);
        
        //Estados
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("nombre", "asc");
        modelo.addAttribute("estados", estadosFacade.findAll(ordenamiento));
        
        //Carga de datos de organizaciones
        //Organizacion
        List<Instancia> listaInstancias = instanciaFacade.findBySpecificField("estatus", "1", "equal", null, null);
        ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();

        for (int i = 0; i < listaInstancias.size(); i++) {
            if (listaInstancias.get(i).getValidacionAdmin() == BigInteger.ONE) {
                filtroInstancias.add(listaInstancias.get(i));
            }
        }
        modelo.addAttribute("instancias", filtroInstancias);

        return "/FormatoUnico/formatoUnicoUsuario";
    }

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(new FormatoUnicoDatosPersoValidaciones()); // registramos el validador
//    }
    @RequestMapping(method = RequestMethod.POST, value = "/modificarDatosPersonales.do")
    public @ResponseBody
    FormatoUnicoErrores modificarDatosPersonalesAlumno(@Valid FormatoUnicoDatosPersonalesBean dt, BindingResult resultado) {
        System.out.println(dt.getId());
        System.out.println(dt.getSexo());
        DatosPersonales datosPersonales = datosPersonalesFacade.find(dt.getId());
        datosPersonales.setNombre(dt.getNombre());
        datosPersonales.setApellidoP(dt.getApellidoP());
        datosPersonales.setApellidoM(dt.getApellidoM());
        datosPersonales.setSexo(dt.getSexo());
        datosPersonales.setEstadoCivil(dt.getEstado_civil());
        datosPersonales.setOcupacion(dt.getOcupacion());
        datosPersonales.setCurp(dt.getCurp());
        datosPersonales.setFolioDocIdentificaciin(new BigInteger(dt.getFolioDocIdentificacion()));
        datosPersonales.setClaveDocIdentificacion(dt.getClaveDocIdentificacion());
        datosPersonalesFacade.edit(datosPersonales);




        if (resultado.hasErrors()) {
            for (ObjectError error : resultado.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
        }
        return new FormatoUnicoErrores();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modificarDatosContacto.do")
    public @ResponseBody
    FormatoUnicoErrores modificarDatosContactoAlumno(FormatoUnicoDatosContactoBean dt, BindingResult resultado) {
        DatosPersonales datosPersonales = datosPersonalesFacade.find(dt.getId());
        datosPersonales.setCalle(dt.getCalle());
        datosPersonales.setNumeroI(dt.getNumeroI());
        datosPersonales.setNumeroE(dt.getNumeroE());
        datosPersonales.setEntreCalles(dt.getEntreCalles());
        datosPersonales.setReferencia(dt.getReferencias());
        datosPersonales.setTelefonoCasa(dt.getTelefono_casa());
        datosPersonales.setTelefonoCel(dt.getTelefono_cel());
        datosPersonales.setTelefonoOficina(dt.getTelefono_oficina());
        datosPersonales.setFacebook(dt.getFacebook());
        datosPersonales.setTwitter(dt.getTwitter());
        datosPersonalesFacade.edit(datosPersonales);
        
        
        
        if (resultado.hasErrors()) {
            for (ObjectError error : resultado.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
        }
        return new FormatoUnicoErrores();

    }
    @RequestMapping(method = RequestMethod.POST, value = "/modificarDatosOrganizaciones.do")
    public @ResponseBody
    FormatoUnicoErrores modificarDatosOrganizaciones(FormatoUnicoDatosContactoBean dt, BigDecimal organizacion, BindingResult resultado) {
        
       DatosPersonales datosPersonales = datosPersonalesFacade.find(dt.getId());
       System.out.println("Datos per" + datosPersonales.getNombre());
       System.out.println("Rec" + dt.getId());
       List<FormatoUnico> listaFormatoUnico = formatoUnicoFacade.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
       FormatoUnico formatoUnico = listaFormatoUnico.get(0);
       // System.out.println("Recibí" + organizacion);
        Proyectos proyecto = new Proyectos();
        proyecto.setIdProyecto(organizacion);
        formatoUnico.setIdproyecto(proyecto);
        formatoUnicoFacade.edit(formatoUnico);
        
        
        if (resultado.hasErrors()) {
            for (ObjectError error : resultado.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
        }
        return new FormatoUnicoErrores();

    }

    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoUsuarioObservaciones.do")
    public String formatoUnicoObservaciones(Model a) {

        return "/FormatoUnico/formatoUnicoUsuarioObservaciones";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pruebaDT.do")
    public String formatoUnicoPruebaDT(Model a) {

        return "/FormatoUnico/pruebaDT";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/cargarProyectos.do")
    public @ResponseBody FormatoUnicoProyectosJSON cargarProyectos(Model a, String id_instancia) {
        Proyectos pr = null;
        System.out.println("Traigo el id"+id_instancia);
        List<Instancia> listaInstancias = instanciaFacade.findBySpecificField("idInstancia", id_instancia, "equal", null, null);
        Instancia instancia = listaInstancias.get(0);
        ArrayList<FormatoUnicoProyectosJSON> fuiProyectos = new ArrayList<FormatoUnicoProyectosJSON>();
        FormatoUnicoProyectosJSON fuiJSON = new FormatoUnicoProyectosJSON();
        System.out.println("iis" + instancia.getNombre());
        System.out.println("tamaño" +  instancia.getProyectosCollection().size());
        for(Proyectos proy: instancia.getProyectosCollection() )
        {
            System.out.println("Aquiii");
            fuiJSON.getId_instancia().add(instancia.getIdInstancia());
            fuiJSON.getId_proyecto().add(proy.getIdProyecto());
            fuiJSON.getNombre().add(proy.getNombre());
            fuiJSON.getDomicilio().add(proy.getDomicilio());
            fuiJSON.getNombre_responsable().add(proy.getNombreResponsable());
            fuiJSON.getTelefono_responsable().add(proy.getTelefonoResponsable());
        }
        return fuiJSON;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/idInstancia.do")
    public @ResponseBody FormatoUnicoProyectosJSON idInstancia(Model a, BigDecimal idProyecto) {
        
        List<Proyectos> listaProys = proyectoFacade.findBySpecificField("idProyecto", idProyecto, "equal", null, null);
        Proyectos pr = listaProys.get(0);
        
        System.out.println("..Id proyecto="+pr.getIdProyecto()+"..IdInstancia="+pr.getIdInstancia().getIdInstancia());
        
        
        
//        List<Instancia> listaInstancias = instanciaFacade.findBySpecificField("idInstancia", id_instancia, "equal", null, null);
//        Instancia instancia = listaInstancias.get(0);
//        ArrayList<FormatoUnicoProyectosJSON> fuiProyectos = new ArrayList<FormatoUnicoProyectosJSON>();
        FormatoUnicoProyectosJSON fuiJSON = new FormatoUnicoProyectosJSON();
        fuiJSON.setIdProyecto(pr.getIdInstancia().getIdInstancia());
//        System.out.println("iis" + instancia.getNombre());
//        System.out.println("tamaño" +  instancia.getProyectosCollection().size());
//        for(Proyectos proy: instancia.getProyectosCollection() )
//        {
//            System.out.println("Aquiii");
//            fuiJSON.getId_instancia().add(instancia.getIdInstancia());
//            fuiJSON.getId_proyecto().add(proy.getIdProyecto());
//            fuiJSON.getNombre().add(proy.getNombre());
//            fuiJSON.getDomicilio().add(proy.getDomicilio());
//            fuiJSON.getNombre_responsable().add(proy.getNombreResponsable());
//            fuiJSON.getTelefono_responsable().add(proy.getTelefonoResponsable());
//        }
        return fuiJSON;
    }
    
}
