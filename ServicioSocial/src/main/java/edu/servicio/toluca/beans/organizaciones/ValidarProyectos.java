/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.organizaciones;

import edu.servicio.toluca.entidades.Proyectos;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 *
 * @author ekt
 */
public class ValidarProyectos 
{
    public void valAltaAdminProy(Proyectos proyecto, BindingResult result, Model model, String codigo_postal){
        //Agregando errores
        if(codigo_postal.equals("") || codigo_postal.length() != 5){
            result.addError(new ObjectError("error_codigo_postal", "Ingrese un código postal válido."));
            model.addAttribute("error_codigo_postal", error("Ingrese un código postal válido."));
        }else if(proyecto.getVacantes().intValue()<proyecto.getVacantesDisponibles().intValue())
        {
            result.addError(new ObjectError("error_vacantes_disponibles", "Número de vacantes no puede ser mayor al número de vacantes disponibles."));
            model.addAttribute("error_vacantes_disponibles", error("Número de vacantes no puede ser mayor al número de vacantes disponibles."));
        }
        try{
            model.addAttribute("nombre", error(result.getFieldError("nombre").getDefaultMessage()));
        }catch(Exception e){
            System.out.println("No hubo error en el nombre");
        }
        try{
            model.addAttribute("vacantes", error(result.getFieldError("vacantes").getDefaultMessage()));
        }catch(Exception e){
            System.out.println("No hubo error en vacantes");
        }
        try{
            model.addAttribute("responsable", error(result.getFieldError("nombreResponsable").getDefaultMessage()));
        }catch(Exception e){
            System.out.println("No hubo error en responsable");
        }
        try{
            model.addAttribute("puesto", error(result.getFieldError("responsablePuesto").getDefaultMessage()));
        }catch(Exception e){
            System.out.println("No hubo error en puesto");
        }
        try{
            model.addAttribute("telefono", error(result.getFieldError("telefonoResponsable").getDefaultMessage()));
        }catch(Exception e){
            System.out.println("No hubo error en telefono");
        }
        try{
            model.addAttribute("domicilio", error(result.getFieldError("domicilio").getDefaultMessage()));
        }catch(Exception e){
            System.out.println("No hay error en domicilio");
        }
        
    }
    
    public String error(String error){
        return "<div class='alert alert-danger'>"+error+"</div>";
    }
}
