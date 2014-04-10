/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.sesion;

import edu.servicio.toluca.beans.organizaciones.MunicipiosJSON;
import edu.servicio.toluca.entidades.Programa;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author SATELLITE
 */
@Stateful
public class ProgramaFacade extends AbstractFacade<Programa> {

    @PersistenceContext(unitName = "servicioPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramaFacade() {
        super(Programa.class);
    }

    public String programasTotales(String anio, String periodo) {
        String arrJSON = "";
        String sql = "SELECT DISTINCT(P.DESCRIPCION), COUNT(P.ID_PROGRAMA) as total \n"
                + "               FROM PROGRAMA P, FORMATO_UNICO FU,PROYECTOS PR\n"
                + "                WHERE FU.IDPROYECTO=PR.ID_PROYECTO and PR.ID_PROGRAMA=P.ID_PROGRAMA \n"
                + "		      and to_char(FU.FECHA_INICIO,'yyyy')=" + anio + " and FU.PERIODO_INICIO='" + periodo + "'\n"
                + "                GROUP BY DESCRIPCION";
        Query query = (Query) em.createNativeQuery(sql);
        List<Object[]> registros = query.getResultList();

        for (int i = 0; i < registros.size(); i++) {
            arrJSON = arrJSON + "" + registros.get(i)[0] + "|" + registros.get(i)[1] + "&";
        }
        return arrJSON;
    }

    public String programasTotalesLiberaciones(String ano, String periodo) {
        String arrJSON = "";
        System.out.println("Año: "+ano+" Periodo: "+periodo);
        String sql = "SELECT DISTINCT(P.DESCRIPCION), COUNT(P.ID_PROGRAMA) as total\n"
                + "                     FROM PROGRAMA P, FORMATO_UNICO FU,PROYECTOS PR\n"
                + "                     WHERE FU.IDPROYECTO=PR.ID_PROYECTO and PR.ID_PROGRAMA=P.ID_PROGRAMA and FU.STATUS_SERVICIO=4\n"
                + "                     and to_char(FU.FECHA_INICIO,'yyyy')=" + ano + " and FU.PERIODO_INICIO='" + periodo + "'\n"
                + "                     GROUP BY DESCRIPCION";
        System.out.println(sql);
        Query query = (Query) em.createNativeQuery(sql);
        List<Object[]> registros = query.getResultList();

        for (int i = 0; i < registros.size(); i++) {
            arrJSON = arrJSON + "" + registros.get(i)[0] + "|" + registros.get(i)[1] + "&";
        }
        return arrJSON;
    }

    public String programasTotalesTabla(String ano,String periodo) {
        String arrJSON = "";

        String sql = "SELECT P.DESCRIPCION, \n"
                + "                (SELECT COUNT(*) AS total \n"
                + "                FROM FORMATO_UNICO FU,PROYECTOS PR\n"
                + "                WHERE FU.IDPROYECTO=PR.ID_PROYECTO and FU.STATUS_SERVICIO=4 AND PR.ID_PROGRAMA=P.ID_PROGRAMA\n"
                + "                and to_char(FU.FECHA_INICIO,'yyyy')="+ano+" and FU.PERIODO_INICIO='"+periodo+"') as Altas, \n"
                + "                (SELECT COUNT(*) AS total \n"
                + "                FROM FORMATO_UNICO FU,PROYECTOS PR\n"
                + "                WHERE FU.IDPROYECTO=PR.ID_PROYECTO AND PR.ID_PROGRAMA=P.ID_PROGRAMA\n"
                + "                and to_char(FU.FECHA_INICIO,'yyyy')="+ano+" and FU.PERIODO_INICIO='"+periodo+"')\n"
                + "                AS Liberaciones\n"
                + "                FROM PROGRAMA P";
        Query query = (Query) em.createNativeQuery(sql);
        List<Object[]> registros = query.getResultList();

        for (int i = 0; i < registros.size(); i++) {
            arrJSON = arrJSON + "" + registros.get(i)[0] + "|" + registros.get(i)[1] + "%" + registros.get(i)[2] + "&";
        }
        return arrJSON;
    }
}
