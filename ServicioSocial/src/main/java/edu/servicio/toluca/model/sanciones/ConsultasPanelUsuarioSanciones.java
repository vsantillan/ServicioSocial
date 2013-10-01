/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.sanciones;

import edu.servicio.toluca.beans.SancionesBean;
import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.entidades.Sanciones;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bustedvillain
 */
public class ConsultasPanelUsuarioSanciones {

    public SancionesBean consultaHorasSancion(StatusServicioBean servicioBean) {
        SancionesBean sancionesBean = new SancionesBean();

        List<Sanciones> sanciones = new ArrayList<Sanciones>(servicioBean.getDatosPersonales().getSancionesCollection());
        for (int i = 0; i < sanciones.size(); i++) {
            int horas = Integer.parseInt(sanciones.get(i).getHorasSancion().toString());
            sancionesBean.sumaHoras(horas);
        }
        
        if(sancionesBean.getHorasSancion()>0){
            sancionesBean.setMensaje("Tienes un total de "+sancionesBean.getHorasSancion()+" horas de sancion, favor de acudir a la oficina de servicio social para que se te asigne una instancia donde pagar tu horas de sancion.");
            sancionesBean.setTieneSancion(true);
        }else{
            sancionesBean.setMensaje("No tienes sanciones");
            sancionesBean.setTieneSancion(false);
        }
        

        return sancionesBean;
    }
}
