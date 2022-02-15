package com.traineeApp.model.service;

import java.util.List;

import com.traineeApp.model.persistence.trainee.Trainee;

public interface TraineeService {
	public List<Trainee> allTrainees();

	public Trainee addTrainee(Trainee trainee);

	public Trainee getTraineeById(int id);
}
