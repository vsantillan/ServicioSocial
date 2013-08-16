/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.FormatoUnicoDatosPersoValidaciones;
import edu.servicio.toluca.beans.FormatoUnicoDatosPersonalesBean;
import edu.servicio.toluca.beans.FormatoUnicoErrores;
import edu.servicio.toluca.beans.Observaciones;
import org.hibernate.Hibernate;
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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SerializationUtils;
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
public class FormatoUnicoAdminController {

    @EJB(mappedName = "java:global/ServicioSocial/CatalogoObservacionesFacade")
    private CatalogoObservacionesFacade observacionesCatalogoFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
    private FormatoUnicoFacade formatoUnicoFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/DocumentosFacade")
    private DocumentosFacade documentoFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/DatosPersonalesFacade")
    private DatosPersonalesFacade datosPersonalesFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/RegObservacionesFacade")
    private RegObservacionesFacade regisObservacionesFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    private VistaAlumnoFacade vistaAlumnoFacade;
    
    //Status de FormatoUnico FUI en  base al documento status_DOC_1.doc
    final int VALOR_NO_REVISADOS = 4;
    final int VALOR_ACEPTADOS = 1;
    final int VALOR_RECHAZADOS = 2;
    final int VALOR_CORRECCION = 3;
    
    //ID CatalogoDocumentos FormatoUnico
    
