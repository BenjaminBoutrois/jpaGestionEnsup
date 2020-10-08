package eu.ensup.jpaGestionEnsup.presentation;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import eu.ensup.jpaGestionEnsup.domaine.Course;
import eu.ensup.jpaGestionEnsup.domaine.Student;
import eu.ensup.jpaGestionEnsup.domaine.User;
import eu.ensup.jpaGestionEnsup.service.CourseService;
import eu.ensup.jpaGestionEnsup.service.UserService;

public class Lanceur
{
	public static void main(String[] args)
	{
		// 1 : Ouverture unité de travail JPA
    	EntityManagerFactory entityManagerFactory =
    			Persistence.createEntityManagerFactory("demojpa-pu");
    	
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
    	// 2 : Ouverture transaction
    	EntityTransaction transaction = entityManager.getTransaction();
    	transaction.begin();
    	
    	// 3 : Instanciation objet métier
    	Course course1 = new Course("GTM", 7);
    	Course course2 = new Course("Anglais", 7);
    	Course course3 = new Course("Communication", 7);
    	
    	Collection<Course> courses = new ArrayList<Course>();
    	courses.add(course1);
    	courses.add(course2);
    	
    	Student student = new Student("Benjamin", "Boutrois", "bb28@gmail.com", "14 rue Machin", "0607080910", courses);

    	// 4 : Persistance objet/relationnel : création d'un enregistrement en base
    	entityManager.persist(student);
    	entityManager.persist(course3);
    	
    	// 5 : Fermeture transaction
    	transaction.commit();
    	
    	CourseService courseService = new CourseService(entityManager);
    	
    	courseService.associateCourse(course3.getThemeCourse(), student.getId());
    	
    	System.out.println(courseService.getAllCourses());
    	
    	User user = new User("admin", "admin");
    	
    	EntityTransaction transaction2 = entityManager.getTransaction();
    	transaction2.begin();
    	
    	entityManager.persist(user);
    	
    	transaction2.commit();
    	
    	UserService userService = new UserService(entityManager);
    	
    	System.out.println(userService.getUser(user.getLogin(), user.getPassword()));
    	
    	// 6 : Fermeture unité de travail JPA
    	entityManager.close();
    	entityManagerFactory.close();
	}

}
