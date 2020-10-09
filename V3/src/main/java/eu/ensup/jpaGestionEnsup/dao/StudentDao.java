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
public class StudentDao implements IStudentDao
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
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.dao.IStudentDao#createStudent(eu.ensup.jpaGestionEnsup.domaine.Student)
	 */
	@Override
	public void createStudent(Student student)
	{
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(student);
		
		entityTransaction.commit();
	}
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.dao.IStudentDao#getStudent(int)
	 */
	@Override
	public Student getStudent(int id)
	{
		return entityManager.find(Student.class, id);
	}
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.dao.IStudentDao#getStudentByMail(java.lang.String)
	 */
	@Override
	public Student getStudentByMail(String mail)
	{
		List<Student> students = entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
		
		return
				students
				.stream()
				.filter(s -> s.getMailAddress().equals(mail))
				.findFirst().get();
	}

	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.dao.IStudentDao#getAllStudents()
	 */
	@Override
	public List<Student> getAllStudents()
	{
		return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
	}
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.dao.IStudentDao#deleteStudent(int)
	 */
	@Override
	public void deleteStudent(int id)
	{
		Student student = getStudent(id);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.remove(student);
		
		entityTransaction.commit();
	}
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.dao.IStudentDao#updateStudent(eu.ensup.jpaGestionEnsup.domaine.Student)
	 */
	@Override
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
