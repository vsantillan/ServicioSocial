/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

/**
 *
 * @author ekt
 */
public class DocumentosFinalesBean 
{
    private int idDatosPer;
    private String noControl;
    private String nombreCompleto;
    private int idReporteFinal;
    private int idConstanciaPago;
    private int idFormatoUnicoFinal;
    private int idReporteCalificacion;
    private int statusRF;
    private int statusCP;
    private int statusFUF;
    private int statusRC;
    private String correo;
    
    public DocumentosFinalesBean()
    {
        
    }
    
    public DocumentosFinalesBean(int idDatosPer, String noControl, String nombreCompleto, int idReporteFinal, int idConstanciaPago, int idFormatoUnicoFinal, int idReporteCalificacion, int statusRF, int statusCP, int statusFUF, int statusRC, String correo)
    {
        this.idConstanciaPago=idConstanciaPago;
        this.idDatosPer=idDatosPer;
        this.idFormatoUnicoFinal=idFormatoUnicoFinal;
        this.idReporteCalificacion=idReporteCalificacion;
        this.noControl=noControl;
        this.nombreCompleto=nombreCompleto;
        this.statusRF=statusRF;
        this.statusCP=statusCP;
        this.statusFUF=statusFUF;
        this.statusRC=statusRC;
        this.correo=correo;
    }

    /**
     * @return the idDatosPer
     */
    public int getIdDatosPer() {
        return idDatosPer;
    }

    /**
     * @param idDatosPer the idDatosPer to set
     */
    public void setIdDatosPer(int idDatosPer) {
        this.idDatosPer = idDatosPer;
    }

    /**
     * @return the noControl
     */
    public String getNoControl() {
        return noControl;
    }

    /**
     * @param noControl the noControl to set
     */
    public void setNoControl(String noControl) {
        this.noControl = noControl;
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return the idReporteFinal
     */
    public int getIdReporteFinal() {
        return idReporteFinal;
    }

    /**
     * @param idReporteFinal the idReporteFinal to set
     */
    public void setIdReporteFinal(int idReporteFinal) {
        this.idReporteFinal = idReporteFinal;
    }

    /**
     * @return the idConstanciaPago
     */
    public int getIdConstanciaPago() {
        return idConstanciaPago;
    }

    /**
     * @param idConstanciaPago the idConstanciaPago to set
     */
    public void setIdConstanciaPago(int idConstanciaPago) {
        this.idConstanciaPago = idConstanciaPago;
    }

    /**
     * @return the idFormatoUnicoFinal
     */
    public int getIdFormatoUnicoFinal() {
        return idFormatoUnicoFinal;
    }

    /**
     * @param idFormatoUnicoFinal the idFormatoUnicoFinal to set
     */
    public void setIdFormatoUnicoFinal(int idFormatoUnicoFinal) {
        this.idFormatoUnicoFinal = idFormatoUnicoFinal;
    }

    /**
     * @return the idReporteCalificacion
     */
    public int getIdReporteCalificacion() {
        return idReporteCalificacion;
    }

    /**
     * @param idReporteCalificacion the idReporteCalificacion to set
     */
    public void setIdReporteCalificacion(int idReporteCalificacion) {
        this.idReporteCalificacion = idReporteCalificacion;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the statusRF
     */
    public int getStatusRF() {
        return statusRF;
    }

    /**
     * @param statusRF the statusRF to set
     */
    public void setStatusRF(int statusRF) {
        this.statusRF = statusRF;
    }

    /**
     * @return the statusCP
     */
    public int getStatusCP() {
        return statusCP;
    }

    /**
     * @param statusCP the statusCP to set
     */
    public void setStatusCP(int statusCP) {
        this.statusCP = statusCP;
    }

    /**
     * @return the statusFUF
     */
    public int getStatusFUF() {
        return statusFUF;
    }

    /**
     * @param statusFUF the statusFUF to set
     */
    public void setStatusFUF(int statusFUF) {
        this.statusFUF = statusFUF;
    }

    /**
     * @return the statusRC
     */
    public int getStatusRC() {
        return statusRC;
    }

    /**
     * @param statusRC the statusRC to set
     */
    public void setStatusRC(int statusRC) {
        this.statusRC = statusRC;
    }
    
}
