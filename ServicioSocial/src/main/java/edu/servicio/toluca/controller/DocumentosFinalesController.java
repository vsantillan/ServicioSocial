/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.DocumentosFinalesBean;
import edu.servicio.toluca.beans.organizaciones.BorrarInstancia;
import edu.servicio.toluca.entidades.CatalogoDocumento;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.Documentos;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.Reportes;
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
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        List<DocumentosFinalesBean> alumnoDocumentos;
        for(int i=0;i<listaDatosPer.size();i++)
        {
            listaDocum=documentosFacade.findBySpecificField("datosPersonalesId", listaDatosPer.get(i), "equal", null, null);
            for(int j=0;j<listaDocum.size();j++)
            {
                if(!"Reporte_Bimestral".equals(listaDocum.get(j).getCatalogoDocumentosId().getTipo()) || !"Formato_Unico".equals(listaDocum.get(j).getCatalogoDocumentosId().getTipo()))
                {
                    System.out.println("No Control: "+listaDatosPer.get(i).getAlumnoId().getId());
                    System.out.println("Nombre: "+listaDatosPer.get(i).getNombre());
                    System.out.println("Tipo Documento: "+listaDocum.get(j).getCatalogoDocumentosId().getTipo());
                    DocumentosFinalesBean nuevoAlumno=new DocumentosFinalesBean(listaDatosPer.get(i).getId().intValue(),
                                                                                listaDatosPer.get(i).getAlumnoId().getId(),
                                                                                listaDatosPer.get(i).getNombre()+listaDatosPer.get(i).getApellidoP()+listaDatosPer.get(i).getApellidoM(),
                                                                                1,3,4,5);
                    
                }
                //System.out.println("+++++++++++++++++++"+listaDocum.get(j).getCatalogoDocumentosId().getTipo());
            }
            //System.out.println("***********"+listaDatosPer.get(i).getNombre());
        }
        
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
        System.out.println("Inicia Subir carta motivos");
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
        
        if("S".equals(formatoUnicoAlumno.getCatalogoPlanId().getDetalle()))
        {
            System.out.println("FUF nombre: "+fileFUF.getOriginalFilename()+"\tConstancia Pago: "+fileCP.getOriginalFilename()+"\tReporte final: "+fileRF.getOriginalFilename()+"\tFormato Evaluacion: "+fileRE.getOriginalFilename());
            
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
            documentoFUF.setCatalogoDocumentosId(catalogoDocumento);
            
            listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Constancia_Pago", "equal", null, null); 
            catalogoDocumento = listaCatalogoDocumento.get(0);
        
            Documentos documentoCP = new Documentos();
            documentoCP.setArchivo(fileCP.getBytes());
            documentoCP.setDatosPersonalesId(datosPersonales);
            extension = fileCP.getOriginalFilename();
            extension = extension.substring(extension.length() - 3, extension.length());
            documentoCP.setExtension(extension);
            documentoCP.setFechaSubida(new java.util.Date());
            documentoCP.setCatalogoDocumentosId(catalogoDocumento);
            
            listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Reporte_Final", "equal", null, null); 
            catalogoDocumento = listaCatalogoDocumento.get(0);
        
            Documentos documentoRF = new Documentos();
            documentoRF.setArchivo(fileRF.getBytes());
            documentoRF.setDatosPersonalesId(datosPersonales);
            extension = fileRF.getOriginalFilename();
            extension = extension.substring(extension.length() - 3, extension.length());
            documentoRF.setExtension(extension);
            documentoRF.setFechaSubida(new java.util.Date());
            documentoRF.setCatalogoDocumentosId(catalogoDocumento);
            
            listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Reporte_Evaluacion", "equal", null, null); 
            catalogoDocumento = listaCatalogoDocumento.get(0);
        
            Documentos documentoRE = new Documentos();
            documentoRE.setArchivo(fileRE.getBytes());
            documentoRE.setDatosPersonalesId(datosPersonales);
            extension = fileRE.getOriginalFilename();
            extension = extension.substring(extension.length() - 3, extension.length());
            documentoRE.setExtension(extension);
            documentoRE.setFechaSubida(new java.util.Date());
            documentoRE.setCatalogoDocumentosId(catalogoDocumento);
            
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
        }else if("N".equals(formatoUnicoAlumno.getCatalogoPlanId().getDetalle()))
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
            documentoFUF.setCatalogoDocumentosId(catalogoDocumento);
            
            listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Constancia_Pago", "equal", null, null); 
            catalogoDocumento = listaCatalogoDocumento.get(0);
        
            Documentos documentoCP = new Documentos();
            documentoCP.setArchivo(fileCP.getBytes());
            documentoCP.setDatosPersonalesId(datosPersonales);
            extension = fileCP.getOriginalFilename();
            extension = extension.substring(extension.length() - 3, extension.length());
            documentoCP.setExtension(extension);
            documentoCP.setFechaSubida(new java.util.Date());
            documentoCP.setCatalogoDocumentosId(catalogoDocumento);
            
            listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Reporte_Final", "equal", null, null); 
            catalogoDocumento = listaCatalogoDocumento.get(0);
        
            Documentos documentoRF = new Documentos();
            documentoRF.setArchivo(fileRF.getBytes());
            documentoRF.setDatosPersonalesId(datosPersonales);
            extension = fileRF.getOriginalFilename();
            extension = extension.substring(extension.length() - 3, extension.length());
            documentoRF.setExtension(extension);
            documentoRF.setFechaSubida(new java.util.Date());
            documentoRF.setCatalogoDocumentosId(catalogoDocumento);
            
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
        
//        List<CatalogoDocumento> listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Formato_Bimestral", "equal", null, null); 
//        CatalogoDocumento catalogoDocumento = catalogoDocumentoFacade.find(BigDecimal.valueOf(2));
//        
//        Documentos documento = new Documentos();
//        documento.setArchivo(file.getBytes());
//        documento.setDatosPersonalesId(datosPersonales);
//        String extension = file.getOriginalFilename();
//        extension = extension.substring(extension.length() - 3, extension.length());
//        documento.setExtension(extension);
//        documento.setFechaSubida(new java.util.Date());
//        documento.setCatalogoDocumentosId(catalogoDocumento);
//  
//        try{
//            //documentosFacade.create(documento);
//            System.out.println("Se subio el Docuemnto con éxito!");
//        }catch(Exception ex){
//            modelo.addAttribute("error", "Error al subir el Reporte Bimestral");
//            System.out.println("ERROR: al subir el Docuemnto!");
//            return "/DocumentosFinales/documentosFinalesAlumno";
//        }
        
        return "/DocumentosFinales/documentosFinalesAlumno";
    }
}
