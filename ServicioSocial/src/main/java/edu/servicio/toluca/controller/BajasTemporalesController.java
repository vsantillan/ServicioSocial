/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.bajasTemporales.BajasTemporales;
import edu.servicio.toluca.beans.bajasTemporales.cambioDependencia;
import edu.servicio.toluca.beans.bimestrales.fechas;
import edu.servicio.toluca.dao.GenericDao;
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
import org.springframework.beans.factory.annotation.Autowired;
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

    private GenericDao<FormatoUnico> daoFormatoUnico;
    private GenericDao<DatosPersonales> daoDatosPersonales;
    private GenericDao<BajaTemporal> daoBajaTemporal;
    private GenericDao<Instancia> daoInstancia;
    private GenericDao<Proyectos> daoProyectos;

    @Autowired
    public void setdaoFormatoUnico(GenericDao<FormatoUnico> daoFormatoUnico)
    {
        this.daoFormatoUnico = daoFormatoUnico;
        daoFormatoUnico.setClass(FormatoUnico.class);
    }

    @Autowired
    public void setdaoDatosPersonales(GenericDao<DatosPersonales> daoDatosPersonales)
    {
        this.daoDatosPersonales = daoDatosPersonales;
        daoDatosPersonales.setClass(DatosPersonales.class);
    }

    @Autowired
    public void setdaoBajaTemporal(GenericDao<BajaTemporal> daoBajaTemporal)
    {
        this.daoBajaTemporal = daoBajaTemporal;
        daoBajaTemporal.setClass(BajaTemporal.class);
    }

    @Autowired
    public void setdaoInstancia(GenericDao<Instancia> daoInstancia)
    {
        this.daoInstancia = daoInstancia;
        daoInstancia.setClass(Instancia.class);
    }

    @Autowired
    public void setDaoProyectos(GenericDao<Proyectos> daoProyectos)
    {
        this.daoProyectos = daoProyectos;
        daoProyectos.setClass(Proyectos.class);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/actualizaInstancia.do")
    public String actualizaInstancia(Model modelo, String idFormatoUnico, String proyectosInstancia)
    {
        System.out.println("idDatos: " + idFormatoUnico + "Proyectos: " + proyectosInstancia);
        List<FormatoUnico> formatoUnico = daoFormatoUnico.findBySpecificField("id", idFormatoUnico, "equal", null, null);
        List<Proyectos> proyectos = daoProyectos.findBySpecificField("idProyecto", proyectosInstancia, "equal", null, null);
        FormatoUnico formatoActualizar = formatoUnico.get(0);
        formatoActualizar.setIdproyecto(proyectos.get(0));
        daoFormatoUnico.edit(formatoActualizar);
        return "redirect:cambioDependencia.do";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dameProyectos.do")
    public @ResponseBody
    String dameProyctos(Model modelo, int idInstancia)
    {
        String arrJSON = "";
        List<Proyectos> listProyectos = daoProyectos.findBySpecificField("idInstancia", idInstancia , "equal", null, null);
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

        List<FormatoUnico> formatos = daoFormatoUnico.findAll();
        Iterator listaFormatos = formatos.iterator();
        List<FormatoUnico> formatosSinBaja = new ArrayList<FormatoUnico>();
        List<Instancia> listaInstancias = daoInstancia.findBySpecificField("validacionAdmin", "1", "equal", null, null);
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
                    && FU.getIdproyecto().getIdInstancia().getStatus() == (short) BigInteger.ONE.intValue())
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
        BajasTemporales bt = new BajasTemporales();
        List<FormatoUnico> formatos = daoFormatoUnico.findAll();
        List<BajaTemporal> bajasTemporales = daoBajaTemporal.findAll();
        Iterator listaFormatos = formatos.iterator();

        List<FormatoUnico> formatosBaja = new ArrayList<FormatoUnico>();
        List<BajasTemporales> formatosSinBaja = new ArrayList<BajasTemporales>();
        while (listaFormatos.hasNext())
        {
            FormatoUnico FU = (FormatoUnico) listaFormatos.next();
            if (FU.getStatusServicio() == BigInteger.ONE)
            {
                formatosBaja.add(FU);
            } else
            {
                for (BajaTemporal temporal : bajasTemporales)
                {
                    if (temporal.getDatosPersonalesId().getId().compareTo(FU.getDatosPersonalesId().getId()) == 0)
                    {
                        bt.setDatosPersonales(FU.getDatosPersonalesId());
                        bt.setFechaBaja(temporal.getFechaBaja());
                        bt.setFechaLimiteBaja(temporal.getFechaLimiteBaja());
                        bt.setPeriodo(FU.getPeriodoInicio());
                        formatosSinBaja.add(bt);
                    }
                }
            }
        }

        modelo.addAttribute("alumnos", formatosBaja);
        modelo.addAttribute("alumnosBaja", formatosSinBaja);
//        modelo.addAttribute("alumnos", formatoUnicoFacade.findBySpecificField("statusServicio", "1", "equal", null, null));
//        modelo.addAttribute("alumnosBaja", formatoUnicoFacade.findBySpecificField("statusServicio", "3", "equal", null, null));
        modelo.addAttribute("bajas", new BajasTemporales());
        modelo.addAttribute("bajasTemporales", bajasTemporales);
        return "/BajasTemporales/administrarBajas";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/guardaBaja.do")
    public String insertaBaja(@ModelAttribute("bajas") BajasTemporales baja, BindingResult resultado, Model modelo, String selectfrom, HttpSession session, HttpServletRequest request)
    {
        BajaTemporal bt = new BajaTemporal();
        fechas fechas = new fechas();
        List<BajaTemporal> listaBajas = daoBajaTemporal.findBySpecificField("datosPersonalesId", baja.getDatosPersonales().getId(), "equal", null, null);
        List<DatosPersonales> DP = daoDatosPersonales.findBySpecificField("id", baja.getDatosPersonales().getId(), "equal", null, null);
        if (listaBajas.isEmpty())
        {
            //Insertamos el registro 
            bt.setFechaBaja(baja.getFechaBaja());
            bt.setFechaLimiteBaja(baja.getFechaLimiteBaja());
            bt.setDatosPersonalesId(DP.get(0));
            daoBajaTemporal.create(bt);
            System.out.println("Se inserto la baja temporal");
        } else
        {
            BajaTemporal bajaAntigua = listaBajas.get(0);
            bajaAntigua.setFechaBaja(baja.getFechaBaja());
            bajaAntigua.setFechaLimiteBaja(baja.getFechaLimiteBaja());
            daoBajaTemporal.edit(bajaAntigua);
        }

        //Cambiamos el Status de Servicio a 3
        List<FormatoUnico> editarFU = daoFormatoUnico.findBySpecificField("datosPersonalesId", DP.get(0).getId(), "equal", null, null);
        editarFU.get(0).setStatusServicio(BigInteger.valueOf(3));
        daoFormatoUnico.edit(editarFU.get(0));
        System.out.println("Se actualizo el status de baja");

        return "redirect:administrarBajas.do";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/quitaBaja.do")
    public @ResponseBody
    String quitaBaja(int id, HttpSession session, HttpServletRequest request)
    {

        //Cambiamos el Status de Servicio a 3
        List<FormatoUnico> editarFU = daoFormatoUnico.findBySpecificField("datosPersonalesId", id, "equal", null, null);
        editarFU.get(0).setStatusServicio(BigInteger.valueOf(1));
        daoFormatoUnico.edit(editarFU.get(0));
        System.out.println("Se actualizo el status de baja");

        return "ok";
    }
}
