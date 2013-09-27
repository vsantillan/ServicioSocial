/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

/**
 *
 * @author bustedvillain
 */
public class SesionBean {
    
    private String nControl;
    private String nombre;
    private String rol;
    private String pagReturn;
    private String mensaje;

    /**     * 
     * @return the nControl
     */
    public String getnControl() {
        return nControl;
    }

    /**
     * @param nControl the nControl to set
     */
    public void setnControl(String nControl) {
        this.nControl = nControl;
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

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * @return the pagReturn
     */
    public String getPagReturn() {
        return pagReturn;
    }

    /**
     * @param pagReturn the pagReturn to set
     */
    public void setPagReturn(String pagReturn) {
        this.pagReturn = pagReturn;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
