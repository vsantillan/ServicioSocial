/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.EnviarCorreo;
import edu.servicio.toluca.beans.Fecha;
import edu.servicio.toluca.beans.bajasTemporales.bajasTemporales;
import edu.servicio.toluca.beans.bimestrales.fechas;
import edu.servicio.toluca.entidades.BajaTemporal;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.sesion.BajaTemporalFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author roy
 */
@Controller
public class BajasTemporalesController {

    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
    private FormatoUnicoFacade formatoUnicoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/BajaTemporalFacade")
    private BajaTemporalFacade bajaTemporal;
    @EJB(mappedName = "java:global/ServicioSocial/DatosPersonalesFacade")
    private DatosPersonalesFacade datosPersonalesFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/administrarBajas.do")
    public String administrarBajas(Model modelo) {

        List<FormatoUnico> formatos = formatoUnicoFacade.findAll();
        Iterator listaFormatos = formatos.iterator();
        List<FormatoUnico> formatosBaja = new ArrayList<FormatoUnico>();
        List<FormatoUnico> formatosSinBaja = new ArrayList<FormatoUnico>();
        while (listaFormatos.hasNext()) {
            FormatoUnico FU = (FormatoUnico) listaFormatos.next();
            if (FU.getStatusServicio() == BigInteger.ONE) {
                formatosBaja.add(FU);
            } else {
                formatosSinBaja.add(FU);
            }

        }
        modelo.addAttribute("alumnos", formatosBaja);
        modelo.addAttribute("alumnosBaja", formatosSinBaja);
//        modelo.addAttribute("alumnos", formatoUnicoFacade.findBySpecificField("statusServicio", "1", "equal", null, null));
//        modelo.addAttribute("alumnosBaja", formatoUnicoFacade.findBySpecificField("statusServicio", "3", "equal", null, null));
        modelo.addAttribute("bajas", new bajasTemporales());
        return "/BajasTemporales/administrarBajas";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/guardaBaja.do")
    public String insertaBaja(@ModelAttribute("bajas") bajasTemporales baja, BindingResult resultado, Model modelo, String selectfrom, HttpSession session, HttpServletRequest request) {
        BajaTemporal bt = new BajaTemporal();
        fechas fechas = new fechas();

        //Insertamos el registro 
        bt.setFechaBaja(fechas.covierteString(baja.getFechaBaja()));
        bt.setFechaLimiteBaja(fechas.covierteString(baja.getFechaLimiteBaja()));
        List<DatosPersonales> DP = datosPersonalesFacade.findBySpecificField("id", baja.getIdDatosPer(), "equal", null, null);
        bt.setDatosPersonalesId(DP.get(0));
        bajaTemporal.create(bt);
        System.out.println("Se inserto la baja temporal");

        //Cambiamos el Status de Servicio a 3
        List<FormatoUnico> editarFU = formatoUnicoFacade.findBySpecificField("datosPersonalesId", DP.get(0).getId(), "equal", null, null);
        editarFU.get(0).setStatusServicio(BigInteger.valueOf(3));
        formatoUnicoFacade.edit(editarFU.get(0));
        System.out.println("Se actualizo el status de baja");



        return "redirect:administrarBajas.do";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/quitaBaja.do")
    public @ResponseBody
    String quitaBaja(int id, HttpSession session, HttpServletRequest request) {



        //Cambiamos el Status de Servicio a 3
        List<FormatoUnico> editarFU = formatoUnicoFacade.findBySpecificField("datosPersonalesId", id, "equal", null, null);
        editarFU.get(0).setStatusServicio(BigInteger.valueOf(1));
        formatoUnicoFacade.edit(editarFU.get(0));
        System.out.println("Se actualizo el status de baja");



        return "ok";
    }
}
