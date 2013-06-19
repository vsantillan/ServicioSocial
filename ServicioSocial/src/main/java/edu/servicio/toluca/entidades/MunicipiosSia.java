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
 * @author ekt
 */
@Entity
@Table(name = "MUNICIPIOS_SIA", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MunicipiosSia.findAll", query = "SELECT m FROM MunicipiosSia m"),
    @NamedQuery(name = "MunicipiosSia.findByIdMunicipio", query = "SELECT m FROM MunicipiosSia m WHERE m.idMunicipio = :idMunicipio"),
    @NamedQuery(name = "MunicipiosSia.findByNombre", query = "SELECT m FROM MunicipiosSia m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "MunicipiosSia.findByStatus", query = "SELECT m FROM MunicipiosSia m WHERE m.status = :status")})
public class MunicipiosSia implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MUNICIPIO")
    private BigDecimal idMunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private BigInteger status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMunicipio")
    private Collection<CodigosPostales> codigosPostalesCollection;

    public MunicipiosSia() {
    }

    public MunicipiosSia(BigDecimal idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public MunicipiosSia(BigDecimal idMunicipio, String nombre, BigInteger status) {
        this.idMunicipio = idMunicipio;
        this.nombre = nombre;
        this.status = status;
    }

    public BigDecimal getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(BigDecimal idMunicipio) {
        this.idMunicipio = idMunicipio;
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
        hash += (idMunicipio != null ? idMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MunicipiosSia)) {
            return false;
        }
        MunicipiosSia other = (MunicipiosSia) object;
        if ((this.idMunicipio == null && other.idMunicipio != null) || (this.idMunicipio != null && !this.idMunicipio.equals(other.idMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.MunicipiosSia[ idMunicipio=" + idMunicipio + " ]";
    }
    
}
