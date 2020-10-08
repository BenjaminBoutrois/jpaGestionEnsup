package eu.ensup.jpaGestionEnsup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import eu.ensup.jpaGestionEnsup.domaine.Student;

/**
 * Classe CRUD pour les étudiants.
 * @author 33651
 *
 */
public class StudentDao
{
	// Fields
	
	private EntityManager entityManager;
	
	// Constructors

	/**
	 * Construit la classe StudentDao à partir de l'entityManager.
	 * @param entityManager
	 */
	public StudentDao(EntityManager entityManager)
	{
		super();
		this.entityManager = entityManager;
	}
	
	// Methods
	
	/**
	 * Crée un étudiant dans la base de données.
	 * @param student L'instance d'entité Student à créer.
	 */
	public void createStudent(Student student)
	{
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(student);
		
		entityTransaction.commit();
	}
	
	/**
	 * Retourne un étudiant en fonction de son id.
	 * @param id L'id de l'étudiant à chercher.
	 * @return L'étudiant dont l'id correspond.
	 */
	public Student getStudent(int id)
	{
		return entityManager.find(Student.class, id);
	}
	
	/**
	 * Retourne un étudiant en fonction de son adresse mail.
	 * @param mail Une chaîne de caractères représentant l'adresse mail à chercher.
	 * @return L'étudiant dont l'adresse mail correspond.
	 */
	public Student getStudentByMail(String mail)
	{
		List<Student> students = entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
		
		return
				students
				.stream()
				.filter(s -> s.getMailAddress().equals(mail))
				.findFirst().get();
	}

	/**
	 * Retourne la liste de tous les étudiants de la table student.
	 * @return La liste de tous les étudiants de la table student.
	 */
	public List<Student> getAllStudents()
	{
		return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
	}
	
	/**
	 * Supprime un étudiant de la base de données.
	 * @param id L'id de l'étudiant à supprimer.
	 */
	public void deleteStudent(int id)
	{
		Student student = getStudent(id);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.remove(student);
		
		entityTransaction.commit();
	}
	
	/**
	 * Met à jour les données d'un étudiant.
	 * @param newStudent L'objet Student contenant les données du nouvel étudiant.
	 */
	public void updateStudent(Student newStudent)
	{
		Student oldStudent = getStudent(newStudent.getId());
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		oldStudent.setFirstName(newStudent.getFirstName());
		oldStudent.setLastName(newStudent.getLastName());
		oldStudent.setAddress(newStudent.getAddress());
		oldStudent.setMailAddress(newStudent.getMailAddress());
		oldStudent.setNumberPhone(newStudent.getNumberPhone());
		oldStudent.setBirthDate(newStudent.getBirthDate());
		oldStudent.setCourses(newStudent.getCourses());
		
		entityTransaction.commit();
	}
}
