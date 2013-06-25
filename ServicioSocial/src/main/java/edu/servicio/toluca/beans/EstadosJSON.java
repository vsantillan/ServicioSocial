/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import edu.servicio.toluca.entidades.EstadosSia;
import java.util.ArrayList;

/**
 *
 * @author bustedvillain
 */
public class EstadosJSON {
    
    private boolean statusJSON;
    private ArrayList<String> nombreEstados = new ArrayList<String>();
    private ArrayList<String> idEstados= new ArrayList<String>();

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

    /**
     * @return the nombreEstados
     */
    public ArrayList<String> getNombreEstados() {
        return nombreEstados;
    }

    /**
     * @param nombreEstados the nombreEstados to set
     */
    public void setNombreEstados(ArrayList<String> nombreEstados) {
        this.nombreEstados = nombreEstados;
    }

    /**
     * @return the idEstados
     */
    public ArrayList<String> getIdEstados() {
        return idEstados;
    }

    /**
     * @param idEstados the idEstados to set
     */
    public void setIdEstados(ArrayList<String> idEstados) {
        this.idEstados = idEstados;
    }

    
}
