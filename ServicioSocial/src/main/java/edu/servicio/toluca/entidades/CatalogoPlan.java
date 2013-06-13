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
@Table(name = "CATALOGO_PLAN", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoPlan.findAll", query = "SELECT c FROM CatalogoPlan c"),
    @NamedQuery(name = "CatalogoPlan.findById", query = "SELECT c FROM CatalogoPlan c WHERE c.id = :id"),
    @NamedQuery(name = "CatalogoPlan.findByDetalle", query = "SELECT c FROM CatalogoPlan c WHERE c.detalle = :detalle")})
public class CatalogoPlan implements Serializable {
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
    @OneToMany(mappedBy = "catalogoPlanId")
    private Collection<FormatoUnico> formatoUnicoCollection;

    public CatalogoPlan() {
    }

    public CatalogoPlan(BigDecimal id) {
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
    public Collection<FormatoUnico> getFormatoUnicoCollection() {
        return formatoUnicoCollection;
    }

    public void setFormatoUnicoCollection(Collection<FormatoUnico> formatoUnicoCollection) {
        this.formatoUnicoCollection = formatoUnicoCollection;
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
        if (!(object instanceof CatalogoPlan)) {
            return false;
        }
        CatalogoPlan other = (CatalogoPlan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.CatalogoPlan[ id=" + id + " ]";
    }
    
}
