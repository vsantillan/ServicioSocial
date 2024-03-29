/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import java.io.Serializable;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Héctor
 */

public class Contacto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    
    @NotEmpty(message = "Escribe tu mensaje")
    private String detalle;
    
   
    @NotEmpty(message = "Escribe un Asunto") 
    private String asunto;
    
    
    @NotEmpty(message = "Escribe un Correo") 
    @Email(message = "Formato de un correo: usuario@compañia.com")
    private String correo;
    
    
    @NotEmpty(message = "Escribe tu Nombre") 
    private String nombre;

    public Contacto() 
    {
        
    }

    
    /**
     * @return the detalle
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
