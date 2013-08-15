/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author roy
 */
@Controller
public class ReporteBimestralController {

    @EJB(mappedName = "java:global/ServicioSocial/DatosPersonalesFacade")
    private DatosPersonalesFacade datosPersonalesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    private VistaAlumnoFacade vistaAlumnoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
    private FormatoUnicoFacade formatoUnicoFacade;

//    @RequestMapping(method = RequestMethod.GET, value = "/reporteBimestralAdministrador.do")
//    public String reporteBimestralAdministrador(Model modelo) {
//        return "/ReporteBimestral/reporteBimestralAdministrador";
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/formatoReporteBimestral.do")
    public String reporteBimestralUsuario(Model modelo) {
        String alumno_id = "09280028";
        List<VistaAlumno> listaAlumnos = vistaAlumnoFacade.findBySpecificField("id", alumno_id, "equal", null, null);
        //objeto que voy a insertar
        VistaAlumno alumno = listaAlumnos.get(0);
        modelo.addAttribute("datosPersonales", datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null));
        //List<FormatoUnico>
        return "/ReporteBimestral/formatoReporteBimestral";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/retroalimentacionReportesBimestrales.do")
    public String retroalimentacionBimestralUsuario(Model a) {

        return "/ReporteBimestral/retroalimentacionReportesBimestrales";
    }
}
