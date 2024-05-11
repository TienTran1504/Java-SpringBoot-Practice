package com.example.springboot.cruddemo;

import com.example.springboot.cruddemo.dao.AppDAO;
import com.example.springboot.cruddemo.entity.Instructor;
import com.example.springboot.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			findInstructorDetail(appDAO);
		};
	}

	private void findInstructorDetail(AppDAO appDAO) {

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
