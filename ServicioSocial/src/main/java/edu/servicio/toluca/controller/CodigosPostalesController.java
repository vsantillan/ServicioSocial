/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.EstadosJSON;

import edu.servicio.toluca.beans.LocalidadJSON;
import edu.servicio.toluca.beans.MetodosValidacion;
import edu.servicio.toluca.beans.organizaciones.CiudadesJSON;
import edu.servicio.toluca.beans.organizaciones.MunicipiosJSON;
import edu.servicio.toluca.entidades.Ciudades;
import edu.servicio.toluca.entidades.CodigosPostales;
import edu.servicio.toluca.entidades.Colonia;
import edu.servicio.toluca.entidades.EstadosSia;
import edu.servicio.toluca.entidades.MunicipiosSia;
import edu.servicio.toluca.entidades.TipoLocalidad;
import edu.servicio.toluca.sesion.CiudadesFacade;
import edu.servicio.toluca.sesion.CodigosPostalesFacade;
import edu.servicio.toluca.sesion.ColoniaFacade;
import edu.servicio.toluca.sesion.EstadosSiaFacade;
import edu.servicio.toluca.sesion.MunicipiosSiaFacade;
import edu.servicio.toluca.sesion.TipoLocalidadFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedHashMap;
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
    @EJB(mappedName = "java:global/ServicioSocial/ColoniaFacade")
    private ColoniaFacade coloniaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/CiudadesFacade")
    private CiudadesFacade ciudadesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/TipoLocalidadFacade")
    private TipoLocalidadFacade tipoLocalidadFacade;
    MetodosValidacion limpiar = new MetodosValidacion();

    @RequestMapping(method = RequestMethod.GET, value = "/cargarColonias.do")
    public @ResponseBody
    LocalidadJSON cargarColonias(Model model, String cp) {
        System.out.println("Controlador, recibe cp:" + cp);
//        BigDecimal bigDecimal = new BigDecimal(Integer.parseInt(cp));

        System.out.println("Comenzare el query buscando el codigo postal:" + cp);
        //Consulta codigo postal
        //model.addAttribute("codigoPostal", );


        //Fabricacion de objeto
        LocalidadJSON localidadJSON = new LocalidadJSON();
        try {
//            CodigosPostales codigosPostales = codigosPostalesFacade.find(Integer.parseInt(cp));
            List<CodigosPostales> codigosPostales = codigosPostalesFacade.findBySpecificField("cp", cp, "equal", null, null);

            ArrayList<Colonia> colonias = new ArrayList(codigosPostales.get(0).getColoniaCollection());
            for (int i = 0; i < colonias.size(); i++) {
                System.out.println("Colonia:" + colonias.get(i).getNombre() + " id:" + colonias.get(i).getIdColonia());
                localidadJSON.getIdColonia().add(colonias.get(i).getIdColonia() + "");
                localidadJSON.getNombreColonia().add(colonias.get(i).getNombre());
            }
            //localidadJSON.setColonias(coloniasTmp);
            try {
                localidadJSON.setCiudad(codigosPostales.get(0).getIdCiudad().getNombre());
            } catch (Exception e) {
                localidadJSON.setCiudad("No hay ciudades");
            }
            localidadJSON.setIdEstado(codigosPostales.get(0).getIdEstado().getIdEstado() + "");
            localidadJSON.setMunicipio(codigosPostales.get(0).getIdMunicipio().getNombre());
            localidadJSON.setIdMunicipio(codigosPostales.get(0).getIdMunicipio().getIdMunicipio() + "");
            //Operacion realizada con exito
            localidadJSON.setStatusJSON(true);
            System.out.println("Operacion con exito");
            return localidadJSON;
        } catch (Exception e) {
            //Error en consulta
            System.out.println("No existe este codigo postal");
            localidadJSON.setStatusJSON(false);
            return localidadJSON;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cargarEstados.do")
    public @ResponseBody
    EstadosJSON cargarEstados(Model model) {
        System.out.println("Cargar Estados controller");
        //Fabricacion de objeto
        EstadosJSON estadosJSON = new EstadosJSON();
        try {
            LinkedHashMap<String, String> ordering = new LinkedHashMap<String, String>();
            ordering.put("asc", "nombre");
            //List<EstadosSia> estados = estadosFacade.findBySpecificField(null, null, null, null, null);
            List<EstadosSia> estados = estadosFacade.findAll();
            for (int i = 0; i < estados.size(); i++) {
                estadosJSON.getIdEstados().add(estados.get(i).getIdEstado() + "");
                estadosJSON.getNombreEstados().add(estados.get(i).getNombre());
                System.out.println("Estado:" + estadosJSON.getNombreEstados().get(i));
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
    public @ResponseBody
    MunicipiosJSON cargarMunicipios(Model model, String idEstado) {
        System.out.println("Cargar Estados controller, idEstado:" + idEstado);
        //Fabricacion de objeto
        MunicipiosJSON municipiosJSON = new MunicipiosJSON();
        try {
            //Track tiempo
            Calendar ahora1 = Calendar.getInstance();
            long tiempo1 = ahora1.getTimeInMillis();

            //Consulta
            municipiosJSON = codigosPostalesFacade.municipiosEstado(idEstado);

            //Operacion realizada con exito
            municipiosJSON.setStatusJSON(true);
            Calendar ahora2 = Calendar.getInstance();
            long tiempo2 = ahora2.getTimeInMillis();
            long total = tiempo2 - tiempo1;
            System.out.println("Operacion con exito en " + total + "ms");
            return municipiosJSON;
        } catch (Exception e) {
            e.printStackTrace();
            //Error en consulta
            municipiosJSON.setStatusJSON(false);
            return municipiosJSON;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cargarCiudades.do")
    public @ResponseBody
    CiudadesJSON cargarCiudades(Model model, String idMunicipio) {
        System.out.println("Cargar Municipios controller, idMunicipio:" + idMunicipio);
        //Fabricacion de objeto
        CiudadesJSON ciudadesJSON = new CiudadesJSON();
        try {
            //Track tiempo
            Calendar ahora1 = Calendar.getInstance();
            long tiempo1 = ahora1.getTimeInMillis();

            //COnsulta
            ciudadesJSON = codigosPostalesFacade.ciudadMunicipio(idMunicipio);

            //Operacion realizada con exito
            ciudadesJSON.setStatusJSON(true);
            Calendar ahora2 = Calendar.getInstance();
            long tiempo2 = ahora2.getTimeInMillis();
            long total = tiempo2 - tiempo1;
            System.out.println("Operacion con exito en " + total + "ms");
            return ciudadesJSON;
        } catch (Exception e) {
            e.printStackTrace();
            //Error en consulta
            ciudadesJSON.setStatusJSON(false);
            return ciudadesJSON;
        }
    }

    //Alta de organizacion por pre-registro
    @RequestMapping(method = RequestMethod.GET, value = "/pruebaConsulta.do")
    public @ResponseBody
    void pruebaConsulta(Model model) {
        String idEstado = "15";
//        //Fabricacion de objeto
        MunicipiosJSON municipiosJSON = new MunicipiosJSON();
        try {
            //Track tiempo
            Calendar ahora1 = Calendar.getInstance();
            long tiempo1 = ahora1.getTimeInMillis();
            municipiosJSON = codigosPostalesFacade.municipiosEstado("15");

            //Operacion realizada con exito
            municipiosJSON.setStatusJSON(true);
            Calendar ahora2 = Calendar.getInstance();
            long tiempo2 = ahora2.getTimeInMillis();
            long total = tiempo2 - tiempo1;
            System.out.println("Operacion con exito en " + total + "ms");

        } catch (Exception e) {
            e.printStackTrace();
            //Error en consulta
            municipiosJSON.setStatusJSON(false);

        }

    }

    //ESTOS METODOS DEBERIA ESTAR EN EL MODELO, DADAS LAS CIRCUNSTANCIAS ESTARA AQUI TEMPORALMENTE
    //Agrega una colonia a un codigo postal
    @RequestMapping(method = RequestMethod.GET, value = "/agregaColonia.do")
    public Colonia agregaColonia(Model model, String codigo_postal, String otra_colonia) {
        try {
            System.out.println("AgregarColonia");
            System.out.println("codigo postal:" + codigo_postal.toString());
            List<CodigosPostales> codigosPostales = codigosPostalesFacade.findBySpecificField("cp", codigo_postal, "equal", null, null);
            CodigosPostales codigoPostal = codigosPostales.get(0);
            Colonia nvaColonia = new Colonia();
            otra_colonia = limpiar.tuneaStringParaBD(otra_colonia);
            nvaColonia.setNombre(otra_colonia);
            nvaColonia.setIdCp(codigoPostal);
            nvaColonia.setStatus(BigInteger.ONE);
            coloniaFacade.create(nvaColonia);

            //Obtenemos la ultima colonia
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("idColonia", "desc");
            Colonia colonia = coloniaFacade.findAll(ordenamiento).get(0);
            return colonia;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }

    public Colonia agregarCodigoPostal(String codigo_postal, String otra_colonia, String idEstado, String idMunicipio, String idCiudad) {

        try {
            EstadosSia estado = estadosFacade.find(BigDecimal.valueOf(Double.parseDouble(idEstado)));
            MunicipiosSia municipio = municipiosFacade.find(BigDecimal.valueOf(Double.parseDouble(idMunicipio)));
            TipoLocalidad localidad = tipoLocalidadFacade.find(BigDecimal.ONE);
            Ciudades ciudad = null;
            try {
                ciudad = ciudadesFacade.find(BigDecimal.valueOf(Double.parseDouble(idCiudad)));
            } catch (Exception e) {
                System.out.println("No tiene ciudad");
            }

            CodigosPostales codigoPostal = new CodigosPostales();
            codigoPostal.setCp(Integer.parseInt(codigo_postal));
            codigoPostal.setIdMunicipio(municipio);
            codigoPostal.setIdEstado(estado);
            codigoPostal.setIdTipoLocalidad(localidad);
            if (ciudad != null) {
                codigoPostal.setIdCiudad(ciudad);
            }
            codigosPostalesFacade.create(codigoPostal);

            //Obtenemos el Ultimo codigo postal
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("idCp", "desc");
            CodigosPostales codigoPostalNew = codigosPostalesFacade.findAll(ordenamiento).get(0);

            Colonia colonia = new Colonia();
            colonia.setIdCp(codigoPostal);
            otra_colonia = limpiar.tuneaStringParaBD(otra_colonia);
            colonia.setNombre(otra_colonia);
            colonia.setStatus(BigInteger.ONE);

            coloniaFacade.create(colonia);

            //Obtenemos la ultima colonia
            ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("idColonia", "desc");
            Colonia coloniaNew = coloniaFacade.findAll(ordenamiento).get(0);
            return coloniaNew;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return null;
        }


    }
}
