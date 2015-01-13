/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.model.vistaalumno;

import edu.servicio.toluca.dao.GenericDao;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bustedvillain
 */
public class ConsultasVistaAlumno
{

    private GenericDao<VistaAlumno> daoVistaAlumno;

    @Autowired
    public void setDaoVistaAlumno(GenericDao<VistaAlumno> daoVistaAlumno)
    {
        this.daoVistaAlumno = daoVistaAlumno;
        daoVistaAlumno.setClass(VistaAlumno.class);
    }

    public ConsultasVistaAlumno(GenericDao<VistaAlumno> daoVistaAlumno)
    {
        this.daoVistaAlumno = daoVistaAlumno;
    }

    public VistaAlumno getAlumnoSesion(HttpSession session)
    {
        return (VistaAlumno) daoVistaAlumno.findBySpecificField("id", session.getAttribute("NCONTROL").toString(), "equal", null, null).get(0);
    }

    public VistaAlumno getAlumno(String id)
    {
        List<VistaAlumno> alumno = daoVistaAlumno.findBySpecificField("id", id, "equal", null, null);
        return alumno.get(0);
    }

}
