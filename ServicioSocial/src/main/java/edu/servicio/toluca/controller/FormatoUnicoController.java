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
    public String formatoUnico(Model modelo) {
        modelo.addAttribute("formatoUnicoDatosPersonales", new FormatoUnicoDatosPersonalesBean());
        //id de alumno provisional en lo que nos dan lo de sesión
        String alumno_id = "09280476";
        //select * from ...where
        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", alumno_id, "equal", null, null);
        //objeto que voy a insertar
        DatosPersonales datosPersonales = new DatosPersonales();
        VistaAlumno alumno = listaAlumnos.get(0);
        datosPersonales.setAlumnoId(alumno);
        datosPersonales.setNombre(alumno.getNombre());
        datosPersonales.setApellidoP(alumno.getApellidoPat());
        datosPersonales.setApellidoM(alumno.getApellidoMat());
        datosPersonales.setCurp(alumno.getCurp());
        datosPersonales.setSexo(alumno.getSexo());
        datosPersonales.setTelefonoCasa(alumno.getTelefono())   ;
        datosPersonales.setCorreoElectronico(alumno.getEMail());
        //inserción del objeto en el facade
        datosPersonalesFacade.create(datosPersonales);
        
        //Para insertar en formato único es necesario recuperar el id de datos personales.
        BigDecimal idDatosPersonales = datosPersonalesFacade.find(datosPersonales.getId()).getId();
        FormatoUnico formatoUnico = new FormatoUnico();
        formatoUnico.setDatosPersonalesId(datosPersonales);
        formatoUnico.setNumeroCreditos(alumno.getCreditosAcumulados());
        formatoUnico.setPorcentajeCreditos(Double.valueOf(alumno.getPorcentaje()));
        formatoUnicoFacade.create(formatoUnico);
        
        
        return "/FormatoUnico/formatoUnicoUsuario";
    }
    
//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(new FormatoUnicoDatosPersoValidaciones()); // registramos el validador
//    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/modificarFormato.do")
    public @ResponseBody FormatoUnicoErrores modificarDatosPersonalesAlumno( @Valid FormatoUnicoDatosPersonalesBean dt,BindingResult resultado){
        System.out.println(dt.getSexo());      
        if (resultado.hasErrors())
        {         
            for(ObjectError error: resultado.getAllErrors())
            {
                System.out.println(error.getDefaultMessage());   
            }
        }        
        return new FormatoUnicoErrores();
    }
    
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoUsuarioObservaciones.do")
    public String formatoUnicoObservaciones(Model a) {
        
        return "/FormatoUnico/formatoUnicoUsuarioObservaciones";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoAdministrador.do")
    public String formatoUnicoAdministrador(Model a) {
        
        return "/FormatoUnico/formatoUnicoAdministrador";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/pruebaDT.do")
    public String formatoUnicoPruebaDT(Model a) {
        
        return "/FormatoUnico/pruebaDT";
    }
   
}
