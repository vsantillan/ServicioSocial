/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.servicio.toluca.sesion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jonny
 * @param <T>
 */
public abstract class AbstractFacade<T>
{

    private Class<T> entityClass;
    private final int MAX_RECORDS_RETURNED = 50000;

    public AbstractFacade(Class<T> entityClass)
    {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity)
    {
        getEntityManager().persist(entity);
    }

    public void edit(T entity)
    {
        getEntityManager().merge(entity);

    }

    public void remove(T entity)
    {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id)
    {
        getEntityManager().flush();
        getEntityManager().clear();
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll()
    {
        getEntityManager().flush();
        getEntityManager().clear();
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findAll(LinkedHashMap<String, String> ordering)
    {
        getEntityManager().flush();
        getEntityManager().clear();
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        Root<T> root = cq.from(entityClass);
        cq.select(root);
        //cq.select(cq.from(entityClass));
        if (ordering != null)
        {
            CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
            //Root<T> root = cq.from(entityClass);
            Set<String> set = ordering.keySet();
            List<Order> orders = new ArrayList<Order>();
            for (String orderingField : set)
            {
                Order order;
                if (ordering.get(orderingField).equals("asc"))
                {
                    order = criteriaBuilder.asc(root.get(orderingField));
                } else
                {
                    order = criteriaBuilder.desc(root.get(orderingField));
                }
                orders.add(order);
            }
            cq.orderBy(orders);
        }
        return getEntityManager().createQuery(cq).setMaxResults(MAX_RECORDS_RETURNED).getResultList();
    }

    public List<T> findRange(int[] range)
    {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count()
    {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<T> findBySpecificField(String field, Object fieldContent, String predicates, LinkedHashMap<String, String> ordering, LinkedList<String> grouping)
    {
        getEntityManager().flush();
        getEntityManager().clear();
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<T> root = criteriaQuery.from(entityClass);

        Predicate predicate = null;

        if (predicates.equals("equal"))
        {
            predicate = criteriaBuilder.equal(root.get(field), fieldContent);
        } else if (predicates.equals("likelower"))
        {
            predicate = criteriaBuilder.like(criteriaBuilder.lower(root.<String>get(field)), fieldContent.toString());
        } else if (predicates.equals("like"))
        {
            predicate = criteriaBuilder.like(root.<String>get(field), "%" + fieldContent.toString() + "%");
        }

        criteriaQuery.select(root);
        criteriaQuery.where(predicate);

        if (ordering != null)
        {
            Set<String> set = ordering.keySet();
            List<Order> orders = new ArrayList<Order>();
            for (String orderingField : set)
            {
                Order order;
                if (ordering.get(orderingField).equals("asc"))
                {
                    order = criteriaBuilder.asc(root.get(orderingField));
                } else
                {
                    order = criteriaBuilder.desc(root.get(orderingField));
                }
                orders.add(order);
            }
            criteriaQuery.orderBy(orders);
        }

        if (grouping != null)
        {
            Iterator iterator = grouping.iterator();
            List<Expression> groups = new LinkedList<Expression>();
            while (iterator.hasNext())
            {
                groups.add(root.get(iterator.next().toString()));
            }
            criteriaQuery.groupBy(groups);
        }

        Query query = getEntityManager().createQuery(criteriaQuery);
        query.setMaxResults(MAX_RECORDS_RETURNED);

        return query.getResultList();
    }
}
