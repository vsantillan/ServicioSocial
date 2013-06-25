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
import javax.persistence.FetchType;
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
@Table(name = "ESTADOS_SIA", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosSia.findAll", query = "SELECT e FROM EstadosSia e"),
    @NamedQuery(name = "EstadosSia.findByIdEstado", query = "SELECT e FROM EstadosSia e WHERE e.idEstado = :idEstado"),
    @NamedQuery(name = "EstadosSia.findByNombre", query = "SELECT e FROM EstadosSia e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadosSia.findByStatus", query = "SELECT e FROM EstadosSia e WHERE e.status = :status")})
public class EstadosSia implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADO")
    private BigDecimal idEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private BigInteger status;
    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "idEstado")
    private Collection<CodigosPostales> codigosPostalesCollection;

    public EstadosSia() {
    }

    public EstadosSia(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }

    public EstadosSia(BigDecimal idEstado, String nombre, BigInteger status) {
        this.idEstado = idEstado;
        this.nombre = nombre;
        this.status = status;
    }

    public BigDecimal getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<CodigosPostales> getCodigosPostalesCollection() {
        return codigosPostalesCollection;
    }

    public void setCodigosPostalesCollection(Collection<CodigosPostales> codigosPostalesCollection) {
        this.codigosPostalesCollection = codigosPostalesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosSia)) {
            return false;
        }
        EstadosSia other = (EstadosSia) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.EstadosSia[ idEstado=" + idEstado + " ]";
    }
    
}
