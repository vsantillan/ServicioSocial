/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.bimestrales.RetroalimentacionReporte;
import edu.servicio.toluca.beans.documentosFinales.GeneraDocumento;
import edu.servicio.toluca.beans.organizaciones.BorrarProyecto;
import edu.servicio.toluca.entidades.CatalogoDocumento;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.Documentos;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.entidades.Reportes;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.login.Conexion;
import edu.servicio.toluca.sesion.CatalogoDocumentoFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.DocumentosFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.ReportesFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.openide.util.Exceptions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ekt
 */
@Controller
public class ReporteBimestralController2 
{
    @EJB(mappedName = "java:global/ServicioSocial/DatosPersonalesFacade")
    private DatosPersonalesFacade datosPersonalesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    private VistaAlumnoFacade vistaAlumnoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/ReportesFacade")
    private ReportesFacade reportesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
    private FormatoUnicoFacade formatoUnicoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/DocumentosFacade")
    private DocumentosFacade documentosFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CatalogoDocumentoFacade")
    private CatalogoDocumentoFacade catalogoDocumentoFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/reporteBimestralAdministrador.do")
    public String reporteBimestralAdministrador(Model modelo,HttpSession session, HttpServletRequest request) 
    {
        modelo.addAttribute("datosPersonales", datosPersonalesFacade.findAll());
        modelo.addAttribute("reportes", reportesFacade.findAll());
        modelo.addAttribute("retroalimentacionReporte", new RetroalimentacionReporte());
        return "/ReporteBimestral/reporteBimestralAdministrador";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/detalleReporteBimestral.do")
    public String detalleReporteBimestral(int id,Model modelo,HttpSession session, HttpServletRequest request) 
    {
        Reportes reporte=reportesFacade.find(BigDecimal.valueOf(id));
        modelo.addAttribute("reportes", reporte);
        return "/ReporteBimestral/detalleReporteBimestral";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/actualizarStatusReporte.do")
    public String aceptarRactualizarStatusReporteporte(RetroalimentacionReporte retroalimentacionReporte,Model model, HttpSession session, HttpServletRequest request) {
        Reportes reporte;
        reporte=reportesFacade.find(BigDecimal.valueOf(retroalimentacionReporte.getIdReporte()));
        //Checar el estatus del reporte
        reporte.setStatus(BigInteger.valueOf(retroalimentacionReporte.getStatus()));
        reporte.setNumeroRevisiones(BigInteger.valueOf(reporte.getNumeroRevisiones().intValue()+1));
        reportesFacade.edit(reporte);
        Documentos documento;
        short nuevoStatus=(short) retroalimentacionReporte.getStatus();
        documento=documentosFacade.find(BigDecimal.valueOf(retroalimentacionReporte.getIdDoc()));
        documento.setStatus(nuevoStatus);
        System.out.println("Reporte Alterado con Status a: "+retroalimentacionReporte.getIdDoc());
        documentosFacade.edit(documento);
        System.out.println("Reporte Alterado con Status a: "+retroalimentacionReporte.getStatus());
        System.out.println("El id de reporte es: "+retroalimentacionReporte.getIdReporte());
        return "redirect:reporteBimestralAdministrador.do";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/aceptarReporte.do")
    public @ResponseBody
    String aceptarReporte(int id,int status,int idDoc, Model model, HttpSession session, HttpServletRequest request) 
    {
        Reportes reporte;
        reporte=reportesFacade.find(BigDecimal.valueOf(id));
        //Checar el estatus del reporte
        reporte.setStatus(BigInteger.ONE);
        reporte.setNumeroRevisiones(BigInteger.valueOf(reporte.getNumeroRevisiones().intValue()+1));
        reportesFacade.edit(reporte);
        Documentos documento;
        documento=documentosFacade.find(BigDecimal.valueOf(idDoc));
        documento.setStatus((short)1);
        documentosFacade.edit(documento);
        System.out.println("id doc es: "+idDoc);
        System.out.println("Reporte Alterado con Status a: "+status);
        return "ok";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/muestraReporteBimestralDoc.do")
    String muestraReporte(Model modelo,HttpSession session, HttpServletRequest request)
    {
        session.setAttribute("no_reporte", 2);
        session.setAttribute("id_reporte", 2);
        System.out.println("Agui genera el reporte");
        return "/ReporteBimestral/generaReporteBimestral";
    }
    
    @RequestMapping(value = "/guardarReporteBimestral.do", method = RequestMethod.POST)
    public String subirReporteBi(@RequestParam("file") MultipartFile file,Model modelo,HttpSession session, HttpServletRequest request) throws IOException 
    {
        String no_control = session.getAttribute("NCONTROL").toString();
        System.out.println("Inicia Subir carta motivos");
        System.out.println("El no control del alumno es->" + no_control);
        
        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", no_control, "equal", null, null);
        if (vistaAlumnoFacade.count() < 1 || listaAlumnos.isEmpty()) {
            System.out.println("O no hay registros en la tabla o no existe tal alumno en la base de datos de Vista LAumno");
            modelo.addAttribute("error", "Error al subir el Reporte Bimestral");
        }
        
        VistaAlumno alumno = listaAlumnos.get(0);
        List<DatosPersonales> listaDatosPersonales = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
        DatosPersonales datosPersonales = listaDatosPersonales.get(0);

        System.out.println("Inicia subida de info la tabla de Egresado");
        System.out.println("Original filename: " + file.getOriginalFilename());
        System.out.println("File:" + file.getName());
        System.out.println("Size:" + file.getSize());
        System.out.println("ContentType:" + file.getContentType());
        System.out.println("COmprobando que no exista antes una carta de motivos en la tabla");
        
        System.out.println("Iniciando proceso de subida de documento");
        //List<CatalogoDocumento> listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Formato_Bimestral", "equal", null, null); 
        CatalogoDocumento catalogoDocumento = catalogoDocumentoFacade.find(BigDecimal.valueOf(2));
        
        Documentos documento = new Documentos();
        documento.setArchivo(file.getBytes());
        documento.setDatosPersonalesId(datosPersonales);
        String extension = file.getOriginalFilename();
        extension = extension.substring(extension.length() - 3, extension.length());
        documento.setExtension(extension);
        documento.setFechaSubida(new java.util.Date());
        documento.setCatalogoDocumentosId(catalogoDocumento);
        documento.setStatus((short)4);
  
        try{
            documentosFacade.create(documento);
            System.out.println("Se subio el Docuemnto con éxito!");
        }catch(Exception ex){
            modelo.addAttribute("error", "Error al subir el Reporte Bimestral");
            return "redirect:formatoReporteBimestral.do";
        }
        
        List<Reportes> listReporte=reportesFacade.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
        Reportes reporte=listReporte.get(0);
        reporte.setStatus(BigInteger.valueOf(4));
        reportesFacade.edit(reporte);
        
        //reporte.setDatosPersonalesId(datosPersonales);
        
        
        
        //##############   CAMBIA REPORTE A ESTATUS 4 
        //##############   REEDIRECCIONA  A PANEL USUARIO
        //##############   MANDAR MENSAJE DE ERROR
            
        return "redirect:panelUsuario.do";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/subirAlumnoReporteBimestral.do")
    String subirAlumnoReporteBimestral(@RequestParam String no_control,Model modelo)
    {
        modelo.addAttribute("no_control", no_control);
        return "/ReporteBimestral/subirAlumnoReporteBimestral";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/muestraReporteBimestral.pdf")
    public @ResponseBody String muestraReporteBimestral(Model modelo, String nControl, String idProyecto, HttpServletRequest request,HttpServletResponse httpServletResponse) throws ParseException, JRException
    {
         
        
//        String[][] arr=new String [2][3];
//        arr[0][0]="no_control";
//        arr[1][0]="09280525";
//        arr[0][1]="no_reporte";
//        arr[1][1]="1";
//        arr[0][2]="id_reporte";
//        arr[1][2]="1";
//        
        Map parameters=new HashMap();
        parameters.put("no_control", "09280525");
        parameters.put("no_reporte", "1");
        parameters.put("id_reporte", "1");
        try {
            GeneraDocumento obj = new GeneraDocumento();
            obj.generar("ges_vin", "gst01a", "plantilaReporteBimestral", parameters, request, httpServletResponse);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        } 
        return "OK";        
    }
}
