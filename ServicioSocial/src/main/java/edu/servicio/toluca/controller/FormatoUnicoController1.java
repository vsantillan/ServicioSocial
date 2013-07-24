/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.FormatoUnicoDatosPersoValidaciones;
import edu.servicio.toluca.beans.FormatoUnicoDatosPersonalesBean;
import edu.servicio.toluca.beans.FormatoUnicoErrores;
import edu.servicio.toluca.beans.Observaciones;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.CatalogoObservacionesFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.DocumentosFacade;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author WindSaber
 */
@Controller
public class FormatoUnicoController1 {

    @EJB(mappedName = "java:global/ServicioSocial/CatalogoObservacionesFacade")
    private CatalogoObservacionesFacade observacionesFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
    private FormatoUnicoFacade formatoUnico;
    
    @EJB(mappedName = "java:global/ServicioSocial/DocumentosFacade")
    private DocumentosFacade documentoFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/DatosPersonalesFacade")
    private DatosPersonalesFacade datosPersonalesFacade;
    
    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoAdministrador.do")
    public String formatoUnicoAdministrador(Model model) {
        final int VALOR_NO_REVISADOS=4; 
        
        model.addAttribute("listadoObservaciones",observacionesFacade.findAll());
        
        //Formatos Unicos No Revisados 
        model.addAttribute("listadoFormatoUnicoNORevisados",
                           formatoUnico.findBySpecificField("statusFui",
                                                           BigInteger.valueOf(VALOR_NO_REVISADOS),
                                                           "equal", null, null)); 
        
        
        datosPersonalesFacade.find(1);
        
        
        documentoFacade.findBySpecificField("datosPersonalesId", model, "equal", null, null);
        
        
        //Formatos Unicos No Revisados
        
        return "/FormatoUnico/formatoUnicoAdministrador";
    }
    
   
    @RequestMapping(method = RequestMethod.POST, value = "/modificarFormatoUnicoNR.do")
    public @ResponseBody String modificarFormatoUnico(@RequestParam(value = "id[]", required = false) String[] id) {
        
        System.out.println(id);
        return "OK";
    }
    
    
     @RequestMapping(method = RequestMethod.GET, value = "/olaqe.do")
    public @ResponseBody String listadoFormatoUnicoNRevisados(Model modelo) {
         
        
        
        
       
        return "OK";
    }
    
    
}
