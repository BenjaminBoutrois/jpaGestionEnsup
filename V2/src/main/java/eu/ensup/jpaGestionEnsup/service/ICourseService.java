package eu.ensup.jpaGestionEnsup.service;

import java.util.List;

import eu.ensup.jpaGestionEnsup.domaine.Course;

public interface ICourseService
{

	/**
	 * Associe un cours à un étudiant.
	 * @param course Le cours à associer.
	 * @param id L'id de l'étudiant à qui associer le cours.
	 */
	void associateCourse(String course, int id);

	/**
	 * Retourne tous les cours de la base de données.
	 * @return La liste des cours de la base de données.
	 */
	List<Course> getAllCourses();

}