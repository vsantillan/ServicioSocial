/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.controller;

import edu.servicio.toluca.beans.CartasLiberacionBean;
import edu.servicio.toluca.beans.DocumentosFinalesBean;
import edu.servicio.toluca.beans.documentosFinales.GeneraDocumento;
import edu.servicio.toluca.beans.documentosFinales.RetroalimentacionDocumentosFinales;
import edu.servicio.toluca.entidades.Documentos;
import edu.servicio.toluca.entidades.FormatoUnico;
import edu.servicio.toluca.sesion.DatosPersonalesFacade;
import edu.servicio.toluca.sesion.DocumentosFacade;
import edu.servicio.toluca.sesion.FormatoUnicoFacade;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openide.util.Exceptions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author regules
 */
@Controller
public class CartasLiberacionController 
{
    @EJB(mappedName = "java:global/ServicioSocial/DocumentosFacade")
    private DocumentosFacade documentosFacade;
    @EJB(mappedName = "java:global/ServicioSocial/FormatoUnicoFacade")
    private FormatoUnicoFacade formatoUnicoFacade;
    
    @RequestMapping(method = RequestMethod.GET, value = "/alumnosCartasLiberacion.do")
    public String alumnosCartasLiberacion(Model modelo) 
    {
        List<Documentos> listaDocum; boolean siCP=false, siFUF=false, siRF=false, siRE=false;
        List<CartasLiberacionBean> listAlumnos=new ArrayList<CartasLiberacionBean>();
        CartasLiberacionBean nuevaCarta;
        List<FormatoUnico> fu = formatoUnicoFacade.findAll();
        for (int i = 0; i < fu.size(); i++) {
            if (fu.get(i).getHorasAcumuladas().intValue() >= 480) {
                listaDocum = documentosFacade.findBySpecificField("datosPersonalesId", fu.get(i).getDatosPersonalesId(), "equal", null, null);
                System.out.println("No Control: " + fu.get(i).getDatosPersonalesId().getAlumnoId().getId());
                System.out.println("Nombre: " + fu.get(i).getDatosPersonalesId().getNombre());
                nuevaCarta=new CartasLiberacionBean();
                for (int j = 0; j < listaDocum.size(); j++) {
                    if ("Constancia_Pago".equals(listaDocum.get(j).getCatalogoDocumentosId().getTipo()) && listaDocum.get(j).getStatus().intValue()==1) {
                        siCP=true;
                    }
                    if ("Reporte_Evaluacion".equals(listaDocum.get(j).getCatalogoDocumentosId().getTipo()) && listaDocum.get(j).getStatus().intValue()==1) {
                        siRE=true;
                    }
                    if ("Reporte_Final".equals(listaDocum.get(j).getCatalogoDocumentosId().getTipo()) && listaDocum.get(j).getStatus().intValue()==1) {
                        siRF=true;
                    }
                    if ("Formato_Unico_Final".equals(listaDocum.get(j).getCatalogoDocumentosId().getTipo()) && listaDocum.get(j).getStatus().intValue()==1) {
                        siFUF=true;
                    }
                }
                if(siCP && siRF && siFUF)
                {
                    if ("S".equals(fu.get(i).getCatalogoPlanId().getDetalle()))
                    {
                        if(siRE){
                            nuevaCarta.setIdDatosPer(fu.get(i).getDatosPersonalesId().getId().intValue());
                            nuevaCarta.setNoControl(fu.get(i).getDatosPersonalesId().getAlumnoId().getId());
                            nuevaCarta.setNombreCompleto(fu.get(i).getDatosPersonalesId().getNombre()+" "+fu.get(i).getDatosPersonalesId().getApellidoP()+" "+fu.get(i).getDatosPersonalesId().getApellidoM());
                            nuevaCarta.setHorasAcumuladas(fu.get(i).getHorasAcumuladas().intValue());
                            listAlumnos.add(nuevaCarta);
                        }
                    }else if ("N".equals(fu.get(i).getCatalogoPlanId().getDetalle()))
                    {
                        nuevaCarta.setIdDatosPer(fu.get(i).getDatosPersonalesId().getId().intValue());
                        nuevaCarta.setNoControl(fu.get(i).getDatosPersonalesId().getAlumnoId().getId());
                        nuevaCarta.setNombreCompleto(fu.get(i).getDatosPersonalesId().getNombre()+" "+fu.get(i).getDatosPersonalesId().getApellidoP()+" "+fu.get(i).getDatosPersonalesId().getApellidoM());
                        nuevaCarta.setHorasAcumuladas(fu.get(i).getHorasAcumuladas().intValue());
                        listAlumnos.add(nuevaCarta);
                    }
                }
            }
        }
        modelo.addAttribute("listaCartasLiberacion", listAlumnos);
        return "/CartasLiberacion/alumnosCartasLiberacion";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/generarCartasLiberacion.pdf")
    public @ResponseBody String generarCartasLiberacion(@RequestParam(value = "arrayAlumnos[]", required = false) String [] arrayAlumnos, Model modelo,HttpServletRequest request, HttpServletResponse httpServletResponse)
    {
        for(int i=0;i<arrayAlumnos.length;i++)
        {
            System.out.println("control alumno: "+arrayAlumnos[i]);
            Map parameters = new HashMap();
            parameters.put("no_control", arrayAlumnos[i]);
            try {
                GeneraDocumento obj = new GeneraDocumento();
                obj.generar("ges_vin", "gst05a", "cartaLiberacion", parameters, request, httpServletResponse);
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        
        return "ok";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/generarCartasLiberacionAux.pdf")
    public @ResponseBody String generarCartasLiberacionAux(String no_control, Model modelo,HttpServletRequest request, HttpServletResponse httpServletResponse)
    {
        Map parameters = new HashMap();
        parameters.put("no_control", no_control);
        try {
            GeneraDocumento obj = new GeneraDocumento();
            obj.generar("ges_vin", "gst05a", "cartaLiberacion", parameters, request, httpServletResponse);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
        
        return "ok";
    }
    
}
