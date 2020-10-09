package eu.ensup.jpaGestionEnsup.service;

import java.util.List;

import javax.persistence.EntityManager;

import eu.ensup.jpaGestionEnsup.dao.CourseDao;
import eu.ensup.jpaGestionEnsup.dao.ICourseDao;
import eu.ensup.jpaGestionEnsup.domaine.Course;

/**
 * Classe CourseService : Fait le lien entre le lanceur et le DAO concernant les cours.
 * @author 33651
 *
 */
public class CourseService implements ICourseService
{
	// Fields
	
	ICourseDao dao;

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

	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.ICourseService#associateCourse(java.lang.String, int)
	 */
	@Override
	public void associateCourse(String course, int id) {
		dao.associateCourse(course, id);
	}

	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.ICourseService#getAllCourses()
	 */
	@Override
	public List<Course> getAllCourses() {		
		return dao.getAllCourses();
	}
}
