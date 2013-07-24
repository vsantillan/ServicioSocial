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

    @RequestMapping(method = RequestMethod.GET, value = "/altaPlatica.do")
    public String altaPlatica(Model modelo) {
        Fecha anio = new Fecha();
        modelo.addAttribute("anioInicio", anio.anioActual());
        modelo.addAttribute("anioFin", anio.anioFin());
        modelo.addAttribute("platica", new Platica());
        //lista de lugares platica de induccion

        modelo.addAttribute("lugares", lugaresPlaticaFacade.findAll());


        return "/Platicas/altaPlatica";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/consultasBajas.do")
    public String consultasBajas(Model model) {



        // System.out.println("Conteo de registros Platica:"+platicaFacade.count()); 
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
    public String AsistenciaPosteriorEspecial(Model a) {
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
        // binder.registerCustomEditor(LugaresPlatica.class, new PropertyEditorSupport());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/altaPlaticaBD.do")
    public String insertarPlatica(@Valid Platica platica, BindingResult result, Model modelo) throws ParseException {

        //System.out.println(platica.getHora());
        //System.out.println(platica.getIdLugar().getId());
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
    public String folioPlatica(Model a) {


        return "/Platicas/reporte";
    }

    @RequestMapping(value = "asistencia.do", method = RequestMethod.POST)
    public String Asistencia(@Valid FoliosPlatica foliosPlatica, BindingResult result, Model modelo) {
        
        if (result.hasErrors()) {
            //modelo.addAttribute("folio", new FoliosPlatica());
            System.out.println("hubo errores asistencia do");
            return "/Platicas/capturarAsistencia";

        } else {
            System.out.println("no hubo errores asistencia do");
            modelo.addAttribute("foliosPlatica", new FoliosPlatica());
            return "/Platicas/capturarAsistencia";
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/eliminarPlatica.do")
    public void eliminarPlatica(long id_platica) throws ParseException {
        //System.out.print("eliminar platica.do");
        Platica platica = new Platica();
        platica.setId(id_platica);
        platicaFacade.remove(platica);


    }

    @RequestMapping(method = RequestMethod.GET, value = "/altaLugares.do")
    public String altaLugares(Model modelo) {
        modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
        return "/Platicas/lugaresPlatica";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/altaLugarBD.do")
    public String altaLugaresBD(LugaresPlatica lugares, Model modelo) {

        lugaresPlaticaFacade.create(lugares);
        modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
        return "/Platicas/lugaresPlatica";
    }

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
}
