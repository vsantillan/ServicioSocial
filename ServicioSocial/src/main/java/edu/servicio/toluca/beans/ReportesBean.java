/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

/**
 * Bean para validar los reportes mensuales o bimestrales en el panel de usuario
 * @author bustedvillain
 */
public class ReportesBean {
    
    private String mensaje;
    private boolean accesoFormato;
    private int status;

    /**
     * Mensaje que se muestra al usuario sobre la situacion de sus reportes mensuales/bimestrales
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Mensaje que se muestra al usuario sobre la situacion de sus reportes mensuales/bimestrales
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Si puede entrar al formato bimestral/mensual
     * @return the accesoFormato
     */
    public boolean isAccesoFormato() {
        return accesoFormato;
    }

    /**
     * Indica si puede entrar al formato bimestral/mensual
     * @param accesoFormato the accesoFormato to set
     */
    public void setAccesoFormato(boolean accesoFormato) {
        this.accesoFormato = accesoFormato;
    }

    /**
     * Indica el status del proceso
     * 1. Paloma. 2. Tache. 3. Reloj
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Indica el status del proceso
     * 1. Paloma. 2. Tache. 3. Reloj
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
