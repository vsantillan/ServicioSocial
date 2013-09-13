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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author SATELLITE
 */
@Entity
@Table(name = "PROYECTO_PERFIL", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoPerfil.findAll", query = "SELECT p FROM ProyectoPerfil p"),
    @NamedQuery(name = "ProyectoPerfil.findByIdProyectoPerfil", query = "SELECT p FROM ProyectoPerfil p WHERE p.idProyectoPerfil = :idProyectoPerfil")})
public class ProyectoPerfil implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROYECTO_PERFIL")
    private BigDecimal idProyectoPerfil;
    @JoinColumn(name = "ID_PROYECTO", referencedColumnName = "ID_PROYECTO")
    @ManyToOne(optional = false)
    private Proyectos idProyecto;
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
    private Perfil idPerfil;

    public ProyectoPerfil() {
    }

    public ProyectoPerfil(BigDecimal idProyectoPerfil) {
        this.idProyectoPerfil = idProyectoPerfil;
    }

    public BigDecimal getIdProyectoPerfil() {
        return idProyectoPerfil;
    }

    public void setIdProyectoPerfil(BigDecimal idProyectoPerfil) {
        this.idProyectoPerfil = idProyectoPerfil;
    }

    public Proyectos getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyectos idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyectoPerfil != null ? idProyectoPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoPerfil)) {
            return false;
        }
        ProyectoPerfil other = (ProyectoPerfil) object;
        if ((this.idProyectoPerfil == null && other.idProyectoPerfil != null) || (this.idProyectoPerfil != null && !this.idProyectoPerfil.equals(other.idProyectoPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.ProyectoPerfil[ idProyectoPerfil=" + idProyectoPerfil + " ]";
    }
    
}
