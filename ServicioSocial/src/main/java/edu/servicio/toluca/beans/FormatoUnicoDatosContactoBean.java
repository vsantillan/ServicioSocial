/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;


import edu.servicio.toluca.configuracion.CatalogoErrores;
import edu.servicio.toluca.configuracion.ExpresionesRegulares;
import edu.servicio.toluca.entidades.Colonia;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author SATELLITE
 */
public class FormatoUnicoDatosContactoBean implements ExpresionesRegulares, CatalogoErrores {
    private BigDecimal id;
    @Size(min = 1, max = 100, message = errorBetween+" 1 y 100 para el campo Calle")
    @Pattern(regexp = letrasNumerosCaractesEspeciales, message = errorNumerosLetrasCaracteresEspeciales+" en el campo Calle")
    private String calle;
    @Size(min = 1, max = 5, message = errorBetween+" 1 y 5 para el campo Numero Interior")
    @Pattern(regexp = numeros, message = errorNumeros+" en el campo Numero Interior")
    private String numeroI;
    @Size(min = 1, max = 5, message = errorBetween+" 1 y 5 para el campo Numero exterior")
    @Pattern(regexp = numeros, message = errorNumeros+" en el campo Numero Exterior")
    private String numeroE;
    @Size(min = 1, max = 100, message = errorBetween+" 1 y 100 para el campo Entre Calles")
    @Pattern(regexp = letrasNumerosCaractesEspeciales, message = errorNumerosLetrasCaracteresEspeciales+" en el campo Entre Calles")
    private String entreCalles;
    @Size(min = 1, max = 100, message = errorBetween+" 1 y 100 para el campo referencias")
    @Pattern(regexp =letrasNumerosCaractesEspeciales, message =errorNumerosLetrasCaracteresEspeciales+" en el campo Referencias")
    private String referencias;
    @Size(min = 10, max = 10, message = "El campo Telefono debe ser a 10 digitos ")
    @Pattern(regexp = numeros, message = errorNumeros+" en el campo Telefono de Casa")
    private String telefono_casa;
    @Size(min = 10, max = 10, message = "El campo Telefono Celular debe ser a 10 digitos")
    @Pattern(regexp = numeros, message = errorNumeros+ "en el campo Telefono Celular")
    private String telefono_cel;
    @Size(min = 10, max = 10, message = "El campo Telefono de Oficina debe ser a 10 digitos")
    @Pattern(regexp = numeros, message = errorNumeros+ "en el campo Telefono de Oficina")
    private String telefono_oficina;
    @Email(message = errorEmail)
    private String correo_electronico;
    @Size(min = 1, max = 100, message = errorBetween+" 1 y 100 para el campo Twitter")
    private String twitter;
    @Size(min = 1, max = 100, message = errorBetween+" 1 y 100 para el campo Facebook")
    private String facebook;
    private Colonia idColonia;
    private ArrayList<String> listaErrores = new ArrayList<String>();
    MetodosValidacion mv = new MetodosValidacion();
    
    public ArrayList<String> Valida()
    { 
        //Validar que no estén vacíos
//        if(id == null || id.equals("")){listaErrores.add("Error interno, nuestros ingenieros trabajan para resolverlo"); }
//        if(calle == null || calle.equals("")){listaErrores.add("El campo calle no puede estar vacío"); }
////        if(numeroE == null || numeroE.equals("")){listaErrores.add("El campo Numero Exterior no puede estar vacío"); }
//        if(entreCalles == null || entreCalles.equals("")){listaErrores.add("El campo Entre Calles no puede estar vacío"); }
//        if(referencias == null || referencias.equals("")){listaErrores.add("El campo Referencias no puede estar vacío"); }
        //Validar tamaños de texto
        if(!mv.minimoString(calle, 1) && !mv.maximoString(calle, 200)){listaErrores.add("El campo calle debe tener entre 1 y 200 letras");} 
        if(!mv.minimoString(numeroE, 1) && !mv.maximoString(numeroE, 5)){listaErrores.add("El campo numero exterior debe tener entre 1 y 5 digitos");} 
        if(!mv.minimoString(entreCalles, 1) && !mv.maximoString(entreCalles, 255)){listaErrores.add("El campo entre calles debe tener entre 1 y 255 letras");} 
        if(!mv.minimoString(referencias, 1) && !mv.maximoString(referencias, 70)){listaErrores.add("El campo referencias debe tener entre 1 y 70 letras");}
        
        if(!mv.maximoString(numeroI, 5)){listaErrores.add("El campo numero interior no puede ser mayor a 5 digitos");} 
        if(!mv.maximoString(telefono_casa, 50)){listaErrores.add("El campo Telefono de casa no puede ser mayor a 50 digitos");} 
        if(!mv.maximoString(telefono_cel, 30)){listaErrores.add("El campo Telefono celular no puede ser mayor a 30 digitos");} 
        if(!mv.maximoString(telefono_oficina, 30)){listaErrores.add("El campo Telefono oficina no puede ser mayor a 30 digitos");} 
        if(!mv.maximoString(correo_electronico, 30)){listaErrores.add("El campo Correo electronico no puede ser mayor a 30 digitos");} 
        if(!mv.maximoString(twitter, 25)){listaErrores.add("El campo Twitter no puede ser mayor a 25 letras");} 
        if(!mv.maximoString(facebook, 30)){listaErrores.add("El campo Facebook no puede ser mayor a 30 letras");} 
        
        return listaErrores;
    }
    
    public void arregla()
    {
        calle = mv.tuneaStringParaBD(calle);
        numeroI = mv.dejarSoloNumeros(numeroI);
        numeroE = mv.dejarSoloNumeros(numeroE);
        entreCalles = mv.tuneaStringParaBD(entreCalles);
        referencias = mv.tuneaStringParaBD(referencias);
        telefono_casa = mv.dejarSoloNumeros(telefono_casa);
        telefono_cel = mv.dejarSoloNumeros(telefono_cel);
        telefono_oficina = mv.dejarSoloNumeros(telefono_oficina);
    }

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

    /**
     * @return the correo_electronico
     */
    public String getCorreo_electronico() {
        return correo_electronico;
    }

    /**
     * @param correo_electronico the correo_electronico to set
     */
    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
    
    
    
    

    
}
