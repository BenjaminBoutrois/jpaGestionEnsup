package eu.ensup.service;

import java.util.List;

import javax.persistence.EntityManager;

import eu.ensup.dao.CourseDao;
import eu.ensup.dao.ICourseDao;
import eu.ensup.domaine.Course;

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
	public CourseService()
	{
		super();
		dao = new CourseDao();
	}

	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.ICourseService#associateCourse(java.lang.String, int)
	 */
	public void associateCourse(String course, int id) {
		dao.associateCourse(course, id);
	}

	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.ICourseService#getAllCourses()
	 */
	public List<Course> getAllCourses() {		
		return dao.getAllCourses();
	}
}
