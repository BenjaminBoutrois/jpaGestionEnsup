package eu.ensup.jpaGestionEnsup.service;

import java.util.List;

import javax.persistence.EntityManager;

import eu.ensup.jpaGestionEnsup.dao.StudentDao;
import eu.ensup.jpaGestionEnsup.domaine.Student;

/**
 * Classe StudentService : Fait le lien entre le lanceur et le DAO concernant les étudiants.
 * @author 33651
 *
 */
public class StudentService
{
	// Fields
	
	private StudentDao studentDao;

	// Constructors
	
	public StudentService(EntityManager entityManager)
	{
		super();
		studentDao = new StudentDao(entityManager);
	}

	// Methods
	
	/**
	 * Crée un étudiant en base de données.
	 * @param student L'étudiant à créer.
	 */
	public void createStudent(Student student)
	{
		studentDao.createStudent(student);
	}
	
	/**
	 * Retourne un étudiant en fonction de son id.
	 * @param id L'id de l'étudiant à chercher.
	 * @return L'étudiant dont l'id correspond.
	 */
	public Student getStudent(int id)
	{
		return studentDao.getStudent(id);
	}
	
	/**
	 * Retourne un étudiant en fonction de son adresse mail.
	 * @param mail L'adresse mail de l'étudiant.
	 * @return L'étudiant dont l'adresse mail correspond.
	 */
	public Student getStudentByMail(String mail)
	{
		return studentDao.getStudentByMail(mail);
	}
	
	/**
	 * Retourne tous les étudiants de la base de données.
	 * @return La liste de tous les étudiants de la base de données.
	 */
	public List<Student> getAllStudents()
	{
		return studentDao.getAllStudents();
	}
	
	/**
	 * Supprime un étudiant de la base de données en fonction de son id.
	 * @param id L'id de l'étudiant à supprimer.
	 */
	public void deleteStudent(int id)
	{
		studentDao.deleteStudent(id);
	}
	
	/**
	 * Met à jour les données d'un étudiant.
	 * @param student Un objet étudiant avec les nouvelles données.
	 */
	public void updateStudent(Student student)
	{
		studentDao.updateStudent(student);
	}
}
