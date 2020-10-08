package eu.ensup.jpaGestionEnsup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import eu.ensup.jpaGestionEnsup.domaine.Course;
import eu.ensup.jpaGestionEnsup.domaine.Student;

public class CourseDao
{
	// Fields
	
	private EntityManager entityManager;

	// Constructors
	
	public CourseDao(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	// Methods
	
	public void associateCourse(String courseTheme, int idStudent)
	{
    	Student student = entityManager.find(Student.class, idStudent);
    	
    	if (student == null)
    	{
    		System.out.println("Cet id n'est attribué à aucun étudiant.");
    		return;
    	}
    	
    	// Ouverture transaction
    	EntityTransaction transaction = entityManager.getTransaction();
    	transaction.begin();
    	
    	student.getCourses().add(entityManager.find(Course.class, courseTheme));
    	
//    	entityManager.persist(student);

    	// Fermeture transaction
    	transaction.commit();
	}

	public List<Course> getAllCourses()
	{
    	return entityManager.createQuery("SELECT * FROM course", Course.class).getResultList();
	}
}
