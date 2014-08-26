/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.sesion;

import edu.servicio.toluca.entidades.Documentos;
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
public class DocumentosFacade extends AbstractFacade<Documentos> {
    @PersistenceContext(unitName = "servicioPU", type= PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocumentosFacade() {
        super(Documentos.class);
    }

    @Override
    public Documentos find(Object id)
    {
        getEntityManager().flush();
        getEntityManager().clear();
        return super.find(id); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
