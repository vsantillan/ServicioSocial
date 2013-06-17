/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.Fecha;
import edu.servicio.toluca.entidades.Platica;
import edu.servicio.toluca.sesion.PlaticaFacade;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jonny
 */
@Controller
public class PlaticaController {

    @EJB(mappedName = "java:global/ServicioSocial/PlaticaFacade")
    private PlaticaFacade platicaFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/altaPlatica.do")
    public String altaPlatica(Model modelo) {
        Fecha anio = new Fecha();
        modelo.addAttribute("anioInicio", anio.anioActual());
        modelo.addAttribute("anioFin", anio.anioFin());
        modelo.addAttribute("platica", new Platica());
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
        model.addAttribute("platica", platicaFacade.findAll());
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

    @RequestMapping(method = RequestMethod.POST, value = "/altaPlaticaBD.do")
    public String insertarPlatica(Platica platica, Model modelo) throws ParseException {
        //parametros se recben en el metodo
        //inyectar en lapagina
        //instanciar clase del modelo para hacer el calculo de los numeros
//        Platica platica1 = new Platica();
//        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        String fecha1 = df.format(platica.getFecha());
//        String fecha2 = df.format(platica.getFechaMxFui());
//
//
//        platica1.setFecha(df.parse(fecha1));
//        platica1.setHora(platica.getHora());
//        platica1.setLugar(platica.getLugar());
//        platica1.setPeriodo(platica.getPeriodo());
//        platica1.setAnio(platica.getAnio());
//        platica1.setDescripcion(platica.getDescripcion());
//        platica1.setTipo(platica.getTipo());
//        platica1.setId(platica.getId());
//        platica1.setStatus((short) 1);
//        platica1.setFechaMxFui(df.parse(fecha2));



        platicaFacade.create(platica);
       
        //  System.out.println("nombres es"+datos.getNombre());
        modelo.addAttribute("notificacion", "platica dada de alta correctamente");
        return "/Platicas/altaPlatica";
    }
}
