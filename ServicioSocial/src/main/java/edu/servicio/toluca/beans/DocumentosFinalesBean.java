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
    private int status;
    private String correo;
    
    public DocumentosFinalesBean()
    {
        
    }
    
    public DocumentosFinalesBean(int idDatosPer, String noControl, String nombreCompleto, int idReporteFinal, int idConstanciaPago, int idFormatoUnicoFinal, int idReporteCalificacion, int status, String correo)
    {
        this.idConstanciaPago=idConstanciaPago;
        this.idDatosPer=idDatosPer;
        this.idFormatoUnicoFinal=idFormatoUnicoFinal;
        this.idReporteCalificacion=idReporteCalificacion;
        this.noControl=noControl;
        this.nombreCompleto=nombreCompleto;
        this.status=status;
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
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
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
    
}
