/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SATELLITE
 */
@Entity
@Table(name = "REPORTE_GENERAL", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteGeneral.findAll", query = "SELECT r FROM ReporteGeneral r"),
    @NamedQuery(name = "ReporteGeneral.findById", query = "SELECT r FROM ReporteGeneral r WHERE r.id = :id"),
    @NamedQuery(name = "ReporteGeneral.findByIdBecado", query = "SELECT r FROM ReporteGeneral r WHERE r.idBecado = :idBecado"),
    @NamedQuery(name = "ReporteGeneral.findByNombreDeReporteGeneral", query = "SELECT r FROM ReporteGeneral r WHERE r.nombreDeReporteGeneral = :nombreDeReporteGeneral"),
    @NamedQuery(name = "ReporteGeneral.findByFechaSubida", query = "SELECT r FROM ReporteGeneral r WHERE r.fechaSubida = :fechaSubida")})
public class ReporteGeneral implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BECADO")
    private BigInteger idBecado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_DE_REPORTE_GENERAL")
    private String nombreDeReporteGeneral;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "REPORTE_GENERAL")
    private Serializable reporteGeneral;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_SUBIDA")
    @Temporal(TemporalType.DATE)
    private Date fechaSubida;
    @JoinColumn(name = "BECADO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Becado becadoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reporteGeneralId")
    private Collection<DetalleRepGral> detalleRepGralCollection;

    public ReporteGeneral() {
    }

    public ReporteGeneral(BigDecimal id) {
        this.id = id;
    }

    public ReporteGeneral(BigDecimal id, BigInteger idBecado, String nombreDeReporteGeneral, Serializable reporteGeneral, Date fechaSubida) {
        this.id = id;
        this.idBecado = idBecado;
        this.nombreDeReporteGeneral = nombreDeReporteGeneral;
        this.reporteGeneral = reporteGeneral;
        this.fechaSubida = fechaSubida;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getIdBecado() {
        return idBecado;
    }

    public void setIdBecado(BigInteger idBecado) {
        this.idBecado = idBecado;
    }

    public String getNombreDeReporteGeneral() {
        return nombreDeReporteGeneral;
    }

    public void setNombreDeReporteGeneral(String nombreDeReporteGeneral) {
        this.nombreDeReporteGeneral = nombreDeReporteGeneral;
    }

    public Serializable getReporteGeneral() {
        return reporteGeneral;
    }

    public void setReporteGeneral(Serializable reporteGeneral) {
        this.reporteGeneral = reporteGeneral;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public Becado getBecadoId() {
        return becadoId;
    }

    public void setBecadoId(Becado becadoId) {
        this.becadoId = becadoId;
    }

    @XmlTransient
    public Collection<DetalleRepGral> getDetalleRepGralCollection() {
        return detalleRepGralCollection;
    }

    public void setDetalleRepGralCollection(Collection<DetalleRepGral> detalleRepGralCollection) {
        this.detalleRepGralCollection = detalleRepGralCollection;
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
        if (!(object instanceof ReporteGeneral)) {
            return false;
        }
        ReporteGeneral other = (ReporteGeneral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.ReporteGeneral[ id=" + id + " ]";
    }
    
}
