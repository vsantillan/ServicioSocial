/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import edu.servicio.toluca.configuracion.CatalogoErrores;
import static edu.servicio.toluca.configuracion.CatalogoErrores.errorBetween;
import static edu.servicio.toluca.configuracion.CatalogoErrores.errorLetrasNumeros;
import static edu.servicio.toluca.configuracion.CatalogoErrores.errorletras;
import edu.servicio.toluca.configuracion.ExpresionesRegulares;
import static edu.servicio.toluca.configuracion.ExpresionesRegulares.letrasNumerosPrimeroDespuesEspacios;
import static edu.servicio.toluca.configuracion.ExpresionesRegulares.letrasPrimeroDespuesEspacios;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;


/**
 *
 * @author Héctor
 */
public class FormatoUnicoDatosPersonalesBean implements ExpresionesRegulares, CatalogoErrores
{
    private BigDecimal id;
    @Size(min = 3, max = 45, message = errorBetween+" 3 y 45 para el campo Nombre")
    @Pattern(regexp = letrasPrimeroDespuesEspacios, message = errorletras+" en el campo Nombre")
    private String nombre;
    @Pattern(regexp = letrasPrimeroDespuesEspacios, message = errorletras+" en el campo Apellido Paterno")
    @Size(min = 3, max = 20, message = errorBetween+" 3 y 20 para el campo Apellido Paterno")
    private String apellidoP;
    @Pattern(regexp = letrasPrimeroDespuesEspacios, message = errorletras+" en el campo Apellido Materno")
    @Size(min = 3, max = 20, message = errorBetween+" 3 y 20 para el campo Apellido Materno")
    private String apellidoM;
    private String sexo;
    private String estado_civil;
    @Pattern(regexp = letrasPrimeroDespuesEspacios, message = errorletras+" en el campo Ocupacion")
    @Size(min = 1, max = 20, message = errorBetween+" 1 y 20 para el campo Ocupacion")
    private String ocupacion;
    @Size(min = 16, max = 18, message = errorBetween+" 16 y 18 para el campo CURP")
    @Pattern(regexp = letrasNumerosPrimeroDespuesEspacios, message = errorLetrasNumeros+" en el campo CURP")
    private String curp;
    @Size(min = 1, max = 40, message = errorBetween+" 1 y 40 para el campo Clave de Indentificacion")
    @Pattern(regexp = letrasNumerosPrimeroDespuesEspacios, message = errorLetrasNumeros+" en el campo Clave de Indentificacion")
    private String claveDocIdentificacion;
    @Size(min = 1, max = 40, message = errorBetween+" 1 y 40 para el campo Folio Documento Identificacion")
    @Pattern(regexp = numeros, message = errorNumeros+" en el campo Folio Documento Identificacion")
    private String folioDocIdentificacion;
    private boolean acuerdoC;
    @Size(min = 1, max = 100, message = errorBetween+" 1 y 100 para el campo Lugar de Nacimiento")
    @Pattern(regexp = letrasPrimeroDespuesEspacios, message = errorletras+" en el campo Lugar de Nacimiento")
    private String lugar_nacimiento;
    private ArrayList<String> listaErrores = new ArrayList<String>();
    MetodosValidacion mv = new MetodosValidacion();
    
    public FormatoUnicoDatosPersonalesBean()
    {
       
    }
    
    public ArrayList<String> Valida()
    { 
        //Validar que no estén vacíos
//        if(id == null || id.equals("")){listaErrores.add("Error interno, nuestros ingenieros trabajan para resolverlo"); }
//        if(nombre == null || nombre.equals("")){listaErrores.add("El campo nombre no puede estar vacío"); }
//        if(apellidoP == null || apellidoP.equals("")){listaErrores.add("El campo Apellido Paterno no puede estar vacío"); }
//        if(apellidoM == null || apellidoM.equals("")){listaErrores.add("El campo Apellido Materno no puede estar vacío"); }
//        if(ocupacion == null || ocupacion.equals("")){listaErrores.add("El campo ocupacion no puede estar vacío"); }
//        if(curp == null || curp.equals("")){listaErrores.add("El campo curp no puede estar vacío"); }
//        if(claveDocIdentificacion.equals("")){listaErrores.add("El campo Clave del Documento de indentificación no puede estar vacío"); }
//        if(folioDocIdentificacion == null || folioDocIdentificacion.equals("0")){listaErrores.add("El campo folio del Documento de indentificación no puede estar vacío"); }
//        if(lugar_nacimiento == null || lugar_nacimiento.equals("0")){listaErrores.add("El campo lugar de Nacimiento no puede estar vacío"); }
        //Validar tamaños de texto
        if(!mv.minimoString(nombre, 1) && !mv.maximoString(nombre, 60)){listaErrores.add("El campo nombre debe tener entre 1 y 60 letras");}
        if(!mv.minimoString(apellidoP, 1) && !mv.maximoString(apellidoP, 30)){listaErrores.add("El campo apellido paterno debe tener entre 1 y 30 letras");}
        if(!mv.minimoString(apellidoM, 1) && !mv.maximoString(apellidoM, 30)){listaErrores.add("El campo apellido materno debe tener entre 1 y 30 letras");}
        if(!mv.minimoString(ocupacion, 1) && !mv.maximoString(ocupacion, 30)){listaErrores.add("El campo ocupacion debe tener entre 1 y 30 letras");}
        if(!mv.minimoString(curp, 18) && !mv.maximoString(curp, 18)){listaErrores.add("El campo CURP debe contener 18 caracteres");}
        if(!mv.minimoString(claveDocIdentificacion, 1) && !mv.maximoString(claveDocIdentificacion, 30)){listaErrores.add("El campo Clave del Documento de identificacion debe tener entre 1 y 30 letras");}
        if(!mv.minimoString(folioDocIdentificacion, 1) && !mv.maximoString(folioDocIdentificacion, 6)){listaErrores.add("El campo Folio del Documento de identificacion debe tener entre 1 y 6 digitos");}
        if(!mv.minimoString(lugar_nacimiento, 1) && !mv.maximoString(lugar_nacimiento, 150)){listaErrores.add("El campo Folio del Documento de identificacion debe tener entre 1 y 6 digitos");}
        
        
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
        this.lugar_nacimiento = mv.tuneaStringParaBD(lugar_nacimiento);
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

    /**
     * @return the lugar_nacimiento
     */
    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    /**
     * @param lugar_nacimiento the lugar_nacimiento to set
     */
    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

}
