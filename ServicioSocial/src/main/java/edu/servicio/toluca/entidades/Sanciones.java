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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ekt
 */
@Entity
@Table(name = "SANCIONES", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sanciones.findAll", query = "SELECT s FROM Sanciones s"),
    @NamedQuery(name = "Sanciones.findById", query = "SELECT s FROM Sanciones s WHERE s.id = :id"),
    @NamedQuery(name = "Sanciones.findByHorasSancion", query = "SELECT s FROM Sanciones s WHERE s.horasSancion = :horasSancion"),
    @NamedQuery(name = "Sanciones.findByFecha", query = "SELECT s FROM Sanciones s WHERE s.fecha = :fecha")})
public class Sanciones implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "HORAS_SANCION")
    private BigInteger horasSancion;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "DATOS_PERSONALES_ID", referencedColumnName = "ID")
    @ManyToOne
    private DatosPersonales datosPersonalesId;
    @JoinColumn(name = "CATALOGO_SANCIONES_ID", referencedColumnName = "ID")
    @ManyToOne
    private CatalogoSanciones catalogoSancionesId;

    public Sanciones() {
    }

    public Sanciones(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getHorasSancion() {
        return horasSancion;
    }

    public void setHorasSancion(BigInteger horasSancion) {
        this.horasSancion = horasSancion;
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

    public CatalogoSanciones getCatalogoSancionesId() {
        return catalogoSancionesId;
    }

    public void setCatalogoSancionesId(CatalogoSanciones catalogoSancionesId) {
        this.catalogoSancionesId = catalogoSancionesId;
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
        if (!(object instanceof Sanciones)) {
            return false;
        }
        Sanciones other = (Sanciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.Sanciones[ id=" + id + " ]";
    }
    
}
