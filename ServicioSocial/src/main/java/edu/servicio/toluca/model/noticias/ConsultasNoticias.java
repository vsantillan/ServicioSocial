/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.noticias;

import edu.servicio.toluca.entidades.Noticias;
import edu.servicio.toluca.sesion.NoticiasFacade;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author bustedvillain
 */
public class ConsultasNoticias {

    public NoticiasFacade noticiasFacade;

    public ConsultasNoticias(NoticiasFacade noticiasFacade) {
        this.noticiasFacade = noticiasFacade;
    }

    /**
     * Hace una consulta de noticias generales
     *
     * @param orden (desc: Orden Descendiente, asc: Orden ascendiente)
     * @return
     */
    public List<Noticias> consultaNoticiasGenerales(String orden) {
        List<Noticias> noticias = null;
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        
        if(orden.equals("desc")){
            ordenamiento.put("fecha", "desc");   
        }
        if(orden.equals("asc")){
            ordenamiento.put("fecha", "asc");
        }
        
        noticias = noticiasFacade.findAll(ordenamiento);

        return noticias;
    }
}
