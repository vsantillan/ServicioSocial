/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SATELLITE
 */
@Entity
@Table(name = "TIPO_LOCALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoLocalidad.findAll", query = "SELECT t FROM TipoLocalidad t"),
    @NamedQuery(name = "TipoLocalidad.findByIdTipoLocalidad", query = "SELECT t FROM TipoLocalidad t WHERE t.idTipoLocalidad = :idTipoLocalidad"),
    @NamedQuery(name = "TipoLocalidad.findByNombre", query = "SELECT t FROM TipoLocalidad t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoLocalidad.findByStatus", query = "SELECT t FROM TipoLocalidad t WHERE t.status = :status")})
public class TipoLocalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_LOCALIDAD")
    private BigDecimal idTipoLocalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private BigInteger status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoLocalidad")
    private Collection<CodigosPostales> codigosPostalesCollection;

    public TipoLocalidad() {
    }

    public TipoLocalidad(BigDecimal idTipoLocalidad) {
        this.idTipoLocalidad = idTipoLocalidad;
    }

    public TipoLocalidad(BigDecimal idTipoLocalidad, String nombre, BigInteger status) {
        this.idTipoLocalidad = idTipoLocalidad;
        this.nombre = nombre;
        this.status = status;
    }

    public BigDecimal getIdTipoLocalidad() {
        return idTipoLocalidad;
    }

    public void setIdTipoLocalidad(BigDecimal idTipoLocalidad) {
        this.idTipoLocalidad = idTipoLocalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<CodigosPostales> getCodigosPostalesCollection() {
        return codigosPostalesCollection;
    }

    public void setCodigosPostalesCollection(Collection<CodigosPostales> codigosPostalesCollection) {
        this.codigosPostalesCollection = codigosPostalesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoLocalidad != null ? idTipoLocalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoLocalidad)) {
            return false;
        }
        TipoLocalidad other = (TipoLocalidad) object;
        if ((this.idTipoLocalidad == null && other.idTipoLocalidad != null) || (this.idTipoLocalidad != null && !this.idTipoLocalidad.equals(other.idTipoLocalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.TipoLocalidad[ idTipoLocalidad=" + idTipoLocalidad + " ]";
    }
    
}
