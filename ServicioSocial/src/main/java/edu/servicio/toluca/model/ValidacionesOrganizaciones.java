/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model;

import edu.servicio.toluca.beans.organizaciones.PropAluInstProyBean;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.Proyectos;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 *
 * @author bustedvillain
 */
public class ValidacionesOrganizaciones {

    //Valida ciertos campos en el alta de una instancia
    public void valGdaAltaInst(Instancia instancia, BindingResult result, Model model, String codigo_postal, String otra_colonia, String existe_colonia, String confirma_password) {
        //Valida contraseñas
        if (confirma_password.equals("")) {
            result.addError(new ObjectError("confirma_passowrd", "Confirmación de contraseña vacía."));
            model.addAttribute("confirma_password", error("Confirmación de contraseña vacía"));
        } else {
            if (!confirma_password.equals(instancia.getPassword())) {
                result.addError(new ObjectError("confirma_passowrd", "Las contraseñas no coinciden"));
                model.addAttribute("confirma_password", error("Las contraseñas no coinciden"));
            }
        }
        //Valida otros datos
        if (codigo_postal.equals("")) {
            result.addError(new ObjectError("codigo_postal", "Código postal vacío."));
            model.addAttribute("codigo_postal", error("Código postal vacío."));
        } else {
            if (codigo_postal.length() != 5) {
                result.addError(new ObjectError("codigo_postal", "Código postal incorrecto."));
                model.addAttribute("codigo_postal", error("Código postal incorrecto."));
            }
        }
        if (instancia.getUsuario().equals("")) {
            result.addError(new ObjectError("usuario", "Campo de usuario vacío."));
            model.addAttribute("usuario", error("Campo de usuario vacío."));
        }
        if (instancia.getCorreo().equals("")) {
            result.addError(new ObjectError("correo", "Campo de correo vacío."));
            model.addAttribute("correo", error("Campo de correo vacío."));
        }
        if (instancia.getPassword().equals("")) {
            result.addError(new ObjectError("password", "Contraseña vacía."));
            model.addAttribute("password", error("Contraseña vacía."));
        }

    }
    //Validacion cuando una organizacion edita su informacion
    public void valGdaEditaInst(Instancia instancia, BindingResult result, Model model, String codigo_postal, String otra_colonia, String existe_colonia, String confirma_password) {
        //Valida contraseñas
        if (!instancia.getPassword().equals("")) {
            if (confirma_password.equals("")) {
                result.addError(new ObjectError("confirma_passowrd", "Confirmación de contraseña vacía."));
                model.addAttribute("confirma_password", error("Confirmación de contraseña vacía"));
            } else {
                if (!confirma_password.equals(instancia.getPassword())) {
                    result.addError(new ObjectError("confirma_passowrd", "Las contraseñas no coinciden"));
                    model.addAttribute("confirma_password", error("Las contraseñas no coinciden"));
                }
            }
        }
        //Valida otros datos
        if (codigo_postal.equals("")) {
            result.addError(new ObjectError("codigo_postal", "Código postal vacío."));
            model.addAttribute("codigo_postal", error("Código postal vacío."));
        } else {
            if (codigo_postal.length() != 5) {
                result.addError(new ObjectError("codigo_postal", "Código postal incorrecto."));
                model.addAttribute("codigo_postal", error("Código postal incorrecto."));
            }
        }
        if (instancia.getUsuario().equals("")) {
            result.addError(new ObjectError("usuario", "Campo de usuario vacío."));
            model.addAttribute("usuario", error("Campo de usuario vacío."));
        }
        if (instancia.getCorreo().equals("")) {
            result.addError(new ObjectError("correo", "Campo de correo vacío."));
            model.addAttribute("correo", error("Campo de correo vacío."));
        }

    }

