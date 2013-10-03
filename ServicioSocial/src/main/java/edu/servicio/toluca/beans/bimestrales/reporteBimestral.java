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
    
    private String  fechaInicio;
    private String fechaFin;
    @NotNull (message ="Introduzca el numero de horas del Reporte" )
    @Range(min = 0,max = 160,message = "El rango de las horas debe ser entre 0-160")
    private Integer horas;
    private BigInteger horasAcumuladas;
    @NotNull (message = "Introduzca una calificacion para el reporte")
    @Range(min = 0,max = 100, message = "La calificacion debe de estar entre 0-100")
    private Integer calificacion;
    private String actividades;
    private Integer numeroReporte;
    private Integer noReviciones;

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
    public Integer getHoras() {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    /**
     * @return the horasAcumuladas
     */
    public BigInteger getHorasAcumuladas() {
        return horasAcumuladas;
    }

    /**
     * @param horasAcumuladas the horasAcumuladas to set
     */
    public void setHorasAcumuladas(BigInteger horasAcumuladas) {
        this.horasAcumuladas = horasAcumuladas;
    }

    /**
     * @return the calificacion
     */
    public Integer getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(Integer calificacion) {
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
    public Integer getNumeroReporte() {
        return numeroReporte;
    }

    /**
     * @param numeroReporte the numeroReporte to set
     */
    public void setNumeroReporte(Integer numeroReporte) {
        this.numeroReporte = numeroReporte;
    }

    /**
     * @return the noReviciones
     */
    public Integer getNoReviciones() {
        return noReviciones;
    }

    /**
     * @param noReviciones the noReviciones to set
     */
    public void setNoReviciones(Integer noReviciones) {
        this.noReviciones = noReviciones;
    }


 



    
}
