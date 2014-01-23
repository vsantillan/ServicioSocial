/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.configuracion;


/**
 *
 * @author Regules
 */
public interface ExpresionesRegularesErrores 
{
    static final  String correos="\"^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$\"";
    static final  String letras="^[A-Za-z/\\s/]+$";
    static final  String numeros="^[0-9]+$";
    static final  String letrasNumeros="^[A-Za-z0-9/\\s/]+$";
    static final  String fecha="\\d{1,2}/\\d{1,2}/\\d\\d";
    static final  String horas="\\d{1,2}:\\d{1,2}";
    
    static final  String errorCorreos="Introduzca un formato de correo válido";
    static final  String errorletras="Introduzca  unicamente letras";
    static final  String errorLetrasNumeros="Introduzca unicamente caracteres alfanumericos"; 
    static final  String errorFecha="El formato de la fecha debe de ser dd/mm/aaaa";
    static final  String errorhoras="El formato de la hora debe de ser";
    static final  String errorCampoVacio="El campo no puede estar vacío";
    static final  String errorBetween="El tamaño de campo debe de estar entre";
    


} 