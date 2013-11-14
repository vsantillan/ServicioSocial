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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author SATELLITE
 */
@Entity
@Table(name = "LOG_SERVICIO", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogServicio.findAll", query = "SELECT l FROM LogServicio l"),
    @NamedQuery(name = "LogServicio.findById", query = "SELECT l FROM LogServicio l WHERE l.id = :id"),
    @NamedQuery(name = "LogServicio.findByFecha", query = "SELECT l FROM LogServicio l WHERE l.fecha = :fecha"),
    @NamedQuery(name = "LogServicio.findByDetalle", query = "SELECT l FROM LogServicio l WHERE l.detalle = :detalle"),
    @NamedQuery(name = "LogServicio.findByTipoLog", query = "SELECT l FROM LogServicio l WHERE l.tipoLog = :tipoLog"),
    @NamedQuery(name = "LogServicio.findByAlumnoId", query = "SELECT l FROM LogServicio l WHERE l.alumnoId = :alumnoId")})
public class LogServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 300)
    @Column(name = "DETALLE")
    private String detalle;
    @Column(name = "TIPO_LOG")
    private BigInteger tipoLog;
    @Column(name = "ALUMNO_ID")
    private BigInteger alumnoId;
    @JoinColumn(name = "DATOS_PERSONALES_ID", referencedColumnName = "ID")
    @ManyToOne
    private DatosPersonales datosPersonalesId;

    public LogServicio() {
    }

    public LogServicio(BigDecimal id) {
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public BigInteger getTipoLog() {
        return tipoLog;
    }

    public void setTipoLog(BigInteger tipoLog) {
        this.tipoLog = tipoLog;
    }

    public BigInteger getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(BigInteger alumnoId) {
        this.alumnoId = alumnoId;
    }

    public DatosPersonales getDatosPersonalesId() {
        return datosPersonalesId;
    }

    public void setDatosPersonalesId(DatosPersonales datosPersonalesId) {
        this.datosPersonalesId = datosPersonalesId;
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
        if (!(object instanceof LogServicio)) {
            return false;
        }
        LogServicio other = (LogServicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.LogServicio[ id=" + id + " ]";
    }
    
}
