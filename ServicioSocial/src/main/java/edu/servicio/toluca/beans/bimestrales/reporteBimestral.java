/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.bimestrales;

import java.math.BigInteger;
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author rodrigo
 */

public class reporteBimestral {
    
    @NotEmpty (message = "El campo no puede ser vacio")
    private String fechaInicio;
    @NotEmpty (message = "El campo no puede ser vacio")
    private String fechaFin;
    @NotEmpty (message = "El campo no puede ser vacio")
    @Range(min = 0,max = 160,message = "El rango de las horas debe ser entre 0-160")
    private int horas;
    private int horasAcumuladas;
    @NotEmpty (message = "El campo no puede ser vacio")
    @Range(min = 0,max = 100, message = "La calificacion debe de estar entre 0-100")
    private int calificacion;
    private String actividades;
    private int numeroReporte;

    /**
     * @return the fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the horas
     */
    public int getHoras() {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(int horas) {
        this.horas = horas;
    }

    /**
     * @return the horasAcumuladas
     */
    public int getHorasAcumuladas() {
        return horasAcumuladas;
    }

    /**
     * @param horasAcumuladas the horasAcumuladas to set
     */
    public void setHorasAcumuladas(int horasAcumuladas) {
        this.horasAcumuladas = horasAcumuladas;
    }

    /**
     * @return the calificacion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the actividades
     */
    public String getActividades() {
        return actividades;
    }

    /**
     * @param actividades the actividades to set
     */
    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    /**
     * @return the numeroReporte
     */
    public int getNumeroReporte() {
        return numeroReporte;
    }

    /**
     * @param numeroReporte the numeroReporte to set
     */
    public void setNumeroReporte(int numeroReporte) {
        this.numeroReporte = numeroReporte;
    }


    
}
