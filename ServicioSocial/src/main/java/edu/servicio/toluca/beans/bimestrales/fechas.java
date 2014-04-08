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

    public java.sql.Date covierteString(String fecha) {
        System.out.println("La fecha en Cadena es: " + fecha);
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        java.sql.Date sqlDate = null;
        try {
            fechaDate = formatoFecha.parse(fecha);
            System.out.println("La fecha Parseada es: " + fechaDate.toLocaleString());
            sqlDate = new java.sql.Date(fechaDate.getTime());
        } catch (Exception ex) {
            System.out.println("Ocurrio un error");

        }
        return sqlDate;
    }

    public String fechaEntrgaMax(Date fechaFin) {
        SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(fechaFin);
        fecha.add(Calendar.DATE, 5);
        return textFormat.format(fecha.getTime());

    }

    public String dameFechaFUF(Date fechaFuf) {
        SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(fechaFuf);
        fecha.add(Calendar.DATE, 15);

        return textFormat.format(fecha.getTime());
    }
}
