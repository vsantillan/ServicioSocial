/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rodrigo
 */
@Entity
@Table(name = "REG_OBSERVACION_GENERAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegObservacionGeneral.findAll", query = "SELECT r FROM RegObservacionGeneral r"),
    @NamedQuery(name = "RegObservacionGeneral.findById", query = "SELECT r FROM RegObservacionGeneral r WHERE r.id = :id"),
    @NamedQuery(name = "RegObservacionGeneral.findByFecha", query = "SELECT r FROM RegObservacionGeneral r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "RegObservacionGeneral.findByIdLlaveUnica", query = "SELECT r FROM RegObservacionGeneral r WHERE r.idLlaveUnica = :idLlaveUnica")})
public class RegObservacionGeneral implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 22, scale = 0)
    private BigDecimal id;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "ID_LLAVE_UNICA")
    private BigInteger idLlaveUnica;
    @JoinColumn(name = "CATALOGO_OBSERVACION_ID", referencedColumnName = "ID")
    @ManyToOne
    private CatalogoObservaciones catalogoObservacionId;

    public RegObservacionGeneral() {
    }

    public RegObservacionGeneral(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getIdLlaveUnica() {
        return idLlaveUnica;
    }

    public void setIdLlaveUnica(BigInteger idLlaveUnica) {
        this.idLlaveUnica = idLlaveUnica;
    }

    public CatalogoObservaciones getCatalogoObservacionId() {
        return catalogoObservacionId;
    }

    public void setCatalogoObservacionId(CatalogoObservaciones catalogoObservacionId) {
        this.catalogoObservacionId = catalogoObservacionId;
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
        if (!(object instanceof RegObservacionGeneral)) {
            return false;
        }
        RegObservacionGeneral other = (RegObservacionGeneral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.RegObservacionGeneral[ id=" + id + " ]";
    }
    
}
