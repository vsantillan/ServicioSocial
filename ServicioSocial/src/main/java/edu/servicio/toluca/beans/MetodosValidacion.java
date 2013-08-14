/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author SATELLITE
 */
public class MetodosValidacion {

    public boolean r = true;

    public boolean minimoString(String s, int tamanyo) {
        if (s.length() < tamanyo) {
            r = false;
        }
        return r;
    }

    public boolean maximoString(String s, int tamanyo) {
        if (s.length() > tamanyo) {
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
    public  String quitaAcentos(String input) {
        
        // Cadena de caracteres original a sustituir.
        String original = "ÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑÇ";
        // Cadena de caracteres ASCII que reemplazarán los originales.
        String ascii = "AAAEEEIIIOOOUUUNC";
        String output = input;
        for (int i = 0; i < original.length(); i++) {
            // Reemplazamos los caracteres especiales.
            output = output.replace(original.charAt(i), ascii.charAt(i));
        }//for i
        return output;
    }//remove1
    public String quitaCaracteresEspeciales(String s)
    {
        Pattern patron = Pattern.compile("[^A-Za-z 0-9]");
        Matcher encaja = patron.matcher(s);
        s = encaja.replaceAll("");
        return s;
    }
    public String dejarSoloNumeros(String s)
    {
        Pattern patron = Pattern.compile("[^0-9]");
        Matcher encaja = patron.matcher(s);
        s = encaja.replaceAll("");
        return s;
    }
}
