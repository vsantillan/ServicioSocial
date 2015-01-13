/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.historialservicio;

import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.dao.GenericDao;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.LogServicio;
import edu.servicio.toluca.model.panelUsuario.ValidacionStatusServicio;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.LogServicioFacade;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Autor: Jose Manuel Nieto Gomez 
 * 
 * Objetivo: Modelo para tratar eventos
 * relacionados al historial del proceso del alumno
 *
 * @author bustedvillain
 */
public class HistorialServicioModel
{
    
    private GenericDao<DatosPersonales> daoDatosPersonales;
    private GenericDao<LogServicio> daoLogServicio;
    
    @Autowired
    public void setDaoDatosPersonales(GenericDao<DatosPersonales> daoDatosPersonales)
    {
        this.daoDatosPersonales = daoDatosPersonales;
        daoDatosPersonales.setClass(DatosPersonales.class);
    }
    
    @Autowired
    public void setDaoLogServicio(GenericDao<LogServicio> daoLogServicio)
    {
        this.daoLogServicio = daoLogServicio;
        daoLogServicio.setClass(LogServicio.class);
    }

    public HistorialServicioModel(GenericDao<DatosPersonales> daoDatosPersonales, GenericDao<LogServicio> daoLogServicio)
    {
        this.daoDatosPersonales = daoDatosPersonales;
        this.daoLogServicio = daoLogServicio;
    }

    //ESTO NO SE USA, POR ESO LO COMENTÉ
//    public HistorialServicioModel(GenericDao<LogServicio> daoLogServicio)
//    {
//        this.daoLogServicio = daoLogServicio;
//    }

    public HistorialServicioModel(GenericDao<DatosPersonales> daoDatosPersonales)
    {
        this.daoDatosPersonales = daoDatosPersonales;
    }

    /**
     * Obtiene el historial de todos los alumnos que mantienen un registro en la
     * base de datos
     *
     * @return
     */
    public List<StatusServicioBean> getHistorialAlumnos()
    {
        List<StatusServicioBean> servicios = new ArrayList<StatusServicioBean>();
        List<DatosPersonales> datosPersonales = daoDatosPersonales.findAll();
        
        //Valida estatus del servicio social
        ValidacionStatusServicio validacionServicio = new ValidacionStatusServicio();

        System.out.println(datosPersonales.size() + " alumnos en el proceso de servico social");
        for(int i = 0; i < datosPersonales.size(); i++)
        {
            try
            {
                StatusServicioBean servicioBean = validacionServicio.validaServicio(datosPersonales.get(i).getAlumnoId());
                servicios.add(servicioBean);
                System.out.println("Alumno procesado y agregado: " + servicioBean.getDatosPersonales().getNombre());
            } 
            catch(Exception e)
            {
                System.out.println("Error al procesar al alumno con control " + datosPersonales.get(i).getAlumnoId().getId());
            }
        }

        return servicios;
    }

    /**
     * Metodo que registra un nuevo evento en el historial del servicio social
     * de un alumno
     *
     * @param datosPersonales alumno
     * @param detalle detalle del evento que se esta registrando
     */
    public void registraEvento(DatosPersonales datosPersonales, String detalle)
    {
        LogServicio logServicio = new LogServicio();
        logServicio.setDatosPersonalesId(datosPersonales);
        logServicio.setAlumnoId(BigInteger.valueOf(Long.parseLong(datosPersonales.getAlumnoId().getId())));

        logServicio.setFecha(Calendar.getInstance().getTime());
        logServicio.setDetalle(detalle);
        logServicio.setTipoLog(BigInteger.ZERO);
        daoLogServicio.create(logServicio);
    }

    public List<LogServicio> getHistorialEventos(DatosPersonales datosPersonales)
    {
        List<LogServicio> historial = new ArrayList<LogServicio>();
        try
        {
            System.out.println("logservicio:" + daoLogServicio);
            historial = daoLogServicio.findBySpecificField("datosPersonalesId", datosPersonales, "equal", null, null);
        } catch(Exception e)
        {
            System.out.println("Error al cargar el historial de eventos");
            e.printStackTrace();
        }
        return historial;
    }

}
