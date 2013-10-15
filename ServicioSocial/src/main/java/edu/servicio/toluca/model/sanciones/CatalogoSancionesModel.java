/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.sanciones;

import edu.servicio.toluca.beans.MetodosValidacion;
import edu.servicio.toluca.entidades.CatalogoSanciones;
import edu.servicio.toluca.entidades.DatosPersonales;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author SATELLITE
 */
public class CatalogoSancionesModel {

    private BigDecimal id;
    private String detalle;
    private BigInteger horasSancion;
    private BigInteger tolerancia;
    
    public void arregla()
    {
        MetodosValidacion mv = new MetodosValidacion();
        detalle =  mv.tuneaStringParaBD(detalle);
        horasSancion = new BigInteger(mv.dejarSoloNumeros(horasSancion.toString()));
        tolerancia = new BigInteger(mv.dejarSoloNumeros(tolerancia.toString()));
    }
    public ArrayList valida()
    {
        ArrayList<String> listaErrores = new ArrayList<String>();
        MetodosValidacion mv = new MetodosValidacion();
        
        if(!mv.minimoString(detalle, 1)){listaErrores.add("El campo detalle no puede estar vacío.");}
//        if(!mv.minimoString(horasSancion.toString(),1)){listaErrores.add("El campo Horas sanción no puede estar vacío.");}
//        if(!mv.minimoString(tolerancia.toString(), 1)){listaErrores.add("El campo tolerancia no puede estar vacío.");}
        if(!mv.maximoString(detalle, 300)){listaErrores.add("El campo detalle no puede exceder los 300 caracteres.");}
//        if(!mv.maximoString(horasSancion.toString(),5)){listaErrores.add("El campo Horas sanción no puede no puede exceder los 5 caracteres.");}
//        if(!mv.maximoString(tolerancia.toString(), 4)){listaErrores.add("El campo tolerancia no puede exceder los 4 caracteres.");}
        if(horasSancion.compareTo(BigInteger.ZERO)>0){listaErrores.add("Las horas de sancion no pueden ser 0.");}
        if(tolerancia.compareTo(BigInteger.ZERO)>0){listaErrores.add("La tolerancia no puede ser 0.");}
        return listaErrores;
    }

    public CatalogoSancionesModel(String detalle, BigInteger horasSancion, BigInteger tolerancia) {
        this.detalle = detalle;
        this.horasSancion = horasSancion;
        this.tolerancia = tolerancia;
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
     * @return the detalle
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    /**
     * @return the horasSancion
     */
    public BigInteger getHorasSancion() {
        return horasSancion;
    }

    /**
     * @param horasSancion the horasSancion to set
     */
    public void setHorasSancion(BigInteger horasSancion) {
        this.horasSancion = horasSancion;
    }

    /**
     * @return the tolerancia
     */
    public BigInteger getTolerancia() {
        return tolerancia;
    }

    /**
     * @param tolerancia the tolerancia to set
     */
    public void setTolerancia(BigInteger tolerancia) {
        this.tolerancia = tolerancia;
    }
   
    
    
}
