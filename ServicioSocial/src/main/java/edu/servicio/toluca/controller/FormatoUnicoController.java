/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.FormatoUnicoDatosPersoValidaciones;
import edu.servicio.toluca.beans.FormatoUnicoDatosPersonalesBean;
import edu.servicio.toluca.beans.FormatoUnicoErrores;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
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

    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoUsuario.do")
    public String formatoUnico(Model modelo, String alumno_id) {
        modelo.addAttribute("formatoUnicoDatosPersonales", new FormatoUnicoDatosPersonalesBean());
        FormatoUnicoDatosPersonalesBean formatoUnicoDatosPersonalesbean = new FormatoUnicoDatosPersonalesBean();
        //id de alumno provisional en lo que nos dan lo de sesión
        //String alumno_id = "09280531";
        //select * from ...where
        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", alumno_id, "equal", null, null);
        //objeto que voy a insertar
        VistaAlumno alumno = listaAlumnos.get(0);

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

            //inserción del objeto en el facade

            datosPersonalesFacade.create(datosPersonales);
            idDatosPersonales = datosPersonalesFacade.find(datosPersonales.getId()).getId();
            System.out.println("No estuvo");


            formatoUnico.setDatosPersonalesId(datosPersonales);
            formatoUnico.setNumeroCreditos(alumno.getCreditosAcumulados());
            formatoUnico.setPorcentajeCreditos(Double.valueOf(alumno.getPorcentaje()));
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


        //Para insertar en formato único es necesario recuperar el id de datos personales.

//        modelo.addAttribute("datosPersonales", datosPersonales);
//        modelo.addAttribute("formatoUnico", formatoUnico);



        return "/FormatoUnico/formatoUnicoUsuario";
    }

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(new FormatoUnicoDatosPersoValidaciones()); // registramos el validador
//    }
    @RequestMapping(method = RequestMethod.POST, value = "/modificarFormato.do")
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

    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoUsuarioObservaciones.do")
    public String formatoUnicoObservaciones(Model a) {

        return "/FormatoUnico/formatoUnicoUsuarioObservaciones";
    }

    

    @RequestMapping(method = RequestMethod.GET, value = "/pruebaDT.do")
    public String formatoUnicoPruebaDT(Model a) {

        return "/FormatoUnico/pruebaDT";
    }
}
