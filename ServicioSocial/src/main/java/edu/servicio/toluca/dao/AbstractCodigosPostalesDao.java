/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.servicio.toluca.dao;

import edu.servicio.toluca.beans.organizaciones.CiudadesJSON;
import edu.servicio.toluca.beans.organizaciones.MunicipiosJSON;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author Jorge Muñoz
 */
public class AbstractCodigosPostalesDao <T extends Serializable>
{
    private final int MAX_RECORDS_RETURNED = 50000;
    
    private Class<T> entityClass;
    
    @PersistenceContext(type=PersistenceContextType.EXTENDED)
    EntityManager entityManager;
    
    public EntityManager getEntityMgr()
    {
        return entityManager;
    }
    
    public void setClass(Class<T> classToSet)
    {
        this.entityClass = classToSet;
    }
    
    public int count()
    {
        javax.persistence.criteria.CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(entityManager.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = entityManager.createQuery(cq);
        return Integer.valueOf(q.getSingleResult().toString());
    }
    
    @Transactional
    public void create(T entity)
    {
        entityManager.persist(entity);
    }
    
    public void deleteById(Object id)
    {
        T entity = find(id);
        remove(entity);
    }
    
    @Transactional
    public T edit(T entity)
    {
        return entityManager.merge(entity);
    }
    
    public T find(Object id)
    {
        return entityManager.find(entityClass, id);
    }

    public List<T> findAll()
    {
        javax.persistence.criteria.CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return entityManager.createQuery(cq).getResultList();
    }
    
    /**
     * Obtiene todos los registros para una entidad dada ordenados con los
     * criterios establecidos a traves de la lista <code>ordering</code>
     * 
     * @param ordering : ["fieldName", "ASC" | "DESC"] <br>
     *                   (if != "ASC" se utiliza "DESC" por default)
     * 
     * @return Registros recuperados ordenados mediante los criterios dados
     */
    public List<T> findAll(LinkedHashMap<String, String> ordering)
    {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        Root<T> root = cq.from(entityClass);
        cq.select(root);
        
        if(ordering != null)
        {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            Set<String> set = ordering.keySet();
            List<Order> orders = new ArrayList<Order>();
            for(String orderingField : set)
            {
                Order order = (ordering.get(orderingField).equals("ASC")) ?
                        cb.asc(root.get(orderingField)) :
                        cb.desc(root.get(orderingField));
                orders.add(order);
            }
            
            cq.orderBy(orders);
        }
        
        return entityManager.createQuery(cq)
                .setMaxResults(MAX_RECORDS_RETURNED)
                .getResultList();
    }
    
    public List<T> findBySpecificField(String field, Object fieldContent, String predicates,
            LinkedHashMap<String, String> ordering, LinkedList<String> grouping)
    {
//        if(entityClass == FormatoUnico.class)
//        {
//            entityManager.flush();
//            entityManager.clear();
//        }
        
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<T> root = cq.from(entityClass);
        Predicate predicate = null;
        
        if(predicates.equals("equal"))
        {
            predicate = cb.equal(root.get(field), fieldContent);
        }
        else if(predicates.equals("likelower"))
        {
            predicate = cb.like(cb.lower(root.<String>get(field)), fieldContent.toString());
        }
        else if(predicates.equals("like"))
        {
            predicate = cb.like(root.<String>get(field), "%"+fieldContent.toString()+"%");
        }
        
        cq.select(root);
        cq.where(predicate);
        
        if(ordering != null)
        {
            Set<String> set = ordering.keySet();
            List<Order> orders = new ArrayList<Order>();
            for(String orderingField : set)
            {
                Order order;
                if(ordering.get(orderingField).equals("ASC"))
                {
                    order = cb.asc(root.get(orderingField));
                }
                else
                {
                    order = cb.desc(root.get(orderingField));
                }
                orders.add(order);
            }
            cq.orderBy(orders);
        }
        
        if(grouping != null)
        {
            Iterator iterator = grouping.iterator();
            List<Expression> groups = new LinkedList<Expression>();
            while(iterator.hasNext())
            {
                groups.add(root.get(iterator.next().toString()));
            }
            cq.groupBy(groups);
        }
        
        Query query = entityManager.createQuery(cq);
        query.setMaxResults(MAX_RECORDS_RETURNED);
        
        return query.getResultList();
    }
    
    public List<T> findRange(int[] range)
    {
        javax.persistence.criteria.CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = entityManager.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
    
    @Transactional
    public void remove(T entity)
    {
        entityManager.remove(entity);
    }
    
   public MunicipiosJSON municipiosEstado(String idEstado){
        System.out.println("Query municipios de un estado");
        
        String sql = "select distinct(cp.id_municipio), m.NOMBRE from GES_VIN.CODIGOS_POSTALES cp, GES_VIN.MUNICIPIOS_SIA m where id_estado='"+idEstado+"' and m.ID_MUNICIPIO= cp.ID_MUNICIPIO and m.STATUS=1 order by nombre";
        System.out.println("SQL:"+ sql);
        Query query = (Query) entityManager.createNativeQuery(sql);
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
        Query query = (Query) entityManager.createNativeQuery(sql);
        CiudadesJSON ciudades = new CiudadesJSON();
        List<Object[]> registros = query.getResultList();        
        
        for (int i = 0; i < registros.size(); i++) {
            System.out.println(registros.get(i)[0] + " "+ registros.get(i)[1]);
            ciudades.agregarCiudad(registros.get(i)[0].toString(), (String) registros.get(i)[1]);
        }
        return ciudades;
    }
     
    
}
