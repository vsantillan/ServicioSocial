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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonny
 */
@Entity
@Table(name = "DOCUMENTOS_FINALES", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentosFinales.findAll", query = "SELECT d FROM DocumentosFinales d"),
    @NamedQuery(name = "DocumentosFinales.findById", query = "SELECT d FROM DocumentosFinales d WHERE d.id = :id"),
    @NamedQuery(name = "DocumentosFinales.findByFechaEntregaMax", query = "SELECT d FROM DocumentosFinales d WHERE d.fechaEntregaMax = :fechaEntregaMax"),
    @NamedQuery(name = "DocumentosFinales.findByCalificacionFinal", query = "SELECT d FROM DocumentosFinales d WHERE d.calificacionFinal = :calificacionFinal"),
    @NamedQuery(name = "DocumentosFinales.findByNivelDesempeno", query = "SELECT d FROM DocumentosFinales d WHERE d.nivelDesempeno = :nivelDesempeno"),
    @NamedQuery(name = "DocumentosFinales.findByDocumentoFisico", query = "SELECT d FROM DocumentosFinales d WHERE d.documentoFisico = :documentoFisico"),
    @NamedQuery(name = "DocumentosFinales.findByNumRevisiones", query = "SELECT d FROM DocumentosFinales d WHERE d.numRevisiones = :numRevisiones")})
public class DocumentosFinales implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FECHA_ENTREGA_MAX")
    @Temporal(TemporalType.DATE)
    private Date fechaEntregaMax;
    @Column(name = "CALIFICACION_FINAL")
    private BigInteger calificacionFinal;
    @Size(max = 30)
    @Column(name = "NIVEL_DESEMPENO")
    private String nivelDesempeno;
    @Column(name = "DOCUMENTO_FISICO")
    private BigInteger documentoFisico;
    @Column(name = "NUM_REVISIONES")
    private BigInteger numRevisiones;
    @JoinColumn(name = "ALUMNO_ID", referencedColumnName = "ID")
    @ManyToOne
    private VistaAlumno alumnoId;
    @JoinColumn(name = "DATOS_PERSONALES_ID", referencedColumnName = "ID")
    @ManyToOne
    private DatosPersonales datosPersonalesId;

    public DocumentosFinales() {
    }

    public DocumentosFinales(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFechaEntregaMax() {
        return fechaEntregaMax;
    }

    public void setFechaEntregaMax(Date fechaEntregaMax) {
        this.fechaEntregaMax = fechaEntregaMax;
    }

    public BigInteger getCalificacionFinal() {
        return calificacionFinal;
    }

    public void setCalificacionFinal(BigInteger calificacionFinal) {
        this.calificacionFinal = calificacionFinal;
    }

    public String getNivelDesempeno() {
        return nivelDesempeno;
    }

    public void setNivelDesempeno(String nivelDesempeno) {
        this.nivelDesempeno = nivelDesempeno;
    }

    public BigInteger getDocumentoFisico() {
        return documentoFisico;
    }

    public void setDocumentoFisico(BigInteger documentoFisico) {
        this.documentoFisico = documentoFisico;
    }

    public BigInteger getNumRevisiones() {
        return numRevisiones;
    }

    public void setNumRevisiones(BigInteger numRevisiones) {
        this.numRevisiones = numRevisiones;
    }

    public VistaAlumno getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(VistaAlumno alumnoId) {
        this.alumnoId = alumnoId;
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
        if (!(object instanceof DocumentosFinales)) {
            return false;
        }
        DocumentosFinales other = (DocumentosFinales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.DocumentosFinales[ id=" + id + " ]";
    }
    
}
