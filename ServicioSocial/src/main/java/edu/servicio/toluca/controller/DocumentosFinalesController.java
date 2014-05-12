/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.DocumentosFinalesBean;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.beans.documentosFinales.RetroalimentacionDocumentosFinales;
import edu.servicio.toluca.entidades.CatalogoDocumento;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.Documentos;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.entidades.RegObservaciones;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.CatalogoDocumentoFacade;
import edu.servicio.toluca.sesion.CatalogoObservacionesFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.DocumentosFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.RegObservacionesFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
public class DocumentosFinalesController {

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
    @EJB(mappedName = "java:global/ServicioSocial/CatalogoObservacionesFacade")
    private CatalogoObservacionesFacade observacionesCatalogoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/RegObservacionesFacade")
    private RegObservacionesFacade regObservacionesFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/documentosFinales.do")
    public String administradorDocumentosFinales(Model model) {
        List<Documentos> listaDocum;//=documentosFacade.findBySpecificField("status", "1", "equal", null, null);
        List<DocumentosFinalesBean> alumnosDocumentos = new ArrayList<DocumentosFinalesBean>();
        DocumentosFinalesBean nuevoAlumno;
        List<FormatoUnico> fu = formatoUnicoFacade.findAll();
        for (int i = 0; i < fu.size(); i++) {
            if (fu.get(i).getHorasAcumuladas().intValue() >= 480) {
                listaDocum = documentosFacade.findBySpecificField("datosPersonalesId", fu.get(i).getDatosPersonalesId(), "equal", null, null);
                System.out.println("No Control: " + fu.get(i).getDatosPersonalesId().getAlumnoId().getId());
                System.out.println("Nombre: " + fu.get(i).getDatosPersonalesId().getNombre());
                nuevoAlumno = new DocumentosFinalesBean();
                for (int j = 0; j < listaDocum.size(); j++) {
                    if ("Constancia_Pago".equals(listaDocum.get(j).getCatalogoDocumentosId().getTipo())) {
                        nuevoAlumno.setIdConstanciaPago(listaDocum.get(j).getId().intValue());
                        nuevoAlumno.setStatusCP(listaDocum.get(j).getStatus());
                    } else if ("Reporte_Evaluacion".equals(listaDocum.get(j).getCatalogoDocumentosId().getTipo())) {
                        nuevoAlumno.setIdReporteCalificacion(listaDocum.get(j).getId().intValue());
                        nuevoAlumno.setStatusRC(listaDocum.get(j).getStatus());
                    } else if ("Reporte_Final".equals(listaDocum.get(j).getCatalogoDocumentosId().getTipo())) {
                        nuevoAlumno.setIdReporteFinal(listaDocum.get(j).getId().intValue());
                        nuevoAlumno.setStatusRF(listaDocum.get(j).getStatus());
                    } else if ("Formato_Unico_Final".equals(listaDocum.get(j).getCatalogoDocumentosId().getTipo())) {
                        nuevoAlumno.setIdFormatoUnicoFinal(listaDocum.get(j).getId().intValue());
                        nuevoAlumno.setStatusFUF(listaDocum.get(j).getStatus());
                    }
                }
                if (nuevoAlumno.getIdConstanciaPago() != 0 || nuevoAlumno.getIdFormatoUnicoFinal() != 0 || nuevoAlumno.getIdReporteFinal() != 0 || nuevoAlumno.getIdReporteCalificacion() != 0) {
                    nuevoAlumno.setIdDatosPer(fu.get(i).getDatosPersonalesId().getId().intValue());
                    nuevoAlumno.setNoControl(fu.get(i).getDatosPersonalesId().getAlumnoId().getId());
                    nuevoAlumno.setNombreCompleto(fu.get(i).getDatosPersonalesId().getNombre() + " " + fu.get(i).getDatosPersonalesId().getApellidoP() + " " + fu.get(i).getDatosPersonalesId().getApellidoM());
                    nuevoAlumno.setCorreo(fu.get(i).getDatosPersonalesId().getCorreoElectronico());
                    alumnosDocumentos.add(nuevoAlumno);
                }
                System.out.println("***********aqui agregaria un nuevo alumno a la lista -- " + fu.get(i).getDatosPersonalesId().getNombre());
            }
        }

        model.addAttribute("documentosAlumno", alumnosDocumentos);
        model.addAttribute("listadoObservaciones", observacionesCatalogoFacade.findAll()); 
        return "/DocumentosFinales/administrarDocumentosFinales";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/documentosFinalesAlumno.do")
    public String documentosFinalesAlumno(Model model, HttpSession session, HttpServletRequest request) {

        if (new ValidaSesion().validaAlumno(session, request)) {
            String no_control = session.getAttribute("NCONTROL").toString();
            //String no_control = "09280525";

            VistaAlumno alumno = vistaAlumnoFacade.find(no_control);

            List<DatosPersonales> listaDatosPersonales = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
            DatosPersonales datosPersonales = listaDatosPersonales.get(0);

            List<FormatoUnico> listaFormatoUnico = formatoUnicoFacade.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
            FormatoUnico formatoUnicoAlumno = listaFormatoUnico.get(0);

            System.out.println("Vista alumno: " + alumno.getId() + "\tDatos personales: " + datosPersonales.getId() + "\tFormato unico: " + formatoUnicoAlumno.getId() + "\tcon plan de: " + formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
            regresaInputDocumentos(formatoUnicoAlumno, model);
            model.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
            model.addAttribute("no_control", no_control);
            return "/DocumentosFinales/documentosFinalesAlumno";
        } else {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesió para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/aceptarDocumentos.do")
    public @ResponseBody
    String aceptarReporte(int id, int status, Model model, HttpSession session, HttpServletRequest request) {
        Documentos documento;
        documento = documentosFacade.find(BigDecimal.valueOf(id));
        documento.setStatus((short) 1);
        documentosFacade.edit(documento);
        System.out.println("Reporte Alterado con Status a: " + status);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rechazaDocumentos.do")
    public @ResponseBody
    String rechazaReporte(@RequestParam(value = "observaciones[]", required = false) String[] observaciones,
                                int id,int status,String no_control, Model model, HttpSession session, HttpServletRequest request) 
    {        
        System.out.println("El numero de control es: "+no_control);
        
        List<DatosPersonales> listaAlumnos = datosPersonalesFacade.findBySpecificField("alumnoId", no_control, "equal", null, null);
        if (listaAlumnos.isEmpty()) {
            return "okkk";
        }
        
        for (String idObservacion : observaciones) {
            //Objeto a Registrar
            RegObservaciones registro = new RegObservaciones();
            //Buscar Objeto Pertenciente al CatalogoObservaciones con el id recibido y asignarlo
            registro.setCatalogoObservacionId(observacionesCatalogoFacade.find(BigDecimal.valueOf(Long.valueOf(idObservacion))));
            //Buscar Objeto Pertenciente a la Tabla de DatosPersonales con el id recibido y asignarlo
            registro.setDatosPersonalesId(datosPersonalesFacade.find(listaAlumnos.get(0).getId()));
            //Asignar Fecha Actual al momento para registro 
            registro.setFecha(new Date());
            //Creacion de Registro
            regObservacionesFacade.create(registro);
        }
        System.out.println("Ya ingreso las observaciones");
        System.out.println("El estatus que recibio es: "+BigInteger.valueOf(status));
        Documentos documentos;
        documentos = documentosFacade.find(BigDecimal.valueOf(id));
        documentos.setStatus((short)status);
        //documentosFacade.edit(documentos);
        System.out.println("Ya actualizo");
        return "ok";
    }

    public void regresaInputDocumentos(FormatoUnico fu, Model model) {
        boolean siCP = false, siRF = false, siFUF = false, siRE = false;
        List<Documentos> listaDocument;
        listaDocument = documentosFacade.findBySpecificField("datosPersonalesId", fu.getDatosPersonalesId(), "equal", null, null);
        for (int j = 0; j < listaDocument.size(); j++) {
            if ("Constancia_Pago".equals(listaDocument.get(j).getCatalogoDocumentosId().getTipo())) {
                if (listaDocument.get(j).getStatus().intValue() == 4 || listaDocument.get(j).getStatus().intValue() == 1) {
                    siCP = true;
                }
            }
            if ("Reporte_Final".equals(listaDocument.get(j).getCatalogoDocumentosId().getTipo())) {
                if (listaDocument.get(j).getStatus().intValue() == 4 || listaDocument.get(j).getStatus().intValue() == 1) {
                    siRF = true;
                }
            }
            if ("Formato_Unico_Final".equals(listaDocument.get(j).getCatalogoDocumentosId().getTipo())) {
                if (listaDocument.get(j).getStatus().intValue() == 4 || listaDocument.get(j).getStatus().intValue() == 1) {
                    siFUF = true;
                }
            }
            if ("Reporte_Evaluacion".equals(listaDocument.get(j).getCatalogoDocumentosId().getTipo())) {
                if (listaDocument.get(j).getStatus().intValue() == 4 || listaDocument.get(j).getStatus().intValue() == 1) {
                    siRE = true;
                }
            }
        }
        if (!siCP) {
            model.addAttribute("muestraCP", "<tr>\n<td>Constancia de Pago</td>\n<td>\n<input type='file'  name ='fileCP' value='Buscar en mi equipo'/> <br/></td></tr>");
        }
        if (!siRF) {
            model.addAttribute("muestraRF", "<tr>\n<td>Reporte Final</td>\n<td>\n<input type='file'  name ='fileRF' value='Buscar en mi equipo'/> <br/></td></tr>");
        }
        if (!siFUF) {
            model.addAttribute("muestraFUF", "<tr>\n<td>Formato Unico Final</td>\n<td>\n<input type='file'  name ='fileFUF' value='Buscar en mi equipo'/> <br/></td></tr>");
        }
        if (!siRE) {
            model.addAttribute("muestraRE", "<tr><td>Reporte de Evaluación</td><td><input type='file'  name ='fileRE' value='Buscar en mi equipo'/> <br/></td></tr>");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/guardarDocumentosFinalesAux.do")
    public String guardarDocumentosFinalesAux(
            MultipartFile fileFUF,
            MultipartFile fileCP,
            MultipartFile fileRF,
            MultipartFile fileRE, String no_control, Model modelo) throws IOException//),HttpSession session, HttpServletRequest request) throws IOException 
    {
        //String no_control = session.getAttribute("NCONTROL").toString(); //@RequestParam("fileRP") MultipartFile fileRP,
        //String no_control = "09280531";
        System.out.println("Inicia Subir Documentoa Finales");
        System.out.println("El no control del alumno es->" + no_control);

        VistaAlumno alumno = vistaAlumnoFacade.find(no_control);
        if (alumno.getId() == null || "".equals(alumno.getId())) {
            System.out.println("O no hay registros en la tabla o no existe tal alumno en la base de datos de Vista LAumno");
            modelo.addAttribute("error", "Error al subir el Reporte Bimestral");
        }

        List<DatosPersonales> listaDatosPersonales = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
        DatosPersonales datosPersonales = listaDatosPersonales.get(0);

        List<FormatoUnico> listaFormatoUnico = formatoUnicoFacade.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
        FormatoUnico formatoUnicoAlumno = listaFormatoUnico.get(0);

        List<CatalogoDocumento> listaCatalogoDocumento;
        CatalogoDocumento catalogoDocumento;
        String extension;
        Documentos documentoFUF;
        Documentos documentoCP;
        Documentos documentoRF;
        Documentos documentoRE;

        //** Inicia Validación si el FUF, CP o RF es vacio **//
        if (fileFUF != null) {
            if (!"".equals(fileFUF.getOriginalFilename())) {
                System.out.println("Crea el objeto Docuemento FUF");
                listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Formato_Unico_Final", "equal", null, null);
                catalogoDocumento = listaCatalogoDocumento.get(0);
                int idDocumento = buscaDocumento(formatoUnicoAlumno, "Formato_Unico_Final");
                System.out.println("el id del documento anterior es " + idDocumento);
                if (idDocumento == -1) {
                    documentoFUF = new Documentos();
                } else {
                    documentoFUF = documentosFacade.find(BigDecimal.valueOf(idDocumento));
                }
                documentoFUF.setArchivo(fileFUF.getBytes());
                documentoFUF.setDatosPersonalesId(datosPersonales);
                extension = fileFUF.getOriginalFilename();
                extension = extension.substring(extension.length() - 3, extension.length());
                documentoFUF.setExtension(extension);
                documentoFUF.setFechaSubida(new java.util.Date());
                documentoFUF.setStatus((short) 4);
                documentoFUF.setCatalogoDocumentosId(catalogoDocumento);
                System.out.println(extension);
                if (!"pdf".equals(extension)) //** Verifica que la extenxion del archivo FUF sea PDF
                {
                    modelo.addAttribute("error_fuf", "<div class='error'>Error al subir el Formato Único Final. Tipo de archivo incorrecto.</div>");
                    regresaInputDocumentos(formatoUnicoAlumno, modelo);
                    modelo.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
                    modelo.addAttribute("no_control", no_control);
                    return "/DocumentosFinales/documentosFinalesAlumno";
                }
                try {
                    formatoUnicoAlumno.setStatusFuf(BigInteger.valueOf(3));
                    formatoUnicoFacade.edit(formatoUnicoAlumno);
                    documentosFacade.edit(documentoFUF);
                } catch (Exception ex) {
                    modelo.addAttribute("error", "<p>Error al subir el Formato Unico Final</p>");
                    System.out.println("ERROR: al subir el Docuemnto! **** Java dice: " + ex);
                    return "/DocumentosFinales/documentosFinalesAlumno";
                }
            }
        }
        if (fileCP != null) {
            if (!"".equals(fileCP.getOriginalFilename())) {
                System.out.println("Crea el objeto Docuemento CP");
                listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Constancia_Pago", "equal", null, null);
                catalogoDocumento = listaCatalogoDocumento.get(0);
                int idDocumento = buscaDocumento(formatoUnicoAlumno, "Constancia_Pago");
                System.out.println("el id del documento anterior es " + idDocumento);
                if (idDocumento == -1) {
                    documentoCP = new Documentos();
                } else {
                    documentoCP = documentosFacade.find(BigDecimal.valueOf(idDocumento));
                }
                documentoCP.setArchivo(fileCP.getBytes());
                documentoCP.setDatosPersonalesId(datosPersonales);
                extension = fileCP.getOriginalFilename();
                extension = extension.substring(extension.length() - 3, extension.length());
                documentoCP.setExtension(extension);
                documentoCP.setFechaSubida(new java.util.Date());
                documentoCP.setStatus((short) 4);
                documentoCP.setCatalogoDocumentosId(catalogoDocumento);
                System.out.println(extension);
                if (!"pdf".equals(extension)) //** Verifica que la extenxion del archivo CP sea PDF
                {
                    modelo.addAttribute("error_cp", "<div class='error'>Erro al subir la Constancia de Pago. Tipo de archivo incorrecto.</div>");
                    regresaInputDocumentos(formatoUnicoAlumno, modelo);
                    modelo.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
                    modelo.addAttribute("no_control", no_control);
                    return "/DocumentosFinales/documentosFinalesAlumno";
                }
                try {
                    formatoUnicoAlumno.setStatusFuf(BigInteger.valueOf(3));
                    formatoUnicoFacade.edit(formatoUnicoAlumno);
                    documentosFacade.edit(documentoCP);
                } catch (Exception ex) {
                    modelo.addAttribute("error", "<p>Error al subir la Constancia de Pago</p>");
                    System.out.println("ERROR: al subir el Docuemnto! **** Java dice: " + ex);
                    return "/DocumentosFinales/documentosFinalesAlumno";
                }
            }
        }
        if (fileRF != null) {
            if (!"".equals(fileRF.getOriginalFilename())) {
                System.out.println("Crea el objeto Docuemento RF");
                listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Reporte_Final", "equal", null, null);
                catalogoDocumento = listaCatalogoDocumento.get(0);
                int idDocumento = buscaDocumento(formatoUnicoAlumno, "Reporte_Final");
                System.out.println("el id del documento anterior es " + idDocumento);
                if (idDocumento == -1) {
                    documentoRF = new Documentos();
                } else {
                    documentoRF = documentosFacade.find(BigDecimal.valueOf(idDocumento));
                }
                documentoRF.setArchivo(fileRF.getBytes());
                documentoRF.setDatosPersonalesId(datosPersonales);
                extension = fileRF.getOriginalFilename();
                extension = extension.substring(extension.length() - 3, extension.length());
                documentoRF.setExtension(extension);
                documentoRF.setFechaSubida(new java.util.Date());
                documentoRF.setStatus((short) 4);
                documentoRF.setCatalogoDocumentosId(catalogoDocumento);
                System.out.println(extension);
                if (!"pdf".equals(extension)) //** Verifica que la extenxion del archivo RF sea PDF
                {
                    modelo.addAttribute("error_fr", "<div class='error'>Error al subir el Reporte Final. Tipo de archivo incorrecto</div>");
                    regresaInputDocumentos(formatoUnicoAlumno, modelo);
                    modelo.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
                    modelo.addAttribute("no_control", no_control);
                    return "/DocumentosFinales/documentosFinalesAlumno";
                }
                try {
                    formatoUnicoAlumno.setStatusFuf(BigInteger.valueOf(3));
                    formatoUnicoFacade.edit(formatoUnicoAlumno);
                    documentosFacade.edit(documentoRF);
                } catch (Exception ex) {
                    modelo.addAttribute("error", "<p>Error al subir el Reporte Final</p>");
                    System.out.println("ERROR: al subir el Docuemnto! **** Java dice: " + ex);
                    return "/DocumentosFinales/documentosFinalesAlumno";
                }
            }
        }
        if (fileRE != null) {
            if ("S".equals(formatoUnicoAlumno.getCatalogoPlanId().getDetalle())) //Cuando es reticula 2009
            {
                if (!"".equals(fileRE.getOriginalFilename())) {
                    listaCatalogoDocumento = catalogoDocumentoFacade.findBySpecificField("tipo", "Reporte_Evaluacion", "equal", null, null);
                    catalogoDocumento = listaCatalogoDocumento.get(0);
                    int idDocumento = buscaDocumento(formatoUnicoAlumno, "Reporte_Evaluacion");
                    System.out.println("el id del documento anterior es " + idDocumento);
                    if (idDocumento == -1) {
                        documentoRE = new Documentos();
                    } else {
                        documentoRE = documentosFacade.find(BigDecimal.valueOf(idDocumento));
                    }
                    documentoRE.setArchivo(fileRE.getBytes());
                    documentoRE.setDatosPersonalesId(datosPersonales);
                    extension = fileRE.getOriginalFilename();
                    extension = extension.substring(extension.length() - 3, extension.length());
                    documentoRE.setExtension(extension);
                    documentoRE.setFechaSubida(new java.util.Date());
                    documentoRE.setStatus((short) 4);
                    documentoRE.setCatalogoDocumentosId(catalogoDocumento);
                    if (!"pdf".equals(extension)) //** Verifica que la extenxion del archivo RF sea PDF
                    {
                        modelo.addAttribute("error_fe", "<div class='error'>Error al subir el Reporte de Evaluación. Tipo de archivo incorrecto</div>");
                        regresaInputDocumentos(formatoUnicoAlumno, modelo);
                        modelo.addAttribute("planAlumno", formatoUnicoAlumno.getCatalogoPlanId().getDetalle());
                        modelo.addAttribute("no_control", no_control);
                        return "/DocumentosFinales/documentosFinalesAlumno";
                    }
                    try {
                        formatoUnicoAlumno.setStatusFuf(BigInteger.valueOf(3));
                        formatoUnicoFacade.edit(formatoUnicoAlumno);
                        documentosFacade.edit(documentoRE);
                    } catch (Exception ex) {
                        modelo.addAttribute("error", "<p>Error al subir el Reporte de Evaluación</p>");
                        System.out.println("ERROR: al subir el Docuemnto! **** Java dice: " + ex);
                        return "/DocumentosFinales/documentosFinalesAlumno";
                    }
                }
            }
        }
        
        return "redirect:panelUsuario.do";
    }

    public int buscaDocumento(FormatoUnico formatoUnicoAlumno, String documento) {
        int idDocumen = -1;
        List<Documentos> listDocumentoXAlumno;
        listDocumentoXAlumno = documentosFacade.findBySpecificField("datosPersonalesId", formatoUnicoAlumno.getDatosPersonalesId(), "equal", null, null);
        for (int j = 0; j < listDocumentoXAlumno.size(); j++) {
            if (documento.equals(listDocumentoXAlumno.get(j).getCatalogoDocumentosId().getTipo())) {
                idDocumen = listDocumentoXAlumno.get(j).getId().intValue();
                break;
            }
        }
        return idDocumen;
    }
}
