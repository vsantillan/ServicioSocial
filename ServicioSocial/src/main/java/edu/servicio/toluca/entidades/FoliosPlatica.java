/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ekt
 */
@Entity
@Table(name = "FOLIOS_PLATICA", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoliosPlatica.findAll", query = "SELECT f FROM FoliosPlatica f"),
    @NamedQuery(name = "FoliosPlatica.findById", query = "SELECT f FROM FoliosPlatica f WHERE f.id = :id"),
    @NamedQuery(name = "FoliosPlatica.findByAsistencia", query = "SELECT f FROM FoliosPlatica f WHERE f.asistencia = :asistencia"),
    @NamedQuery(name = "FoliosPlatica.findByNumeroFolio", query = "SELECT f FROM FoliosPlatica f WHERE f.numeroFolio = :numeroFolio"),
    @NamedQuery(name = "FoliosPlatica.findByStatus", query = "SELECT f FROM FoliosPlatica f WHERE f.status = :status")})
public class FoliosPlatica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "ASISTENCIA")
    private Short asistencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_FOLIO")
    private long numeroFolio;
    @Column(name = "STATUS")
    private Short status;
    @JoinColumn(name = "ALUMNO_ID", referencedColumnName = "ID")
    @ManyToOne
    private VistaAlumno alumnoId;
    @JoinColumn(name = "PLATICA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Platica platicaId;

    public FoliosPlatica() {
    }

    public FoliosPlatica(Long id) {
        this.id = id;
    }

    public FoliosPlatica(Long id, long numeroFolio) {
        this.id = id;
        this.numeroFolio = numeroFolio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Short asistencia) {
        this.asistencia = asistencia;
    }

    public long getNumeroFolio() {
        return numeroFolio;
    }

    public void setNumeroFolio(long numeroFolio) {
        this.numeroFolio = numeroFolio;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public VistaAlumno getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(VistaAlumno alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Platica getPlaticaId() {
        return platicaId;
    }

    public void setPlaticaId(Platica platicaId) {
        this.platicaId = platicaId;
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
        if (!(object instanceof FoliosPlatica)) {
            return false;
        }
        FoliosPlatica other = (FoliosPlatica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.FoliosPlatica[ id=" + id + " ]";
    }
    
}