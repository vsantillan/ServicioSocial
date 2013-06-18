/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

/**
 *
 * @author Héctor
 */
public class FormatoUnicoErrores {
    private String nombre;
    private String[] apellido=new String[2];

    
    
    public FormatoUnicoErrores()
    {
        this.nombre = "Hec";
        this.apellido[0]="a";
        this.apellido[1]="b";
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
     * @return the apellido
     */
    public String[] getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String[] apellido) {
        this.apellido = apellido;
    }
}
