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
 * @author SATELLITE
 */
@Entity
@Table(name = "PROGRAMA", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programa.findAll", query = "SELECT p FROM Programa p"),
    @NamedQuery(name = "Programa.findByIdPrograma", query = "SELECT p FROM Programa p WHERE p.idPrograma = :idPrograma"),
    @NamedQuery(name = "Programa.findByDescripcion", query = "SELECT p FROM Programa p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Programa.findByStatus", query = "SELECT p FROM Programa p WHERE p.status = :status"),
    @NamedQuery(name = "Programa.findBySiglas", query = "SELECT p FROM Programa p WHERE p.siglas = :siglas")})
public class Programa implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROGRAMA")
    private BigDecimal idPrograma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private BigInteger status;
    @Size(max = 4)
    @Column(name = "SIGLAS")
    private String siglas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrograma")
    private Collection<Proyectos> proyectosCollection;

    public Programa() {
    }

    public Programa(BigDecimal idPrograma) {
        this.idPrograma = idPrograma;
    }

    public Programa(BigDecimal idPrograma, String descripcion, BigInteger status) {
        this.idPrograma = idPrograma;
        this.descripcion = descripcion;
        this.status = status;
    }

    public BigDecimal getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(BigDecimal idPrograma) {
        this.idPrograma = idPrograma;
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

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
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
        hash += (idPrograma != null ? idPrograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.idPrograma == null && other.idPrograma != null) || (this.idPrograma != null && !this.idPrograma.equals(other.idPrograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.Programa[ idPrograma=" + idPrograma + " ]";
    }
    
}
