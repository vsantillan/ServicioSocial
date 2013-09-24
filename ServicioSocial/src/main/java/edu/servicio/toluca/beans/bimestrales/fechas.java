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

    public String dameFechaFin(Date fechaInicio) throws ParseException {
        SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(fechaInicio);
        fecha.add(Calendar.MONTH, 2);

        return textFormat.format(fecha.getTime());

    }

    public String convierteDate(Date fecha) {
        SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");

        return textFormat.format(fecha);
    }

    public Date covierteString(String fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formatoFecha.parse(fecha);
        } catch (Exception ex) {
            System.out.println("Ocurrio un error");

        }
        return fechaDate;
    }

    public Date fechaEntrgaMax() {
        Date fechaEntregaMax = null;
        return fechaEntregaMax;

    }
}
