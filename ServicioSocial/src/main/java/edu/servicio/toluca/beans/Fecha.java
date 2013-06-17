/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonny
 */
public class Fecha {

    private int anio = 5;

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int anioActual() {
        java.util.Calendar fecha = java.util.Calendar.getInstance();
        return fecha.get(java.util.Calendar.YEAR);
    }

    public int anioFin() {

        return anioActual() + 4;

    }
    
}
