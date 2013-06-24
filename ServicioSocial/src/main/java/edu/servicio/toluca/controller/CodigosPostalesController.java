/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.LocalidadJSON;
import edu.servicio.toluca.entidades.CodigosPostales;
import edu.servicio.toluca.entidades.Colonia;
import edu.servicio.toluca.sesion.CodigosPostalesFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author bustedvillain
 */
@Controller
public class CodigosPostalesController {

    @EJB(mappedName = "java:global/ServicioSocial/CodigosPostalesFacade")
    private CodigosPostalesFacade codigosPostalesFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/cargarColonias.do")
    public @ResponseBody
    LocalidadJSON cargarColonias(Model model, String cp, BindingResult result) {
        System.out.println("Controlador, recibe cp:" + cp);
//        BigDecimal bigDecimal = new BigDecimal(Integer.parseInt(cp));

        System.out.println("Comenzare el query buscando el codigo postal:" + cp);
        //Consulta codigo postal
        //model.addAttribute("codigoPostal", );
        System.out.println("Termine el query");

        //Fabricacion de objeto
        LocalidadJSON localidadJSON = new LocalidadJSON();
        CodigosPostales codigosPostales = codigosPostalesFacade.find(Integer.parseInt(cp));
        ArrayList<Colonia> colonias = new ArrayList(codigosPostales.getColoniaCollection());
        for (int i = 0; i < colonias.size(); i++) {
            System.out.println("Colonia:" + colonias.get(i).getNombre() + " id:" + colonias.get(i).getIdColonia());
            localidadJSON.getIdColonia().add(colonias.get(i).getIdColonia() + "");
            localidadJSON.getNombreColonia().add(colonias.get(i).getNombre());
        }
        //localidadJSON.setColonias(coloniasTmp);
        localidadJSON.setCiudad(codigosPostales.getIdCiudad().getNombre());
        localidadJSON.setEstado(codigosPostales.getIdEstado().getNombre());
        localidadJSON.setMunicipio(codigosPostales.getIdMunicipio().getNombre());

        
        return localidadJSON;
    }
}
