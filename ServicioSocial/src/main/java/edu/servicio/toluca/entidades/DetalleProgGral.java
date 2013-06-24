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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Jonny
 */
@Entity
@Table(name = "DETALLE_PROG_GRAL", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleProgGral.findAll", query = "SELECT d FROM DetalleProgGral d"),
    @NamedQuery(name = "DetalleProgGral.findById", query = "SELECT d FROM DetalleProgGral d WHERE d.id = :id"),
    @NamedQuery(name = "DetalleProgGral.findByMes", query = "SELECT d FROM DetalleProgGral d WHERE d.mes = :mes"),
    @NamedQuery(name = "DetalleProgGral.findByHoras", query = "SELECT d FROM DetalleProgGral d WHERE d.horas = :horas")})
public class DetalleProgGral implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "MES")
    private String mes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAS")
    private BigInteger horas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleProgGralId")
    private Collection<DetProgGralActiv> detProgGralActivCollection;
    @JoinColumn(name = "PROGRAMA_GENERAL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ProgramaGeneral programaGeneralId;

    public DetalleProgGral() {
    }

    public DetalleProgGral(BigDecimal id) {
        this.id = id;
    }

    public DetalleProgGral(BigDecimal id, String mes, BigInteger horas) {
        this.id = id;
        this.mes = mes;
        this.horas = horas;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public BigInteger getHoras() {
        return horas;
    }

    public void setHoras(BigInteger horas) {
        this.horas = horas;
    }

    @XmlTransient
    public Collection<DetProgGralActiv> getDetProgGralActivCollection() {
        return detProgGralActivCollection;
    }

    public void setDetProgGralActivCollection(Collection<DetProgGralActiv> detProgGralActivCollection) {
        this.detProgGralActivCollection = detProgGralActivCollection;
    }

    public ProgramaGeneral getProgramaGeneralId() {
        return programaGeneralId;
    }

    public void setProgramaGeneralId(ProgramaGeneral programaGeneralId) {
        this.programaGeneralId = programaGeneralId;
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
        if (!(object instanceof DetalleProgGral)) {
            return false;
        }
        DetalleProgGral other = (DetalleProgGral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.DetalleProgGral[ id=" + id + " ]";
    }
    
}
