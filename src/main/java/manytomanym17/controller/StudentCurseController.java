package manytomanym17.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanym17.dto.Course;
import manytomanym17.dto.Student;

public class StudentCurseController {
public static void main(String[] args) {
	
	Course course1=new Course();
	course1.setId(1);
	course1.setName("Java");
	course1.setFees(5000);
	
	Course course2=new Course();
	course2.setId(2);
	course2.setName("AdvJava");
	course2.setFees(5000);
	
	Course course3=new Course();
	course3.setId(3);
	course3.setName("sql");
	course3.setFees(5000);
	
	Student student1=new Student();
	student1.setId(1);
	student1.setName("Swati");
	student1.setAddress("Banga");
	
	List<Course> courses=new ArrayList<Course>();
	courses.add(course1);
	courses.add(course2);
	courses.add(course3);
	
	student1.setCourses(courses);
	
	Student student2=new Student();
	student2.setId(2);
	student2.setName("poojitha");
	student2.setAddress("Banga");
	
	student2.setCourses(courses);
	
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(course1);
	entityManager.persist(course2);
	entityManager.persist(course3);
	entityManager.persist(student1);
	entityManager.persist(student2);
	
	entityTransaction.commit();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
