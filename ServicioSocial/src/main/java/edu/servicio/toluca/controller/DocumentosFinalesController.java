/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.DocumentosFinalesBean;
import edu.servicio.toluca.beans.documentosFinales.RetroalimentacionDocumentosFinales;
import edu.servicio.toluca.configuracion.ExpresionesRegularesErrores;
import edu.servicio.toluca.entidades.CatalogoDocumento;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.Documentos;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.CatalogoDocumentoFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.DocumentosFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ekt
 */
@Controller
public class DocumentosFinalesController 
{
    @EJB(mappedName = "java:global/ServicioSocial/DatosPersonalesFacade")
    private DatosPersonalesFacade datosPersonalesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/DocumentosFacade")
    private DocumentosFacade documentosFacade;
    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    private VistaAlumnoFacade vistaAlumnoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CatalogoDocumentoFacade")
    private CatalogoDocumentoFacade catalogoDocumentoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
    private FormatoUnicoFacade formatoUnicoFacade;
    
    @RequestMapping(method = RequestMethod.GET, value = "/documentosFinales.do")
    public String administradorDocumentosFinales(Model model) 
    {
        List<DatosPersonales> listaDatosPer=datosPersonalesFacade.findAll();
        List<Documentos> listaDocum;//=documentosFacade.findBySpecificField("status", "1", "equal", null, null);
        List<DocumentosFinalesBean> alumnosDocumentos=new ArrayList<DocumentosFinalesBean>();
        DocumentosFinalesBean nuevoAlumno;
        for(int i=0;i<listaDatosPer.size();i++)
        {
            listaDocum=documentosFacade.findBySpecificField("datosPersonalesId", listaDatosPer.get(i), "equal", null, null);
            System.out.println("No Control: "+listaDatosPer.get(i).getAlumnoId().getId());
            System.out.println("Nombre: "+listaDatosPer.get(i).getNombre());
            nuevoAlumno=new DocumentosFinalesBean();
            nuevoAlumno.setIdDatosPer(listaDatosPer.get(i).getId().intValue());
            nuevoAlumno.setNoControl(listaDatosPer.get(i).getAlumnoId().getId());
            nuevoAlumno.setNombreCompleto(listaDatosPer.get(i).getNombre()+" "+listaDatosPer.get(i).getApellidoP()+" "+listaDatosPer.get(i).getApellidoM());
            nuevoAlumno.setCorreo(listaDatosPer.get(i).getCorreoElectronico());
            for(int j=0;j<listaDocum.size();j++)
            {
                if("Reporte_Bimestral".equals(listaDocum.get(j).getCatalogoDocumentosId().getTipo()) || "Formato_Unico".equals(listaDocum.get(j).getCatalogoDocumentosId().getTipo()))
                {

                }else if("Constancia_Pago".equals(listaDocum.get(j).getCatalogoDocumentosId().getTipo()))
                {
                    nuevoAlumno.setIdConstanciaPago(listaDocum.get(j).getId().intValue());
                }else if("Reporte_Evaluacion".equals(listaDocum.get(j).getCatalogoDocumentosId().getTipo()))
                {
                    nuevoAlumno.setIdReporteCalificacion(listaDocum.get(j).getId().intValue());
                }else if("Reporte_Final".equals(listaDocum.get(j).getCatalogoDocumentosId().getTipo()))
                {
                    nuevoAlumno.setIdReporteFinal(listaDocum.get(j).getId().intValue());
                }else if("Formato_Unico_Final".equals(listaDocum.get(j).getCatalogoDocumentosId().getTipo()))
                {
                    nuevoAlumno.setIdFormatoUnicoFinal(listaDocum.get(j).getId().intValue());
                }
            }
            if(nuevoAlumno.getIdConstanciaPago()!=0 || nuevoAlumno.getIdFormatoUnicoFinal()!=0 || nuevoAlumno.getIdReporteFinal()!=0 || nuevoAlumno.getIdReporteCalificacion()!=0)
            {
                alumnosDocumentos.add(nuevoAlumno);
            }
            System.out.println("***********aqui agregaria un nuevo alumno a la lista -- "+ listaDatosPer.get(i).getNombre());
        }
        
        model.addAttribute("documentosAlumno", alumnosDocumentos);
        model.addAttribute("retroalimentacionDocumentosFinales", new RetroalimentacionDocumentosFinales());
        return "/DocumentosFinales/administrarDocumentosFinales";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/documentosFinalesAlumno.do")
    public String documentosFinalesAlumno(Model model) 
    {    
        //String no_control = session.getAttribute("NCONTROL").toString();
        String no_control="09280525";

        VistaAlumno alumno = vistaAlumnoFacade.find(no_control);
        
        List<DatosPersonales> listaDatosPersonales = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
        DatosPersonales datosPersonales = listaDatosPersonales.get(0);
        
        List<FormatoUnico> listaFormatoUnico = formatoUnicoFacade.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
        FormatoUnico formatoUnicoAlumno = listaFormatoUnico.get(0);
        
        System.out.println("Vista alumno: "+alumno.getId()+"\tDatos personales: "+datosPersonales.getId()+"\tFormato unico: "+formatoUnicoAlumno.getId()+"\tcon plan de: "+formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
        
        model.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
        model.addAttribute("no_control", no_control);
        return "/DocumentosFinales/documentosFinalesAlumno";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/guardarDocumentosFinales.do")
    public String guardarDocumentosFinales(MultipartFile fileFUF,
                                           MultipartFile fileCP,
                                           MultipartFile fileRF,
                                           MultipartFile fileRE ,Model modelo) throws IOException//),HttpSession session, HttpServletRequest request) throws IOException 
    {
        //String no_control = session.getAttribute("NCONTROL").toString(); @RequestParam("fileRP") MultipartFile fileRP,
        String no_control="09280525";
        System.out.println("Inicia Subir Documentoa Finales");
        System.out.println("El no control del alumno es->" + no_control);
        
        VistaAlumno alumno = vistaAlumnoFacade.find(no_control);
        if(alumno.getId()==null || "".equals(alumno.getId()))
        {
            System.out.println("O no hay registros en la tabla o no existe tal alumno en la base de datos de Vista LAumno");
            modelo.addAttribute("error", "Error al subir el Reporte Bimestral");
        }
        
        List<DatosPersonales> listaDatosPersonales = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
        DatosPersonales datosPersonales = listaDatosPersonales.get(0);
        
        List<FormatoUnico> listaFormatoUnico = formatoUnicoFacade.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
        FormatoUnico formatoUnicoAlumno = listaFormatoUnico.get(0);
        
        //** Inicia Validación si el FUF, CP o RF es vacio **//
        if("".equals(fileFUF.getOriginalFilename()))
        {
            modelo.addAttribute("error_fuf", "<div class='error'>El campo Formato Único Final no puede ser vacío</div>");
            modelo.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
            modelo.addAttribute("no_control", no_control);
            return "/DocumentosFinales/documentosFinalesAlumno";
        }else if("".equals(fileCP.getOriginalFilename()))
        {
            modelo.addAttribute("error_cp", "<div class='error'>La campo Constancia de Evaluación no puede estar vacío</div>");
            modelo.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
            modelo.addAttribute("no_control", no_control);
            return "/DocumentosFinales/documentosFinalesAlumno";
        }else if("".equals(fileRF.getOriginalFilename()))
        {
            modelo.addAttribute("error_fr", "<div class='error'>El campo Reporte Final no puede estar vacío</div>");    
            modelo.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
            modelo.addAttribute("no_control", no_control);
            return "/DocumentosFinales/documentosFinalesAlumno";
        }
        //** Termina Validación si el FUF, CP o RF es vacio **//
        
        //** Inicia Verifica el tipo de reticula del alumno **//
        if("S".equals(formatoUnicoAlumno.getCatalogoPlanId().getDetalle())) //Cuando es reticula 2009
        {
            System.out.println("FUF nombre: "+fileFUF.getOriginalFilename()+"\tConstancia Pago: "+fileCP.getOriginalFilename()+"\tReporte final: "+fileRF.getOriginalFilename()+"\tFormato Evaluacion: "+fileRE.getOriginalFilename());
            //** Inicia Validación si el RE es vacio **//
            if("".equals(fileRE.getOriginalFilename()))
            {
                modelo.addAttribute("error_fe", "<div class='error'>El campo Formato de Evaluación no puede estar vacío</div>");    
                modelo.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
                modelo.addAttribute("no_control", no_control);
                return "/DocumentosFinales/documentosFinalesAlumno";
            }
            //** Termina Validación si el RE es vacio **//
            
            System.out.println("Iniciando proceso de subida de documento");
            
            List<CatalogoDocumento> listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Formato_Unico_Final", "equal", null, null); 
            CatalogoDocumento catalogoDocumento = listaCatalogoDocumento.get(0);
        
            Documentos documentoFUF = new Documentos();
            documentoFUF.setArchivo(fileFUF.getBytes());
            documentoFUF.setDatosPersonalesId(datosPersonales);
            String extension = fileFUF.getOriginalFilename();
            extension = extension.substring(extension.length() - 3, extension.length());
            documentoFUF.setExtension(extension);
            documentoFUF.setFechaSubida(new java.util.Date());
            documentoFUF.setStatus((short)1);
            documentoFUF.setCatalogoDocumentosId(catalogoDocumento);
            System.out.println(extension);
            if(!"pdf".equals(extension)) //** Verifica que la extenxion del archivo FUF sea PDF
            {
                modelo.addAttribute("error_fuf", "<div class='error'>Tipo de archivo incorrecto</div>");

                modelo.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
                modelo.addAttribute("no_control", no_control);
                return "/DocumentosFinales/documentosFinalesAlumno";
            }
            
            listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Constancia_Pago", "equal", null, null); 
            catalogoDocumento = listaCatalogoDocumento.get(0);
        
            Documentos documentoCP = new Documentos();
            documentoCP.setArchivo(fileCP.getBytes());
            documentoCP.setDatosPersonalesId(datosPersonales);
            extension = fileCP.getOriginalFilename();
            extension = extension.substring(extension.length() - 3, extension.length());
            documentoCP.setExtension(extension);
            documentoCP.setFechaSubida(new java.util.Date());
            documentoCP.setStatus((short)1);
            documentoCP.setCatalogoDocumentosId(catalogoDocumento);
            System.out.println(extension);
            if(!"pdf".equals(extension)) //** Verifica que la extenxion del archivo CP sea PDF
            {
                modelo.addAttribute("error_cp", "<div class='error'>Tipo de archivo incorrecto</div>");
                
                modelo.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
                modelo.addAttribute("no_control", no_control);
                return "/DocumentosFinales/documentosFinalesAlumno";
            }
            
            listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Reporte_Final", "equal", null, null); 
            catalogoDocumento = listaCatalogoDocumento.get(0);
        
            Documentos documentoRF = new Documentos();
            documentoRF.setArchivo(fileRF.getBytes());
            documentoRF.setDatosPersonalesId(datosPersonales);
            extension = fileRF.getOriginalFilename();
            extension = extension.substring(extension.length() - 3, extension.length());
            documentoRF.setExtension(extension);
            documentoRF.setFechaSubida(new java.util.Date());
            documentoRF.setStatus((short)1);
            documentoRF.setCatalogoDocumentosId(catalogoDocumento);
            System.out.println(extension);
            if(!"pdf".equals(extension)) //** Verifica que la extenxion del archivo RF sea PDF
            {
                modelo.addAttribute("error_fr", "<div class='error'>Tipo de archivo incorrecto</div>");    
                
                modelo.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
                modelo.addAttribute("no_control", no_control);
                return "/DocumentosFinales/documentosFinalesAlumno";
            }
            
            listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Reporte_Evaluacion", "equal", null, null); 
            catalogoDocumento = listaCatalogoDocumento.get(0);
        
            Documentos documentoRE = new Documentos();
            documentoRE.setArchivo(fileRE.getBytes());
            documentoRE.setDatosPersonalesId(datosPersonales);
            extension = fileRE.getOriginalFilename();
            extension = extension.substring(extension.length() - 3, extension.length());
            documentoRE.setExtension(extension);
            documentoRE.setFechaSubida(new java.util.Date());
            documentoRE.setStatus((short)1);
            documentoRE.setCatalogoDocumentosId(catalogoDocumento);
            if(!"pdf".equals(extension)) //** Verifica que la extenxion del archivo RF sea PDF
            {
                modelo.addAttribute("error_fe", "<div class='error'>Tipo de archivo incorrecto</div>");    
                
                modelo.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
                modelo.addAttribute("no_control", no_control);
                return "/DocumentosFinales/documentosFinalesAlumno";
            }
            
            try{
                documentosFacade.create(documentoFUF);
                documentosFacade.create(documentoCP);
                documentosFacade.create(documentoRF);
                documentosFacade.create(documentoRE);
                System.out.println("Se subio el Docuemnto con éxito!");
            }catch(Exception ex){
                modelo.addAttribute("error", "Error al subir los documentos");
                System.out.println("ERROR: al subir el Docuemnto! **** Java dice: "+ex);
                return "/DocumentosFinales/documentosFinalesAlumno";
            }
        }else if("N".equals(formatoUnicoAlumno.getCatalogoPlanId().getDetalle())) //Cuando es reticula 2004
        {
            System.out.println("FUF nombre: "+fileFUF.getOriginalFilename()+"\tConstancia Pago: "+fileCP.getOriginalFilename()+"\tReporte final: "+fileRF.getOriginalFilename());
            
            System.out.println("Iniciando proceso de subida de documento");
            
            List<CatalogoDocumento> listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Formato_Unico_Final", "equal", null, null); 
            CatalogoDocumento catalogoDocumento = listaCatalogoDocumento.get(0);
        
            Documentos documentoFUF = new Documentos();
            documentoFUF.setArchivo(fileFUF.getBytes());
            documentoFUF.setDatosPersonalesId(datosPersonales);
            String extension = fileFUF.getOriginalFilename();
            extension = extension.substring(extension.length() - 3, extension.length());
            documentoFUF.setExtension(extension);
            documentoFUF.setFechaSubida(new java.util.Date());
            documentoFUF.setStatus((short)1);
            documentoFUF.setCatalogoDocumentosId(catalogoDocumento);
            System.out.println(extension);
            if(!"pdf".equals(extension)) //** Verifica que la extenxion del archivo FUF sea PDF
            {
                modelo.addAttribute("error_fuf", "<div class='error'>Tipo de archivo incorrecto</div>");

                modelo.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
                modelo.addAttribute("no_control", no_control);
                return "/DocumentosFinales/documentosFinalesAlumno";
            }
            
            listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Constancia_Pago", "equal", null, null); 
            catalogoDocumento = listaCatalogoDocumento.get(0);
        
            Documentos documentoCP = new Documentos();
            documentoCP.setArchivo(fileCP.getBytes());
            documentoCP.setDatosPersonalesId(datosPersonales);
            extension = fileCP.getOriginalFilename();
            extension = extension.substring(extension.length() - 3, extension.length());
            documentoCP.setExtension(extension);
            documentoCP.setFechaSubida(new java.util.Date());
            documentoCP.setStatus((short)1);
            documentoCP.setCatalogoDocumentosId(catalogoDocumento);
            System.out.println(extension);
            if(!"pdf".equals(extension)) //** Verifica que la extenxion del archivo CP sea PDF
            {
                modelo.addAttribute("error_cp", "<div class='error'>Tipo de archivo incorrecto</div>");
                
                modelo.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
                modelo.addAttribute("no_control", no_control);
                return "/DocumentosFinales/documentosFinalesAlumno";
            }
            
            listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Reporte_Final", "equal", null, null); 
            catalogoDocumento = listaCatalogoDocumento.get(0);
        
            Documentos documentoRF = new Documentos();
            documentoRF.setArchivo(fileRF.getBytes());
            documentoRF.setDatosPersonalesId(datosPersonales);
            extension = fileRF.getOriginalFilename();
            extension = extension.substring(extension.length() - 3, extension.length());
            documentoRF.setExtension(extension);
            documentoRF.setFechaSubida(new java.util.Date());
            documentoRF.setStatus((short)1);
            documentoRF.setCatalogoDocumentosId(catalogoDocumento);
            System.out.println(extension);
            if(!"pdf".equals(extension)) //** Verifica que la extenxion del archivo RF sea PDF
            {
                modelo.addAttribute("error_fr", "<div class='error'>Tipo de archivo incorrecto</div>");    
                
                modelo.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
                modelo.addAttribute("no_control", no_control);
                return "/DocumentosFinales/documentosFinalesAlumno";
            }
            
            try{
                documentosFacade.create(documentoFUF);
                documentosFacade.create(documentoCP);
                documentosFacade.create(documentoRF);
                System.out.println("Se subio el Docuemnto con éxito!");
            }catch(Exception ex){
                modelo.addAttribute("error", "Error al subir los documentos");
                System.out.println("ERROR: al subir el Docuemnto! **** Java dice: "+ex);
                return "/DocumentosFinales/documentosFinalesAlumno";
            }
        }
        
        return "/DocumentosFinales/documentosFinalesAlumno";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/aceptarDocumentos.do")
    public @ResponseBody
    String aceptarReporte(int id,int status,Model model, HttpSession session, HttpServletRequest request) 
    {
        Documentos documento;
        documento=documentosFacade.find(BigDecimal.valueOf(id));
        
        documentosFacade.edit(documento);
        System.out.println("Reporte Alterado con Status a: "+status);
        return "ok";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/rechazaDocumentos.do")
    public @ResponseBody
    String rechazaReporte(RetroalimentacionDocumentosFinales retroalimentacionDocumentosFinales,Model model, HttpSession session, HttpServletRequest request) 
    {
        System.out.println("fuf: "+retroalimentacionDocumentosFinales.getIdFUF());
        System.out.println("cp: "+retroalimentacionDocumentosFinales.getIdCP());
        System.out.println("rf: "+retroalimentacionDocumentosFinales.getIdRF());
        System.out.println("rc: "+retroalimentacionDocumentosFinales.getIdRC());
        
        System.out.println("Reporte Alterado con Status a: "+retroalimentacionDocumentosFinales.getStatus());
        return "ok";
    }
}
