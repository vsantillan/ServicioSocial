/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonny
 */
@Entity
@Table(name = "REVISION", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revision.findAll", query = "SELECT r FROM Revision r"),
    @NamedQuery(name = "Revision.findById", query = "SELECT r FROM Revision r WHERE r.id = :id"),
    @NamedQuery(name = "Revision.findByFechaDeRevision", query = "SELECT r FROM Revision r WHERE r.fechaDeRevision = :fechaDeRevision"),
    @NamedQuery(name = "Revision.findByComentario", query = "SELECT r FROM Revision r WHERE r.comentario = :comentario")})
public class Revision implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_DE_REVISION")
    @Temporal(TemporalType.DATE)
    private Date fechaDeRevision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "COMENTARIO")
    private String comentario;
    @JoinColumn(name = "BECADO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Becado becadoId;

    public Revision() {
    }

    public Revision(BigDecimal id) {
        this.id = id;
    }

    public Revision(BigDecimal id, Date fechaDeRevision, String comentario) {
        this.id = id;
        this.fechaDeRevision = fechaDeRevision;
        this.comentario = comentario;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFechaDeRevision() {
        return fechaDeRevision;
    }

    public void setFechaDeRevision(Date fechaDeRevision) {
        this.fechaDeRevision = fechaDeRevision;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Becado getBecadoId() {
        return becadoId;
    }

    public void setBecadoId(Becado becadoId) {
        this.becadoId = becadoId;
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
        if (!(object instanceof Revision)) {
            return false;
        }
        Revision other = (Revision) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.Revision[ id=" + id + " ]";
    }
    
}
