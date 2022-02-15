package com.traineeApp.model.persistence.trainee;


public class Trainee {
	private int trainee_id;
	private String trainee_name;
	private String branch;
	private Double percentage;

	public Trainee() {
	}

	public Trainee(String trainee_name, String branch, Double percentage) {

		this.trainee_name = trainee_name;
		this.branch = branch;
		this.percentage = percentage;
	}

	public Trainee(int trainee_id, String trainee_name, String branch, Double percentage) {

		this.trainee_id = trainee_id;
		this.trainee_name = trainee_name;
		this.branch = branch;
		this.percentage = percentage;
	}

	public int getTrainee_id() {
		return trainee_id;
	}

	public void setTrainee_id(int trainee_id) {
		this.trainee_id = trainee_id;
	}

	public String getTrainee_name() {
		return trainee_name;
	}

	

	public String getBranch() {
		return branch;
	}

	

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trainee [trainee_id=");
		builder.append(trainee_id);
		builder.append(", trainee_name=");
		builder.append(trainee_name);
		builder.append(", branch=");
		builder.append(branch);
		builder.append(", percentage=");
		builder.append(percentage);
		builder.append("]");
		return builder.toString();
	}

}
