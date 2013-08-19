/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.organizaciones;

import edu.servicio.toluca.entidades.Colonia;
import edu.servicio.toluca.entidades.Programa;
import edu.servicio.toluca.entidades.TipoOrganizacion;
import edu.servicio.toluca.entidades.TipoProyecto;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author bustedvillain
 */
public class PropAluInstProyBean {
    //Campos para la info de la instancia
    @Size(min = 1, max = 45, message="Nombre de la Organización vacía")
    private String nombre_instancia;
    @Size(min = 12, max = 12, message="El RFC debe tener una longitud de 12 caracteres")
    private String rfc;
    @Size(min = 1, max = 45, message="Nombre del Titular vacío")
    private String titular;
    @Size(min = 1, max = 45, message="Puesto vacío")
    private String puesto_titular;
    @NotNull    
    private long telefono_titular;
    @NotNull
    @Size(min = 1, max = 100)
    private String domicilio_instancia;
    private TipoOrganizacion tipoOrganizacion;
    private Colonia idColonia_instancia;
    
    
    //Datos del proyecto
    @Size(max = 60)
    @NotBlank
    private String nombre_proyecto;
    @Size(min = 1, max = 100)
    private String domicilio_proyecto;
    @Size(min = 1, max = 45)
    @NotBlank
    private String nombreResponsable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String responsablePuesto;
    @Basic(optional = false)
    @NotNull
    private long telefonoResponsable;
    private String modalidad;
    @Basic(optional = false)
    @NotNull
    @Min(1)
    private BigInteger vacantes;
    private Colonia idColonia_proyecto;
    private TipoProyecto idTipoProyecto;
    private Programa idPrograma;

    /**
     * @return the nombre_instancia
     */
    public String getNombre_instancia() {
        return nombre_instancia;
    }

    /**
     * @param nombre_instancia the nombre_instancia to set
     */
    public void setNombre_instancia(String nombre_instancia) {
        this.nombre_instancia = nombre_instancia;
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
     * @return the puesto_titular
     */
    public String getPuesto_titular() {
        return puesto_titular;
    }

    /**
     * @param puesto_titular the puesto_titular to set
     */
    public void setPuesto_titular(String puesto_titular) {
        this.puesto_titular = puesto_titular;
    }

    /**
     * @return the telefono_titular
     */
    public long getTelefono_titular() {
        return telefono_titular;
    }

    /**
     * @param telefono_titular the telefono_titular to set
     */
    public void setTelefono_titular(long telefono_titular) {
        this.telefono_titular = telefono_titular;
    }

    /**
     * @return the domicilio_instancia
     */
    public String getDomicilio_instancia() {
        return domicilio_instancia;
    }

    /**
     * @param domicilio_instancia the domicilio_instancia to set
     */
    public void setDomicilio_instancia(String domicilio_instancia) {
        this.domicilio_instancia = domicilio_instancia;
    }

    /**
     * @return the tipoOrganizacion
     */
    public TipoOrganizacion getTipoOrganizacion() {
        return tipoOrganizacion;
    }

    /**
     * @param tipoOrganizacion the tipoOrganizacion to set
     */
    public void setTipoOrganizacion(TipoOrganizacion tipoOrganizacion) {
        this.tipoOrganizacion = tipoOrganizacion;
    }

    /**
     * @return the idColonia_instancia
     */
    public Colonia getIdColonia_instancia() {
        return idColonia_instancia;
    }

    /**
     * @param idColonia_instancia the idColonia_instancia to set
     */
    public void setIdColonia_instancia(Colonia idColonia_instancia) {
        this.idColonia_instancia = idColonia_instancia;
    }

    /**
     * @return the nombre_proyecto
     */
    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    /**
     * @param nombre_proyecto the nombre_proyecto to set
     */
    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    /**
     * @return the domicilio_proyecto
     */
    public String getDomicilio_proyecto() {
        return domicilio_proyecto;
    }

    /**
     * @param domicilio_proyecto the domicilio_proyecto to set
     */
    public void setDomicilio_proyecto(String domicilio_proyecto) {
        this.domicilio_proyecto = domicilio_proyecto;
    }

    /**
     * @return the nombreResponsable
     */
    public String getNombreResponsable() {
        return nombreResponsable;
    }

    /**
     * @param nombreResponsable the nombreResponsable to set
     */
    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    /**
     * @return the responsablePuesto
     */
    public String getResponsablePuesto() {
        return responsablePuesto;
    }

    /**
     * @param responsablePuesto the responsablePuesto to set
     */
    public void setResponsablePuesto(String responsablePuesto) {
        this.responsablePuesto = responsablePuesto;
    }

    /**
     * @return the telefonoResponsable
     */
    public long getTelefonoResponsable() {
        return telefonoResponsable;
    }

    /**
     * @param telefonoResponsable the telefonoResponsable to set
     */
    public void setTelefonoResponsable(long telefonoResponsable) {
        this.telefonoResponsable = telefonoResponsable;
    }

    /**
     * @return the modalidad
     */
    public String getModalidad() {
        return modalidad;
    }

    /**
     * @param modalidad the modalidad to set
     */
    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    /**
     * @return the vacantes
     */
    public BigInteger getVacantes() {
        return vacantes;
    }

    /**
     * @param vacantes the vacantes to set
     */
    public void setVacantes(BigInteger vacantes) {
        this.vacantes = vacantes;
    }

    /**
     * @return the idColonia_proyecto
     */
    public Colonia getIdColonia_proyecto() {
        return idColonia_proyecto;
    }

    /**
     * @param idColonia_proyecto the idColonia_proyecto to set
     */
    public void setIdColonia_proyecto(Colonia idColonia_proyecto) {
        this.idColonia_proyecto = idColonia_proyecto;
    }

    /**
     * @return the idTipoProyecto
     */
    public TipoProyecto getIdTipoProyecto() {
        return idTipoProyecto;
    }

    /**
     * @param idTipoProyecto the idTipoProyecto to set
     */
    public void setIdTipoProyecto(TipoProyecto idTipoProyecto) {
        this.idTipoProyecto = idTipoProyecto;
    }

    /**
     * @return the idPrograma
     */
    public Programa getIdPrograma() {
        return idPrograma;
    }

    /**
     * @param idPrograma the idPrograma to set
     */
    public void setIdPrograma(Programa idPrograma) {
        this.idPrograma = idPrograma;
    }
}
