/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.sesion;

import edu.servicio.toluca.entidades.RegObservacionGeneral;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author ekt
 */
@Stateful
public class RegObservacionGeneralFacade extends AbstractFacade<RegObservacionGeneral> {
    @PersistenceContext(unitName = "servicioPU",type= PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegObservacionGeneralFacade() {
        super(RegObservacionGeneral.class);
    }
    
}
