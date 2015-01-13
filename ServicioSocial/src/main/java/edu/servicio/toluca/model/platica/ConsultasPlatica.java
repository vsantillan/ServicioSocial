/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.platica;

import edu.servicio.toluca.beans.FechaAPalabras;
import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.beans.platica.FoliosPlaticaBean;
import edu.servicio.toluca.dao.GenericDao;
import edu.servicio.toluca.entidades.FoliosPlatica;
import edu.servicio.toluca.entidades.Platica;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bustedvillain
 */
public class ConsultasPlatica
{

    private GenericDao<FoliosPlatica> daoFoliosPlatica;
    private GenericDao<Platica> daoPlatica;

    @Autowired
    public void setDaoFoliosPlatica(GenericDao<FoliosPlatica> daoFoliosPlatica)
    {
        this.daoFoliosPlatica = daoFoliosPlatica;
        daoFoliosPlatica.setClass(FoliosPlatica.class);
    }

    @Autowired
    public void setDaoPlatica(GenericDao<Platica> daoVistaAlumno)
    {
        this.daoPlatica = daoPlatica;
        daoPlatica.setClass(Platica.class);
    }

    FechaAPalabras fecha = new FechaAPalabras();

    /**
     * Constructor que recibe la instancia de FoliosPlatica
     *
     * @param daoFoliosPlatica
     * @param foliosPlaticaFacade
     */
    public ConsultasPlatica(GenericDao<FoliosPlatica> daoFoliosPlatica)
    {
        this.daoFoliosPlatica = daoFoliosPlatica;
    }

    /**
     * COnstructor que recibe la instancia de Platica
     *
     * @param daoPlatica
     * @param platicaFacade
     */
//    public ConsultasPlatica(GenericDao<Platica> daoPlatica) {
//        this.daoPlatica = daoPlatica;
//    }
    public ConsultasPlatica(GenericDao<FoliosPlatica> daoFoliosPlatica, GenericDao<Platica> daoPlatica)
    {
        this.daoFoliosPlatica = daoFoliosPlatica;
        this.daoPlatica = daoPlatica;
    }

    public FoliosPlaticaBean checaAlumnoPlatica(StatusServicioBean servicioBean)
    {

        System.out.println("Checa platica");

        List<FoliosPlatica> platica = new ArrayList<FoliosPlatica>();

        try
        {
//            platica = new ArrayList<FoliosPlatica>(servicioBean.getVistaAlumno().getFoliosPlaticaCollection());
//            platica = foliosPlaticaFacade.findBySpecificField("alumnoId", servicioBean.getVistaAlumno(), "equal", null, null);
            System.out.println("alumnoId:" + servicioBean.getVistaAlumno());
            System.out.println("id:" + servicioBean.getVistaAlumno().getId());
            platica = daoFoliosPlatica.findBySpecificField("alumnoId", servicioBean.getVistaAlumno(), "equal", null, null);
        } catch (Exception e)
        {
            System.out.println("ERR. No tiene coleccion de platica");
            e.printStackTrace();
        }

        List<FoliosPlatica> filtroPlatica = new ArrayList();
        System.out.println("No. de registros en platica:" + platica.size());
        short uno = 1;

        for (int i = 0; i < platica.size(); i++)
        {
            System.out.println(platica.get(i).toString());
            System.out.println("Status platica:" + platica.get(i).getStatus());
            if (platica.get(i).getStatus() == uno)
            {
                filtroPlatica.add(platica.get(i));
            }
        }

        FoliosPlaticaBean beanPlatica = new FoliosPlaticaBean();
        Date d = new Date();
        //Checa si se registro a alguna platica
        if (!filtroPlatica.isEmpty())
        {
            //Checa si asistio a la platica en la cual se registro
            if (filtroPlatica.get(0).getAsistencia() != null)
            {
                if (filtroPlatica.get(0).getAsistencia().toString().equals("1"))
                {
                    beanPlatica.setTienePlatica(true);
                    beanPlatica.setAccesoPanelPlatica(false);
                    beanPlatica.setMensajeUsuario("Número de Folio: " + platica.get(0).getNumeroFolio() + ". Asististe a la platica del " + fecha.fechaAPalabras(platica.get(0).getPlaticaId().getFecha()) + ", la fecha máxima para que subas tu formato único es hasta el " + fecha.fechaAPalabras(platica.get(0).getPlaticaId().getFechaMxFui()) + ", de lo contrario serás acreedor a una sanción.");

                    System.out.println("Asistio a la platica");
                } else
                {
                    beanPlatica.setTienePlatica(false);
                    beanPlatica.setAccesoPanelPlatica(false);
                    beanPlatica.setMensajeUsuario("Número de Folio: " + platica.get(0).getNumeroFolio() + ". Te registraste a la platica, pero no asististe a ella. Favor de pasar a la oficina de servicio social para solicitar un alta posterior.");
                    System.out.println("No asistio a la platica");
                }
            } else
            {
                if (filtroPlatica.get(0).getPlaticaId().getFecha().compareTo(d) > 0)
                {
                    beanPlatica.setTienePlatica(false);
                    beanPlatica.setAccesoPanelPlatica(false);
                    beanPlatica.setMensajeUsuario("Número de Folio: " + platica.get(0).getNumeroFolio() + ". Te has registrado a la platica del " + fecha.fechaAPalabras(platica.get(0).getPlaticaId().getFecha()) + ", la fecha máxima para que subas tu formato único es hasta el " + fecha.fechaAPalabras(platica.get(0).getPlaticaId().getFechaMxFui()) + ", de lo contrario serás acreedor a una sanción.");
                    System.out.println("aun no es la platica");
                } else
                {
                    beanPlatica.setTienePlatica(false);
                    beanPlatica.setAccesoPanelPlatica(false);
                    beanPlatica.setMensajeUsuario("Número de Folio: " + platica.get(0).getNumeroFolio() + ". Te registraste a la platica del " + fecha.fechaAPalabras(platica.get(0).getPlaticaId().getFecha()) + ", pero no asististe a ella. Favor de pasar a la oficina de servicio social para solicitar un alta posterior.");
                    System.out.println("No asistio a la platica");
                }
            }

        } else
        {
            beanPlatica.setTienePlatica(false);
            beanPlatica.setAccesoPanelPlatica(true);
            beanPlatica.setMensajeUsuario("No te has registrado a ninguna plática");
            System.out.println("No se registro a ninguna platica");
        }

        servicioBean.setPlaticaBean(beanPlatica);
        return beanPlatica;
    }
}
