/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

/**
 *Bean para validar el acceso del alumno a reportes finales desde
 * el panel del usuario
 * @author bustedvillain
 */
public class ReportesFinalesBean {
    
    private boolean puedeAccesar;
    private String mensaje;
    private int status;

    /**
     * Si puede o no accesar el alumno a reportes finales desde el panel de usuario
     * @return the puedeAccesar
     */
    public boolean isPuedeAccesar() {
        return puedeAccesar;
    }

    /**
     * Asigna si puede el alumno accesar o no a reportes finales desde e panel de usuario
     * @param puedeAccesar the puedeAccesar to set
     */
    public void setPuedeAccesar(boolean puedeAccesar) {
        this.puedeAccesar = puedeAccesar;
    }

    /**
     * El mensaje que se le muestra sobre los reportes finales
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Asigna el mensaje que se le muestra al alumno sobre los reportes finles
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Obtniene el estatus de este proceso
     * 1. Paloma. 2. Tache. 3. Reloj. 4. Aceptado pero queda pendiente algo
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Asigna el estatus de este proceso
     * 1. Paloma. 2 Tache. 3.Reloj. 4. Aceptado pero queda pendiente algo
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
    
}
