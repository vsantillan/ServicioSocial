/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openide.util.Exceptions;


/**
 *
 * @author SATELLITE
 */
public class MetodosValidacion {

    public boolean r = true;

    public boolean minimoString(String s, int tamanyo) {
        r = true;
        System.out.println("Tamaño:" + tamanyo + " Longitud:"+s.length());
        if (s.length() < tamanyo) {
            r = false;
        }
        return r;
    }

    public boolean maximoString(String s, int tamanyo) {
        r = true;
        System.out.println("Tamaño:" + tamanyo + " Longitud:"+s.length());
        if (s.length() > tamanyo) {

            

            System.out.println("Tamaño:" + tamanyo + " Longitud:" + s.length());

            r = false;
        }
        return r;
    }

    public String tuneaStringParaBD(String s)
    {
        s = pasaMayusculas(s);
        s = quitaAcentos(s);
        s = quitaCaracteresEspeciales(s);
        return s;       
    }
    public String pasaMayusculas(String s)
    {
        return s.toUpperCase();
    }
    public String pasaMinusculas(String s)
    {
        return s.toLowerCase();
    }


    public String quitaAcentos(String input) {

        // Cadena de caracteres original a sustituir.
        // ya no usadoString original = "ÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑÇ";
        String original = "ÀÄÈËÌÏÒÖÙÜÇ";
        // Cadena de caracteres ASCII que reemplazarán los originales.
        //ya no usado String ascii = "AAAEEEIIIOOOUUUNC";
        String ascii = "AAEEIIOOUUC";
        String output = input;
        for (int i = 0; i < original.length(); i++) {
            // Reemplazamos los caracteres especiales.
            output = output.replace(original.charAt(i), ascii.charAt(i));
        }//for i
        return output;
    }//remove1


    public String quitaCaracteresEspeciales(String s) {

        Pattern patron = Pattern.compile("[^A-Za-z 0-9]");
        Matcher encaja = patron.matcher(s);
        s = encaja.replaceAll("");
        return s;
    }

    public String dejarSoloNumeros(String s) {
        Pattern patron = Pattern.compile("[^0-9]");
        Matcher encaja = patron.matcher(s);
        s = encaja.replaceAll("");
        return s;
    }


    public boolean esHora(String s) {
        //Pattern patron = Pattern.compile("[0-9][0-9]:[0-9][0-9]");
//        Pattern patron = Pattern.compile("\\|([0-9]|([0-1][0-9])|(2[0-3]))\\:[0-5][0-9]\\|");
//        Matcher encaja = patron.matcher(s);
//        if (encaja.find()) {
//            return true;
//        } else {
//            return false;
//        }
        boolean r = true;
        DateFormat formato = new SimpleDateFormat("hh:mm");
        try {
            Date h1 = (Date)formato.parse(s);
            System.out.println("Sin problema al parsear queda"+h1);
            return true;
        } catch (Exception ex) {
            r= false;
            Exceptions.printStackTrace(ex);
            System.out.println("excepcion"+ex.getMessage());
            return false;
        }
        //return r;
    }

}
