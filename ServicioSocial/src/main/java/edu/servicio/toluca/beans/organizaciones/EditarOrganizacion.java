/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.organizaciones;

import java.math.BigDecimal;

/**
 *
 * @author regules
 */
public class EditarOrganizacion 
{
    private BigDecimal idInstancia;
    private String nombre="hola";
    private String rfc;
    private String titular;
    private String puesto;
    private String correo;
    private String password;
    private int estatus;
    private long telefono;
    private String domicilio;
    private BigDecimal idColonia;
    private BigDecimal idCodigoPostal;
    private BigDecimal tipoOrganizacion;

    /**
     * @return the idInstancia
     */
    public BigDecimal getIdInstancia() {
        return idInstancia;
    }

    /**
     * @param idInstancia the idInstancia to set
     */
    public void setIdInstancia(BigDecimal idInstancia) {
        this.idInstancia = idInstancia;
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
     * @return the rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * @return the titular
     */
    public String getTitular() {
        return titular;
    }

    /**
     * @param titular the titular to set
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * @return the puesto
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * @param puesto the puesto to set
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the estatus
     */
    public int getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    /**
     * @return the telefono
     */
    public long getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the idColonia
     */
    public BigDecimal getIdColonia() {
        return idColonia;
    }

    /**
     * @param idColonia the idColonia to set
     */
    public void setIdColonia(BigDecimal idColonia) {
        this.idColonia = idColonia;
    }

    /**
     * @return the idCodigoPostal
     */
    public BigDecimal getIdCodigoPostal() {
        return idCodigoPostal;
    }

    /**
     * @param idCodigoPostal the idCodigoPostal to set
     */
    public void setIdCodigoPostal(BigDecimal idCodigoPostal) {
        this.idCodigoPostal = idCodigoPostal;
    }

    /**
     * @return the tipoOrganizacion
     */
    public BigDecimal getTipoOrganizacion() {
        return tipoOrganizacion;
    }

    /**
     * @param tipoOrganizacion the tipoOrganizacion to set
     */
    public void setTipoOrganizacion(BigDecimal tipoOrganizacion) {
        this.tipoOrganizacion = tipoOrganizacion;
    }
}
