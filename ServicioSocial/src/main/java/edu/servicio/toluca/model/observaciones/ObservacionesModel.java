/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.observaciones;

import edu.servicio.toluca.beans.FechaAPalabras;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.RegObservaciones;
import edu.servicio.toluca.sesion.RegObservacionesFacade;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author bustedvillain
 */
public class ObservacionesModel {
    
    public List<RegObservaciones> consultaObservaciones(DatosPersonales datosPersonales, RegObservacionesFacade regObservacionesFacade, String orden){
        FechaAPalabras fecha = new FechaAPalabras();
        List<RegObservaciones> observaciones = null;
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();

        if (orden.equals("desc")) {
            ordenamiento.put("fecha", "desc");
        }
        if (orden.equals("asc")) {
            ordenamiento.put("fecha", "asc");
        }
        //Consulta a las noticias generales
        observaciones = regObservacionesFacade.findBySpecificField("datosPersonalesId", datosPersonales, "equal", ordenamiento, null);

        //Imprime noticias en consola
//        System.out.println("Observaciones");
        if (!observaciones.isEmpty()) {
            for (int i = 0; i < observaciones.size(); i++) {
//                System.out.println("--------------------------------");
//                System.out.println("Fecha:"+fecha.fechaAPalabras(observaciones.get(i).getFecha()));
//                System.out.println("Detalle:"+observaciones.get(i).getCatalogoObservacionId().getDetalle());                
            }
        }
        return observaciones;
        
    }
    
}
