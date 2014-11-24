/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.dao.GenericDao;
import edu.servicio.toluca.entidades.VistaAlumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author bustedvillain
 */
@Controller
public class DemoController {
    
    GenericDao<VistaAlumno> daoVistaAlumno;
    
    @Autowired
    public void setDaoVistaAlumno(GenericDao<VistaAlumno> daoVistaAlumno)
    {
        this.daoVistaAlumno = daoVistaAlumno;
        daoVistaAlumno.setClass(VistaAlumno.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/demoAdministrador.do")
    public String demoAdministrador(Model a) {

        return "/Plantillas/demoAdministrador";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/demoUsuario.do")
    public String demoUsuario(Model a) {

        return "/Plantillas/demoUsuario";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/demoOrganizacion.do")
    public String demoOrganizacion(Model a) {

        return "/Plantillas/demoOrganizacion";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/demoFormulario.do")
    public String demoFormulario(Model a) {
        return "/Plantillas/demoFormulario";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/testdato.do")
    public String testDAO(Model m)
    {
        List<VistaAlumno> alus = daoVistaAlumno
                .findBySpecificField("nombre", "JOSE MARIA", "equal", null, null);
        
        System.out.println("");System.out.println("");System.out.println("");
        System.out.println("RIFADOS ALUMNOOS:");
        for(VistaAlumno alu : alus)
        {
            System.out.println("Nombre: " + alu.getNombre());
        }
        
        return "Hola enfermeeera";
    }
}
