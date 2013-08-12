/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "VISTA_ALUMNO", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VistaAlumno.findAll", query = "SELECT v FROM VistaAlumno v"),
    @NamedQuery(name = "VistaAlumno.findById", query = "SELECT v FROM VistaAlumno v WHERE v.id = :id"),
    @NamedQuery(name = "VistaAlumno.findByCurp", query = "SELECT v FROM VistaAlumno v WHERE v.curp = :curp"),
    @NamedQuery(name = "VistaAlumno.findByStaActual", query = "SELECT v FROM VistaAlumno v WHERE v.staActual = :staActual"),
    @NamedQuery(name = "VistaAlumno.findBySemActual", query = "SELECT v FROM VistaAlumno v WHERE v.semActual = :semActual"),
    @NamedQuery(name = "VistaAlumno.findByApellidoPat", query = "SELECT v FROM VistaAlumno v WHERE v.apellidoPat = :apellidoPat"),
    @NamedQuery(name = "VistaAlumno.findByApellidoMat", query = "SELECT v FROM VistaAlumno v WHERE v.apellidoMat = :apellidoMat"),
    @NamedQuery(name = "VistaAlumno.findByNombre", query = "SELECT v FROM VistaAlumno v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "VistaAlumno.findBySexo", query = "SELECT v FROM VistaAlumno v WHERE v.sexo = :sexo"),
    @NamedQuery(name = "VistaAlumno.findByDomicilio", query = "SELECT v FROM VistaAlumno v WHERE v.domicilio = :domicilio"),
    @NamedQuery(name = "VistaAlumno.findByTelefono", query = "SELECT v FROM VistaAlumno v WHERE v.telefono = :telefono"),
    @NamedQuery(name = "VistaAlumno.findByCelular", query = "SELECT v FROM VistaAlumno v WHERE v.celular = :celular"),
    @NamedQuery(name = "VistaAlumno.findByTelefonoTutor", query = "SELECT v FROM VistaAlumno v WHERE v.telefonoTutor = :telefonoTutor"),
    @NamedQuery(name = "VistaAlumno.findByEMail", query = "SELECT v FROM VistaAlumno v WHERE v.eMail = :eMail"),
    @NamedQuery(name = "VistaAlumno.findByCarreraId", query = "SELECT v FROM VistaAlumno v WHERE v.carreraId = :carreraId"),
    @NamedQuery(name = "VistaAlumno.findByCarrera", query = "SELECT v FROM VistaAlumno v WHERE v.carrera = :carrera"),
    @NamedQuery(name = "VistaAlumno.findByCreditos", query = "SELECT v FROM VistaAlumno v WHERE v.creditos = :creditos"),
    @NamedQuery(name = "VistaAlumno.findByCreditosAcumulados", query = "SELECT v FROM VistaAlumno v WHERE v.creditosAcumulados = :creditosAcumulados"),
    @NamedQuery(name = "VistaAlumno.findByPorcentaje", query = "SELECT v FROM VistaAlumno v WHERE v.porcentaje = :porcentaje"),
    @NamedQuery(name = "VistaAlumno.findByPromedio", query = "SELECT v FROM VistaAlumno v WHERE v.promedio = :promedio")})
public class VistaAlumno implements Serializable {
    @Column(name = "PROMEDIO")
    private Double promedio;
    
    @Lob 
    @Column(name = "FOTO")
//    private Serializable foto;
    private byte[] foto;
    
    
    private static final long serialVersionUID = 1L;
    @GenericGenerator(name = "vaGen" , strategy = "increment")
    @Id
    @GeneratedValue(generator="vaGen")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ID")
    private String id;
    
