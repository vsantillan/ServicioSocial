/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans.organizaciones;

import edu.servicio.toluca.sesion.InstanciaFacade;
import javax.ejb.EJB;

/**
 *
 * @author bustedvillain
 */
public class AltaOrganizacion {
    
    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
    InstanciaFacade instanciaFacade = new InstanciaFacade();
    
}
