/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;
import edu.servicio.toluca.entidades.FoliosPlatica;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mary
 */
public class ValidacionAsistenciaPlatica  {
    
    @NotNull
     @Size(min = 1, max = 13)
    private long numeroFolio;

    /**
     * @return the numeroFolio
     */
    public long getNumeroFolio() {
        return numeroFolio;
    }

    /**
     * @param numeroFolio the numeroFolio to set
     */
    public void setNumeroFolio(long numeroFolio) {
        this.numeroFolio = numeroFolio;
    }



}
