/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.sesion;

import edu.servicio.toluca.entidades.FormatoUnico;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author SATELLITE
 */
@Stateful
public class FormatoUnicoFacade extends AbstractFacade<FormatoUnico>
{

    @PersistenceContext(unitName = "servicioPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public FormatoUnicoFacade()
    {
        super(FormatoUnico.class);
    }

    @PreDestroy
    public void destruct()
    {
        em.close();
    }

}
