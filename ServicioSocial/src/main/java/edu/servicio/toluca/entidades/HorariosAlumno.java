/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ekt
 */
@Entity
@Table(name = "HORARIOS_ALUMNO", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorariosAlumno.findAll", query = "SELECT h FROM HorariosAlumno h"),
    @NamedQuery(name = "HorariosAlumno.findById", query = "SELECT h FROM HorariosAlumno h WHERE h.id = :id"),
    @NamedQuery(name = "HorariosAlumno.findByDia", query = "SELECT h FROM HorariosAlumno h WHERE h.dia = :dia"),
    @NamedQuery(name = "HorariosAlumno.findByHoraInicio", query = "SELECT h FROM HorariosAlumno h WHERE h.horaInicio = :horaInicio"),
    @NamedQuery(name = "HorariosAlumno.findByHoraFin", query = "SELECT h FROM HorariosAlumno h WHERE h.horaFin = :horaFin")})
public class HorariosAlumno implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 30)
    @Column(name = "DIA")
    private String dia;
    @Column(name = "HORA_INICIO")
    private BigDecimal horaInicio;
    @Column(name = "HORA_FIN")
    private BigDecimal horaFin;
    @JoinColumn(name = "FORMATO_UNICO_ID", referencedColumnName = "ID")
    @ManyToOne
    private FormatoUnico formatoUnicoId;

    public HorariosAlumno() {
    }

    public HorariosAlumno(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public BigDecimal getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(BigDecimal horaInicio) {
        this.horaInicio = horaInicio;
    }

    public BigDecimal getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(BigDecimal horaFin) {
        this.horaFin = horaFin;
    }

    public FormatoUnico getFormatoUnicoId() {
        return formatoUnicoId;
    }

    public void setFormatoUnicoId(FormatoUnico formatoUnicoId) {
        this.formatoUnicoId = formatoUnicoId;
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
        if (!(object instanceof HorariosAlumno)) {
            return false;
        }
        HorariosAlumno other = (HorariosAlumno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.HorariosAlumno[ id=" + id + " ]";
    }
    
}
