package com.spring.hibernate_demo.dao;

import com.spring.hibernate_demo.entity.Course;
import com.spring.hibernate_demo.entity.Instructor;
import com.spring.hibernate_demo.entity.InstructorDetail;
import com.spring.hibernate_demo.entity.Student;
import java.util.List;

/**
 * 
 * AppDao.
 */

public interface AppDao {

    Instructor findInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    List<Course> findCoursesByInstructorId(int theId);
    Instructor findInstructorByIdJoinFetch(int theId);
    Course findCourseAndReviewsByCourseId(int theId);
    Course findCourseAndStudentByCourseId(int theId);
    Student findStudentAndCoursesByStudentId(int theId);
    void save(Instructor theInstructor);
    void deleteInstructorId(int theId);
    void deleteInstructorDetail(int theId);
    void update(Instructor theInstructor);
    void deleteInstructorById(int theId);
    void save(Course theCourse);
    void deleteCourseById(int theId);
    void update(Student theStudent);
    void deleteStudentById(int theId);
}
