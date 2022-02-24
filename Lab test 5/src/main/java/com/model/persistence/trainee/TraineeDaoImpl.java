package com.model.persistence.trainee;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.exceptions.DataAccessException;
import com.model.exceptions.TraineeNotFoundException;
import com.model.persistence.factory.HibernateSessionFactory;

public class TraineeDaoImpl implements TraineeDao{

	private SessionFactory factory;
	
	public TraineeDaoImpl() {
		factory = HibernateSessionFactory.getSessionFactory();
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		try {
			session.save(trainee);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new DataAccessException(ex);
		}
		session.close();
		return trainee;
	}

	@Override
	public List<Trainee> getAll() throws DataAccessException {
		Session session = factory.openSession();
		List<Trainee> trainees=session
				.createQuery("select e from Trainee e", Trainee.class)
				.getResultList();
		session.close();
		return trainees;
	}

	@Override
	public Optional<Trainee> getById(int id) throws TraineeNotFoundException {
		Session session = factory.openSession();
		Trainee trainee = session.get(Trainee.class, id);
		session.close();
		if (trainee == null)
			throw new TraineeNotFoundException("Trainee with id :" + id + " is not found");
		return Optional.ofNullable(trainee);
	}

}
