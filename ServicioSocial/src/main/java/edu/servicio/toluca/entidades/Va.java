/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "VA", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Va.findAll", query = "SELECT v FROM Va v"),
    @NamedQuery(name = "Va.findById", query = "SELECT v FROM Va v WHERE v.id = :id"),
    @NamedQuery(name = "Va.findByCurp", query = "SELECT v FROM Va v WHERE v.curp = :curp"),
    @NamedQuery(name = "Va.findByStaActual", query = "SELECT v FROM Va v WHERE v.staActual = :staActual"),
    @NamedQuery(name = "Va.findBySemActual", query = "SELECT v FROM Va v WHERE v.semActual = :semActual"),
    @NamedQuery(name = "Va.findByApellidoPat", query = "SELECT v FROM Va v WHERE v.apellidoPat = :apellidoPat"),
    @NamedQuery(name = "Va.findByApellidoMat", query = "SELECT v FROM Va v WHERE v.apellidoMat = :apellidoMat"),
    @NamedQuery(name = "Va.findByNombre", query = "SELECT v FROM Va v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Va.findBySexo", query = "SELECT v FROM Va v WHERE v.sexo = :sexo"),
    @NamedQuery(name = "Va.findByFecNac", query = "SELECT v FROM Va v WHERE v.fecNac = :fecNac"),
    @NamedQuery(name = "Va.findByDomicilio", query = "SELECT v FROM Va v WHERE v.domicilio = :domicilio"),
    @NamedQuery(name = "Va.findByTelefono", query = "SELECT v FROM Va v WHERE v.telefono = :telefono"),
    @NamedQuery(name = "Va.findByCelular", query = "SELECT v FROM Va v WHERE v.celular = :celular"),
    @NamedQuery(name = "Va.findByTelefonoTutor", query = "SELECT v FROM Va v WHERE v.telefonoTutor = :telefonoTutor"),
    @NamedQuery(name = "Va.findByEMail", query = "SELECT v FROM Va v WHERE v.eMail = :eMail"),
    @NamedQuery(name = "Va.findByCarreraId", query = "SELECT v FROM Va v WHERE v.carreraId = :carreraId"),
    @NamedQuery(name = "Va.findByCarrera", query = "SELECT v FROM Va v WHERE v.carrera = :carrera"),
    @NamedQuery(name = "Va.findByPlanId", query = "SELECT v FROM Va v WHERE v.planId = :planId"),
    @NamedQuery(name = "Va.findByEspecialidadId", query = "SELECT v FROM Va v WHERE v.especialidadId = :especialidadId"),
    @NamedQuery(name = "Va.findByCreditos", query = "SELECT v FROM Va v WHERE v.creditos = :creditos"),
    @NamedQuery(name = "Va.findByCreditosAcumulados", query = "SELECT v FROM Va v WHERE v.creditosAcumulados = :creditosAcumulados"),
    @NamedQuery(name = "Va.findByPorcentaje", query = "SELECT v FROM Va v WHERE v.porcentaje = :porcentaje"),
    @NamedQuery(name = "Va.findByPromedio", query = "SELECT v FROM Va v WHERE v.promedio = :promedio")})
public class Va implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
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
    @Column(name = "FEC_NAC")
    @Temporal(TemporalType.DATE)
    private Date fecNac;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLAN_ID")
    private short planId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESPECIALIDAD_ID")
    private short especialidadId;
    @Column(name = "CREDITOS")
    private Short creditos;
    @Column(name = "CREDITOS_ACUMULADOS")
    private BigInteger creditosAcumulados;
    @Size(max = 7)
    @Column(name = "PORCENTAJE")
    private String porcentaje;
    @Column(name = "PROMEDIO")
    private BigInteger promedio;
    @Lob
    @Column(name = "FOTO")
    private byte[] foto;

    public Va() {
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

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
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

    public short getPlanId() {
        return planId;
    }

    public void setPlanId(short planId) {
        this.planId = planId;
    }

    public short getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(short especialidadId) {
        this.especialidadId = especialidadId;
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

    public BigInteger getPromedio() {
        return promedio;
    }

    public void setPromedio(BigInteger promedio) {
        this.promedio = promedio;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
}
