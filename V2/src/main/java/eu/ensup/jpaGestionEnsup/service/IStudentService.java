package eu.ensup.jpaGestionEnsup.service;

import java.util.List;

import eu.ensup.jpaGestionEnsup.domaine.Student;

public interface IStudentService
{

	/**
	 * Crée un étudiant en base de données.
	 * @param student L'étudiant à créer.
	 */
	void createStudent(Student student);

	/**
	 * Retourne un étudiant en fonction de son id.
	 * @param id L'id de l'étudiant à chercher.
	 * @return L'étudiant dont l'id correspond.
	 */
	Student getStudent(int id);

	/**
	 * Retourne un étudiant en fonction de son adresse mail.
	 * @param mail L'adresse mail de l'étudiant.
	 * @return L'étudiant dont l'adresse mail correspond.
	 */
	Student getStudentByMail(String mail);

	/**
	 * Retourne tous les étudiants de la base de données.
	 * @return La liste de tous les étudiants de la base de données.
	 */
	List<Student> getAllStudents();

	/**
	 * Supprime un étudiant de la base de données en fonction de son id.
	 * @param id L'id de l'étudiant à supprimer.
	 */
	void deleteStudent(int id);

	/**
	 * Met à jour les données d'un étudiant.
	 * @param student Un objet étudiant avec les nouvelles données.
	 */
	void updateStudent(Student student);

}