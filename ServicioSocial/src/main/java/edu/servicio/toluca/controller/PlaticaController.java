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
import edu.servicio.toluca.beans.ValidacionAsistenciaPlatica;
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
import edu.servicio.toluca.beans.ValidacionPlatica;
import edu.servicio.toluca.entidades.Va;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.FoliosPlaticaFacade;
import edu.servicio.toluca.sesion.VaFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    public String altaPlatica(Model modelo) {
        Fecha anio = new Fecha();
        modelo.addAttribute("anioInicio", anio.anioActual());
        modelo.addAttribute("anioFin", anio.anioFin());
        modelo.addAttribute("platica", new Platica());
        modelo.addAttribute("lugares", lugaresPlaticaFacade.findBySpecificField("status", 1, "equal", null, null));
        modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
        return "/Platicas/altaPlatica";
    }

        @RequestMapping(method = RequestMethod.GET, value = "/pruebarep.do")
    public String reporte(Model model) {
        return "/Platicas/pruebarep";
    }
          @RequestMapping(method = RequestMethod.GET, value = "/rep.do")
    public String reporte2(Model model) {
        return "/Platicas/rep";
    }    
        
    @RequestMapping(method = RequestMethod.GET, value = "/consultasBajas.do")
    public String consultasBajas(Model model) {
        LinkedHashMap ordenarDesc = new LinkedHashMap();
        ordenarDesc.put("fecha", "desc");

        model.addAttribute("platica", platicaFacade.findBySpecificField("status", "1", "equal", ordenarDesc, null));
        return "/Platicas/consultasBajas";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/capturarAsistencia.do")
    public String capturarAsistencia(Model modelo) {
        modelo.addAttribute("foliosPlatica", new FoliosPlatica());
        return "/Platicas/capturarAsistencia";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/asistenciaPosteriorEspecial.do")
    public String AsistenciaPosteriorEspecial(Model modelo) {
        modelo.addAttribute("platicasPeriodo", platicaFacade.findAll());
        return "/Platicas/asistenciaPosteriorEspecial";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/seleccionarPlatica.do")
    public String seleccionarPlatica(Model modelo) {
        modelo.addAttribute("platicasPeriodo", platicaFacade.platicasPeriodo());
        modelo.addAttribute("platica", new Platica());
        return "/Platicas/seleccionarPlatica";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/altaPlaticaBD.do")
    public String insertarPlatica(@Valid Platica platica, BindingResult result, Model modelo) throws ParseException {

        platica.setNumeroAsistentes(0);
        Fecha anio = new Fecha();
        System.out.println("intentando guardar");
        if (result.hasErrors()) {
            System.out.println("intentando guardar errores");
            modelo.addAttribute("anioInicio", anio.anioActual());
            modelo.addAttribute("anioFin", anio.anioFin());
            modelo.addAttribute("lugares", lugaresPlaticaFacade.findBySpecificField("status", 1, "equal", null, null));
            modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
            return "/Platicas/altaPlatica";
        } else {
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
                    modelo.addAttribute("errorHora", "<div class='error'>La hora no es valida</div>");
                    return "/Platicas/altaPlatica";
                } else {
                    platica.setStatus((short) 1);
                    List<Platica> listaPlaticas = platicaFacade.findAll();
                    Boolean existe = false;
                    MetodosValidacion limpiar1 = new MetodosValidacion();
                    for (int i = 0; i < listaPlaticas.size(); i++) {
                        if ((platica.getAnio().toString().compareTo(listaPlaticas.get(i).getAnio().toString()) == 0) && (platica.getFecha().compareTo(listaPlaticas.get(i).getFecha()) == 0)
                                && (platica.getHora().toString().compareTo(listaPlaticas.get(i).getHora().toString()) == 0) && (platica.getPeriodo().toString().compareTo(listaPlaticas.get(i).getPeriodo().toString()) == 0)
                                && (platica.getTipo().compareTo(listaPlaticas.get(i).getTipo()) == 0) && (platica.getStatus().compareTo(listaPlaticas.get(i).getTipo()) == 0)
                                && (platica.getStatus().compareTo(listaPlaticas.get(i).getStatus()) == 0) && (platica.getFechaMxFui().compareTo(listaPlaticas.get(i).getFechaMxFui()) == 0)
                                && (platica.getDescripcion().toString().compareTo(limpiar1.quitaCaracteresEspeciales(platica.getDescripcion())) == 0)
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
                        modelo.addAttribute("exito", "<div class='error'> LA PLÁTICA YA EXISTE</div>");
                        System.out.println("ya existia");
                        return "/Platicas/altaPlatica";
                    } else {
                        MetodosValidacion limpiar = new MetodosValidacion();
                        platica.setDescripcion(limpiar.pasaMayusculas(limpiar.quitaCaracteresEspeciales(platica.getDescripcion())));
                        platicaFacade.create(platica);
                        modelo.addAttribute("anioInicio", anio.anioActual());
                        modelo.addAttribute("anioFin", anio.anioFin());
                        modelo.addAttribute("lugares", lugaresPlaticaFacade.findBySpecificField("status", 1, "equal", null, null));
                        modelo.addAttribute("lugaresPlatica", new LugaresPlatica());

                        modelo.addAttribute("alert", "<script>alert('Platica Guardada');</script>");
                        System.out.println("creada");
                        return "/Platicas/altaPlatica";
                    }
                }
            } else {
                modelo.addAttribute("anioInicio", anio.anioActual());
                modelo.addAttribute("anioFin", anio.anioFin());
                modelo.addAttribute("lugares", lugaresPlaticaFacade.findBySpecificField("status", 1, "equal", null, null));
                modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
                modelo.addAttribute("errorFm", "<div class='error'>La fecha de platica debe ser menor a la de Formato unico</div>");
                return "/Platicas/altaPlatica";
            }

        }


    }

    @RequestMapping(method = RequestMethod.GET, value = "/folioPlatica.do")
    public String folioPlatica(Model modelo, String fecha, String numeroC) {

        List<FoliosPlatica> lista = foliosPlaticaFacade.findBySpecificField("numeroFolio", fecha + numeroC, "equal", null, null);
        if (lista.isEmpty()) {
            FoliosPlatica foliosPlatica = new FoliosPlatica();
            Platica platica = new Platica();
            VistaAlumno alumno = new VistaAlumno();
            alumno.setId(numeroC);
            System.out.println("platica id:" + fecha);
            platica.setId(Long.parseLong(fecha));
            foliosPlatica.setPlaticaId(platica);
            foliosPlatica.setAlumnoId(alumno);
            //folio: numero de control+idPlatica
            foliosPlatica.setNumeroFolio(fecha + numeroC);
            System.out.println(fecha + numeroC);
            foliosPlatica.setStatus((short) 1);
            foliosPlaticaFacade.create(foliosPlatica);

            //incrementar numero de asistentes +1
            platica = platicaFacade.findBySpecificField("id", fecha, "equal", null, null).get(0);
            int numero = platica.getNumeroAsistentes().intValue();
            numero = numero + 1;
            System.out.println("numero" + numero);
            platica.setNumeroAsistentes(numero);
            platicaFacade.edit(platica);
            return "/Platicas/seleccionarPlatica";
            //  return "/Platicas/reporte";
        } else {
            modelo.addAttribute("platicasPeriodo", platicaFacade.platicasPeriodo());
            modelo.addAttribute("platica", new Platica());
            modelo.addAttribute("existe", "<div class='error'>Ya te has registrado a esta platica anteriormente</div>");
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
                modelo.addAttribute("existe", "<div class='error'>No existe numero de folio</div>");
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
                return "/Platicas/capturarAsistencia";
            } else {
                modelo.addAttribute("foliosPlatica", new FoliosPlatica());
                modelo.addAttribute("existe", "<div class='error'>No existe numero de folio</div>");
                return "/Platicas/capturarAsistencia";
            }
        }
    }

    @RequestMapping(value = "capturarAsistenciaPosteriorEspecial.do", method = RequestMethod.POST)
    public String ponerAsistenciaEspecial(String idPlatica, String no_control, Model modelo) {

        if (no_control.length() > 7 && no_control.length() < 9) {
            // List<Va> listaAlumno = vaFacade.findBySpecificField("id", no_control, "equal", null, null); 
            List<VistaAlumno> listaAlumno = VistaAlumnoFacade.findBySpecificField("id", no_control, "equal", null, null);
            if (listaAlumno.isEmpty()) {
                modelo.addAttribute("platicasPeriodo", platicaFacade.findAll());
                modelo.addAttribute("error", "<div class='error'>Numero de control no encontrado</div>");
                return "/Platicas/asistenciaPosteriorEspecial";
            } else {
                VistaAlumno porcentaje = listaAlumno.get(0);
                if (Float.parseFloat(porcentaje.getPorcentaje()) < 70) {
                    modelo.addAttribute("platicasPeriodo", platicaFacade.findAll());
                    modelo.addAttribute("error", "<div class='error'>El alumno no cuenta con los creditos suficientes</div>");
                    return "/Platicas/asistenciaPosteriorEspecial";
                } else {

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
            modelo.addAttribute("error", "<div class='error'>Numero de control incorrecto</div>");
            return "/Platicas/asistenciaPosteriorEspecial";
        }

    }

    @RequestMapping(value = "/mostrarFoto.do", method = RequestMethod.GET)
    @ResponseBody
    public void saveAndShowPDF(String id, HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException, Exception {

        httpServletResponse.setContentType("image/jpg");
        httpServletResponse.getOutputStream().write(VistaAlumnoFacade.find(id).getFoto());
        httpServletResponse.getOutputStream().close();

    }
    /////////ASISTENCIA.DO  finnnnnnnnnnnnnnnnnnnnnnnn////////////////////

    @RequestMapping(method = RequestMethod.POST, value = "/eliminarPlatica.do")
    public void eliminarPlatica(long id_platica) throws ParseException {
        //System.out.print("eliminar platica.do");
        Platica platica = new Platica();
        platica = platicaFacade.find(id_platica);
        platica.setStatus((short) 0);
        platicaFacade.edit(platica);


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
        platicaJson.setDetalle("Hora:" + platica.getHora() + "\t" + "Lugar:" + platica.getIdLugar().getLugar());
        platicaJson.setDescripcion("Descripción:" + platica.getDescripcion());
        return platicaJson;
    }
////PRUEBA DE FOTO!!!!!!!!!!!!!!!!!!!!!!!

    @RequestMapping(value = "/subirFoto.do", method = RequestMethod.POST)
    public String save(
            @RequestParam("file") MultipartFile file, String id) throws IOException {
        VistaAlumno vistaAlumno1;
        vistaAlumno1 = VistaAlumnoFacade.find(id);
        vistaAlumno1.setFoto(file.getBytes());
        VistaAlumnoFacade.edit(vistaAlumno1);
        return "/Platicas/guardarFoto";
    }

    @RequestMapping(value = "/guardaFoto.do")
    public String guardaFotoPrueba(Model modelo) {
        modelo.addAttribute("vistaAlumno", new VistaAlumno());
        return "/Platicas/guardarFoto";
    }
    //// fin          PRUEBA DE FOTO!!!!!!!!!!!!!!!!!!!!!!!
}
