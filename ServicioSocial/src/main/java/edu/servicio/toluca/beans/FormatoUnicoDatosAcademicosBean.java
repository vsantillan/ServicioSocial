/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import java.math.BigInteger;

/**
 *
 * @author SATELLITE
 */
public class FormatoUnicoDatosAcademicosBean {
    private String ncontrol;
    private String carrera;
    private String periodo;
    private Short semestre;
    private BigInteger cc;
    private String pcc;

    /**
     * @return the ncontrol
     */
    public String getNcontrol() {
        return ncontrol;
    }

    /**
     * @param ncontrol the ncontrol to set
     */
    public void setNcontrol(String ncontrol) {
        this.ncontrol = ncontrol;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * @return the periodo
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the semestre
     */
    public Short getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(Short semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the cc
     */
    public BigInteger getCc() {
        return cc;
    }

    /**
     * @param cc the cc to set
     */
    public void setCc(BigInteger cc) {
        this.cc = cc;
    }

    /**
     * @return the pcc
     */
    public String getPcc() {
        return pcc;
    }

    /**
     * @param pcc the pcc to set
     */
    public void setPcc(String pcc) {
        this.pcc = pcc;
    }
}
