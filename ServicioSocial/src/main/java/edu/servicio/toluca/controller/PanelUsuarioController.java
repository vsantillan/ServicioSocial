/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.beans.ValidaSesion;
import edu.servicio.toluca.beans.formatoUnico.FormatoUnicoPanelUsuarioBean;
import edu.servicio.toluca.beans.platica.FoliosPlaticaBean;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.model.VistaAlumno.ConsultasVistaAlumno;
import edu.servicio.toluca.model.formatoUnico.ValidacionPanelUsuarioFU;
import edu.servicio.toluca.model.noticias.ConsultasNoticias;
import edu.servicio.toluca.model.observaciones.ObservacionesModel;
import edu.servicio.toluca.model.platica.ConsultasPlatica;
import edu.servicio.toluca.sesion.FoliosPlaticaFacade;
import edu.servicio.toluca.sesion.NoticiasFacade;
import edu.servicio.toluca.sesion.RegObservacionesFacade;
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
    @EJB(mappedName = "java:global/ServicioSocial/NoticiasFacade")
    public NoticiasFacade noticiasFacade;
    @EJB(mappedName = "java:global/ServicioSocial/RegObservacionesFacade")
    public RegObservacionesFacade regObservacionesFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/panelUsuario.do")
    public String panelUsuario(Model model, HttpSession session, HttpServletRequest request, String mensaje) {
        //Valida sesion
        if (!new ValidaSesion().validaAlumno(session, request)) {
            model.addAttribute("error", "<div class='error'>Debes iniciar sesión para acceder a esta sección.</div>");
            return "redirect:login.do";
        }
        System.out.println("NCONTROL:" + session.getAttribute("NCONTROL").toString());

        //Obtenemos al alumno
        ConsultasVistaAlumno consultaVistaAlumno = new ConsultasVistaAlumno(vistaAlumnoFacade);
        VistaAlumno alumno = consultaVistaAlumno.getAlumnoSesion(session);

        System.out.println("Bienvenido al panel de usuario " + alumno.getNombre());

        //Cargar noticias noticias
        ConsultasNoticias noticias = new ConsultasNoticias(noticiasFacade);
        model.addAttribute("noticiasAlumnos", noticias.consultaNoticiasGenerales("desc"));

        //Checa platica
        ConsultasPlatica platica = new ConsultasPlatica(foliosPlaticaFacade);
        FoliosPlaticaBean beanPlatica = platica.checaAlumnoPlatica(alumno);

        model.addAttribute("platica", beanPlatica.isTienePlatica());
        model.addAttribute("accesoPlatica", beanPlatica.isAccesoPanelPlatica());
        model.addAttribute("mensajePlatica", beanPlatica.getMensajeUsuario());

        //Valida Formato Unico
        DatosPersonales datosPersonales = null;
        try {
            ValidacionPanelUsuarioFU valFormatoUnico = new ValidacionPanelUsuarioFU();
            List<DatosPersonales> datosPersonalesC = new ArrayList<DatosPersonales>(alumno.getDatosPersonalesCollection());
            datosPersonales = datosPersonalesC.get(0);
            List<FormatoUnico> formatoUnico = new ArrayList<FormatoUnico>(datosPersonales.getFormatoUnicoCollection());
            FormatoUnicoPanelUsuarioBean beanFU = valFormatoUnico.validaPanelUsuario(beanPlatica, formatoUnico.get(0));

            model.addAttribute("accesoFormatoUnico", beanFU.isAccesoFormatoUnico());
            model.addAttribute("statusFui", beanFU.getStatusFui());
            model.addAttribute("mensajeFormatoUnico", beanFU.getMensaje());

        } catch (Exception e) {
            System.out.println("Error al validar formato unico, Datos personales o formato unico nulo");
            model.addAttribute("accesoFormatoUnico", true);
            model.addAttribute("statusFui", 2);
            model.addAttribute("mensajeFormatoUnico", "No has dado de alta tu Formato Unico");
            //e.printStackTrace();
        }

        //Mensaje personal
        if (mensaje != null) {
            model.addAttribute("mensajePersonal", "<div class='error'>" + mensaje + "</div>");
        }

        //Observaciones
        try {
            if (datosPersonales != null) {
                ObservacionesModel observaciones = new ObservacionesModel();
                model.addAttribute("observaciones", observaciones.consultaObservaciones(datosPersonales, regObservacionesFacade, "desc"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        return "/PanelUsuario/panelUsuario";


    }
}
