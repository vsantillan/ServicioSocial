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
    private String estado;
    private String municipio;
    private String ciudad;

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
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
}
