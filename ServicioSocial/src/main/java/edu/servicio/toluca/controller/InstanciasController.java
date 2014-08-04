/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.StringMD;
import edu.servicio.toluca.entidades.Colonia;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.TipoOrganizacion;
import edu.servicio.toluca.sesion.ColoniaFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.TipoOrganizacionFacade;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author giovanni
 */
@Controller
public class InstanciasController
{
    @EJB(mappedName = "java:global/ServicioSocial/TipoOrganizacionFacade")
    private TipoOrganizacionFacade tipoOrgFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/ColoniaFacade")
    private ColoniaFacade coloniaFacade;
    
    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
    private InstanciaFacade instanciaFacade;
    
    @RequestMapping( value="verificarinstancia.do", method=RequestMethod.GET )
    public String verificarInstancia(Model model)
    {
        return "/Instancias/verificarInstancia";
    }
    
    @RequestMapping( value="preregistrarinstancia.do", method=RequestMethod.GET)
    public String preregistro(Model model)
    {
        List<TipoOrganizacion> tiposOrg = tipoOrgFacade.findAll();
        Instancia nvaInstancia = new Instancia();
        nvaInstancia.setTipoOrganizacion(tiposOrg.get(0)); // Default in radio buttons
        
        model.addAttribute("tiposOrganizacion", tiposOrg);
        model.addAttribute("instancia", nvaInstancia);
        model.addAttribute("rfcError", "");
        
        return "/Instancias/preregistro";
    }
    
    @RequestMapping( value="preregistrarinstancia.do", method=RequestMethod.POST)
    public String preregistrar(Model model, @Valid Instancia instancia, 
            BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()) // Showing error in form
        {
            List<TipoOrganizacion> tiposOrg = tipoOrgFacade.findAll();
            model.addAttribute("tiposOrganizacion", tiposOrg);
            
            return "/Instancias/preregistro";
        }
        else
        {
            // Check if instance is yet registered
            List<Instancia> instancias = 
                    instanciaFacade.findBySpecificField("rfc", instancia.getRfc().toUpperCase(), "equal", null, null);
            if(instancias.size() > 0)
            {
                String rfcError = "<div class='alert alert-danger'>Este RFC ya está registrado</div>";
                List<TipoOrganizacion> tiposOrg = tipoOrgFacade.findAll();
                model.addAttribute("tiposOrganizacion", tiposOrg);
                model.addAttribute("rfcError", rfcError);

                return "/Instancias/preregistro";
            }
            else
            {
                // Configurar Entity y persistir
                Colonia col = coloniaFacade.find(instancia.getIdColonia().getIdColonia());
                instancia.setIdColonia(col);

                TipoOrganizacion tipoOrg = tipoOrgFacade.find(
                        instancia.getTipoOrganizacion().getIdTipoOrganizacion());
                instancia.setTipoOrganizacion(tipoOrg);

                instancia.setPassword(StringMD.getStringMessageDigest(
                        instancia.getPassword(), "SHA-1"));

                instancia.setEstatus(BigInteger.ZERO);
                instancia.setValidacionAdmin(BigInteger.ZERO);
                instancia.setUsuario(instancia.getCorreo());

                // To UpperCase
                instancia.setNombre(instancia.getNombre().toUpperCase());
                instancia.setRfc(instancia.getRfc().toUpperCase());
                instancia.setTitular(instancia.getTitular().toUpperCase());
                instancia.setPuesto(instancia.getPuesto().toUpperCase());

                instanciaFacade.create(instancia);

                return "/Instancias/preregistroexitoso";
            }
        }
    }
    
    @RequestMapping( value="buscarinstancias.do", method=RequestMethod.GET )
    public @ResponseBody List<HashMap> buscarInstancias(Model model, String field, String value)
    {
        List<Instancia> resultado = (field.equals("rfc")) ? 
                instanciaFacade.findBySpecificField("rfc", value, "like", null, null) : 
                instanciaFacade.findBySpecificField("nombre", value, "like", null, null);
        
        List<HashMap> instancias = new ArrayList<HashMap>();
        for(Instancia instancia : resultado)
        {
            HashMap mapa = new HashMap();
            mapa.put("nombre", instancia.getNombre());
            mapa.put("email", instancia.getCorreo());
            mapa.put("titular", instancia.getTitular());
            mapa.put("rfc", instancia.getRfc());
            
            instancias.add(mapa);
        }
        
        return instancias;
    }
    
}