package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
	return runner -> {
//		createStudent(studentDAO);
		createMultipleStudents(studentDAO);
	};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("c.igrek631@hotmail.com","igre1k","Cemal1");
		Student tempStudent2 = new Student("c.igrek632@hotmail.com","Öncü","Idil");
		Student tempStudent3 = new Student("c.igrek633@hotmail.com","igrek","Mehmet Ali");

		//save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student...");
		Student tempStudent = new Student("c.igrek63@hotmail.com","igrek","Cemal");

		//save the student object
		System.out.println("Saving student...");
		studentDAO.save(tempStudent);
		//display id of the save student
		System.out.println("Student saved and his id is " + tempStudent.getId());
	}
}
