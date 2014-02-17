/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.configuracion;


/**
 *
 * @author Regules
 */
public interface ExpresionesRegulares 
{
  //  static final  String correos="\"^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$\"";
    static final  String letras="^[A-Za-zÑñÁÉÍÓÚáéíóúü/\\s/]+$";
    static final  String numeros="^[0-9]+$";
    static final  String letrasNumeros="^[A-Za-z0-9ÑñÁÉÍÓÚáéíóúü]+$";
    static final  String fechaER="\\d{1,2}/\\d{1,2}/\\d\\d\\d\\d";
    static final  String horas="\\d{1,2}:\\d{1,2}/\\s/[A-Z]+$";
    static final  String comentarios="^[A-Za-z/\\s/.,\"\'+*]+$";
    static final  String letrasNumerosEspeciales="^[A-Za-z0-9ÑñÁÉÍÓÚáéíóúü!\";:%#&?¿¡+*,.)(/\\s/]+$";
    static final  String letrasNumerosPrimeroDespuesEspacios="^[A-Za-z0-9ÑñÁÉÍÓÚáéíóúü]+[A-Za-z0-9ÑñÁÉÍÓÚáéíóúü/\\s/]+$";
    static final  String letrasPrimeroDespuesEspacios="^[A-Za-zÑñÁÉÍÓÚáéíóúü]+[A-Za-zÑñÁÉÍÓÚáéíóúü/\\s/]+$";
    static final  String letrasNumerosCaractesEspeciales="^[A-Za-z0-9ÑñÁÉÍÓÚáéíóúü.-_,#+*)(/\\s/]+$";
    
    
    


} 