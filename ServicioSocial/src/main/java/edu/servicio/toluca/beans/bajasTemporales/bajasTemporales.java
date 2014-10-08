/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.bajasTemporales;

import edu.servicio.toluca.entidades.DatosPersonales;
import java.util.Date;

public class BajasTemporales
{

    private String periodo;
    private Date fechaBaja;
    private Date fechaLimiteBaja;
    private DatosPersonales datosPersonales;

    public String getPeriodo()
    {
        return periodo;
    }

    public void setPeriodo(String periodo)
    {
        this.periodo = periodo;
    }

    public Date getFechaBaja()
    {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja)
    {
        this.fechaBaja = fechaBaja;
    }

    public Date getFechaLimiteBaja()
    {
        return fechaLimiteBaja;
    }

    public void setFechaLimiteBaja(Date fechaLimiteBaja)
    {
        this.fechaLimiteBaja = fechaLimiteBaja;
    }

    public DatosPersonales getDatosPersonales()
    {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales)
    {
        this.datosPersonales = datosPersonales;
    }

}
