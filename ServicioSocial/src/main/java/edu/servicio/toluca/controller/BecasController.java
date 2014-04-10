/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.Becado;
import edu.servicio.toluca.beans.EnviarCorreo;
import edu.servicio.toluca.beans.Fecha;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String preseleccionAlumnos(@ModelAttribute(value = "alumnoP") Becado alumnoP, BindingResult result, Model model) throws ParseException {
        Fecha fecha = new Fecha();
        List<FormatoUnico> consulta = formatoUnico.findAll();
        List<FormatoUnico> alumno = new ArrayList<FormatoUnico>();
        for (int i = 0; i < consulta.size(); i++) {
            if (((consulta.get(i).getStatusServicio().toString().compareTo("1") == 0) && (consulta.get(i).getTipoServicio().toString().compareTo("1") == 0))) {
                alumno.add(consulta.get(i));
            }
        }

        model.addAttribute("alumno", alumno);

        return "/Becas/preseleccionAlumnos";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/administracionAlumnosBecados.do")
    public String administracionAlumnosBecados(@ModelAttribute(value = "alumnoP") Becado alumnoP, BindingResult result, Model model) {

        model.addAttribute("alumno", formatoUnico.findBySpecificField("tipoServicio", "1", "equal", null, null));
        model.addAttribute("preseleccionado", formatoUnico.findBySpecificField("tipoServicio", "4", "equal", null, null));
        model.addAttribute("becado", formatoUnico.findBySpecificField("tipoServicio", "3", "equal", null, null));
        //  model.addAttribute("preseleccionado", formatoUnico.findAll());
        model.addAttribute("espacio", " ");

        return "/Becas/administracionAlumnosBecados";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sadf.do")
    public String correo(Model model) {

        return "/Becas/correo";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dbPreseleccionados.xls")
    public String generaPreseleccionadosExcel(Model model) {
        return "/Becas/dbPreseleccionadosReporte";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/becados.pdf")
    public String generaPDFBecados(Model model) {
        return "/Becas/becados";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/becadosExcel.xls")
    public String generaExcelBecados(Model model) {
        return "/Becas/dbBecadosReporte";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/preseleccionadoBD.do")
    public @ResponseBody
    void updateBecados(Becado alumnoP, Model model) {
        System.out.println("llego aqui");
        System.out.println(alumnoP.getAlumno());
        if (alumnoP.getAlumno() != null) {
            for (String current : alumnoP.getAlumno()) {
                FormatoUnico form;
                BigDecimal id = new BigDecimal(current);
                BigInteger tipoServicio = new BigInteger(String.valueOf(4));
                form = formatoUnico.find(id);
                form.setTipoServicio(tipoServicio);
                formatoUnico.edit(form);
            }
//            return "Alumno(s) agregados a la lista de preseleccion de becados";
//
//        } else {
//            return "ERROR no se pudo agregar alumno(s) agregados a la lista de preselelcion de becados";
//        }
        }

//        return "redirect:administracionAlumnosBecados.do";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/quitarAlumno.do")
    public @ResponseBody
    String quitarAlumno(@RequestParam(value = "alumno[]", required = false) String[] alumno, Model model) {
        if (alumno != null) {
            for (String current : alumno) {
                FormatoUnico form;
                //System.out.println(current);
                BigDecimal id = new BigDecimal(current);
                BigInteger tipoServicio = new BigInteger(String.valueOf(1));
                form = formatoUnico.find(id);
                form.setTipoServicio(tipoServicio);
                formatoUnico.edit(form);
            }
            return "Se a quitado el alumno de la lista de preseleccion";

        } else {
            return "ERROR no se pudo queitar el alumno de la lista de preseleccion";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/enviarCorreo.do")
    public @ResponseBody
    String enviarCorreo(@RequestParam(value = "alumno[]", required = false) String[] alumno, Model model) {
        if (alumno != null) {
            for (String current : alumno) {
            }
            return "Se ha enviado el correo exitosamente";

        } else {
            return "ERROR no se a podido enviar el correo";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/aceptarAlumno.do")
    public @ResponseBody
    String aceptarAlumno(@RequestParam(value = "alumno[]", required = false) String[] alumno, Model model) {
        if (alumno != null) {
            for (String current : alumno) {
                FormatoUnico form;
                BigDecimal id = new BigDecimal(current);
                BigInteger tipoServicio = new BigInteger(String.valueOf(3));
                form = formatoUnico.find(id);
                form.setTipoServicio(tipoServicio);
                formatoUnico.edit(form);
            }
            return "El alumno(s) fue agrado correctamente a la lista de becados";

        } else {
            return "ERROR no se a podido agregar el alumno a la lista de becados";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/envioCorreoBecados.do")
    public @ResponseBody
    void envioCorreoBecados(@RequestParam(value = "alumno[]", required = false) String[] alumno, String asunto, String descripcion, Model model) {
        
        if (alumno != null && asunto != null && descripcion != null) 
        {            
            for (String current : alumno) {
                FormatoUnico form;
                BigDecimal id = new BigDecimal(current);
                form = formatoUnico.find(id);
                if (form.getDatosPersonalesId().getCorreoElectronico()!=null){
                Thread hiloCorreo = new Thread(new EnviarCorreo(asunto, form.getDatosPersonalesId().getCorreoElectronico(), descripcion));
                hiloCorreo.start();
            }
                
            }

        }
    }
}
