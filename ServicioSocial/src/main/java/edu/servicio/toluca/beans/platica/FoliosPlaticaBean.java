/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.platica;

/**
 *  Bean para validar acceso en el panel de usuario
 * @author bustedvillain
 */
public class FoliosPlaticaBean {
    
    private boolean tienePlatica;
    private boolean  accesoPanelPlatica;
    private String mensajeUsuario;

    /**
     * Variable que determina si el alumno asistio a la platica
     * @return the tienePlatica
     */
    public boolean isTienePlatica() {
        return tienePlatica;
    }

    /**
     * Se define la variable que determina si el alumno asistio a la platica o no
     * @param tienePlatica the tienePlatica to set
     */
    public void setTienePlatica(boolean tienePlatica) {
        this.tienePlatica = tienePlatica;
    }

    /**
     * Variable que determina si se le habilita el link para panel de platica o no al alumno
     * @return the accesoPanelPlatica
     */
    public boolean isAccesoPanelPlatica() {
        return accesoPanelPlatica;
    }

    /**
     * Se define la variable para determinar si se le hablilita el link para el panel de platica o no al alumno
     * @param accesoPanelPlatica the accesoPanelPlatica to set
     */
    public void setAccesoPanelPlatica(boolean accesoPanelPlatica) {
        this.accesoPanelPlatica = accesoPanelPlatica;
    }

    /**
     * @return the mensajeUsuario
     */
    public String getMensajeUsuario() {
        return mensajeUsuario;
    }

    /**
     * @param mensajeUsuario the mensajeUsuario to set
     */
    public void setMensajeUsuario(String mensajeUsuario) {
        this.mensajeUsuario = mensajeUsuario;
    }
}
