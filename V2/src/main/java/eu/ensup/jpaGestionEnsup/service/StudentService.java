package eu.ensup.jpaGestionEnsup.service;

import java.util.List;

import javax.persistence.EntityManager;

import eu.ensup.jpaGestionEnsup.dao.IStudentDao;
import eu.ensup.jpaGestionEnsup.dao.StudentDao;
import eu.ensup.jpaGestionEnsup.domaine.Student;

/**
 * Classe StudentService : Fait le lien entre le lanceur et le DAO concernant les étudiants.
 * @author 33651
 *
 */
public class StudentService implements IStudentService
{
	// Fields
	
	private IStudentDao studentDao;

	// Constructors
	
	public StudentService(EntityManager entityManager)
	{
		super();
		studentDao = new StudentDao(entityManager);
	}

	// Methods
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#createStudent(eu.ensup.jpaGestionEnsup.domaine.Student)
	 */
	@Override
	public void createStudent(Student student)
	{
		studentDao.createStudent(student);
	}
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#getStudent(int)
	 */
	@Override
	public Student getStudent(int id)
	{
		return studentDao.getStudent(id);
	}
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#getStudentByMail(java.lang.String)
	 */
	@Override
	public Student getStudentByMail(String mail)
	{
		return studentDao.getStudentByMail(mail);
	}
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#getAllStudents()
	 */
	@Override
	public List<Student> getAllStudents()
	{
		return studentDao.getAllStudents();
	}
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#deleteStudent(int)
	 */
	@Override
	public void deleteStudent(int id)
	{
		studentDao.deleteStudent(id);
	}
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#updateStudent(eu.ensup.jpaGestionEnsup.domaine.Student)
	 */
	@Override
	public void updateStudent(Student student)
	{
		studentDao.updateStudent(student);
	}
}
