/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import java.util.Date;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
/**
 *
 * @author mary
 */

public class PlaticaBean {
   
    @NotBlank
    private String fecha;
    @NotEmpty
    private String hora;
    @NotEmpty
    private String lugar;
   
   
  
    @NotBlank
    private String fechaMxFui;
    
    private String descripcion;


    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.setFecha(fecha);
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

 



 

  

    /**
     * @return the fechaMxFui
     */
    public String getFechaMxFui() {
        return fechaMxFui;
    }

    /**
     * @param fechaMxFui the fechaMxFui to set
     */
    public void setFechaMxFui(String fechaMxFui) {
        this.setFechaMxFui(fechaMxFui);
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    
}
