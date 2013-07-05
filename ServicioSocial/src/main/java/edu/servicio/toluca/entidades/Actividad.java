/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SATELLITE
 */
@Entity
@Table(name = "ACTIVIDAD", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findById", query = "SELECT a FROM Actividad a WHERE a.id = :id"),
    @NamedQuery(name = "Actividad.findByActividad", query = "SELECT a FROM Actividad a WHERE a.actividad = :actividad"),
    @NamedQuery(name = "Actividad.findByDescripcion", query = "SELECT a FROM Actividad a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Actividad.findByStatus", query = "SELECT a FROM Actividad a WHERE a.status = :status")})
public class Actividad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ACTIVIDAD")
    private String actividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STATUS")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadId")
    private Collection<DetProgGralActiv> detProgGralActivCollection;
    @JoinColumn(name = "ENFOQUE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Enfoque enfoqueId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadId")
    private Collection<DetRepMenAct> detRepMenActCollection;

    public Actividad() {
    }

    public Actividad(BigDecimal id) {
        this.id = id;
    }

    public Actividad(BigDecimal id, String actividad, String descripcion, String status) {
        this.id = id;
        this.actividad = actividad;
        this.descripcion = descripcion;
        this.status = status;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<DetProgGralActiv> getDetProgGralActivCollection() {
        return detProgGralActivCollection;
    }

    public void setDetProgGralActivCollection(Collection<DetProgGralActiv> detProgGralActivCollection) {
        this.detProgGralActivCollection = detProgGralActivCollection;
    }

    public Enfoque getEnfoqueId() {
        return enfoqueId;
    }

    public void setEnfoqueId(Enfoque enfoqueId) {
        this.enfoqueId = enfoqueId;
    }

    @XmlTransient
    public Collection<DetRepMenAct> getDetRepMenActCollection() {
        return detRepMenActCollection;
    }

    public void setDetRepMenActCollection(Collection<DetRepMenAct> detRepMenActCollection) {
        this.detRepMenActCollection = detRepMenActCollection;
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
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.Actividad[ id=" + id + " ]";
    }
    
}
