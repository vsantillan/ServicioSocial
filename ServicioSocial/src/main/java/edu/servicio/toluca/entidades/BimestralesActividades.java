/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author SATELLITE
 */
@Entity
@Table(name = "BIMESTRALES_ACTIVIDADES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BimestralesActividades.findAll", query = "SELECT b FROM BimestralesActividades b"),
    @NamedQuery(name = "BimestralesActividades.findById", query = "SELECT b FROM BimestralesActividades b WHERE b.id = :id")})
public class BimestralesActividades implements Serializable {
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "ID_ACTIVIDAD")
//    private BigInteger idActividad;
    @JoinColumn(name = "ID_ACTIVIDADES", referencedColumnName = "ID_ACTIVIDAD")
    @ManyToOne
    private Actividades idActividades;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "repostesBimestralesActividades", strategy = "increment")
    @Id
    @GeneratedValue(generator="repostesBimestralesActividades")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "ID_REPORTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Reportes idReporte;
//    @JoinColumn(name = "ID_ACTIVIDAD", referencedColumnName = "ID")
//    @ManyToOne(optional = false)
//    private Actividad idActividad;

    public BimestralesActividades() {
    }

    public BimestralesActividades(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Reportes getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Reportes idReporte) {
        this.idReporte = idReporte;
    }

//    public Actividad getIdActividad() {
//        return idActividad;
//    }
//
//    public void setIdActividad(Actividad idActividad) {
//        this.idActividad = idActividad;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BimestralesActividades)) {
            return false;
        }
        BimestralesActividades other = (BimestralesActividades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.BimestralesActividades[ id=" + id + " ]";
    }

//    public BigInteger getIdActividad() {
//        return idActividad;
//    }
//
//    public void setIdActividad(BigInteger idActividad) {
//        this.idActividad = idActividad;
//    }

    public Actividades getIdActividades() {
        return idActividades;
    }

    public void setIdActividades(Actividades idActividades) {
        this.idActividades = idActividades;
    }
    
}
