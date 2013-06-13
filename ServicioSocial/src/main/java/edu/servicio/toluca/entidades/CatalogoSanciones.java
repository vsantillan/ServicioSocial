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
@Table(name = "CATALOGO_SANCIONES", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoSanciones.findAll", query = "SELECT c FROM CatalogoSanciones c"),
    @NamedQuery(name = "CatalogoSanciones.findById", query = "SELECT c FROM CatalogoSanciones c WHERE c.id = :id"),
    @NamedQuery(name = "CatalogoSanciones.findByDetalle", query = "SELECT c FROM CatalogoSanciones c WHERE c.detalle = :detalle"),
    @NamedQuery(name = "CatalogoSanciones.findByHorasSancion", query = "SELECT c FROM CatalogoSanciones c WHERE c.horasSancion = :horasSancion"),
    @NamedQuery(name = "CatalogoSanciones.findByTolerancia", query = "SELECT c FROM CatalogoSanciones c WHERE c.tolerancia = :tolerancia")})
public class CatalogoSanciones implements Serializable {
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
    @Column(name = "HORAS_SANCION")
    private BigInteger horasSancion;
    @Column(name = "TOLERANCIA")
    private BigInteger tolerancia;
    @OneToMany(mappedBy = "catalogoSancionesId")
    private Collection<Sanciones> sancionesCollection;

    public CatalogoSanciones() {
    }

    public CatalogoSanciones(BigDecimal id) {
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

    public BigInteger getHorasSancion() {
        return horasSancion;
    }

    public void setHorasSancion(BigInteger horasSancion) {
        this.horasSancion = horasSancion;
    }

    public BigInteger getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(BigInteger tolerancia) {
        this.tolerancia = tolerancia;
    }

    @XmlTransient
    public Collection<Sanciones> getSancionesCollection() {
        return sancionesCollection;
    }

    public void setSancionesCollection(Collection<Sanciones> sancionesCollection) {
        this.sancionesCollection = sancionesCollection;
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
        if (!(object instanceof CatalogoSanciones)) {
            return false;
        }
        CatalogoSanciones other = (CatalogoSanciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.CatalogoSanciones[ id=" + id + " ]";
    }
    
}
