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
   private int anio;
   private List<String> listaDeAnios;

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
    
    public List<String> anioActual ()
    {
         java.util.Calendar fecha = java.util.Calendar.getInstance();
         listaDeAnios= new ArrayList<String>();
         anio=fecha.get(java.util.Calendar.YEAR);
         for (int i=1; i<=4;i++)
         {
         listaDeAnios.add (""+anio);
         anio++;
         }
         return listaDeAnios;
    }  
    
}
