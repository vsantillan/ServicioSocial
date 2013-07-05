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
@Table(name = "TIPO_ORGANIZACION", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoOrganizacion.findAll", query = "SELECT t FROM TipoOrganizacion t"),
    @NamedQuery(name = "TipoOrganizacion.findByIdTipoOrganizacion", query = "SELECT t FROM TipoOrganizacion t WHERE t.idTipoOrganizacion = :idTipoOrganizacion"),
    @NamedQuery(name = "TipoOrganizacion.findByDetalle", query = "SELECT t FROM TipoOrganizacion t WHERE t.detalle = :detalle"),
    @NamedQuery(name = "TipoOrganizacion.findByEstatus", query = "SELECT t FROM TipoOrganizacion t WHERE t.estatus = :estatus")})
public class TipoOrganizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_ORGANIZACION")
    private BigDecimal idTipoOrganizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DETALLE")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTATUS")
    private BigInteger estatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoOrganizacion")
    private Collection<Instancia> instanciaCollection;

    public TipoOrganizacion() {
    }

    public TipoOrganizacion(BigDecimal idTipoOrganizacion) {
        this.idTipoOrganizacion = idTipoOrganizacion;
    }

    public TipoOrganizacion(BigDecimal idTipoOrganizacion, String detalle, BigInteger estatus) {
        this.idTipoOrganizacion = idTipoOrganizacion;
        this.detalle = detalle;
        this.estatus = estatus;
    }

    public BigDecimal getIdTipoOrganizacion() {
        return idTipoOrganizacion;
    }

    public void setIdTipoOrganizacion(BigDecimal idTipoOrganizacion) {
        this.idTipoOrganizacion = idTipoOrganizacion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public BigInteger getEstatus() {
        return estatus;
    }

    public void setEstatus(BigInteger estatus) {
        this.estatus = estatus;
    }

    @XmlTransient
    public Collection<Instancia> getInstanciaCollection() {
        return instanciaCollection;
    }

    public void setInstanciaCollection(Collection<Instancia> instanciaCollection) {
        this.instanciaCollection = instanciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoOrganizacion != null ? idTipoOrganizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoOrganizacion)) {
            return false;
        }
        TipoOrganizacion other = (TipoOrganizacion) object;
        if ((this.idTipoOrganizacion == null && other.idTipoOrganizacion != null) || (this.idTipoOrganizacion != null && !this.idTipoOrganizacion.equals(other.idTipoOrganizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.TipoOrganizacion[ idTipoOrganizacion=" + idTipoOrganizacion + " ]";
    }
    
}
