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
import java.util.ArrayList;
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
        List<Noticias> noticias = new ArrayList<Noticias>();
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();

        if (orden.equals("desc")) {
            ordenamiento.put("fecha", "desc");
        }
        if (orden.equals("asc")) {
            ordenamiento.put("fecha", "asc");
        }
        //Consulta a las noticias generales
//        noticias = noticiasFacade.findBySpecificField("tipoServicio", 2, "equal", ordenamiento, null);
        List<Noticias> noticiasCrude = noticiasFacade.findAll(ordenamiento);
        System.out.println("Noticias crude:"+noticiasCrude.size());
        for (int i = 0; i < noticiasCrude.size(); i++) {
            int tipo = Integer.parseInt(noticiasCrude.get(i).getTipoServicio().toString());
            if(tipo == 2 || tipo == 4){
                noticias.add(noticiasCrude.get(i));
            }
        }
        return noticias;
    }
    
    public List<Noticias> consultaNoticiasPrincipales(String orden) {
        FechaAPalabras fecha = new FechaAPalabras();
        List<Noticias> noticias = new ArrayList<Noticias>();
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();

        if (orden.equals("desc")) {
            ordenamiento.put("fecha", "desc");
        }
        if (orden.equals("asc")) {
            ordenamiento.put("fecha", "asc");
        }
        //Consulta a las noticias generales
//        noticias = noticiasFacade.findBySpecificField("tipoServicio", 2, "equal", ordenamiento, null);
        List<Noticias> noticiasCrude = noticiasFacade.findAll(ordenamiento);
        System.out.println("Noticias crude:"+noticiasCrude.size());
        for (int i = 0; i < noticiasCrude.size(); i++) {
            int tipo = Integer.parseInt(noticiasCrude.get(i).getTipoServicio().toString());
            if(tipo == 1){
                noticias.add(noticiasCrude.get(i));
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
    public boolean editarNoticia(Noticias noticia)
    {
        try
        {
            Noticias noticiaEditar = noticiasFacade.find(noticia.getId());
            
            noticiaEditar.setTitulo(noticia.getTitulo());
            noticiaEditar.setTipoServicio(noticia.getTipoServicio());
            noticiaEditar.setDetalle(noticia.getDetalle());
            noticiasFacade.edit(noticiaEditar);
            return true;
        }catch(Exception e)
        {
            return false;
        }
    }
    
    
    public List<Noticias> listadoNoticias()
    {
        try
        {
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("fecha", "desc");
            ordenamiento.put("id", "desc");
            List<Noticias> noticiasListado= noticiasFacade.findAll(ordenamiento);
            return noticiasListado;
        }catch(Exception e)
        {
            return null;
        }
        
        
    
    
    }
    
}
