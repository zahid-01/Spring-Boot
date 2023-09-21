package com.sudo.JPA.entity;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student retrieve(int id);

    List<Student> getAll();

    List<Student> getByLastName(String lastName);
    List<Student> predicateOr(String firstName0, String firstName1);
    void updateLastNames(String lastName);

    void update(Student student);

    void deleteByFirstName(String firstName);

    void deleteAll();
}
