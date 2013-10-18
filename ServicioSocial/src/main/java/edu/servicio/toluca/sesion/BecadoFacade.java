/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.sesion;

import edu.servicio.toluca.beans.Fecha;
import edu.servicio.toluca.entidades.Becado;
import edu.servicio.toluca.entidades.FormatoUnico;
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
public class BecadoFacade extends AbstractFacade<Becado> {
    @PersistenceContext(unitName = "servicioPU", type= PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BecadoFacade() {
        super(Becado.class);
    }
    
}
