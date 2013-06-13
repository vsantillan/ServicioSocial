/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.sesion;

import edu.servicio.toluca.entidades.Preguntas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bustedvillain
 */
@Stateless
public class PreguntasFacade extends AbstractFacade<Preguntas> {
    @PersistenceContext(unitName = "servicioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreguntasFacade() {
        super(Preguntas.class);
    }
    
}
