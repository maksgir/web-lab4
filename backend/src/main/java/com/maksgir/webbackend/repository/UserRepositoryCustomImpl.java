package com.maksgir.webbackend.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    public void clearPoints(long id){
        Query query = em.createQuery("delete from PointEntity where owner.id = :id");
        query.setParameter("id", id).executeUpdate();
        query.executeUpdate();
    }
}
