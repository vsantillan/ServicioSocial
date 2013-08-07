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
import edu.servicio.toluca.beans.formatoUnico.FormatoUnicoHorariosBean;
import edu.servicio.toluca.beans.formatoUnico.FormatoUnicoProyectosJSON;
import edu.servicio.toluca.entidades.Colonia;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.HorariosAlumno;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.ColoniaFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.HorarioFacade;
import edu.servicio.toluca.sesion.HorariosAlumnoFacade;
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
    @EJB(mappedName = "java:global/ServicioSocial/HorariosAlumnoFacade")
    private HorariosAlumnoFacade horarioFacade;
    @EJB(mappedName = "java:global/ServicioSocial/ColoniaFacade")
    private ColoniaFacade coloniaFacade;


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
        //Creación de los objetos necesarios para inserción y lectura
        DatosPersonales datosPersonales = new DatosPersonales();
        datosPersonales.setAlumnoId(alumno);
        FormatoUnico formatoUnico = new FormatoUnico();
        HorariosAlumno horariosAlumno = new HorariosAlumno();
        // fin de creación de objetos
        
        //verificar si ya está en datos personales
        List<DatosPersonales> listaDatosPersonales = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
        BigDecimal idDatosPersonales;
        
        if (listaDatosPersonales.isEmpty()) { //Si No fue dado de alta el alumno
            //Setea en vacío y default datos personales
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
            
            //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
            //----Inserción de todo el bean de datos personales con el facade---
            //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
            datosPersonalesFacade.create(datosPersonales);
            //Fin de inserción en el facade
            
            //recuperación del id insertado
            idDatosPersonales = datosPersonalesFacade.find(datosPersonales.getId()).getId();
            System.out.println("No estuvo");
            
            //Seteo de datos académicos de acuerdo a lo que hay en la vista_alumno
            formatoUnico.setDatosPersonalesId(datosPersonales);
            formatoUnico.setNumeroCreditos(alumno.getCreditosAcumulados());
            formatoUnico.setPorcentajeCreditos(Double.valueOf(alumno.getPorcentaje()));
            
            //seteo del proyecto al alumno a través del banco
            Proyectos proyecto = new Proyectos();
            proyecto.setIdProyecto(BigDecimal.ONE);
            formatoUnico.setIdproyecto(proyecto);
            
            //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
            //----Inserción de todo el bean de formato unico con el facade---
            //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
            formatoUnicoFacade.create(formatoUnico);
            //fin de inserción
            
            //Setear en vacío los horarios alumno 
            //Recuperar el objeto FormatoUnico que se acaba de insertar para insertarlo en los horarios_alumno
            List<FormatoUnico> listaFormatoUnico = formatoUnicoFacade.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
            FormatoUnico fuiAux = listaFormatoUnico.get(0);
            //fin recuperación
            //Día{1 = Lunes, 2= Martes, 3= Miercoles .......... }
            for(int i = 1; i <= 5; i++)
            {
                HorariosAlumno horariosAlumno2 = new HorariosAlumno();
                //horariosAlumno2 = horariosAlumno;
                horariosAlumno2.setFormatoUnicoId(fuiAux);
                horariosAlumno2.setDia(i+"");
                horariosAlumno2.setHoraInicio(" ");
                horariosAlumno2.setHoraFin(" ");
                //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
                //----Inserción de un horario alumno con el facade------------------
                //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
                horarioFacade.create(horariosAlumno2);
                
            }
            //fin de la inserción de los horarios
            
        } else //Si el alumno ya existe en la base de datos de servicio social
        {
            //Recuperación del id de datos_personales
            idDatosPersonales = listaDatosPersonales.get(0).getId();
            //Recuperación del Objeto DatosPersonales
            DatosPersonales dp2 = listaDatosPersonales.get(0);
            
            //Consultas de los objetos necesarios para el despliegue de la vista alumno
            List<FormatoUnico> listaFormatoUnico = formatoUnicoFacade.findBySpecificField("datosPersonalesId", dp2, "equal", null, null);
            System.out.println("Tu alumno ya está, su id de datos es " + listaDatosPersonales.get(0).getId());// + idDatosPersonales);
            
            
            //Asignación a objetos para posteriormente preparar
            datosPersonales = listaDatosPersonales.get(0);
            formatoUnico = listaFormatoUnico.get(0);
            //horariosAlumno = listaHorariosAlumno.get(0);

        }
