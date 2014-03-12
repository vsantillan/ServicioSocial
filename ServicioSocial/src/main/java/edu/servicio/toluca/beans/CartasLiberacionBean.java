/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

/**
 *
 * @author Regules
 */
public class CartasLiberacionBean 
{
    private int idDatosPer;
    private String noControl;
    private String nombreCompleto;
    private int seEntrego;//no funciona por el momento
    private int horasAcumuladas;
    

    public CartasLiberacionBean(){}
    /**
     * @return the idDatosPer
     */
    public int getIdDatosPer() {
        return idDatosPer;
    }

    /**
     * @param idDatosPer the idDatosPer to set
     */
    public void setIdDatosPer(int idDatosPer) {
        this.idDatosPer = idDatosPer;
    }

    /**
     * @return the noControl
     */
    public String getNoControl() {
        return noControl;
    }

    /**
     * @param noControl the noControl to set
     */
    public void setNoControl(String noControl) {
        this.noControl = noControl;
    }

    /**
     * @return the NombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the NombreCompleto to set
     */
    public void setNombreCompleto(String NombreCompleto) {
        this.nombreCompleto = NombreCompleto;
    }

    /**
     * @return the seEntrego
     */
    public int getSeEntrego() {
        return seEntrego;
    }

    /**
     * @param seEntrego the seEntrego to set
     */
    public void setSeEntrego(int seEntrego) {
        this.seEntrego = seEntrego;
    }

    /**
     * @return the horasAcumuladas
     */
    public int getHorasAcumuladas() {
        return horasAcumuladas;
    }

    /**
     * @param horasAcumuladas the horasAcumuladas to set
     */
    public void setHorasAcumuladas(int horasAcumuladas) {
        this.horasAcumuladas = horasAcumuladas;
    }
}
