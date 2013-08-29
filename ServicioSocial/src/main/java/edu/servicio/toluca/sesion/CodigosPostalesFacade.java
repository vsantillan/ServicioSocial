/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.sesion;

import edu.servicio.toluca.beans.organizaciones.CiudadesJSON;
import edu.servicio.toluca.beans.organizaciones.MunicipiosJSON;
import edu.servicio.toluca.entidades.CodigosPostales;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author SATELLITE
 */
@Stateful
public class CodigosPostalesFacade extends AbstractFacade<CodigosPostales> {
    @PersistenceContext(unitName = "servicioPU", type= PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CodigosPostalesFacade() {
        super(CodigosPostales.class);
    }
    
    public MunicipiosJSON municipiosEstado(String idEstado){
        System.out.println("Query municipios de un estado");
        
        String sql = "select distinct(cp.id_municipio), m.NOMBRE from GES_VIN.CODIGOS_POSTALES cp, GES_VIN.MUNICIPIOS_SIA m where id_estado='"+idEstado+"' and m.ID_MUNICIPIO= cp.ID_MUNICIPIO and m.STATUS=1 order by nombre";
        System.out.println("SQL:"+ sql);
        Query query = (Query) em.createNativeQuery(sql);
        MunicipiosJSON municipios = new MunicipiosJSON();
        List<Object[]> registros = query.getResultList();        
        
        for (int i = 0; i < registros.size(); i++) {
            System.out.println(registros.get(i)[0] + " "+ registros.get(i)[1]);
            municipios.agregarMunicipio(registros.get(i)[0].toString(), (String) registros.get(i)[1]);
        }
        return municipios;
    }
    
     public CiudadesJSON ciudadMunicipio(String idMunicipio){
        System.out.println("Query municipios de un estado");
        
        String sql = "select distinct(cp.id_ciudad), c.nombre from GES_VIN.CODIGOS_POSTALES cp, GES_VIN.CIUDADES c where cp.ID_CIUDAD =c.ID_CIUDAD and id_municipio='"+idMunicipio+"' and c.status=1 order by nombre";
        System.out.println("SQL:"+ sql);
        Query query = (Query) em.createNativeQuery(sql);
        CiudadesJSON ciudades = new CiudadesJSON();
        List<Object[]> registros = query.getResultList();        
        
        for (int i = 0; i < registros.size(); i++) {
            System.out.println(registros.get(i)[0] + " "+ registros.get(i)[1]);
            ciudades.agregarCiudad(registros.get(i)[0].toString(), (String) registros.get(i)[1]);
        }
        return ciudades;
    }
    

    
}
