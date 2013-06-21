/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bustedvillain
 */
@Entity
@Table(name = "LOCALIDADES", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidades.findAll", query = "SELECT l FROM Localidades l"),
    @NamedQuery(name = "Localidades.findById", query = "SELECT l FROM Localidades l WHERE l.localidadesPK.id = :id"),
    @NamedQuery(name = "Localidades.findByLocalidad", query = "SELECT l FROM Localidades l WHERE l.localidad = :localidad"),
    @NamedQuery(name = "Localidades.findByIdEstado", query = "SELECT l FROM Localidades l WHERE l.localidadesPK.idEstado = :idEstado"),
    @NamedQuery(name = "Localidades.findByIdMunicipio", query = "SELECT l FROM Localidades l WHERE l.localidadesPK.idMunicipio = :idMunicipio")})
public class Localidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LocalidadesPK localidadesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @JoinColumn(name = "ID_MUNICIPIO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Municipios municipios;
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estados estados;

    public Localidades() {
    }

    public Localidades(LocalidadesPK localidadesPK) {
        this.localidadesPK = localidadesPK;
    }

    public Localidades(LocalidadesPK localidadesPK, String localidad) {
        this.localidadesPK = localidadesPK;
        this.localidad = localidad;
    }

    public Localidades(String id, String idEstado, String idMunicipio) {
        this.localidadesPK = new LocalidadesPK(id, idEstado, idMunicipio);
    }

    public LocalidadesPK getLocalidadesPK() {
        return localidadesPK;
    }

    public void setLocalidadesPK(LocalidadesPK localidadesPK) {
        this.localidadesPK = localidadesPK;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Municipios getMunicipios() {
        return municipios;
    }

    public void setMunicipios(Municipios municipios) {
        this.municipios = municipios;
    }

    public Estados getEstados() {
        return estados;
    }

    public void setEstados(Estados estados) {
        this.estados = estados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localidadesPK != null ? localidadesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidades)) {
            return false;
        }
        Localidades other = (Localidades) object;
        if ((this.localidadesPK == null && other.localidadesPK != null) || (this.localidadesPK != null && !this.localidadesPK.equals(other.localidadesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.Localidades[ localidadesPK=" + localidadesPK + " ]";
    }
    
}
