/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import edu.servicio.toluca.entidades.Platica;

/**
 *
 * @author mary
 */
public class ValidacionPlatica implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {

        return Platica.class.isAssignableFrom(clazz);

    }
     public
void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fecha", "fecha.required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hora", "hora.required");

        ValidationUtils.rejectIfEmpty(errors, "lugar", "lugar.required");

        ValidationUtils.rejectIfEmpty(errors, "fechaMxFui", "fechaMxFui.required");

        

//        Platica platica = (Platica) target;
//
//        if(platica.getComunidad().length == 0)
//
//        {
//
//            errors.rejectValue("comunidad","comunidad.required");
//
//        }

    }
}