    public void valAltaAdminInst(Instancia instancia, BindingResult result, Model model, String codigo_postal) {
        if (codigo_postal.equals("")) {
            result.addError(new ObjectError("codigo_postal", "Código postal vacío."));
            model.addAttribute("error_codigo_postal", error("Código postal vacío."));
        } else {
            if (codigo_postal.length() != 5) {
                result.addError(new ObjectError("codigo_postal", "Código postal incorrecto."));
                model.addAttribute("error_codigo_postal", error("Código postal incorrecto."));
            }
        }
    }

    public void valAltaAdminProy(Proyectos proyecto, BindingResult result, Model model, String codigo_postal) {
        //Agregando errores
        if (codigo_postal.equals("") || codigo_postal.length() != 5) {
            result.addError(new ObjectError("error_codigo_postal", "Ingrese un código postal válido."));
            model.addAttribute("error_codigo_postal", error("Ingrese un código postal válido."));
        }
        try {
            model.addAttribute("nombre", error(result.getFieldError("nombre").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hubo error en el nombre");
        }
        try {
            model.addAttribute("vacantes", error(result.getFieldError("vacantes").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hubo error en vacantes");
        }
        try {
            model.addAttribute("responsable", error(result.getFieldError("nombreResponsable").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hubo error en responsable");
        }
        try {
            model.addAttribute("puesto", error(result.getFieldError("responsablePuesto").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hubo error en puesto");
        }
        try {
            model.addAttribute("telefono", error(result.getFieldError("telefonoResponsable").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hubo error en telefono");
        }
        try {
            model.addAttribute("domicilio", error(result.getFieldError("domicilio").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hay error en domicilio");
        }

    }
    
    public void valPropAlInstancia(PropAluInstProyBean propuesta, BindingResult result, Model model, String codigo_postal, String otra_colonia, String existe_colonia, String selectfrom, String cadenaActividades, String codigo_postal2, String formato_unico){
        //Agregando errores
        if (codigo_postal.equals("") || codigo_postal.length() != 5) {
            result.addError(new ObjectError("error_codigo_postal", "Ingrese un código postal válido."));
            model.addAttribute("error_codigo_postal1", error("Ingrese un código postal válido."));
        }
        if (codigo_postal2.equals("") || codigo_postal2.length() != 5) {
            result.addError(new ObjectError("error_codigo_postal2", "Ingrese un código postal válido."));
            model.addAttribute("error_codigo_postal2", error("Ingrese un código postal válido."));
        }
        //Validacion instancia
        try {
            model.addAttribute("nombre_instancia", error(result.getFieldError("nombre_instancia").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hubo error en el nombre instancia");
        }
        try {
            model.addAttribute("domicilio_instancia", error(result.getFieldError("domicilio_instancia").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hubo error en el nombre");
        }
        try {
            model.addAttribute("titular", error(result.getFieldError("titular").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hubo error en el nombre");
        }
        try {
            model.addAttribute("puesto_titular", error(result.getFieldError("puesto_titular").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hubo error en el nombre");
        }
        try {
            model.addAttribute("telefono_titular", error(result.getFieldError("telefono_titular").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hubo error en el nombre");
        }
        try {
            model.addAttribute("rfc", error(result.getFieldError("rfc").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hubo error en el nombre");
        }
        //Validacion proyecto
        try {
            model.addAttribute("nombre_proyecto", error(result.getFieldError("nombre_proyecto").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hubo error en el nombre");
        }
        try {
            model.addAttribute("vacantes", error(result.getFieldError("vacantes").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hubo error en vacantes");
        }
        try {
            model.addAttribute("nombreResponsable", error(result.getFieldError("nombreResponsable").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hubo error en responsable");
        }
        try {
            model.addAttribute("responsablePuesto", error(result.getFieldError("responsablePuesto").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hubo error en puesto");
        }
        try {
            model.addAttribute("telefono_responsable", error(result.getFieldError("telefonoResponsable").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hubo error en telefono");
        }
        try {
            model.addAttribute("domicilio_proyecto", error(result.getFieldError("domicilio_proyecto").getDefaultMessage()));
        } catch (Exception e) {
            System.out.println("No hay error en domicilio");
        }
    }

    public String error(String error) {
        return "<div class='error'>" + error + "</div>";
    }
}
