package manytomanym17.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanym17.dto.Course;

public class CourseDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	public void updateCourse(int id,Course course) {
		EntityManager entityManager=getEntityManager();
		Course dbCourse=entityManager.find(Course.class, id);
		if(dbCourse!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			course.setId(id);
			entityManager.merge(course);
			entityTransaction.commit();
			
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	public void findCourse(int id) {
		EntityManager entityManager=getEntityManager();
		Course dbCourse=entityManager.find(Course.class, id);
		if(dbCourse!=null) {
			System.out.println(dbCourse);
			
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	public void deleteCourse(int id) {
		EntityManager entityManager=getEntityManager();
		Course dbCourse=entityManager.find(Course.class, id);
		if(dbCourse!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbCourse);
			entityTransaction.commit();
			
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
