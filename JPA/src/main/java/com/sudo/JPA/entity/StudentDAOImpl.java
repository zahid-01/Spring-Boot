package com.sudo.JPA.entity;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private final EntityManager entityManager;

    @Autowired
    StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }
}
