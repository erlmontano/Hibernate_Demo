package com.spring.hibernate_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.List;
import com.spring.hibernate_demo.dao.AppDao;
// import com.spring.hibernate_demo.dao.StudentDao;
import com.spring.hibernate_demo.entity.Course;
import com.spring.hibernate_demo.entity.Instructor;
import com.spring.hibernate_demo.entity.InstructorDetail;
import com.spring.hibernate_demo.entity.Review;
import com.spring.hibernate_demo.entity.Student;

/**
 * HibernateDemoApplication.
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
			// findInstructorDetail(app);
			// deleteInstructorDetail(app);
			// createInstructorWithCourses(app);
			// findInstructorWithCourses(app);
			// findCoursesForInstructor(app);
			// findInstructorWithCoursesJoinFetch(app);
			// updateInstructor(app);
			// deleteInstructorOnly(app);
			// createCourseAndReviews(app);
			// retrieveCourseAndReviews(app);
			// deleteCourseAndReviews(app);
			// createCourseAndStudents(app);
			// findCourseAndStudents(app);
			// findStudentAndCourses(app);
			// addMoreCoursesForStuent(app);
			// deleteCourseById(app);
			deleteStudent(app);
		};
	}

	/**
	 * Create a student.
	 * @param app
	 */
	// private void createStudent(StudentDao studentDao) {
	// 	System.out.println("Creating student information...");
	// 	Student student = new Student("Light", "Yagami", 
	// "light.yagami@example.com");
	// 	System.out.println("Saving student information...");
	// 	studentDao.save(student);
	// 	System.out.println("Saved! Generated id: " + student.getId());
	// }


	/**
	 * Read Student from database.
	 * @param app
	 */
	// private void readStudent(StudentDao studentDao) {
	// 	System.out.println("Retrieving student id 2...");
	// 	Student student = studentDao.findById(2);
	// 	System.out.println("Found the student " + student);
	// }

	/**
	 * Query student.
	 * @param app
	 */
	// private void queryStudents(StudentDao studentDao) {
	// 	List<Student> students = studentDao.findAll();
	// 	for(Student s:students) {
	// 		System.out.println(s);
	// 	}
	// }

	/**
	 * Query student by their last name.
	 * @param app
	 */
	// private void queryStudentLastName(StudentDao studentDao) {
	// 	List<Student> students = studentDao.findByLastName("Yagamata");
	// 	for(Student s : students){
	// 		System.out.println(s);
	// 	}
	// }

	/**
	 * Update student information.
	 * @param app
	 */
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

	/**
	 * delete student.
	 * @param app
	 */
	// private void deleteStudent(StudentDao studentDao) {
	// 	int id = 5;
	// 	System.out.println("Delete ID: " + id);

	// 	studentDao.delete(id);
	// }

	/**
	 * Delete all student in the database.
	 * @param app
	 */
	// private void deleteAllStudent(StudentDao studentDao){
	// 	System.out.println("Deleting all student information...");
	// 	int rowsDeleted = studentDao.deleteAll();
	// 	System.out.println("Number of deleted rows: " + rowsDeleted);
	// }

	/**
	 * Create instructor.
	 * @param app
	 */
	private void createInstructor(AppDao app){
		//create the instructor and details
		Instructor ins = new Instructor("Carbon", "Nara", 
		"carbon@example.com");
		InstructorDetail deets = new InstructorDetail("Food", 
		"How to Cook");

		//associate the objects
		ins.setInstructorDeets(deets);

		//save the intructor
		//this will also save the detalils object
		//because of the CascaseType.ALL

		System.out.println("Information saved!");
		app.save(ins);
	}

	/**
	 * find the specific instructor in the database.
	 * @param app
	 */
	private void findInstructor(AppDao app){
		int id = 4;
		System.out.println("Find id: " + id);

		Instructor ins = app.findInstructorById(id);

		System.out.println("Instructor: " + ins);
		System.out.println("Details: " + ins.getInstructorDeets());
	}

	/**
	 * Delete instructor from database.
	 * @param app
	 */
	private void deleteInstructor(AppDao app){
		int id = 3; 
		System.out.println("Delete id: " + id);

		app.deleteInstructorId(id);
		System.out.println("Deleted successfully!");
	}

	/**
	 * Find instructor detail.
	 * @param app
	 */
	private void findInstructorDetail(AppDao app){
		// get the instructor detail object
		int id = 3;
		InstructorDetail inDeets = app.findInstructorDetailById(id);

		//print the instructor detail
		System.out.println("Details: " + inDeets);

		//print the associated instructor
		System.out.println("Instructor: " + inDeets.getInstructor());
	}

	/**
	 * delete instructor detail.
	 * @param app
	 */
	private void deleteInstructorDetail(AppDao app){
		int id = 6	;
		System.out.println("Delete id: " + id);

		app.deleteInstructorDetail(id);
		System.out.println("Deleted successfully!");
	}

	/**
	 * create instructor with their courses.
	 * @param app
	 */
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

	/**
	 * find instructor with course in databse.
	 * @param app
	 */
	private void findInstructorWithCourses(AppDao app) {
		int id = 24;
		System.out.println("Find instructor id: " + id);

		Instructor ins = app.findInstructorById(id);

		System.out.println("Instructor: " + ins);
		System.out.println("Courses: " + ins.getCourses());
	}

	/**
	 * find courses with instructor.
	 * @param app
	 */
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

	/**
	 * find instructor with courses using join fetch.
	 * @param app
	 */
	private void findInstructorWithCoursesJoinFetch(AppDao app){
		int id = 11;
		System.out.println("Find instructor id: " + id);
		Instructor ins = app.findInstructorByIdJoinFetch(id);
		System.out.println("Instructor: " + ins);
		System.out.println("Courses: " + ins.getCourses());
	}

	/**
	 * update instructor in database.
	 * @param app
	 */
	private void updateInstructor(AppDao app) {
		int id = 6;
		System.out.println("Find instructor id: " + id);
		Instructor ins = app.findInstructorById(id);

		//change instructor's data
		ins.setFirstName("Verde");

		//update the data
		System.out.println("Update!");
		app.update(ins);
	}

	/**
	 * delete instructor only.
	 * @param app
	 */
	private void deleteInstructorOnly(AppDao app){
		int id = 10;
		System.out.println("Delete instructor: " + id);

		// Instructor instructor = app.findInstructorById(id);
		app.deleteInstructorById(id);
		System.out.println("Deleted successfully");
	}

	/**
	 * create course with review.
	 * @param app
	 */
	private void createCourseAndReviews(AppDao app) {
		//create a course
		Course course = new Course("How to Speed Run String in 1 Day");

		//add some reviews
		course.addReview(new Review("Great speed 2x...loved it!!!"));
		course.addReview(new Review("I wanted the speed 0.75x :(("));
		course.addReview(new Review(
			"Hoping to do a speed of 3x :D. Anyways, nice"));
		
		//save the course
		System.out.println("Course saved!");
		app.save(course);
	}

	/**
	 * retrieve course and reviews.
	 * @param app
	 */
	private void retrieveCourseAndReviews(AppDao app){
		int id = 4;
		System.out.println("Get course and reviews from id: " + id);
		//get the course and reviews
		Course course = app.findCourseAndReviewsByCourseId(id);

		//print the course
		System.out.println(course);

		//print the reviews
		System.out.println(course.getReview());
	}

	/**
	 * delete course and reviews.
	 * @param app
	 */
	private void deleteCourseAndReviews(AppDao app){
		int id = 3;
		System.out.println("Delete course: " + id);

		app.deleteCourseById(id);
		System.out.println("Deleted Successfully");
	}

	/**
	 * create course and students.
	 * @param app
	 */
	private void createCourseAndStudents(AppDao app) {
		//create a course
		Course course = new Course("How to Be A FullStack Dev in Half a Day");

		//create the students
		Student student1 = new Student("Blue", "Ranger", 
		"blue.ranger@example.com");
		Student student2 = new Student("Barats", "Sher", 
		"bara.sher@example.com");

		//add student to the course
		course.addStudent(student1);
		course.addStudent(student2);

		//save the course and associated students
		app.save(course);
		System.out.println("Successfully enrolled");
	}

	/**
	 * find course and student
	 * @param app
	 */
	private void findCourseAndStudents(AppDao app) {
		int id = 6;

		Course course = app.findCourseAndStudentByCourseId(id);

		System.out.println("Course: " + course);
		System.out.println("Students: " + course.getStudents());
	}

	/**
	 * find students with courses.
	 * @param app
	 */
	private void findStudentAndCourses(AppDao app){
		int id = 4;
		Student student = app.findStudentAndCoursesByStudentId(id);

		System.out.println("Student: " + student);
		System.out.println("Courses: " + student.getCourses());
	}

	/**
	 * add more courses.
	 * @param app
	 */
	private void addMoreCoursesForStuent(AppDao app) {
		int id = 4;

		Student student = app.findStudentAndCoursesByStudentId(id);

		Course course1 = new Course(
			"How to Test without Running Application");
		Course course2 = new Course(
			"How to Develop without Computer");
		Course course3 = new Course(
			"How to be a Legit Developer");

		student.addCourse(course1);
		student.addCourse(course2);
		student.addCourse(course3);
		
		System.out.println("Successfully enrolled to new courses!");

		app.update(student);
	}

	/**
	 * delete course.
	 * @param app
	 */
	private void deleteCourseById(AppDao app){
		int id = 5;

		System.out.println("Delete course: " + id);

		app.deleteCourseById(id);
		System.out.println("Deleted successfully");
	}
	
	/**
	 * delete a student from the database.
	 * @param app
	 */
	private void deleteStudent(AppDao app){
		int id = 5;
		System.out.println("Delete Student: " + id);

		app.deleteStudentById(id);
		System.out.println("Deleted Successfully!");
	}
}
