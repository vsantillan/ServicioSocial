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
import edu.servicio.toluca.beans.MetodosValidacion;
import edu.servicio.toluca.beans.formatoUnico.FormatoUnicoHorariosBean;
import edu.servicio.toluca.beans.formatoUnico.FormatoUnicoProyectosJSON;
import edu.servicio.toluca.entidades.CatalogoDocumento;
import edu.servicio.toluca.entidades.CatalogoPlan;
import edu.servicio.toluca.entidades.CatalogoSanciones;
import edu.servicio.toluca.entidades.Ciudades;
import edu.servicio.toluca.entidades.CodigosPostales;
import edu.servicio.toluca.entidades.Colonia;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.Documentos;
import edu.servicio.toluca.entidades.EstadosSia;
import edu.servicio.toluca.entidades.FoliosPlatica;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.HorariosAlumno;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.MunicipiosSia;
import edu.servicio.toluca.entidades.Platica;
import edu.servicio.toluca.entidades.ProyectoPerfil;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.entidades.Sanciones;
import edu.servicio.toluca.entidades.TipoLocalidad;
import edu.servicio.toluca.entidades.Va;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.model.SancionesModelo;
import edu.servicio.toluca.sesion.CatalogoDocumentoFacade;
import edu.servicio.toluca.sesion.CatalogoPlanFacade;
import edu.servicio.toluca.sesion.CatalogoSancionesFacade;
import edu.servicio.toluca.sesion.CiudadesFacade;
import edu.servicio.toluca.sesion.CodigosPostalesFacade;
import edu.servicio.toluca.sesion.ColoniaFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.DocumentosFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.FoliosPlaticaFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
//import edu.servicio.toluca.sesion.HorarioFacade;
import edu.servicio.toluca.sesion.HorariosAlumnoFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.MunicipiosSiaFacade;
import edu.servicio.toluca.sesion.ProyectosFacade;
import edu.servicio.toluca.sesion.SancionesFacade;
import edu.servicio.toluca.sesion.TipoLocalidadFacade;
import edu.servicio.toluca.sesion.VaFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
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
public class EgresadoController {

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
    @EJB(mappedName = "java:global/ServicioSocial/CodigosPostalesFacade")
    private CodigosPostalesFacade codigosPostalesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CiudadesFacade")
    private CiudadesFacade ciudadesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/MunicipiosSiaFacade")
    private MunicipiosSiaFacade municipiosFacade;
    @EJB(mappedName = "java:global/ServicioSocial/TipoLocalidadFacade")
    private TipoLocalidadFacade tipoLocalidadFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CatalogoSancionesFacade")
    private CatalogoSancionesFacade catalogoSancionesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/SancionesFacade")
    private SancionesFacade sancionesFacade;



    @RequestMapping(method = RequestMethod.GET, value = "/cartaMotivos.do")
    public String formatoUnico(Model modelo, String alumno_id, HttpSession session, HttpServletRequest request) throws ParseException {
       
//        if (new ValidaSesion().validaAlumno(session, request)) {
//            //return "/PanelUsuario/panelUsuario";
//        } else {
//            modelo.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
//            return "redirect:login.do";
//        }
        System.out.println("***Eyy N control =" + session.getAttribute("NCONTROL").toString());
        alumno_id = session.getAttribute("NCONTROL").toString();
        modelo.addAttribute("formatoUnicoDatosPersonales", new FormatoUnicoDatosPersonalesBean());
        FormatoUnicoDatosPersonalesBean formatoUnicoDatosPersonalesbean = new FormatoUnicoDatosPersonalesBean();
        FormatoUnicoDatosContactoBean formatoUnicoDatosContacoBean = new FormatoUnicoDatosContactoBean();

        //select * from ...where
        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", alumno_id, "equal", null, null);
        //***List<Va> listaAlumnos = vaFacade.findBySpecificField("id", alumno_id, "equal", null, null);
        //---List<Va> listaAlumnos = vaFacade.findAll();

        //objeto que voy a insertar
        if (listaAlumnos.isEmpty()) {
            System.out.println("La lista de alumnos está vacía");
            return "PanelUsuario/panelUsuario";
        }
        VistaAlumno alumno = listaAlumnos.get(0);
        System.out.println("Que traigo? Nombre:" + alumno.getNombre() + " id:" + alumno.getId() + "Tipo:" + alumno.getStaActual());
        //---Va alumno = listaAlumnos.get(0);




        if (Float.parseFloat(alumno.getPorcentaje()) < 70) {
            System.out.println("El alumno no tiene los créditos necesarios");
            return "PanelUsuario/panelUsuario";
        }
        if(!alumno.getStaActual().equals("EG"))
        {
            System.out.println("El Alumno no es algún egresado");
            return "redirect:login.do";
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
            if (listaFolios.isEmpty()) {
                return "PanelUsuario/panelUsuario";
            }
            FoliosPlatica platica = listaFolios.get(0);
            formatoUnico.setPeriodoInicio(platica.getPlaticaId().getPeriodo());
            formatoUnico.setTipoServicio(BigInteger.ONE);
            formatoUnico.setStatusServicio(BigInteger.ONE);




            //seteo del proyecto al alumno a través del banco
            //**Proyectos proyecto = new Proyectos();
            List<Proyectos> listaProyectos = proyectoFacade.findAll();
            if (listaProyectos.isEmpty()) {
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
            if (listaFormatoUnico.isEmpty()) {
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

            //Validar que el alumno esté rechazado o en correción
            if (formatoUnico.getStatusFui() != null) {
                System.out.println("El status del fui es" + formatoUnico.getStatusFui().toString());
                if (formatoUnico.getStatusFui().toString().equals("5") || formatoUnico.getStatusFui().toString().equals("2") || formatoUnico.getStatusFui().toString().equals("3") ||  formatoUnico.getStatusFui() == null) {
                    System.out.println("Su formato único está en correción o fue rechazado, puede entrar");
                } else {
                    System.out.println("El formato único no puede entrar, anda en validaciones o ya fue aceptado");
                    return "PanelUsuario/panelUsuario";
                }
            }
            //horariosAlumno = listaHorariosAlumno.get(0);

        }
//////////////////////////////////////////////////////////////////////////
////////Asunto de la foto provisional/////////////////
//////////////////////////////////////////////////////////////////////////
//        if (alumno.getFoto() == null) {
//            modelo.addAttribute("idUsuario", alumno.getId());
//            return "/FormatoUnico/subirFoto";
//        } else {
//            System.out.println("La foto no estaba nula");
//        }

//////////////////////////////////////////////////////////////////////////
////////Preparar información de datos personales y enviar/////////////////
//////////////////////////////////////////////////////////////////////////
        modelo.addAttribute("nombre", datosPersonales.getNombre());
        modelo.addAttribute("email", datosPersonales.getCorreoElectronico());
        modelo.addAttribute("idAlumno", datosPersonales.getAlumnoId().getId());
        modelo.addAttribute("idDatosPersonales", datosPersonales.getId());
        
        
        return "/Egresados/cartaMotivos";
    }


}
