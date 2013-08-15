/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.Fecha;
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
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.FoliosPlaticaFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    private VistaAlumnoFacade vistaAlumnoFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/altaPlatica.do")
    public String altaPlatica(Model modelo) {
        Fecha anio = new Fecha();
        modelo.addAttribute("anioInicio", anio.anioActual());
        modelo.addAttribute("anioFin", anio.anioFin());
        modelo.addAttribute("platica", new Platica());
        modelo.addAttribute("lugares", lugaresPlaticaFacade.findAll());
        return "/Platicas/altaPlatica";
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
        modelo.addAttribute("platicasPeriodo", platicaFacade.platicasPeriodo());
        return "/Platicas/asistenciaPosteriorEspecial";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/seleccionarPlatica.do")
    public String seleccionarPlatica(Model modelo) {
        modelo.addAttribute("platicasPeriodo", platicaFacade.platicasPeriodo());
        modelo.addAttribute("platica", new Platica());
        return "/Platicas/seleccionarPlatica";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/altaLugares.do")
    public String altaLugares(Model modelo) {
        modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
        return "/Platicas/lugaresPlatica";
    }

    // metodo para validar fecha, va colocado antes del metodo que invoca a @valid
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true);
        binder.registerCustomEditor(Date.class, editor);
        // binder.registerCustomEditor(LugaresPlatica.class, new PropertyEditorSupport());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/altaPlaticaBD.do")
    public String insertarPlatica(@Valid Platica platica, BindingResult result, Model modelo) throws ParseException {

        platica.setNumeroAsistentes(0);

        if (result.hasErrors()) {
            Fecha anio = new Fecha();
            modelo.addAttribute("anioInicio", anio.anioActual());
            modelo.addAttribute("anioFin", anio.anioFin());
            modelo.addAttribute("lugares", lugaresPlaticaFacade.findAll());
            return "/Platicas/altaPlatica";
        } else {
            platicaFacade.create(platica);
            return "/Platicas/redirectAltaPlatica";
        }


    }

    @RequestMapping(method = RequestMethod.GET, value = "/folioPlatica.do")
    public String folioPlatica(Model a, String fecha) {
        FoliosPlatica foliosPlatica = new FoliosPlatica();
        Platica platica = new Platica();
        VistaAlumno alumno = new VistaAlumno();
        alumno.setId("09280531");
        System.out.println("platica id:" + fecha);
        platica.setId(Long.parseLong(fecha));
        foliosPlatica.setPlaticaId(platica);
        foliosPlatica.setAlumnoId(alumno);
        //folio: numero de control+idPlatica
        foliosPlatica.setNumeroFolio(fecha + "09280531");
        System.out.println(fecha + "09280531");
        foliosPlatica.setStatus((short) 1);
        foliosPlaticaFacade.create(foliosPlatica);

        //incrementar numero de asistentes +1
        platica = platicaFacade.findBySpecificField("id", fecha, "equal", null, null).get(0);
        int numero = platica.getNumeroAsistentes();
        numero = numero + 1;
        System.out.println("numero" + numero);
        platica.setNumeroAsistentes(numero);
        platicaFacade.edit(platica);

         return "/Platicas/reporte";
       // return "/Platicas/seleccionarPlatica";
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
                vistaAlumno1 = vistaAlumnoFacade.find(lista.get(0).getAlumnoId() + ""); //id se toma de sa sesion
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

    @RequestMapping(value = "ponerAsistenciaEspecial.do", method = RequestMethod.POST)
    public String ponerAsistenciaEspecial(String idPlatica, String no_control, Model modelo) {

        if (no_control.length() > 7 && no_control.length() < 9) {
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
       platica = platicaFacade.findBySpecificField("id",idPlatica, "equal", null, null).get(0);
        int numero = platica.getNumeroAsistentes();
        numero = numero + 1;
        System.out.println("numero" + numero);
        platica.setNumeroAsistentes(numero);
        platicaFacade.edit(platica);
          modelo.addAttribute("platicasPeriodo", platicaFacade.platicasPeriodo());
          return "/Platicas/asistenciaPosteriorEspecial";
        } else {
            modelo.addAttribute("platicasPeriodo", platicaFacade.platicasPeriodo());
            modelo.addAttribute("error", "<div class='error'>Numero de control incorrecto</div>");
        }
        return "/Platicas/asistenciaPosteriorEspecial";
    }

    @RequestMapping(value = "/mostrarFoto.do", method = RequestMethod.GET)
    @ResponseBody
    public void saveAndShowPDF(String id, HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException, Exception {

        httpServletResponse.setContentType("image/jpg");
        httpServletResponse.getOutputStream().write(vistaAlumnoFacade.find(id).getFoto());
        httpServletResponse.getOutputStream().close();

    }
    /////////ASISTENCIA.DO  finnnnnnnnnnnnnnnnnnnnnnnn////////////////////

    @RequestMapping(method = RequestMethod.POST, value = "/eliminarPlatica.do")
    public void eliminarPlatica(long id_platica) throws ParseException {
        //System.out.print("eliminar platica.do");
        Platica platica = new Platica();
        platica.setId(id_platica);
        platicaFacade.remove(platica);


    }

    @RequestMapping(method = RequestMethod.POST, value = "/altaLugarBD.do")
    public String altaLugaresBD(@Valid LugaresPlatica lugares, BindingResult result, Model modelo) {
        if (result.hasErrors()) {

            return "/Platicas/lugaresPlatica";
        } else {
            lugaresPlaticaFacade.create(lugares);
            modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
            return "/Platicas/lugaresPlatica";
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
        vistaAlumno1 = vistaAlumnoFacade.find(id);
        vistaAlumno1.setFoto(file.getBytes());
        vistaAlumnoFacade.edit(vistaAlumno1);
        return "/Platicas/guardarFoto";
    }

    @RequestMapping(value = "/guardaFoto.do")
    public String guardaFotoPrueba(Model modelo) {
        modelo.addAttribute("vistaAlumno", new VistaAlumno());
        return "/Platicas/guardarFoto";
    }
    //// fin          PRUEBA DE FOTO!!!!!!!!!!!!!!!!!!!!!!!
}
