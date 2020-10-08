package eu.ensup.jpaGestionEnsup.dao;

import java.util.List;

import javax.persistence.EntityManager;

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
	
	public void createStudent()
	{
		
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

}
