/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.bimestrales.RetroalimentacionReporte;
import edu.servicio.toluca.beans.documentosFinales.GeneraDocumento;
import edu.servicio.toluca.beans.organizaciones.BorrarProyecto;
import edu.servicio.toluca.entidades.BimestralesActividades;
import edu.servicio.toluca.entidades.CatalogoDocumento;
import edu.servicio.toluca.entidades.CatalogoObservaciones;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.Documentos;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.entidades.RegObservaciones;
import edu.servicio.toluca.entidades.Reportes;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.login.Conexion;
import edu.servicio.toluca.sesion.CatalogoDocumentoFacade;
import edu.servicio.toluca.sesion.CatalogoObservacionesFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.DocumentosFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.RegObservacionesFacade;
import edu.servicio.toluca.sesion.ReportesFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
public class ReporteBimestralController2 {

    @EJB(mappedName = "java:global/ServicioSocial/CatalogoObservacionesFacade")
    private CatalogoObservacionesFacade observacionesCatalogoFacade;
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
        @EJB(mappedName = "java:global/ServicioSocial/RegObservacionesFacade")
    private RegObservacionesFacade regisObservacionesFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/reporteBimestralAdministrador.do")
    public String reporteBimestralAdministrador(Model modelo, HttpSession session, HttpServletRequest request) {
        modelo.addAttribute("datosPersonales", datosPersonalesFacade.findAll());
        List<Reportes> listaBimestrales = reportesFacade.findAll();
        List<Reportes> reportesRevisados = new ArrayList<Reportes>();
        List<Reportes> reportesRevisadosUnicos = new ArrayList<Reportes>();
        List<Reportes> reportesNoRevisados = new ArrayList<Reportes>();
        List<Reportes> reportesEnCorreccion = new ArrayList<Reportes>();
        List<Reportes> reportesRechazados = new ArrayList<Reportes>();
        Iterator<Reportes> recorreListaBimestrales = listaBimestrales.iterator();

        while (recorreListaBimestrales.hasNext()) {
            Reportes reporteActual = recorreListaBimestrales.next();
            if (reporteActual.getStatus().compareTo(BigInteger.valueOf(1)) == 0) {
                reportesRevisados.add(reporteActual);
            }
            if (reporteActual.getStatus().compareTo(BigInteger.valueOf(4)) == 0) {
                reportesNoRevisados.add(reporteActual);
            }
            if (reporteActual.getStatus().compareTo(BigInteger.valueOf(3)) == 0) {
                reportesEnCorreccion.add(reporteActual);
            }
            if (reporteActual.getStatus().compareTo(BigInteger.valueOf(2)) == 0) {
                reportesRechazados.add(reporteActual);
            }
        }

        boolean existe = false;
        Iterator<Reportes> recorreListaRevisados = reportesRevisados.iterator();

        while (recorreListaRevisados.hasNext()) {
            Reportes reporte = recorreListaRevisados.next();
            System.out.println("Tamaño de los Unicos" + reportesRevisadosUnicos.size());
            if (!reportesRevisadosUnicos.isEmpty()) {
                for (int i = 0; i <= reportesRevisadosUnicos.size() - 1; i++) {
                    BigDecimal id = reportesRevisadosUnicos.get(i).getDatosPersonalesId().getId();
                    System.out.println("i for:" + (i + 1) + "Size" + (reportesRevisadosUnicos.size() - 1));

                    if (reporte.getDatosPersonalesId().getId().compareTo(id) == 0) {
                        existe = true;
                        System.out.println("Existe y corto el while interno");
                        break;
                    } else {
                        if ((i) == reportesRevisadosUnicos.size() - 1) {
                            existe = false;
                            System.out.println("Debo agregar" + reporte.getDatosPersonalesId().getId());
                            reportesRevisadosUnicos.add(reporte);
                        }
                    }
                }
            } else {
                reportesRevisadosUnicos.add(reporte);
            }

        }
        modelo.addAttribute("reportesRevisados", reportesRevisadosUnicos);
        modelo.addAttribute("reportesNoRevisados", reportesNoRevisados);
        modelo.addAttribute("reportesEnCorreccion", reportesEnCorreccion);
        modelo.addAttribute("reportesRechazados", reportesRechazados);
//        modelo.addAttribute("retroalimentacionReporte", new RetroalimentacionReporte());
        //Catalogo Sanciones
        List<CatalogoObservaciones> observaciones = observacionesCatalogoFacade.findAll();
        List<CatalogoObservaciones> observacionesBimestrales = new ArrayList();
        for (CatalogoObservaciones observacionActual : observaciones) {
            if (observacionActual.getTipo().compareTo(BigInteger.valueOf(2)) == 0) {
                observacionesBimestrales.add(observacionActual);
            }
        }
        modelo.addAttribute("listadoObservaciones", observacionesBimestrales);
        return "/ReporteBimestral/reporteBimestralAdministrador";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detalleReporteBimestral.do")
    public String detalleReporteBimestral(int id, Model modelo, HttpSession session, HttpServletRequest request) {
        Reportes reporte = reportesFacade.find(BigDecimal.valueOf(id));
        modelo.addAttribute("reportes", reporte);
        return "/ReporteBimestral/detalleReporteBimestral";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/actualizarStatusReporte.do")
    public @ResponseBody
    String aceptarRactualizarStatusReporteporte(@RequestParam(value = "observaciones[]", required = false) String[] observaciones,
            String idDatoPersonales,
            String idReporte,
            String idDocumento,
            String status,
            String tipo) {

        for (String idObservacion : observaciones) {
            //Objeto a Registrar
            RegObservaciones registro = new RegObservaciones();
            //Buscar Objeto Pertenciente al CatalogoObservaciones con el id recibido y asignarlo
            registro.setCatalogoObservacionId(observacionesCatalogoFacade.find(BigDecimal.valueOf(Long.valueOf(idObservacion))));
            //Buscar Objeto Pertenciente a la Tabla de DatosPersonales con el id recibido y asignarlo
            registro.setDatosPersonalesId(datosPersonalesFacade.find(BigDecimal.valueOf(Long.valueOf(idDatoPersonales))));
            //Asignar Fecha Actual al momento para registro 
            registro.setFecha(new Date());
            //Creacion de Registro
            regisObservacionesFacade.create(registro);
        }
        Reportes reporte;
        reporte = reportesFacade.find(BigDecimal.valueOf(Integer.parseInt(idReporte)));
        //Checar el estatus del reporte
        reporte.setStatus(BigInteger.valueOf(Integer.parseInt(status)));
        reporte.setNumeroRevisiones(BigInteger.valueOf(reporte.getNumeroRevisiones().intValue() + 1));
        reportesFacade.edit(reporte);
        Documentos documento;
        short nuevoStatus = (short) Integer.parseInt(status);
        documento = documentosFacade.find(BigDecimal.valueOf(Integer.parseInt(idDocumento)));
        documento.setStatus(nuevoStatus);
        documentosFacade.edit(documento);
        return "OK";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/aceptarReporte.do")
    public @ResponseBody
    String aceptarReporte(int id, int status, int idDoc, Model model, HttpSession session, HttpServletRequest request) {
        Reportes reporte;
        reporte = reportesFacade.find(BigDecimal.valueOf(id));
        //Checar el estatus del reporte
        reporte.setStatus(BigInteger.ONE);
        reporte.setNumeroRevisiones(BigInteger.valueOf(reporte.getNumeroRevisiones().intValue() + 1));
        reportesFacade.edit(reporte);
        Documentos documento;
        documento = documentosFacade.find(BigDecimal.valueOf(idDoc));
        documento.setStatus((short) 1);
        documentosFacade.edit(documento);
        System.out.println("id doc es: " + idDoc);
        System.out.println("Reporte Alterado con Status a: " + status);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/muestraReporteBimestralDoc.do")
    String muestraReporte(Model modelo, HttpSession session, HttpServletRequest request) {
        session.setAttribute("no_reporte", 2);
        session.setAttribute("id_reporte", 2);
        System.out.println("Agui genera el reporte");
        return "/ReporteBimestral/generaReporteBimestral";
    }

    @RequestMapping(value = "/guardarReporteBimestral.do", method = RequestMethod.POST)
    public String subirReporteBi(@RequestParam("file") MultipartFile file, Model modelo, HttpSession session, HttpServletRequest request) throws IOException {

        String no_control = session.getAttribute("NCONTROL").toString();
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



        ///////////VERIFICAMOS QUE NO EXISTA EL DOCUMENTO//////////////////////
        List<Documentos> ultimoDoc = documentosFacade.findBySpecificField("datosPersonalesId", datosPersonales.getId(), "equal", null, null);
        if (!ultimoDoc.isEmpty()) {
            Documentos ultimoDocumento = ultimoDoc.get(0);
            if (ultimoDocumento.getCatalogoDocumentosId().getId() == BigDecimal.valueOf(2)) {
                if (ultimoDocumento.getStatus() == 3) {
                    ultimoDocumento.setArchivo(file.getBytes());
                    ultimoDocumento.setDatosPersonalesId(datosPersonales);
                    String extension = file.getOriginalFilename();
                    extension = extension.substring(extension.length() - 3, extension.length());
                    ultimoDocumento.setExtension(extension);
                    ultimoDocumento.setFechaSubida(new java.util.Date());
                    ultimoDocumento.setCatalogoDocumentosId(catalogoDocumento);
                    ultimoDocumento.setStatus((short) 4);
                    documentosFacade.edit(ultimoDocumento);
                    System.out.println("Documento Actualizado Correctamente");
                    try {
                        documentosFacade.edit(ultimoDocumento);
                        System.out.println("Se actualizo el documento con exito!");
                        return "redirect:panelUsuario.do";
                    } catch (Exception ex) {
                        modelo.addAttribute("error", "Error al subir el Reporte Bimestral");
                        return "redirect:formatoReporteBimestral.do";
                    }
                }
            }
        }
        ///////////////////////////////////////////////////////////////////////
        Documentos documento = new Documentos();
        documento.setArchivo(file.getBytes());
        documento.setDatosPersonalesId(datosPersonales);
        String extension = file.getOriginalFilename();
        extension = extension.substring(extension.length() - 3, extension.length());
        documento.setExtension(extension);
        documento.setFechaSubida(new java.util.Date());
        documento.setCatalogoDocumentosId(catalogoDocumento);
        documento.setStatus((short) 4);

        try {
            documentosFacade.create(documento);
            System.out.println("Se subio el Docuemnto con éxito!");
        } catch (Exception ex) {
            modelo.addAttribute("error", "Error al subir el Reporte Bimestral");
            return "redirect:formatoReporteBimestral.do";
        }

        List<Reportes> listReporte = reportesFacade.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
        Reportes reporte = listReporte.get(0);
        reporte.setStatus(BigInteger.valueOf(4));
        reportesFacade.edit(reporte);

        //reporte.setDatosPersonalesId(datosPersonales);



        //##############   CAMBIA REPORTE A ESTATUS 4 
        //##############   REEDIRECCIONA  A PANEL USUARIO
        //##############   MANDAR MENSAJE DE ERROR

        return "redirect:panelUsuario.do";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/subirAlumnoReporteBimestral.do")
    String subirAlumnoReporteBimestral(@RequestParam String no_control, Model modelo) {
        modelo.addAttribute("no_control", no_control);
        return "/ReporteBimestral/subirAlumnoReporteBimestral";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/muestraReporteBimestral.pdf")
    public @ResponseBody
    String muestraReporteBimestral(Model modelo, String noReporte, String idReporte, HttpSession session, HttpServletRequest request, HttpServletResponse httpServletResponse) throws ParseException, JRException {

        Map parameters = new HashMap();
        parameters.put("no_control", session.getAttribute("NCONTROL").toString());
        parameters.put("no_reporte", noReporte);
        parameters.put("id_reporte", idReporte);
        try {
            GeneraDocumento obj = new GeneraDocumento();
            obj.generar("ges_vin", "gst05a", "plantilaReporteBimestral", parameters, request, httpServletResponse);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
        return "OK";
    }
    
    public void remueveObservaciones(BigDecimal idDatosPersonales){
        List<RegObservaciones> observacionesAlumno= regisObservacionesFacade.findBySpecificField(null, this, null, null, null);
    }
}
