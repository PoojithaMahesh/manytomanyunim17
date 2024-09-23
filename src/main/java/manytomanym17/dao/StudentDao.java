package manytomanym17.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanym17.dto.Course;
import manytomanym17.dto.Student;

public class StudentDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	public void updateStudent(int id,Student  student) {
		EntityManager entityManager=getEntityManager();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
		
			
			student.setId(id);
			student.setCourses(dbStudent.getCourses());
			
			entityManager.merge(student);
			entityTransaction.commit();
			
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	
	public void findStudent(int id) {
		EntityManager entityManager=getEntityManager();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
			System.out.println(dbStudent);
			
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	public void deleteStudent(int id) {
		EntityManager entityManager=getEntityManager();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();	
			entityManager.remove(dbStudent);
			entityTransaction.commit();
			
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
