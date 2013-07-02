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
public class FormatoUnicoHorariosValidaciones implements Validator{
    
    @Override
    public boolean supports(Class<?> type) {
        return FormatoUnicoHorariosBean.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        FormatoUnicoHorariosBean datosPersonales = (FormatoUnicoHorariosBean) o;
        
        
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidoP","El apellido paterno es obligatorio");
        
       
        
    }
    
    
    private void  validarHorario(Errors errors,String horaInicio,String horaFin)
    {
        if( !horaInicio.matches(""))
        {
            return;
        }
        if(!horaFin.matches(""))
        {
            return;
        }
        
        
        
    }
}
