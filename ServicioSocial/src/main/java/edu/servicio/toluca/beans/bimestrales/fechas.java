/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.bimestrales;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author rodrigo
 */
public class fechas {

    private Date fechaInicio;
    private Date fechaFin;

    public fechas(Date fecha) {
        this.fechaInicio = fecha;

    }

    public String dameFecha() throws ParseException {
        SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
        //fechaFin = textFormat.parse(fechaInicio);
        System.out.println("La fecha de Inicio es: "+fechaInicio);
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(fechaInicio);
        fecha.add(Calendar.MONTH,2);

        return textFormat.format(fecha.getTime());

    }
}
