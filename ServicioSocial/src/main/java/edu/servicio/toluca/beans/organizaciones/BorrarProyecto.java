/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.organizaciones;

/**
 *
 * @author ekt
 */
public class BorrarProyecto 
{
    private String nombreProyecto;
    private String nombreInstancia;
    private String email;
    private String descripcion;

    /**
     * @return the nombreProyecto
     */
    public String getNombreProyecto() {
        return nombreProyecto;
    }

    /**
     * @param nombreProyecto the nombreProyecto to set
     */
    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    /**
     * @return the nombreInstancia
     */
    public String getNombreInstancia() {
        return nombreInstancia;
    }

    /**
     * @param nombreInstancia the nombreInstancia to set
     */
    public void setNombreInstancia(String nombreInstancia) {
        this.nombreInstancia = nombreInstancia;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
