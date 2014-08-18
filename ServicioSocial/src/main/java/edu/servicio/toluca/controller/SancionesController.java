/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.beans.sanciones.sancionesBean;
import edu.servicio.toluca.entidades.CatalogoSanciones;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.Sanciones;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.model.sanciones.CatalogoSancionesModel;
import edu.servicio.toluca.sesion.CatalogoSancionesFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.SancionesFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Regules
 */
@Controller
public class SancionesController {

    @EJB(mappedName = "java:global/ServicioSocial/CatalogoSancionesFacade")
    private CatalogoSancionesFacade catalogoSancionesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/SancionesFacade")
    private SancionesFacade sancionesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/DatosPersonalesFacade")
    private DatosPersonalesFacade datosPersonalesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    private VistaAlumnoFacade vistaAlumnoFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/sancionesAlumno.do")
    public String sancionesAlumno(Model modelo, HttpSession session, HttpServletRequest request) {
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("datosPersonalesId", "asc");
        List<Sanciones> listaTodasSanciones = sancionesFacade.findAll(ordenamiento);
        List<Sanciones> sanciones = new ArrayList<Sanciones>();
        if (listaTodasSanciones.isEmpty()) {
            modelo.addAttribute("listaSanciones", null);
            modelo.addAttribute("espacio", " ");
        } else {
            for (Sanciones sancion : listaTodasSanciones) {
//                if (sancion.getHorasSancion().intValue() >= 0) {
                    sanciones.add(sancion);
//                }
            }
        }
        modelo.addAttribute("listaSanciones", sanciones);
        modelo.addAttribute("espacio", " ");
        return "/Sanciones/sancionesAlumno";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pagoSancionAlumno.do")
    public String pagoSancionAlumno(String nombre, String noControl, Model modelo) {
        modelo.addAttribute("nombre", nombre);
        modelo.addAttribute("noControl", noControl);
        return "/Sanciones/pagoSancionAlumno";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detalleSancionAlumno.do")
    public String detalleSancionAlumno(String nombre, String noControl, Model modelo) {
        System.out.println("Recibí" + noControl);
        VistaAlumno alumno = vistaAlumnoFacade.findBySpecificField("id", noControl, "equal", null, null).get(0);
        System.out.println("//Nocontrol" + alumno.getId());

        DatosPersonales dpAlumno = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null).get(0);
        System.out.println("//Nomnre" + dpAlumno.getNombre());
        List<Sanciones> listaTodasSanciones = sancionesFacade.findBySpecificField("datosPersonalesId", dpAlumno, "equal", null, null);
        List<Sanciones> listaSanciones = new ArrayList<Sanciones>();
        List<Sanciones> listaPagoSanciones = new ArrayList<Sanciones>();

        for (Sanciones sancion : listaTodasSanciones) {
            System.out.println("La sancion a agregar es" + sancion.getCatalogoSancionesId().getDetalle());
            if (sancion.getHorasSancion().intValue() > 0) {
//            if (sancion.getHorasSancion().compareTo(BigInteger.ZERO) > 1) {
                listaSanciones.add(sancion);
            } else {
                listaPagoSanciones.add(sancion);
            }
        }

        modelo.addAttribute("tipo", "sancion");
        modelo.addAttribute("titulo", "Sanciones");
        modelo.addAttribute("listaSanciones", listaSanciones);

        modelo.addAttribute("datosPersonalesId", dpAlumno);
        modelo.addAttribute("catalogoSanciones", catalogoSancionesFacade.findAll());
        modelo.addAttribute("nombre", dpAlumno.getNombre());
        modelo.addAttribute("noControl", alumno.getId());
        return "/Sanciones/detalleSancionAlumno";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/catalogoSanciones.do")
    public String catalogoSanciones(Model model, HttpSession session, HttpServletRequest request) {
        if (new ValidaSesion().validaAdmin(session, request) || new ValidaSesion().validaOperador(session, request)) {
           System.out.println("Conteo de registros Catalogo Sanciones:" + catalogoSancionesFacade.count());
            List<CatalogoSanciones> listaSanciones = new ArrayList<CatalogoSanciones>();
            List<CatalogoSanciones> listaPagoSanciones = new ArrayList<CatalogoSanciones>();
            if (catalogoSancionesFacade.findAll().isEmpty()) {
            return "/Sanciones/catalogoSanciones";
        }
        model.addAttribute("sanciones", catalogoSancionesFacade.findAll());
        return "/Sanciones/catalogoSanciones";
        } else {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editaSancion.do")
    public String editaSancion(String descripcion, String horas, Model modelo, BigDecimal id, HttpSession session, HttpServletRequest request) {
        if (new ValidaSesion().validaAdmin(session, request) || new ValidaSesion().validaOperador(session, request)) {
            //return "/PanelUsuario/panelUsuario";
        } else {
            modelo.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        CatalogoSanciones sancion = catalogoSancionesFacade.find(id);
        modelo.addAttribute("idSancion", sancion.getId());
        modelo.addAttribute("descripcion", sancion.getDetalle());
        modelo.addAttribute("horas", sancion.getHorasSancion());
        modelo.addAttribute("tolerancia", sancion.getTolerancia());
        return "/Sanciones/editaSancion";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editaPagoSancion.do")
    public String editaPagoSancion(String descripcion, String horas, Model modelo, BigDecimal id, HttpSession session, HttpServletRequest request) {
        if (new ValidaSesion().validaAdmin(session, request) || new ValidaSesion().validaOperador(session, request)) {
            //return "/PanelUsuario/panelUsuario";
        } else {
            modelo.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        CatalogoSanciones sancion = catalogoSancionesFacade.find(id);
        modelo.addAttribute("idSancion", sancion.getId());
        modelo.addAttribute("descripcion", sancion.getDetalle());
        return "/Sanciones/editaPagoSancion";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/nuevaSancion.do")
    public @ResponseBody
    String nuevaSancion(Model model, BigDecimal idSancion, String descripcion, BigInteger horas, BigInteger tolerancia, Model modelo, String tipo) {
        CatalogoSancionesModel csm = new CatalogoSancionesModel(descripcion, horas, tolerancia);
        String arrJSON = "[";
        csm.arregla();
        ArrayList<String> listaErrores = csm.valida();
        if (listaErrores.isEmpty()) {
            CatalogoSanciones sancion = null;
            if (tipo.equals("nuevo")) {
                sancion = new CatalogoSanciones();
            } else {
                sancion = catalogoSancionesFacade.find(idSancion);
            }
            sancion.setDetalle(descripcion);
            sancion.setHorasSancion(horas);
            sancion.setTolerancia(tolerancia);
            try {
                if (tipo.equals("nuevo")) {
                    catalogoSancionesFacade.create(sancion);
                } else {
                    catalogoSancionesFacade.edit(sancion);
                }

            } catch (Exception e) {
                arrJSON = arrJSON + "{\"observacion\":\"" + e.getMessage() + "\"},";
            }

        } else {
            int i = 1;
            for (String s : listaErrores) {
                arrJSON = arrJSON + "{\"observacion\":\"" + s + "\"},";
                System.out.println("Error " + i + " " + s);
                i++;
            }
        }
        if (arrJSON.equals("[")) {
            arrJSON = "noInfo";
        } else {
            arrJSON = arrJSON.substring(0, arrJSON.length() - 1) + "]";
        }

        System.out.println("Arrjson" + arrJSON);
        return arrJSON;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/asignaSancion.do")
    public @ResponseBody
    void asignaSancion(Model model, BigDecimal idSancion, BigDecimal idDatosPersonales, BigInteger horas) {
        Sanciones sancion = new Sanciones();
        DatosPersonales datosPersonales = datosPersonalesFacade.find(idDatosPersonales);
        System.out.println("--->Asignando sancion");
        System.out.println("Datos Personales--id=" + datosPersonales.getId() + ", Nombre:" + datosPersonales.getNombre());
        CatalogoSanciones catalogoSancion = catalogoSancionesFacade.find(idSancion);
        System.out.println("Sancion id=" + catalogoSancion.getId() + ", detalle=" + catalogoSancion.getDetalle());
        sancion.setCatalogoSancionesId(catalogoSancion);
        sancion.setDatosPersonalesId(datosPersonales);
        sancion.setFecha(new java.util.Date());
        sancion.setHorasSancion(horas);
        try {
            sancionesFacade.create(sancion);
        } catch (Exception e) {
            System.out.println("Hubo un problema: " + e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/quitarSancion.do")
    public String quitarSancion(String idSancion, Model model, HttpSession session, HttpServletRequest request) {
        if (new ValidaSesion().validaAdmin(session, request) || new ValidaSesion().validaOperador(session, request)) {
            //return "/PanelUsuario/panelUsuario";
        } else {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        try {
            BigDecimal id = new BigDecimal(idSancion);
            List<Sanciones> sancion = sancionesFacade.findBySpecificField("id", id, "equal", null, null);
            if (!sancion.isEmpty()) {
                sancionesFacade.remove(sancion.get(0));
            }
        } catch (Exception e) {
            System.out.println("Hubo un problema: " + e.toString());
        }
        return "redirect:sancionesAlumno.do";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pagoSancion.do")
    public
            String pagoSancion(Model model, String idSancion, HttpSession session, HttpServletRequest request) {
        if (new ValidaSesion().validaAdmin(session, request) || new ValidaSesion().validaOperador(session, request)) {
            //return "/PanelUsuario/panelUsuario";
        } else {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        try {
            BigDecimal id = new BigDecimal(idSancion);
            List<Sanciones> sancion = sancionesFacade.findBySpecificField("id", id, "equal", null, null);
            if (!sancion.isEmpty()) {
                model.addAttribute("sancion", sancion.get(0));
                model.addAttribute("espacio", " ");
            }
        } catch (Exception e) {
            System.out.println("Hubo un problema: " + e.toString());
        }

        return "/Sanciones/detalleSancionAlumno";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/pagoSancionAlumno.do")
    @ResponseBody
    public
            String pagoSancionAlumno(Model model, String id, String horas, HttpSession session, HttpServletRequest request) {
        System.out.println("entro");
        if (new ValidaSesion().validaAdmin(session, request) || new ValidaSesion().validaOperador(session, request)) {
            //return "/PanelUsuario/panelUsuario";
        } else {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        try {
            BigDecimal idSancion = new BigDecimal(id);
            List<Sanciones> sancion = sancionesFacade.findBySpecificField("id", idSancion, "equal", null, null);
            if (!sancion.isEmpty()) {
                if (sancion.get(0).getHorasSancion().intValue() < new BigInteger(horas).intValue()) {
                    model.addAttribute("sancion", sancion.get(0));
                    model.addAttribute("espacio", " ");
                    return "Numero de horas es mayor  las hora restantes";
                } else {
                   
                    sancion.get(0).setHorasSancion(sancion.get(0).getHorasSancion().subtract(new BigInteger(horas)));
                    sancionesFacade.edit(sancion.get(0));
                     model.addAttribute("sancion", sancion.get(0));
                    model.addAttribute("espacio", " ");
                    return "ok";
                }
            }
        } catch (Exception e) {
            System.out.println("Hubo un problema: " + e.toString());
            return "'Ocurrio un error";
        }

        return "ok";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/asignarSancion.do")
    String asignarSancion(Model model) {
        model.addAttribute("catalogoSancion", catalogoSancionesFacade.findAll());
        return "/Sanciones/asignarSancion";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/asignaSancionAlumno.do")
    String asignarSancionAlumno(Model model, String idSancion, String numeroControl) {
        String errorSancion = null;
        String errorAlumno = null;
        List<CatalogoSanciones> catSanciones = null;
        List<VistaAlumno> alumno = null;
        List<DatosPersonales> alumnoDP = null;

        model.addAttribute("catalogoSancion", catalogoSancionesFacade.findAll());

        if (idSancion == "" || numeroControl == "") {
            errorSancion = (idSancion == "") ? "<div class='alert alert-danger'>No se a seleccionado una Sancion </div>" : "";
            errorAlumno = (numeroControl == "") ? "<div class='alert alert-danger'>Numero de Control no encontrado </div>" : "";
            model.addAttribute("errorSancion", errorSancion);
            model.addAttribute("errorAlumno", errorAlumno);
            return "/Sanciones/asignarSancion";
        }
        try {
            catSanciones = catalogoSancionesFacade.findBySpecificField("id", idSancion, "equal", null, null);
            alumno = vistaAlumnoFacade.findBySpecificField("id", numeroControl, "equal", null, null);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            model.addAttribute("errorAlumno", "error del sistema");
            return "/Sanciones/asignarSancion";
        }

        if (catSanciones.isEmpty() || alumno.isEmpty()) {
            errorSancion = (catSanciones.isEmpty()) ? "<div class='alert alert-danger'>Sanciion no encontrada </div>" : "";
            errorAlumno = (alumno.isEmpty()) ? "<div class='alert alert-danger'>Numero de Control no encontrado </div>" : "";
            model.addAttribute("errorSancion", errorSancion);
            model.addAttribute("errorAlumno", errorAlumno);
            return "/Sanciones/asignarSancion";
        }
        try {

            alumnoDP = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            model.addAttribute("errorAlumno", "error del sistema");
            return "/Sanciones/asignarSancion";
        }
        Sanciones sancion = new Sanciones();
        sancion.setDatosPersonalesId(alumnoDP.get(0));
        sancion.setFecha(new java.util.Date());
        sancion.setHorasSancion(catSanciones.get(0).getHorasSancion());
        sancion.setCatalogoSancionesId(catSanciones.get(0));

        try {
            sancionesFacade.create(sancion);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            model.addAttribute("errorAlumno", "error del sistema");
            return "/Sanciones/asignarSancion";
        }
        model.addAttribute("errorAlumno", "<div class='alert alert-success'>Sancion asignada</div>");
        return "/Sanciones/asignarSancion";
    }
    public void sancionAutomatica (String idSancion, String numeroControl){
        String errorSancion = null;
        String errorAlumno = null;
        List<CatalogoSanciones> catSanciones = null;
        List<VistaAlumno> alumno = null;
        List<DatosPersonales> alumnoDP = null;
        try {
            catSanciones = catalogoSancionesFacade.findBySpecificField("id", idSancion, "equal", null, null);
            alumno = vistaAlumnoFacade.findBySpecificField("id", numeroControl, "equal", null, null);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {

            alumnoDP = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        Sanciones sancion = new Sanciones();
        sancion.setDatosPersonalesId(alumnoDP.get(0));
        sancion.setFecha(new java.util.Date());
        sancion.setHorasSancion(catSanciones.get(0).getHorasSancion());
        sancion.setCatalogoSancionesId(catSanciones.get(0));

        try {
            sancionesFacade.create(sancion);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
       
        
    }
}
