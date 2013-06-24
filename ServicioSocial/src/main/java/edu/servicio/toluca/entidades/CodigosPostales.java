/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bustedvillain
 */
@Entity
@Table(name = "CODIGOS_POSTALES", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodigosPostales.findAll", query = "SELECT c FROM CodigosPostales c"),
    @NamedQuery(name = "CodigosPostales.findByIdCp", query = "SELECT c FROM CodigosPostales c WHERE c.idCp = :idCp"),
    @NamedQuery(name = "CodigosPostales.findByCp", query = "SELECT c FROM CodigosPostales c WHERE c.cp = :cp")})
public class CodigosPostales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CP")
    private Integer idCp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CP")
    private int cp;
    @OneToMany(mappedBy = "idCp", fetch = FetchType.EAGER)
    private Collection<Colonia> coloniaCollection;
    @JoinColumn(name = "ID_TIPO_LOCALIDAD", referencedColumnName = "ID_TIPO_LOCALIDAD")
    @ManyToOne(optional = false)
    private TipoLocalidad idTipoLocalidad;
    @JoinColumn(name = "ID_MUNICIPIO", referencedColumnName = "ID_MUNICIPIO")
    @ManyToOne(optional = false)
    private MunicipiosSia idMunicipio;
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO")
    @ManyToOne(optional = false)
    private EstadosSia idEstado;
    @JoinColumn(name = "ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne
    private Ciudades idCiudad;

    public CodigosPostales() {
    }

    public CodigosPostales(Integer idCp) {
        this.idCp = idCp;
    }

    public CodigosPostales(Integer idCp, int cp) {
        this.idCp = idCp;
        this.cp = cp;
    }

    public Integer getIdCp() {
        return idCp;
    }

    public void setIdCp(Integer idCp) {
        this.idCp = idCp;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    @XmlTransient
    public Collection<Colonia> getColoniaCollection() {
        return coloniaCollection;
    }

    public void setColoniaCollection(Collection<Colonia> coloniaCollection) {
        this.coloniaCollection = coloniaCollection;
    }

    public TipoLocalidad getIdTipoLocalidad() {
        return idTipoLocalidad;
    }

    public void setIdTipoLocalidad(TipoLocalidad idTipoLocalidad) {
        this.idTipoLocalidad = idTipoLocalidad;
    }

    public MunicipiosSia getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(MunicipiosSia idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public EstadosSia getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadosSia idEstado) {
        this.idEstado = idEstado;
    }

    public Ciudades getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudades idCiudad) {
        this.idCiudad = idCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCp != null ? idCp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodigosPostales)) {
            return false;
        }
        CodigosPostales other = (CodigosPostales) object;
        if ((this.idCp == null && other.idCp != null) || (this.idCp != null && !this.idCp.equals(other.idCp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.CodigosPostales[ idCp=" + idCp + " ]";
    }
    
}
