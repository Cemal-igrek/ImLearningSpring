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
        return runner -> {
//		createStudent(studentDAO);
//		createMultipleStudents(studentDAO);
//		readStudent(studentDAO);
//		queryForStudents(studentDAO);
            queryForStudentsByLastName(studentDAO);
        };
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> tempStudent = studentDAO.findByLastName("igrek");
        for (Student student : tempStudent) {
            System.out.println("Found student : " + student);
        }

    }

    private void queryForStudents(StudentDAO studentDAO) {
        //get a list of Students
        List<Student> theStudents = studentDAO.findAll();
//		studentDAO.findAll().forEach(System.out::println);
        for (Student student : theStudents) {
            System.out.println("Found student : " + student);
        }

    }

    private void readStudent(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("c.igrek63@hotmail.com", "igrek", "Cemal");

        //save the student object
        System.out.println("Saving student...");
        studentDAO.save(tempStudent);
        //display id of the save student
        System.out.println("Student saved and his id is " + tempStudent.getId());
        //retrieve student based on the id:Primary key
        System.out.println("Retrieving student with id:" + tempStudent.getId());
        Student myStudent = studentDAO.findById(tempStudent.getId());
        //display student
        System.out.println("Found student : " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        //create multiple students
        System.out.println("Creating 3 student objects...");
        Student tempStudent1 = new Student("c.igrek631@hotmail.com", "igre1k", "Cemal1");
        Student tempStudent2 = new Student("c.igrek632@hotmail.com", "Öncü", "Idil");
        Student tempStudent3 = new Student("c.igrek633@hotmail.com", "igrek", "Mehmet Ali");

        //save the student objects
        System.out.println("Saving the students...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void createStudent(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new student...");
        Student tempStudent = new Student("c.igrek63@hotmail.com", "igrek", "Cemal");

        //save the student object
        System.out.println("Saving student...");
        studentDAO.save(tempStudent);
        //display id of the save student
        System.out.println("Student saved and his id is " + tempStudent.getId());
    }
}
