/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author bustedvillain
 */
public class FechaAPalabras {

    /**
     * Retorna una fecha tipo Date en palabras ej Lunes 3 de Agosto del 2013
     * @param fecha
     * @return 
     */
    public String fechaAPalabras(Date fecha) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        String fechaString = "";
        switch (cal.get(Calendar.DAY_OF_WEEK)) {
            case 0:
                fechaString += "Sabado ";
                break;
            case 1:
                fechaString += "Domingo ";
                break;
            case 2:
                fechaString += "Lunes ";
                break;
            case 3:
                fechaString += "Martes ";
                break;
            case 4:
                fechaString += "Miercoles ";
                break;
            case 5:
                fechaString += "Jueves ";
                break;
            case 6:
                fechaString += "Viernes ";
                break;
        }
        fechaString += cal.get(Calendar.DAY_OF_MONTH)+" de ";
        
        switch(cal.get(Calendar.MONTH)){
            case 0:
                fechaString += "Enero del ";
                break;
            case 1:
                fechaString += "Febrero del ";
                break;
            case 2:
                fechaString += "Marzo del ";
                break;
            case 3:
                fechaString += "Abril del ";
                break;
            case 4:
                fechaString += "Mayo del ";
                break;
            case 5:
                fechaString += "Junio del ";
                break;
            case 6:
                fechaString += "Julio del ";
                break;
            case 7:
                fechaString += "Agosto del ";
                break;
            case 8:
                fechaString += "Septiembre del ";
                break;
            case 9:
                fechaString += "Octubre del ";
                break;
            case 10:
                fechaString += "Noviembre del ";
                break;
            case 11:
                fechaString += "Diciembre del ";
                break;            
        }
        fechaString += cal.get(Calendar.YEAR);
        return fechaString;
    }
}
