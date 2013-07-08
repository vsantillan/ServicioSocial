/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//Convierte un String a un objeto de tipo Colonia
package edu.servicio.toluca.model;

import edu.servicio.toluca.sesion.ColoniaFacade;
import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import javax.ejb.EJB;

/**
 *
 * @author bustedvillain
 */
public class ColoniaEditor extends PropertyEditorSupport{
    
    @EJB(mappedName = "java:global/ServicioSocial/ColoniaFacade")
    private ColoniaFacade coloniaFacade;
    
    public void setAsText(String text){
        System.out.println("setAsText Colonia Editor");
        setValue(coloniaFacade.find(BigDecimal.valueOf(Double.parseDouble(text))));
    }
    
}
