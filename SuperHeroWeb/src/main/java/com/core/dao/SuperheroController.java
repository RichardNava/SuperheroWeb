package com.core.dao;

import com.core.entities.Superhero;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

public class SuperheroController extends LazyDataModel<Superhero> {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(name = "SuperHeroesWebPU")
    private EntityManager em;

    public SuperheroController(EntityManager em) {
        this.em = em;
    } 
    
    public List<Superhero> findAllSuperheroes() {
        return em.createQuery("SELECT s FROM Superhero s").getResultList();
    }

    @Override
    public int count(Map<String, FilterMeta> map) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Superhero> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filters) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Superhero.class);
        Root<Superhero> root = cq.from(Superhero.class);
        
        if(sortBy!=null && !sortBy.isEmpty()){
            List<Order> orderList = new ArrayList<>();
            for (Map.Entry<String, SortMeta> entry : sortBy.entrySet()) {
                String field = entry.getKey();
                SortMeta sortMeta = entry.getValue();
                SortOrder sortOrder = sortMeta.getOrder();

                Order order = (sortOrder == SortOrder.ASCENDING) ? cb.asc(root.get(field)) : cb.desc(root.get(field));
                orderList.add(order);
            }
            cq.orderBy(orderList);
        }
        System.out.println(cq);
        TypedQuery<Superhero> query = em.createQuery(cq);
        
        query.setFirstResult(first);
        query.setMaxResults(pageSize);
        
        return findAllSuperheroes();     
    }

}
