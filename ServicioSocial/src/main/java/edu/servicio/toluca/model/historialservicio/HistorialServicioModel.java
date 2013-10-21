/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.historialservicio;

import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.LogServicio;
import edu.servicio.toluca.model.panelUsuario.ValidacionStatusServicio;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.LogServicioFacade;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Autor: Jose Manuel Nieto Gomez
 * Objetivo: Modelo para tratar eventos relacionados al historial del proceso
 * del alumno
 * @author bustedvillain
 */
public class HistorialServicioModel {
    
    public DatosPersonalesFacade datosPersonalesFacade;
    public LogServicioFacade logServicioFacade;

    public HistorialServicioModel(DatosPersonalesFacade datosPersonalesFacade, LogServicioFacade logServicioFacade) {
        this.datosPersonalesFacade = datosPersonalesFacade;
        this.logServicioFacade = logServicioFacade;
    }

    public HistorialServicioModel(LogServicioFacade logServicioFacade) {
        this.logServicioFacade = logServicioFacade;
    }

    public HistorialServicioModel(DatosPersonalesFacade datosPersonalesFacade) {
        this.datosPersonalesFacade = datosPersonalesFacade;
    }
    
    /**
     * Obtiene el historial de todos los alumnos que mantienen un registro en la base de datos
     * @return 
     */
    public List<StatusServicioBean> getHistorialAlumnos(){
        List<StatusServicioBean> servicios = new ArrayList<StatusServicioBean>();
        
        List<DatosPersonales> datosPersonales = datosPersonalesFacade.findAll();
        //Valida estatus del servicio social
        ValidacionStatusServicio validacionServicio = new ValidacionStatusServicio();
        

        System.out.println(datosPersonales.size()+" alumnos en el proceso de servico social");
        for (int i = 0; i < datosPersonales.size(); i++) {
            try{
                StatusServicioBean servicioBean = validacionServicio.validaServicio(datosPersonales.get(i).getAlumnoId());
                servicios.add(servicioBean);
                System.out.println("Alumno procesado y agregado: "+servicioBean.getDatosPersonales().getNombre());
            }catch(Exception e){
                System.out.println("Error al procesar al alumno con control "+datosPersonales.get(i).getAlumnoId().getId());
            }
        }
        
        return servicios;
    }
    
    /**
     * Metodo que registra un nuevo evento en el historial del servicio social de un alumno
     * @param datosPersonales alumno
     * @param detalle detalle del evento que se esta registrando
     */
    public void registraEvento(DatosPersonales datosPersonales, String detalle){
        LogServicio logServicio = new LogServicio();
        logServicio.setDatosPersonalesId(datosPersonales);
        logServicio.setAlumnoId(BigInteger.valueOf(Long.parseLong(datosPersonales.getAlumnoId().getId())));
        logServicio.setFecha(new Date());
        logServicio.setDetalle(detalle);
        logServicio.setTipoLog(BigInteger.ZERO);
        logServicioFacade.create(logServicio);
    }
    
    
}
