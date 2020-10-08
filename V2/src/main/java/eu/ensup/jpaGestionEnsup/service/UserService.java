package eu.ensup.jpaGestionEnsup.service;

import javax.persistence.EntityManager;

import eu.ensup.jpaGestionEnsup.dao.UserDao;
import eu.ensup.jpaGestionEnsup.domaine.User;

/**
 * Classe UserService : Fait le lien entre le lanceur et le DAO concernant les utilisateurs.
 * @author 33651
 *
 */
public class UserService
{
	// Fields
	
	UserDao dao;
	
	// Constructors

	/**
	 * Construit le UserService en fonction d'un entityManager.
	 * @param entityManager
	 */
	public UserService(EntityManager entityManager)
	{
		super();
		dao = new UserDao(entityManager);
	}
	
	/**
	 * Retourne un utilisateur en fonction de son login et son mot de passe.
	 * @param login Le login de l'utilisateur à chercher.
	 * @param password Le mot de passe de l'utilisateur à chercher.
	 * @return L'utilisateur correspondant au login et mot de passe.
	 */
	public User getUser(String login, String password)
	{
		return dao.getUser(login, password);
	}
}
