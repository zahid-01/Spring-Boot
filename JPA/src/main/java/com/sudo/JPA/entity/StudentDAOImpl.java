package com.sudo.JPA.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    @Autowired
    StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
//    @Transactional
    public Student retrieve(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> getByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName = :lastName",Student.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public List<Student> predicateOr(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("from Student where firstName = 'jakarta' OR firstName = 'nimda'", Student.class);

        return query.getResultList();
    }
}
