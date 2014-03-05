/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import edu.servicio.toluca.configuracion.CatalogoErrores;
import edu.servicio.toluca.configuracion.ExpresionesRegulares;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author SATELLITE
 */
@Entity
@Table(name = "NOTICIAS", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Noticias.findAll", query = "SELECT n FROM Noticias n"),
    @NamedQuery(name = "Noticias.findById", query = "SELECT n FROM Noticias n WHERE n.id = :id"),
    @NamedQuery(name = "Noticias.findByFecha", query = "SELECT n FROM Noticias n WHERE n.fecha = :fecha"),
    @NamedQuery(name = "Noticias.findByDetalle", query = "SELECT n FROM Noticias n WHERE n.detalle = :detalle"),
    @NamedQuery(name = "Noticias.findByTipoServicio", query = "SELECT n FROM Noticias n WHERE n.tipoServicio = :tipoServicio")})
public class Noticias implements Serializable, ExpresionesRegulares, CatalogoErrores {
    
    @Size(max = 255)
    @Pattern(regexp = letrasPrimeroDespuesEspacios, message = errorLetrasNumeros)
    @Column(name = "TITULO")
    private String titulo;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "noticiasG", strategy = "increment")
    @Id
    @GeneratedValue(generator="noticiasG")
    @Basic(optional = false)
    @NotNull(message = "Saaaa") 
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    //@NotEmpty(message = "Escribe el Detalle de la Noticia")
    @Size(max =1000,message = "El detalle debe de ser mayor a 1 caracter y menor que 1000")
    @Column(name = "DETALLE")
    private String detalle;
    //1. Noticas para pagina principal, 2. Noticias para alumnos, 3. Noticias para organizaciones, 4. Noticias para becados 0.Noticia Eliminada
    @NotNull(message = "Selecciona un Tipo de Noticia") 
    @Column(name = "TIPO_SERVICIO")
    private BigInteger tipoServicio;

    public Noticias() {
    }

    public Noticias(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    /**
     * 1. Noticas para pagina principal, 2. Noticias para alumnos, 3. Noticias para organizaciones
     * @return 
     */
    public BigInteger getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(BigInteger tipoServicio) {
        this.tipoServicio = tipoServicio;
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
        if (!(object instanceof Noticias)) {
            return false;
        }
        Noticias other = (Noticias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.Noticias[ id=" + id + " ]";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
