/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.noticias;

import edu.servicio.toluca.beans.FechaAPalabras;
import edu.servicio.toluca.entidades.Noticias;
import edu.servicio.toluca.sesion.NoticiasFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
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
        FechaAPalabras fecha = new FechaAPalabras();
        List<Noticias> noticias = null;
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();

        if (orden.equals("desc")) {
            ordenamiento.put("fecha", "desc");
        }
        if (orden.equals("asc")) {
            ordenamiento.put("fecha", "asc");
        }
        //Consulta a las noticias generales
        noticias = noticiasFacade.findBySpecificField("tipoServicio", 2, "equal", ordenamiento, null);

        //Imprime noticias en consola
//        System.out.println("Noticias");
        if (!noticias.isEmpty()) {
            for (int i = 0; i < noticias.size(); i++) {
//                System.out.println("--------------------------------");
//                System.out.println("Fecha:"+fecha.fechaAPalabras(noticias.get(i).getFecha()));
//                System.out.println("Detalle:"+noticias.get(i).getDetalle());                
            }
        }
        return noticias;
    }
    
    
    public Noticias consultaNoticiaPrincipal(int id)
    {
        
        try
        {
         BigDecimal idNoticia = null;   
         idNoticia  = BigDecimal.valueOf(id);
         Noticias noticia=noticiasFacade.find(idNoticia);
         
         //Uno para Noticias Generales
         if(noticia.getTipoServicio().compareTo(new BigInteger("1")) == 0)
             return noticia;
         
         return null;
         
         
        }catch(Exception e)
        {
            return null;
        }
     
    }
    
    public boolean nuevaNoticia(Noticias noticia)
    {
        try
        {
            noticiasFacade.create(noticia);
            return true;
        }catch(Exception e)
        {
            return false;
        }
        
    }
    
    public Noticias obtenterNoticia(int id)
    {        
        try
        {
          BigDecimal idNoticia = null;   
          idNoticia  = BigDecimal.valueOf(id);
          Noticias noticia=noticiasFacade.find(idNoticia);
          return noticia;
        }catch(Exception e)
        {
            return null;
        }
     
    }
    
}
