package eu.ensup.jpaGestionEnsup.service;

import java.util.List;

import javax.persistence.EntityManager;

import eu.ensup.jpaGestionEnsup.dao.CourseDao;
import eu.ensup.jpaGestionEnsup.domaine.Course;

/**
 * Classe CourseService : Fait le lien entre le lanceur et le DAO concernant les cours.
 * @author 33651
 *
 */
public class CourseService
{
	// Fields
	
	CourseDao dao;

	// Constructors
	
	/**
	 * Construit le CourseService en fonction de l'entityManager.
	 * @param entityManager
	 */
	public CourseService(EntityManager entityManager)
	{
		super();
		dao = new CourseDao(entityManager);
	}

	/**
	 * Associe un cours à un étudiant.
	 * @param course Le cours à associer.
	 * @param id L'id de l'étudiant à qui associer le cours.
	 */
	public void associateCourse(String course, int id) {
		dao.associateCourse(course, id);
	}

	/**
	 * Retourne tous les cours de la base de données.
	 * @return La liste des cours de la base de données.
	 */
	public List<Course> getAllCourses() {		
		return dao.getAllCourses();
	}
}
