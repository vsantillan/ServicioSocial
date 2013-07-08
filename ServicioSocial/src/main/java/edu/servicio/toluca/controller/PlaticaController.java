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
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jonny
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
        // Platica platica = new Platica();
//       platica.setAnio("2015");
//       platica.setFecha(new Date("20/05/2013"));
//       platica.setFechaMxFui(new Date("25/05/2013"));
//       platica.setHora("05:00");
        //  platica.setId(2L);
//       platica.setLugar("Edificio kkkkkk");
//       platica.setNumeroAsistentes(200);
//       platica.setPeriodo("Ago-Diciembre!");
//       platica.setStatus((short)2);
//       platica.setTipo((short)2);


        // System.out.println("Conteo de registros Platica:"+platicaFacade.count()); 
        LinkedHashMap ordenarDesc = new LinkedHashMap();
        ordenarDesc.put("fecha", "desc");

        model.addAttribute("platica", platicaFacade.findBySpecificField("status", "1", "equal", ordenarDesc, null));
        return "/Platicas/consultasBajas";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/capturarAsistencia.do")
    public String capturarAsistencia(Model a) {
        return "/Platicas/capturarAsistencia";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/asistenciaPosteriorEspecial.do")
    public String AsistenciaPosteriorEspecial(Model a) {
        return "/Platicas/asistenciaPosteriorEspecial";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/seleccionarPlatica.do")
    public String seleccionarPlatica(Model a) {
        return "/Platicas/seleccionarPlatica";
    }
     @RequestMapping(method = RequestMethod.GET, value = "/altaLugares.do")
    public String altaLugares(Model modelo) {
        return "/Platicas/lugaresPlatica";
    }
      @RequestMapping(method = RequestMethod.POST, value = "/altaLugarBD.do")
    public String altaLugaresBD(LugaresPlatica lugares, Model modelo) {
          lugaresPlaticaFacade.create(lugares);
          
        return "/Platicas/lugaresPlatica";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/altaPlaticaBD.do")
    public String insertarPlatica(@Valid Platica platica, BindingResult result) throws ParseException {
        //parametros se recben en el metodo
        //inyectar en lapagina
        //instanciar clase del modelo para hacer el calculo de los numeros
      //  Platica platica1 = new Platica();
//        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        String fecha1 = df.format(platica.getFecha());
//        String fecha2 = df.format(platica.getFechaMxFui());
//
//
//        platica1.setFecha(df.parse(fecha1));
//        platica1.setFecha(platica.getFecha());
//        platica1.setHora(platica.getHora());
//        platica1.setIdLugar(platica.getIdLugar());
//        
//        System.out.println(platica.getIdLugar());
//        
//        platica1.setPeriodo(platica.getPeriodo());
//        platica1.setAnio(platica.getAnio());
//        platica1.setDescripcion(platica.getDescripcion());
//        platica1.setTipo(platica.getTipo());
////        platica1.setId(platica.getId());
//        platica1.setStatus(platica.getStatus());
//        platica1.setFechaMxFui(platica.getFechaMxFui());
        //   platica1.setIdLugar(platica.getIdLugar());
//        if (result.hasErrors()) {
//            System.out.print("hubo errores");
//            System.out.println(result.hasFieldErrors("fecha"));
//            List<ObjectError> list = result.getAllErrors();
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i).getDefaultMessage());
//                System.out.println(list.get(i).getCode());
//                System.out.println(platica.getIdLugar());
//            }
//
//            return "/Platicas/altaPlatica";
//
//        } else {
            System.out.print("no hubo errores");
            LugaresPlatica lugaresPlatica= new LugaresPlatica();
            lugaresPlatica.setId(BigDecimal.valueOf(1));
            platica.setIdLugar(lugaresPlatica);
            platicaFacade.create(platica);
            //modelo.addAttribute("notificacion", "platica dada de alta correctamente");
            return "/Platicas/redirectAltaPlatica";
//    }


    }

    @RequestMapping(method = RequestMethod.GET, value = "/folioPlatica.do")
    public String folioPlatica(Model a) {


        return "/Platicas/reporte";
    }

    @RequestMapping(value = "asistencia.do", method = RequestMethod.POST)
    public String Asistencia(@Valid ValidacionAsistenciaPlatica folio, BindingResult result) {


        if (result.hasErrors()) {

            return "/Platicas/capturarAsistencia";

        } else {

            return "/Platicas/redirectAltaPlatica";
        }

    }
}
