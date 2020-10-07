package eu.ensup.jpaGestionEnsup.presentation;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import eu.ensup.jpaGestionEnsup.domaine.Course;
import eu.ensup.jpaGestionEnsup.domaine.Student;

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
    	
    	Collection<Course> courses = new ArrayList<Course>();
    	courses.add(course1);
    	courses.add(course2);
    	
    	Student student = new Student("Benjamin", "Boutrois", "bb28@gmail.com", "14 rue Machin", "0607080910", courses);
//    	Formation formationIntra = new FormationIntra("Sall", "niveau 2");
//    	Formation formationInter = new FormationInter("JPA", 8);
//    	Formation formation = new Formation("JAVASE");
//    	
//    	// 4 : Persistance objet/relationnel : création d'un enregistrement en base
    	entityManager.persist(student);
//    	entityManager.persist(formationIntra);
//    	entityManager.persist(formationInter);
//    	entityManager.persist(formation);
    	
    	// 5 : Fermeture transaction
    	transaction.commit();
    	
    	// 6 : Fermeture unité de travail JPA
    	entityManager.close();
    	entityManagerFactory.close();
	}

}
