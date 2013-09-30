/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.panelUsuario;

import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.VistaAlumno;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bustedvillain
 */
public class ValidacionStatusServicio {

    public StatusServicioBean validaServicio(VistaAlumno vistaAlumno) {

        StatusServicioBean servicioBean = new StatusServicioBean();
        try {
            List<DatosPersonales> datosPersonales = new ArrayList<DatosPersonales>(vistaAlumno.getDatosPersonalesCollection());
            List<FormatoUnico> formatoUnicoColl = new ArrayList<FormatoUnico>(datosPersonales.get(0).getFormatoUnicoCollection());
            FormatoUnico formatoUnico = formatoUnicoColl.get(0);
            
            int statusServicio = Integer.parseInt(formatoUnico.getStatusServicio().toString());
            servicioBean.setStatusServicio(statusServicio);
            servicioBean.setDatosPersonales(datosPersonales.get(0));
            servicioBean.setFormatoUnico(formatoUnico);
            servicioBean.setVistaAlumno(vistaAlumno);
            
            switch (statusServicio) {
                //Activo
                case 1:
                    servicioBean.setMensaje("Servicio Social Activo");
                    break;
                //Cancelado
                case 2:
                    servicioBean.setMensaje("Tu servicio social ha sido cancelado");
                    break;
                //Baja Temporal
                case 3:
                    servicioBean.setMensaje("Tu servicio social esta dado de baja temporalmente");
                    break;
                //Terminado
                case 4:
                    servicioBean.setMensaje("Tu servicio social ya ha concluido");
                    break;
            }

        } catch (Exception e) {
            System.out.println("Newbie en el sistema sin datos personales");
            servicioBean.setMensaje("Servicio Social Activo");
            servicioBean.setStatusServicio(1);
        }
        return servicioBean;
    }
}
