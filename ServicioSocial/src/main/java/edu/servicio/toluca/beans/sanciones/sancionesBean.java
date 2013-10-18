/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.sanciones;

import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.VistaAlumno;
import java.math.BigDecimal;

/**
 *
 * @author SATELLITE
 */
public class sancionesBean {
    private BigDecimal idCatalogoSanciones;
    private BigDecimal idSancion;
    private String idAlumno;
    private VistaAlumno alumno;
    private DatosPersonales datosPersonales;
    private int horas;

    /**
     * @return the idCatalogoSanciones
     */
    public BigDecimal getIdCatalogoSanciones() {
        return idCatalogoSanciones;
    }

    /**
     * @param idCatalogoSanciones the idCatalogoSanciones to set
     */
    public void setIdCatalogoSanciones(BigDecimal idCatalogoSanciones) {
        this.idCatalogoSanciones = idCatalogoSanciones;
    }

    /**
     * @return the idSancion
     */
    public BigDecimal getIdSancion() {
        return idSancion;
    }

    /**
     * @param idSancion the idSancion to set
     */
    public void setIdSancion(BigDecimal idSancion) {
        this.idSancion = idSancion;
    }

    /**
     * @return the idAlumno
     */
    public String getIdAlumno() {
        return idAlumno;
    }

    /**
     * @param idAlumno the idAlumno to set
     */
    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    /**
     * @return the alumno
     */
    public VistaAlumno getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(VistaAlumno alumno) {
        this.alumno = alumno;
    }

    /**
     * @return the datosPersonales
     */
    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    /**
     * @param datosPersonales the datosPersonales to set
     */
    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
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
}
