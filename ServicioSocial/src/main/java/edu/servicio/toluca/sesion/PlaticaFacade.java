/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.sesion;

import edu.servicio.toluca.beans.Fecha;
import edu.servicio.toluca.entidades.Platica;
import java.util.ArrayList;
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
public class PlaticaFacade extends AbstractFacade<Platica> {
    @PersistenceContext(unitName = "servicioPU", type= PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlaticaFacade() {
        super(Platica.class);
    }
    
     public List<Platica> platicasPeriodo() {
         getEntityManager().flush();
        getEntityManager().clear();
        Fecha fecha = new Fecha();
        String periodo = fecha.CalculaPeriodoPrueba();
        System.out.println("periodo platica actual_" + periodo);

        String sql = "select * from platica where status=1 and periodo='" + periodo + "'" + "  and fecha >=(select sysdate -1 from dual)";
        Query query = (Query) em.createNativeQuery(sql, Platica.class);
        List<Platica> lista = query.getResultList();
        List<Platica> listaPlatica = new ArrayList<Platica>();

//    System.out.println("-------------------------"+lista.size()); 
        for (int i = 0; i < lista.size(); i++) {
            listaPlatica.add(lista.get(i));
        }
        return listaPlatica;

    }
}
