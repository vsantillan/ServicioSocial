/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model;

import edu.servicio.toluca.entidades.Perfil;
import edu.servicio.toluca.entidades.ProyectoPerfil;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.sesion.PerfilFacade;
import edu.servicio.toluca.sesion.ProyectoPerfilFacade;
import edu.servicio.toluca.sesion.ProyectosFacade;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.ejb.EJB;

/**
 *
 * @author bustedvillain
 */
public class ProyectoPerfilModel {

    @EJB(mappedName = "java:global/ServicioSocial/ProyectosFacade")
    private ProyectosFacade proyectosFacade;
    @EJB(mappedName = "java:global/ServicioSocial/PerfilFacade")
    private PerfilFacade perfilFacade;
    @EJB(mappedName = "java:global/ServicioSocial/ProyectoPerfilFacade")
    private ProyectoPerfilFacade proyectoPerfilFacade;
    //Recibe una cadena de id's de perfiles que desea agregar a cierto proyecto
    Proyectos proyecto;
    ArrayList<Perfil> perfiles = new ArrayList<Perfil>();

    public ProyectoPerfilModel(String cadenaPerfiles) {       

        //Analisis de la cadena
        StringTokenizer token = new StringTokenizer(cadenaPerfiles, ";");

        System.out.println("Analizar cadena:" + cadenaPerfiles);
        System.out.println("No de tokens:" + token.countTokens());
        while (token.hasMoreTokens()) {
            String perfil = token.nextToken();
            System.out.println("Token:" + perfil);
            if (perfil != null && !perfil.equals("")) {
                perfiles.add(perfilFacade.find(BigDecimal.valueOf(Double.parseDouble(perfil))));
            }
        }
    }

    public RespuestaInsertProyectoPerfil validarInsercionProyectoPerfil() {
        RespuestaInsertProyectoPerfil respuesta = new RespuestaInsertProyectoPerfil();
        if (perfiles.size() > 0) {
            if (validarUnicoPerfil()) {
                respuesta.setSuccess(true);
                respuesta.setMensaje("Perfiles insertados correctamente");
            } else {
                respuesta.setSuccess(false);
                respuesta.setMensaje("Hay perfiles repetidos");
            }

        } else {
            respuesta.setSuccess(false);
            respuesta.setMensaje("Error al insertar perfiles");
        }
        
        return respuesta;
    }

    //Validar que ningun perfil se repita
    public boolean validarUnicoPerfil() {
        for (int i = 0; i < perfiles.size(); i++) {
            Perfil perfil = perfiles.get(i);
            for (int j = 0; j < perfiles.size(); j++) {
                //Que no se compare con si mismo 
                if (i != j) {
                    if (perfil == perfiles.get(j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public void insertarProyectoPerfil(BigDecimal idProyecto) {
        try {
            proyecto = proyectosFacade.find(idProyecto);
        } catch (Exception e) {
            System.out.println("Error al buscar el proyecto");
        }
        
        for (int i = 0; i < perfiles.size(); i++) {
            ProyectoPerfil proyectoPerfil = new ProyectoPerfil();
            proyectoPerfil.setIdPerfil(perfiles.get(i));
            proyectoPerfil.setIdProyecto(proyecto);
            proyectoPerfilFacade.create(proyectoPerfil);
        }
    }
}
