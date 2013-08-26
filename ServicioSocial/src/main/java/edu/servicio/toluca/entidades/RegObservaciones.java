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
@Table(name = "REG_OBSERVACIONES", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegObservaciones.findAll", query = "SELECT r FROM RegObservaciones r"),
    @NamedQuery(name = "RegObservaciones.findById", query = "SELECT r FROM RegObservaciones r WHERE r.id = :id"),
    @NamedQuery(name = "RegObservaciones.findByFecha", query = "SELECT r FROM RegObservaciones r WHERE r.fecha = :fecha")})
public class RegObservaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GeneratedValue(generator="regObservacionG") 
    @GenericGenerator(name = "regObservacionG", strategy = "increment")
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "DATOS_PERSONALES_ID", referencedColumnName = "ID")
    @ManyToOne
    private DatosPersonales datosPersonalesId;
    @JoinColumn(name = "CATALOGO_OBSERVACION_ID", referencedColumnName = "ID")
    @ManyToOne
    private CatalogoObservaciones catalogoObservacionId;

    public RegObservaciones() {
    }

    public RegObservaciones(BigDecimal id) {
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

    public DatosPersonales getDatosPersonalesId() {
        return datosPersonalesId;
    }

    public void setDatosPersonalesId(DatosPersonales datosPersonalesId) {
        this.datosPersonalesId = datosPersonalesId;
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
        if (!(object instanceof RegObservaciones)) {
            return false;
        }
        RegObservaciones other = (RegObservaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.RegObservaciones[ id=" + id + " ]";
    }
    
}