    final long DOC_CAT_FU=1;
    
    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoAdministrador.do")
    public String formatoUnicoAdministrador(Model model) {
        
        //Listas de Formato Unico en los diferentes Status
        List<FormatoUnicoBean> listadoFormatosNoRevisados=new ArrayList<FormatoUnicoBean>();
        List<FormatoUnicoBean> listadoFormatosAceptados=new ArrayList<FormatoUnicoBean>();
        List<FormatoUnicoBean> listadoFormatosRechazados=new ArrayList<FormatoUnicoBean>();
        List<FormatoUnicoBean> listadoFormatosCorreccion=new ArrayList<FormatoUnicoBean>();
        

        for (FormatoUnico formato : formatoUnicoFacade.findAll()) 
        {
            
             //------------------Formatos No Revisados------------------------
                if(formato.getStatusFui()!=null && 
                   formato.getStatusFui().equals(BigInteger.valueOf(VALOR_NO_REVISADOS)))
                {
                //Asignando Datos A Formato Unico en estado NO_REVISADO
                FormatoUnicoBean formatoNR=new FormatoUnicoBean();
                formatoNR.setIdFormatoUnico(formato.getId().toString());
                formatoNR.setNoControl( formato.getDatosPersonalesId().getAlumnoId().getId() );
                formatoNR.setNombre(formato.getDatosPersonalesId().getNombre()
                                    +" "+formato.getDatosPersonalesId().getApellidoP()
                                    +" "+formato.getDatosPersonalesId().getApellidoM());
                formatoNR.setIdDatosPersonales(formato.getDatosPersonalesId().getId().toString());
                formatoNR.setPeriodo(formato.getPeriodoInicio());
                //Buscar FormatoUnico en Tabla Documentos Regresa todos los .pdf .jpg .png
                //En caso de que HIBERNATE se generen consultas con AND, se tiene que modificar este query 
                // y se reducen lineas de codigo
                List<Documentos> listaDocumentos = documentoFacade.findBySpecificField("datosPersonalesId",
                                                               formato.getDatosPersonalesId(),
                                                               "equal", null, null);
                //Filtrar Resultado 
                String fechaSubida = obtenerFechaSubidaFormatoU(listaDocumentos);
                if(fechaSubida != null)
                {
                     /*
                      Si es diferente de null, el documento de FormatoUnico se encuentra en la tabla de Documentos
                      */
                     formatoNR.setFechaSubida(fechaSubida);
                     String idDocumento = obtenerIDDocumentoFormatoU(listaDocumentos);
                     
                     if(idDocumento!=null)
                     {
                        formatoNR.setIdDocumentoFormatoUnico(idDocumento);
                        //Se Agrega El Objeto FormatoUnico a la lista de FomatoUnicos en estado NO_REVISADOS
                        listadoFormatosNoRevisados.add(formatoNR);    
                     }

                }
            }
            //------------------Formatos Aceptados------------------------    
            if(formato.getStatusFui()!=null && formato.getStatusFui().equals(BigInteger.valueOf(VALOR_ACEPTADOS)))//
            {
                FormatoUnicoBean formatoAceptados = new FormatoUnicoBean();
                
                formatoAceptados.setNoControl( formato.getDatosPersonalesId().getAlumnoId().getId() );
                formatoAceptados.setNombre(formato.getDatosPersonalesId().getNombre()
                                    +" "+formato.getDatosPersonalesId().getApellidoP()
                                    +" "+formato.getDatosPersonalesId().getApellidoM());
                formatoAceptados.setPeriodo(formato.getPeriodoInicio());
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
            //------------------Formatos Rechazados------------------------   
            if(formato.getStatusFui()!=null && formato.getStatusFui().equals(BigInteger.valueOf(VALOR_RECHAZADOS)))//
            {
                FormatoUnicoBean formatoRechazados = new FormatoUnicoBean();
                formatoRechazados.setNoControl( formato.getDatosPersonalesId().getAlumnoId().getId() );
                formatoRechazados.setNombre(formato.getDatosPersonalesId().getNombre()
                                    +" "+formato.getDatosPersonalesId().getApellidoP()
                                    +" "+formato.getDatosPersonalesId().getApellidoM());   
                formatoRechazados.setPeriodo(formato.getPeriodoInicio());
                List<Documentos> listaDocumentos2 = documentoFacade.findBySpecificField("datosPersonalesId",
                                                               formato.getDatosPersonalesId(),
                                                               "equal", null, null);
                for (RegObservaciones reg : regisObservacionesFacade.findBySpecificField("datosPersonalesId", 
                                                            formato.getDatosPersonalesId(),
                                                            "equal", null, null)) {
                     
                     String detalle=observacionesCatalogoFacade.find(reg.getId()).getDetalle();
                     System.out.println(detalle);
                     formatoRechazados.añadirObservacion(detalle);
                }

                String fechaSubida = obtenerFechaSubidaFormatoU(listaDocumentos2);
                if(fechaSubida != null)
                {
                     formatoRechazados.setFechaSubida(fechaSubida);
                     listadoFormatosRechazados.add(formatoRechazados);
                }
            }
            //------------------//Formatos Correccion-----------------------   
            if(formato.getStatusFui()!=null && formato.getStatusFui().equals(BigInteger.valueOf(VALOR_CORRECCION)))
            {
                FormatoUnicoBean formatoCorreccion = new FormatoUnicoBean();
                formatoCorreccion.setNoControl( formato.getDatosPersonalesId().getAlumnoId().getId() );
                formatoCorreccion.setNombre(formato.getDatosPersonalesId().getNombre()
                                    +" "+formato.getDatosPersonalesId().getApellidoP()
                                    +" "+formato.getDatosPersonalesId().getApellidoM());   
                formatoCorreccion.setPeriodo(formato.getPeriodoInicio());
                List<Documentos> listaDocumentos = documentoFacade.findBySpecificField("datosPersonalesId",
                                                               formato.getDatosPersonalesId(),
                                                               "equal", null, null);
                for (RegObservaciones reg : regisObservacionesFacade.findBySpecificField("datosPersonalesId", 
                                                            formato.getDatosPersonalesId(),
                                                            "equal", null, null)) {
                     
                     String detalle=observacionesCatalogoFacade.find(reg.getId()).getDetalle();
                     System.out.println(detalle);
                     formatoCorreccion.añadirObservacion(detalle);
                }
                String fechaSubida = obtenerFechaSubidaFormatoU(listaDocumentos);
 
                if(fechaSubida != null)
                {
                     formatoCorreccion.setFechaSubida(fechaSubida);
                     listadoFormatosCorreccion.add(formatoCorreccion);
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
        //Catalogo Sanciones
        model.addAttribute("listadoObservaciones", observacionesCatalogoFacade.findAll());
        return "/FormatoUnico/formatoUnicoAdministrador";
    }
    
    
    /**
     * 
     * @param id
     * @return Cambia el estado de un FormatoUnico de estado NO_REVISADO 
     * a estado ACEPTADO
     */
    @RequestMapping(method = RequestMethod.POST, value = "/modificarFormatoUnicoNR_Aceptado.do")
    public @ResponseBody String modificarFU_NR_Aceptados(String id) {
        //Obtener FormatoUnico en especifico 
        FormatoUnico fA=formatoUnicoFacade.find(BigDecimal.valueOf(Long.valueOf(id)));
        //Se encontro el Objeto
        if(fA!=null)
        {
            //Cambiar Estado de NO_ACEPTADO A ACEPTADO
            fA.setStatusFui(BigInteger.valueOf(VALOR_ACEPTADOS));
            formatoUnicoFacade.edit(fA);
        }
        
        
        
        return "OK";
    }
    
    
    
    /**
     * @see  variable tipo indica que tipo de cambio de status realizara
     *                     si es 1 cambiara de NO_REVISADO a CORRECCION
     *                     si es 2 cambiara de NO_REVISADO a RECHAZO
     *       variable observaciones es un array de id's de Observaciones en Base al Catalogo Observaciones
     * 
     * @param observaciones
     * @param idDatoPersonales
     * @param idFormatoUnico
     * @param tipo
     * @return 
     */
    @RequestMapping(method = RequestMethod.POST, value = "/modificarFormatoUnicoNR.do")
    public @ResponseBody String modificarFormatoUnico(@RequestParam(value = "observaciones[]", required = false) String[] observaciones,
                         String idDatoPersonales,
                         String idFormatoUnico,
                         String tipo) {
        

        switch(Integer.parseInt(tipo))
        {
            case 1://Correccion
                //Buscar Formato Unico
                FormatoUnico fu=formatoUnicoFacade.find(BigDecimal.valueOf(Long.valueOf(idFormatoUnico)));
                //Cambiar Status
                fu.setStatusFui(BigInteger.valueOf(VALOR_CORRECCION));
                formatoUnicoFacade.edit(fu);
                break;
            case 2://Rechazo
                //Buscar Formato Unico
                FormatoUnico fuR=formatoUnicoFacade.find(BigDecimal.valueOf(Long.valueOf(idFormatoUnico)));
                //Cambiar Status
                fuR.setStatusFui(BigInteger.valueOf(VALOR_RECHAZADOS));
                formatoUnicoFacade.edit(fuR);
                break;
        }
        
        for(String idObservacion:observaciones)
        {
            //Objeto a Registrar
            RegObservaciones registro=new RegObservaciones();
            //Buscar Objeto Pertenciente al CatalogoObservaciones con el id recibido y asignarlo
            registro.setCatalogoObservacionId(observacionesCatalogoFacade.find(BigDecimal.valueOf(Long.valueOf(idObservacion))));
            //Buscar Objeto Pertenciente a la Tabla de DatosPersonales con el id recibido y asignarlo
            registro.setDatosPersonalesId(datosPersonalesFacade.find(BigDecimal.valueOf(Long.valueOf(idFormatoUnico))));
            //Asignar Fecha Actual al momento para registro 
            registro.setFecha(new Date());
            //Creacion de Registro
            regisObservacionesFacade.create(registro);
        }
        return "OK";
    }

    
     
    //Metodos 
     
     
     /**
      * 
      * @param listaDocumentos
      * @return Fecha de Subida de Formato Unico
      * De todos los documentos, se obtiene solo los documentos con CATALOGO_ID= 1
      * En caso de no encontrar nada devuelve null, en caso contrario la Fecha de Subida
      */
     
     private  String  obtenerFechaSubidaFormatoU(List<Documentos> listaDocumentos)
     {
         for (Documentos docu : listaDocumentos) 
         {
                    if(docu.getCatalogoDocumentosId().getId().equals(BigDecimal.valueOf(DOC_CAT_FU)) )//Es igual a formato Unico
                    {
                        return docu.getFechaSubida().toString();
                    }
         }
         return null;
     }
     /**
      * 
      * @param listaDocumentos
      * @return ID_DOCUMENTO del FormatoUnico, en caso de no encontrarse retorna null
      */
     
     private String  obtenerIDDocumentoFormatoU(List<Documentos> listaDocumentos)
     {
         for (Documentos docu : listaDocumentos) 
         {
                    if(docu.getCatalogoDocumentosId().getId().equals(BigDecimal.valueOf(DOC_CAT_FU)) )//Es igual a formato Unico
                    {
                        return docu.getId().toString();
                    }
         }
         return null;
     }
     
     ////PRUEBA DE FOTO!!!!!!!!!!!!!!!!!!!!!!!
    @RequestMapping(value = "/guardarPDF.do", method = RequestMethod.POST)
    public String save(
            @RequestParam("file") MultipartFile file,String id) throws IOException { 

        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        Documentos doc=documentoFacade.find(BigDecimal.valueOf(Long.parseLong(id)));
        System.out.println(doc);
        doc.setArchivo(file.getBytes());
        doc.setExtension("pdf");
        documentoFacade.edit(doc);
        return "redirect:subirpdf.do";
    }
    @RequestMapping(value = "/guardarIMG.do", method = RequestMethod.POST)
    public String saveImage(
            @RequestParam("file") MultipartFile file,String id) throws IOException { 
        
        VistaAlumno alumno= vistaAlumnoFacade.find(id);
        System.out.println(file.getSize());
        alumno.setFoto(file.getBytes());
        vistaAlumnoFacade.edit(alumno);
        return "redirect:subirIMG.do";
    }

    @RequestMapping(value = "/subirpdf.do",method = RequestMethod.GET)
    public String guardaFotoPrueba(Model modelo) {
        return "/FormatoUnico/guardarFoto";
    }
    
    @RequestMapping(value = "/subirIMG.do",method = RequestMethod.GET)
    public String guardaIMGPrueba(Model modelo) {
        return "/FormatoUnico/guardarIMG";
    }
    
    @RequestMapping(value = "/mostarPDF.do", method = RequestMethod.GET)
    @ResponseBody
    public void showPDF(String id,HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {
        
        httpServletResponse.setContentType("application/pdf");
        Documentos doc=documentoFacade.find(BigDecimal.valueOf(Long.parseLong(id)));
        byte[] pdfImage = serialize(doc.getArchivo());
        httpServletResponse.getOutputStream().write(pdfImage);
    }
    
    
    
    @RequestMapping(value = "/eeeee.do", method = RequestMethod.GET)
    @ResponseBody
    public void saveAndShowPDF( HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {
        
        httpServletResponse.setContentType("application/pdf");
         Documentos doc=documentoFacade.find(BigDecimal.valueOf(1l));
        byte[] pdfImage = serialize(doc.getArchivo());
        httpServletResponse.getOutputStream().write(pdfImage);
    }
    
    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(obj);
        return b.toByteArray();
    }
     
    
}
