/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.organizaciones;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author bustedvillain
 */
public class CiudadesJSON {

    private ArrayList<String> ciudades = new ArrayList<String>();
    private ArrayList<String> idCiudades = new ArrayList<String>();
    private boolean statusJSON;

    public void agregarCiudad(String idCiudad, String ciudad) {
        getCiudades().add(ciudad);
        getIdCiudades().add(idCiudad);

    }

    public boolean checarUnique(String idCiudad) {
        for (int i = 0; i < getIdCiudades().size(); i++) {
            if (getIdCiudades().get(i).equals(idCiudad)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return the ciudades
     */
    public ArrayList<String> getCiudades() {
        return ciudades;
    }

    /**
     * @param ciudades the ciudades to set
     */
    public void setCiudades(ArrayList<String> ciudades) {
        this.ciudades = ciudades;
    }

    /**
     * @return the idCiudades
     */
    public ArrayList<String> getIdCiudades() {
        return idCiudades;
    }

    /**
     * @param idCiudades the idCiudades to set
     */
    public void setIdCiudades(ArrayList<String> idCiudades) {
        this.idCiudades = idCiudades;
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
