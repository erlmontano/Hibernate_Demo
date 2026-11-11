package com.spring.hibernate_demo.dao;

import com.spring.hibernate_demo.entity.Student;
import java.util.List;

/**
 * Operation for student changes.
 */
public interface StudentDao {

    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastname);
    void save(Student thStudent);
    void update(Student thStudent);
    void delete(Integer id);
    int deleteAll();

}
