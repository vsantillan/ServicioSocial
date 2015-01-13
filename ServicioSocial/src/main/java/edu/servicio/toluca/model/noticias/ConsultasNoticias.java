/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.noticias;

import edu.servicio.toluca.beans.FechaAPalabras;
import edu.servicio.toluca.dao.GenericDao;
import edu.servicio.toluca.entidades.Noticias;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bustedvillain
 */
public class ConsultasNoticias {

    private GenericDao<Noticias> daoNoticias;
    
    @Autowired
    public void setDaoNoticias(GenericDao<Noticias> daoNoticias)
    {
        this.daoNoticias = daoNoticias;
        daoNoticias.setClass(Noticias.class);
    }

    public ConsultasNoticias(GenericDao<Noticias> daoNoticias) {
        this.daoNoticias = daoNoticias;
    }

    /**
     * Hace una consulta de noticias generales
     *
     * @param orden (desc: Orden Descendiente, asc: Orden ascendiente)
     * @return
     */
    public List<Noticias> consultaNoticiasGenerales(String orden) {
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
        List<Noticias> noticiasCrude = daoNoticias.findAll(ordenamiento);
        System.out.println("Noticias crude:" + noticiasCrude.size());

        for (int i = 0; i < noticiasCrude.size(); i++) {
            int tipo = Integer.parseInt(noticiasCrude.get(i).getTipoServicio().toString());

            if (tipo == 2 || tipo == 4) {
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
        List<Noticias> noticiasCrude = daoNoticias.findAll(ordenamiento);
        System.out.println("Noticias crude:" + noticiasCrude.size());
        String detalle = "";
        for (int i = 0; i < noticiasCrude.size(); i++) {
            int tipo = Integer.parseInt(noticiasCrude.get(i).getTipoServicio().toString());

            if (tipo == 1) {
                noticias.add(noticiasCrude.get(i));
            }
        }
        return noticias;
    }

    public Noticias consultaNoticiaPrincipal(int id) {

        try {
            BigDecimal idNoticia = null;
            idNoticia = BigDecimal.valueOf(id);
            Noticias noticiaa = (Noticias) daoNoticias.find(idNoticia);

            //Uno para Noticias Generales
            if (noticiaa.getTipoServicio().compareTo(new BigInteger("1")) == 0) {
                return noticiaa;
            }

            return null;

        } catch (Exception e) {
            return null;
        }

    }

    public boolean nuevaNoticia(Noticias noticia) {
        try {
            daoNoticias.create(noticia);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public Noticias obtenerNoticia(int id) {
        try {
            BigDecimal idNoticia = null;
            idNoticia = BigDecimal.valueOf(id);
            Noticias noticia = (Noticias) daoNoticias.find(idNoticia);
            return noticia;
        } catch (Exception e) {
            return null;
        }

    }

    public void eliminarNoticia(Noticias noticia) {
        daoNoticias.remove(noticia);
    }

    public boolean editarNoticia(Noticias noticia) {
        try {
            Noticias noticiaEditar = (Noticias) daoNoticias.find(noticia.getId());

            noticiaEditar.setTitulo(noticia.getTitulo());
            noticiaEditar.setTipoServicio(noticia.getTipoServicio());
            noticiaEditar.setDetalle(noticia.getDetalle());
            daoNoticias.edit(noticiaEditar);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Noticias> listadoNoticias() {
        try {
            LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
            ordenamiento.put("fecha", "desc");
            ordenamiento.put("id", "desc");
            List<Noticias> noticiasListado = daoNoticias.findAll(ordenamiento);
            return noticiasListado;
        } catch (Exception e) {
            return null;
        }

    }
}
