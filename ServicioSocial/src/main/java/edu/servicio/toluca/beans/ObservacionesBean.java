/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.beans;

import edu.servicio.toluca.entidades.CatalogoObservaciones;
import edu.servicio.toluca.entidades.Noticias;
import edu.servicio.toluca.sesion.CatalogoObservacionesFacade;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Héctor
 */
public class ObservacionesBean {
    private CatalogoObservacionesFacade catalogoObservacionesFacade;
    //tipo 0:Eliminado 1: Formato Unico 2: Reportes Bimestrales 3:Documentos Finales
    public ObservacionesBean(CatalogoObservacionesFacade catalogoObservacionesFacade){
        this.catalogoObservacionesFacade=catalogoObservacionesFacade;
    }
    
    public List<CatalogoObservaciones> ConsultaTodas(){
        List<CatalogoObservaciones> crude = catalogoObservacionesFacade.findAll();
        for (int i=0; i<crude.size(); i++) {
            if (crude.get(i).getTipo()== BigInteger.ZERO) crude.remove(i);
        }
        return crude;
    }
    
    /**
     * Consulta las observaciones para el formato unico
     * @param orden desc o asc
     * @return 
     */
    public List<CatalogoObservaciones> ConsultaObservacionesFormatoUnico(String orden){
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();

        if (orden.equals("desc")) {
            ordenamiento.put("fecha", "desc");
        }
        if (orden.equals("asc")) {
            ordenamiento.put("fecha", "asc");
        }
        return catalogoObservacionesFacade.findBySpecificField("tipo", "1", "equal", ordenamiento , null);
    }
    
    public List<CatalogoObservaciones> ConsultaObservacionesUsuario(String orden){
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();
        if (orden.equals("desc")) {
            ordenamiento.put("fecha", "desc");
        }
        if (orden.equals("asc")) {
            ordenamiento.put("fecha", "asc");
        }
        return catalogoObservacionesFacade.findBySpecificField("tipo", "6", "equal", ordenamiento , null);
    }
    
    /**
     * Consulta las observaciones para reportes bimestrales
     * @param orden desc o asc
     * @return 
     */
    public List<CatalogoObservaciones> ConsultaObservacionesReportesBimestrales(String orden){
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();

        if (orden.equals("desc")) {
            ordenamiento.put("fecha", "desc");
        }
        if (orden.equals("asc")) {
            ordenamiento.put("fecha", "asc");
        }
        return catalogoObservacionesFacade.findBySpecificField("tipo", "2", "equal", ordenamiento , null);
    }
    
    /**
     * Consulta las observaciones para documentos finales
     * @param orden desc o asc
     * @return 
     */
    public List<CatalogoObservaciones> ConsultaObservacionesDocumentosFinales(String orden){
        LinkedHashMap<String, String> ordenamiento = new LinkedHashMap<String, String>();

        if (orden.equals("desc")) {
            ordenamiento.put("fecha", "desc");
        }
        if (orden.equals("asc")) {
            ordenamiento.put("fecha", "asc");
        }
        return catalogoObservacionesFacade.findBySpecificField("tipo", "2", "equal", ordenamiento , null);
    }
}
