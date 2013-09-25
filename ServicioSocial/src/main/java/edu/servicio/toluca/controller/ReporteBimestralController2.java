/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.bimestrales.RetroalimentacionReporte;
import edu.servicio.toluca.beans.organizaciones.BorrarProyecto;
import edu.servicio.toluca.entidades.CatalogoDocumento;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.Documentos;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.entidades.Reportes;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.CatalogoDocumentoFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.DocumentosFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.ReportesFacade;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @EJB(mappedName = "java:global/ServicioSocial/ReportesFacade")
    private ReportesFacade reportesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
    private FormatoUnicoFacade formatoUnicoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/DocumentosFacade")
    private DocumentosFacade documentosFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CatalogoDocumentoFacade")
    private CatalogoDocumentoFacade catalogoDocumentoFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/reporteBimestralAdministrador.do")
    public String reporteBimestralAdministrador(Model modelo) 
    {
        modelo.addAttribute("datosPersonales", datosPersonalesFacade.findAll());
        modelo.addAttribute("reportes", reportesFacade.findAll());
        modelo.addAttribute("retroalimentacionReporte", new RetroalimentacionReporte());
        return "/ReporteBimestral/reporteBimestralAdministrador";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/detalleReporteBimestral.do")
    public String detalleReporteBimestral(int id,Model modelo) 
    {
        Reportes reporte=reportesFacade.find(BigDecimal.valueOf(id));
        modelo.addAttribute("reportes", reporte);
        return "/ReporteBimestral/detalleReporteBimestral";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/actualizarStatusReporte.do")
    public @ResponseBody
    String aceptarRactualizarStatusReporteporte(int id,RetroalimentacionReporte retroalimentacionReporte,Model model, HttpSession session, HttpServletRequest request) {
        Reportes reporte;
        reporte=reportesFacade.find(BigDecimal.valueOf(id));
        //Checar el estatus del reporte
        reporte.setStatus(BigInteger.ONE);
        reportesFacade.edit(reporte);
        System.out.println("Reporte Alterado con Status a: "+retroalimentacionReporte.getStatus());
        return "ok";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/aceptarReporte.do")
    public @ResponseBody
    String aceptarReporte(int id,int status,Model model, HttpSession session, HttpServletRequest request) {
        Reportes reporte;
        reporte=reportesFacade.find(BigDecimal.valueOf(id));
        //Checar el estatus del reporte
        reporte.setStatus(BigInteger.ZERO);
        reportesFacade.edit(reporte);
        System.out.println("Reporte Alterado con Status a: "+status);
        return "ok";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/muestraReporteBimestral.do")
    String muestraReporte(String no_control,Model modelo)
    {
        modelo.addAttribute("no_control", no_control);
        System.out.println("Agui genera el reporte");
        return "/ReporteBimestral/generaReporteBimestral";
    }
    
    @RequestMapping(value = "/guardarReporteBimestral.do", method = RequestMethod.POST)
    public String save(@RequestParam("file") MultipartFile file,int id) throws IOException 
    { 
        System.out.println("Aqui es donde lo debe guardar. Con id: "+id+" y docuemento: "+file.getOriginalFilename());
        Documentos doc=new Documentos();
        CatalogoDocumento catalogoDoc=catalogoDocumentoFacade.find(BigDecimal.valueOf(2));
        DatosPersonales dp=datosPersonalesFacade.find(BigDecimal.valueOf(id));
        doc.setDatosPersonalesId(dp);
        doc.setCatalogoDocumentosId(catalogoDoc);
        doc.setArchivo(file.getBytes());
        doc.setExtension("pdf");
        documentosFacade.create(doc);
        return "/ReporteBimestral/subirAlumnoReporteBimestral";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/subirAlumnoReporteBimestral.do")
    String subirAlumnoReporteBimestral()
    {
        System.out.println("Entro aquí");
        return "/ReporteBimestral/subirAlumnoReporteBimestral";
    }
}
