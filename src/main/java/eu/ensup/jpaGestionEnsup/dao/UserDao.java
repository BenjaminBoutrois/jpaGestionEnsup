package eu.ensup.jpaGestionEnsup.dao;

import java.util.List;

import javax.persistence.EntityManager;

import eu.ensup.jpaGestionEnsup.domaine.User;

/**
 * Classe CRUD pour les utilisateurs.
 * @author 33651
 *
 */
public class UserDao
{
	// Fields
	
	private EntityManager entityManager;
	
	// Constructors
	
	/**
	 * Construit le UserDao à partir de l'entityManager.
	 * @param entityManager
	 */
	public UserDao(EntityManager entityManager)
	{
		super();
		this.entityManager = entityManager;
	}
	
	// Methods

	/**
	 * Retourne un utilisateur en fonction de son login et mot de masse.
	 * @param login Le login de l'utilisateur.
	 * @param password Le mot de passe de l'utilisateur.
	 * @return L'utilisateur dont le login et mot de passe correspondent.
	 */
	public User getUser(String login, String password)
	{
		List<User> users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
		
		return
				users
				.stream()
				.filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
				.findFirst().get();
	}
}
