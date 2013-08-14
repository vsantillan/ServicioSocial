/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Héctor
 */
public class FormatoUnicoDatosPersonalesBean {
    
    private BigDecimal id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String sexo;
    private String estado_civil;
    private String ocupacion;
    private String curp;
    private String claveDocIdentificacion;
    private String folioDocIdentificacion;
    private boolean acuerdoC;
    private ArrayList<String> listaErrores = new ArrayList<String>();
    MetodosValidacion mv = new MetodosValidacion();
    
    public FormatoUnicoDatosPersonalesBean()
    {
       
    }
    
    public ArrayList<String> Valida()
    {
        
        boolean r = true;
        
        //Validar que no estén vacíos
        if(id == null || id.equals("")){listaErrores.add("Error interno, nuestros ingenieros trabajan para resolverlo"); r = false;}
        if(nombre == null || nombre.equals("")){listaErrores.add("El campo nombre no puede estar vacío"); r = false;}
        if(apellidoP == null || apellidoP.equals("")){listaErrores.add("El campo Apellido Paterno no puede estar vacío"); r = false;}
        if(apellidoM == null || apellidoM.equals("")){listaErrores.add("El campo Apellido Materno no puede estar vacío"); r = false;}
        if(ocupacion == null || ocupacion.equals("")){listaErrores.add("El campo ocupacion no puede estar vacío"); r = false;}
        if(curp == null || curp.equals("")){listaErrores.add("El campo curp no puede estar vacío"); r = false;}
        if(claveDocIdentificacion.equals("")){listaErrores.add("El campo Clave del Documento de indentificación no puede estar vacío"); r = false;}
        if(folioDocIdentificacion == null || folioDocIdentificacion.equals("0")){listaErrores.add("El campo folio del Documento de indentificación no puede estar vacío"); r = false;}
        //Validar tamaños de texto
        if(!mv.minimoString(nombre, 1) && !mv.maximoString(nombre, 28)){listaErrores.add("El campo nombre debe tener entre 1 y 28 letras");}
        
        
        return listaErrores;
    }
    public void arregla()
    {
        this.nombre = mv.tuneaStringParaBD(nombre);
        this.apellidoP = mv.tuneaStringParaBD(apellidoP);
        this.apellidoM = mv.tuneaStringParaBD(apellidoM);
        this.sexo = mv.pasaMayusculas(sexo);
        this.sexo = mv.quitaAcentos(sexo);
        this.estado_civil = mv.pasaMayusculas(estado_civil);
        this.estado_civil = mv.quitaAcentos(estado_civil);
        this.ocupacion = mv.tuneaStringParaBD(ocupacion);
        this.curp = mv.tuneaStringParaBD(curp);
        this.claveDocIdentificacion = mv.tuneaStringParaBD(claveDocIdentificacion);
        this.folioDocIdentificacion = mv.dejarSoloNumeros(folioDocIdentificacion);
        setFolioDocIdentificacion(mv.dejarSoloNumeros(folioDocIdentificacion));
        
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

}