//////////////////////////////////////////////////////////////////////////
////////Preparar información de datos personales y enviar/////////////////
//////////////////////////////////////////////////////////////////////////
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
        
        
//////////////////////////////////////////////////////////////////////////
////////Preparar información de datos de conteacto y enviar/////////////////
///////////////////////////////////////////////////////////////////////////
        formatoUnicoDatosContacoBean.setCalle(datosPersonales.getCalle());
        //System.out.println("Numero i " + datosPersonales.getNumeroI());
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


//////////////////////////////////////////////////////////////////////////
////////Preparar información de datos académicos y enviar/////////////////
//////////////////////////////////////////////////////////////////////////
        FormatoUnicoDatosAcademicosBean formatoUnicoDatosAcademicos = new FormatoUnicoDatosAcademicosBean();
        formatoUnicoDatosAcademicos.setNcontrol(alumno.getId());
        formatoUnicoDatosAcademicos.setCarrera(alumno.getCarrera());
        formatoUnicoDatosAcademicos.setPeriodo("Ago-Dic");
        formatoUnicoDatosAcademicos.setSemestre(alumno.getSemActual());
        formatoUnicoDatosAcademicos.setCc(alumno.getCreditosAcumulados());
        formatoUnicoDatosAcademicos.setPcc(alumno.getPorcentaje());
        modelo.addAttribute("academicos", formatoUnicoDatosAcademicos);


        
        
//////////////////////////////////////////////////////////////////////////
////////Preparar información de estados y enviar//////////////////////////
//////////////////////////////////////////////////////////////////////////
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("nombre", "asc");
        modelo.addAttribute("estados", estadosFacade.findAll(ordenamiento));
        
        
//////////////////////////////////////////////////////////////////////////
////////Preparar información de las organizaciones y enviar/////////////////
//////////////////////////////////////////////////////////////////////////
        //toma toda la info que se tiene en la bd de las organizaciones
        List<Instancia> listaInstancias = instanciaFacade.findBySpecificField("estatus", "1", "equal", null, null);
        ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();
        for (int i = 0; i < listaInstancias.size(); i++) {
            if (listaInstancias.get(i).getValidacionAdmin() == BigInteger.ONE) {
                filtroInstancias.add(listaInstancias.get(i));
            }
        }
        modelo.addAttribute("instancias", filtroInstancias);
        System.out.println("lo que mando al facade es: "+ datosPersonales.getIdColonia().getIdColonia() );
       // modelo.addAttribute("instanciaDireccion", instanciaFacade.findBySpecificField("idColonia", datosPersonales.getIdColonia(), "equal" , null, null));
        Colonia col = coloniaFacade.find(datosPersonales.getIdColonia().getIdColonia());
        System.out.println("Cp" + col.getIdCp().getCp());
        modelo.addAttribute("codigoPostal" , col.getIdCp().getCp());
        modelo.addAttribute("preColonia" , datosPersonales.getIdColonia().getIdColonia());

        /////Carga la información que se tiene en la bd del alumno
        FormatoUnicoProyectosJSON formatoUnicoProyectosJON = new FormatoUnicoProyectosJSON();
        formatoUnicoProyectosJON.setId(datosPersonales.getId());
        formatoUnicoProyectosJON.setIdProyecto(formatoUnico.getIdproyecto().getIdProyecto());
        modelo.addAttribute("formatoUnicoDatosOrganizaciones", formatoUnicoProyectosJON);
        

