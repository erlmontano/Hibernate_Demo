package com.spring.hibernate_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.List;

import com.spring.hibernate_demo.dao.AppDao;
import com.spring.hibernate_demo.dao.StudentDao;
import com.spring.hibernate_demo.entity.Course;
import com.spring.hibernate_demo.entity.Instructor;
import com.spring.hibernate_demo.entity.InstructorDetail;
import com.spring.hibernate_demo.entity.Student;

/**
 * HibernateDemoApplication
 */
@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

	// @Bean
	// CommandLineRunner commandLineRunner(StudentDao studentDao) {
	// 	return runner -> {
	// 		// createStudent(studentDao);
	// 		// readStudent(studentDao);
	// 		// queryStudents(studentDao);
	// 		// queryStudentLastName(studentDao);
	// 		// updateStudent(studentDao);
	// 		// deleteStudent(studentDao);
	// 		// deleteAllStudent(studentDao);
	// 	};
	// }

	@Bean
	CommandLineRunner commandLineRunner(AppDao app){
		return runner -> {
			// createInstructor(app);
			// findInstructor(app);
			// // deleteInstructor(app);
			// findInstructorDetal(app);
			// deleteInstructorDetail(app);
			// createInstructorWithCourses(app);
			// findInstructorWithCourses(app);
			// findCoursesForInstructor(app);
			findInstructorWithCoursesJoinFetch(app);
		};
	}

	// private void createStudent(StudentDao studentDao) {
	// 	System.out.println("Creating student information...");
	// 	Student student = new Student("Light", "Yagami", "light.yagami@example.com");
	// 	System.out.println("Saving student information...");
	// 	studentDao.save(student);
	// 	System.out.println("Saved! Generated id: " + student.getId());
	// }

	// private void readStudent(StudentDao studentDao) {
	// 	System.out.println("Retrieving student id 2...");
	// 	Student student = studentDao.findById(2);
	// 	System.out.println("Found the student " + student);
	// }

	// private void queryStudents(StudentDao studentDao) {
	// 	List<Student> students = studentDao.findAll();
	// 	for(Student s:students) {
	// 		System.out.println(s);
	// 	}
	// }

	// private void queryStudentLastName(StudentDao studentDao) {
	// 	List<Student> students = studentDao.findByLastName("Yagamata");
	// 	for(Student s : students){
	// 		System.out.println(s);
	// 	}
	// }

	// private void updateStudent(StudentDao studentDao) {
	// 	int id = 1;
	// 	System.out.println("Student ID: " + id);
	// 	Student student = studentDao.findById(id);
		
	// 	System.out.println("Updating Student name...");
	// 	student.setFirstName("Red");
	// 	student.setLastName("Akagami");
	// 	student.setEmail("redakagami@example.com");
	// 	studentDao.update(student);

	// 	System.out.println("Updated student information: " + student);
	// }

	// private void deleteStudent(StudentDao studentDao) {
	// 	int id = 5;
	// 	System.out.println("Delete ID: " + id);

	// 	studentDao.delete(id);
	// }

	// private void deleteAllStudent(StudentDao studentDao){
	// 	System.out.println("Deleting all student information...");
	// 	int rowsDeleted = studentDao.deleteAll();
	// 	System.out.println("Number of deleted rows: " + rowsDeleted);
	// }

	private void createInstructor(AppDao app){
		//create the instructor and details
		Instructor ins = new Instructor("Carbon", "Nara", "carbon@example.com");
		InstructorDetail deets = new InstructorDetail("Food", "How to Cook");

		//associate the objects
		ins.setInstructorDeets(deets);

		//save the intructor
		//this will also save the detalils object
		//because of the CascaseType.ALL

		System.out.println("Information saved!");
		app.save(ins);
	}

	private void findInstructor(AppDao app){
		int id = 4;
		System.out.println("Find id: " + id);

		Instructor ins = app.findInstructorById(id);

		System.out.println("Instructor: " + ins);
		System.out.println("Details: " + ins.getInstructorDeets());
	}

	private void deleteInstructor(AppDao app){
		int id = 3; 
		System.out.println("Delete id: " + id);

		app.deleteInstructorId(id);
		System.out.println("Deleted successfully!");
	}

	private void findInstructorDetal(AppDao app){
		// get the instructor detail object
		int id = 3;
		InstructorDetail inDeets = app.findInstructorDetailById(id);

		//print the instructor detail
		System.out.println("Details: " + inDeets);

		//print the associated instructor
		System.out.println("Instructor: " + inDeets.getInstructor());
	}

	private void deleteInstructorDetail(AppDao app){
		int id = 6	;
		System.out.println("Delete id: " + id);

		app.deleteInstructorDetail(id);
		System.out.println("Deleted successfully!");
	}

	private void createInstructorWithCourses(AppDao app){
		//create the instructor and details
		Instructor ins = new Instructor("Kurt",
										"Waldheim",
										"kurt.wald@example.com");
		
		InstructorDetail deets = new InstructorDetail("Science",
													  "Sprinkling wota");
		
		//associate the objects
		ins.setInstructorDeets(deets);

		//create courses
		Course course1 = new Course("Physics");
		Course course2 = new Course("Drug Chemistry");

		//add course to instructor
		ins.add(course1);
		ins.add(course2);

		//save the instructor
		System.out.println("Course saved: " + ins.getCourses());
		app.save(ins);
	}

	private void findInstructorWithCourses(AppDao app) {
		int id = 24;
		System.out.println("Find instructor id: " + id);

		Instructor ins = app.findInstructorById(id);

		System.out.println("Instructor: " + ins);
		System.out.println("Courses: " + ins.getCourses());
	}

	private void findCoursesForInstructor(AppDao app){
		int id = 5;

		//find the instructor
		System.out.println("Find instructor id: " + id);
		Instructor ins = app.findInstructorById(id);

		System.out.println("Instructor: " + ins);

		//find courses for instructor
		System.out.println("Courses from id: " + id);
		List<Course> courses = app.findCoursesByInstructorId(id);

		//associate the objects
		ins.setCourses(courses);

		//get the courses
		System.out.println(ins.getCourses());
	}

	private void findInstructorWithCoursesJoinFetch(AppDao app){
		int id = 11;
		System.out.println("Find instructor id: " + id);
		Instructor ins = app.findInstructorByIdJoinFetch(id);
		System.out.println("Instructor: " + ins);
		System.out.println("Courses: " + ins.getCourses());
	}
}
