package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		//java lambda expression
		return runner -> {
//			createStudent(studentDAO);

			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};

	}
	private void deleteAllStudents(StudentDAO studentDAO) {
		//delete all students
		System.out.println("Deleting all students");
		int numRowsDeleted= studentDAO.deleteAll();
		System.out.println("Number of rows deleted: " + numRowsDeleted);
	}
	private void deleteStudent(StudentDAO studentDAO) {
		//delete student
		int studentId = 1;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.delete(studentId);
	}
	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		//change first name to "Scooby"
		System.out.println("Updating student...");
		myStudent.setFirstName("Scooby");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get all students
		System.out.println("Getting all students with last name of Doe");
//		List<Student> theStudents = studentDAO.findByLastName("Doe");

		//display list of students
		studentDAO.findByLastName("Doe").forEach(System.out::println);
	}
	private void queryForStudents(StudentDAO studentDAO) {
		//get all students
		System.out.println("Getting all students");
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
//		studentDAO.findAll().forEach(System.out::println);
		for(Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating a new student");
		Student student = new Student("Daffy", "Duck", "daffy@gmail.com");

		//save the student
		System.out.println("Saving the student");
		studentDAO.save(student);
		//display id of the saved student
	int theId = student.getId();
		System.out.println("Saved student. Generated id: " + theId);
		//find student by id
		System.out.println("Finding student by id");
		Student myStudent = studentDAO.findById(theId);
		System.out.println("Found student: " + myStudent);
	}
	private void createMultipleStudents(StudentDAO studentDAO) {
		//create students
		System.out.println("Creating multiple students");
		Student student1 = new Student("John", "Doe", "john1@gmail.com");
		Student student2 = new Student("Mary", "Public", "mary@gmail.com");
		Student student3 = new Student("Bon", "Jovi", "bon@gmail.com");

		//save objects
		System.out.println("Saving students");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

	}
	private void createStudent(StudentDAO studentDAO) {
		//create a student
		System.out.println("Creating a new student");
		Student student = new Student("Paul", "Wall", "paul@gmail.com");


		//save the student
		System.out.println("Saving the student");
		studentDAO.save(student);
		//display id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());
	}
}
