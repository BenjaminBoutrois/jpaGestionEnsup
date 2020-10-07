package eu.ensup.jpaGestionEnsup.presentation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
//    	Formation formationIntra = new FormationIntra("Sall", "niveau 2");
//    	Formation formationInter = new FormationInter("JPA", 8);
//    	Formation formation = new Formation("JAVASE");
//    	
//    	// 4 : Persistance objet/relationnel : création d'un enregistrement en base
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
