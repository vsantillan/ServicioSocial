/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import edu.servicio.toluca.entidades.Colonia;
import java.util.ArrayList;

/**
 *
 * @author bustedvillain
 */
public class LocalidadJSON {
    private ArrayList<String> nombreColonia = new ArrayList<String>();
    private ArrayList<String> idColonia = new ArrayList<String>();
    private String idEstado;    
    private String idMunicipio;
    private String municipio;
    private String idCiudad;
    private String ciudad;
    private boolean statusJSON;

    /**
     * @return the nombreColonia
     */
    public ArrayList<String> getNombreColonia() {
        return nombreColonia;
    }

    /**
     * @param nombreColonia the nombreColonia to set
     */
    public void setNombreColonia(ArrayList<String> nombreColonia) {
        this.nombreColonia = nombreColonia;
    }

    /**
     * @return the idColonia
     */
    public ArrayList<String> getIdColonia() {
        return idColonia;
    }

    /**
     * @param idColonia the idColonia to set
     */
    public void setIdColonia(ArrayList<String> idColonia) {
        this.idColonia = idColonia;
    }

    /**
     * @return the idEstado
     */
    public String getIdEstado() {
        return idEstado;
    }

    /**
     * @param idEstado the idEstado to set
     */
    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    /**
     * @return the idMunicipio
     */
    public String getIdMunicipio() {
        return idMunicipio;
    }

    /**
     * @param idMunicipio the idMunicipio to set
     */
    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * @return the idCiudad
     */
    public String getIdCiudad() {
        return idCiudad;
    }

    /**
     * @param idCiudad the idCiudad to set
     */
    public void setIdCiudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the statusJSON
     */
    public boolean isStatusJSON() {
        return statusJSON;
    }

    /**
     * @param statusJSON the statusJSON to set
     */
    public void setStatusJSON(boolean statusJSON) {
        this.statusJSON = statusJSON;
    }

}
