package eu.ensup.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ensup.dao.IUserDao;
import eu.ensup.dao.UserDao;
import eu.ensup.domaine.User;

/**
 * Classe UserService : Fait le lien entre le lanceur et le DAO concernant les
 * utilisateurs.
 * 
 * @author 33651
 *
 */
public class UserService implements IUserService
{
	// Fields

	private static final Logger LOG = LogManager.getLogger(UserService.class);

	IUserDao dao;

	// Constructors

	/**
	 * Construit le UserService en fonction d'un entityManager.
	 * 
	 * @param entityManager
	 */
	public UserService()
	{
		super();
		LOG.info("Démarrage du service UserService");
		dao = new UserDao();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.ensup.jpaGestionEnsup.service.IUserService#getUser(java.lang.String,
	 * java.lang.String)
	 */
	public User getUser(String login, String password)
	{
		LOG.info("Appel de la méthode getUser() du dao");
		return dao.getUser(login, password);
	}
}
