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
import javax.persistence.GeneratedValue;
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
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author SATELLITE
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
    @NamedQuery(name = "DatosPersonales.findByApellidoM", query = "SELECT d FROM DatosPersonales d WHERE d.apellidoM = :apellidoM"),
    @NamedQuery(name = "DatosPersonales.findByFacebook", query = "SELECT d FROM DatosPersonales d WHERE d.facebook = :facebook"),
    @NamedQuery(name = "DatosPersonales.findByTwitter", query = "SELECT d FROM DatosPersonales d WHERE d.twitter = :twitter"),
    @NamedQuery(name = "DatosPersonales.findByCalle", query = "SELECT d FROM DatosPersonales d WHERE d.calle = :calle"),
    @NamedQuery(name = "DatosPersonales.findByNumeroI", query = "SELECT d FROM DatosPersonales d WHERE d.numeroI = :numeroI"),
    @NamedQuery(name = "DatosPersonales.findByNumeroE", query = "SELECT d FROM DatosPersonales d WHERE d.numeroE = :numeroE"),
    @NamedQuery(name = "DatosPersonales.findByEntreCalles", query = "SELECT d FROM DatosPersonales d WHERE d.entreCalles = :entreCalles"),
    @NamedQuery(name = "DatosPersonales.findByReferencia", query = "SELECT d FROM DatosPersonales d WHERE d.referencia = :referencia"),
    @NamedQuery(name = "DatosPersonales.findByOcupacion", query = "SELECT d FROM DatosPersonales d WHERE d.ocupacion = :ocupacion"),
    @NamedQuery(name = "DatosPersonales.findByTelefonoOficina", query = "SELECT d FROM DatosPersonales d WHERE d.telefonoOficina = :telefonoOficina"),
    @NamedQuery(name = "DatosPersonales.findByEstadoCivil", query = "SELECT d FROM DatosPersonales d WHERE d.estadoCivil = :estadoCivil")})
public class DatosPersonales implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "dpGen" , strategy = "increment")
    @Id
    @GeneratedValue(generator="dpGen")
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
    @Size(max = 30)
    @Column(name = "FACEBOOK")
    private String facebook;
    @Size(max = 25)
    @Column(name = "TWITTER")
    private String twitter;
    @Size(max = 200)
    @Column(name = "CALLE")
    private String calle;
    @Size(max = 5)
    @Column(name = "NUMERO_I")
    private String numeroI;
    @Size(max = 5)
    @Column(name = "NUMERO_E")
    private String numeroE;
    @Size(max = 255)
    @Column(name = "ENTRE_CALLES")
    private String entreCalles;
    @Size(max = 70)
    @Column(name = "REFERENCIA")
    private String referencia;
    @Size(max = 30)
    @Column(name = "OCUPACION")
    private String ocupacion;
    @Size(max = 30)
    @Column(name = "TELEFONO_OFICINA")
    private String telefonoOficina;
    @Size(max = 15)
    @Column(name = "ESTADO_CIVIL")
    private String estadoCivil;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<Egresado> egresadoCollection;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<Sanciones> sancionesCollection;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<DocumentosFinales> documentosFinalesCollection;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<LogServicio> logServicioCollection;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<RegObservaciones> regObservacionesCollection;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<Reportes> reportesCollection;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<Documentos> documentosCollection;
    @JoinColumn(name = "ALUMNO_ID", referencedColumnName = "ID")
    @ManyToOne
    private VistaAlumno alumnoId;
    @JoinColumn(name = "ID_COLONIA", referencedColumnName = "ID_COLONIA")
    @ManyToOne
    private Colonia idColonia;
    @OneToMany(mappedBy = "datosPersonalesId")
    private Collection<BajaTemporal> bajaTemporalCollection;
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

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroI() {
        return numeroI;
    }

    public void setNumeroI(String numeroI) {
        this.numeroI = numeroI;
    }

    public String getNumeroE() {
        return numeroE;
    }

    public void setNumeroE(String numeroE) {
        this.numeroE = numeroE;
    }

    public String getEntreCalles() {
        return entreCalles;
    }

    public void setEntreCalles(String entreCalles) {
        this.entreCalles = entreCalles;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getTelefonoOficina() {
        return telefonoOficina;
    }

    public void setTelefonoOficina(String telefonoOficina) {
        this.telefonoOficina = telefonoOficina;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
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
    public Collection<DocumentosFinales> getDocumentosFinalesCollection() {
        return documentosFinalesCollection;
    }

    public void setDocumentosFinalesCollection(Collection<DocumentosFinales> documentosFinalesCollection) {
        this.documentosFinalesCollection = documentosFinalesCollection;
    }

    @XmlTransient
    public Collection<LogServicio> getLogServicioCollection() {
        return logServicioCollection;
    }

    public void setLogServicioCollection(Collection<LogServicio> logServicioCollection) {
        this.logServicioCollection = logServicioCollection;
    }

    @XmlTransient
    public Collection<RegObservaciones> getRegObservacionesCollection() {
        return regObservacionesCollection;
    }

    public void setRegObservacionesCollection(Collection<RegObservaciones> regObservacionesCollection) {
        this.regObservacionesCollection = regObservacionesCollection;
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

    public Colonia getIdColonia() {
        return idColonia;
    }

    public void setIdColonia(Colonia idColonia) {
        this.idColonia = idColonia;
    }

    @XmlTransient
    public Collection<BajaTemporal> getBajaTemporalCollection() {
        return bajaTemporalCollection;
    }

    public void setBajaTemporalCollection(Collection<BajaTemporal> bajaTemporalCollection) {
        this.bajaTemporalCollection = bajaTemporalCollection;
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

    public void setAlumnoId(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
