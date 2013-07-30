/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.formatoUnico;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author SATELLITE
 */
public class FormatoUnicoProyectosJSON {
    private ArrayList<BigDecimal> id_proyecto;
    private ArrayList<BigDecimal> id_instancia;
    private ArrayList<String> domicilio;
    private ArrayList<Long> telefono_responsable;
    private ArrayList<String> nombre_responsable;

    /**
     * @return the id_proyecto
     */
    public ArrayList<BigDecimal> getId_proyecto() {
        return id_proyecto;
    }

    /**
     * @param id_proyecto the id_proyecto to set
     */
    public void setId_proyecto(ArrayList<BigDecimal> id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    /**
     * @return the id_instancia
     */
    public ArrayList<BigDecimal> getId_instancia() {
        return id_instancia;
    }

    /**
     * @param id_instancia the id_instancia to set
     */
    public void setId_instancia(ArrayList<BigDecimal> id_instancia) {
        this.id_instancia = id_instancia;
    }

    /**
     * @return the domicilio
     */
    public ArrayList<String> getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(ArrayList<String> domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the telefono_responsable
     */
    public ArrayList<Long> getTelefono_responsable() {
        return telefono_responsable;
    }

    /**
     * @param telefono_responsable the telefono_responsable to set
     */
    public void setTelefono_responsable(ArrayList<Long> telefono_responsable) {
        this.telefono_responsable = telefono_responsable;
    }

    /**
     * @return the nombre_responsable
     */
    public ArrayList<String> getNombre_responsable() {
        return nombre_responsable;
    }

    /**
     * @param nombre_responsable the nombre_responsable to set
     */
    public void setNombre_responsable(ArrayList<String> nombre_responsable) {
        this.nombre_responsable = nombre_responsable;
    }
    
    
}
