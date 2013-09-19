/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.organizaciones;

import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.sesion.InstanciaFacade;
import java.util.List;

/**
 *
 * @author bustedvillain
 */
public class prueba {
    
    public void prueba(InstanciaFacade instanciaFacade){
        
        List<Instancia> instancias = instanciaFacade.findAll();
        
        System.out.println("Instancias");
        for (int i = 0; i < instancias.size(); i++) {
            System.out.println(instancias.get(i).getNombre());
        }
        
    }
    
}
