package com.example.springboot.cruddemo;

import com.example.springboot.cruddemo.dao.AppDAO;
import com.example.springboot.cruddemo.entity.Course;
import com.example.springboot.cruddemo.entity.Instructor;
import com.example.springboot.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {

//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
//			createInstructorWithCourses(appDAO);
//			findInstructorWithCourses(appDAO);
//			findCoursesForInstructor(appDAO);
//			findInstructorWithCoursesJoinFetch(appDAO);
//			updateInstructor(appDAO);

//			updateCourse(appDAO);

//			deleteInstructor(appDAO);

			deleteCourse(appDAO);
		};

	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		//delete the course by id
		System.out.println("Deleted course with id: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Deleted course");
	}
	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		//get the course by id
		Course tempCourse = appDAO.findCourseById(theId);
		System.out.println("Found course: " + tempCourse);
		System.out.println("The associated instructor only: " + tempCourse.getInstructor());
		//update the course
		tempCourse.setTitle("Java - The Ultimate Guide");
		appDAO.update(tempCourse);
		System.out.println("Updated course: " + tempCourse);
	}
	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		//get the instructor by id
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Found instructor: " + tempInstructor);
//		System.out.println("The associated instructorDetail only: " + tempInstructor.getInstructorDetail());
//		System.out.println("The associated courses: " + tempInstructor.getCourses());
		//update the instructor
		tempInstructor.setFirstName("TESTER");
		tempInstructor.setLastName("NEW TESTER");
		appDAO.update(tempInstructor);
		System.out.println("Updated instructor: " + tempInstructor);

	}
	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;
		//get the instructor by id
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("Found instructor: " + tempInstructor);
//		System.out.println("The associated instructorDetail only: " + tempInstructor.getInstructorDetail());
		System.out.println("The associated courses: " + tempInstructor.getCourses());
	}
	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		//get the courses for the instructor
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Found instructor: " + tempInstructor);

		//find courses for instructor
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		// associate the objects
		tempInstructor.setCourses(courses);
		System.out.println("the assosicated courses: " + tempInstructor.getCourses());
	}
	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		//get the instructor by id
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Found instructor: " + tempInstructor);
		System.out.println("The associated instructorDetail only: " + tempInstructor.getInstructorDetail());
		System.out.println("The associated courses: " + tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		//create an instructor object
		Instructor tempInstructor = new Instructor("Susan", "Public", "susan@luv2code.com");
		//create an instructor detail object
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Games");
		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//save the instructor
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("Saving courses: " + tempInstructor.getCourses());

		appDAO.save(tempInstructor);
		System.out.println("Saved instructor: ");


	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		//delete the instructor detail by id
		System.out.println("Deleted instructor detail with id: " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Deleted instructor detail");
	}
	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		//get the instructor detail by id
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("Found instructor detail: " + tempInstructorDetail);
		System.out.println("The associated instructor only: " + tempInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO){
		int theId = 1;
		//delete the instructor by id
		System.out.println("Deleted instructor with id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Deleted instructor");

	}

	private void findInstructor(AppDAO appDAO){
		int theId = 1;
		//get the instructor by id
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Found instructor: " + tempInstructor);
		System.out.println("The associated instructorDetail only: " + tempInstructor.getInstructorDetail());
	}
	private void createInstructor(AppDAO appDAO){
		/*
		//create an instructor object
		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
		//create an instructor detail object
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");

		 */
		//create an instructor object
		Instructor tempInstructor = new Instructor("Madhu", "Patel", "darby@luv2code.com");
		//create an instructor detail object
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Guitar");
		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		//save the instructor this will also save the instructor detail object because of CascadeType.ALL
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Saved instructor");
	}

}
