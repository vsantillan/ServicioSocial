/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.organizaciones;

import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.sesion.InstanciaFacade;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author bustedvillain
 */
public class ConsultasOrganizaciones {
    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
    public InstanciaFacade instanciaFacade;
    
    public List<Instancia> getOrganizacionesPreRegistradas(){
        //Name Query Pendiente
        return instanciaFacade.findAll();
    }
}
