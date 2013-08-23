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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SATELLITE
 */
@Entity
@Table(name = "LOG_ADMIN", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogAdmin.findAll", query = "SELECT l FROM LogAdmin l"),
    @NamedQuery(name = "LogAdmin.findByIdLog", query = "SELECT l FROM LogAdmin l WHERE l.idLog = :idLog"),
    @NamedQuery(name = "LogAdmin.findByDetalle", query = "SELECT l FROM LogAdmin l WHERE l.detalle = :detalle"),
    @NamedQuery(name = "LogAdmin.findByFecha", query = "SELECT l FROM LogAdmin l WHERE l.fecha = :fecha"),
    @NamedQuery(name = "LogAdmin.findByIdAdmin", query = "SELECT l FROM LogAdmin l WHERE l.idAdmin = :idAdmin")})
public class LogAdmin implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LOG")
    private BigDecimal idLog;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DETALLE")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ADMIN")
    private BigInteger idAdmin;

    public LogAdmin() {
    }

    public LogAdmin(BigDecimal idLog) {
        this.idLog = idLog;
    }

    public LogAdmin(BigDecimal idLog, String detalle, Date fecha, BigInteger idAdmin) {
        this.idLog = idLog;
        this.detalle = detalle;
        this.fecha = fecha;
        this.idAdmin = idAdmin;
    }

    public BigDecimal getIdLog() {
        return idLog;
    }

    public void setIdLog(BigDecimal idLog) {
        this.idLog = idLog;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(BigInteger idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLog != null ? idLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogAdmin)) {
            return false;
        }
        LogAdmin other = (LogAdmin) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.LogAdmin[ idLog=" + idLog + " ]";
    }
    
}
