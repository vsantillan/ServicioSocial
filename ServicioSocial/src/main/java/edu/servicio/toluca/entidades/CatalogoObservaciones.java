/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Jesus
 */
@Entity
@Table(name = "CATALOGO_OBSERVACIONES", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoObservaciones.findAll", query = "SELECT c FROM CatalogoObservaciones c"),
    @NamedQuery(name = "CatalogoObservaciones.findById", query = "SELECT c FROM CatalogoObservaciones c WHERE c.id = :id"),
    @NamedQuery(name = "CatalogoObservaciones.findByDetalle", query = "SELECT c FROM CatalogoObservaciones c WHERE c.detalle = :detalle"),
    @NamedQuery(name = "CatalogoObservaciones.findByTipo", query = "SELECT c FROM CatalogoObservaciones c WHERE c.tipo = :tipo")})
public class CatalogoObservaciones implements Serializable {
    @OneToMany(mappedBy = "catalogoObservacionId")
    private Collection<RegObservacionGeneral> regObservacionGeneralCollection;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @NotNull
    @Size(min=1,max = 300,message="El tamaño debe ser menor a 300 caracteres")
    @Column(name = "DETALLE")
    private String detalle;
    //tipo 0:Eliminado 1: Formato Unico 2: Reportes Bimestrales 3:Documentos Finales 4:Organizacions 5:proyectos
    @Column(name = "TIPO") 
    private BigInteger tipo;
    @OneToMany(mappedBy = "catalogoObservacionId")
    private Collection<RegObservaciones> regObservacionesCollection;


    public CatalogoObservaciones() {
    }

    public CatalogoObservaciones(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    
    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public BigInteger getTipo() {
        return tipo;
    }

    public void setTipo(BigInteger tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @XmlTransient
    public Collection<RegObservaciones> getRegObservacionesCollection() {
        return regObservacionesCollection;
    }

    public void setRegObservacionesCollection(Collection<RegObservaciones> regObservacionesCollection) {
        this.regObservacionesCollection = regObservacionesCollection;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoObservaciones)) {
            return false;
        }
        CatalogoObservaciones other = (CatalogoObservaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.CatalogoObservaciones[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<RegObservacionGeneral> getRegObservacionGeneralCollection() {
        return regObservacionGeneralCollection;
    }

    public void setRegObservacionGeneralCollection(Collection<RegObservacionGeneral> regObservacionGeneralCollection) {
        this.regObservacionGeneralCollection = regObservacionGeneralCollection;
    }
    
}
