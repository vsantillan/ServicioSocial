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
    private Date fechaInicio;
    @NotEmpty (message = "El campo no puede ser vacio")
    private Date fechaFin;
    @NotEmpty (message = "El campo no puede ser vacio")
    @Range(min = 0,max = 160,message = "El rango de las horas debe ser entre 0-160")
    private BigInteger horas;
    private BigInteger horasAcumuladas;
    @NotEmpty (message = "El campo no puede ser vacio")
    @Range(min = 0,max = 100, message = "La calificacion debe de estar entre 0-100")
    private BigInteger calificacion;

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the horas
     */
    public BigInteger getHoras() {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(BigInteger horas) {
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
    public BigInteger getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(BigInteger calificacion) {
        this.calificacion = calificacion;
    }
    
}
