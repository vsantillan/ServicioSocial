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
    int idDatosPer;
    String noControl;
    String nombreCompleto;
    int idReporteFinal;
    int idConstanciaPago;
    int idFormatoUnicoFinal;
    int idReporteCalificacion;
    
    public DocumentosFinalesBean(int idDatosPer, String noControl, String nombreCompleto, int idReporteFinal, int idConstanciaPago, int idFormatoUnicoFinal, int idReporteCalificacion)
    {
        this.idConstanciaPago=idConstanciaPago;
        this.idDatosPer=idDatosPer;
        this.idFormatoUnicoFinal=idFormatoUnicoFinal;
        this.idReporteCalificacion=idReporteCalificacion;
        this.noControl=noControl;
        this.nombreCompleto=nombreCompleto;
    }
    
}
