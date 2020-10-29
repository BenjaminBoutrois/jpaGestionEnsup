package eu.ensup.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ensup.dao.IStudentDao;
import eu.ensup.dao.StudentDao;
import eu.ensup.domaine.Student;

/**
 * Classe StudentService : Fait le lien entre le lanceur et le DAO concernant les étudiants.
 * @author 33651
 *
 */
public class StudentService implements IStudentService
{
	// Fields
 
    private static final Logger LOG = LogManager.getLogger(StudentService.class);
	
	private IStudentDao studentDao;

	// Constructors
	
	public StudentService()
	{
		super();
		LOG.info("Démarrage du service StudentService");
		studentDao = new StudentDao();
	}

	// Methods
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#createStudent(eu.ensup.jpaGestionEnsup.domaine.Student)
	 */
	public void createStudent(Student student)
	{
		LOG.info("Appel de la méthode createStudent() du dao");
		studentDao.createStudent(student);
	}
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#getStudent(int)
	 */
	public Student getStudent(int id)
	{
		LOG.info("Appel de la méthode getStudent() du dao");
		return studentDao.getStudent(id);
	}
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#getStudentByMail(java.lang.String)
	 */
	public Student getStudentByMail(String mail)
	{
		LOG.info("Appel de la méthode getStudentByMail() du dao");
		return studentDao.getStudentByMail(mail);
	}
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#getAllStudents()
	 */
	public List<Student> getAllStudents()
	{
		LOG.info("Appel de la méthode getAllStudents() du dao");
		return studentDao.getAllStudents();
	}
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#deleteStudent(int)
	 */
	public void deleteStudent(int id)
	{
		LOG.info("Appel de la méthode deleteStudent() du dao");
		studentDao.deleteStudent(id);
	}
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.IStudentService#updateStudent(eu.ensup.jpaGestionEnsup.domaine.Student)
	 */
	public void updateStudent(int oldStudentId, Student student)
	{
		LOG.info("Appel de la méthode updateStudent() du dao");
		studentDao.updateStudent(oldStudentId, student);
	}
	
	/**
	 * Recherche un ou plusieurs étudiants en fonction de leur données.
	 * @param firstName Le prénom du ou des étudiants à chercher.
	 * @param lastName Le nom de famille du ou des étudiants à chercher.
	 * @return La liste des étudiants correspondant au prénom et au nom entrés.
	 */
	public List<Student> searchStudent(String firstName, String lastName)
	{
		LOG.info("Appel de la méthode searchStudent() du dao");
		return studentDao.searchStudent(firstName, lastName);
	}
}
