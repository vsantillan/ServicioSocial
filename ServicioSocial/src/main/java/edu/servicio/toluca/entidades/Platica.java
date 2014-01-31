/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import edu.servicio.toluca.configuracion.ExpresionesRegularesErrores;
import static edu.servicio.toluca.configuracion.ExpresionesRegularesErrores.comentarios;
import static edu.servicio.toluca.configuracion.ExpresionesRegularesErrores.fechaER;
import static edu.servicio.toluca.configuracion.ExpresionesRegularesErrores.numeros;
import java.io.Serializable;
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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author SATELLITE
 */
@Cache(usage = CacheConcurrencyStrategy.NONE)
@Entity
@Table(name = "PLATICA", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platica.findAll", query = "SELECT p FROM Platica p"),
    @NamedQuery(name = "Platica.findById", query = "SELECT p FROM Platica p WHERE p.id = :id"),
    @NamedQuery(name = "Platica.findByFecha", query = "SELECT p FROM Platica p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Platica.findByHora", query = "SELECT p FROM Platica p WHERE p.hora = :hora"),
    @NamedQuery(name = "Platica.findByPeriodo", query = "SELECT p FROM Platica p WHERE p.periodo = :periodo"),
    @NamedQuery(name = "Platica.findByAnio", query = "SELECT p FROM Platica p WHERE p.anio = :anio"),
    @NamedQuery(name = "Platica.findByNumeroAsistentes", query = "SELECT p FROM Platica p WHERE p.numeroAsistentes = :numeroAsistentes"),
    @NamedQuery(name = "Platica.findByTipo", query = "SELECT p FROM Platica p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Platica.findByStatus", query = "SELECT p FROM Platica p WHERE p.status = :status"),
    @NamedQuery(name = "Platica.findByFechaMxFui", query = "SELECT p FROM Platica p WHERE p.fechaMxFui = :fechaMxFui"),
    @NamedQuery(name = "Platica.findByDescripcion", query = "SELECT p FROM Platica p WHERE p.descripcion = :descripcion")})
public class Platica implements ExpresionesRegularesErrores, Serializable{
    private static final long serialVersionUID = 1L;
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull(message = "El campo fecha no puede estar vacio")
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(min=5,max = 5,message = "El campo hora no es correcto")
    @Column(name = "HORA")
    @Pattern(regexp = horas, message = "El campo Horas tiene formato incorrecto (HH:MM).")
    private String hora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PERIODO")
    private String periodo;
    @Size(min=1, max = 4, message = "El campo Año debe tener 4 números")
    @Pattern(regexp = numeros, message = "El campo año sólo puede contener Números")
    @Column(name = "ANIO")
    private String anio;
    @Column(name = "NUMERO_ASISTENTES")
    //@Pattern(regexp = numeros, message = "El campo Número de Asistentes sólo puede contener Números")
    private Integer numeroAsistentes;
    @Column(name = "TIPO")
    private Short tipo;
    @Column(name = "STATUS")
    private Short status;
    @Column(name = "FECHA_MX_FUI")
    //@Pattern(regexp = fechaER, message = "El campo Fecha Máxima Formato Único tiene formato incorrecto (DD/MM/AAAA).")
    @Temporal(TemporalType.DATE)
    private Date fechaMxFui;
    @Pattern(regexp = comentarios, message = "El campo Descripción sólo puede contener Letras")
    @Size(min = 1, max = 100, message = "El campo Descripción no puede estar vacío")
    @Column(name = "DESCRIPCION")
    private String descripcion;
  
    @JoinColumn(name = "ID_LUGAR", referencedColumnName = "ID")
    @ManyToOne
    private LugaresPlatica idLugar;
    @OneToMany(mappedBy = "platicaId")
    private Collection<FoliosPlatica> foliosPlaticaCollection;

    public Platica() {
    }

    public Platica(Long id) {
        this.id = id;
    }

    public Platica(Long id, Date fecha, String periodo) {
        this.id = id;
        this.fecha = fecha;
        this.periodo = periodo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Integer getNumeroAsistentes() {
        return numeroAsistentes;
    }

    public void setNumeroAsistentes(Integer numeroAsistentes) {
        this.numeroAsistentes = numeroAsistentes;
    }

    public Short getTipo() {
        return tipo;
    }

    public void setTipo(Short tipo) {
        this.tipo = tipo;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getFechaMxFui() {
        return fechaMxFui;
    }

    public void setFechaMxFui(Date fechaMxFui) {
        this.fechaMxFui = fechaMxFui;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LugaresPlatica getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(LugaresPlatica idLugar) {
        this.idLugar = idLugar;
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
        if (!(object instanceof Platica)) {
            return false;
        }
        Platica other = (Platica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.Platica[ id=" + id + " ]";
    }
    
}
