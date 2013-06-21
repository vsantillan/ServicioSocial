/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author bustedvillain
 */
@Entity
@Table(name = "CATALOGO_OBSERVACIONES", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoObservaciones.findAll", query = "SELECT c FROM CatalogoObservaciones c"),
    @NamedQuery(name = "CatalogoObservaciones.findById", query = "SELECT c FROM CatalogoObservaciones c WHERE c.id = :id"),
    @NamedQuery(name = "CatalogoObservaciones.findByDetalle", query = "SELECT c FROM CatalogoObservaciones c WHERE c.detalle = :detalle")})
public class CatalogoObservaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 300)
    @Column(name = "DETALLE")
    private String detalle;
    @OneToMany(mappedBy = "catalogoObservacionId")
    private Collection<RegObservaciones> regObservacionesCollection;

    public CatalogoObservaciones() {
    }

    public CatalogoObservaciones(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @XmlTransient
    public Collection<RegObservaciones> getRegObservacionesCollection() {
        return regObservacionesCollection;
    }

    public void setRegObservacionesCollection(Collection<RegObservaciones> regObservacionesCollection) {
        this.regObservacionesCollection = regObservacionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoObservaciones)) {
            return false;
        }
        CatalogoObservaciones other = (CatalogoObservaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.CatalogoObservaciones[ id=" + id + " ]";
    }
    
}
