/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.StatusServicioBean;
import edu.servicio.toluca.model.historialservicio.HistorialServicioModel;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import java.util.ArrayList;


import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Controlador para el historial de servicio social
 * Autor: Jose Manuel Nieto Gomez
 * @author bustedvillain
 */

@Controller
public class HistorialServicioController {

    @EJB(mappedName = "java:global/ServicioSocial/DatosPersonalesFacade")
    public DatosPersonalesFacade datosPersonalesFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/historialServicio.do")
    public String historialServicio(Model model, HttpSession session, HttpServletRequest request) {
        //Valida sesion
        ValidaSesion valSession = new ValidaSesion(session, request);
        if (valSession.accesaPanelAdministrador()) {

            //Modelo ara procesar el historial de alumnos
            HistorialServicioModel historialModel = new HistorialServicioModel(datosPersonalesFacade);
            //Obtener todos los alumnos procesados en el sistema y validandolos
            List<StatusServicioBean> alumnos = new ArrayList<StatusServicioBean>();
            try {
                alumnos = historialModel.getHistorialAlumnos();
            } catch (Exception e) {
                System.out.println("Error al cargar alumnos en el servicio social");
            }
            
            //Inyectando alumnos
            model.addAttribute("alumnos", alumnos);
            
            return "/HistorialServicio/historialServicio";
        } else {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }



    }
}
