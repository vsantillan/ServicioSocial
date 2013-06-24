/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jonny
 */
@Entity
@Table(name = "PROGRAMA_GENERAL", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramaGeneral.findAll", query = "SELECT p FROM ProgramaGeneral p"),
    @NamedQuery(name = "ProgramaGeneral.findById", query = "SELECT p FROM ProgramaGeneral p WHERE p.id = :id"),
    @NamedQuery(name = "ProgramaGeneral.findByNombreProgramaGenaral", query = "SELECT p FROM ProgramaGeneral p WHERE p.nombreProgramaGenaral = :nombreProgramaGenaral"),
    @NamedQuery(name = "ProgramaGeneral.findByFechaSubida", query = "SELECT p FROM ProgramaGeneral p WHERE p.fechaSubida = :fechaSubida")})
public class ProgramaGeneral implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_PROGRAMA_GENARAL")
    private String nombreProgramaGenaral;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "PROGRAMA_GENERAL")
    private Serializable programaGeneral;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_SUBIDA")
    @Temporal(TemporalType.DATE)
    private Date fechaSubida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programaGeneralId")
    private Collection<DetalleProgGral> detalleProgGralCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programaGeneralId")
    private Collection<Becado> becadoCollection;

    public ProgramaGeneral() {
    }

    public ProgramaGeneral(BigDecimal id) {
        this.id = id;
    }

    public ProgramaGeneral(BigDecimal id, String nombreProgramaGenaral, Serializable programaGeneral, Date fechaSubida) {
        this.id = id;
        this.nombreProgramaGenaral = nombreProgramaGenaral;
        this.programaGeneral = programaGeneral;
        this.fechaSubida = fechaSubida;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombreProgramaGenaral() {
        return nombreProgramaGenaral;
    }

    public void setNombreProgramaGenaral(String nombreProgramaGenaral) {
        this.nombreProgramaGenaral = nombreProgramaGenaral;
    }

    public Serializable getProgramaGeneral() {
        return programaGeneral;
    }

    public void setProgramaGeneral(Serializable programaGeneral) {
        this.programaGeneral = programaGeneral;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    @XmlTransient
    public Collection<DetalleProgGral> getDetalleProgGralCollection() {
        return detalleProgGralCollection;
    }

    public void setDetalleProgGralCollection(Collection<DetalleProgGral> detalleProgGralCollection) {
        this.detalleProgGralCollection = detalleProgGralCollection;
    }

    @XmlTransient
    public Collection<Becado> getBecadoCollection() {
        return becadoCollection;
    }

    public void setBecadoCollection(Collection<Becado> becadoCollection) {
        this.becadoCollection = becadoCollection;
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
        if (!(object instanceof ProgramaGeneral)) {
            return false;
        }
        ProgramaGeneral other = (ProgramaGeneral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.ProgramaGeneral[ id=" + id + " ]";
    }
    
}
