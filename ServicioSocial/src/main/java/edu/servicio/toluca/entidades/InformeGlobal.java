/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author SATELLITE
 */
@Entity
@Table(name = "INFORME_GLOBAL", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformeGlobal.findAll", query = "SELECT i FROM InformeGlobal i"),
    @NamedQuery(name = "InformeGlobal.findById", query = "SELECT i FROM InformeGlobal i WHERE i.id = :id"),
    @NamedQuery(name = "InformeGlobal.findByIdBecado", query = "SELECT i FROM InformeGlobal i WHERE i.idBecado = :idBecado"),
    @NamedQuery(name = "InformeGlobal.findByNombreDeInforme", query = "SELECT i FROM InformeGlobal i WHERE i.nombreDeInforme = :nombreDeInforme"),
    @NamedQuery(name = "InformeGlobal.findByFechaSubida", query = "SELECT i FROM InformeGlobal i WHERE i.fechaSubida = :fechaSubida")})
public class InformeGlobal implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BECADO")
    private BigInteger idBecado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_DE_INFORME")
    private String nombreDeInforme;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "INFORME")
    private Serializable informe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_SUBIDA")
    @Temporal(TemporalType.DATE)
    private Date fechaSubida;
    @JoinColumn(name = "BECADO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Becado becadoId;

    public InformeGlobal() {
    }

    public InformeGlobal(BigDecimal id) {
        this.id = id;
    }

    public InformeGlobal(BigDecimal id, BigInteger idBecado, String nombreDeInforme, Serializable informe, Date fechaSubida) {
        this.id = id;
        this.idBecado = idBecado;
        this.nombreDeInforme = nombreDeInforme;
        this.informe = informe;
        this.fechaSubida = fechaSubida;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getIdBecado() {
        return idBecado;
    }

    public void setIdBecado(BigInteger idBecado) {
        this.idBecado = idBecado;
    }

    public String getNombreDeInforme() {
        return nombreDeInforme;
    }

    public void setNombreDeInforme(String nombreDeInforme) {
        this.nombreDeInforme = nombreDeInforme;
    }

    public Serializable getInforme() {
        return informe;
    }

    public void setInforme(Serializable informe) {
        this.informe = informe;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
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
        if (!(object instanceof InformeGlobal)) {
            return false;
        }
        InformeGlobal other = (InformeGlobal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.InformeGlobal[ id=" + id + " ]";
    }
    
}
