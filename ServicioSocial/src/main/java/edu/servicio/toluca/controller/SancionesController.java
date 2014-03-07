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
        List<sancionesBean> listaSancionesVista = new ArrayList();
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        ordenamiento.put("datosPersonalesId", "asc");
        List<Sanciones> listaTodasSanciones = sancionesFacade.findAll(ordenamiento);
        if(listaTodasSanciones.isEmpty()){
            return "redirect:panelAdministrador.do";
        }
        //List<String> listaSancionesVista = new ArrayList();
        int horas = 0;
        String noControl = listaTodasSanciones.get(0).getDatosPersonalesId().getAlumnoId().getId().toString();
        Sanciones s2 = new Sanciones();
        sancionesBean sancionBean = new sancionesBean();
        for (Sanciones sancion : listaTodasSanciones) {
            s2 = sancion;
            System.out.println("Obteniendo datos de sanciones");
            if (sancion.getDatosPersonalesId().getAlumnoId().getId().toString().equals(noControl)) {
                System.out.println("haciendo suma de horas, inicialmente se tiene" + horas);
                horas = horas + sancion.getHorasSancion().intValue();
                System.out.println("Las nuevas horas son " + horas);
            } else {
                sancionBean.setAlumno(sancion.getDatosPersonalesId().getAlumnoId());
                sancionBean.setDatosPersonales(sancion.getDatosPersonalesId());
                sancionBean.setHoras(horas);
                sancionBean.setIdAlumno(noControl);
                sancionBean.setIdCatalogoSanciones(sancion.getCatalogoSancionesId().getId());
                sancionBean.setIdSancion(sancion.getId());
                listaSancionesVista.add(sancionBean);
                horas = 0;
                noControl = sancion.getDatosPersonalesId().getAlumnoId().getId().toString();
            }
        }
        sancionBean.setAlumno(s2.getDatosPersonalesId().getAlumnoId());
        sancionBean.setDatosPersonales(s2.getDatosPersonalesId());
        sancionBean.setHoras(horas);
        sancionBean.setIdAlumno(noControl);
        sancionBean.setIdCatalogoSanciones(s2.getCatalogoSancionesId().getId());
        sancionBean.setIdSancion(s2.getId());
        listaSancionesVista.add(sancionBean);
        //listaSancionesVista.

        modelo.addAttribute("listaSanciones", listaSancionesVista);
        return "/Sanciones/sancionesAlumno";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/pagoSancionAlumno.do")
    public String pagoSancionAlumno(String nombre, String noControl, Model modelo) {
        modelo.addAttribute("nombre", nombre);
        modelo.addAttribute("noControl", noControl);
        return "/Sanciones/pagoSancionAlumno";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/detalleSancionAlumno.do")
    public String detalleSancionAlumno(String nombre, String noControl, String ins, Model modelo) {
        System.out.println("Recibí"+noControl);
        VistaAlumno alumno = vistaAlumnoFacade.findBySpecificField("id", noControl, "equal", null, null).get(0);
        System.out.println("//Nocontrol"+alumno.getId());
        
        DatosPersonales dpAlumno = datosPersonalesFacade.findBySpecificField("alumnoId", alumno, "equal", null, null).get(0);
        System.out.println("//Nomnre"+dpAlumno.getNombre());
        List<Sanciones> listaTodasSanciones = sancionesFacade.findBySpecificField("datosPersonalesId", dpAlumno, "equal", null, null);
        List<Sanciones> listaSanciones = new ArrayList<Sanciones>();
        List<Sanciones> listaPagoSanciones = new ArrayList<Sanciones>();
        
        for (Sanciones sancion : listaTodasSanciones) {
            System.out.println("La sancion a agregar es"+sancion.getCatalogoSancionesId().getDetalle());
            if (sancion.getHorasSancion().intValue() > 0) {
//            if (sancion.getHorasSancion().compareTo(BigInteger.ZERO) > 1) {
                listaSanciones.add(sancion);
            } else {
                listaPagoSanciones.add(sancion);
            }
        }
        if (ins.equals("sancion")) {
            modelo.addAttribute("tipo", "sancion");
            modelo.addAttribute("titulo", "Sanciones");
            modelo.addAttribute("listaSanciones",listaSanciones);
        } else if (ins.equals("pago")) {
            modelo.addAttribute("tipo", "pago");
            modelo.addAttribute("titulo", "Pago de Sanciones");
            modelo.addAttribute("listaSanciones",listaPagoSanciones);
        }
        modelo.addAttribute("datosPersonalesId",dpAlumno);
        modelo.addAttribute("catalogoSanciones", catalogoSancionesFacade.findAll());
        modelo.addAttribute("nombre", dpAlumno.getNombre());
        modelo.addAttribute("noControl", alumno.getId());
        return "/Sanciones/detalleSancionAlumno";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/catalogoSanciones.do")
    public String catalogoSanciones(Model model, HttpSession session, HttpServletRequest request) {
        if (new ValidaSesion().validaAdmin(session, request) || new ValidaSesion().validaOperador(session, request)) {
            //return "/PanelUsuario/panelUsuario";
        } else {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        System.out.println("Conteo de registros Catalogo Sanciones:" + catalogoSancionesFacade.count());
        List<CatalogoSanciones> listaSanciones = new ArrayList<CatalogoSanciones>();
        List<CatalogoSanciones> listaPagoSanciones = new ArrayList<CatalogoSanciones>();
        if(catalogoSancionesFacade.findAll().isEmpty()){
            return "redirect:panelAdministrador.do";
        }
        for (CatalogoSanciones sancion : catalogoSancionesFacade.findAll()) {
            
            if (sancion.getHorasSancion().compareTo(BigInteger.ZERO) > 0) {
                listaSanciones.add(sancion);
            } else {
                listaPagoSanciones.add(sancion);
            }
        }
        
        model.addAttribute("sanciones", listaSanciones);
        model.addAttribute("pagoSanciones", listaPagoSanciones);
        return "/Sanciones/catalogoSanciones";
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
    String asignaSancion(Model model, BigDecimal idSancion, BigDecimal idDatosPersonales, BigInteger horas, Model modelo) {
        Sanciones sancion = new Sanciones();
        DatosPersonales datosPersonales = datosPersonalesFacade.find(idDatosPersonales);
        System.out.println("--->Asignando sancion");
        System.out.println("Datos Personales--id="+datosPersonales.getId()+", Nombre:"+datosPersonales.getNombre());
        CatalogoSanciones catalogoSancion = catalogoSancionesFacade.find(idSancion);
        System.out.println("Sancion id="+catalogoSancion.getId()+", detalle="+catalogoSancion.getDetalle());
        sancion.setCatalogoSancionesId(catalogoSancion);
        sancion.setDatosPersonalesId(datosPersonales);
        sancion.setFecha(new java.util.Date());
        sancion.setHorasSancion(horas);
        try
        {
            sancionesFacade.create(sancion);
        }
        catch(Exception e)
        {
            return "Hubo un problema: "+e.getMessage();
        }
        
        
        return "Sancion asignada correctamente";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/quitaSancion.do")
    public @ResponseBody
    String quitaSancion(Model model, BigDecimal idSancion, Model modelo) {
        
        Sanciones sancion = sancionesFacade.find(idSancion);
        try
        {
            sancionesFacade.remove(sancion);
        }
        catch(Exception e)
        {
            return "Hubo un problema: "+e.getMessage();
        }
        
        
        return "Sancion Elminada correctamente";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/nuevoPagoSancion.do")
    public @ResponseBody
    String nuevoPagoSancion(Model model, BigDecimal idSancion, String descripcion, Model modelo, String tipo) {
        CatalogoSancionesModel csm = new CatalogoSancionesModel(descripcion, BigInteger.ZERO, BigInteger.ZERO);
        String arrJSON = "[";
        csm.arregla();
        ArrayList<String> listaErrores = csm.valida2();
        
        if (listaErrores.isEmpty()) {
            CatalogoSanciones sancion = null;
            if (tipo.equals("nuevo")) {
                sancion = new CatalogoSanciones();
            } else {
                sancion = catalogoSancionesFacade.find(idSancion);
            }
            sancion.setDetalle(descripcion);
            sancion.setHorasSancion(BigInteger.ZERO);
            sancion.setTolerancia(BigInteger.ZERO);
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
    
}
