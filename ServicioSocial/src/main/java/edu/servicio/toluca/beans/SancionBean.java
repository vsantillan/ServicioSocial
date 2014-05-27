/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import java.util.Date;

/**
 * Bean para desplegar correctamente el detalle de sanciones y pagos de sancion en el panel de usuario
 * @author bustedvillain
 */
public class SancionBean {
    private  Date fecha;
    //deuda=0 o pago=1
    private int concepto;
    private String detalle;

    /**
     * Devuelve la fecha de la sancion o pago de sancion
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Asigna la fecha de la sancion o pago de la sancion
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Concepto de la sancion:
     * 0. Sancion
     * 1. Pago de sancion
     * @return the concepto
     */
    public int getConcepto() {
        return concepto;
    }

    /**
     * Concepto de la sancion:
     * 0. Sancion
     * 1. Pago de la sancion
     * @param concepto the concepto to set
     */
    public void setConcepto(int concepto) {
        this.concepto = concepto;
    }

    /**
     * Devuelve el concepto de la sancion
     * @return the detalle
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * Asigna el detalle de la sancion
     * @param detalle the detalle to set
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
