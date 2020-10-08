package eu.ensup.jpaGestionEnsup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import eu.ensup.jpaGestionEnsup.domaine.Student;

public class StudentDao
{
	// Fields
	
	private EntityManager entityManager;
	
	// Constructors

	public StudentDao(EntityManager entityManager)
	{
		super();
		this.entityManager = entityManager;
	}
	
	// Methods
	
	public void createStudent(Student student)
	{
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(student);
		
		entityTransaction.commit();
	}
	
	public Student getStudent(int id)
	{
		return entityManager.find(Student.class, id);
	}
	
	public Student getStudentByMail(String mail)
	{
		List<Student> students = entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
		
		return
				students
				.stream()
				.filter(s -> s.getMailAddress().equals(mail))
				.findFirst().get();
	}

	public List<Student> getAllStudents()
	{
		return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
	}
	
	public void deleteStudent(int id)
	{
		Student student = getStudent(id);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.remove(student);
		
		entityTransaction.commit();
	}
	
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
		oldStudent.setCourses(newStudent.getCourses());
		
		entityTransaction.commit();
	}
}
