/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Héctor
 */
public class FormatoUnicoDatosPersoValidaciones implements Validator
{

    @Override
    public boolean supports(Class<?> type) {
        return FormatoUnicoDatosPersonalesBean.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        FormatoUnicoDatosPersonalesBean datosPersonales = (FormatoUnicoDatosPersonalesBean) o;
        
        
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidoP","El apellido paterno es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidoM","El apellido materno es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sexo","El sexo es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "estado_civil","El Estado Civil es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ocupacion","El Ocupacion es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "curp","El CURP es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "folioDocIdentificacion","El Folio de Documento de Identificación es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "claveDocIdentificacion","La Clave de Documento de Identificaión nombre es obligatorio");
        
        
      
        
        
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "acuerdoC","El nombre es obligatorio");
        //Preguntar a nava si esto es correcto.
        
        
    }
    
}
