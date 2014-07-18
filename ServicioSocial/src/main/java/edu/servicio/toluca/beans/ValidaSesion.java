/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bustedvillain
 */
public class ValidaSesion {
    //Valida sesion para el alumno

    HttpSession session;
    HttpServletRequest request;

    public ValidaSesion(HttpSession session, HttpServletRequest request) {
        this.session = session;
        this.request = request;
    }

    public ValidaSesion() {
    }
    
    /**
     * Retorna true si hay una sesion iniciada. No recibe parametros, estos debieron haber sido enviados en el constructor de la clase
     * @return 
     */
    public boolean haySesion(){
        if(validaAdmin() || validaAlumno() || validaConsultas() || validaOperador() || validaOrganizacion() || validaRegistro()){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Retorna ture si hay una sesion iniciada. No recibe parametros.
     * @param session
     * @param request
     * @return 
     */
    public boolean haySesion(HttpSession session, HttpServletRequest request){
        if(validaAdmin(session, request) || validaAlumno(session, request) || validaConsultas(session, request) || validaOperador(session, request) || validaOrganizacion(session, request) || validaRegistro(session, request)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Valida si el usuario puede entrar al panel del administrador. Sin recibir parametros, que debieron haber sido enviados en el constructor de la clase.
     * @return 
     */
    public boolean accesaPanelAdministrador(){
        if(validaAdmin() || validaConsultas() || validaRegistro() || validaOperador()){
           return true; 
        }else{
            return false;
        }
        
    }
    
    /**
     * Valida si el usuario puede entrar al panel del administrador. Recibe las variables de sesion.
     * @param session
     * @param request
     * @return 
     */
    public boolean accesaPanelAdministraodr(HttpSession session, HttpServletRequest request){
        if(validaAdmin(session, request) || validaConsultas(session, request) || validaRegistro(session, request) || validaOperador(session, request)){
           return true; 
        }else{
            return false;
        }
    }
    /**
     * Este metodo valida que la sesion sea de un alumno recibiendo las
     * variables de la sesion
     *
     * @param session
     * @param request
     * @return
     */
    public boolean validaAlumno(HttpSession session, HttpServletRequest request) {
        return validaSesion(session, request, "ALUMNO");
    }

    /**
     * Este metodo valida que la sesion sea de un alumno sin recibir parametros,
     * los cuales fueron recibidos en el contructor de la clase.
     *
     * @return *
     */
    public boolean validaAlumno() {
        return validaSesion(session, request, "ALUMNO");
    }

    //Valida sesion para el Operador (Maestro Joelito)
    /**
     * Valida sesion para el operador recibiendo las variables de sesion. El
     * usuario puede ser el Jefe del Departamento de Servicio Social o el Jefe
     * del Departamento de Gestion y Vinculacion
     *
     * @param session
     * @param request
     * @return
     */
    public boolean validaOperador(HttpSession session, HttpServletRequest request) {
        return validaSesion(session, request, "OPERACION");
    }

    /**
     * Valida sesion para el operador sin recibir parametros, los cuales fueron
     * recibidos en el constructor de la clase. El usuario puede ser el Jefe del
     * Departamento de Servicio Social o el Jefe del Departamento de Gestion y
     * Vinculacion
     *
     * @return
     */
    public boolean validaOperador() {
        return validaSesion(session, request, "OPERACION");
    }

    //Valida sesion para un directivo que solo hace consultas
    /**
     * Valida la sesion para consultas recibiendo las variables de sesion. El
     * usuario puede ser de personal administrativo, tal como la direcotora,
     * subdirectora, etc.
     *
     * @param session
     * @param request
     * @return
     */
    public boolean validaConsultas(HttpSession session, HttpServletRequest request) {
        return validaSesion(session, request, "CONSULTAS");
    }

    /**
     * Valida la sesion para consultas sin recibir parametros, los cuales fueron
     * recibidos en el constructor de la clase. El usuario puede ser del
     * personal administrativo, tal como la directora, subdirectora, etc.
     *
     * @return
     */
    public boolean validaConsultas() {
        return validaSesion(session, request, "CONSULTAS");
    }

    //Valida sesion para un super administrador
    /**
     * Valida la sesion del SuperAdmin recibiendo las variables de sesion. BD
     *
     * @param session
     * @param request
     * @return
     */
    public boolean validaAdmin(HttpSession session, HttpServletRequest request) {
        return validaSesion(session, request, "ADMIN");
    }

    /**
     * Valida la seesion del SuperAdmin sin recibir parametros, los cuales
     * fueron recibidos en el constructor de la clase. BD
     *
     * @return
     */
    public boolean validaAdmin() {
        return validaSesion(session, request, "ADMIN");
    }

    //Valida sesion para alguien que registra, ASISTENTE
    /**
     * Valida la sesion para registro recibiendo las variables de sesion. El
     * usuario puede ser el asistente del jefe del departamento de servicio
     * social.
     *
     * @param session
     * @param request
     * @return
     */
    public boolean validaRegistro(HttpSession session, HttpServletRequest request) {
        return validaSesion(session, request, "REGISTRO");
    }

    /**
     * Valida la sesion para registro sin recibir parametros, los cuales fueron
     * recibidos en el constructor de la clase. El usuario puede ser el
     * asistente del jefe del departamento de servicio social.
     *
     * @return
     */
    public boolean validaRegistro() {
        return validaSesion(session, request, "REGISTRO");
    }

    //Valida sesion para organizaciones
    /**
     * Valida la sesion de organizacion recibiendo las variables de sesion
     *
     * @param session
     * @param request
     * @return
     */
    public boolean validaOrganizacion(HttpSession session, HttpServletRequest request) {
        return validaSesion(session, request, "ORGANIZACION");
    }

    /**
     * Valida la sesion de organizacion sin recibir parametros, los cuales
     * fueron recibidos en el constructor de la clase.
     *
     * @return
     */
    public boolean validaOrganizacion() {
        return validaSesion(session, request, "ORGANIZACION");
    }

    /**
     * Metodo que valida la sesion recibiendo las variables Session, Request y
     * especificandole que rol se desea comprobar
     *
     * @param session
     * @param request
     * @param rol
     * @return
     */
    public boolean validaSesion(HttpSession session, HttpServletRequest request, String rol) {
        session = request.getSession();
        boolean sessionOk = false;

        if (session.getAttribute("ROL") != null) {
            if (rol.equals("ALUMNO") || rol.equals("ORGANIZACION")) {
                if (session.getAttribute("NCONTROL") != null) {
                    if (session.getAttribute("ROL").toString().equals(rol)) {
                        sessionOk = true;
                    }
                }
            } else {
                if (session.getAttribute("ROL").toString().equals(rol)) {
                    sessionOk = true;
                }
            }
        }

        return sessionOk;
    }
}
