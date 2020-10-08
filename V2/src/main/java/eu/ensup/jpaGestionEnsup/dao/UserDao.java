package eu.ensup.jpaGestionEnsup.dao;

import java.util.List;

import javax.persistence.EntityManager;

import eu.ensup.jpaGestionEnsup.domaine.User;

/**
 * Classe CRUD pour les utilisateurs.
 * @author 33651
 *
 */
public class UserDao implements IUserDao
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

	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.dao.IUserDao#getUser(java.lang.String, java.lang.String)
	 */
	@Override
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
