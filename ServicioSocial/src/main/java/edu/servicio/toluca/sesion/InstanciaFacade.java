/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.sesion;

import edu.servicio.toluca.entidades.Instancia;
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
public class InstanciaFacade extends AbstractFacade<Instancia> {

    @PersistenceContext(unitName = "servicioPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstanciaFacade() {
        super(Instancia.class);
    }

    public String instanciasTotales() {
        String arrJSON = "";

        String sql = "SELECT I.NOMBRE, \n"
                + "(SELECT COUNT(*) AS total \n"
                + "FROM FORMATO_UNICO FU,PROYECTOS PR\n"
                + "WHERE FU.IDPROYECTO=PR.ID_PROYECTO  AND PR.ID_INSTANCIA=I.ID_INSTANCIA) \n"
                + "AS TOTAL\n"
                + "FROM INSTANCIA I";
        Query query = (Query) em.createNativeQuery(sql);
        List<Object[]> registros = query.getResultList();

        for (int i = 0; i < registros.size(); i++) {
            arrJSON = arrJSON + "" + registros.get(i)[0] + "|" + registros.get(i)[1] +"&";
        }
        return arrJSON;
    }
}
