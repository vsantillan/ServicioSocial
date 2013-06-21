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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bustedvillain
 */
@Entity
@Table(name = "RETROALIMENTACION_INSTANCIA", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RetroalimentacionInstancia.findAll", query = "SELECT r FROM RetroalimentacionInstancia r"),
    @NamedQuery(name = "RetroalimentacionInstancia.findByIdRetroalimentacion", query = "SELECT r FROM RetroalimentacionInstancia r WHERE r.idRetroalimentacion = :idRetroalimentacion"),
    @NamedQuery(name = "RetroalimentacionInstancia.findByFecha", query = "SELECT r FROM RetroalimentacionInstancia r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "RetroalimentacionInstancia.findByDetalle", query = "SELECT r FROM RetroalimentacionInstancia r WHERE r.detalle = :detalle"),
    @NamedQuery(name = "RetroalimentacionInstancia.findByEstatus", query = "SELECT r FROM RetroalimentacionInstancia r WHERE r.estatus = :estatus")})
public class RetroalimentacionInstancia implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RETROALIMENTACION")
    private BigDecimal idRetroalimentacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DETALLE")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTATUS")
    private BigInteger estatus;
    @JoinColumn(name = "ID_INSTANCIA", referencedColumnName = "ID_INSTANCIA")
    @ManyToOne(optional = false)
    private Instancia idInstancia;

    public RetroalimentacionInstancia() {
    }

    public RetroalimentacionInstancia(BigDecimal idRetroalimentacion) {
        this.idRetroalimentacion = idRetroalimentacion;
    }

    public RetroalimentacionInstancia(BigDecimal idRetroalimentacion, Date fecha, String detalle, BigInteger estatus) {
        this.idRetroalimentacion = idRetroalimentacion;
        this.fecha = fecha;
        this.detalle = detalle;
        this.estatus = estatus;
    }

    public BigDecimal getIdRetroalimentacion() {
        return idRetroalimentacion;
    }

    public void setIdRetroalimentacion(BigDecimal idRetroalimentacion) {
        this.idRetroalimentacion = idRetroalimentacion;
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

    public BigInteger getEstatus() {
        return estatus;
    }

    public void setEstatus(BigInteger estatus) {
        this.estatus = estatus;
    }

    public Instancia getIdInstancia() {
        return idInstancia;
    }

    public void setIdInstancia(Instancia idInstancia) {
        this.idInstancia = idInstancia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRetroalimentacion != null ? idRetroalimentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetroalimentacionInstancia)) {
            return false;
        }
        RetroalimentacionInstancia other = (RetroalimentacionInstancia) object;
        if ((this.idRetroalimentacion == null && other.idRetroalimentacion != null) || (this.idRetroalimentacion != null && !this.idRetroalimentacion.equals(other.idRetroalimentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.RetroalimentacionInstancia[ idRetroalimentacion=" + idRetroalimentacion + " ]";
    }
    
}
