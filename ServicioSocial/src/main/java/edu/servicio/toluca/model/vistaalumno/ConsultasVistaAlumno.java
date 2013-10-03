/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.vistaalumno;

import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bustedvillain
 */
public class ConsultasVistaAlumno {
    
    public VistaAlumnoFacade vistaAlumnoFacade;
    
    public ConsultasVistaAlumno(VistaAlumnoFacade vistaAlumnoFacade){
        this.vistaAlumnoFacade=vistaAlumnoFacade;
    }
    
    public VistaAlumno getAlumnoSesion(HttpSession session){
        return vistaAlumnoFacade.findBySpecificField("id", session.getAttribute("NCONTROL").toString(), "equal", null, null).get(0);
    }
    
}
