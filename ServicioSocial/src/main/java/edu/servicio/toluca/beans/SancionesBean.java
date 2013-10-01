/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

/**
 *
 * @author bustedvillain
 */
public class SancionesBean {

    private String mensaje = "";
    private int horasSancion = 0;
    private boolean tieneSancion;

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

    /**
     * @return the horasSancion
     */
    public int getHorasSancion() {
        return horasSancion;
    }

    /**
     * @param horasSancion the horasSancion to set
     */
    public void setHorasSancion(int horasSancion) {
        this.horasSancion = horasSancion;
    }

    public void sumaHoras(int horas) {
        horasSancion += horas;
    }

    /**
     * @return the tieneSancion
     */
    public boolean isTieneSancion() {
        return tieneSancion;
    }

    /**
     * @param tieneSancion the tieneSancion to set
     */
    public void setTieneSancion(boolean tieneSancion) {
        this.tieneSancion = tieneSancion;
    }
}
