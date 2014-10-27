/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.servicio.toluca.sesion;

import edu.servicio.toluca.entidades.UsuarioInstancia;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author giovanni
 */
@Stateful
public class UsuarioInstanciaFacade extends AbstractFacade<UsuarioInstancia>
{
    
    @PersistenceContext(unitName = "servicioPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }
    
    public UsuarioInstanciaFacade()
    {
        super(UsuarioInstancia.class);
    }
    
}
