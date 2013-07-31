/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.FormatoUnicoDatosPersoValidaciones;
import edu.servicio.toluca.beans.FormatoUnicoDatosPersonalesBean;
import edu.servicio.toluca.beans.FormatoUnicoErrores;
import edu.servicio.toluca.beans.Observaciones;

import edu.servicio.toluca.beans.formatoUnico.FormatoUnicoBean;

import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.Documentos;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.RegObservaciones;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.CatalogoObservacionesFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.DocumentosFacade;
import edu.servicio.toluca.sesion.RegObservacionesFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
    
    @EJB(mappedName = "java:global/ServicioSocial/RegObservacionesFacade")
    private RegObservacionesFacade regisObservacionesFacade;
    
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoAdministrador.do")
    public String formatoUnicoAdministrador(Model model) {
        
        List<FormatoUnicoBean> listadoFormatosNoRevisados=new ArrayList<FormatoUnicoBean>();
        List<FormatoUnicoBean> listadoFormatosAceptados=new ArrayList<FormatoUnicoBean>();
        List<FormatoUnicoBean> listadoFormatosRechazados=new ArrayList<FormatoUnicoBean>();
        List<FormatoUnicoBean> listadoFormatosCorreccion=new ArrayList<FormatoUnicoBean>();
        
        
        
        
        final int VALOR_NO_REVISADOS = 4;
        final int VALOR_ACEPTADOS = 1;
        final int VALOR_RECHAZADOS = 2;
        final int VALOR_CORRECCION = 3;
        
        for (FormatoUnico formato : formatoUnico.findAll()) 
        {
                if(formato.getStatusFui()!=null && formato.getStatusFui().equals(BigInteger.valueOf(VALOR_NO_REVISADOS)))//Formatos No Revisados
                {
                    FormatoUnicoBean formatoNR=new FormatoUnicoBean();

                formatoNR.setIdFormatoUnico(formato.getId().toString());
                formatoNR.setNoControl( formato.getDatosPersonalesId().getAlumnoId().getId() );
                formatoNR.setNombre(formato.getDatosPersonalesId().getNombre()
                                    +" "+formato.getDatosPersonalesId().getApellidoP()
                                    +" "+formato.getDatosPersonalesId().getApellidoM());
                formatoNR.setIdDatosPersonales(formato.getDatosPersonalesId().getId().toString());
                

                List<Documentos> listaDocumentos = documentoFacade.findBySpecificField("datosPersonalesId",
                                                               formato.getDatosPersonalesId(),
                                                               "equal", null, null);

                String fechaSubida = obtenerFechaSubidaFormatoU(listaDocumentos);
                if(fechaSubida != null)
                {
                     formatoNR.setFechaSubida(fechaSubida);
                     listadoFormatosNoRevisados.add(formatoNR);
                }
            }
                
            if(formato.getStatusFui()!=null && formato.getStatusFui().equals(BigInteger.valueOf(VALOR_ACEPTADOS)))//Formatos Aceptados
            {
                FormatoUnicoBean formatoAceptados = new FormatoUnicoBean();
                
                formatoAceptados.setNoControl( formato.getDatosPersonalesId().getAlumnoId().getId() );
                formatoAceptados.setNombre(formato.getDatosPersonalesId().getNombre()
                                    +" "+formato.getDatosPersonalesId().getApellidoP()
                                    +" "+formato.getDatosPersonalesId().getApellidoM());
                
                List<Documentos> listaDocumentos2 = documentoFacade.findBySpecificField("datosPersonalesId",
                                                               formato.getDatosPersonalesId(),
                                                               "equal", null, null);

                String fechaSubida = obtenerFechaSubidaFormatoU(listaDocumentos2);
                if(fechaSubida != null)
                {
                     formatoAceptados.setFechaSubida(fechaSubida);
                     listadoFormatosAceptados.add(formatoAceptados);
                }
            }
            if(formato.getStatusFui()!=null && formato.getStatusFui().equals(BigInteger.valueOf(VALOR_RECHAZADOS)))//Formatos Rechazados
            {
                FormatoUnicoBean formatoRechazados = new FormatoUnicoBean();
                formatoRechazados.setNoControl( formato.getDatosPersonalesId().getAlumnoId().getId() );
                formatoRechazados.setNombre(formato.getDatosPersonalesId().getNombre()
                                    +" "+formato.getDatosPersonalesId().getApellidoP()
                                    +" "+formato.getDatosPersonalesId().getApellidoM());   
                List<Documentos> listaDocumentos2 = documentoFacade.findBySpecificField("datosPersonalesId",
                                                               formato.getDatosPersonalesId(),
                                                               "equal", null, null);
                String fechaSubida = obtenerFechaSubidaFormatoU(listaDocumentos2);
                if(fechaSubida != null)
                {
                     formatoRechazados.setFechaSubida(fechaSubida);
                     listadoFormatosRechazados.add(formatoRechazados);
                }
            }
            if(formato.getStatusFui()!=null && formato.getStatusFui().equals(BigInteger.valueOf(VALOR_CORRECCION)))//Formatos Correccion
            {
                FormatoUnicoBean formatoRechazados = new FormatoUnicoBean();
                formatoRechazados.setNoControl( formato.getDatosPersonalesId().getAlumnoId().getId() );
                formatoRechazados.setNombre(formato.getDatosPersonalesId().getNombre()
                                    +" "+formato.getDatosPersonalesId().getApellidoP()
                                    +" "+formato.getDatosPersonalesId().getApellidoM());   
                List<Documentos> listaDocumentos = documentoFacade.findBySpecificField("datosPersonalesId",
                                                               formato.getDatosPersonalesId(),
                                                               "equal", null, null);
                String fechaSubida = obtenerFechaSubidaFormatoU(listaDocumentos);
                if(fechaSubida != null)
                {
                     formatoRechazados.setFechaSubida(fechaSubida);
                     listadoFormatosCorreccion.add(formatoRechazados);
                }
            }
        }
        
       
        
        
        
        
        
        //Formatos Unicos No Revisados 
        model.addAttribute("listadoFormatoUnicoNORevisados",listadoFormatosNoRevisados);
        
        //Formato Unico Aceptados
        model.addAttribute("listadoFormatoUnicoAceptados",listadoFormatosAceptados);
        
        //Formato Rechazados
        model.addAttribute("listadoFormatoUnicoRechazados",listadoFormatosRechazados);
        
        //Formato Correccion
        model.addAttribute("listadoFormatoUnicoCorreccion",listadoFormatosCorreccion);
        
        model.addAttribute("listadoObservaciones", observacionesFacade.findAll());
        return "/FormatoUnico/formatoUnicoAdministrador";
    }
    
    
    ///Cambios de Datos 
    @RequestMapping(method = RequestMethod.POST, value = "/modificarFormatoUnicoNR_Aceptado.do")
    public @ResponseBody String modificarFU_NR_Aceptados(String id) {
        
        formatoUnico.find(BigDecimal.valueOf(Long.valueOf(id))).setStatusFui(BigInteger.valueOf(1));
        
        
        return "OK";
    }
    
    
    
   
    @RequestMapping(method = RequestMethod.POST, value = "/modificarFormatoUnicoNR.do")
    public @ResponseBody String modificarFormatoUnico(@RequestParam(value = "observaciones[]", required = false) String[] observaciones,String alumno) {
        
        for(String i:observaciones)
        {
            RegObservaciones registro=new RegObservaciones();
            registro.setCatalogoObservacionId(observacionesFacade.find(BigDecimal.valueOf(Long.valueOf(i))));
            registro.setDatosPersonalesId(datosPersonalesFacade.find(BigDecimal.valueOf(Long.valueOf(alumno))));
            registro.setFecha(new Date());
        }
        return "OK";
    }
    
    
     @RequestMapping(method = RequestMethod.GET, value = "/olaqe.do")
    public @ResponseBody String listadoFormatoUnicoNRevisados(Model modelo) {
        return "OK";
    }
    
     
    //Metodos Estaticos
     
     private static String  obtenerFechaSubidaFormatoU(List<Documentos> listaDocumentos)
     {
         for (Documentos docu : listaDocumentos) 
         {
                    if(docu.getCatalogoDocumentosId().getId().equals(BigDecimal.valueOf(1l)) )//Es igual a formato Unico
                    {
                        return docu.getFechaSubida().toString();
                    }
         }
         return null;
     }
    
}
