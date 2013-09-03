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
import edu.servicio.toluca.entidades.CatalogoDocumento;
import edu.servicio.toluca.entidades.CatalogoPlan;
import edu.servicio.toluca.entidades.Colonia;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.Documentos;
import edu.servicio.toluca.entidades.FoliosPlatica;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.HorariosAlumno;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.ProyectoPerfil;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.entidades.Va;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.model.ValidaSesion;
import edu.servicio.toluca.sesion.CatalogoDocumentoFacade;
import edu.servicio.toluca.sesion.CatalogoPlanFacade;
import edu.servicio.toluca.sesion.ColoniaFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.DocumentosFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.FoliosPlaticaFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
//import edu.servicio.toluca.sesion.HorarioFacade;
import edu.servicio.toluca.sesion.HorariosAlumnoFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.ProyectosFacade;
import edu.servicio.toluca.sesion.VaFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
    @EJB(mappedName = "java:global/ServicioSocial/DocumentosFacade")
    private DocumentosFacade documentoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CatalogoDocumentoFacade")
    private CatalogoDocumentoFacade catalogoDocumentoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CatalogoPlanFacade")
    private CatalogoPlanFacade catalogoPlanFacade;
    @EJB(mappedName = "java:global/ServicioSocial/FoliosPlaticaFacade")
    private FoliosPlaticaFacade foliosPlaticaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/VaFacade")
    private VaFacade vaFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/showpdf.do")
    public String showpdf(Model modelo, String alumno_id) {
        return "/FormatoUnico/showpdf";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoUsuario.do")
    public String formatoUnico(Model modelo, String alumno_id, HttpSession session, HttpServletRequest request) throws ParseException {
        if(new ValidaSesion().validaAlumno(session, request)){
            //return "/PanelUsuario/panelUsuario";
        }else{
            modelo.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        System.out.println("***Eyy N control ="+session.getAttribute("NCONTROL").toString());
        alumno_id = session.getAttribute("NCONTROL").toString();
        modelo.addAttribute("formatoUnicoDatosPersonales", new FormatoUnicoDatosPersonalesBean());
        FormatoUnicoDatosPersonalesBean formatoUnicoDatosPersonalesbean = new FormatoUnicoDatosPersonalesBean();
        FormatoUnicoDatosContactoBean formatoUnicoDatosContacoBean = new FormatoUnicoDatosContactoBean();
        //id de alumno provisional en lo que nos dan lo de sesión
        //String alumno_id = "09280531";
        //select * from ...where
        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", alumno_id, "equal", null, null);
        //***List<Va> listaAlumnos = vaFacade.findBySpecificField("id", alumno_id, "equal", null, null);
        //---List<Va> listaAlumnos = vaFacade.findAll();
        
        //objeto que voy a insertar
        if(listaAlumnos.isEmpty())
        {
            System.out.println("La lista de alumnos está vacía");
            return "PanelUsuario/panelUsuario";
        }
        VistaAlumno alumno = listaAlumnos.get(0);
        System.out.println("Que traigo? Nombre:"+alumno.getNombre()+" id:"+alumno.getId());
        //---Va alumno = listaAlumnos.get(0);
        
        
        
        
        if (Float.parseFloat(alumno.getPorcentaje()) < 70) {
            System.out.println("El alumno no tiene los créditos necesarios");
            return "PanelUsuario/panelUsuario";
        }
        //Creación de los objetos necesarios para inserción y lectura
        DatosPersonales datosPersonales = new DatosPersonales();
        datosPersonales.setAlumnoId(alumno);
        //---datosPersonales.setNumeroControl(alumno.getId());
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

//            List<Colonia> listaCo = coloniaFacade.findAll();
//            Colonia co = listaCo.get(0);
            Colonia co = coloniaFacade.find(BigDecimal.ONE);
            datosPersonales.setIdColonia(co);
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
            formatoUnico.setStatusServicio(BigInteger.ONE);
            CatalogoPlan plan = catalogoPlanFacade.find(new BigDecimal(alumno.getPlanId()));
            formatoUnico.setCatalogoPlanId(plan);
            List<FoliosPlatica> listaFolios = foliosPlaticaFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
            if(listaFolios.isEmpty())
                return "PanelUsuario/panelUsuario";
            FoliosPlatica platica = listaFolios.get(0);
            formatoUnico.setPeriodoInicio(platica.getPlaticaId().getPeriodo());
            formatoUnico.setTipoServicio(BigInteger.ONE);
            formatoUnico.setStatusServicio(BigInteger.ONE);




            //seteo del proyecto al alumno a través del banco
            //**Proyectos proyecto = new Proyectos();
            List<Proyectos> listaProyectos = proyectoFacade.findAll();
            if(listaProyectos.isEmpty())
            {
                System.out.println("La lista de proyectos está vacía");
                return "PanelUsuario/panelUsuario";
            }
            Proyectos proyecto = listaProyectos.get(0);
            //**proyecto.setIdProyecto(BigDecimal.ONE);
            formatoUnico.setIdproyecto(proyecto);
            formatoUnico.setFechaInicio(new java.util.Date());

            //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
            //----Inserción de todo el bean de formato unico con el facade---
            //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
            formatoUnicoFacade.create(formatoUnico);
            //fin de inserción

            //Setear en vacío los horarios alumno 
            //Recuperar el objeto FormatoUnico que se acaba de insertar para insertarlo en los horarios_alumno
            List<FormatoUnico> listaFormatoUnico = formatoUnicoFacade.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
            if(listaFormatoUnico.isEmpty()){
                System.out.println("La lista de formatoUnico está vacía");
                return "PanelUsuario/panelUsuario";
            }
            FormatoUnico fuiAux = listaFormatoUnico.get(0);
            //fin recuperación
            //Día{1 = Lunes, 2= Martes, 3= Miercoles .......... }
            for (int i = 1; i <= 5; i++) {
                HorariosAlumno horariosAlumno2 = new HorariosAlumno();
                //horariosAlumno2 = horariosAlumno;
                horariosAlumno2.setFormatoUnicoId(fuiAux);
                horariosAlumno2.setDia(i + "");
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
////////Asunto de la foto provisional/////////////////
//////////////////////////////////////////////////////////////////////////
        if(alumno.getFoto() == null)
        {
            modelo.addAttribute("idUsuario", alumno.getId());
            return "/FormatoUnico/subirFoto";
        }
        else
            System.out.println("La foto no estaba nula");
        
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
        formatoUnicoDatosPersonalesbean.setLugar_nacimiento(datosPersonales.getLugarNacimiento());
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
        System.out.println("lo que mando al facade es: " + datosPersonales.getIdColonia().getIdColonia());
        // modelo.addAttribute("instanciaDireccion", instanciaFacade.findBySpecificField("idColonia", datosPersonales.getIdColonia(), "equal" , null, null));
        Colonia col = coloniaFacade.find(datosPersonales.getIdColonia().getIdColonia());
        System.out.println("Cp" + col.getIdCp().getCp());
        modelo.addAttribute("codigoPostal", col.getIdCp().getCp());
        modelo.addAttribute("preColonia", datosPersonales.getIdColonia().getIdColonia());

        /////Carga la información que se tiene en la bd del alumno
        FormatoUnicoProyectosJSON formatoUnicoProyectosJON = new FormatoUnicoProyectosJSON();
        formatoUnicoProyectosJON.setId(datosPersonales.getId());
        formatoUnicoProyectosJON.setIdProyecto(formatoUnico.getIdproyecto().getIdProyecto());
        System.out.println("Id de fui" + formatoUnico.getId());
        System.out.println("id de datos perso del fui" + formatoUnico.getDatosPersonalesId().getId());
        System.out.println("El  proy asignado es " + formatoUnico.getIdproyecto().getIdProyecto());
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(formatoUnico.getFechaInicio());
        Date f = new java.sql.Date(sdf.parse(fecha).getTime());
        formatoUnicoProyectosJON.setFecha_inicio(formatoUnico.getFechaInicio());
        modelo.addAttribute("formatoUnicoDatosOrganizaciones", formatoUnicoProyectosJON);
        //modelo.addAttribute("idDeInstancia", formatoUnico.getIdproyecto().getIdInstancia().getIdInstancia());

//////////////////////////////////////////////////////////////////////////
////////Preparar información de los horarios y enviar/////////////////////
//////////////////////////////////////////////////////////////////////////
        FormatoUnicoHorariosBean formatoUnicoHorariosBean = new FormatoUnicoHorariosBean();
        formatoUnicoHorariosBean.setId(formatoUnico.getId());
        List<HorariosAlumno> listaHorariosAlumno = horarioFacade.findBySpecificField("formatoUnicoId", formatoUnico, "equal", null, null);
        for (HorariosAlumno hor : listaHorariosAlumno) {
            if (hor.getDia().equals("1")) {
                formatoUnicoHorariosBean.setLuI(hor.getHoraInicio());
                formatoUnicoHorariosBean.setLuF(hor.getHoraFin());
            }
            if (hor.getDia().equals("2")) {
                formatoUnicoHorariosBean.setMaI(hor.getHoraInicio());
                formatoUnicoHorariosBean.setMaF(hor.getHoraFin());
            }
            if (hor.getDia().equals("3")) {
                formatoUnicoHorariosBean.setMiI(hor.getHoraInicio());
                formatoUnicoHorariosBean.setMiF(hor.getHoraFin());
            }
            if (hor.getDia().equals("4")) {
                formatoUnicoHorariosBean.setJuI(hor.getHoraInicio());
                formatoUnicoHorariosBean.setJuF(hor.getHoraFin());
            }
            if (hor.getDia().equals("5")) {
                formatoUnicoHorariosBean.setViI(hor.getHoraInicio());
                formatoUnicoHorariosBean.setViF(hor.getHoraFin());
            }

        }
        modelo.addAttribute("formatoUnicoHorarios", formatoUnicoHorariosBean);
//////////////////////////////////////////////////////////////////////////
////////Para la subida de archivos/////////////////////
//////////////////////////////////////////////////////////////////////////
        modelo.addAttribute("idDatSubida", datosPersonales.getId());


        return "/FormatoUnico/formatoUnicoUsuario";
    }

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(new FormatoUnicoDatosPersoValidaciones()); // registramos el validador
//    }
    @RequestMapping(method = RequestMethod.POST, value = "/modificarDatosPersonales.do")
    public @ResponseBody
    String modificarDatosPersonalesAlumno(@Valid FormatoUnicoDatosPersonalesBean dt, BindingResult resultado) {

        String arrJSON = "[";
        dt.arregla();
        ArrayList<String> listaErrores = dt.Valida();
        if (!dt.isAcuerdoC()) {
            listaErrores.add("No has seleccionado la opción del Acuerdo de confidencialidad");
        }
        if (listaErrores.isEmpty()) {
            System.out.println("No hubo errores");
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
            datosPersonales.setLugarNacimiento(dt.getLugar_nacimiento());
            datosPersonales.setFolioDocIdentificaciin(new BigInteger(dt.getFolioDocIdentificacion()));
            datosPersonales.setClaveDocIdentificacion(dt.getClaveDocIdentificacion());
            datosPersonalesFacade.edit(datosPersonales);

        } else {
            int i = 1;
            for (String s : listaErrores) {
                arrJSON = arrJSON + "{\"observacion\":\"" + s + "\"},";
                System.out.println("Error " + i + " " + s);
                i++;
            }
        }
        if (arrJSON.equals("[")) {
            arrJSON = "noInfo";
        } else {
            arrJSON = arrJSON.substring(0, arrJSON.length() - 1) + "]";
        }


        System.out.println("Arrjson" + arrJSON);
        return arrJSON;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modificarDatosContacto.do")
    public @ResponseBody
    String modificarDatosContactoAlumno(FormatoUnicoDatosContactoBean dt, BindingResult resultado) {
        String arrJSON = "[";
        dt.arregla();

        ArrayList<String> listaErrores = dt.Valida();
        if (listaErrores.isEmpty()) {
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
        } else {
            int i = 1;
            for (String s : listaErrores) {
                arrJSON = arrJSON + "{\"observacion\":\"" + s + "\"},";
                System.out.println("Error " + i + " " + s);
                i++;
            }
        }
        if (arrJSON.equals("[")) {
            arrJSON = "noInfo";
        } else {
            arrJSON = arrJSON.substring(0, arrJSON.length() - 1) + "]";
        }


        System.out.println("Arrjson" + arrJSON);
        return arrJSON;


    }

    @RequestMapping(method = RequestMethod.POST, value = "/modificarDatosOrganizaciones.do")
    public @ResponseBody
    String modificarDatosOrganizaciones(FormatoUnicoDatosContactoBean dt, Date fecha_inicio, BigDecimal proyecto, BindingResult resultado) {
        System.out.println("recibí" + proyecto);
        DatosPersonales datosPersonales = datosPersonalesFacade.find(dt.getId());
        System.out.println("Datos per" + datosPersonales.getNombre());
        System.out.println("Rec" + dt.getId());
        List<FormatoUnico> listaFormatoUnico = formatoUnicoFacade.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
        FormatoUnico formatoUnico = listaFormatoUnico.get(0);
        // System.out.println("Recibí" + organizacion);
        Proyectos proyectoG = new Proyectos();
        proyectoG.setIdProyecto(proyecto);
        formatoUnico.setIdproyecto(proyectoG);
        formatoUnico.setFechaInicio(fecha_inicio);
        System.out.println("La fecha recibida es" + fecha_inicio);
        List<FoliosPlatica> listaF = foliosPlaticaFacade.findBySpecificField("alumnoId", datosPersonales.getAlumnoId(), "equal", null, null);
        FoliosPlatica fp = listaF.get(0);
        Date fechaMax = new java.sql.Date(fp.getPlaticaId().getFechaMxFui().getTime());
        if (fecha_inicio.after(fechaMax)) {
            return "La fecha de inicio sobrepasa la fecha maxima permitida";
        }
        // formatoUnico.setFechaInicio(fj.getFecha_inicio());
        try {
            formatoUnicoFacade.edit(formatoUnico);
            return "Informacion Almacenada correctamente";
        } catch (Exception e) {
            return "Hubo un Problema al Guardar tu informacion";
        }




        //return new FormatoUnicoErrores();

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
    public @ResponseBody
    FormatoUnicoProyectosJSON cargarProyectos(Model a, String id_instancia, String id_datos_personales) {
        Proyectos pr = null;
        BigDecimal idDP = new BigDecimal(id_datos_personales);
        //System.out.println("Traigo el id"+id_instancia);
        List<Instancia> listaInstancias = instanciaFacade.findBySpecificField("idInstancia", id_instancia, "equal", null, null);
        Instancia instancia = listaInstancias.get(0);
        ArrayList<FormatoUnicoProyectosJSON> fuiProyectos = new ArrayList<FormatoUnicoProyectosJSON>();
        FormatoUnicoProyectosJSON fuiJSON = new FormatoUnicoProyectosJSON();
        DatosPersonales dp = datosPersonalesFacade.find(idDP);
        VistaAlumno alumno = vistaAlumnoFacade.find(dp.getAlumnoId().getId());
        //System.out.println("iis" + instancia.getNombre());
        //System.out.println("tamaño" +  instancia.getProyectosCollection().size());
        for (Proyectos proy : instancia.getProyectosCollection()) {
            //System.out.println("Aquiii");
            if (proy.getVacantesDisponibles().compareTo(BigInteger.ZERO) > 0) {
                if (proy.getProyectoPerfilCollection().isEmpty()) {
                    System.out.println("oxxAgregando uno sin coleccion perfiles");
                    fuiJSON.getId_instancia().add(instancia.getIdInstancia());
                    fuiJSON.getId_proyecto().add(proy.getIdProyecto());
                    fuiJSON.getNombre().add(proy.getNombre());
                    fuiJSON.getDomicilio().add(proy.getDomicilio());
                    fuiJSON.getNombre_responsable().add(proy.getNombreResponsable());
                    fuiJSON.getTelefono_responsable().add(proy.getTelefonoResponsable());
                } else {
                    for (ProyectoPerfil per : proy.getProyectoPerfilCollection()) {
                        System.out.println("xxxCarrera id:" + alumno.getCarreraId());
                        System.out.println("xxxPerfil p/proy" + per.getIdPerfil().getIdPerfil());
                        System.out.println("xxxNombre" + per.getIdPerfil().getNombre());
                        if (per.getIdPerfil().getIdPerfil().toString().equals(new BigDecimal(alumno.getCarreraId()).toString())) {
                            System.out.println("oxxAgregando uno de perfil");
                            fuiJSON.getId_instancia().add(instancia.getIdInstancia());
                            fuiJSON.getId_proyecto().add(proy.getIdProyecto());
                            fuiJSON.getNombre().add(proy.getNombre());
                            fuiJSON.getDomicilio().add(proy.getDomicilio());
                            fuiJSON.getNombre_responsable().add(proy.getNombreResponsable());
                            fuiJSON.getTelefono_responsable().add(proy.getTelefonoResponsable());
                        }
                    }
                }
            }

        }
        return fuiJSON;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/idInstancia.do")
    public @ResponseBody
    FormatoUnicoProyectosJSON idInstancia(Model a, BigDecimal idProyecto) {

        List<Proyectos> listaProys = proyectoFacade.findBySpecificField("idProyecto", idProyecto, "equal", null, null);
        Proyectos pr = listaProys.get(0);
        FormatoUnicoProyectosJSON fuiJSON = new FormatoUnicoProyectosJSON();
        fuiJSON.setIdProyecto(pr.getIdInstancia().getIdInstancia());
        return fuiJSON;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modificarHorarios.do")
    public @ResponseBody
    String modificarHorarios(Model a, FormatoUnicoHorariosBean hb) throws ParseException {
        String arrJSON = "[";
        //hb.arregla();
        ArrayList<String> listaErrores = hb.Valida();
        if (listaErrores.isEmpty()) {
            System.out.println("No hubo errores");
            List<FormatoUnico> listaFui = formatoUnicoFacade.findBySpecificField("id", hb.getId(), "equal", null, null);
            FormatoUnico formatoUnico = listaFui.get(0);
            List<HorariosAlumno> listaHorariosAlumno = horarioFacade.findBySpecificField("formatoUnicoId", formatoUnico, "equal", null, null);
            for (HorariosAlumno hor : listaHorariosAlumno) {
                if (hor.getDia().equals("1")) {
                    hor.setHoraInicio(hb.getLuI());
                    hor.setHoraFin(hb.getLuF());
                    horarioFacade.edit(hor);
                }
                if (hor.getDia().equals("2")) {
                    hor.setHoraInicio(hb.getMaI());
                    hor.setHoraFin(hb.getMaF());
                    horarioFacade.edit(hor);
                }
                if (hor.getDia().equals("3")) {
                    hor.setHoraInicio(hb.getMiI());
                    hor.setHoraFin(hb.getMiF());
                    horarioFacade.edit(hor);
                }
                if (hor.getDia().equals("4")) {
                    hor.setHoraInicio(hb.getJuI());
                    hor.setHoraFin(hb.getJuF());
                    horarioFacade.edit(hor);
                }
                if (hor.getDia().equals("5")) {
                    hor.setHoraInicio(hb.getViI());
                    hor.setHoraFin(hb.getViF());
                    horarioFacade.edit(hor);
                }

            }
        } else {
            int i = 1;
            for (String s : listaErrores) {
                arrJSON = arrJSON + "{\"observacion\":\"" + s + "\"},";
                System.out.println("Error " + i + " " + s);
                i++;
            }
        }
        if (arrJSON.equals("[")) {
            arrJSON = "noInfo";
        } else {
            arrJSON = arrJSON.substring(0, arrJSON.length() - 1) + "]";
        }


        System.out.println("Arrjson" + arrJSON);
        return arrJSON;

    }
    ////PRUEBA DE FOTO!!!!!!!!!!!!!!!!!!!!!!!

    @RequestMapping(value = "/subirFui.do", method = RequestMethod.POST)
    public String save(
            @RequestParam("file") MultipartFile file, BigDecimal id) throws IOException {
        List<Documentos> listaDocumento = documentoFacade.findBySpecificField("datosPersonalesId", id, "equal", null, null);
        List<CatalogoDocumento> listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Formato_Unico", "equal", null, null);
        System.out.println("Inicia subida de info");
        System.out.println("Original filename: " + file.getOriginalFilename());
        System.out.println("File:" + file.getName());
        System.out.println("Size:" + file.getSize());
        System.out.println("ContentType:" + file.getContentType());
        if (listaDocumento.isEmpty()) {
            System.out.println("Subida nueva");
            Documentos doc = new Documentos();
            doc.setDatosPersonalesId(datosPersonalesFacade.find(id));
            doc.setArchivo(file.getBytes());
            doc.setCatalogoDocumentosId(listaCatalogoDocumento.get(0));
            String extension = file.getOriginalFilename();
            extension = extension.substring(extension.length()-3, extension.length());
            //**doc.setExtension("pdf");
            doc.setExtension(extension);
            doc.setFechaSubida(new java.util.Date());
            DatosPersonales dp = datosPersonalesFacade.find(id);
            List<FormatoUnico> listaFui = formatoUnicoFacade.findBySpecificField("datosPersonalesId", dp, "equal", null, null);
            FormatoUnico fui = listaFui.get(0);
            fui.setStatusFui(new BigInteger("4"));
            formatoUnicoFacade.edit(fui);
            documentoFacade.create(doc);
        } else {
            System.out.println("Ya estaba");
            Documentos doc = listaDocumento.get(0);
            doc.setDatosPersonalesId(datosPersonalesFacade.find(id));
            doc.setArchivo(file.getBytes());
            doc.setCatalogoDocumentosId(listaCatalogoDocumento.get(0));
            String extension = file.getOriginalFilename();
            extension = extension.substring(extension.length()-3, extension.length());
            //**doc.setExtension("pdf");
            doc.setExtension(extension);
            doc.setFechaSubida(new java.util.Date());
            DatosPersonales dp = datosPersonalesFacade.find(id);
            List<FormatoUnico> listaFui = formatoUnicoFacade.findBySpecificField("datosPersonalesId", dp, "equal", null, null);
            FormatoUnico fui = listaFui.get(0);
            fui.setStatusFui(new BigInteger("4"));
            formatoUnicoFacade.edit(fui);
            documentoFacade.edit(doc);

        }
//        System.out.println("id:" + vistaAlumno.getId());
//        String id=vistaAlumno.getId();
//        
//        VistaAlumno vistaAlumno1;
//        vistaAlumno1 = vistaAlumnoFacade.find(id);
//        System.out.println("find:" + vistaAlumno.getApellidoPat());
//        vistaAlumno1.setFoto(file.getBytes());
//
//        vistaAlumnoFacade.edit(vistaAlumno1);

//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getSize());
//        Documentos doc = documentoFacade.find(BigDecimal.valueOf(Long.parseLong(id)));
//        System.out.println(doc);
//        doc.setArchivo(file.getBytes());
//        doc.setExtension("pdf");
//        documentoFacade.edit(doc);


        return "redirect:panelUsuario.do";
    }


    @RequestMapping(value = "/guardarImagenFui.do", method = RequestMethod.POST)
    public String guardarImagenFui(
            @RequestParam("file") MultipartFile file, String id) throws IOException {
        System.out.println("Buscare pa subir foto el id"+id);
        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", id, "equal", null, null);
        if(listaAlumnos.isEmpty())
            return "redirect:panelUsuario.do";
        VistaAlumno alumno = listaAlumnos.get(0);
        System.out.println("Inicia subida de info");
        System.out.println("Original filename: " + file.getOriginalFilename());
        System.out.println("File:" + file.getName());
        System.out.println("Size:" + file.getSize());
        System.out.println("ContentType:" + file.getContentType());
        if(alumno.getFoto() == null)
        {
            System.out.println("ya tenía foto");
            alumno.setFoto(file.getBytes());
            vistaAlumnoFacade.edit(alumno);
        }
        else
        {
            System.out.println("No tenía foto");
            alumno.setFoto(file.getBytes());
            vistaAlumnoFacade.create(alumno);
        }
       
        return "redirect:formatoUnicoUsuario.do";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/bajaImagenes.do")
    public @ResponseBody
    String bajaImagenes(Model a, String id) throws ParseException {
        
        return "";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/muestraReporteFUI.do")
    String muestraReporteFUI(Model a, String nControl, String idProyecto, HttpSession session, HttpServletRequest request) throws ParseException {
        String noControl = session.getAttribute("NCONTROL").toString();
        a.addAttribute("noControl", noControl);
        System.out.println("En el muestra :D" + noControl);
        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", noControl, "equal", null, null);
        VistaAlumno alumno = listaAlumnos.get(0);
        
        List<DatosPersonales> listaDatosPersonales = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
        DatosPersonales dp = listaDatosPersonales.get(0);
        List<FormatoUnico> listaFormatoUnico = formatoUnicoFacade.findBySpecificField("datosPersonalesId", dp, "equal", null, null);
        if(listaFormatoUnico.isEmpty()){
            System.out.println("La lista de formatoUnico está vacía");
            return "PanelUsuario/panelUsuario";
        }
        System.out.println("Ahh y su fui es"+listaFormatoUnico.get(0).getId());
        a.addAttribute("idProyecto", listaFormatoUnico.get(0).getId());
        session.setAttribute("idProyecto", listaFormatoUnico.get(0).getId());
        return "/FormatoUnico/reporteFUI";
    }
    

}
