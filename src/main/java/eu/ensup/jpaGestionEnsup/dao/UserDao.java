package eu.ensup.jpaGestionEnsup.dao;

import java.util.List;

import javax.persistence.EntityManager;

import eu.ensup.jpaGestionEnsup.domaine.User;

public class UserDao
{
	// Fields
	
	private EntityManager entityManager;
	
	// Constructors
	
	public UserDao(EntityManager entityManager)
	{
		super();
		this.entityManager = entityManager;
	}
	
	// Methods

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
