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
public class PerfilJSON {
    
    private ArrayList<String> nombre = new ArrayList<String>();
    private ArrayList<String> idPerfil= new ArrayList<String>();

    /**
     * @return the nombre
     */
    public ArrayList<String> getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(ArrayList<String> nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the idPerfil
     */
    public ArrayList<String> getIdPerfil() {
        return idPerfil;
    }

    /**
     * @param idPerfil the idPerfil to set
     */
    public void setIdPerfil(ArrayList<String> idPerfil) {
        this.idPerfil = idPerfil;
    }
    
}
