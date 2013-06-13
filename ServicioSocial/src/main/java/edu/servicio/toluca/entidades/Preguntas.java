/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bustedvillain
 */
@Entity
@Table(name = "PREGUNTAS", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preguntas.findAll", query = "SELECT p FROM Preguntas p"),
    @NamedQuery(name = "Preguntas.findById", query = "SELECT p FROM Preguntas p WHERE p.id = :id"),
    @NamedQuery(name = "Preguntas.findByPregunta", query = "SELECT p FROM Preguntas p WHERE p.pregunta = :pregunta"),
    @NamedQuery(name = "Preguntas.findByRespuesta", query = "SELECT p FROM Preguntas p WHERE p.respuesta = :respuesta"),
    @NamedQuery(name = "Preguntas.findByTipoServicio", query = "SELECT p FROM Preguntas p WHERE p.tipoServicio = :tipoServicio")})
public class Preguntas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 150)
    @Column(name = "PREGUNTA")
    private String pregunta;
    @Size(max = 150)
    @Column(name = "RESPUESTA")
    private String respuesta;
    @Column(name = "TIPO_SERVICIO")
    private BigInteger tipoServicio;

    public Preguntas() {
    }

    public Preguntas(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

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
        if (!(object instanceof Preguntas)) {
            return false;
        }
        Preguntas other = (Preguntas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.Preguntas[ id=" + id + " ]";
    }
    
}
