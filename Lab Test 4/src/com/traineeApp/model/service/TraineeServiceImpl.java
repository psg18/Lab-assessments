package com.traineeApp.model.service;

import java.util.List;

import com.traineeApp.model.persistence.trainee.Trainee;
import com.traineeApp.model.persistence.trainee.TraineeDao;
import com.traineeApp.model.persistence.trainee.TraineeDaoImpl;

public class TraineeServiceImpl implements TraineeService{
	private TraineeDao traineeDao;
	
	
	public TraineeServiceImpl() {
		this.traineeDao=new TraineeDaoImpl();
	}

	@Override
	public List<Trainee> allTrainees() {
		
		return traineeDao.allTrainees();
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		return traineeDao.addTrainee(trainee);
	}

	@Override
	public Trainee getTraineeById(int id) {
		return traineeDao.getTraineeById(id);
	}

}
