/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.configuracion;

/**
 *
 * @author Jonny
 */
public interface CatalogoErrores {
    /**
     * Errores de expresiones regulares
     * 
     */
    static final  String errorCorreos="Introduzca un formato de correo válido";
    static final  String errorletras="Introduzca  únicamente letras";
    static final  String errorNumeros="Introduzca  únicamente números";
    static final  String errorLetrasNumeros="Introduzca únicamente caracteres alfanuméricos"; 
    static final  String errorFecha="El formato de la fecha debe de ser dd/mm/aaaa";
    static final  String errorhoras="El formato de la hora debe de ser";
    static final  String errorCampoVacio="El campo no puede estar vacío";
    static final  String errorBetween="El tamaño debe de estar entre";
    static final  String errorEmail="El correo electronico no es un email valido";
    static final  String errorNumerosLetrasCaracteresEspeciales="Introduzca unicamente caracteres alfanumericos y los caractes especiales permitidos .-_,#+*";
    
}
