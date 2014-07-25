/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import edu.servicio.toluca.configuracion.CatalogoErrores;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import edu.servicio.toluca.configuracion.ExpresionesRegulares;
import javax.validation.constraints.Pattern;

/**
 *
 * @author bustedvillain
 */
@Cache(usage = CacheConcurrencyStrategy.NONE)
@Entity
@Table(name = "INSTANCIA", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Instancia.findAll", query = "SELECT i FROM Instancia i"),
    @NamedQuery(name = "Instancia.findByIdInstancia", query = "SELECT i FROM Instancia i WHERE i.idInstancia = :idInstancia"),
    @NamedQuery(name = "Instancia.findByNombre", query = "SELECT i FROM Instancia i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Instancia.findByRfc", query = "SELECT i FROM Instancia i WHERE i.rfc = :rfc"),
    @NamedQuery(name = "Instancia.findByTitular", query = "SELECT i FROM Instancia i WHERE i.titular = :titular"),
    @NamedQuery(name = "Instancia.findByPuesto", query = "SELECT i FROM Instancia i WHERE i.puesto = :puesto"),
    @NamedQuery(name = "Instancia.findByTelefono", query = "SELECT i FROM Instancia i WHERE i.telefono = :telefono"),
    @NamedQuery(name = "Instancia.findByDomicilio", query = "SELECT i FROM Instancia i WHERE i.domicilio = :domicilio"),
    @NamedQuery(name = "Instancia.findByValidacionAdmin", query = "SELECT i FROM Instancia i WHERE i.validacionAdmin = :validacionAdmin"),
    @NamedQuery(name = "Instancia.findByEstatus", query = "SELECT i FROM Instancia i WHERE i.estatus = :estatus"),
    @NamedQuery(name = "Instancia.findByUsuario", query = "SELECT i FROM Instancia i WHERE i.usuario = :usuario"),
    @NamedQuery(name = "Instancia.findByPassword", query = "SELECT i FROM Instancia i WHERE i.password = :password"),
    @NamedQuery(name = "Instancia.findByCorreo", query = "SELECT i FROM Instancia i WHERE i.correo = :correo")
})
public class Instancia implements Serializable, ExpresionesRegulares, CatalogoErrores
{
    private static final long serialVersionUID = 1L;

    @Size(max = 7)
    @Column(name = "EXT")
    private String ext;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstancia")
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    private Collection<RetroalimentacionInstancia2> retroalimentacionInstancia2Collection;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    @Basic(optional = false)
    @Column(name = "ID_INSTANCIA")
    private BigDecimal idInstancia;
    
    @Basic(optional = false)
    @Size(max = 45, message = errorBetween + " 1 y 45")
    @Pattern(regexp = letrasNumerosPrimeroDespuesEspacios, message = errorLetrasNumeros)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min=12, max=13, message = "El campo RFC debe tener entre 12 y 13 caraceres")
    @Pattern(regexp = letrasNumeros, message = errorLetrasNumeros)
    @Column(name = "RFC")
    private String rfc;
    
    @Basic(optional = false)
    @NotNull
    @Size(max = 45, message = "El campo Nombre del Titular está vacío")
    @Pattern(regexp = letrasNumerosPrimeroDespuesEspacios, message = errorLetrasNumeros)
    @Column(name = "TITULAR")
    private String titular;
    
    @Basic(optional = false)
    @NotNull
    @Size(max = 45, message = "El campo Puesto no debe ser vacío")
    @Pattern(regexp = letrasNumerosPrimeroDespuesEspacios, message = errorLetrasNumeros)
    @Column(name = "PUESTO")
    private String puesto;
    
    @Basic(optional = false)
    @NotNull
    //@Size(min = 10, message = "El campo Teléfono debe contener al menos 10 números")
    //@Pattern(regexp =numeros, message = errorNumeros)
    @Column(name = "TELEFONO")
    private long telefono;
    
    @Basic(optional = false)
    @NotNull
    @Size(max = 100, message = "El campo Domicilio admite un máximo de 100 caracteres")
    @Pattern(regexp = letrasNumerosEspeciales, message = errorCampoVacio)
    @Column(name = "DOMICILIO")
    private String domicilio;
    
    @Column(name = "VALIDACION_ADMIN")
    private BigInteger validacionAdmin;
    
    @Column(name = "ESTATUS")
    private BigInteger estatus;
    
    @Size(max = 30, message = "El campo Usuario debe tener menos de 30 caracteres")
    @Pattern(regexp = letrasNumeros, message = errorLetrasNumeros)
    @Column(name = "USUARIO")
    private String usuario;
    
    @Size(max = 120, min=6, message="Debe tener al menos 6 caracteres.")
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "CORREO")
    @Size(min = 1, max = 60, message = "El campo correo no puede estar vacío")
    @Email(message = "Introduzca una dirección real, similar a: email@example.com")
    private String correo;
    
    @JoinColumn(name = "TIPO_ORGANIZACION", referencedColumnName = "ID_TIPO_ORGANIZACION")
    @ManyToOne(optional = false)
    private TipoOrganizacion tipoOrganizacion;
    
    @JoinColumn(name = "ID_COLONIA", referencedColumnName = "ID_COLONIA")
    @ManyToOne
    private Colonia idColonia;
    
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstancia")
    private Collection<Proyectos> proyectosCollection;
