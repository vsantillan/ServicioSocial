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
 * @author bustedvillain
 */
@Entity
@Table(name = "DATOS_PERSONALES", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosPersonales.findAll", query = "SELECT d FROM DatosPersonales d"),
    @NamedQuery(name = "DatosPersonales.findById", query = "SELECT d FROM DatosPersonales d WHERE d.id = :id"),
    @NamedQuery(name = "DatosPersonales.findByFolioDocIdentificaciin", query = "SELECT d FROM DatosPersonales d WHERE d.folioDocIdentificaciin = :folioDocIdentificaciin"),
    @NamedQuery(name = "DatosPersonales.findByClaveDocIdentificacion", query = "SELECT d FROM DatosPersonales d WHERE d.claveDocIdentificacion = :claveDocIdentificacion"),
    @NamedQuery(name = "DatosPersonales.findByLugarNacimiento", query = "SELECT d FROM DatosPersonales d WHERE d.lugarNacimiento = :lugarNacimiento"),
    @NamedQuery(name = "DatosPersonales.findByTelefonoCasa", query = "SELECT d FROM DatosPersonales d WHERE d.telefonoCasa = :telefonoCasa"),
    @NamedQuery(name = "DatosPersonales.findByTelefonoCel", query = "SELECT d FROM DatosPersonales d WHERE d.telefonoCel = :telefonoCel"),
    @NamedQuery(name = "DatosPersonales.findByDomicilio", query = "SELECT d FROM DatosPersonales d WHERE d.domicilio = :domicilio"),
    @NamedQuery(name = "DatosPersonales.findByCurp", query = "SELECT d FROM DatosPersonales d WHERE d.curp = :curp"),
    @NamedQuery(name = "DatosPersonales.findBySexo", query = "SELECT d FROM DatosPersonales d WHERE d.sexo = :sexo"),
    @NamedQuery(name = "DatosPersonales.findByCorreoElectronico", query = "SELECT d FROM DatosPersonales d WHERE d.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "DatosPersonales.findByNombre", query = "SELECT d FROM DatosPersonales d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DatosPersonales.findByApellidoP", query = "SELECT d FROM DatosPersonales d WHERE d.apellidoP = :apellidoP"),
    @NamedQuery(name = "DatosPersonales.findByApellidoM", query = "SELECT d FROM DatosPersonales d WHERE d.apellidoM = :apellidoM")})
public class DatosPersonales implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FOLIO_DOC_IDENTIFICACIIN")
    private BigInteger folioDocIdentificaciin;
    @Size(max = 30)
    @Column(name = "CLAVE_DOC_IDENTIFICACION")
    private String claveDocIdentificacion;
    @Size(max = 150)
    @Column(name = "LUGAR_NACIMIENTO")
    private String lugarNacimiento;
    @Size(max = 50)
    @Column(name = "TELEFONO_CASA")
    private String telefonoCasa;
    @Size(max = 30)
    @Column(name = "TELEFONO_CEL")
    private String telefonoCel;
    @Size(max = 30)
    @Column(name = "DOMICILIO")
    private String domicilio;
    @Size(max = 30)
    @Column(name = "CURP")
    private String curp;
    @Size(max = 30)
    @Column(name = "SEXO")
    private String sexo;
    @Size(max = 30)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Size(max = 60)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 30)
    @Column(name = "APELLIDO_P")
    private String apellidoP;
    @Size(max = 30)
    @Column(name = "APELLIDO_M")
    private String apellidoM;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<Egresado> egresadoCollection;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<Sanciones> sancionesCollection;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<RegObservaciones> regObservacionesCollection;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<DocumentosFinales> documentosFinalesCollection;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<Reportes> reportesCollection;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<Documentos> documentosCollection;
    @JoinColumn(name = "ALUMNO_ID", referencedColumnName = "ID")
    @ManyToOne
    private VistaAlumno alumnoId;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<BajaTemporal> bajaTemporalCollection;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<LogServicio> logServicioCollection;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<FormatoUnico> formatoUnicoCollection;

    public DatosPersonales() {
    }

    public DatosPersonales(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getFolioDocIdentificaciin() {
        return folioDocIdentificaciin;
    }

    public void setFolioDocIdentificaciin(BigInteger folioDocIdentificaciin) {
        this.folioDocIdentificaciin = folioDocIdentificaciin;
    }

    public String getClaveDocIdentificacion() {
        return claveDocIdentificacion;
    }

    public void setClaveDocIdentificacion(String claveDocIdentificacion) {
        this.claveDocIdentificacion = claveDocIdentificacion;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(String telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public String getTelefonoCel() {
        return telefonoCel;
    }

    public void setTelefonoCel(String telefonoCel) {
        this.telefonoCel = telefonoCel;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    @XmlTransient
    public Collection<Egresado> getEgresadoCollection() {
        return egresadoCollection;
    }

    public void setEgresadoCollection(Collection<Egresado> egresadoCollection) {
        this.egresadoCollection = egresadoCollection;
    }

    @XmlTransient
    public Collection<Sanciones> getSancionesCollection() {
        return sancionesCollection;
    }

    public void setSancionesCollection(Collection<Sanciones> sancionesCollection) {
        this.sancionesCollection = sancionesCollection;
    }

    @XmlTransient
    public Collection<RegObservaciones> getRegObservacionesCollection() {
        return regObservacionesCollection;
    }

    public void setRegObservacionesCollection(Collection<RegObservaciones> regObservacionesCollection) {
        this.regObservacionesCollection = regObservacionesCollection;
    }

    @XmlTransient
    public Collection<DocumentosFinales> getDocumentosFinalesCollection() {
        return documentosFinalesCollection;
    }

    public void setDocumentosFinalesCollection(Collection<DocumentosFinales> documentosFinalesCollection) {
        this.documentosFinalesCollection = documentosFinalesCollection;
    }

    @XmlTransient
    public Collection<Reportes> getReportesCollection() {
        return reportesCollection;
    }

    public void setReportesCollection(Collection<Reportes> reportesCollection) {
        this.reportesCollection = reportesCollection;
    }

    @XmlTransient
    public Collection<Documentos> getDocumentosCollection() {
        return documentosCollection;
    }

    public void setDocumentosCollection(Collection<Documentos> documentosCollection) {
        this.documentosCollection = documentosCollection;
    }

    public VistaAlumno getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(VistaAlumno alumnoId) {
        this.alumnoId = alumnoId;
    }

    @XmlTransient
    public Collection<BajaTemporal> getBajaTemporalCollection() {
        return bajaTemporalCollection;
    }

    public void setBajaTemporalCollection(Collection<BajaTemporal> bajaTemporalCollection) {
        this.bajaTemporalCollection = bajaTemporalCollection;
    }

    @XmlTransient
    public Collection<LogServicio> getLogServicioCollection() {
        return logServicioCollection;
    }

    public void setLogServicioCollection(Collection<LogServicio> logServicioCollection) {
        this.logServicioCollection = logServicioCollection;
    }

    @XmlTransient
    public Collection<FormatoUnico> getFormatoUnicoCollection() {
        return formatoUnicoCollection;
    }

    public void setFormatoUnicoCollection(Collection<FormatoUnico> formatoUnicoCollection) {
        this.formatoUnicoCollection = formatoUnicoCollection;
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
        if (!(object instanceof DatosPersonales)) {
            return false;
        }
        DatosPersonales other = (DatosPersonales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.DatosPersonales[ id=" + id + " ]";
    }
    
}
