/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.bajasTemporales.bajasTemporales;
import edu.servicio.toluca.beans.bajasTemporales.cambioDependencia;
import edu.servicio.toluca.beans.bimestrales.fechas;
import edu.servicio.toluca.entidades.BajaTemporal;
import edu.servicio.toluca.entidades.DatosPersonales;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.entidades.Instancia;
import edu.servicio.toluca.entidades.Proyectos;
import edu.servicio.toluca.sesion.BajaTemporalFacade;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import edu.servicio.toluca.sesion.InstanciaFacade;
import edu.servicio.toluca.sesion.ProyectosFacade;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class BajasTemporalesController
{

    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
    private FormatoUnicoFacade formatoUnicoFacade;
    @EJB(mappedName = "java:global/ServicioSocial/BajaTemporalFacade")
    private BajaTemporalFacade bajaTemporal;
    @EJB(mappedName = "java:global/ServicioSocial/DatosPersonalesFacade")
    private DatosPersonalesFacade datosPersonalesFacade;
    @EJB(mappedName = "java:global/ServicioSocial/InstanciaFacade")
    private InstanciaFacade instanciaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/ProyectosFacade")
    private ProyectosFacade proyectoFacade;

    @RequestMapping(method = RequestMethod.POST, value = "/actualizaInstancia.do")
    public String actualizaInstancia(Model modelo, String idFormatoUnico, String proyectosInstancia)
    {
        System.out.println("idDatos: " + idFormatoUnico + "Proyectos: " + proyectosInstancia);
        List<FormatoUnico> formatoUnico = formatoUnicoFacade.findBySpecificField("id", idFormatoUnico, "equal", null, null);
        List<Proyectos> proyectos = proyectoFacade.findBySpecificField("idProyecto", proyectosInstancia, "equal", null, null);
        FormatoUnico formatoActualizar = formatoUnico.get(0);
        formatoActualizar.setIdproyecto(proyectos.get(0));
        formatoUnicoFacade.edit(formatoActualizar);
        return "redirect:cambioDependencia.do";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dameProyectos.do")
    public @ResponseBody
    String dameProyctos(Model modelo, int idInstancia)
    {
        String arrJSON = "";
        List<Proyectos> listProyectos = proyectoFacade.findBySpecificField("idInstancia", idInstancia, "equal", null, null);
        Iterator<Proyectos> recorreProyectos = listProyectos.iterator();

        while (recorreProyectos.hasNext())
        {
            Proyectos proyectoAcual = recorreProyectos.next();
            arrJSON += "<option value='" + proyectoAcual.getIdProyecto() + "'>" + proyectoAcual.getNombre() + "</option>";

        }
        return arrJSON;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cambioDependencia.do")
    public String cambioDependencia(Model modelo)
    {

        List<FormatoUnico> formatos = formatoUnicoFacade.findAll();
        Iterator listaFormatos = formatos.iterator();
        List<FormatoUnico> formatosSinBaja = new ArrayList<FormatoUnico>();
        List<Instancia> listaInstancias = instanciaFacade.findBySpecificField("validacionAdmin", "1", "equal", null, null);
        ArrayList<Instancia> filtroInstancias = new ArrayList<Instancia>();

        for (int i = 0; i < listaInstancias.size(); i++)
        {
//            if (listaInstancias.get(i).getEstatus() == BigInteger.ONE)//.....................................correcion de la sentencia if al comparar status.................................................
            if (listaInstancias.get(i).getStatus() == (short) BigInteger.ONE.intValue())
            {
                filtroInstancias.add(listaInstancias.get(i));
            }
        }
        while (listaFormatos.hasNext())
        {
            FormatoUnico FU = (FormatoUnico) listaFormatos.next();
            if (FU.getStatusServicio() == BigInteger.ONE 
//                    && FU.getIdproyecto().getIdInstancia().getEstatus() == BigInteger.ONE)//.....................................correcion de la sentencia if al comparar status.................................................
                    && FU.getIdproyecto().getIdInstancia().getStatus() ==(short) BigInteger.ONE.intValue())
            {
                formatosSinBaja.add(FU);
            }

        }
        modelo.addAttribute("cambioDependencia", new cambioDependencia());
        modelo.addAttribute("instancias", filtroInstancias);
        modelo.addAttribute("alumnos", formatosSinBaja);
        return "/BajasTemporales/cambioDependencia";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/administrarBajas.do")
    public String administrarBajas(Model modelo)
    {

        List<FormatoUnico> formatos = formatoUnicoFacade.findAll();
        List<BajaTemporal> bajasTemporales = bajaTemporal.findAll();
        Iterator listaFormatos = formatos.iterator();
        List<FormatoUnico> formatosBaja = new ArrayList<FormatoUnico>();
        List<FormatoUnico> formatosSinBaja = new ArrayList<FormatoUnico>();
        while (listaFormatos.hasNext())
        {
            FormatoUnico FU = (FormatoUnico) listaFormatos.next();
            if (FU.getStatusServicio() == BigInteger.ONE)
            {
                formatosBaja.add(FU);
            } else
            {
                formatosSinBaja.add(FU);
            }

        }
        modelo.addAttribute("alumnos", formatosBaja);
        modelo.addAttribute("alumnosBaja", formatosSinBaja);
//        modelo.addAttribute("alumnos", formatoUnicoFacade.findBySpecificField("statusServicio", "1", "equal", null, null));
//        modelo.addAttribute("alumnosBaja", formatoUnicoFacade.findBySpecificField("statusServicio", "3", "equal", null, null));
        modelo.addAttribute("bajas", new bajasTemporales());
        modelo.addAttribute("bajasTemporales", bajasTemporales);
        return "/BajasTemporales/administrarBajas";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/guardaBaja.do")
    public String insertaBaja(@ModelAttribute("bajas") bajasTemporales baja, BindingResult resultado, Model modelo, String selectfrom, HttpSession session, HttpServletRequest request)
    {
        BajaTemporal bt = new BajaTemporal();
        fechas fechas = new fechas();
        List<BajaTemporal> listaBajas = bajaTemporal.findBySpecificField("datosPersonalesId", baja.getIdDatosPer(), "equal", null, null);
        List<DatosPersonales> DP = datosPersonalesFacade.findBySpecificField("id", baja.getIdDatosPer(), "equal", null, null);
        if (listaBajas.isEmpty())
        {
            //Insertamos el registro 
            bt.setFechaBaja(fechas.covierteString(baja.getFechaBaja()));
            bt.setFechaLimiteBaja(fechas.covierteString(baja.getFechaLimiteBaja()));
            bt.setDatosPersonalesId(DP.get(0));
            bajaTemporal.create(bt);
            System.out.println("Se inserto la baja temporal");
        } else
        {
            BajaTemporal bajaAntigua = listaBajas.get(0);
            bajaAntigua.setFechaBaja(fechas.covierteString(baja.getFechaBaja()));
            bajaAntigua.setFechaLimiteBaja(fechas.covierteString(baja.getFechaLimiteBaja()));
            bajaTemporal.edit(bajaAntigua);
        }

        //Cambiamos el Status de Servicio a 3
        List<FormatoUnico> editarFU = formatoUnicoFacade.findBySpecificField("datosPersonalesId", DP.get(0).getId(), "equal", null, null);
        editarFU.get(0).setStatusServicio(BigInteger.valueOf(3));
        formatoUnicoFacade.edit(editarFU.get(0));
        System.out.println("Se actualizo el status de baja");

        return "redirect:administrarBajas.do";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/quitaBaja.do")
    public @ResponseBody
    String quitaBaja(int id, HttpSession session, HttpServletRequest request)
    {

        //Cambiamos el Status de Servicio a 3
        List<FormatoUnico> editarFU = formatoUnicoFacade.findBySpecificField("datosPersonalesId", id, "equal", null, null);
        editarFU.get(0).setStatusServicio(BigInteger.valueOf(1));
        formatoUnicoFacade.edit(editarFU.get(0));
        System.out.println("Se actualizo el status de baja");

        return "ok";
    }
}
