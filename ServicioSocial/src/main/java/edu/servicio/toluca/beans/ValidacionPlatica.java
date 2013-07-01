/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import edu.servicio.toluca.entidades.Platica;
import org.springframework.stereotype.Component;

/**
 *
 * @author mary
 */
@Component
public class ValidacionPlatica implements Validator {

    @Override
   public boolean supports(Class clazz) {
      return Platica.class.isAssignableFrom(clazz);
   }

   @Override
   public void validate(Object target, Errors errors) {
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "Enter firstname.");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "Enter surname.");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Enter login.");

   }

}
