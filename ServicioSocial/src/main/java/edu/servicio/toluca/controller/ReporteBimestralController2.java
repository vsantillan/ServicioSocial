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
    public @ResponseBody
    String aceptarRactualizarStatusReporteporte(int id,RetroalimentacionReporte retroalimentacionReporte,Model model, HttpSession session, HttpServletRequest request) {
        Reportes reporte;
        reporte=reportesFacade.find(BigDecimal.valueOf(id));
        //Checar el estatus del reporte
        reporte.setStatus(BigInteger.ONE);
        reporte.setNumeroRevisiones(BigInteger.valueOf(reporte.getNumeroRevisiones().intValue()+1));
        reportesFacade.edit(reporte);
        System.out.println("Reporte Alterado con Status a: "+retroalimentacionReporte.getStatus());
        return "ok";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/aceptarReporte.do")
    public @ResponseBody
    String aceptarReporte(int id,int status,Model model, HttpSession session, HttpServletRequest request) 
    {
        Reportes reporte;
        reporte=reportesFacade.find(BigDecimal.valueOf(id));
        //Checar el estatus del reporte
        reporte.setStatus(BigInteger.ZERO);
        reporte.setNumeroRevisiones(BigInteger.valueOf(reporte.getNumeroRevisiones().intValue()+1));
        reportesFacade.edit(reporte);
        System.out.println("Reporte Alterado con Status a: "+status);
        return "ok";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/muestraReporteBimestral.do")
    String muestraReporte(String no_control,Model modelo,HttpSession session, HttpServletRequest request)
    {
        modelo.addAttribute("no_control", no_control);
        System.out.println("Agui genera el reporte");
        return "/ReporteBimestral/generaReporteBimestral";
    }
    
    @RequestMapping(value = "/guardarReporteBimestral.do", method = RequestMethod.POST)
    public String subirReporteBi(@RequestParam("file") MultipartFile file, String no_control,HttpSession session, HttpServletRequest request) throws IOException 
    {
        System.out.println("Inicia Subir carta motivos");
        System.out.println("El no control del alumno es->" + no_control);
        
        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", no_control, "equal", null, null);
        if (vistaAlumnoFacade.count() < 1 || listaAlumnos.isEmpty()) {
            System.out.println("O no hay registros en la tabla o no existe tal alumno en la base de datos de Vista LAumno");
            return "redirect:panelUsuario.do";
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
        List<Documentos> listaDocumentos = documentosFacade.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
        Documentos documento = new Documentos();
        boolean enDocumentos = false;
        if (documentosFacade.count() < 1 || listaDocumentos.isEmpty()) {
            System.out.println("Todo indica que dicho registro en Documentos no existia se va a hacer uno nuevo");
            enDocumentos = false;
        } else {
            if(listaDocumentos.get(0).getCatalogoDocumentosId() == catalogoDocumento)
            {
                System.out.println("Todo indica que ya estaba el registro en Documentos, se va a editar");
                enDocumentos = true;
                documento = listaDocumentos.get(0);
            }
            else
            {
                System.out.println("Todo indica que dicho registro en Documentos no existia se va a hacer uno nuevo");
                enDocumentos = false;
            }
            
        }
        documento.setArchivo(file.getBytes());
        documento.setDatosPersonalesId(datosPersonales);
        String extension = file.getOriginalFilename();
        extension = extension.substring(extension.length() - 3, extension.length());
        documento.setExtension(extension);
        documento.setFechaSubida(new java.util.Date());
        documento.setCatalogoDocumentosId(catalogoDocumento);
//        if(enDocumentos)
//        {
//            documentosFacade.edit(documento);
//            System.out.println("Fin de creación en Documento");
//        }
//        else
//        {
            documentosFacade.create(documento);
            System.out.println("Fin de edición en Docuemnto");
//        }
        return "redirect:subirAlumnoReporteBimestral.do";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/subirAlumnoReporteBimestral.do")
    String subirAlumnoReporteBimestral(@RequestParam String no_control,Model modelo)
    {
        modelo.addAttribute("no_control", no_control);
        return "/ReporteBimestral/subirAlumnoReporteBimestral";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/muestraReporteBimestral.pdf")
    public String muestraReporteBimestral(Model modelo, String nControl, String no_reporte, HttpSession session, HttpServletRequest request,HttpServletResponse httpServletResponse) throws ParseException, JRException 
    {
        try {
        String noControl = session.getAttribute("NCONTROL").toString();
        modelo.addAttribute("noControl", noControl);
        System.out.println("En el muestra :D" + noControl);
        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", noControl, "equal", null, null);
        VistaAlumno alumno = listaAlumnos.get(0);

        if (listaAlumnos.isEmpty()) 
        {
            System.out.println("La lista de formatoUnico está vacía");
            return "PanelUsuario/panelUsuario";
        }

        Conexion conn =new Conexion ();
        /*Establecemos la ruta del reporte*/ 
        File reportFile = new File(request.getRealPath("reportes//plantilaReporteBimestral.jasper")); 
         /* No enviamos parámetros porque nuestro reporte no los necesita asi que escriba cualquier cadena de texto ya que solo seguiremos el formato del método runReportToPdf*/
        Map parameters = new HashMap();
        parameters.put("noControl",alumno.getId());
        parameters.put("no_reporte", Integer.parseInt(no_reporte));
        //parameters.put("Nombre_parametro", "Valor_Parametro"); 
        /*Enviamos la ruta del reporte, los parámetros y la conexión(objeto Connection)*/
        byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath (), parameters, conn.conectar("ges_vin", "gst05a"));
        /*Indicamos que la respuesta va a ser en formato PDF*/ 
        httpServletResponse.setContentType("application/pdf"); 
        httpServletResponse.setContentLength(bytes.length);
        httpServletResponse.getOutputStream().write(bytes);

    } catch (Exception ex) {
        Exceptions.printStackTrace(ex);
    } 

    //modelo.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
    return "redirect:login.do";        
}
}
