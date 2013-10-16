/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import edu.servicio.toluca.beans.egresado.EgresadoPanelUsuarioBean;
import edu.servicio.toluca.beans.platica.FoliosPlaticaBean;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.Reportes;
import edu.servicio.toluca.entidades.VistaAlumno;
import java.util.ArrayList;

/**
 *Autor: Jose Manuel Nieto Gomez
 * @author bustedvillain
 */
public class StatusServicioBean {
    
    private String mensaje;
    private int statusServicio;
    private DatosPersonales datosPersonales;
    private FormatoUnico formatoUnico;
    private VistaAlumno vistaAlumno;
    private FoliosPlaticaBean platicaBean;
    private int horasServicio=0;
    private ArrayList<Reportes> reportesBimestrales;
    private int tipoPanel=0;
    private EgresadoPanelUsuarioBean egresado;
    

    /**
     * Mensaje sobre el estatus del servicio social
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Mensaje sobre el estatus del servicio social
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     *  Estatus del servicio social: 
     * 1. Activo
     * 2. Cancelado
     * 3. Baja Temporal
     * 4. Terminado
     * @return the statusServicio
     */
    public int getStatusServicio() {
        return statusServicio;
    }

    /**
     * Estatus del servicio social: 
     * 1. Activo
     * 2. Cancelado
     * 3. Baja Temporal
     * 4. Terminado
     * @param statusServicio the statusServicio to set
     */
    public void setStatusServicio(int statusServicio) {
        this.statusServicio = statusServicio;
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
     * @return the formatoUnico
     */
    public FormatoUnico getFormatoUnico() {
        return formatoUnico;
    }

    /**
     * @param formatoUnico the formatoUnico to set
     */
    public void setFormatoUnico(FormatoUnico formatoUnico) {
        this.formatoUnico = formatoUnico;
    }

    /**
     * @return the vistaAlumno
     */
    public VistaAlumno getVistaAlumno() {
        return vistaAlumno;
    }

    /**
     * @param vistaAlumno the vistaAlumno to set
     */
    public void setVistaAlumno(VistaAlumno vistaAlumno) {
        this.vistaAlumno = vistaAlumno;
    }

    /**
     * @return the platicaBean
     */
    public FoliosPlaticaBean getPlaticaBean() {
        return platicaBean;
    }

    /**
     * @param platicaBean the platicaBean to set
     */
    public void setPlaticaBean(FoliosPlaticaBean platicaBean) {
        this.platicaBean = platicaBean;
    }

    /**
     * @return the horasServicio
     */
    public int getHorasServicio() {
        return horasServicio;
    }

    /**
     * @param horasServicio the horasServicio to set
     */
    public void setHorasServicio(int horasServicio) {
        this.horasServicio = horasServicio;
    }

    /**
     * @return the reportesBimestrales
     */
    public ArrayList<Reportes> getReportesBimestrales() {
        return reportesBimestrales;
    }

    /**
     * @param reportesBimestrales the reportesBimestrales to set
     */
    public void setReportesBimestrales(ArrayList<Reportes> reportesBimestrales) {
        this.reportesBimestrales = reportesBimestrales;
    }

    /**
     * El tipo de panel que se le va a mostrar al alumno
     * 0:Interno
     * 1:Egresado
     * 2:Egresado haciendo servicio normal
     * @return the tipoPanel
     */
    public int getTipoPanel() {
        return tipoPanel;
    }

    /**
     * El tipo de panel que se le va a mostrar al alumno
     * 0:Interno
     * 1:Egresado
     * 2:Egresado haciendo servicio normal
     * @param tipoPanel the tipoPanel to set
     */
    public void setTipoPanel(int tipoPanel) {
        this.tipoPanel = tipoPanel;
    }

    /**
     * Bean para los egresados
     * @return the egresado
     */
    public EgresadoPanelUsuarioBean getEgresado() {
        return egresado;
    }

    /**
     * Bean para los egresados
     * @param egresado the egresado to set
     */
    public void setEgresado(EgresadoPanelUsuarioBean egresado) {
        this.egresado = egresado;
    }
}
