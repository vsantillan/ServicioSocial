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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bustedvillain
 */
@Entity
@Table(name = "REPORTES", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reportes.findAll", query = "SELECT r FROM Reportes r"),
    @NamedQuery(name = "Reportes.findById", query = "SELECT r FROM Reportes r WHERE r.id = :id"),
    @NamedQuery(name = "Reportes.findByNumeroReporte", query = "SELECT r FROM Reportes r WHERE r.numeroReporte = :numeroReporte"),
    @NamedQuery(name = "Reportes.findByHoras", query = "SELECT r FROM Reportes r WHERE r.horas = :horas"),
    @NamedQuery(name = "Reportes.findByCalificacion", query = "SELECT r FROM Reportes r WHERE r.calificacion = :calificacion"),
    @NamedQuery(name = "Reportes.findByFechaInicio", query = "SELECT r FROM Reportes r WHERE r.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Reportes.findByFechaFin", query = "SELECT r FROM Reportes r WHERE r.fechaFin = :fechaFin"),
    @NamedQuery(name = "Reportes.findByStatus", query = "SELECT r FROM Reportes r WHERE r.status = :status"),
    @NamedQuery(name = "Reportes.findByFechaEntregaMax", query = "SELECT r FROM Reportes r WHERE r.fechaEntregaMax = :fechaEntregaMax"),
    @NamedQuery(name = "Reportes.findByNumeroRevisiones", query = "SELECT r FROM Reportes r WHERE r.numeroRevisiones = :numeroRevisiones"),
    @NamedQuery(name = "Reportes.findByNumeroBeneficiados", query = "SELECT r FROM Reportes r WHERE r.numeroBeneficiados = :numeroBeneficiados"),
    @NamedQuery(name = "Reportes.findByTipo", query = "SELECT r FROM Reportes r WHERE r.tipo = :tipo")})
public class Reportes implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NUMERO_REPORTE")
    private BigInteger numeroReporte;
    @Column(name = "HORAS")
    private BigInteger horas;
    @Column(name = "CALIFICACION")
    private BigInteger calificacion;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "STATUS")
    private BigInteger status;
    @Column(name = "FECHA_ENTREGA_MAX")
    @Temporal(TemporalType.DATE)
    private Date fechaEntregaMax;
    @Column(name = "NUMERO_REVISIONES")
    private BigInteger numeroRevisiones;
    @Column(name = "NUMERO_BENEFICIADOS")
    private BigInteger numeroBeneficiados;
    @Column(name = "TIPO")
    private BigInteger tipo;
    @JoinColumn(name = "DATOS_PERSONALES_ID", referencedColumnName = "ID")
    @ManyToOne
    private DatosPersonales datosPersonalesId;

    public Reportes() {
    }

    public Reportes(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getNumeroReporte() {
        return numeroReporte;
    }

    public void setNumeroReporte(BigInteger numeroReporte) {
        this.numeroReporte = numeroReporte;
    }

    public BigInteger getHoras() {
        return horas;
    }

    public void setHoras(BigInteger horas) {
        this.horas = horas;
    }

    public BigInteger getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigInteger calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    public Date getFechaEntregaMax() {
        return fechaEntregaMax;
    }

    public void setFechaEntregaMax(Date fechaEntregaMax) {
        this.fechaEntregaMax = fechaEntregaMax;
    }

    public BigInteger getNumeroRevisiones() {
        return numeroRevisiones;
    }

    public void setNumeroRevisiones(BigInteger numeroRevisiones) {
        this.numeroRevisiones = numeroRevisiones;
    }

    public BigInteger getNumeroBeneficiados() {
        return numeroBeneficiados;
    }

    public void setNumeroBeneficiados(BigInteger numeroBeneficiados) {
        this.numeroBeneficiados = numeroBeneficiados;
    }

    public BigInteger getTipo() {
        return tipo;
    }

    public void setTipo(BigInteger tipo) {
        this.tipo = tipo;
    }

    public DatosPersonales getDatosPersonalesId() {
        return datosPersonalesId;
    }

    public void setDatosPersonalesId(DatosPersonales datosPersonalesId) {
        this.datosPersonalesId = datosPersonalesId;
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
        if (!(object instanceof Reportes)) {
            return false;
        }
        Reportes other = (Reportes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.Reportes[ id=" + id + " ]";
    }
    
}
