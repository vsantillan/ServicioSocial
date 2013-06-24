/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.sesion.CodigosPostalesFacade;
import java.math.BigDecimal;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author bustedvillain
 */
@Controller
public class CodigosPostalesController {

    @EJB(mappedName = "java:global/ServicioSocial/CodigosPostalesFacade")
    private CodigosPostalesFacade codigosPostalesFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/cargarColonias.do")
    public String cargarColonias(Model model, String cp) {
        System.out.println("Controlador, recibe cp:"+cp);
//        BigDecimal bigDecimal = new BigDecimal(Integer.parseInt(cp));
        
        System.out.println("Comenzare el query buscando el codigo postal:"+cp);        
        //Consulta codigo postal
        model.addAttribute("codigoPostal", codigosPostalesFacade.find(Integer.parseInt(cp)));
        System.out.println("Termine el query");
        return "/CodigosPostales/cargarColonias";
    }
}
