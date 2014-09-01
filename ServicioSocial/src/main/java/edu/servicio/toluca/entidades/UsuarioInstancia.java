/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.servicio.toluca.entidades;

import edu.servicio.toluca.configuracion.ExpresionesRegulares;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author giovanni
 */
@Cache(usage = CacheConcurrencyStrategy.NONE)
@Entity
@Table( name = "USUARIO_INSTANCIA")
@XmlRootElement
public class UsuarioInstancia implements Serializable, ExpresionesRegulares
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID_USUARIO_INSTANCIA")
    @GenericGenerator( name = "generator", strategy = "increment")
    @GeneratedValue( generator = "generator" )
    private BigDecimal idUsuarioInstancia;
    
    @Basic(optional = false)
    @Column( name = "NOMBRE")
    @NotNull
    @Pattern(regexp =  letras, message = "Ingrese solo letras por favor")
    @Size(max = 100, message = "No se admiten nombres de mas de 100 caracteres")
    private String nombre;
    
    @Basic(optional = false)
    @Column( name = "APELLIDO_PAT")
    @NotNull
    @Pattern(regexp =  letras, message = "Ingrese solo letras por favor")
    @Size(max = 100, message = "No se admiten apellidos de mas de 100 caracteres")
    private String apellidoPat;
    
    @Basic(optional = false)
    @Column( name = "APELLIDO_MAT")
    @NotNull
    @Pattern(regexp =  letras, message = "Ingrese solo letras por favor")
    @Size(max = 100, message = "No se admiten apellidos de mas de 100 caracteres")
    private String apellidoMat;
    
    @Basic(optional = false)
    @Column(name = "PUESTO")
    @NotNull
    @Size(max = 150, message = "No de admiten mas de 150 caracteres")
    @Pattern(regexp = letrasNumerosPrimeroDespuesEspacios, message = "Ingrese primero letras o números por favor")
    private String puesto;
    
    @Basic(optional = false)
    @Column(name = "TELEFONO")
    @NotNull
    @Pattern(regexp = numeros, message = "Ingrese solo numeros por favor.")
    @Size(min = 5, message = "Ingrese al menos 5 digitos.")
    private String telefono;
    
    @Basic(optional = false)
    @Column(name = "EXT")
    @Pattern(regexp = numeros, message = "Ingrese solo numeros por favor.")
    private String extension;
    
    @Column(name = "STATUS")
    @NotNull
    private short status;
    
    @Column(name = "EMAIL")
    @Email(message = "Ingrese una dirección valida, similar a: email@example.com")
    @NotNull
    @Size(max = 500, message = "Ingrese un email de menos de 500 caracteres")
    private String email;
    
    @Column(name = "PASSWORD")
    @NotNull
    @Size(max = 1000, min = 6, message = "Debe incluir al menos 6 caracteres")
    private String password;
    
    
  // RELACIONES
    
    @Cache(usage = CacheConcurrencyStrategy.NONE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioInstancia")
    private Collection<Instancia> instancias;
    
    
    public UsuarioInstancia() { }
    
    public UsuarioInstancia(BigDecimal idUsuarioInstancia)
    {
        this.idUsuarioInstancia = idUsuarioInstancia;
    }

    /**
     * @return the idUsuarioInstancia
     */
    public BigDecimal getIdUsuarioInstancia()
    {
        return idUsuarioInstancia;
    }

    /**
     * @param idUsuarioInstancia the idUsuarioInstancia to set
     */
    public void setIdUsuarioInstancia(BigDecimal idUsuarioInstancia)
    {
        this.idUsuarioInstancia = idUsuarioInstancia;
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
     * @return the apellidoPat
     */
    public String getApellidoPat()
    {
        return apellidoPat;
    }

    /**
     * @param apellidoPat the apellidoPat to set
     */
    public void setApellidoPat(String apellidoPat)
    {
        this.apellidoPat = apellidoPat;
    }

    /**
     * @return the apellidoMat
     */
    public String getApellidoMat()
    {
        return apellidoMat;
    }

    /**
     * @param apellidoMat the apellidoMat to set
     */
    public void setApellidoMat(String apellidoMat)
    {
        this.apellidoMat = apellidoMat;
    }

    /**
     * @return the puesto
     */
    public String getPuesto()
    {
        return puesto;
    }

    /**
     * @param puesto the puesto to set
     */
    public void setPuesto(String puesto)
    {
        this.puesto = puesto;
    }

    /**
     * @return the telefono
     */
    public String getTelefono()
    {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    /**
     * @return the extension
     */
    public String getExtension()
    {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(String extension)
    {
        this.extension = extension;
    }

    /**
     * @return el status del usuario:                       <br/>
     *         0 : Pendiente de revisar por administrador   <br/>
     *         1 : Aprobado por el administrador            <br/>
     *         2 : Aprobado pero inactivo                   <br/>
     */
    public short getStatus()
    {
        return status;
    }

    /**
     * Asigna el status al usuario
     * @param status El status que se asignara:            <br/>
     *        0 : Pendiente de revisar por administrador   <br/>
     *        1 : Aprobado por el administrador            <br/>
     *        2 : Aprobado pero inactivo                   <br/>
     *        
     */
    public void setStatus(short status)
    {
        this.status = status;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idUsuarioInstancia != null ? idUsuarioInstancia.hashCode() : 0);
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
        final UsuarioInstancia other = (UsuarioInstancia) obj;
        if(this.idUsuarioInstancia != other.idUsuarioInstancia && (this.idUsuarioInstancia == null || !this.idUsuarioInstancia.equals(other.idUsuarioInstancia)))
        {
            return false;
        }
        return true;
    }
}