//////////////////////////////////////////////////////////////////////////
////////Preparar información de los horarios y enviar/////////////////////
//////////////////////////////////////////////////////////////////////////
        FormatoUnicoHorariosBean formatoUnicoHorariosBean = new FormatoUnicoHorariosBean();
        formatoUnicoHorariosBean.setId(formatoUnico.getId());
        List<HorariosAlumno> listaHorariosAlumno = horarioFacade.findBySpecificField("formatoUnicoId", formatoUnico, "equal", null, null);
        for(HorariosAlumno hor: listaHorariosAlumno)
        {
            if(hor.getDia().equals("1"))
            {
                formatoUnicoHorariosBean.setLuI(hor.getHoraInicio());
                formatoUnicoHorariosBean.setLuF(hor.getHoraFin());
            }
            if(hor.getDia().equals("2"))
            {
                formatoUnicoHorariosBean.setMaI(hor.getHoraInicio());
                formatoUnicoHorariosBean.setMaF(hor.getHoraFin());
            }
            if(hor.getDia().equals("3"))
            {
                formatoUnicoHorariosBean.setMiI(hor.getHoraInicio());
                formatoUnicoHorariosBean.setMiF(hor.getHoraFin());
            }
            if(hor.getDia().equals("4"))
            {
                formatoUnicoHorariosBean.setJuI(hor.getHoraInicio());
                formatoUnicoHorariosBean.setJuF(hor.getHoraFin());
            }
            if(hor.getDia().equals("5"))
            {
                formatoUnicoHorariosBean.setViI(hor.getHoraInicio());
                formatoUnicoHorariosBean.setViF(hor.getHoraFin());
            }
            
        }
        modelo.addAttribute("formatoUnicoHorarios", formatoUnicoHorariosBean);
        
        
        
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
        System.out.println("coloonia" + dt.getIdColonia() + "  " + dt.getIdColonia().getNombre());
        datosPersonales.setIdColonia(dt.getIdColonia());
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
        //System.out.println("Traigo el id"+id_instancia);
        List<Instancia> listaInstancias = instanciaFacade.findBySpecificField("idInstancia", id_instancia, "equal", null, null);
        Instancia instancia = listaInstancias.get(0);
        ArrayList<FormatoUnicoProyectosJSON> fuiProyectos = new ArrayList<FormatoUnicoProyectosJSON>();
        FormatoUnicoProyectosJSON fuiJSON = new FormatoUnicoProyectosJSON();
        //System.out.println("iis" + instancia.getNombre());
        //System.out.println("tamaño" +  instancia.getProyectosCollection().size());
        for(Proyectos proy: instancia.getProyectosCollection() )
        {
            //System.out.println("Aquiii");
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
        FormatoUnicoProyectosJSON fuiJSON = new FormatoUnicoProyectosJSON();
        fuiJSON.setIdProyecto(pr.getIdInstancia().getIdInstancia());
        return fuiJSON;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/modificarHorarios.do")
    public @ResponseBody  FormatoUnicoErrores  modificarHorarios(Model a, FormatoUnicoHorariosBean hb) {
        List<FormatoUnico> listaFui = formatoUnicoFacade.findBySpecificField("id", hb.getId(), "equal", null, null);
        FormatoUnico formatoUnico = listaFui.get(0);
        List<HorariosAlumno> listaHorariosAlumno = horarioFacade.findBySpecificField("formatoUnicoId", formatoUnico, "equal", null, null);
        for(HorariosAlumno hor: listaHorariosAlumno)
        {
            if(hor.getDia().equals("1"))
            {
                hor.setHoraInicio(hb.getLuI());
                hor.setHoraFin(hb.getLuF());
                horarioFacade.edit(hor);
            }
            if(hor.getDia().equals("2"))
            {
                hor.setHoraInicio(hb.getMaI());
                hor.setHoraFin(hb.getMaF());
                horarioFacade.edit(hor);
            }
            if(hor.getDia().equals("3"))
            {
                hor.setHoraInicio(hb.getMiI());
                hor.setHoraFin(hb.getMiF());
                horarioFacade.edit(hor);
            }
            if(hor.getDia().equals("4"))
            {
                hor.setHoraInicio(hb.getJuI());
                hor.setHoraFin(hb.getJuF());
                horarioFacade.edit(hor);
            }
            if(hor.getDia().equals("5"))
            {
                hor.setHoraInicio(hb.getViI());
                hor.setHoraFin(hb.getViF());
                horarioFacade.edit(hor);
            }
            
        }
        return new FormatoUnicoErrores();
    }
    
    
}
