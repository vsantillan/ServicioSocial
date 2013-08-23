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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author SATELLITE
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
    @GenericGenerator(name = "horariosAlumnoG", strategy = "increment")
    @Id
    @GeneratedValue(generator="horariosAlumnoG")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 30)
    @Column(name = "DIA")
    private String dia;
    @Size(max = 5)
    @Column(name = "HORA_INICIO")
    private String horaInicio;
    @Size(max = 5)
    @Column(name = "HORA_FIN")
    private String horaFin;
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

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
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
