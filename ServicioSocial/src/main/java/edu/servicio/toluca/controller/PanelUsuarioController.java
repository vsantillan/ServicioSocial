/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.entidades.FoliosPlatica;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.sesion.FoliosPlaticaFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author roy
 */
@Controller
public class PanelUsuarioController {

    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    public VistaAlumnoFacade vistaAlumnoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/FoliosPlaticaFacade")
    public FoliosPlaticaFacade foliosPlaticaFacade;    

    @RequestMapping(method = RequestMethod.GET, value = "/panelUsuario.do")
    public String formatoUnico(Model model, HttpSession session, HttpServletRequest request) {
        //Valida sesion
        if (!new ValidaSesion().validaAlumno(session, request)) {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        System.out.println("NCONTROL:" + session.getAttribute("NCONTROL").toString());

        List<VistaAlumno> alumnos = vistaAlumnoFacade.findBySpecificField("id", session.getAttribute("NCONTROL").toString(), "equal", null, null);
        VistaAlumno alumno = null;
        if (!alumnos.isEmpty()) {
            alumno = alumnos.get(0);
            System.out.println("Bienvenido al panel de usuario " + alumno.getNombre());

            //Checa platica
            System.out.println("Checa platica");
            List<FoliosPlatica> platica = foliosPlaticaFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
            List<FoliosPlatica> filtroPlatica= new ArrayList();
            System.out.println("No. de registros en platica:"+platica.size());
            short uno =1;
                
            for (int i = 0; i < platica.size(); i++) {
                System.out.println(platica.get(i).toString());
                if(platica.get(i).getStatus() == uno){
                    filtroPlatica.add(platica.get(i));
                }
            }
            //Checa si se registro a alguna platica
            if(!filtroPlatica.isEmpty()){
                //Checa si asistio a la platica en la cual se registro
                if(platica.get(0).getAsistencia()==uno){
                    model.addAttribute("platica", true);
                    model.addAttribute("mensajePlatica", "Asististe a la platica del "+platica.get(0).getPlaticaId().getFecha()+", la fecha máxima para que subas tu formato único es hasta el "+platica.get(0).getPlaticaId().getFechaMxFui()+", de lo contrario serás acreedor a una sanción.");
                    System.out.println("Asistio a la platica");
                }else{
                    model.addAttribute("platica", false);
                    model.addAttribute("mensajePlatica", "Te registraste a la platica, pero no asististe a ella. Favor de pasar a la oficina de servicio social para solicitar un alta posterior.");
                    System.out.println("No asistio a la platica");
                }
            }else{
                model.addAttribute("platica", false);
                model.addAttribute("mensajePlatica", "No te has registrado a ninguna plática");
                System.out.println("No se registro a ninguna platica");
            }

            return "/PanelUsuario/panelUsuario";
        } else {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }

    }
}
