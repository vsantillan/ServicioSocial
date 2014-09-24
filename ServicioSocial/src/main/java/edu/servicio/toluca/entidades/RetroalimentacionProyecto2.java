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
@Table(name = "RETROALIMENTACION_PROYECTO2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RetroalimentacionProyecto2.findAll", query = "SELECT r FROM RetroalimentacionProyecto2 r"),
    @NamedQuery(name = "RetroalimentacionProyecto2.findByIdRetroalimentacionProyecto", query = "SELECT r FROM RetroalimentacionProyecto2 r WHERE r.idRetroalimentacionProyecto = :idRetroalimentacionProyecto"),
    @NamedQuery(name = "RetroalimentacionProyecto2.findByDetalle", query = "SELECT r FROM RetroalimentacionProyecto2 r WHERE r.detalle = :detalle"),
    @NamedQuery(name = "RetroalimentacionProyecto2.findByFecha", query = "SELECT r FROM RetroalimentacionProyecto2 r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "RetroalimentacionProyecto2.findByEstatus", query = "SELECT r FROM RetroalimentacionProyecto2 r WHERE r.estatus = :estatus")})
public class RetroalimentacionProyecto2 implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RETROALIMENTACION_PROYECTO")
    private BigDecimal idRetroalimentacionProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DETALLE")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTATUS")
    private BigInteger estatus;
    @JoinColumn(name = "ID_PROYECTO", referencedColumnName = "ID_PROYECTO")
    @ManyToOne(optional = false)
    private Proyectos idProyecto;

    public RetroalimentacionProyecto2() {
    }

    public RetroalimentacionProyecto2(BigDecimal idRetroalimentacionProyecto) {
        this.idRetroalimentacionProyecto = idRetroalimentacionProyecto;
    }

    public RetroalimentacionProyecto2(BigDecimal idRetroalimentacionProyecto, String detalle, Date fecha, BigInteger estatus) {
        this.idRetroalimentacionProyecto = idRetroalimentacionProyecto;
        this.detalle = detalle;
        this.fecha = fecha;
        this.estatus = estatus;
    }

    public BigDecimal getIdRetroalimentacionProyecto() {
        return idRetroalimentacionProyecto;
    }

    public void setIdRetroalimentacionProyecto(BigDecimal idRetroalimentacionProyecto) {
        this.idRetroalimentacionProyecto = idRetroalimentacionProyecto;
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

    public BigInteger getEstatus() {
        return estatus;
    }

    public void setEstatus(BigInteger estatus) {
        this.estatus = estatus;
    }

    public Proyectos getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyectos idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRetroalimentacionProyecto != null ? idRetroalimentacionProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetroalimentacionProyecto2)) {
            return false;
        }
        RetroalimentacionProyecto2 other = (RetroalimentacionProyecto2) object;
        if ((this.idRetroalimentacionProyecto == null && other.idRetroalimentacionProyecto != null) || (this.idRetroalimentacionProyecto != null && !this.idRetroalimentacionProyecto.equals(other.idRetroalimentacionProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.RetroalimentacionProyecto2[ idRetroalimentacionProyecto=" + idRetroalimentacionProyecto + " ]";
    }
    
}
