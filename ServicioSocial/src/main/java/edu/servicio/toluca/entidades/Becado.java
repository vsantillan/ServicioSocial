/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SATELLITE
 */
@Entity
@Table(name = "BECADO", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Becado.findAll", query = "SELECT b FROM Becado b"),
    @NamedQuery(name = "Becado.findById", query = "SELECT b FROM Becado b WHERE b.id = :id"),
    @NamedQuery(name = "Becado.findByNumeroDeRegistro", query = "SELECT b FROM Becado b WHERE b.numeroDeRegistro = :numeroDeRegistro"),
    @NamedQuery(name = "Becado.findByStatus", query = "SELECT b FROM Becado b WHERE b.status = :status")})
public class Becado implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 11)
    @Column(name = "NUMERO_DE_REGISTRO")
    private String numeroDeRegistro;
    @Size(max = 1)
    @Column(name = "STATUS")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "becadoId")
    private Collection<ReporteGeneral> reporteGeneralCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "becadoId")
    private Collection<InformeGlobal> informeGlobalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "becadoId")
    private Collection<ReporteMensual> reporteMensualCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "becadoId")
    private Collection<Revision> revisionCollection;
    @JoinColumn(name = "NUMERO_CONTROL", referencedColumnName = "ID")
    @ManyToOne
    private VistaAlumno numeroControl;
    @JoinColumn(name = "PROGRAMA_GENERAL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ProgramaGeneral programaGeneralId;
    @JoinColumn(name = "ID_FORMATO_UNICO", referencedColumnName = "ID")
    @ManyToOne
    private FormatoUnico idFormatoUnico;

    public Becado() {
    }

    public Becado(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNumeroDeRegistro() {
        return numeroDeRegistro;
    }

    public void setNumeroDeRegistro(String numeroDeRegistro) {
        this.numeroDeRegistro = numeroDeRegistro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<ReporteGeneral> getReporteGeneralCollection() {
        return reporteGeneralCollection;
    }

    public void setReporteGeneralCollection(Collection<ReporteGeneral> reporteGeneralCollection) {
        this.reporteGeneralCollection = reporteGeneralCollection;
    }

    @XmlTransient
    public Collection<InformeGlobal> getInformeGlobalCollection() {
        return informeGlobalCollection;
    }

    public void setInformeGlobalCollection(Collection<InformeGlobal> informeGlobalCollection) {
        this.informeGlobalCollection = informeGlobalCollection;
    }

    @XmlTransient
    public Collection<ReporteMensual> getReporteMensualCollection() {
        return reporteMensualCollection;
    }

    public void setReporteMensualCollection(Collection<ReporteMensual> reporteMensualCollection) {
        this.reporteMensualCollection = reporteMensualCollection;
    }

    @XmlTransient
    public Collection<Revision> getRevisionCollection() {
        return revisionCollection;
    }

    public void setRevisionCollection(Collection<Revision> revisionCollection) {
        this.revisionCollection = revisionCollection;
    }

    public VistaAlumno getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(VistaAlumno numeroControl) {
        this.numeroControl = numeroControl;
    }

    public ProgramaGeneral getProgramaGeneralId() {
        return programaGeneralId;
    }

    public void setProgramaGeneralId(ProgramaGeneral programaGeneralId) {
        this.programaGeneralId = programaGeneralId;
    }

    public FormatoUnico getIdFormatoUnico() {
        return idFormatoUnico;
    }

    public void setIdFormatoUnico(FormatoUnico idFormatoUnico) {
        this.idFormatoUnico = idFormatoUnico;
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
        if (!(object instanceof Becado)) {
            return false;
        }
        Becado other = (Becado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.Becado[ id=" + id + " ]";
    }
    
}
