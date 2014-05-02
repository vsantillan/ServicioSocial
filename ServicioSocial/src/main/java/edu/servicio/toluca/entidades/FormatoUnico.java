/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import edu.servicio.toluca.configuracion.CatalogoErrores;
import edu.servicio.toluca.configuracion.ExpresionesRegulares;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author SATELLITE
 */

@Entity
@Table(name = "FORMATO_UNICO", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormatoUnico.findAll", query = "SELECT f FROM FormatoUnico f"),
    @NamedQuery(name = "FormatoUnico.findById", query = "SELECT f FROM FormatoUnico f WHERE f.id = :id"),
    @NamedQuery(name = "FormatoUnico.findByFechaInicio", query = "SELECT f FROM FormatoUnico f WHERE f.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "FormatoUnico.findByFechaFin", query = "SELECT f FROM FormatoUnico f WHERE f.fechaFin = :fechaFin"),
    @NamedQuery(name = "FormatoUnico.findByTipoServicio", query = "SELECT f FROM FormatoUnico f WHERE f.tipoServicio = :tipoServicio"),
    @NamedQuery(name = "FormatoUnico.findByStatusServicio", query = "SELECT f FROM FormatoUnico f WHERE f.statusServicio = :statusServicio"),
    @NamedQuery(name = "FormatoUnico.findByStatusFui", query = "SELECT f FROM FormatoUnico f WHERE f.statusFui = :statusFui"),
    @NamedQuery(name = "FormatoUnico.findByStatusFuf", query = "SELECT f FROM FormatoUnico f WHERE f.statusFuf = :statusFuf"),
    @NamedQuery(name = "FormatoUnico.findByHorasAcumuladas", query = "SELECT f FROM FormatoUnico f WHERE f.horasAcumuladas = :horasAcumuladas"),
    @NamedQuery(name = "FormatoUnico.findByFechaEntregaFuf", query = "SELECT f FROM FormatoUnico f WHERE f.fechaEntregaFuf = :fechaEntregaFuf"),
    @NamedQuery(name = "FormatoUnico.findByPorcentajeCreditos", query = "SELECT f FROM FormatoUnico f WHERE f.porcentajeCreditos = :porcentajeCreditos"),
    @NamedQuery(name = "FormatoUnico.findByNumeroCreditos", query = "SELECT f FROM FormatoUnico f WHERE f.numeroCreditos = :numeroCreditos"),
    @NamedQuery(name = "FormatoUnico.findByPeriodoInicio", query = "SELECT f FROM FormatoUnico f WHERE f.periodoInicio = :periodoInicio"),
    @NamedQuery(name = "FormatoUnico.findByRevisionesFui", query = "SELECT f FROM FormatoUnico f WHERE f.revisionesFui = :revisionesFui"),
    @NamedQuery(name = "FormatoUnico.findByRevisionesFuf", query = "SELECT f FROM FormatoUnico f WHERE f.revisionesFuf = :revisionesFuf"),
    @NamedQuery(name = "FormatoUnico.findByModalidad", query = "SELECT f FROM FormatoUnico f WHERE f.modalidad = :modalidad")})
