package eu.ensup.jpaGestionEnsup.service;

import javax.persistence.EntityManager;

import eu.ensup.jpaGestionEnsup.dao.IUserDao;
import eu.ensup.jpaGestionEnsup.dao.UserDao;
import eu.ensup.jpaGestionEnsup.domaine.User;

/**
 * Classe UserService : Fait le lien entre le lanceur et le DAO concernant les utilisateurs.
 * @author 33651
 *
 */
public class UserService implements IUserService
{
	// Fields
	
	IUserDao dao;
	
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
	
	/* (non-Javadoc)
	 * @see eu.ensup.jpaGestionEnsup.service.IUserService#getUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User getUser(String login, String password)
	{
		return dao.getUser(login, password);
	}
}