    @Size(max = 18)
    @Column(name = "CURP")
    private String curp;
    @Size(max = 2)
    @Column(name = "STA_ACTUAL")
    private String staActual;
    @Column(name = "SEM_ACTUAL")
    private Short semActual;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 41)
    @Column(name = "APELLIDO_PAT")
    private String apellidoPat;
    @Size(max = 41)
    @Column(name = "APELLIDO_MAT")
    private String apellidoMat;
    @Size(max = 28)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SEXO")
    private String sexo;
    @Size(max = 98)
    @Column(name = "DOMICILIO")
    private String domicilio;
    @Size(max = 40)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 15)
    @Column(name = "CELULAR")
    private String celular;
    @Size(max = 12)
    @Column(name = "TELEFONO_TUTOR")
    private String telefonoTutor;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "E_MAIL")
    private String eMail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARRERA_ID")
    private short carreraId;
    @Size(max = 15)
    @Column(name = "CARRERA")
    private String carrera;
    @Column(name = "CREDITOS")
    private Short creditos;
    @Column(name = "CREDITOS_ACUMULADOS")
    private BigInteger creditosAcumulados;
    @Size(max = 7)
    @Column(name = "PORCENTAJE")
    private String porcentaje;
    @OneToMany(mappedBy = "alumnoId")
    private Collection<Egresado> egresadoCollection;
    @OneToMany(mappedBy = "alumnoId")
    private Collection<DocumentosFinales> documentosFinalesCollection;
    @OneToMany(mappedBy = "alumnoId")
    private Collection<DatosPersonales> datosPersonalesCollection;
    @OneToMany(mappedBy = "alumnoId")
    private Collection<FoliosPlatica> foliosPlaticaCollection;

    public VistaAlumno() {
    }

    public VistaAlumno(String id) {
        this.id = id;
    }

    public VistaAlumno(String id, String apellidoPat, String sexo, short carreraId) {
        this.id = id;
        this.apellidoPat = apellidoPat;
        this.sexo = sexo;
        this.carreraId = carreraId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getStaActual() {
        return staActual;
    }

    public void setStaActual(String staActual) {
        this.staActual = staActual;
    }

    public Short getSemActual() {
        return semActual;
    }

    public void setSemActual(Short semActual) {
        this.semActual = semActual;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefonoTutor() {
        return telefonoTutor;
    }

    public void setTelefonoTutor(String telefonoTutor) {
        this.telefonoTutor = telefonoTutor;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public short getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(short carreraId) {
        this.carreraId = carreraId;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Short getCreditos() {
        return creditos;
    }

    public void setCreditos(Short creditos) {
        this.creditos = creditos;
    }

    public BigInteger getCreditosAcumulados() {
        return creditosAcumulados;
    }

    public void setCreditosAcumulados(BigInteger creditosAcumulados) {
        this.creditosAcumulados = creditosAcumulados;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    @XmlTransient
    public Collection<Egresado> getEgresadoCollection() {
        return egresadoCollection;
    }

    public void setEgresadoCollection(Collection<Egresado> egresadoCollection) {
        this.egresadoCollection = egresadoCollection;
    }

    @XmlTransient
    public Collection<DocumentosFinales> getDocumentosFinalesCollection() {
        return documentosFinalesCollection;
    }

    public void setDocumentosFinalesCollection(Collection<DocumentosFinales> documentosFinalesCollection) {
        this.documentosFinalesCollection = documentosFinalesCollection;
    }

    @XmlTransient
    public Collection<DatosPersonales> getDatosPersonalesCollection() {
        return datosPersonalesCollection;
    }

    public void setDatosPersonalesCollection(Collection<DatosPersonales> datosPersonalesCollection) {
        this.datosPersonalesCollection = datosPersonalesCollection;
    }

    @XmlTransient
    public Collection<FoliosPlatica> getFoliosPlaticaCollection() {
        return foliosPlaticaCollection;
    }

    public void setFoliosPlaticaCollection(Collection<FoliosPlatica> foliosPlaticaCollection) {
        this.foliosPlaticaCollection = foliosPlaticaCollection;
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
        if (!(object instanceof VistaAlumno)) {
            return false;
        }
        VistaAlumno other = (VistaAlumno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.VistaAlumno[ id=" + id + " ]";
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public byte[]  getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
}
