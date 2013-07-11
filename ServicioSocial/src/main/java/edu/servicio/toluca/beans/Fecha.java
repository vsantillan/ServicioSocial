/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import java.util.ArrayList;
import java.util.Calendar;
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
     public String CalculaPeriodo() {
        Calendar calendar = Calendar.getInstance();
        int month = 1;
        String periodo="";
        // Obtenemos el valor del año, mes y día.
        month = calendar.get(Calendar.MONTH) + 1;
        
        if (month <7) 
            periodo = "ENE-JUN";
        else if (month>7)
             periodo = "AGO-DIC";
        else
            periodo="JULIO";
        return periodo;
    }
       public String CalculaPeriodoPrueba() {
        Calendar calendar = Calendar.getInstance();
        int month = 1;
        String periodo="";
        // Obtenemos el valor del año, mes y día.
        month = calendar.get(Calendar.MONTH) + 1;
        
        if (month <8) 
            periodo = "ENE-JUN";
        else 
             periodo = "AGO-DIC";
        
        return periodo;
    }
}
