/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.EnviarCorreo;
import edu.servicio.toluca.beans.bimestrales.RetroalimentacionReporte;
import edu.servicio.toluca.beans.bimestrales.fechas;
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
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.openide.util.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(OrganizacionesController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/reporteBimestralAdministrador.do")
    public String reporteBimestralAdministrador(Model modelo, HttpSession session, HttpServletRequest request)
    {
        LinkedHashMap ordenarAsc = new LinkedHashMap();
        ordenarAsc.put("id", "asc");
        modelo.addAttribute("datosPersonales", datosPersonalesFacade.findAll(ordenarAsc));
        List<Reportes> listaBimestrales = reportesFacade.findAll();
        List<Reportes> reportesRevisados = new ArrayList<Reportes>();
        List<Reportes> reportesRevisadosUnicos = new ArrayList<Reportes>();
        List<Reportes> reportesNoRevisados = new ArrayList<Reportes>();
        List<Reportes> reportesEnCorreccion = new ArrayList<Reportes>();
        List<Reportes> reportesRechazados = new ArrayList<Reportes>();
        Iterator<Reportes> recorreListaBimestrales = listaBimestrales.iterator();

        while (recorreListaBimestrales.hasNext())
        {
            Reportes reporteActual = recorreListaBimestrales.next();
            if (reporteActual.getStatus().compareTo(BigInteger.valueOf(1)) == 0)
            {
                reportesRevisados.add(reporteActual);
            }
            if (reporteActual.getStatus().compareTo(BigInteger.valueOf(4)) == 0)
            {
                reportesNoRevisados.add(reporteActual);
            }
            if (reporteActual.getStatus().compareTo(BigInteger.valueOf(3)) == 0)
            {
                reportesEnCorreccion.add(reporteActual);
            }
            if (reporteActual.getStatus().compareTo(BigInteger.valueOf(2)) == 0)
            {
                reportesRechazados.add(reporteActual);
            }
        }

        boolean existe = false;
        Iterator<Reportes> recorreListaRevisados = reportesRevisados.iterator();

        while (recorreListaRevisados.hasNext())
        {
            Reportes reporte = recorreListaRevisados.next();
            System.out.println("Tamaño de los Unicos" + reportesRevisadosUnicos.size());
            if (!reportesRevisadosUnicos.isEmpty())
            {
                for (int i = 0; i <= reportesRevisadosUnicos.size() - 1; i++)
                {
                    BigDecimal id = reportesRevisadosUnicos.get(i).getDatosPersonalesId().getId();
                    System.out.println("i for:" + (i + 1) + "Size" + (reportesRevisadosUnicos.size() - 1));

                    if (reporte.getDatosPersonalesId().getId().compareTo(id) == 0)
                    {
                        existe = true;
                        System.out.println("Existe y corto el while interno");
                        break;
                    } else
                    {
                        if ((i) == reportesRevisadosUnicos.size() - 1)
                        {
                            existe = false;
                            System.out.println("Debo agregar" + reporte.getDatosPersonalesId().getId());
                            reportesRevisadosUnicos.add(reporte);
                        }
                    }
                }
            } else
            {
                reportesRevisadosUnicos.add(reporte);
            }

        }
        // Collections.sort(reportesRevisadosUnicos, new OrdenarPorId());
        modelo.addAttribute("reportesRevisados", reportesRevisadosUnicos);
        modelo.addAttribute("reportesNoRevisados", reportesNoRevisados);
        modelo.addAttribute("reportesEnCorreccion", reportesEnCorreccion);
        modelo.addAttribute("reportesRechazados", reportesRechazados);
//        modelo.addAttribute("retroalimentacionReporte", new RetroalimentacionReporte());
        //Catalogo Sanciones
        List<CatalogoObservaciones> observaciones = observacionesCatalogoFacade.findAll();
        List<CatalogoObservaciones> observacionesBimestrales = new ArrayList();
        for (CatalogoObservaciones observacionActual : observaciones)
        {
            if (observacionActual.getTipo().compareTo(BigInteger.valueOf(2)) == 0)
            {
                observacionesBimestrales.add(observacionActual);
            }
        }
        modelo.addAttribute("listadoObservaciones", observacionesBimestrales);
        return "/ReporteBimestral/reporteBimestralAdministrador";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detalleReporteBimestral.do")
    public String detalleReporteBimestral(int id, Model modelo, HttpSession session, HttpServletRequest request)
    {
        Reportes reporte = reportesFacade.find(BigDecimal.valueOf(id));
        modelo.addAttribute("reportes", reporte);
        return "/ReporteBimestral/detalleReporteBimestral";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dameObservaciones.do")
    public @ResponseBody
    List<String> dameObservaciones(@RequestParam(value = "id", required = true) String idAlumno)
    {
        System.out.println("Datos personales" + idAlumno);
        List<RegObservaciones> listaObservaciones
                = regisObservacionesFacade.findBySpecificField("datosPersonalesId", BigDecimal.valueOf(Long.valueOf(idAlumno)), "equal", null, null);
        List<String> observaciones = new ArrayList<String>();

        for (RegObservaciones regObservaciones : listaObservaciones)
        {
            observaciones.add(regObservaciones.getCatalogoObservacionId().getDetalle());
        }
        return observaciones;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/actualizarStatusReporte.do")
    public @ResponseBody
    String aceptarRactualizarStatusReporteporte(@RequestParam(value = "observaciones[]", required = false) String[] observaciones,
            String idDatoPersonales,
            String idReporte,
            String idDocumento,
            String status,
            String tipo)
    {

        for (String idObservacion : observaciones)
        {
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
        String nombre = "";
        System.out.println("El estatus es" + status);
        switch (Integer.parseInt(status))
        {
            case 2://Rechazo
                //Enviar Correo
                List<FormatoUnico> formatoCancelado = formatoUnicoFacade.findBySpecificField("datosPersonalesId", reporte.getDatosPersonalesId().getId(), "equal", null, null);
                FormatoUnico fuc = formatoCancelado.get(0);
                fuc.setStatusServicio(BigInteger.valueOf(2));
                formatoUnicoFacade.edit(fuc);
                nombre = reporte.getDatosPersonalesId().getNombre() + " "
                        + reporte.getDatosPersonalesId().getApellidoP() + " "
                        + reporte.getDatosPersonalesId().getApellidoM();

                enviarCorreo(3, reporte.getDatosPersonalesId().getCorreoElectronico(), nombre, reporte.getDatosPersonalesId());
                break;
            case 3://Correccion
                nombre = reporte.getDatosPersonalesId().getNombre() + " "
                        + reporte.getDatosPersonalesId().getApellidoP() + " "
                        + reporte.getDatosPersonalesId().getApellidoM();

                enviarCorreo(2, reporte.getDatosPersonalesId().getCorreoElectronico(), nombre, reporte.getDatosPersonalesId());
                break;
        }
        return "OK";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/aceptarReporte.do")
    public @ResponseBody
    String aceptarReporte(int id, int status, int idDoc, Model model, HttpSession session, HttpServletRequest request)
    {
        Reportes reporte;
        fechas beanFecha = new fechas();
        reporte = reportesFacade.find(BigDecimal.valueOf(id));
        //Checar el estatus del reporte
        reporte.setStatus(BigInteger.ONE);
        reporte.setNumeroRevisiones(BigInteger.valueOf(reporte.getNumeroRevisiones().intValue() + 1));
        reportesFacade.edit(reporte);
        Documentos documento;
        documento = documentosFacade.find(BigDecimal.valueOf(idDoc));
        documento.setStatus((short) 1);
        documentosFacade.edit(documento);
        //validacion de las horas del servicio
        List<FormatoUnico> formatoUnicoAlumno = formatoUnicoFacade.findBySpecificField("datosPersonalesId", reporte.getDatosPersonalesId().getId(), "equal", null, null);
        FormatoUnico formatoAlumno = formatoUnicoAlumno.get(0);
        if (formatoAlumno.getIdproyecto().getIdInstancia().getTipoOrganizacion().getDetalle().equals("Gobierno Federal"))
        {
            if (formatoAlumno.getHorasAcumuladas().compareTo(BigInteger.valueOf(480)) == 0 || formatoAlumno.getHorasAcumuladas().compareTo(BigInteger.valueOf(480)) == 1)
            {
                formatoAlumno.setFechaEntregaFuf(beanFecha.covierteString(beanFecha.dameFechaFUF(reporte.getFechaFin())));
            }
        }
        if (formatoAlumno.getIdproyecto().getIdInstancia().getTipoOrganizacion().getDetalle().equals("Gobierno Municipal"))
        {
            if (formatoAlumno.getHorasAcumuladas().compareTo(BigInteger.valueOf(600)) == 0 || formatoAlumno.getHorasAcumuladas().compareTo(BigInteger.valueOf(600)) == 1)
            {
                formatoAlumno.setFechaEntregaFuf(beanFecha.covierteString(beanFecha.dameFechaFUF(reporte.getFechaFin())));
            }
        }
        String nombre = reporte.getDatosPersonalesId().getNombre() + " "
                + reporte.getDatosPersonalesId().getApellidoP() + " "
                + reporte.getDatosPersonalesId().getApellidoM();
        enviarCorreo(1, reporte.getDatosPersonalesId().getCorreoElectronico(), nombre, reporte.getDatosPersonalesId());
        return "ok";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/muestraReporteBimestralDoc.do")
    String muestraReporte(Model modelo, HttpSession session, HttpServletRequest request)
    {
        session.setAttribute("no_reporte", 2);
        session.setAttribute("id_reporte", 2);
        System.out.println("Agui genera el reporte");
        return "/ReporteBimestral/generaReporteBimestral";
    }

    @RequestMapping(value = "/guardarReporteBimestral.do", method = RequestMethod.POST)
    public String subirReporteBi(@RequestParam("file") MultipartFile file, Model modelo, HttpSession session, HttpServletRequest request) throws IOException
    {
        fechas manejadorFechas = new fechas();
        String no_control = session.getAttribute("NCONTROL").toString();
        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", no_control, "equal", null, null);
        if (vistaAlumnoFacade.count() < 1 || listaAlumnos.isEmpty())
        {
            System.out.println("O no hay registros en la tabla o no existe tal alumno en la base de datos de Vista LAumno");
            modelo.addAttribute("error", "Error al subir el Reporte Bimestral");
        }

        VistaAlumno alumno = listaAlumnos.get(0);
        List<DatosPersonales> listaDatosPersonales = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
        DatosPersonales datosPersonales = listaDatosPersonales.get(0);

        //Validacion para verificar los 2 años de servicio////
        List<FormatoUnico> formatosUnico = formatoUnicoFacade.findBySpecificField("datosPersonalesId", datosPersonales.getId(), "equal", null, null);
        FormatoUnico formatoActual = formatosUnico.get(0);
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(formatoActual.getFechaInicio());
        fecha.add(Calendar.YEAR, 2);
        Date fechaMaxima = manejadorFechas.covierteString(manejadorFechas.convierteDate(fecha.getTime()));
        Calendar fechaActual = Calendar.getInstance();
        Date fechaActualDate = manejadorFechas.covierteString(manejadorFechas.convierteDate(fechaActual.getTime()));
        if (!fechaActualDate.before(fechaMaxima))
        {
            formatoActual.setStatusServicio(BigInteger.valueOf(2));
            formatoUnicoFacade.edit(formatoActual);
            return "redirect:login.do";
        }
        ////////////////////////////////////
        LinkedHashMap ordenarAsc = new LinkedHashMap();
        ordenarAsc.put("id", "desc");
        List<Reportes> listReporte = reportesFacade.findBySpecificField("datosPersonalesId", datosPersonales, "equal", ordenarAsc, null);
        if (!listReporte.isEmpty())
        {
            Reportes reporte = listReporte.get(0);
            if (reporte.getStatus().compareTo(BigInteger.ONE) != 0)
            {
                reporte.setStatus(BigInteger.valueOf(4));
                reportesFacade.edit(reporte);
            } else
            {
                System.out.println("fail interno");
                return "redirect:formatoReporteBimestral.do?OK=false";
            }
        } else
        {
            System.out.println("fail");
            return "redirect:formatoReporteBimestral.do?OK=false";
        }

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
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("id", "desc");
        List<Documentos> ultimoDoc = documentosFacade.findBySpecificField("datosPersonalesId", datosPersonales.getId(), "equal", ordenamiento, null);
        if (!ultimoDoc.isEmpty())
        {
            Documentos ultimoDocumento = ultimoDoc.get(0);
            if (ultimoDocumento.getCatalogoDocumentosId().getId().compareTo(BigDecimal.valueOf(2)) == 0)
            {
                if (ultimoDocumento.getStatus() == 3)
                {
                    ultimoDocumento.setArchivo(file.getBytes());
                    ultimoDocumento.setDatosPersonalesId(datosPersonales);
                    String extension = file.getOriginalFilename();
                    //extension = getExtension(extension);
                    extension = extension.substring(extension.length() - 3, extension.length());
                    ultimoDocumento.setExtension(extension);
                    ultimoDocumento.setFechaSubida(new java.util.Date());
                    ultimoDocumento.setCatalogoDocumentosId(catalogoDocumento);
                    ultimoDocumento.setStatus((short) 4);
                    documentosFacade.edit(ultimoDocumento);
                    System.out.println("Documento Actualizado Correctamente");
                    try
                    {
                        documentosFacade.edit(ultimoDocumento);
                        remueveObservaciones(ultimoDocumento.getDatosPersonalesId().getId());
                        System.out.println("Se actualizo el documento con exito!");
                        return "redirect:panelUsuario.do";
                    } catch (Exception ex)
                    {
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
        //extension = getExtension(extension);
        extension = extension.substring(extension.length() - 3, extension.length());
        documento.setExtension(extension);
        documento.setFechaSubida(new java.util.Date());
        documento.setCatalogoDocumentosId(catalogoDocumento);
        documento.setStatus((short) 4);

        try
        {
            documentosFacade.create(documento);
            remueveObservaciones(datosPersonales.getId());
            System.out.println("Se subio el Docuemnto con éxito!");
        } catch (Exception ex)
        {
            modelo.addAttribute("error", "Error al subir el Reporte Bimestral");
            return "redirect:formatoReporteBimestral.do";
        }

//        List<Reportes> listReporte = reportesFacade.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
//        if (!listReporte.isEmpty()) {
//            Reportes reporte = listReporte.get(0);
//            reporte.setStatus(BigInteger.valueOf(4));
//            reportesFacade.edit(reporte);
//        } else {
//            modelo.addAttribute("errorSubir", "Error, Primero debe generar su reporte en la primera pestaña");
//            return "redirect:formatoReporteBimestral.do";
//        }
        //reporte.setDatosPersonalesId(datosPersonales);
        //##############   CAMBIA REPORTE A ESTATUS 4 
        //##############   REEDIRECCIONA  A PANEL USUARIO
        //##############   MANDAR MENSAJE DE ERROR
        return "redirect:panelUsuario.do";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/subirAlumnoReporteBimestral.do")
    String subirAlumnoReporteBimestral(@RequestParam String no_control, Model modelo)
    {
        modelo.addAttribute("no_control", no_control);
        return "/ReporteBimestral/subirAlumnoReporteBimestral";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/muestraReporteBimestral.pdf")
    public @ResponseBody
    String muestraReporteBimestral(Model modelo, String noReporte, String idReporte, HttpSession session, HttpServletRequest request, HttpServletResponse httpServletResponse) throws ParseException, JRException
    {

        Map parameters = new HashMap();
        parameters.put("no_control", session.getAttribute("NCONTROL").toString());
        parameters.put("no_reporte", noReporte);
        parameters.put("id_reporte", idReporte);
        try
        {
            GeneraDocumento obj = new GeneraDocumento();
            obj.generar("ges_vin", "gst05a", "plantilaReporteBimestral", parameters, request, httpServletResponse);
        } catch (Exception ex)
        {
            Exceptions.printStackTrace(ex);
        }
        return "OK";
    }

    public void remueveObservaciones(BigDecimal idDatosPersonales)
    {
        List<RegObservaciones> observacionesAlumno = regisObservacionesFacade.findBySpecificField("datosPersonalesId", idDatosPersonales, "equal", null, null);
        for (RegObservaciones observacionActual : observacionesAlumno)
        {
            regisObservacionesFacade.remove(observacionActual);
        }
    }

    public static String getExtension(String filename)
    {
        int index = filename.lastIndexOf('.');
        if (index == -1)
        {
            return "";
        } else
        {
            return filename.substring(index + 1);
        }
    }

    /**
     *
     * Metodo que se encarga de enviar notificacion al alumno en base a su correo
     *
     * @param tipo
     * @param correoDestinatario
     * @param nombre
     * @param dtp
     */
    private void enviarCorreo(int tipo, String correoDestinatario, String nombre, DatosPersonales dtp)
    {
        //Romper metodo en caso de que correo no se encuentre
        if (correoDestinatario == null)
        {
            return;
        }
//        } else if (banderaPrueba) {
//            correoDestinatario = correoTest;
//        }
        //En caso de que BanderaPrueba este activa se envia Correo al correo de Test

        String mensaje = " ";
        switch (tipo)
        {
            case 1://Aceptados
                mensaje = "<h1>Notificación Servicio Social</h1>\n"
                        + "<h2>Estimado  <b>" + nombre + "</b>:</h2> \n"
                        + "<p>\n"
                        + "Te informamos que  tu Reporte Bimestral que has llenado, fue revisado por la Oficina de Servicio Social  y ha sido <b>Aceptado</b> Satisfactoriamente. \n"
                        + "</p>\n"
                        + "<p>Por lo que te recordamos, que puedes proseguir con tu proceso. \n"
                        + "</p>\n"
                        + "<p>\n"
                        + "Oficina de Servicio Social<br> \n"
                        + "Instituto Tecnológico  de Toluca\n"
                        + "</p>";
                break;
            case 2://Correccion
                String mns1 = "<h1>Notificación Servicio Social</h1>\n"
                        + "<h2>Estimado  <b>" + nombre + "</b>:</h2> \n"
                        + "<p>\n"
                        + "Te informamos que   tu  Reporte Bimestral que has llenado, ha sido revisado por la Oficina de Servicio Social  y este tiene errores.  Favor de corregirlos lo más pronto posible.\n"
                        + "</p>\n"
                        + "<ul>\n";
                mensaje += mns1;

                for (RegObservaciones reg : regisObservacionesFacade.findBySpecificField("datosPersonalesId",
                        dtp,
                        "equal", null, null))
                {

                    String detalle = reg.getCatalogoObservacionId().getDetalle();
                    mensaje += "<li>" + detalle + "</li>\n";
                }

                String mns2
                        = "</ul>\n"
                        + "<p>\n"
                        + "Oficina de Servicio Social <br>\n"
                        + "Instituto Tecnológico  de Toluca\n"
                        + "</p>";
                mensaje += mns2;
                break;
            case 3://No aceptados
                mensaje = "<h1>Notificación Servicio Social</h1>\n"
                        + "<h2>Estimado  <b>" + nombre + "</b>:</h2> \n"
                        + "<p>\n"
                        + "Te informamos que   tu  Reporte Bimestral que has llenado, fue revisado por la Oficina de Servicio Social  y este ha sido <b>Rechazado</b>.\n"
                        + "</p>\n"
                        + "<p>\n"
                        + "Si esto ha sucedido, es porque has rebasado el número de intentos  para corregir tu Reporte Bimestral.  Para mayor información  presentarse en la Oficina de Servicio Social o intentar de  nuevo para la siguiente convocatoria.  \n"
                        + "</p>\n"
                        + "<p>\n"
                        + "Oficina de Servicio Social <br>\n"
                        + "Instituto Tecnológico  de Toluca\n"
                        + "</p>";
                break;
            default:
                return;
        }

        Thread hiloCorreo = new Thread(new EnviarCorreo(nombre, correoDestinatario, mensaje));
        hiloCorreo.start();

    }
//    class OrdenarPorId implements Comparator<Reportes> {
//
//    public int compare(Reportes o1, Reportes o2) {
//        return Integer.valueOf(String.valueOf(o1.getId())) - Integer.valueOf(String.valueOf(o2.getId()));
//    }
//}
}
