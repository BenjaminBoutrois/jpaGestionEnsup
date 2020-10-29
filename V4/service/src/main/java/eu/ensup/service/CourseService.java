package eu.ensup.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ensup.dao.CourseDao;
import eu.ensup.dao.ICourseDao;
import eu.ensup.domaine.Course;

/**
 * Classe CourseService : Fait le lien entre le lanceur et le DAO concernant les
 * cours.
 * 
 * @author 33651
 *
 */
public class CourseService implements ICourseService
{
	// Fields
 
    private static final Logger LOG = LogManager.getLogger(CourseService.class);

	ICourseDao dao;

	// Constructors

	/**
	 * Construit le CourseService en fonction de l'entityManager.
	 * 
	 * @param entityManager
	 */
	public CourseService()
	{
		super();
		LOG.info("Démarrage du service CourseService");
		dao = new CourseDao();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.ensup.jpaGestionEnsup.service.ICourseService#associateCourse(java.lang.
	 * String, int)
	 */
	public void associateCourse(String course, int id)
	{
		LOG.info("Appel de la méthode associateCourse() du dao");
		dao.associateCourse(course, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.service.ICourseService#getAllCourses()
	 */
	public List<Course> getAllCourses()
	{
		LOG.info("Appel de la méthode getAllCourses() du dao");
		return dao.getAllCourses();
	}
}
