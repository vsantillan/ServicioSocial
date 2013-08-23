/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.entidades;

import java.io.Serializable;
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
 * @author SATELLITE
 */
@Entity
@Table(name = "HORARIOS_TEMP", catalog = "", schema = "GES_VIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorariosTemp.findAll", query = "SELECT h FROM HorariosTemp h"),
    @NamedQuery(name = "HorariosTemp.findByHorarioId", query = "SELECT h FROM HorariosTemp h WHERE h.horarioId = :horarioId"),
    @NamedQuery(name = "HorariosTemp.findByAlumnoId", query = "SELECT h FROM HorariosTemp h WHERE h.alumnoId = :alumnoId"),
    @NamedQuery(name = "HorariosTemp.findByLunes", query = "SELECT h FROM HorariosTemp h WHERE h.lunes = :lunes"),
    @NamedQuery(name = "HorariosTemp.findByMartes", query = "SELECT h FROM HorariosTemp h WHERE h.martes = :martes"),
    @NamedQuery(name = "HorariosTemp.findByMiercoles", query = "SELECT h FROM HorariosTemp h WHERE h.miercoles = :miercoles"),
    @NamedQuery(name = "HorariosTemp.findByJueves", query = "SELECT h FROM HorariosTemp h WHERE h.jueves = :jueves"),
    @NamedQuery(name = "HorariosTemp.findByViernes", query = "SELECT h FROM HorariosTemp h WHERE h.viernes = :viernes"),
    @NamedQuery(name = "HorariosTemp.findBySabado", query = "SELECT h FROM HorariosTemp h WHERE h.sabado = :sabado"),
    @NamedQuery(name = "HorariosTemp.findByDomingo", query = "SELECT h FROM HorariosTemp h WHERE h.domingo = :domingo"),
    @NamedQuery(name = "HorariosTemp.findByStatus", query = "SELECT h FROM HorariosTemp h WHERE h.status = :status")})
public class HorariosTemp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORARIO_ID")
    private Long horarioId;
    @Size(max = 20)
    @Column(name = "ALUMNO_ID")
    private String alumnoId;
    @Size(max = 40)
    @Column(name = "LUNES")
    private String lunes;
    @Size(max = 40)
    @Column(name = "MARTES")
    private String martes;
    @Size(max = 40)
    @Column(name = "MIERCOLES")
    private String miercoles;
    @Size(max = 40)
    @Column(name = "JUEVES")
    private String jueves;
    @Size(max = 40)
    @Column(name = "VIERNES")
    private String viernes;
    @Size(max = 40)
    @Column(name = "SABADO")
    private String sabado;
    @Size(max = 40)
    @Column(name = "DOMINGO")
    private String domingo;
    @Column(name = "STATUS")
    private Short status;

    public HorariosTemp() {
    }

    public HorariosTemp(Long horarioId) {
        this.horarioId = horarioId;
    }

    public Long getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Long horarioId) {
        this.horarioId = horarioId;
    }

    public String getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(String alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }

    public String getSabado() {
        return sabado;
    }

    public void setSabado(String sabado) {
        this.sabado = sabado;
    }

    public String getDomingo() {
        return domingo;
    }

    public void setDomingo(String domingo) {
        this.domingo = domingo;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horarioId != null ? horarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorariosTemp)) {
            return false;
        }
        HorariosTemp other = (HorariosTemp) object;
        if ((this.horarioId == null && other.horarioId != null) || (this.horarioId != null && !this.horarioId.equals(other.horarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.servicio.toluca.entidades.HorariosTemp[ horarioId=" + horarioId + " ]";
    }
    
}