//@OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstancia")
//    private Collection<RetroalimentacionInstancia> retroalimentacionInstanciaCollection;

    public Instancia()
    {
    }

    public Instancia(BigDecimal idInstancia)
    {
        this.idInstancia = idInstancia;
    }

    public Instancia(BigDecimal idInstancia, String nombre, String rfc, String titular, String puesto, long telefono, String domicilio)
    {
        this.idInstancia = idInstancia;
        this.nombre = nombre;
        this.rfc = rfc;
        this.titular = titular;
        this.puesto = puesto;
        this.telefono = telefono;
        this.domicilio = domicilio;
    }

    public BigDecimal getIdInstancia()
    {
        return idInstancia;
    }

    public void setIdInstancia(BigDecimal idInstancia)
    {
        this.idInstancia = idInstancia;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getRfc()
    {
        return rfc;
    }

    public void setRfc(String rfc)
    {
        this.rfc = rfc;
    }

    public String getTitular()
    {
        return titular;
    }

    public void setTitular(String titular)
    {
        this.titular = titular;
    }

    public String getPuesto()
    {
        return puesto;
    }

    public void setPuesto(String puesto)
    {
        this.puesto = puesto;
    }

    public long getTelefono()
    {
        return telefono;
    }

    public void setTelefono(long telefono)
    {
        this.telefono = telefono;
    }

    public String getDomicilio()
    {
        return domicilio;
    }

    public void setDomicilio(String domicilio)
    {
        this.domicilio = domicilio;
    }

    @Cache(usage = CacheConcurrencyStrategy.NONE)
    public BigInteger getValidacionAdmin()
    {
        return validacionAdmin;
    }

    public void setValidacionAdmin(BigInteger validacionAdmin)
    {
        this.validacionAdmin = validacionAdmin;
    }

    @Cache(usage = CacheConcurrencyStrategy.NONE)
    public BigInteger getEstatus()
    {
        return estatus;
    }

    public void setEstatus(BigInteger estatus)
    {
        this.estatus = estatus;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getCorreo()
    {
        return correo;
    }

    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    public TipoOrganizacion getTipoOrganizacion()
    {
        return tipoOrganizacion;
    }

    public void setTipoOrganizacion(TipoOrganizacion tipoOrganizacion)
    {
        this.tipoOrganizacion = tipoOrganizacion;
    }

    public Colonia getIdColonia()
    {
        return idColonia;
    }

    public void setIdColonia(Colonia idColonia)
    {
        this.idColonia = idColonia;
    }

    @XmlTransient
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    public Collection<Proyectos> getProyectosCollection()
    {
        return proyectosCollection;
    }

    public void setProyectosCollection(Collection<Proyectos> proyectosCollection)
    {
        this.proyectosCollection = proyectosCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idInstancia != null ? idInstancia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(!(object instanceof Instancia))
        {
            return false;
        }
        Instancia other = (Instancia) object;
        if((this.idInstancia == null && other.idInstancia != null) || (this.idInstancia != null && !this.idInstancia.equals(other.idInstancia)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "edu.servicio.toluca.entidades.Instancia[ idInstancia=" + idInstancia + " ]";
    }

    @XmlTransient
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    public Collection<RetroalimentacionInstancia2> getRetroalimentacionInstancia2Collection()
    {
        return retroalimentacionInstancia2Collection;
    }

    public void setRetroalimentacionInstancia2Collection(Collection<RetroalimentacionInstancia2> retroalimentacionInstancia2Collection)
    {
        this.retroalimentacionInstancia2Collection = retroalimentacionInstancia2Collection;
    }

    public String getExt()
    {
        return ext;
    }

    public void setExt(String ext)
    {
        this.ext = ext;
    }
}
