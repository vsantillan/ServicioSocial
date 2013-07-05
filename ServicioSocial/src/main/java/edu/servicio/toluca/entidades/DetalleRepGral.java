/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SATELLITE
 */
@Entity
@Table(name = "DETALLE_REP_GRAL", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleRepGral.findAll", query = "SELECT d FROM DetalleRepGral d"),
    @NamedQuery(name = "DetalleRepGral.findById", query = "SELECT d FROM DetalleRepGral d WHERE d.id = :id"),
    @NamedQuery(name = "DetalleRepGral.findByMes", query = "SELECT d FROM DetalleRepGral d WHERE d.mes = :mes"),
    @NamedQuery(name = "DetalleRepGral.findByDescripcion", query = "SELECT d FROM DetalleRepGral d WHERE d.descripcion = :descripcion")})
public class DetalleRepGral implements Serializable {
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
    @Size(min = 1, max = 2700)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "REPORTE_GENERAL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ReporteGeneral reporteGeneralId;

    public DetalleRepGral() {
    }

    public DetalleRepGral(BigDecimal id) {
        this.id = id;
    }

    public DetalleRepGral(BigDecimal id, String mes, String descripcion) {
        this.id = id;
        this.mes = mes;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ReporteGeneral getReporteGeneralId() {
        return reporteGeneralId;
    }

    public void setReporteGeneralId(ReporteGeneral reporteGeneralId) {
        this.reporteGeneralId = reporteGeneralId;
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
        if (!(object instanceof DetalleRepGral)) {
            return false;
        }
        DetalleRepGral other = (DetalleRepGral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.DetalleRepGral[ id=" + id + " ]";
    }
    
}
