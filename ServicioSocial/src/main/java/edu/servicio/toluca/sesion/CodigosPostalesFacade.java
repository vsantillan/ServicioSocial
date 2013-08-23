/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.sesion;

import edu.servicio.toluca.beans.Fecha;
import edu.servicio.toluca.entidades.CodigosPostales;
import edu.servicio.toluca.entidades.MunicipiosSia;
import edu.servicio.toluca.entidades.Platica;
import java.util.ArrayList;
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
    
    public List<Platica> platicasPeriodo() {
        Fecha fecha = new Fecha();
        String periodo = fecha.CalculaPeriodoPrueba();
        System.out.println("periodo platica actual_" + periodo);

        String sql = "select * from platica where status=1 and periodo='" + periodo + "'" + "  and fecha >=(select sysdate -1 from dual) and tipo=1";
        Query query = (Query) em.createNativeQuery(sql, Platica.class);
        List<Platica> lista = query.getResultList();
        List<Platica> listaPlatica = new ArrayList<Platica>();

//    System.out.println("-------------------------"+lista.size()); 
        for (int i = 0; i < lista.size(); i++) {
            listaPlatica.add(lista.get(i));
        }
        return listaPlatica;

    }
    
    public List<MunicipiosSia> municipiosEstado(String idEstado){
        System.out.println("Query municipios de un estado");
        
        String sql = "select distinct(cp.id_municipio), m.NOMBRE from GES_VIN.CODIGOS_POSTALES cp, GES_VIN.MUNICIPIOS_SIA m where id_estado='"+idEstado+"' and m.ID_MUNICIPIO= cp.ID_MUNICIPIO order by nombre";
        Query query = (Query) em.createNamedQuery(sql, MunicipiosSia.class);
        List<MunicipiosSia> municipios = new ArrayList<MunicipiosSia>();
        List<MunicipiosSia> registros = query.getResultList();
        
        for (int i = 0; i < registros.size(); i++) {
            System.out.println(registros.get(i).getIdMunicipio());
            
        }
        return municipios;
    }
    
}
