/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonny
 */
@Entity
@Table(name = "DET_PROG_GRAL_ACTIV", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetProgGralActiv.findAll", query = "SELECT d FROM DetProgGralActiv d"),
    @NamedQuery(name = "DetProgGralActiv.findById", query = "SELECT d FROM DetProgGralActiv d WHERE d.id = :id"),
    @NamedQuery(name = "DetProgGralActiv.findByHoras", query = "SELECT d FROM DetProgGralActiv d WHERE d.horas = :horas")})
public class DetProgGralActiv implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAS")
    private BigInteger horas;
    @JoinColumn(name = "DETALLE_PROG_GRAL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private DetalleProgGral detalleProgGralId;
    @JoinColumn(name = "ACTIVIDAD_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Actividad actividadId;

    public DetProgGralActiv() {
    }

    public DetProgGralActiv(BigDecimal id) {
        this.id = id;
    }

    public DetProgGralActiv(BigDecimal id, BigInteger horas) {
        this.id = id;
        this.horas = horas;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getHoras() {
        return horas;
    }

    public void setHoras(BigInteger horas) {
        this.horas = horas;
    }

    public DetalleProgGral getDetalleProgGralId() {
        return detalleProgGralId;
    }

    public void setDetalleProgGralId(DetalleProgGral detalleProgGralId) {
        this.detalleProgGralId = detalleProgGralId;
    }

    public Actividad getActividadId() {
        return actividadId;
    }

    public void setActividadId(Actividad actividadId) {
        this.actividadId = actividadId;
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
        if (!(object instanceof DetProgGralActiv)) {
            return false;
        }
        DetProgGralActiv other = (DetProgGralActiv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.DetProgGralActiv[ id=" + id + " ]";
    }
    
}
