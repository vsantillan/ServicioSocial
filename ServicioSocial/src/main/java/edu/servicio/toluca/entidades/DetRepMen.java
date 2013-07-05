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
 * @author SATELLITE
 */
@Entity
@Table(name = "DET_REP_MEN", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetRepMen.findAll", query = "SELECT d FROM DetRepMen d"),
    @NamedQuery(name = "DetRepMen.findById", query = "SELECT d FROM DetRepMen d WHERE d.id = :id"),
    @NamedQuery(name = "DetRepMen.findByNumeroBeneficiados", query = "SELECT d FROM DetRepMen d WHERE d.numeroBeneficiados = :numeroBeneficiados")})
public class DetRepMen implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_BENEFICIADOS")
    private BigInteger numeroBeneficiados;
    @JoinColumn(name = "REPORTE_MENSUAL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ReporteMensual reporteMensualId;
    @JoinColumn(name = "LUGAR_DESARROLLO", referencedColumnName = "ID_INSTANCIA")
    @ManyToOne(optional = false)
    private Instancia lugarDesarrollo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detRepMenId")
    private Collection<DetRepMenAct> detRepMenActCollection;

    public DetRepMen() {
    }

    public DetRepMen(BigDecimal id) {
        this.id = id;
    }

    public DetRepMen(BigDecimal id, BigInteger numeroBeneficiados) {
        this.id = id;
        this.numeroBeneficiados = numeroBeneficiados;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getNumeroBeneficiados() {
        return numeroBeneficiados;
    }

    public void setNumeroBeneficiados(BigInteger numeroBeneficiados) {
        this.numeroBeneficiados = numeroBeneficiados;
    }

    public ReporteMensual getReporteMensualId() {
        return reporteMensualId;
    }

    public void setReporteMensualId(ReporteMensual reporteMensualId) {
        this.reporteMensualId = reporteMensualId;
    }

    public Instancia getLugarDesarrollo() {
        return lugarDesarrollo;
    }

    public void setLugarDesarrollo(Instancia lugarDesarrollo) {
        this.lugarDesarrollo = lugarDesarrollo;
    }

    @XmlTransient
    public Collection<DetRepMenAct> getDetRepMenActCollection() {
        return detRepMenActCollection;
    }

    public void setDetRepMenActCollection(Collection<DetRepMenAct> detRepMenActCollection) {
        this.detRepMenActCollection = detRepMenActCollection;
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
        if (!(object instanceof DetRepMen)) {
            return false;
        }
        DetRepMen other = (DetRepMen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.DetRepMen[ id=" + id + " ]";
    }
    
}
