/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Jonny
 */
@Entity
@Table(name = "TIPO_PROYECTO", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProyecto.findAll", query = "SELECT t FROM TipoProyecto t"),
    @NamedQuery(name = "TipoProyecto.findByIdTipoProyecto", query = "SELECT t FROM TipoProyecto t WHERE t.idTipoProyecto = :idTipoProyecto"),
    @NamedQuery(name = "TipoProyecto.findByDescripcion", query = "SELECT t FROM TipoProyecto t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoProyecto.findByStatus", query = "SELECT t FROM TipoProyecto t WHERE t.status = :status")})
public class TipoProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_PROYECTO")
    private BigDecimal idTipoProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private BigInteger status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoProyecto")
    private Collection<Proyectos> proyectosCollection;

    public TipoProyecto() {
    }

    public TipoProyecto(BigDecimal idTipoProyecto) {
        this.idTipoProyecto = idTipoProyecto;
    }

    public TipoProyecto(BigDecimal idTipoProyecto, String descripcion, BigInteger status) {
        this.idTipoProyecto = idTipoProyecto;
        this.descripcion = descripcion;
        this.status = status;
    }

    public BigDecimal getIdTipoProyecto() {
        return idTipoProyecto;
    }

    public void setIdTipoProyecto(BigDecimal idTipoProyecto) {
        this.idTipoProyecto = idTipoProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Proyectos> getProyectosCollection() {
        return proyectosCollection;
    }

    public void setProyectosCollection(Collection<Proyectos> proyectosCollection) {
        this.proyectosCollection = proyectosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoProyecto != null ? idTipoProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProyecto)) {
            return false;
        }
        TipoProyecto other = (TipoProyecto) object;
        if ((this.idTipoProyecto == null && other.idTipoProyecto != null) || (this.idTipoProyecto != null && !this.idTipoProyecto.equals(other.idTipoProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.TipoProyecto[ idTipoProyecto=" + idTipoProyecto + " ]";
    }
    
}
