/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.sesion;

import edu.servicio.toluca.entidades.EstadosSia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SATELLITE
 */
@Stateless
public class EstadosSiaFacade extends AbstractFacade<EstadosSia> {
    @PersistenceContext(unitName = "servicioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadosSiaFacade() {
        super(EstadosSia.class);
    }
    
}
