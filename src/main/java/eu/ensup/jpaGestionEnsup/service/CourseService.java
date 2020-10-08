package eu.ensup.jpaGestionEnsup.service;

import java.util.List;

import javax.persistence.EntityManager;

import eu.ensup.jpaGestionEnsup.dao.CourseDao;
import eu.ensup.jpaGestionEnsup.domaine.Course;

public class CourseService
{
	CourseDao dao;

	public CourseService(EntityManager entityManager)
	{
		super();
		dao = new CourseDao(entityManager);
	}

	/**
	 * associate course 
	 * @param course
	 * @param id
	 */
	public void associateCourse(String course, int id) {
		dao.associateCourse(course, id);
	}

	public List<Course> getAllCourses() {		
		return dao.getAllCourses();
	}
}
