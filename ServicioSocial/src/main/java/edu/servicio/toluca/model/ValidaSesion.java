/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bustedvillain
 */
public class ValidaSesion {
    //Valida sesion para el alumno

    public boolean validaAlumno(HttpSession session, HttpServletRequest request) {
        return validaSesion(session, request, "ALUMNO");
    }
    //Valida sesion para el Operador (Maestro Joelito)

    public boolean validaOperador(HttpSession session, HttpServletRequest request) {
        return validaSesion(session, request, "OPERACION");
    }
    //Valida sesion para un directivo que solo hace consultas

    public boolean validaConsultas(HttpSession session, HttpServletRequest request) {
        return validaSesion(session, request, "CONSULTAS");
    }
    //Valida sesion para un super administrador

    public boolean validaAdmin(HttpSession session, HttpServletRequest request) {
        return validaSesion(session, request, "ADMIN");
    }
    //Valida sesion para alguien que registra, ASISTENTE

    public boolean validaRegistro(HttpSession session, HttpServletRequest request) {
        return validaSesion(session, request, "REGISTRO");
    }
    //Valida sesion para organizaciones
    public boolean validaOrganizacion(HttpSession session, HttpServletRequest request) {
        return validaSesion(session, request, "ORGANIZACION");
    }

    public boolean validaSesion(HttpSession session, HttpServletRequest request, String rol) {
        session = request.getSession();
        boolean sessionOk = false;
        if (session.getAttribute("ROL") != null && session.getAttribute("NCONTROL") != null) {
            if (session.getAttribute("ROL").toString().equals(rol) ) {
                sessionOk = true;
            }
        }        
        return sessionOk;
    }
}
