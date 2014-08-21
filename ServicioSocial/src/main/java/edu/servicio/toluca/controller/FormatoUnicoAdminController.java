/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.EnviarCorreo;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.beans.formatoUnico.FormatoUnicoBean;
import edu.servicio.toluca.entidades.CatalogoObservaciones;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.Documentos;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.RegObservaciones;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.model.formatoUnico.FormatoUnicoAdminModel;
import edu.servicio.toluca.sesion.CatalogoObservacionesFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.DocumentosFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.RegObservacionesFacade;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
 * @author WindSaber
 */
@Controller
public class FormatoUnicoAdminController
{

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
    //Status de FormatoUnico FUI en  base al documento status_DOC_1.doc
    final int VALOR_NO_REVISADOS = 4;
    final int VALOR_ACEPTADOS = 1;
    final int VALOR_RECHAZADOS = 2;
    final int VALOR_CORRECCION = 3;
    //ID CatalogoDocumentos FormatoUnico
    final long DOC_CAT_FU = 1;
    //Pruebas Developer
    //**********************************************
    //Desactivar para Produccion, Activar para Desarrollo
    final boolean banderaPrueba = false;
    final String correoTest = "rehoscript@gmail.com";
    //**********************************************
    private FormatoUnicoAdminModel modeloFormatoUnico = new FormatoUnicoAdminModel(observacionesCatalogoFacade,
            formatoUnicoFacade,
            documentoFacade,
            datosPersonalesFacade,
            regisObservacionesFacade);

