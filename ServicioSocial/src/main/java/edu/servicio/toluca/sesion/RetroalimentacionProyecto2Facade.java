/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.sesion;

import edu.servicio.toluca.entidades.RetroalimentacionProyecto2;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SATELLITE
 */
@Stateless
public class RetroalimentacionProyecto2Facade extends AbstractFacade<RetroalimentacionProyecto2> {
    @PersistenceContext(unitName = "servicioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RetroalimentacionProyecto2Facade() {
        super(RetroalimentacionProyecto2.class);
    }
    
}
