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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author SATELLITE
 */
@Cache(usage = CacheConcurrencyStrategy.NONE)
@Entity
@Table(name = "LUGARES_PLATICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LugaresPlatica.findAll", query = "SELECT l FROM LugaresPlatica l"),
    @NamedQuery(name = "LugaresPlatica.findById", query = "SELECT l FROM LugaresPlatica l WHERE l.id = :id"),
    @NamedQuery(name = "LugaresPlatica.findByLugar", query = "SELECT l FROM LugaresPlatica l WHERE l.lugar = :lugar"),
    @NamedQuery(name = "LugaresPlatica.findByStatus", query = "SELECT l FROM LugaresPlatica l WHERE l.status = :status")})
public class LugaresPlatica implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Id
    @Basic(optional = false)
//    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "LUGAR")
    private String lugar;
    @Column(name = "STATUS")
    private BigInteger status;
    @OneToMany(mappedBy = "idLugar")
    private Collection<Platica> platicaCollection;

    public LugaresPlatica() {
    }

    public LugaresPlatica(BigDecimal id) {
        this.id = id;
    }

    public LugaresPlatica(BigDecimal id, String lugar) {
        this.id = id;
        this.lugar = lugar;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Platica> getPlaticaCollection() {
        return platicaCollection;
    }

    public void setPlaticaCollection(Collection<Platica> platicaCollection) {
        this.platicaCollection = platicaCollection;
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
        if (!(object instanceof LugaresPlatica)) {
            return false;
        }
        LugaresPlatica other = (LugaresPlatica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.LugaresPlatica[ id=" + id + " ]";
    }
    
}
