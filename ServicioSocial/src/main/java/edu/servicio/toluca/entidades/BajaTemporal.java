/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author SATELLITE
 */
@Entity
@Table(name = "BAJA_TEMPORAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BajaTemporal.findAll", query = "SELECT b FROM BajaTemporal b"),
    @NamedQuery(name = "BajaTemporal.findById", query = "SELECT b FROM BajaTemporal b WHERE b.id = :id"),
    @NamedQuery(name = "BajaTemporal.findByFechaBaja", query = "SELECT b FROM BajaTemporal b WHERE b.fechaBaja = :fechaBaja"),
    @NamedQuery(name = "BajaTemporal.findByFechaLimiteBaja", query = "SELECT b FROM BajaTemporal b WHERE b.fechaLimiteBaja = :fechaLimiteBaja")})
public class BajaTemporal implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "bajaTemporal", strategy = "increment")
    @Id
    @GeneratedValue(generator="bajaTemporal")
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @NotNull (message ="Introduzca la Fecha de Inicio de la Baja temporal" )
    @Column(name = "FECHA_BAJA")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    @NotNull (message ="Introduzca la Fecha Maxima para la baja Temporal" )
    @Column(name = "FECHA_LIMITE_BAJA")
    @Temporal(TemporalType.DATE)
    private Date fechaLimiteBaja;
    @JoinColumn(name = "DATOS_PERSONALES_ID", referencedColumnName = "ID")
    @ManyToOne
    private DatosPersonales datosPersonalesId;

    public BajaTemporal() {
    }

    public BajaTemporal(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Date getFechaLimiteBaja() {
        return fechaLimiteBaja;
    }

    public void setFechaLimiteBaja(Date fechaLimiteBaja) {
        this.fechaLimiteBaja = fechaLimiteBaja;
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
        if (!(object instanceof BajaTemporal)) {
            return false;
        }
        BajaTemporal other = (BajaTemporal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.BajaTemporal[ id=" + id + " ]";
    }
    
}
