/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.egresado;

import java.util.List;

/**
 *
 * @author SATELLITE
 */
public class EgresadoBean {
    private String idEgresado;
    private String noControl;
    private String nombre;
    private String fechaSubida;
    private String idDatosPersonales;
    private String idDocumentoCartaMotivos;
    private String periodo;
    private List<String> listaObservaciones;
    //private String idDocumentoFormatoUnico;

    /**
     * @return the idEgresado
     */
    public String getIdEgresado() {
        return idEgresado;
    }

    /**
     * @param idEgresado the idEgresado to set
     */
    public void setIdEgresado(String idEgresado) {
        this.idEgresado = idEgresado;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fechaSubida
     */
    public String getFechaSubida() {
        return fechaSubida;
    }

    /**
     * @param fechaSubida the fechaSubida to set
     */
    public void setFechaSubida(String fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    /**
     * @return the idDatosPersonales
     */
    public String getIdDatosPersonales() {
        return idDatosPersonales;
    }

    /**
     * @param idDatosPersonales the idDatosPersonales to set
     */
    public void setIdDatosPersonales(String idDatosPersonales) {
        this.idDatosPersonales = idDatosPersonales;
    }

    /**
     * @return the idDocumentoCartaMotivos
     */
    public String getIdDocumentoCartaMotivos() {
        return idDocumentoCartaMotivos;
    }

    /**
     * @param idDocumentoCartaMotivos the idDocumentoCartaMotivos to set
     */
    public void setIdDocumentoCartaMotivos(String idDocumentoCartaMotivos) {
        this.idDocumentoCartaMotivos = idDocumentoCartaMotivos;
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
     * @return the listaObservaciones
     */
    public List<String> getListaObservaciones() {
        return listaObservaciones;
    }

    /**
     * @param listaObservaciones the listaObservaciones to set
     */
    public void setListaObservaciones(List<String> listaObservaciones) {
        this.listaObservaciones = listaObservaciones;
    }
}
