package com.spring.hibernate_demo.dao;

import com.spring.hibernate_demo.entity.Student;
import java.util.List;

/**
 * Operation for student changes.
 */
public interface StudentDao {

    void save(Student thStudent);

    Student findById(Integer id);

    List<Student> findAll();
    List<Student> findByLastName(String lastname);

    void update(Student thStudent);

    void delete(Integer id);
    int deleteAll();

}
