/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model;

import edu.servicio.toluca.beans.organizaciones.RespuestaInsertActividades;
import edu.servicio.toluca.entidades.Actividades;
import edu.servicio.toluca.entidades.Perfil;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.sesion.ActividadesFacade;
import edu.servicio.toluca.sesion.ProyectosFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.ejb.EJB;

/**
 *
 * @author bustedvillain
 */
public class ActividadesModel {
    
    @EJB(mappedName = "java:global/ServicioSocial/ProyectosFacade")
    private ProyectosFacade proyectosFacade;
    @EJB(mappedName = "java:global/ServicioSocial/ActividadesFacade")
    private ActividadesFacade actividadesFacade;
    
    Proyectos proyecto;
    public ArrayList<String> actividades = new ArrayList<String>();

    public ActividadesModel(String cadenaActividades) {        

        //Analisis de la cadena
        StringTokenizer token = new StringTokenizer(cadenaActividades, ";");

        System.out.println("Analizar cadena:" + cadenaActividades);
        System.out.println("No de tokens:" + token.countTokens());
        while (token.hasMoreTokens()) {
            String actividad = token.nextToken();
            System.out.println("Token:" + actividad);
            actividades.add(actividad);
        }
    }

    public RespuestaInsertActividades validarInsercionActividades() {
        RespuestaInsertActividades respuesta = new RespuestaInsertActividades();
        if (actividades.size() > 0) {
            if (validarUnicaActividad()) {
                if (validarConsistenciaCadenas()) {
                    respuesta.setSuccess(true);
                    respuesta.setMensaje("");
                } else {
                    respuesta.setSuccess(false);
                    respuesta.setMensaje("<div class='alert alert-danger'>Hay actividades vacías</div>");
                }
            } else {
                respuesta.setSuccess(false);
                respuesta.setMensaje("<div class='alert alert-danger'>Hay actividades repetidas</div>");
            }

        } else {
            respuesta.setSuccess(false);
            respuesta.setMensaje("<div class='alert alert-danger'>Actividades vacías</div>");
        }

        return respuesta;
    }

    //Validar que ningun perfil se repita
    public boolean validarUnicaActividad() {
        for (int i = 0; i < actividades.size(); i++) {
            String actividad = actividades.get(i);
            for (int j = 0; j < actividades.size(); j++) {
                //Que no se compare con si mismo 
                if (i != j) {
                    if (actividad.equals(actividades.get(j))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean validarConsistenciaCadenas() {
        for (int i = 0; i < actividades.size(); i++) {
            if (actividades.get(i) == null || actividades.get(i).equals("")) {
                return false;
            }
        }
        return true;
    }

    public void insertarActividades(BigDecimal idProyecto) {
        try {
            proyecto = proyectosFacade.find(idProyecto);
        } catch (Exception e) {
            System.out.println("Error al buscar el proyecto");
        }
        
        for (int i = 0; i < actividades.size(); i++) {
            Actividades actividad = new Actividades();
            actividad.setDetalle(actividades.get(i));
            actividad.setEstatus(BigInteger.ONE);
            actividad.setIdProyecto(proyecto);
            actividadesFacade.create(actividad);
        }
    }
}
