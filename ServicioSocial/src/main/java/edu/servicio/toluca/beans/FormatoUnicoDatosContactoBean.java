/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import edu.servicio.toluca.entidades.Colonia;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author SATELLITE
 */
public class FormatoUnicoDatosContactoBean {
    private BigDecimal id;
    @NotNull
    private String calle;
    private String numeroI;
    private String numeroE;
  //  private Colonia colonia;
    private String entreCalles;
    private String referencias;
    private String telefono_casa;
    private String telefono_cel;
    private String telefono_oficina;
    private String twitter;
    private String facebook;
    private Colonia idColonia;

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the numeroI
     */
    public String getNumeroI() {
        return numeroI;
    }

    /**
     * @param numeroI the numeroI to set
     */
    public void setNumeroI(String numeroI) {
        this.numeroI = numeroI;
    }

    /**
     * @return the numeroE
     */
    public String getNumeroE() {
        return numeroE;
    }

    /**
     * @param numeroE the numeroE to set
     */
    public void setNumeroE(String numeroE) {
        this.numeroE = numeroE;
    }



    /**
     * @return the entreCalles
     */
    public String getEntreCalles() {
        return entreCalles;
    }

    /**
     * @param entreCalles the entreCalles to set
     */
    public void setEntreCalles(String entreCalles) {
        this.entreCalles = entreCalles;
    }

    /**
     * @return the referencias
     */
    public String getReferencias() {
        return referencias;
    }

    /**
     * @param referencias the referencias to set
     */
    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    /**
     * @return the telefono_casa
     */
    public String getTelefono_casa() {
        return telefono_casa;
    }

    /**
     * @param telefono_casa the telefono_casa to set
     */
    public void setTelefono_casa(String telefono_casa) {
        this.telefono_casa = telefono_casa;
    }

    /**
     * @return the telefono_cel
     */
    public String getTelefono_cel() {
        return telefono_cel;
    }

    /**
     * @param telefono_cel the telefono_cel to set
     */
    public void setTelefono_cel(String telefono_cel) {
        this.telefono_cel = telefono_cel;
    }

    /**
     * @return the telefono_oficina
     */
    public String getTelefono_oficina() {
        return telefono_oficina;
    }

    /**
     * @param telefono_oficina the telefono_oficina to set
     */
    public void setTelefono_oficina(String telefono_oficina) {
        this.telefono_oficina = telefono_oficina;
    }

    /**
     * @return the twitter
     */
    public String getTwitter() {
        return twitter;
    }

    /**
     * @param twitter the twitter to set
     */
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    /**
     * @return the facebook
     */
    public String getFacebook() {
        return facebook;
    }

    /**
     * @param facebook the facebook to set
     */
    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }



    /**
     * @return the id
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * @return the idColonia
     */
    public Colonia getIdColonia() {
        return idColonia;
    }

    /**
     * @param idColonia the idColonia to set
     */
    public void setIdColonia(Colonia idColonia) {
        this.idColonia = idColonia;
    }
    
    
    
    

    
}
