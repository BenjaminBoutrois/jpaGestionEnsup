package eu.ensup.jpaGestionEnsup.service;

import javax.persistence.EntityManager;

import eu.ensup.jpaGestionEnsup.dao.UserDao;
import eu.ensup.jpaGestionEnsup.domaine.User;

public class UserService
{
	UserDao dao;

	public UserService(EntityManager entityManager)
	{
		super();
		dao = new UserDao(entityManager);
	}
	
	public User getUser(String login, String password)
	{
		return dao.getUser(login, password);
	}
}
