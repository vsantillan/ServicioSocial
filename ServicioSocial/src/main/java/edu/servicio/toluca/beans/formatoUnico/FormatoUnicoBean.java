/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.formatoUnico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Héctor
 */
public class FormatoUnicoBean {
    private String idFormatoUnico;
    private String noControl;
    private String nombre;
    private String fechaSubida;
    private String idDatosPersonales;
    private String periodo;
    private List<String> listaObservaciones;
    private String idDocumentoFormatoUnico;

    public FormatoUnicoBean() {
        listaObservaciones = new ArrayList<String>();
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
     * @return the idFormatoUnico
     */
    public String getIdFormatoUnico() {
        return idFormatoUnico;
    }

    /**
     * @param idFormatoUnico the idFormatoUnico to set
     */
    public void setIdFormatoUnico(String idFormatoUnico) {
        this.idFormatoUnico = idFormatoUnico;
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
    
    public void añadirObservacion(String observacion)
    {
        getListaObservaciones().add(observacion);
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

    /**
     * @return the idDocumentoFormatoUnico
     */
    public String getIdDocumentoFormatoUnico() {
        return idDocumentoFormatoUnico;
    }

    /**
     * @param idDocumentoFormatoUnico the idDocumentoFormatoUnico to set
     */
    public void setIdDocumentoFormatoUnico(String idDocumentoFormatoUnico) {
        this.idDocumentoFormatoUnico = idDocumentoFormatoUnico;
    }
}
