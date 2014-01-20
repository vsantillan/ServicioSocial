/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.configuracion;


/**
 *
 * @author Regules
 */
public abstract class ExpresionesRegulares 
{
    public String correos="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String letras="^[A-Za-z]+$";
    String numeros="^[0-9]+$";
    String letrasNumeros="^[A-Za-z0-9]+$";
    String fecha="\\d{1,2}/\\d{1,2}/\\d\\d";
    String horas="\\d{1,2}:\\d{1,2}";
}
