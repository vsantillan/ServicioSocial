/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.formatoUnico;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author SATELLITE
 */
public class FormatoUnicoProyectosJSON {
    private BigDecimal id;
    private BigDecimal idProyecto;
    private ArrayList<BigDecimal> id_proyecto = new ArrayList<BigDecimal>();
    private ArrayList<BigDecimal> id_instancia = new ArrayList<BigDecimal>();
    private ArrayList<String> domicilio = new ArrayList<String>();
    private ArrayList<Long> telefono_responsable = new ArrayList<Long>();
    private ArrayList<String> nombre_responsable = new ArrayList<String>();
    private ArrayList<String> nombre = new ArrayList<String>();
    private Date fecha_inicio;

    /**
     * @return the id_proyecto
     */
    public ArrayList<BigDecimal> getId_proyecto() {
        return id_proyecto;
    }

    /**
     * @param id_proyecto the id_proyecto to set
     */
    public void setId_proyecto(ArrayList<BigDecimal> id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    /**
     * @return the id_instancia
     */
    public ArrayList<BigDecimal> getId_instancia() {
        return id_instancia;
    }

    /**
     * @param id_instancia the id_instancia to set
     */
    public void setId_instancia(ArrayList<BigDecimal> id_instancia) {
        this.id_instancia = id_instancia;
    }

    /**
     * @return the domicilio
     */
    public ArrayList<String> getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(ArrayList<String> domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the telefono_responsable
     */
    public ArrayList<Long> getTelefono_responsable() {
        return telefono_responsable;
    }

    /**
     * @param telefono_responsable the telefono_responsable to set
     */
    public void setTelefono_responsable(ArrayList<Long> telefono_responsable) {
        this.telefono_responsable = telefono_responsable;
    }

    /**
     * @return the nombre_responsable
     */
    public ArrayList<String> getNombre_responsable() {
        return nombre_responsable;
    }

    /**
     * @param nombre_responsable the nombre_responsable to set
     */
    public void setNombre_responsable(ArrayList<String> nombre_responsable) {
        this.nombre_responsable = nombre_responsable;
    }

    /**
     * @return the nombre
     */
    public ArrayList<String> getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(ArrayList<String> nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * @return the idProyecto
     */
    public BigDecimal getIdProyecto() {
        return idProyecto;
    }

    /**
     * @param idProyecto the idProyecto to set
     */
    public void setIdProyecto(BigDecimal idProyecto) {
        this.idProyecto = idProyecto;
    }

    /**
     * @return the fecha_inicio
     */
    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * @param fecha_inicio the fecha_inicio to set
     */
    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    
    
}
