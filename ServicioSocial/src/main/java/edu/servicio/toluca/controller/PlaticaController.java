/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.Fecha;
import edu.servicio.toluca.beans.MetodosValidacion;
import edu.servicio.toluca.entidades.Platica;
import edu.servicio.toluca.entidades.LugaresPlatica;
import edu.servicio.toluca.sesion.PlaticaFacade;
import edu.servicio.toluca.sesion.LugaresPlaticaFacade;
import edu.servicio.toluca.entidades.FoliosPlatica;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import javax.ejb.EJB;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.servicio.toluca.beans.PlaticaJson;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.login.Conexion;
import edu.servicio.toluca.sesion.FoliosPlaticaFacade;
import edu.servicio.toluca.sesion.VaFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.openide.util.Exceptions;


/**
 *
 * @author Mary
 */
@Controller
public class PlaticaController {

    @EJB(mappedName = "java:global/ServicioSocial/PlaticaFacade")
    private PlaticaFacade platicaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/LugaresPlaticaFacade")
    private LugaresPlaticaFacade lugaresPlaticaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/FoliosPlaticaFacade")
    private FoliosPlaticaFacade foliosPlaticaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/VaFacade")
    private VaFacade vaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    private VistaAlumnoFacade VistaAlumnoFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/altaPlatica.do")
    public String altaPlatica(Model modelo, HttpSession session, HttpServletRequest request) {
        if (!(((new ValidaSesion().validaOperador(session, request))) || (new ValidaSesion().validaRegistro(session, request))
                || (new ValidaSesion().validaAdmin(session, request)))) {
            modelo.addAttribute("error", "<div class='alert alert-danger'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        Fecha anio = new Fecha();
        modelo.addAttribute("anioInicio", anio.anioActual());
        modelo.addAttribute("anioFin", anio.anioFin());
        modelo.addAttribute("platica", new Platica());
        modelo.addAttribute("lugar_i", new LugaresPlatica());
        modelo.addAttribute("lugares", lugaresPlaticaFacade.findBySpecificField("status", 1, "equal", null, null));
        modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
        return "/Platicas/altaPlatica";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/folio.pdf")
    @ResponseBody
    public void reporte2(Model modelo, HttpSession session, HttpServletRequest request, HttpServletResponse httpServletResponse) throws ParseException, JRException {
        try {/*Parametros para realizar la conexión*/
            Conexion conn = new Conexion();
            /*Establecemos la ruta del reporte*/
            File reportFile = new File(request.getRealPath("reportes//folioPlatica.jasper"));
            /* No enviamos parámetros porque nuestro reporte no los necesita asi que escriba cualquier cadena de texto ya que solo seguiremos el formato del método runReportToPdf*/
            Map parameters = new HashMap();
            System.out.println("foli generado" + "809280531");
            parameters.put("folio", "809280531");
            /*Enviamos la ruta del reporte, los parámetros y la conexión(objeto Connection)*/
            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conn.conectar("ges_vin", "gst05a"));
            System.out.println("numero control");
            /*Indicamos que la respuesta va a ser en formato PDF*/
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setContentLength(bytes.length);
            httpServletResponse.getOutputStream().write(bytes);

        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
        //  modelo.addAttribute("error", "<div class='alert alert-danger'>Debes iniciar sesión para acceder a esta sección.</div>");


        // return "/Platicas/folio";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/consultasBajas.do")
    public String consultasBajas(Model modelo, HttpSession session, HttpServletRequest request) {
        if (!(((new ValidaSesion().validaOperador(session, request))) || (new ValidaSesion().validaRegistro(session, request))
                || (new ValidaSesion().validaAdmin(session, request)))) {
            modelo.addAttribute("error", "<div class='alert alert-danger'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        LinkedHashMap ordenarDesc = new LinkedHashMap();
        ordenarDesc.put("fecha", "desc");

        modelo.addAttribute("platica", platicaFacade.findBySpecificField("status", "1", "equal", ordenarDesc, null));
        return "/Platicas/consultasBajas";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/capturarAsistencia.do")
    public String capturarAsistencia(Model modelo, HttpSession session, HttpServletRequest request) {
        if (!(((new ValidaSesion().validaOperador(session, request))) || (new ValidaSesion().validaRegistro(session, request))
                || (new ValidaSesion().validaAdmin(session, request)))) {


            modelo.addAttribute("error", "<div class='alert alert-danger'>Debes iniciar sesión para acceder a esta sección.</div>");

            return "redirect:login.do";
        }
        modelo.addAttribute("foliosPlatica", new FoliosPlatica());
        return "/Platicas/capturarAsistencia";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/muestraPdf.do")
    public String pdfProcedimiento(Model modelo, HttpSession session, HttpServletRequest request) {
        return "/Platicas/muestraPdf";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/asistenciaPosteriorEspecial.do")
    public String AsistenciaPosteriorEspecial(Model modelo, HttpSession session, HttpServletRequest request) {
        if (!(((new ValidaSesion().validaOperador(session, request))) || (new ValidaSesion().validaAdmin(session, request)))) {
            modelo.addAttribute("error", "<div class='alert alert-danger'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
         ArrayList <Platica> platicasDisponibles = new ArrayList<Platica> ();
         List<Platica> platicas = platicaFacade.findAll();
         if (!platicas.isEmpty()){
         for(int i=0;i<platicas.size();i++){
             if ((platicas.get(i).getStatus().compareTo((short)1))==0){
                 platicasDisponibles.add(platicas.get(0));
             }
         }
         }
        modelo.addAttribute("platicasPeriodo",platicasDisponibles);
        return "/Platicas/asistenciaPosteriorEspecial";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/seleccionarPlatica.do")
    public String seleccionarPlatica(Model modelo, HttpSession session, HttpServletRequest request) {
        if (!(new ValidaSesion().validaAlumno(session, request))) {
            modelo.addAttribute("error", "<div class='alert alert-danger'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        modelo.addAttribute("platicasPeriodo", platicaFacade.platicasPeriodo());
        modelo.addAttribute("platica", new Platica());
        return "/Platicas/seleccionarPlatica";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/altaPlaticaBD.do")
    public String insertarPlatica(@Valid Platica platica, BindingResult result, Model modelo) throws ParseException, JRException {
        try {
            Fecha anio = new Fecha();
            platica.setNumeroAsistentes(0);
            if (result.hasErrors()) {
                System.out.println("intentando guardar errores");
                modelo.addAttribute("anioInicio", anio.anioActual());
                modelo.addAttribute("anioFin", anio.anioFin());
                modelo.addAttribute("lugares", lugaresPlaticaFacade.findBySpecificField("status", 1, "equal", null, null));
                modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
                modelo.addAttribute("lugar_i", new LugaresPlatica());
                modelo.addAttribute("alert", "<div class='alert alert-danger'><span class=\"glyphicon glyphicon-remove sizeIcon\" ></span>Error al guardar plática verifique los errores</div>");
                System.out.println("--" + result.getAllErrors());

                return "/Platicas/altaPlatica";
            } else {
                //////////////Obtenemos el Periodo y año de la platica apartir de la fecha de la platica//////////////
//                DateFormat formateador = DateFormat.getDateInstance();
//                String[] arrayFecha = formateador.format(platica.getFecha().).split("/");

                if (platica.getFecha().getMonth() <= 6) {
                    platica.setPeriodo("ENE-JUN");
                } else {
                    platica.setPeriodo("AGO-DIC");
                }

                platica.setAnio(((platica.getFecha().getYear())+1900)+"");
///////////////////////////////////////////////////////////////////////////////////////////////////
                System.out.println("sin errores entidad");
                System.out.println("fecha" + platica.getFechaMxFui().toString());
                if (platica.getFechaMxFui().compareTo(platica.getFecha()) > 0) {
                    MetodosValidacion hora = new MetodosValidacion();
                    System.out.println("hora" + platica.getHora());
                    if (!hora.esHora(platica.getHora())) {
                        System.out.println("no es hora");
                        modelo.addAttribute("anioInicio", anio.anioActual());
                        modelo.addAttribute("anioFin", anio.anioFin());
                        modelo.addAttribute("lugares", lugaresPlaticaFacade.findBySpecificField("status", 1, "equal", null, null));
                        modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
                        modelo.addAttribute("lugar_i", new LugaresPlatica());
                        modelo.addAttribute("alert", "<div class='alert alert-danger'><span class=\"glyphicon glyphicon-remove sizeIcon\" ></span>Error al guardar plática verifique los errores</div>");
                        modelo.addAttribute("errorHora", "<div class='alert alert-danger'><span class=\"glyphicon glyphicon-remove sizeIcon\" ></span>La hora no es valida</div>");
                        return "/Platicas/altaPlatica";
                    } else {
                        platica.setDescripcion(platica.getDescripcion().toUpperCase());
                        platica.setStatus((short) 1);
                        List<Platica> listaPlaticas = platicaFacade.findAll();
                        Boolean existe = false;
                        MetodosValidacion limpiar1 = new MetodosValidacion();
                        for (int i = 0; i < listaPlaticas.size(); i++) {
                            if ((platica.getAnio().toString().compareTo(listaPlaticas.get(i).getAnio().toString()) == 0) && (platica.getFecha().compareTo(listaPlaticas.get(i).getFecha()) == 0)
                                    && (platica.getHora().toString().compareTo(listaPlaticas.get(i).getHora().toString()) == 0) && (platica.getPeriodo().toString().compareTo(listaPlaticas.get(i).getPeriodo().toString()) == 0)
                                    && (platica.getStatus().compareTo(listaPlaticas.get(i).getStatus()) == 0) && (platica.getFechaMxFui().compareTo(listaPlaticas.get(i).getFechaMxFui()) == 0)
                                    && (platica.getDescripcion().toString().compareTo(platica.getDescripcion()) == 0)
                                    && (platica.getIdLugar().equals(listaPlaticas.get(i).getIdLugar()))) {
                                System.out.println("si existe");
                                existe = true;
                                break;
                            }

                        }
                        if (existe) {
                            
                            modelo.addAttribute("anioInicio", anio.anioActual());
                            modelo.addAttribute("anioFin", anio.anioFin());
                            modelo.addAttribute("lugares", lugaresPlaticaFacade.findBySpecificField("status", 1, "equal", null, null));
                            modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
                            modelo.addAttribute("lugar_i", new LugaresPlatica());
                            modelo.addAttribute("alert", "<div class='alert alert-danger'><span class=\"glyphicon glyphicon-remove sizeIcon\" ></span>Error al guardar plática verifique los errores</div>");
                            modelo.addAttribute("exito", "<div class='alert alert-danger'><span class=\"glyphicon glyphicon-remove sizeIcon\" ></span> La platica ya existe</div>");
                            System.out.println("ya existia");
                            return "/Platicas/altaPlatica";
                        } else {
                            MetodosValidacion limpiar = new MetodosValidacion();
                            platica.setDescripcion(platica.getDescripcion().toUpperCase());
                            platicaFacade.create(platica);
                            modelo.addAttribute("anioInicio", anio.anioActual());
                            modelo.addAttribute("anioFin", anio.anioFin());
                            modelo.addAttribute("lugares", lugaresPlaticaFacade.findBySpecificField("status", 1, "equal", null, null));
                            modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
                            modelo.addAttribute("lugar_i", new LugaresPlatica());
                            modelo.addAttribute("alert", "<div class='alert alert-success'><span class=\"glyphicon glyphicon-saved sizeIcon\" ></span>Plática Guardada</div>");
                            System.out.println("creada");
                            return "/Platicas/altaPlatica";
                        }
                    }
                } else {
                    modelo.addAttribute("anioInicio", anio.anioActual());
                    modelo.addAttribute("anioFin", anio.anioFin());
                    modelo.addAttribute("lugares", lugaresPlaticaFacade.findBySpecificField("status", 1, "equal", null, null));
                    modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
                    modelo.addAttribute("lugar_i", new LugaresPlatica());
                    modelo.addAttribute("alert", "<div class='alert alert-danger'><h3<span class=\"glyphicon glyphicon-remove sizeIcon\" ></span>Error al guardar plática verifique los errores</h3></div>");
                    modelo.addAttribute("errorFm", "<div class='alert alert-danger'>La fecha de platica debe ser menor a la de Formato Único</div>");
                    return "/Platicas/altaPlatica";
                }
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
            System.out.println(ex.getCause() + "" + ex.getCause() + "" + ex.getLocalizedMessage());
            return "/Platicas/altaPlatica";
        }


    }

    @RequestMapping(method = RequestMethod.POST, value = "/folioPlatica.pdf")
    public String folioPlatica(Model modelo, String fecha, HttpSession session, HttpServletRequest request) {

        List<FoliosPlatica> lista = foliosPlaticaFacade.findBySpecificField("numeroFolio", fecha + session.getAttribute("NCONTROL").toString(), "equal", null, null);
        if (lista.isEmpty()) {
            VistaAlumno alumnoRegistrado = new VistaAlumno();
            alumnoRegistrado.setId(session.getAttribute("NCONTROL").toString());
            List<FoliosPlatica> tieneRegistros = foliosPlaticaFacade.findBySpecificField("alumnoId", alumnoRegistrado, "equal", null, null);
            if (!tieneRegistros.isEmpty()) {
                for (int i = 0; i < tieneRegistros.size(); i++) {
                    foliosPlaticaFacade.remove(tieneRegistros.get(i));
                }
            }
            FoliosPlatica foliosPlatica = new FoliosPlatica();
            Platica platica = new Platica();
            VistaAlumno alumno = new VistaAlumno();
            alumno.setId(session.getAttribute("NCONTROL").toString());
            System.out.println("platica id:" + fecha);
            platica.setId(Long.parseLong(fecha));
            foliosPlatica.setPlaticaId(platica);
            foliosPlatica.setAlumnoId(alumno);
            //folio: numero de control+idPlatica
            foliosPlatica.setNumeroFolio(fecha + session.getAttribute("NCONTROL").toString());
            System.out.println(fecha + session.getAttribute("NCONTROL").toString());
            foliosPlatica.setStatus((short) 1);
            foliosPlaticaFacade.create(foliosPlatica);

            //incrementar numero de asistentes +1
            platica = platicaFacade.findBySpecificField("id", fecha, "equal", null, null).get(0);
            int numero = platica.getNumeroAsistentes().intValue();
            numero = numero + 1;
            System.out.println("numero" + numero);
            platica.setNumeroAsistentes(numero);
            platicaFacade.edit(platica);
            session.setAttribute("platica", fecha + "");
            return "/Platicas/folio";

        } else {
            modelo.addAttribute("platicasPeriodo", platicaFacade.platicasPeriodo());
            modelo.addAttribute("platica", new Platica());

            modelo.addAttribute("existe", "<div class='alert alert-danger'>Ya te has registrado a esta platica anteriormente</div>");
            return "/Platicas/seleccionarPlatica";
        }
    }

/////////ASISTENCIA.DO////////////////////
    @RequestMapping(value = "asistencia.do", method = RequestMethod.POST)
    public String Asistencia(@Valid FoliosPlatica foliosPlatica, BindingResult result, Model modelo) throws IOException {

        if (result.hasErrors()) {
            modelo.addAttribute("folio", new FoliosPlatica());
            System.out.println("hubo errores asistencia do");
            return "/Platicas/capturarAsistencia";

        } else {
            List<FoliosPlatica> lista = foliosPlaticaFacade.findBySpecificField("numeroFolio", foliosPlatica.getNumeroFolio(), "equal", null, null);

            if (lista.size() > 0) {
                VistaAlumno vistaAlumno1;
                vistaAlumno1 = VistaAlumnoFacade.find(lista.get(0).getAlumnoId().getId());
                System.out.println(lista.get(0).getAlumnoId());
                //vistaAlumno1 = VistaAlumnoFacade.find("09280531");
                modelo.addAttribute("alumno", vistaAlumno1);
                modelo.addAttribute("espacio", " ");
                return "/Platicas/capturarAsistencia2";
            } else {
                modelo.addAttribute("foliosPlatica", new FoliosPlatica());
                modelo.addAttribute("existe", "<div class='alert alert-danger'>No existe numero de folio</div>");
                return "/Platicas/capturarAsistencia";
            }
        }
    }

    @RequestMapping(value = "ponerAsistencia.do", method = RequestMethod.POST)
    public String ponerAsistencia(@Valid FoliosPlatica foliosPlatica, BindingResult result, Model modelo) throws IOException {

        if (result.hasErrors()) {
            modelo.addAttribute("folio", new FoliosPlatica());
            System.out.println("hubo errores asistencia do");
            return "/Platicas/capturarAsistencia";

        } else {
            List<FoliosPlatica> lista = foliosPlaticaFacade.findBySpecificField("numeroFolio", foliosPlatica.getNumeroFolio(), "equal", null, null);

            if (lista.size() > 0) {
                foliosPlatica = foliosPlaticaFacade.find(lista.get(0).getId());
                foliosPlatica.setAsistencia((short) 1);
                foliosPlaticaFacade.edit(foliosPlatica);
                modelo.addAttribute("colocado"," <div ><span class=\"glyphicon glyphicon-ok  alert-succes\" ></span></div>");
                return "/Platicas/capturarAsistencia";
            } else {
                modelo.addAttribute("foliosPlatica", new FoliosPlatica());
                modelo.addAttribute("colocado"," <div ><span class=\"glyphicon glyphicon-remove alert-danger\" ></span></div>");
                modelo.addAttribute("existe", "<div class='alert alert-danger'><span class=\"glyphicon glyphicon-remove sizeIcon\" ></span> No existe numero de folio</div>");
                return "/Platicas/capturarAsistencia";
            }
        }
    }

    @RequestMapping(value = "capturarAsistenciaPosteriorEspecial.do", method = RequestMethod.POST)
    public String ponerAsistenciaEspecial(String idPlatica, String no_control, Model modelo, HttpSession session, HttpServletRequest request) {

        if (no_control.length() > 7 && no_control.length() < 9) {
            // List<Va> listaAlumno = vaFacade.findBySpecificField("id", no_control, "equal", null, null); 
            List<VistaAlumno> listaAlumno = VistaAlumnoFacade.findBySpecificField("id", no_control, "equal", null, null);
            if (listaAlumno.isEmpty()) {
                modelo.addAttribute("platicasPeriodo", platicaFacade.findAll());
                modelo.addAttribute("error", "<p class='alert alert-danger'>Numero de control no encontrado</p>");
                return "/Platicas/asistenciaPosteriorEspecial";
            } else {
                VistaAlumno porcentaje = listaAlumno.get(0);
                if (Float.parseFloat(porcentaje.getPorcentaje()) < 70) {
                    modelo.addAttribute("platicasPeriodo", platicaFacade.findAll());
                    modelo.addAttribute("error", "<p class='alert alert-danger'>El alumno no cuenta con los creditos suficientes , tiene" + Float.parseFloat(porcentaje.getPorcentaje()) + "% de creditos</p>");
                    return "/Platicas/asistenciaPosteriorEspecial";
                } else {
                    VistaAlumno alumnoRegistrado1 = new VistaAlumno();
                    alumnoRegistrado1.setId(no_control);
                    System.out.println("creo alumno");
                    List<FoliosPlatica> tieneRegistros = foliosPlaticaFacade.findBySpecificField("alumnoId", alumnoRegistrado1, "equal", null, null);
                    if (!tieneRegistros.isEmpty()) {
                        System.out.println("entro no esta vacia");
                        for (int i = 0; i < tieneRegistros.size(); i++) {
                            foliosPlaticaFacade.remove(tieneRegistros.get(i));
                        }
                    }

                    List<FoliosPlatica> lista = foliosPlaticaFacade.findBySpecificField("numeroFolio", idPlatica + "" + no_control, "equal", null, null);
                    if (lista.isEmpty()) {
                        FoliosPlatica foliosPlatica = new FoliosPlatica();
                        Platica platica = new Platica();
                        VistaAlumno alumno = new VistaAlumno();
                        alumno.setId(no_control);
                        System.out.println("platica id:" + idPlatica);
                        platica.setId(Long.parseLong(idPlatica));
                        foliosPlatica.setPlaticaId(platica);
                        foliosPlatica.setAlumnoId(alumno);
                        //folio: numero de control+idPlatica
                        foliosPlatica.setNumeroFolio(idPlatica + no_control);
                        System.out.println(idPlatica + no_control);
                        foliosPlatica.setStatus((short) 1);
                        foliosPlatica.setAsistencia((short) 1);
                        foliosPlaticaFacade.create(foliosPlatica);
                        //incrementar numero de asistentes +1
                        platica = platicaFacade.findBySpecificField("id", idPlatica, "equal", null, null).get(0);
                        int numero = platica.getNumeroAsistentes();
                        numero = numero + 1;
                        System.out.println("numero" + numero);
                        platica.setNumeroAsistentes(numero);
                        platicaFacade.edit(platica);
                        modelo.addAttribute("folio", idPlatica + no_control);
                        modelo.addAttribute("idP", foliosPlatica.getPlaticaId().getId());
                        modelo.addAttribute("platicasPeriodo", platicaFacade.findAll());
                        return "/Platicas/asistenciaPosteriorEspecial";

                    } else {
                        FoliosPlatica foliosPlatica = lista.get(0);
                        System.out.println("si encontro numero folio");
                        foliosPlatica.setAsistencia((short) 1);
                        foliosPlaticaFacade.edit(foliosPlatica);
                        modelo.addAttribute("folio", idPlatica + no_control);
                        modelo.addAttribute("idP", foliosPlatica.getPlaticaId().getId());
                        modelo.addAttribute("platicasPeriodo", platicaFacade.findAll());
                        return "/Platicas/asistenciaPosteriorEspecial";
                    }
                }
            }
        } else {
            modelo.addAttribute("platicasPeriodo", platicaFacade.findAll());
            modelo.addAttribute("error", "<p class='alert alert-danger'>Numero de control incorrecto</p>");
            return "/Platicas/asistenciaPosteriorEspecial";
        }

    }

//    @RequestMapping(value = "/mostrarFoto.do", method = RequestMethod.GET)
//    @ResponseBody
//    public void saveAndShowPDF(String id, HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException, Exception {
//
//        httpServletResponse.setContentType("image/jpg");
//        httpServletResponse.getOutputStream().write(VistaAlumnoFacade.find(id).getFoto());
//        httpServletResponse.getOutputStream().close();
//
//    }
    /////////ASISTENCIA.DO  finnnnnnnnnnnnnnnnnnnnnnnn////////////////////
    @RequestMapping(method = RequestMethod.POST, value = "/eliminarPlatica.do")
    public void eliminarPlatica(long id_platica) throws ParseException {
        //System.out.print("eliminar platica.do");
        try {
            Platica platica;
            platica = platicaFacade.find(id_platica);
            platica.setStatus((short) 0);
            platicaFacade.edit(platica);
        } catch (Exception e) {
        }


    }

    @RequestMapping(method = RequestMethod.POST, value = "/guardaLugar.do")
    public String guardaLugar(LugaresPlatica lugares, Model modelo) {
        if (!lugares.getLugar().isEmpty()) {
            List<LugaresPlatica> listaLugares = lugaresPlaticaFacade.findAll();
            Boolean existe = false;
            MetodosValidacion limpiar = new MetodosValidacion();
            for (int i = 0; i < listaLugares.size(); i++) {
                System.out.println(listaLugares.get(i).getLugar().toString());
                if (listaLugares.get(i).getLugar().toString().compareTo(limpiar.quitaCaracteresEspeciales(lugares.getLugar().toUpperCase().toString())) == 0) {
                    existe = true;
                    break;
                }
            }
            if (existe) {
                Fecha anio = new Fecha();
                modelo.addAttribute("anioInicio", anio.anioActual());
                modelo.addAttribute("anioFin", anio.anioFin());
                modelo.addAttribute("platica", new Platica());
                LinkedHashMap ordenarDesc = new LinkedHashMap();
                ordenarDesc.put("id", "desc");
                modelo.addAttribute("lugares", lugaresPlaticaFacade.findBySpecificField("status", 1, "equal", ordenarDesc, null));
                modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
                modelo.addAttribute("alert", "<script>alert('El lugar ya existe');</script>");
                return "/Platicas/altaPlatica";
            } else {
                lugares.setStatus(BigInteger.valueOf(1));
                lugares.setLugar(lugares.getLugar());
                MetodosValidacion limpiar2 = new MetodosValidacion();
                lugares.setLugar(limpiar2.quitaCaracteresEspeciales(lugares.getLugar().toUpperCase().toString()));
                lugaresPlaticaFacade.create(lugares);
                Fecha anio = new Fecha();
                modelo.addAttribute("anioInicio", anio.anioActual());
                modelo.addAttribute("anioFin", anio.anioFin());
                modelo.addAttribute("platica", new Platica());
                LinkedHashMap ordenarDesc = new LinkedHashMap();
                ordenarDesc.put("id", "desc");
                modelo.addAttribute("lugares", lugaresPlaticaFacade.findBySpecificField("status", 1, "equal", ordenarDesc, null));
                modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
                modelo.addAttribute("alert", "<script>alert('Lugar agregado');</script>");
                return "/Platicas/altaPlatica";
            }
        } else {
            Fecha anio = new Fecha();
            modelo.addAttribute("anioInicio", anio.anioActual());
            modelo.addAttribute("anioFin", anio.anioFin());
            modelo.addAttribute("platica", new Platica());
            LinkedHashMap ordenarDesc = new LinkedHashMap();
            ordenarDesc.put("id", "desc");
            modelo.addAttribute("lugares", lugaresPlaticaFacade.findBySpecificField("status", 1, "equal", ordenarDesc, null));
            modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
            modelo.addAttribute("alert", "<script>alert('Error al agregar lugar el capo no puede estar vacio');</script>");
            return "/Platicas/altaPlatica";
        }


    }

    //metodo para cambiar informacion de platica dinamicamente en seleccionarPlatica
    @RequestMapping(method = RequestMethod.POST, value = "/actualizarDetalle.do")
    public @ResponseBody
    PlaticaJson actualizarDetalle(String fecha, Model modelo) {
        //System.out.println("fecha:"+fecha);
        PlaticaJson platicaJson = new PlaticaJson();
        modelo.addAttribute("lugaresPlatica", new LugaresPlatica());

        Platica platica = platicaFacade.find(Long.parseLong(fecha));
        platicaJson.setHora("Hora:" + platica.getHora());
        platicaJson.setLugar("Lugar:"+platica.getIdLugar().getLugar());
        platicaJson.setDescripcion("Descripción:" + platica.getDescripcion());
        return platicaJson;
    }
////PRUEBA DE FOTO!!!!!!!!!!!!!!!!!!!!!!!
//    @RequestMapping(value = "/subirFoto.do", method = RequestMethod.POST)
//    public String save(
//            @RequestParam("file") MultipartFile file, String id) throws IOException {
//        VistaAlumno vistaAlumno1;
//        vistaAlumno1 = VistaAlumnoFacade.find(id);
//        vistaAlumno1.setFoto(file.getBytes());
//        VistaAlumnoFacade.edit(vistaAlumno1);
//        return "/Platicas/guardarFoto";
//    }
//
//    @RequestMapping(value = "/guardaFoto.do")
//    public String guardaFotoPrueba(Model modelo) {
//        modelo.addAttribute("vistaAlumno", new VistaAlumno());
//        return "/Platicas/guardarFoto";
//    }
    //// fin          PRUEBA DE FOTO!!!!!!!!!!!!!!!!!!!!!!!
}
