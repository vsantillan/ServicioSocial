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
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre","El nombre es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre","El nombre es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre","El nombre es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre","El nombre es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre","El nombre es obligatorio");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre","El nombre es obligatorio");
        
    }
    
}
