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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author SATELLITE
 */
@Cache(usage = CacheConcurrencyStrategy.NONE)
@Entity
@Table(name = "PROYECTOS", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p"),
    @NamedQuery(name = "Proyectos.findByIdProyecto", query = "SELECT p FROM Proyectos p WHERE p.idProyecto = :idProyecto"),
    @NamedQuery(name = "Proyectos.findByDomicilio", query = "SELECT p FROM Proyectos p WHERE p.domicilio = :domicilio"),
    @NamedQuery(name = "Proyectos.findByNombreResponsable", query = "SELECT p FROM Proyectos p WHERE p.nombreResponsable = :nombreResponsable"),
    @NamedQuery(name = "Proyectos.findByResponsablePuesto", query = "SELECT p FROM Proyectos p WHERE p.responsablePuesto = :responsablePuesto"),
    @NamedQuery(name = "Proyectos.findByTelefonoResponsable", query = "SELECT p FROM Proyectos p WHERE p.telefonoResponsable = :telefonoResponsable"),
    @NamedQuery(name = "Proyectos.findByValidacionAdmin", query = "SELECT p FROM Proyectos p WHERE p.validacionAdmin = :validacionAdmin"),
    @NamedQuery(name = "Proyectos.findByEstatus", query = "SELECT p FROM Proyectos p WHERE p.estatus = :estatus"),
    @NamedQuery(name = "Proyectos.findByModalidad", query = "SELECT p FROM Proyectos p WHERE p.modalidad = :modalidad"),
    @NamedQuery(name = "Proyectos.findByFechaAlta", query = "SELECT p FROM Proyectos p WHERE p.fechaAlta = :fechaAlta"),
    @NamedQuery(name = "Proyectos.findByVacantes", query = "SELECT p FROM Proyectos p WHERE p.vacantes = :vacantes"),
    @NamedQuery(name = "Proyectos.findByVacantesDisponibles", query = "SELECT p FROM Proyectos p WHERE p.vacantesDisponibles = :vacantesDisponibles"),
    @NamedQuery(name = "Proyectos.findByNombre", query = "SELECT p FROM Proyectos p WHERE p.nombre = :nombre")})
