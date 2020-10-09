package eu.ensup.jpaGestionEnsup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import eu.ensup.jpaGestionEnsup.domaine.Course;
import eu.ensup.jpaGestionEnsup.domaine.Student;

/**
 * Classe CRUD pour les cours.
 * @author 33651
 *
 */
public class CourseDao implements ICourseDao
{
	// Fields
	
	private EntityManager entityManager;

	// Constructors
	
	/**
	 * Construit le CourseDao à partir de l'entityManager.
	 * @param entityManager
	 */
	public CourseDao(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	// Methods
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.dao.ICourseDao#associateCourse(java.lang.String, int)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.dao.ICourseDao#getAllCourses()
	 */
	@Override
	public List<Course> getAllCourses()
	{
    	return entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
	}
}
