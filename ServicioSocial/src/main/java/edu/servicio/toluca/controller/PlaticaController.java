/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.Fecha;
import edu.servicio.toluca.entidades.Platica;
import edu.servicio.toluca.entidades.LugaresPlatica;
import edu.servicio.toluca.sesion.PlaticaFacade;
import edu.servicio.toluca.sesion.LugaresPlaticaFacade;
import edu.servicio.toluca.beans.ValidacionAsistenciaPlatica;
import edu.servicio.toluca.entidades.FoliosPlatica;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import javax.ejb.EJB;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.servicio.toluca.beans.PlaticaJson;
import edu.servicio.toluca.entidades.VistaAlumno;
import edu.servicio.toluca.sesion.FoliosPlaticaFacade;
import edu.servicio.toluca.sesion.VistaAlumnoFacade;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Mary
 */
@Controller
public class PlaticaController {

    @EJB(mappedName = "java:global/ServicioSocial/PlaticaFacade")
    private PlaticaFacade platicaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/LugaresPlaticaFacade")
    private LugaresPlaticaFacade lugaresPlaticaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/FoliosPlaticaFacade")
    private FoliosPlaticaFacade foliosPlaticaFacade;
    @EJB(mappedName = "java:global/ServicioSocial/VistaAlumnoFacade")
    private VistaAlumnoFacade vistaAlumnoFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/altaPlatica.do")
    public String altaPlatica(Model modelo) {
        Fecha anio = new Fecha();
        modelo.addAttribute("anioInicio", anio.anioActual());
        modelo.addAttribute("anioFin", anio.anioFin());
        modelo.addAttribute("platica", new Platica());
        modelo.addAttribute("lugares", lugaresPlaticaFacade.findAll());
        return "/Platicas/altaPlatica";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/consultasBajas.do")
    public String consultasBajas(Model model) {
        LinkedHashMap ordenarDesc = new LinkedHashMap();
        ordenarDesc.put("fecha", "desc");

        model.addAttribute("platica", platicaFacade.findBySpecificField("status", "1", "equal", ordenarDesc, null));
        return "/Platicas/consultasBajas";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/capturarAsistencia.do")
    public String capturarAsistencia(Model modelo) {

        modelo.addAttribute("foliosPlatica", new FoliosPlatica());
        return "/Platicas/capturarAsistencia";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/asistenciaPosteriorEspecial.do")
    public String AsistenciaPosteriorEspecial(Model a) {
        return "/Platicas/asistenciaPosteriorEspecial";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/seleccionarPlatica.do")
    public String seleccionarPlatica(Model modelo) {

        modelo.addAttribute("platicasPeriodo", platicaFacade.platicasPeriodo());
        modelo.addAttribute("platica", new Platica());
        return "/Platicas/seleccionarPlatica";
    }
       @RequestMapping(method = RequestMethod.GET, value = "/altaLugares.do")
    public String altaLugares(Model modelo) {
        modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
        return "/Platicas/lugaresPlatica";
    }

    // metodo para validar fecha, va colocado antes del metodo que invoca a @valid
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true);
        binder.registerCustomEditor(Date.class, editor);
        // binder.registerCustomEditor(LugaresPlatica.class, new PropertyEditorSupport());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/altaPlaticaBD.do")
    public String insertarPlatica(@Valid Platica platica, BindingResult result, Model modelo) throws ParseException {

        platica.setNumeroAsistentes(0);

        if (result.hasErrors()) {
            Fecha anio = new Fecha();
            modelo.addAttribute("anioInicio", anio.anioActual());
            modelo.addAttribute("anioFin", anio.anioFin());
            modelo.addAttribute("lugares", lugaresPlaticaFacade.findAll());
            return "/Platicas/altaPlatica";
        } else {
            platicaFacade.create(platica);
            return "/Platicas/redirectAltaPlatica";
        }


    }

    @RequestMapping(method = RequestMethod.GET, value = "/folioPlatica.do")
    public String folioPlatica(Model a, String fecha) {

        System.out.println("fecha platica id:" + fecha);
        FoliosPlatica foliosPlatica = new FoliosPlatica();
        Platica platica = new Platica();
        platica.setId(Long.parseLong(fecha));

        foliosPlatica.setPlaticaId(platica);
        //folio: numero de control+idPlatica
        foliosPlatica.setNumeroFolio("hola");
        foliosPlatica.setStatus((short) 1);
        //incrementar numero de asistentes +1

        foliosPlaticaFacade.create(foliosPlatica);


        return "/Platicas/reporte";
        //return "/PanelUsuario/panelUsuario";
    }
/////////ASISTENCIA.DO////////////////////

    @RequestMapping(value = "asistencia.do", method = RequestMethod.POST)
    public String Asistencia(@Valid FoliosPlatica foliosPlatica, BindingResult result, Model modelo) throws IOException {

        if (result.hasErrors()) {
            //modelo.addAttribute("folio", new FoliosPlatica());
            //System.out.println("hubo errores asistencia do");
            return "/Platicas/capturarAsistencia";

        } else {
            // System.out.println("no hubo errores asistencia do---"+foliosPlatica.getNumeroFolio());
            List<FoliosPlatica> lista = foliosPlaticaFacade.findBySpecificField("numeroFolio", foliosPlatica.getNumeroFolio(), "equal", null, null);

            /// System.out.println("despues de facade---");
            if (lista.size() > 0) {
                foliosPlatica = foliosPlaticaFacade.find(lista.get(0).getId());
                System.out.println("find folio---" + lista.get(0).getId());
                foliosPlatica.setAsistencia((short) 1);
                foliosPlaticaFacade.edit(foliosPlatica);
                
                String id="11280476";
        
                VistaAlumno vistaAlumno1;
                vistaAlumno1 = vistaAlumnoFacade.find(id);
                System.out.print("alumno"+vistaAlumno1.getCurp());
                ByteArrayOutputStream bs= new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream (bs);
                os.writeObject(vistaAlumno1.getFoto());  // this es de tipo DatoUdp
                os.close();
                
                byte[] bytes =  bs.toByteArray(); // devuelve byte[]
                
                
                modelo.addAttribute("foto", Base64.encodeBase64String(bytes));
               // modelo.addAttribute("foto", bytes);
                return "/Platicas/capturarAsistencia2";
            } else {
                modelo.addAttribute("foliosPlatica", new FoliosPlatica());
                modelo.addAttribute("existe", "No existe numero de folio");
                return "/Platicas/capturarAsistencia";
            }
        }

    }
    /////////ASISTENCIA.DO  finnnnnnnnnnnnnnnnnnnnnnnn////////////////////

    @RequestMapping(method = RequestMethod.POST, value = "/eliminarPlatica.do")
    public void eliminarPlatica(long id_platica) throws ParseException {
        //System.out.print("eliminar platica.do");
        Platica platica = new Platica();
        platica.setId(id_platica);
        platicaFacade.remove(platica);


    }

 

    @RequestMapping(method = RequestMethod.POST, value = "/altaLugarBD.do")
  public String altaLugaresBD(@Valid LugaresPlatica lugares, BindingResult result,Model modelo) {
  if (result.hasErrors()) {
      
        return "/Platicas/lugaresPlatica";
  }
  else{
        lugaresPlaticaFacade.create(lugares);
        modelo.addAttribute("lugaresPlatica", new LugaresPlatica());
        return "/Platicas/lugaresPlatica";
    }
    }
    //metodo para cambiar informacion de platica dinamicamente en seleccionarPlatica
    @RequestMapping(method = RequestMethod.POST, value = "/actualizarDetalle.do")
    public @ResponseBody
    PlaticaJson actualizarDetalle(String fecha, Model modelo) {
        //System.out.println("fecha:"+fecha);
        PlaticaJson platicaJson = new PlaticaJson();
        modelo.addAttribute("lugaresPlatica", new LugaresPlatica());

        Platica platica = platicaFacade.find(Long.parseLong(fecha));
        platicaJson.setDetalle("Hora:" + platica.getHora() + "\t" + "Lugar:" + platica.getIdLugar().getLugar());
        platicaJson.setDescripcion("Descripción:" + platica.getDescripcion());
        return platicaJson;
    }
////PRUEBA DE FOTO!!!!!!!!!!!!!!!!!!!!!!!
    @RequestMapping(value = "/guardarFoto.do", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("vistaAlumno") VistaAlumno vistaAlumno,
            @RequestParam("file") MultipartFile file) throws IOException {
        
        System.out.println("id:" + vistaAlumno.getId());
        String id=vistaAlumno.getId();
        
        VistaAlumno vistaAlumno1;
        vistaAlumno1 = vistaAlumnoFacade.find(id);
        System.out.println("find:" + vistaAlumno.getApellidoPat());
        vistaAlumno1.setFoto(file.getBytes());

        vistaAlumnoFacade.edit(vistaAlumno1);


        return "/Platicas/guardarFoto";
    }

    @RequestMapping(value = "/guardaFotoPrueba.do")
    public String guardaFotoPrueba(Model modelo) {
        modelo.addAttribute("vistaAlumno", new VistaAlumno());
        return "/Platicas/guardarFoto";
    }
    //// fin          PRUEBA DE FOTO!!!!!!!!!!!!!!!!!!!!!!!
}