public class Proyectos implements Serializable {
    @Size(max = 7)
    @Column(name = "EXT")
    private String ext;
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private Collection<RetroalimentacionProyecto2> retroalimentacionProyecto2Collection;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    @Basic(optional = false)
    @Column(name = "ID_PROYECTO")
    private BigDecimal idProyecto;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "DOMICILIO")
    private String domicilio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE_RESPONSABLE")
    @NotBlank
    private String nombreResponsable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "RESPONSABLE_PUESTO")
    private String responsablePuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TELEFONO_RESPONSABLE")
    private long telefonoResponsable;
    @Basic(optional = false)
    @Column(name = "VALIDACION_ADMIN")
    private BigInteger validacionAdmin;
    @Basic(optional = false)
    @Column(name = "ESTATUS")
    private BigInteger estatus;
    @Basic(optional = false)
    @Column(name = "MODALIDAD")
    private String modalidad;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VACANTES")
    @Min(1)
    private BigInteger vacantes;
    @Basic(optional = false)
    @Column(name = "VACANTES_DISPONIBLES")
    @Min(1)
    private BigInteger vacantesDisponibles;
    @Basic(optional = false)
    @Size(min = 1,max = 60)
    @NotNull
    @NotBlank
    @Column(name = "NOMBRE")
    private String nombre;
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private Collection<ProyectoPerfil> proyectoPerfilCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    private Collection<Actividades> actividadesCollection;
    @JoinColumn(name = "ID_TIPO_PROYECTO", referencedColumnName = "ID_TIPO_PROYECTO")
    @ManyToOne(optional = false)
    private TipoProyecto idTipoProyecto;
    @JoinColumn(name = "ID_PROGRAMA", referencedColumnName = "ID_PROGRAMA")
    @ManyToOne(optional = false)
    private Programa idPrograma;
    @JoinColumn(name = "ID_INSTANCIA", referencedColumnName = "ID_INSTANCIA")
    @ManyToOne(optional = false)
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    private Instancia idInstancia;
    @JoinColumn(name = "ID_COLONIA", referencedColumnName = "ID_COLONIA")
    @ManyToOne
    private Colonia idColonia;
    @OneToMany(mappedBy = "idproyecto")
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    private Collection<FormatoUnico> formatoUnicoCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstancia")
//    private Collection<RetroalimentacionProyecto> retroalimentacionProyectoCollection;
//    
    public Proyectos() {
    }

    public Proyectos(BigDecimal idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Proyectos(BigDecimal idProyecto, String domicilio, String nombreResponsable, String responsablePuesto, long telefonoResponsable, BigInteger validacionAdmin, BigInteger estatus, String modalidad, Date fechaAlta, BigInteger vacantes, BigInteger vacantesDisponibles) {
        this.idProyecto = idProyecto;
        this.domicilio = domicilio;
        this.nombreResponsable = nombreResponsable;
        this.responsablePuesto = responsablePuesto;
        this.telefonoResponsable = telefonoResponsable;
        this.validacionAdmin = validacionAdmin;
        this.estatus = estatus;
        this.modalidad = modalidad;
        this.fechaAlta = fechaAlta;
        this.vacantes = vacantes;
        this.vacantesDisponibles = vacantesDisponibles;
    }

    public BigDecimal getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(BigDecimal idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public String getResponsablePuesto() {
        return responsablePuesto;
    }

    public void setResponsablePuesto(String responsablePuesto) {
        this.responsablePuesto = responsablePuesto;
    }

    public long getTelefonoResponsable() {
        return telefonoResponsable;
    }

    public void setTelefonoResponsable(long telefonoResponsable) {
        this.telefonoResponsable = telefonoResponsable;
    }

    public BigInteger getValidacionAdmin() {
        return validacionAdmin;
    }
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    public void setValidacionAdmin(BigInteger validacionAdmin) {
        this.validacionAdmin = validacionAdmin;
    }
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    public BigInteger getEstatus() {
        return estatus;
    }
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    public void setEstatus(BigInteger estatus) {
        this.estatus = estatus;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public BigInteger getVacantes() {
        return vacantes;
    }

    public void setVacantes(BigInteger vacantes) {
        this.vacantes = vacantes;
    }

    public BigInteger getVacantesDisponibles() {
        return vacantesDisponibles;
    }

    public void setVacantesDisponibles(BigInteger vacantesDisponibles) {
        this.vacantesDisponibles = vacantesDisponibles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    public Collection<ProyectoPerfil> getProyectoPerfilCollection() {
        return proyectoPerfilCollection;
    }

    public void setProyectoPerfilCollection(Collection<ProyectoPerfil> proyectoPerfilCollection) {
        this.proyectoPerfilCollection = proyectoPerfilCollection;
    }
    
    @XmlTransient
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    public Collection<Actividades> getActividadesCollection() {
        return actividadesCollection;
    }

    public void setActividadesCollection(Collection<Actividades> actividadesCollection) {
        this.actividadesCollection = actividadesCollection;
    }

    public TipoProyecto getIdTipoProyecto() {
        return idTipoProyecto;
    }

    public void setIdTipoProyecto(TipoProyecto idTipoProyecto) {
        this.idTipoProyecto = idTipoProyecto;
    }

    public Programa getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Programa idPrograma) {
        this.idPrograma = idPrograma;
    }
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    public Instancia getIdInstancia() {
        return idInstancia;
    }

    public void setIdInstancia(Instancia idInstancia) {
        this.idInstancia = idInstancia;
    }

    public Colonia getIdColonia() {
        return idColonia;
    }

    public void setIdColonia(Colonia idColonia) {
        this.idColonia = idColonia;
    }

    @XmlTransient
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    public Collection<FormatoUnico> getFormatoUnicoCollection() {
        return formatoUnicoCollection;
    }

    public void setFormatoUnicoCollection(Collection<FormatoUnico> formatoUnicoCollection) {
        this.formatoUnicoCollection = formatoUnicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.Proyectos[ idProyecto=" + idProyecto + " ]";
    }

    @XmlTransient
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    public Collection<RetroalimentacionProyecto2> getRetroalimentacionProyecto2Collection() {
        return retroalimentacionProyecto2Collection;
    }

    public void setRetroalimentacionProyecto2Collection(Collection<RetroalimentacionProyecto2> retroalimentacionProyecto2Collection) {
        this.retroalimentacionProyecto2Collection = retroalimentacionProyecto2Collection;
    }
    
    public void getInfToBd(){
        System.out.println("Proyecto");
        try{
            System.out.println("idProyecto:"+getIdProyecto());
        }catch(Exception e){
            System.out.println("Aun no tiene idProyecto");
        }        
        System.out.println("idInstancia:"+getIdInstancia().getIdInstancia());
        System.out.println("Nombre proyecto:"+getNombre());
        System.out.println("Vacantes:"+getVacantes());
        System.out.println("Vacantes disponibles:"+getVacantesDisponibles());
        System.out.println("Responsable:"+getNombreResponsable());
        System.out.println("Puesto responsable:"+getResponsablePuesto());
        System.out.println("Telefono:"+getTelefonoResponsable());
        System.out.println("Domicilio:"+getDomicilio());
        System.out.println("idColonia:"+getIdColonia().getIdColonia());
        System.out.println("ValidacionAdmin:"+getValidacionAdmin());
        System.out.println("Estatus:"+getEstatus());
        System.out.println("idPrograma:"+getIdPrograma().getIdPrograma());
        System.out.println("Modalidad:"+getModalidad());
        System.out.println("Fecha alta:"+getFechaAlta());
        System.out.println("Tipo Poryecto:"+getIdTipoProyecto().getIdTipoProyecto());
        
    }
    
    public void getEverythingDebugged(){
        
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
    
}
