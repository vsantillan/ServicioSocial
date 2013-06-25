/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.EstadosJSON;
import edu.servicio.toluca.beans.LocalidadJSON;
import edu.servicio.toluca.entidades.CodigosPostales;
import edu.servicio.toluca.entidades.Colonia;
import edu.servicio.toluca.entidades.EstadosSia;
import edu.servicio.toluca.sesion.CodigosPostalesFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.MunicipiosSiaFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    
    @EJB(mappedName = "java:global/ServicioSocial/EstadosSiaFacade")
    private EstadosSiaFacade estadosFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/MunicipiosSiaFacade")
    private MunicipiosSiaFacade municipiosFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/cargarColonias.do")
    public @ResponseBody LocalidadJSON cargarColonias(Model model, String cp) {
        System.out.println("Controlador, recibe cp:" + cp);
//        BigDecimal bigDecimal = new BigDecimal(Integer.parseInt(cp));

        System.out.println("Comenzare el query buscando el codigo postal:" + cp);
        //Consulta codigo postal
        //model.addAttribute("codigoPostal", );
        System.out.println("Termine el query");

        //Fabricacion de objeto
        LocalidadJSON localidadJSON = new LocalidadJSON();
        try {
            CodigosPostales codigosPostales = codigosPostalesFacade.find(Integer.parseInt(cp));
            ArrayList<Colonia> colonias = new ArrayList(codigosPostales.getColoniaCollection());
            for (int i = 0; i < colonias.size(); i++) {
                System.out.println("Colonia:" + colonias.get(i).getNombre() + " id:" + colonias.get(i).getIdColonia());
                localidadJSON.getIdColonia().add(colonias.get(i).getIdColonia() + "");
                localidadJSON.getNombreColonia().add(colonias.get(i).getNombre());
            }
            //localidadJSON.setColonias(coloniasTmp);
            localidadJSON.setCiudad(codigosPostales.getIdCiudad().getNombre());
            localidadJSON.setIdEstado(codigosPostales.getIdEstado().getIdEstado()+"");
            localidadJSON.setMunicipio(codigosPostales.getIdMunicipio().getNombre());
            localidadJSON.setCiudad(codigosPostales.getIdCiudad().getNombre()+"");
            localidadJSON.setIdMunicipio(codigosPostales.getIdMunicipio().getIdMunicipio()+"");
            //Operacion realizada con exito
            localidadJSON.setStatusJSON(true);
            System.out.println("Operacion con exito");
            return localidadJSON;
        } catch (Exception e) {
            //Error en consulta
            localidadJSON.setStatusJSON(false);
            return localidadJSON;
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/cargarEstados.do")
    public @ResponseBody EstadosJSON cargarColonias(Model model) {
        System.out.println("Cargar Estados controller");
        //Fabricacion de objeto
        EstadosJSON estadosJSON = new EstadosJSON();
        try {
            List<EstadosSia> estados=estadosFacade.findAll();
            for (int i = 0; i < estados.size(); i++) {
                estadosJSON.getIdEstados().add(estados.get(i).getIdEstado()+"");
                estadosJSON.getNombreEstados().add(estados.get(i).getNombre());                
                System.out.println("Estado:"+estadosJSON.getNombreEstados().get(i));
            }
            System.out.println("Consulta exitosa");
            estadosJSON.setStatusJSON(true);
            return estadosJSON;
        } catch (Exception e) {
            estadosJSON.setStatusJSON(false);
            e.printStackTrace();
            //Error en consulta           
            return null;
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/cargarMunicipios.do")
    public @ResponseBody EstadosJSON cargarMunicipios(Model model, String idEstado) {
        System.out.println("Cargar Estados controller, idEstado:"+idEstado);
        //Fabricacion de objeto
        EstadosJSON estadosJSON = new EstadosJSON();
        try {
            List<EstadosSia> estados=estadosFacade.findAll();
            for (int i = 0; i < estados.size(); i++) {
                estadosJSON.getIdEstados().add(estados.get(i).getIdEstado()+"");
                estadosJSON.getNombreEstados().add(estados.get(i).getNombre());                
                System.out.println("Estado:"+estadosJSON.getNombreEstados().get(i));
            }
            System.out.println("Consulta exitosa");
            estadosJSON.setStatusJSON(true);
            return estadosJSON;
        } catch (Exception e) {
            estadosJSON.setStatusJSON(false);
            e.printStackTrace();
            //Error en consulta           
            return null;
        }
    }
}
