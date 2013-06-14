/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;
import edu.servicio.toluca.beans.Fecha;
import edu.servicio.toluca.entidades.Platica;
import edu.servicio.toluca.sesion.PlaticaFacade;
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
        Fecha anio= new Fecha ();
        modelo.addAttribute("anioInicio",anio.anioActual());
        modelo.addAttribute("anioFin",anio.anioFin());
        return "/Platicas/altaPlatica";
    }

   @RequestMapping(method = RequestMethod.GET, value = "/consultasBajas.do")
    public String consultasBajas(Model model) {
       Platica platica = new Platica();
//       platica.setAnio("2015");
//       platica.setFecha(new Date("20/05/2013"));
//       platica.setFechaMxFui(new Date("25/05/2013"));
//       platica.setHora("05:00");
       platica.setId(2L);
//       platica.setLugar("Edificio kkkkkk");
//       platica.setNumeroAsistentes(200);
//       platica.setPeriodo("Ago-Diciembre!");
//       platica.setStatus((short)2);
//       platica.setTipo((short)2);
      
       
       System.out.println("Conteo de registros Platica:"+platicaFacade.count()); 
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
      
}
