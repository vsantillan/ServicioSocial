/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import java.util.ArrayList;

/**
 *
 * @author bustedvillain
 */
public class MunicipiosJSON {
    
    private ArrayList<String> municipios = new ArrayList<String>();
    private ArrayList<String> idMunicipios = new ArrayList<String>();
    private boolean statusJSON;

    /**
     * @return the municipios
     */
    public ArrayList<String> getMunicipios() {
        return municipios;
    }

    /**
     * @param municipios the municipios to set
     */
    public void setMunicipios(ArrayList<String> municipios) {
        this.municipios = municipios;
    }

    /**
     * @return the idMunicipios
     */
    public ArrayList<String> getIdMunicipios() {
        return idMunicipios;
    }

    /**
     * @param idMunicipios the idMunicipios to set
     */
    public void setIdMunicipios(ArrayList<String> idMunicipios) {
        this.idMunicipios = idMunicipios;
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