    @RequestMapping(method = RequestMethod.GET, value = "/formatoUnicoAdministrador.do")
    public String formatoUnicoAdministrador(Model model, HttpSession session, HttpServletRequest request)
    {

        ValidaSesion valSession = new ValidaSesion(session, request);
        if (valSession.accesaPanelAdministrador())
        {
            System.out.println("entro");
            long time_start,
                    time_end;
            time_start = System.currentTimeMillis();
            //Listas de Formato Unico en los diferentes Status
            List<FormatoUnicoBean> listadoFormatosNoRevisados = new ArrayList<FormatoUnicoBean>();
            List<FormatoUnicoBean> listadoFormatosAceptados = new ArrayList<FormatoUnicoBean>();
            List<FormatoUnicoBean> listadoFormatosRechazados = new ArrayList<FormatoUnicoBean>();
            List<FormatoUnicoBean> listadoFormatosCorreccion = new ArrayList<FormatoUnicoBean>();

            for (FormatoUnico formato : formatoUnicoFacade.findAll())
            {

                //------------------Formatos No Revisados------------------------
                if (formato.getStatusFui() != null
                        && formato.getStatusFui().equals(BigInteger.valueOf(VALOR_NO_REVISADOS)))
                {
                    //Asignando Datos A Formato Unico en estado NO_REVISADO
                    FormatoUnicoBean formatoNR = new FormatoUnicoBean();
                    formatoNR.setIdFormatoUnico(formato.getId().toString());
                    formatoNR.setNoControl(formato.getDatosPersonalesId().getAlumnoId().getId());
                    formatoNR.setNombre(formato.getDatosPersonalesId().getNombre()
                            + " " + formato.getDatosPersonalesId().getApellidoP()
                            + " " + formato.getDatosPersonalesId().getApellidoM());
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
                    if (fechaSubida != null)
                    {
                        /*
                         * Si es diferente de null, el documento de FormatoUnico se encuentra en la tabla de Documentos
                         */
                        formatoNR.setFechaSubida(fechaSubida);
                        String idDocumento = obtenerIDDocumentoFormatoU(listaDocumentos);

                        if (idDocumento != null)
                        {
                            formatoNR.setIdDocumentoFormatoUnico(idDocumento);
                            //Se Agrega El Objeto FormatoUnico a la lista de FomatoUnicos en estado NO_REVISADOS
                            listadoFormatosNoRevisados.add(formatoNR);
                        }

                    }
                }
                //------------------Formatos Aceptados------------------------    
                if (formato.getStatusFui() != null && formato.getStatusFui().equals(BigInteger.valueOf(VALOR_ACEPTADOS)))//
                {
                    FormatoUnicoBean formatoAceptados = new FormatoUnicoBean();

                    formatoAceptados.setNoControl(formato.getDatosPersonalesId().getAlumnoId().getId());
                    formatoAceptados.setNombre(formato.getDatosPersonalesId().getNombre()
                            + " " + formato.getDatosPersonalesId().getApellidoP()
                            + " " + formato.getDatosPersonalesId().getApellidoM());
                    formatoAceptados.setPeriodo(formato.getPeriodoInicio());
                    List<Documentos> listaDocumentos2 = documentoFacade.findBySpecificField("datosPersonalesId",
                            formato.getDatosPersonalesId(),
                            "equal", null, null);

                    String fechaSubida = obtenerFechaSubidaFormatoU(listaDocumentos2);
                    if (fechaSubida != null)
                    {
                        String idDocumento = obtenerIDDocumentoFormatoU(listaDocumentos2);
                        formatoAceptados.setFechaSubida(fechaSubida);
                        if (idDocumento != null)
                        {
                            formatoAceptados.setIdDocumentoFormatoUnico(idDocumento);
                            listadoFormatosAceptados.add(formatoAceptados);
                        }
                    }
                }
                //------------------Formatos Rechazados------------------------   
                if (formato.getStatusFui() != null && formato.getStatusFui().equals(BigInteger.valueOf(VALOR_RECHAZADOS)))//
                {
                    FormatoUnicoBean formatoRechazados = new FormatoUnicoBean();
                    formatoRechazados.setNoControl(formato.getDatosPersonalesId().getAlumnoId().getId());
                    formatoRechazados.setNombre(formato.getDatosPersonalesId().getNombre()
                            + " " + formato.getDatosPersonalesId().getApellidoP()
                            + " " + formato.getDatosPersonalesId().getApellidoM());
                    formatoRechazados.setPeriodo(formato.getPeriodoInicio());
                    formatoRechazados.setIdDatosPersonales(formato.getDatosPersonalesId().getId().toString());
                    List<Documentos> listaDocumentos3 = documentoFacade.findBySpecificField("datosPersonalesId",
                            formato.getDatosPersonalesId(),
                            "equal", null, null);

                    String fechaSubida = obtenerFechaSubidaFormatoU(listaDocumentos3);
                    if (fechaSubida != null)
                    {
                        String idDocumento = obtenerIDDocumentoFormatoU(listaDocumentos3);
                        formatoRechazados.setFechaSubida(fechaSubida);
                        if (idDocumento != null)
                        {
                            formatoRechazados.setIdDocumentoFormatoUnico(idDocumento);
                            listadoFormatosRechazados.add(formatoRechazados);
                        }
                    }
                }
                //------------------//Formatos Correccion-----------------------   
                if (formato.getStatusFui() != null && formato.getStatusFui().equals(BigInteger.valueOf(VALOR_CORRECCION)))
                {
                    FormatoUnicoBean formatoCorreccion = new FormatoUnicoBean();
                    formatoCorreccion.setNoControl(formato.getDatosPersonalesId().getAlumnoId().getId());
                    formatoCorreccion.setNombre(formato.getDatosPersonalesId().getNombre()
                            + " " + formato.getDatosPersonalesId().getApellidoP()
                            + " " + formato.getDatosPersonalesId().getApellidoM());
                    formatoCorreccion.setPeriodo(formato.getPeriodoInicio());
                    formatoCorreccion.setIdDatosPersonales(formato.getDatosPersonalesId().getId().toString());
                    List<Documentos> listaDocumentos4 = documentoFacade.findBySpecificField("datosPersonalesId",
                            formato.getDatosPersonalesId(),
                            "equal", null, null);

                    String fechaSubida = obtenerFechaSubidaFormatoU(listaDocumentos4);

                    if (fechaSubida != null)
                    {
                        String idDocumento = obtenerIDDocumentoFormatoU(listaDocumentos4);
                        formatoCorreccion.setFechaSubida(fechaSubida);
                        if (idDocumento != null)
                        {
                            formatoCorreccion.setIdDocumentoFormatoUnico(idDocumento);
                            listadoFormatosCorreccion.add(formatoCorreccion);
                        }

                    }
                }
            }

            //Formatos Unicos No Revisados 
            model.addAttribute("listadoFormatoUnicoNORevisados", listadoFormatosNoRevisados);
            //Formato Unico Aceptados
            model.addAttribute("listadoFormatoUnicoAceptados", listadoFormatosAceptados);
            //Formato Rechazados
            model.addAttribute("listadoFormatoUnicoRechazados", listadoFormatosRechazados);
            //Formato Correccion
            model.addAttribute("listadoFormatoUnicoCorreccion", listadoFormatosCorreccion);
            //Catalogo Sanciones
            List<CatalogoObservaciones> observaciones = observacionesCatalogoFacade.findAll();
            List<CatalogoObservaciones> observacionesBimestrales = new ArrayList();
            for (CatalogoObservaciones observacionActual : observaciones)
            {
                if (observacionActual.getTipo().compareTo(BigInteger.valueOf(1)) == 0)
                {
                    observacionesBimestrales.add(observacionActual);
                }
            }
            model.addAttribute("listadoObservaciones", observacionesBimestrales);

            time_end = System.currentTimeMillis();
            System.out.println("Tiempo: " + (time_end - time_start));
            return "/FormatoUnico/formatoUnicoAdministrador";
        } else
        {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/modificarFormatoUnicoNR_Aceptado.do")
    public @ResponseBody
    String modificarFU_NR_Aceptados(String id)
    {
        //Obtener FormatoUnico en especifico 

        FormatoUnico fA = formatoUnicoFacade.find(BigDecimal.valueOf(Long.valueOf(id)));
        //Se encontro el Objeto
        if (fA != null)
        {
            //Cambiar Estado de NO_ACEPTADO A ACEPTADO
            fA.setStatusFui(BigInteger.valueOf(VALOR_ACEPTADOS));
            formatoUnicoFacade.edit(fA);

            String nombre = fA.getDatosPersonalesId().getNombre() + " "
                    + fA.getDatosPersonalesId().getApellidoP() + " "
                    + fA.getDatosPersonalesId().getApellidoM();
            enviarCorreo(1, fA.getDatosPersonalesId().getCorreoElectronico(), nombre, null);
        }

        return "OK";
    }

    /**
     * @see variable tipo indica que tipo de cambio de status realizara si es 1 cambiara de NO_REVISADO a CORRECCION si
     * es 2 cambiara de NO_REVISADO a RECHAZO variable observaciones es un array de id's de Observaciones en Base al
     * Catalogo Observaciones
     *
     * @param observaciones
     * @param idDatoPersonales
     * @param idFormatoUnico
     * @param tipo
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/modificarFormatoUnicoNR.do")
    public @ResponseBody
    String modificarFormatoUnico(@RequestParam(value = "observaciones[]", required = false) String[] observaciones,
            String idDatoPersonales,
            String idFormatoUnico,
            String tipo)
    {
        System.out.println("Entro a modificar el status del formato unico");
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
        System.out.println("Ya ingreso las observaciones");
        System.out.println("Inicia la modificación... tipo: " + tipo + " idDatosPersonales: " + idDatoPersonales + " idFormatoUnico: " + idFormatoUnico);
        String nombre = " ";
        switch (Integer.parseInt(tipo))
        {
            case 1://Correccion
                //Buscar Formato Unico
                FormatoUnico fu = formatoUnicoFacade.find(BigDecimal.valueOf(Long.valueOf(idFormatoUnico)));
                //Cambiar Status 
                fu.setStatusFui(BigInteger.valueOf(VALOR_CORRECCION));
                formatoUnicoFacade.edit(fu);
                //Enviar Correo
                nombre = fu.getDatosPersonalesId().getNombre() + " "
                        + fu.getDatosPersonalesId().getApellidoP() + " "
                        + fu.getDatosPersonalesId().getApellidoM();

                enviarCorreo(2, fu.getDatosPersonalesId().getCorreoElectronico(), nombre, fu.getDatosPersonalesId());
                break;
            case 2://Rechazo
                //Buscar Formato Unico
                FormatoUnico fuR = formatoUnicoFacade.find(BigDecimal.valueOf(Long.valueOf(idFormatoUnico)));
                //Cambiar Status
                fuR.setStatusFui(BigInteger.valueOf(VALOR_RECHAZADOS));
                fuR.setStatusServicio(BigInteger.valueOf(VALOR_RECHAZADOS));
                formatoUnicoFacade.edit(fuR);
                //Enviar Correo
                nombre = fuR.getDatosPersonalesId().getNombre() + " "
                        + fuR.getDatosPersonalesId().getApellidoP() + " "
                        + fuR.getDatosPersonalesId().getApellidoM();
                enviarCorreo(3, fuR.getDatosPersonalesId().getCorreoElectronico(), nombre, fuR.getDatosPersonalesId());
                break;
        }
        System.out.println("fui modificado");

        return "OK";
    }

    @RequestMapping(value = "/mostarPDF.do", method = RequestMethod.GET)
    @ResponseBody
    public void showPDF(String id, HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException
    {
        //Buscar el Documento en base al ID
        Documentos doc = documentoFacade.find(BigDecimal.valueOf(Long.parseLong(id)));

        if (doc != null)
        {
            if (doc.getExtension().equals("pdf"))
            {//El Documento es PDF
                httpServletResponse.setContentType("application/pdf");
            } else if (doc.getExtension().equals("jpg") || doc.getExtension().equals("png") || doc.getExtension().equals("jpeg"))
            {//Es imagen
                httpServletResponse.setContentType("image/jpg");
            } else
            {
                return;
            }
            byte[] documentoBLOB = doc.getArchivo();
            httpServletResponse.getOutputStream().write(documentoBLOB);
        }
    }

    @RequestMapping(value = "/mostarObservacion.do", method = RequestMethod.GET)
    public String mostrarObservacion(String idDatosPersonales, Model modelo)
    {
        modelo.addAttribute("listadoObservaciones",
                regisObservacionesFacade.findBySpecificField("datosPersonalesId",
                        datosPersonalesFacade.find(BigDecimal.valueOf(Long.parseLong(idDatosPersonales))),
                        "equal", null, null));

        return "/FormatoUnico/detalleObservacion";

    }

    //Metodos 
    /**
     *
     * @param listaDocumentos
     * @return Fecha de Subida de Formato Unico De todos los documentos, se obtiene solo los documentos con CATALOGO_ID=
     * 1 En caso de no encontrar nada devuelve null, en caso contrario la Fecha de Subida
     */
    private String obtenerFechaSubidaFormatoU(List<Documentos> listaDocumentos)
    {
        for (Documentos docu : listaDocumentos)
        {
            if (docu.getCatalogoDocumentosId().getId().equals(BigDecimal.valueOf(DOC_CAT_FU)))//Es igual a formato Unico
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
    private String obtenerIDDocumentoFormatoU(List<Documentos> listaDocumentos)
    {
        for (Documentos docu : listaDocumentos)
        {
            if (docu.getCatalogoDocumentosId().getId().equals(BigDecimal.valueOf(DOC_CAT_FU)))//Es igual a formato Unico
            {
                return docu.getId().toString();
            }
        }
        return null;
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
        } else if (banderaPrueba)
        {
            correoDestinatario = correoTest;
        }
        //En caso de que BanderaPrueba este activa se envia Correo al correo de Test

        String mensaje = " ";
        switch (tipo)
        {
            case 1://Aceptados
                mensaje = "<h1>Notificación Servicio Social</h1>\n"
                        + "<h2>Estimado  <b>" + nombre + "</b>:</h2> \n"
                        + "<p>\n"
                        + "Te informamos que  tu  Formato Único que has llenado, fue revisado por la Oficina de Servicio Social  y ha sido <b>Aceptado</b> Satisfactoriamente. \n"
                        + "</p>\n"
                        + "<p>Por lo que te recordamos, que a partir de este momento cada 2 meses tienes que subir tu   reporte bimestral, el cual será revisado de la misma manera  por la Oficina de Servicio Social. \n"
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
                        + "Te informamos que   tu  Formato Único que has llenado, ha sido revisado por la Oficina de Servicio Social  y este tiene errores.  Favor de corregirlos lo más pronto posible.\n"
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
                        + "Te informamos que   tu  Formato Único que has llenado, fue revisado por la Oficina de Servicio Social  y este ha sido <b>Rechazado</b>.\n"
                        + "</p>\n"
                        + "<p>\n"
                        + "Si esto ha sucedido, es porque has rebasado el número de intentos  para corregir tu Formato  Único.  Para mayor información  presentarse en la Oficina de Servicio Social o intentar de  nuevo para la siguiente convocatoria.  \n"
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

    //No-Visible 
    ////PRUEBA DE FOTO!!!!!!!!!!!!!!!!!!!!!!!
    @RequestMapping(value = "/guardarPDF2.do", method = RequestMethod.POST)
    public String save(
            @RequestParam("file") MultipartFile file, String id) throws IOException
    {

        Documentos doc = documentoFacade.find(BigDecimal.valueOf(Long.parseLong(id)));
        doc.setArchivo(file.getBytes());
        doc.setExtension("pdf");
        documentoFacade.edit(doc);
        return "redirect:subirpdf2.do";
    }

    @RequestMapping(value = "/subirpdf2.do", method = RequestMethod.GET)
    public String guardaFotoPrueba(Model modelo)
    {
        return "/FormatoUnico/guardarFoto";
    }
}
