package com.sudo.JPA.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student Order by lastName desc", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> getByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student WHERE lastName = :lastName", Student.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public List<Student> predicateOr(String fistName0, String firstName1) {
        TypedQuery<Student> query = entityManager.createQuery(
                "from Student where firstName =:firstName OR firstName =:lastName",
                Student.class);

        query.setParameter("firstName", firstName1);
        query.setParameter("firstName", firstName1);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateLastNames(String lastName) {
        var query = entityManager.createQuery("update Student set lastName = :lastName");
        query.setParameter("lastName", lastName);

        query.executeUpdate();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteByFirstName(String firstName) {
        Query query = entityManager.createQuery(
                "DELETE From Student WHERE firstName = :firstName");
        query.setParameter("firstName", firstName);

        query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteAll() {
        entityManager.createQuery("Delete FROM Student").executeUpdate();
    }


}
