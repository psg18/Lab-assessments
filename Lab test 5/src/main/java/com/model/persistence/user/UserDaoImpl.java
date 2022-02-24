package com.model.persistence.user;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.exceptions.DataAccessException;
import com.model.exceptions.UserNotFoundException;
import com.model.persistence.factory.HibernateSessionFactory;

public class UserDaoImpl implements UserDao{

	private SessionFactory factory;
	
	public UserDaoImpl() {
		factory = HibernateSessionFactory.getSessionFactory();
	}

	@Override
	public void addUser(User user) {
		
		Session session = factory.openSession();

		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(user);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new DataAccessException(ex);
		}
		session.close();		
	}

	@Override
	public Optional<User> getUser(String username, String password) throws UserNotFoundException {
		Session session = factory.openSession();
		User user=null;
		try {
			Query q = session.createQuery("select u from User u where u.username=:username and u.password=:password", User.class);
			q.setParameter("username", username);
			q.setParameter("password", password);
			user = (User)q.uniqueResult();
			
		}catch(HibernateException ex) {
			ex.printStackTrace();
//			throw new UserNotFoundException("User not found");
		}
		return Optional.ofNullable(user);
	}
	
	

}
