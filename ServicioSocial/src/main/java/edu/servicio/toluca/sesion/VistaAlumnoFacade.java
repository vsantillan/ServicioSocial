/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.sesion;

import edu.servicio.toluca.entidades.VistaAlumno;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**0
 *
 * @author SATELLITE
 */
@Stateful
public class VistaAlumnoFacade extends AbstractFacade<VistaAlumno> {
    @PersistenceContext(unitName = "servicioPU", type= PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VistaAlumnoFacade() {
        super(VistaAlumno.class);
    }
    
}
