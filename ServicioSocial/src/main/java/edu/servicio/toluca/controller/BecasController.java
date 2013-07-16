/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.Becado;
import edu.servicio.toluca.beans.Fecha;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jonny
 */
@Controller
public class BecasController {

    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    private VistaAlumnoFacade vistaAlumno;
    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
    private FormatoUnicoFacade formatoUnico;

    @RequestMapping(method = RequestMethod.GET, value = "/preseleccionAlumnos.do")
    public String preseleccionAlumnos(@ModelAttribute(value = "alumnoP") Becado alumnoP, BindingResult result, Model model) {
        Fecha fecha = new Fecha();
        fecha.CalculaPeriodo();
        model.addAttribute("alumno", formatoUnico.findAll());
        return "/Becas/preseleccionAlumnos";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/administracionAlumnosBecados.do")
    public String administracionAlumnosBecados(Model model) {
        
       
       model.addAttribute("preseleccionado",formatoUnico.findBySpecificField("tipoServicio","4", "equal", null, null));
       //model.addAttribute("becado", formatoUnico.findBySpecificField("tipoServicio", "3", "equal", null, null));
       //model.addAttribute("preseleccionado", formatoUnico.findAll());
       model.addAttribute("espacio", " ");
        return "/Becas/administracionAlumnosBecados";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reporteMensualAdministrador.do")
    public String reporteMensualAdministrador(Model model) {

        return "/Becas/reporteMensualAdministrador";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/correo.do")
    public String correo(Model model) {

        return "/Becas/correo";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/excel.do")
    public String generaExcel(Model model) {
        return "/Becas/excel";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/preseleccionadoBD.do")
    public String updateBecados(Becado alumnoP, Model model) {

        if (alumnoP.getAlumno()!=null) {
            for (String current : alumnoP.getAlumno()) {
                FormatoUnico form;
                BigDecimal id = new BigDecimal(current);
                BigInteger tipoServicio = new BigInteger(String.valueOf(4));
                form = formatoUnico.find(id);
                form.setTipoServicio(tipoServicio);
                formatoUnico.edit(form);
            }
            return "/Becas/exito";

        } else {
            return "/Becas/error";
        }


    }
    @RequestMapping(method = RequestMethod.POST, value = "/quitarAlumno.do")
    public String quitarAlumno(String categorias[], Model model) {
//        System.out.println(categorias[0]);
//            for (String current : categorias) {
//                FormatoUnico form;
//                BigDecimal id = new BigDecimal(current);
//                BigInteger tipoServicio = new BigInteger(String.valueOf(1));
//                form = formatoUnico.find(id);
//                form.setTipoServicio(tipoServicio);
//                formatoUnico.edit(form);
//            }
            return "/Becas/exito";
    }
}
