/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.historialservicio;

import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.model.panelUsuario.ValidacionStatusServicio;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bustedvillain
 */
public class HistorialServicioModel {
    
    public DatosPersonalesFacade datosPersonalesFacade;

    public HistorialServicioModel(DatosPersonalesFacade datosPersonalesFacade) {
        this.datosPersonalesFacade = datosPersonalesFacade;
    }
    
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
}
