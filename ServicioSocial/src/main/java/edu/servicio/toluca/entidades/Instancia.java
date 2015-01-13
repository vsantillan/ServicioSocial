/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.servicio.toluca.entidades;

import edu.servicio.toluca.configuracion.CatalogoErrores;
import static edu.servicio.toluca.configuracion.CatalogoErrores.errorLetrasNumeros;
import edu.servicio.toluca.configuracion.ExpresionesRegulares;
import static edu.servicio.toluca.configuracion.ExpresionesRegulares.letrasNumeros;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author giovanni
 */
@Cache(usage = CacheConcurrencyStrategy.NONE)
@Entity
@Table(name = "INSTANCIA2")
@XmlRootElement
public class Instancia implements Serializable, ExpresionesRegulares, CatalogoErrores
{
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TELEFONO")
    private long telefono;
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID_INSTANCIA")
    @GenericGenerator( name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator" )
    private BigDecimal idInstancia;
    
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    @NotNull
    @Pattern(regexp = letrasNumerosPrimeroDespuesEspacios, message = errorLetrasNumeros)
    @Size(min=1, max=500, message = errorBetween + "1 y 500 caracteres")
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "RFC")
    @NotNull
    @Pattern(regexp = letrasNumeros, message = errorLetrasNumeros)
    @Size(min=12, max=13, message = "El campo RFC debe tener entre 12 y 13 caraceres")
    private String rfc;
    
    
    
  // Domicilio de la INSTANCIA
    
    @Basic(optional = false)
    @Column(name = "DOMICILIO")
    @NotNull
    @Pattern(regexp = letrasNumerosEspeciales, message = errorCampoVacio)
    @Size(max = 300, message = "El campo Domicilio admite un máximo de 300 caracteres")
    private String domicilio;
    
    @JoinColumn(name = "ID_COLONIA", referencedColumnName = "ID_COLONIA")
    @ManyToOne
    private Colonia idColonia;
    
  
  // RELACIONES
    
    @JoinColumn(name = "TIPO_ORGANIZACION", referencedColumnName = "ID_TIPO_ORGANIZACION")
    @ManyToOne
    private TipoOrganizacion tipoOrganizacion;
    
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstancia")
    private Collection<Proyectos> proyectosCollection;
    
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstancia")
    private Collection<RetroalimentacionInstancia2> retroalimentacionInstancia2Collection;

    @JoinColumn(name = "ID_USUARIO_INSTANCIA", referencedColumnName = "ID_USUARIO_INSTANCIA")
    @ManyToOne
    private UsuarioInstancia usuarioInstancia;
    
  
    
    public Instancia() { }
    
    public Instancia(BigDecimal idInstancia)
    {
        this.idInstancia = idInstancia;
    }
    
    /**
     * @return the idInstancia
     */
    public BigDecimal getIdInstancia()
    {
        return idInstancia;
    }

    /**
     * @param idInstancia the idInstancia to set
     */
    public void setIdInstancia(BigDecimal idInstancia)
    {
        this.idInstancia = idInstancia;
    }

    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the rfc
     */
    public String getRfc()
    {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc)
    {
        this.rfc = rfc;
    }


    /**
     * @return the domicilio
     */
    public String getDomicilio()
    {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio)
    {
        this.domicilio = domicilio;
    }

    /**
     * @return the idColonia
     */
    public Colonia getIdColonia()
    {
        return idColonia;
    }

    /**
     * @param idColonia the idColonia to set
     */
    public void setIdColonia(Colonia idColonia)
    {
        this.idColonia = idColonia;
    }

    /**
     * @return the tipoOrganizacion
     */
    public TipoOrganizacion getTipoOrganizacion()
    {
        return tipoOrganizacion;
    }

    /**
     * @param tipoOrganizacion the tipoOrganizacion to set
     */
    public void setTipoOrganizacion(TipoOrganizacion tipoOrganizacion)
    {
        this.tipoOrganizacion = tipoOrganizacion;
    }

    /**
     * @return the proyectosCollection
     */
    public Collection<Proyectos> getProyectosCollection()
    {
        return proyectosCollection;
    }

    /**
     * @param proyectosCollection the proyectosCollection to set
     */
    public void setProyectosCollection(Collection<Proyectos> proyectosCollection)
    {
        this.proyectosCollection = proyectosCollection;
    }

    /**
     * @return the retroalimentacionInstancia2Collection
     */
    public Collection<RetroalimentacionInstancia2> getRetroalimentacionInstancia2Collection()
    {
        return retroalimentacionInstancia2Collection;
    }

    /**
     * @param retroalimentacionInstancia2Collection the retroalimentacionInstancia2Collection to set
     */
    public void setRetroalimentacionInstancia2Collection(Collection<RetroalimentacionInstancia2> retroalimentacionInstancia2Collection)
    {
        this.retroalimentacionInstancia2Collection = retroalimentacionInstancia2Collection;
    }

    /**
     * @return the usuarioInstancia
     */
    public UsuarioInstancia getUsuarioInstancia()
    {
        return usuarioInstancia;
    }

    /**
     * @param usuarioInstancia the usuarioInstancia to set
     */
    public void setUsuarioInstancia(UsuarioInstancia usuarioInstancia)
    {
        this.usuarioInstancia = usuarioInstancia;
    }
    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idInstancia != null ? idInstancia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        }
        if(getClass() != obj.getClass())
        {
            return false;
        }
        final Instancia other = (Instancia) obj;
        if(this.idInstancia != other.idInstancia && (this.idInstancia == null || !this.idInstancia.equals(other.idInstancia)))
        {
            return false;
        }
        return true;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public long getTelefono()
    {
        return telefono;
    }

    public void setTelefono(long telefono)
    {
        this.telefono = telefono;
    }
}
