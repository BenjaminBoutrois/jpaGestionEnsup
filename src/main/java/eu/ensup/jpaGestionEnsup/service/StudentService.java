package eu.ensup.jpaGestionEnsup.service;

import java.util.List;

import javax.persistence.EntityManager;

import eu.ensup.jpaGestionEnsup.dao.StudentDao;
import eu.ensup.jpaGestionEnsup.domaine.Student;

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
	
	public void createStudent(Student student)
	{
		studentDao.createStudent(student);
	}
	
	public Student getStudent(int id)
	{
		return studentDao.getStudent(id);
	}
	
	public Student getStudentByMail(String mail)
	{
		return studentDao.getStudentByMail(mail);
	}
	
	public List<Student> getAllStudents()
	{
		return studentDao.getAllStudents();
	}
	
	public void deleteStudent(int id)
	{
		studentDao.deleteStudent(id);
	}
	
	public void updateStudent(Student student)
	{
		studentDao.updateStudent(student);
	}
}
