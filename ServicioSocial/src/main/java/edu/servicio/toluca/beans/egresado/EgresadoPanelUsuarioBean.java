/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.egresado;

/**
 *  Bean para validar cuando entra un egresado al panel de usuario que no ha hecho su carta de motivos
 * @author JoséManuel
 */
public class EgresadoPanelUsuarioBean {
    
    private boolean accesoCartaMotivos;
    private String mensajeCartaMotivos;
    private int statusCartaMotivos;

    /**
     * Si puede accesar a la carta de motivos
     * @return the accesoCartaMotivos
     */
    public boolean isAccesoCartaMotivos() {
        return accesoCartaMotivos;
    }

    /**
     * Si puede accesar a la carta de motivos
     * @param accesoCartaMotivos the accesoCartaMotivos to set
     */
    public void setAccesoCartaMotivos(boolean accesoCartaMotivos) {
        this.accesoCartaMotivos = accesoCartaMotivos;
    }

    /**
     * El mensaje sobre su carta de motivos
     * @return the mensajeCartaMotivos
     */
    public String getMensajeCartaMotivos() {
        return mensajeCartaMotivos;
    }

    /**
     * El mensaje sobre su carta de motivos
     * @param mensajeCartaMotivos the mensajeCartaMotivos to set
     */
    public void setMensajeCartaMotivos(String mensajeCartaMotivos) {
        this.mensajeCartaMotivos = mensajeCartaMotivos;
    }

    /**
     * Status para el icono que se le pondra sobre su carta de motivos
     * 1: Paloma, 2. Tache, 3. Reloj
     * @return the statusCartaMotivos
     */
    public int getStatusCartaMotivos() {
        return statusCartaMotivos;
    }

    /**
     * Status para el icono que se le pondra sobre su carta de motivos
     * 1: Paloma, 2.Tache, 3. Reloj
     * @param statusCartaMotivos the statusCartaMotivos to set
     */
    public void setStatusCartaMotivos(int statusCartaMotivos) {
        this.statusCartaMotivos = statusCartaMotivos;
    }
    
}
