/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author SATELLITE
 */
@Entity
@Table(name = "DET_REP_MEN_ACT", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetRepMenAct.findAll", query = "SELECT d FROM DetRepMenAct d"),
    @NamedQuery(name = "DetRepMenAct.findById", query = "SELECT d FROM DetRepMenAct d WHERE d.id = :id")})
public class DetRepMenAct implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "DET_REP_MEN_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private DetRepMen detRepMenId;
    @JoinColumn(name = "ACTIVIDAD_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Actividad actividadId;

    public DetRepMenAct() {
    }

    public DetRepMenAct(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public DetRepMen getDetRepMenId() {
        return detRepMenId;
    }

    public void setDetRepMenId(DetRepMen detRepMenId) {
        this.detRepMenId = detRepMenId;
    }

    public Actividad getActividadId() {
        return actividadId;
    }

    public void setActividadId(Actividad actividadId) {
        this.actividadId = actividadId;
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
        if (!(object instanceof DetRepMenAct)) {
            return false;
        }
        DetRepMenAct other = (DetRepMenAct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.DetRepMenAct[ id=" + id + " ]";
    }
    
}
