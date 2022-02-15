package com.traineeApp.model.exceptions;

public class TraineeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -7843949554760027657L;

	public TraineeNotFoundException(String message) {
		super(message);
	}
}