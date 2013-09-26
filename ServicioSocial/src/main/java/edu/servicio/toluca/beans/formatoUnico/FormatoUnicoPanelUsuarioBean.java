/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.formatoUnico;

/**
 *
 * @author bustedvillain
 */
public class FormatoUnicoPanelUsuarioBean {
    
    private String mensaje;
    private boolean accesoFormatoUnico;
    private int statusFui;

    /**
     * Mensaje que se muestra al usuario sobre la situacion de su formato unico
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
     * Si puede entrar al formato unico
     * @return the accesoFormatoUnico
     */
    public boolean isAccesoFormatoUnico() {
        return accesoFormatoUnico;
    }

    /**
     * @param accesoFormatoUnico the accesoFormatoUnico to set
     */
    public void setAccesoFormatoUnico(boolean accesoFormatoUnico) {
        this.accesoFormatoUnico = accesoFormatoUnico;
    }

    /**
     * Estatus sobre el formato unico para saber el icono que se muestra en el panel de usuario
     * 1. Paloma, 2. Tache, 3. Reloj
     * @return the statusFui
     */
    public int getStatusFui() {
        return statusFui;
    }

    /**
     * * Estatus sobre el formato unico para saber el icono que se muestra en el panel de usuario
     * 1. Paloma, 2. Tache, 3. Reloj
     * @param statusFui the statusFui to set
     */
    public void setStatusFui(int statusFui) {
        this.statusFui = statusFui;
    }
    
}
