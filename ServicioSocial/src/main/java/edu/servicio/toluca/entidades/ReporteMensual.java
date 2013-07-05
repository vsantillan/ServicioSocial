/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
 * @author SATELLITE
 */
@Entity
@Table(name = "REPORTE_MENSUAL", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteMensual.findAll", query = "SELECT r FROM ReporteMensual r"),
    @NamedQuery(name = "ReporteMensual.findById", query = "SELECT r FROM ReporteMensual r WHERE r.id = :id"),
    @NamedQuery(name = "ReporteMensual.findByNumeroDeInforme", query = "SELECT r FROM ReporteMensual r WHERE r.numeroDeInforme = :numeroDeInforme"),
    @NamedQuery(name = "ReporteMensual.findByPeriodo", query = "SELECT r FROM ReporteMensual r WHERE r.periodo = :periodo"),
    @NamedQuery(name = "ReporteMensual.findByHoras", query = "SELECT r FROM ReporteMensual r WHERE r.horas = :horas"),
    @NamedQuery(name = "ReporteMensual.findByNombreDeReporte", query = "SELECT r FROM ReporteMensual r WHERE r.nombreDeReporte = :nombreDeReporte"),
    @NamedQuery(name = "ReporteMensual.findByFechaSubida", query = "SELECT r FROM ReporteMensual r WHERE r.fechaSubida = :fechaSubida")})
public class ReporteMensual implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Lob
    @Column(name = "FECHA_ENTREGA")
    private Serializable fechaEntrega;
    @Column(name = "NUMERO_DE_INFORME")
    private BigInteger numeroDeInforme;
    @Size(max = 35)
    @Column(name = "PERIODO")
    private String periodo;
    @Column(name = "HORAS")
    private BigInteger horas;
    @Size(max = 50)
    @Column(name = "NOMBRE_DE_REPORTE")
    private String nombreDeReporte;
    @Lob
    @Column(name = "REPORTE")
    private Serializable reporte;
    @Column(name = "FECHA_SUBIDA")
    @Temporal(TemporalType.DATE)
    private Date fechaSubida;
    @JoinColumn(name = "BECADO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Becado becadoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reporteMensualId")
    private Collection<DetRepMen> detRepMenCollection;

    public ReporteMensual() {
    }

    public ReporteMensual(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Serializable getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Serializable fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public BigInteger getNumeroDeInforme() {
        return numeroDeInforme;
    }

    public void setNumeroDeInforme(BigInteger numeroDeInforme) {
        this.numeroDeInforme = numeroDeInforme;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public BigInteger getHoras() {
        return horas;
    }

    public void setHoras(BigInteger horas) {
        this.horas = horas;
    }

    public String getNombreDeReporte() {
        return nombreDeReporte;
    }

    public void setNombreDeReporte(String nombreDeReporte) {
        this.nombreDeReporte = nombreDeReporte;
    }

    public Serializable getReporte() {
        return reporte;
    }

    public void setReporte(Serializable reporte) {
        this.reporte = reporte;
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

    @XmlTransient
    public Collection<DetRepMen> getDetRepMenCollection() {
        return detRepMenCollection;
    }

    public void setDetRepMenCollection(Collection<DetRepMen> detRepMenCollection) {
        this.detRepMenCollection = detRepMenCollection;
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
        if (!(object instanceof ReporteMensual)) {
            return false;
        }
        ReporteMensual other = (ReporteMensual) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.ReporteMensual[ id=" + id + " ]";
    }
    
}
