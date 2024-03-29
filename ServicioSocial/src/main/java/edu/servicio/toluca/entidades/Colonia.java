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
@Table(name = "COLONIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colonia.findAll", query = "SELECT c FROM Colonia c"),
    @NamedQuery(name = "Colonia.findByIdColonia", query = "SELECT c FROM Colonia c WHERE c.idColonia = :idColonia"),
    @NamedQuery(name = "Colonia.findByNombre", query = "SELECT c FROM Colonia c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Colonia.findByStatus", query = "SELECT c FROM Colonia c WHERE c.status = :status")})
public class Colonia implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COLONIA")
    private BigDecimal idColonia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "STATUS")
    private BigInteger status;
    @JoinColumn(name = "ID_CP", referencedColumnName = "ID_CP")
    @ManyToOne
    private CodigosPostales idCp;
    @OneToMany(mappedBy = "idColonia")
    private Collection<Instancia> instanciaCollection;
    @OneToMany(mappedBy = "idColonia")
    private Collection<DatosPersonales> datosPersonalesCollection;
    @OneToMany(mappedBy = "idColonia")
    private Collection<Proyectos> proyectosCollection;

    public Colonia() {
    }

    public Colonia(BigDecimal idColonia) {
        this.idColonia = idColonia;
    }

    public Colonia(BigDecimal idColonia, String nombre) {
        this.idColonia = idColonia;
        this.nombre = nombre;
    }

    public BigDecimal getIdColonia() {
        return idColonia;
    }

    public void setIdColonia(BigDecimal idColonia) {
        this.idColonia = idColonia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    public CodigosPostales getIdCp() {
        return idCp;
    }

    public void setIdCp(CodigosPostales idCp) {
        this.idCp = idCp;
    }

    @XmlTransient
    public Collection<Instancia> getInstanciaCollection() {
        return instanciaCollection;
    }

    public void setInstanciaCollection(Collection<Instancia> instanciaCollection) {
        this.instanciaCollection = instanciaCollection;
    }

    @XmlTransient
    public Collection<DatosPersonales> getDatosPersonalesCollection() {
        return datosPersonalesCollection;
    }

    public void setDatosPersonalesCollection(Collection<DatosPersonales> datosPersonalesCollection) {
        this.datosPersonalesCollection = datosPersonalesCollection;
    }

    @XmlTransient
    public Collection<Proyectos> getProyectosCollection() {
        return proyectosCollection;
    }

    public void setProyectosCollection(Collection<Proyectos> proyectosCollection) {
        this.proyectosCollection = proyectosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColonia != null ? idColonia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colonia)) {
            return false;
        }
        Colonia other = (Colonia) object;
        if ((this.idColonia == null && other.idColonia != null) || (this.idColonia != null && !this.idColonia.equals(other.idColonia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.Colonia[ idColonia=" + idColonia + " ]";
    }
    
}