public class FormatoUnico implements Serializable,ExpresionesRegulares, CatalogoErrores {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "formatoUnicoG", strategy = "increment")
    @Id
    @GeneratedValue(generator="formatoUnicoG")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "TIPO_SERVICIO")
    private BigInteger tipoServicio;
    @Column(name = "STATUS_SERVICIO")
    private BigInteger statusServicio;
    @Column(name = "STATUS_FUI")
    private BigInteger statusFui;
    @Column(name = "STATUS_FUF")
    private BigInteger statusFuf;
    @Column(name = "HORAS_ACUMULADAS")
    private BigInteger horasAcumuladas;
    @Column(name = "FECHA_ENTREGA_FUF")
    @Temporal(TemporalType.DATE)
    private Date fechaEntregaFuf;
    @Column(name = "PORCENTAJE_CREDITOS")
    private Double porcentajeCreditos;
    @Column(name = "NUMERO_CREDITOS")
    private BigInteger numeroCreditos;
    @Size(max = 45)
    @Column(name = "PERIODO_INICIO")
    private String periodoInicio;
    @Column(name = "REVISIONES_FUI")
    private BigInteger revisionesFui;
    @Column(name = "REVISIONES_FUF")
    private BigInteger revisionesFuf;
    @Size(max = 1)
    @Column(name = "MODALIDAD")
    private String modalidad;
    @OneToMany(mappedBy = "formatoUnicoId")
    private Collection<HorariosAlumno> horariosAlumnoCollection;
    @OneToMany(mappedBy = "idFormatoUnico")
    private Collection<Becado> becadoCollection;
    @JoinColumn(name = "IDPROYECTO", referencedColumnName = "ID_PROYECTO")
    @ManyToOne
    private Proyectos idproyecto;
    @JoinColumn(name = "DATOS_PERSONALES_ID", referencedColumnName = "ID")
    @ManyToOne
    private DatosPersonales datosPersonalesId;
    @JoinColumn(name = "CATALOGO_PLAN_ID", referencedColumnName = "ID")
    @ManyToOne
    private CatalogoPlan catalogoPlanId;

    public FormatoUnico() {
    }

    public FormatoUnico(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public BigInteger getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(BigInteger tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public BigInteger getStatusServicio() {
        return statusServicio;
    }

    public void setStatusServicio(BigInteger statusServicio) {
        this.statusServicio = statusServicio;
    }

    public BigInteger getStatusFui() {
        return statusFui;
    }

    public void setStatusFui(BigInteger statusFui) {
        this.statusFui = statusFui;
    }

    public BigInteger getStatusFuf() {
        return statusFuf;
    }

    public void setStatusFuf(BigInteger statusFuf) {
        this.statusFuf = statusFuf;
    }

    public BigInteger getHorasAcumuladas() {
        return horasAcumuladas;
    }

    public void setHorasAcumuladas(BigInteger horasAcumuladas) {
        this.horasAcumuladas = horasAcumuladas;
    }

    public Date getFechaEntregaFuf() {
        return fechaEntregaFuf;
    }

    public void setFechaEntregaFuf(Date fechaEntregaFuf) {
        this.fechaEntregaFuf = fechaEntregaFuf;
    }

    public Double getPorcentajeCreditos() {
        return porcentajeCreditos;
    }

    public void setPorcentajeCreditos(Double porcentajeCreditos) {
        this.porcentajeCreditos = porcentajeCreditos;
    }

    public BigInteger getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(BigInteger numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public String getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(String periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public BigInteger getRevisionesFui() {
        return revisionesFui;
    }

    public void setRevisionesFui(BigInteger revisionesFui) {
        this.revisionesFui = revisionesFui;
    }

    public BigInteger getRevisionesFuf() {
        return revisionesFuf;
    }

    public void setRevisionesFuf(BigInteger revisionesFuf) {
        this.revisionesFuf = revisionesFuf;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    @XmlTransient
    public Collection<HorariosAlumno> getHorariosAlumnoCollection() {
        return horariosAlumnoCollection;
    }

    public void setHorariosAlumnoCollection(Collection<HorariosAlumno> horariosAlumnoCollection) {
        this.horariosAlumnoCollection = horariosAlumnoCollection;
    }

    @XmlTransient
    public Collection<Becado> getBecadoCollection() {
        return becadoCollection;
    }

    public void setBecadoCollection(Collection<Becado> becadoCollection) {
        this.becadoCollection = becadoCollection;
    }

    public Proyectos getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Proyectos idproyecto) {
        this.idproyecto = idproyecto;
    }

    public DatosPersonales getDatosPersonalesId() {
        return datosPersonalesId;
    }

    public void setDatosPersonalesId(DatosPersonales datosPersonalesId) {
        this.datosPersonalesId = datosPersonalesId;
    }

    public CatalogoPlan getCatalogoPlanId() {
        return catalogoPlanId;
    }

    public void setCatalogoPlanId(CatalogoPlan catalogoPlanId) {
        this.catalogoPlanId = catalogoPlanId;
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
        if (!(object instanceof FormatoUnico)) {
            return false;
        }
        FormatoUnico other = (FormatoUnico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.FormatoUnico[ id=" + id + " ]";
    }
    
}
