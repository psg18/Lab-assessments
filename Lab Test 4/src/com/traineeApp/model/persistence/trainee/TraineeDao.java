package com.traineeApp.model.persistence.trainee;

import java.util.*;

public interface TraineeDao {
	public List<Trainee> allTrainees();

	public Trainee addTrainee(Trainee trainee);

	public Trainee getTraineeById(int id);
}
