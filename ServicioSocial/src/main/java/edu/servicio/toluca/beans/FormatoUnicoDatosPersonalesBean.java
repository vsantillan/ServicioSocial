/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Héctor
 */
public class FormatoUnicoDatosPersonalesBean {
    
    @Size(min=1, max=60,message = "Tamaño de Nombre debe ser Menor a 60 caracteres")
    @NotEmpty(message = "Campo Nombre es Requerido")
    @Pattern(regexp="[a-z]+")  
    private String nombre;
    
    @Size(min=1, max=30,message = "Tamaño de Nombre debe ser Menor a 60 caracteres")
    @NotEmpty(message = "Campo Apellido Paterno es Requerido")
    private String apellidoP;
    
    @Size(min=1, max=30,message = "Tamaño de Nombre debe ser Menor a 60 caracteres")
    @NotEmpty(message = "Campo Apellido Materno es Requerido")
    private String apellidoM;
    
    @Size(min=1, max=30,message = "Tamaño de Nombre debe ser Menor a 60 caracteres")
    @NotEmpty(message = "Campo Sexo es Requerido")
    private String sexo;
    
    @Size(min=1, max=15,message = "Tamaño de Nombre debe ser Menor a 60 caracteres")
    @NotEmpty(message = "Campo Estado Civil es Requerido")
    private String estado_civil;
    
    @Size(min=1, max=30,message = "Tamaño de Nombre debe ser Menor a 60 caracteres")
    @NotEmpty(message = "Campo Ocupacion es Requerido")
    private String ocupacion;
    
    @Size(min=1, max=30,message = "Tamaño de Nombre debe ser Menor a 60 caracteres")
    @NotEmpty(message = "Campo CURP es Requerido")
    private String curp;
    
    @Size(min=1, max=60,message = "Tamaño de Nombre debe ser Menor a 60 caracteres")
    @NotEmpty(message = "Campo Folio de Identificacion es Requerido")
    private String folioDocIdentificacion;
    
    @Size(min=1, max=60,message = "Tamaño de Nombre debe ser Menor a 60 caracteres")
    @NotEmpty(message = "Campo Clave de Identificacion es Requerido")
    private String claveDocIdentificacion;
    
    @AssertTrue(message = "Debes Aceptar el Acuerdo de Confidencialidad")
    private boolean acuerdoC;
    
    
    public FormatoUnicoDatosPersonalesBean()
    {
       
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidoP
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     * @param apellidoP the apellidoP to set
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     * @return the apellidoM
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * @param apellidoM the apellidoM to set
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the estado_civil
     */
    public String getEstado_civil() {
        return estado_civil;
    }

    /**
     * @param estado_civil the estado_civil to set
     */
    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    /**
     * @return the ocupacion
     */
    public String getOcupacion() {
        return ocupacion;
    }

    /**
     * @param ocupacion the ocupacion to set
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    /**
     * @return the curp
     */
    public String getCurp() {
        return curp;
    }

    /**
     * @param curp the curp to set
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * @return the folioDocIdentificacion
     */
    public String getFolioDocIdentificacion() {
        return folioDocIdentificacion;
    }

    /**
     * @param folioDocIdentificacion the folioDocIdentificacion to set
     */
    public void setFolioDocIdentificacion(String folioDocIdentificacion) {
        this.folioDocIdentificacion = folioDocIdentificacion;
    }

    /**
     * @return the claveDocIdentificacion
     */
    public String getClaveDocIdentificacion() {
        return claveDocIdentificacion;
    }

    /**
     * @param claveDocIdentificacion the claveDocIdentificacion to set
     */
    public void setClaveDocIdentificacion(String claveDocIdentificacion) {
        this.claveDocIdentificacion = claveDocIdentificacion;
    }    

    /**
     * @return the acuerdoC
     */
    public boolean isAcuerdoC() {
        return acuerdoC;
    }

    /**
     * @param acuerdoC the acuerdoC to set
     */
    public void setAcuerdoC(boolean acuerdoC) {
        this.acuerdoC = acuerdoC;
    }

}
