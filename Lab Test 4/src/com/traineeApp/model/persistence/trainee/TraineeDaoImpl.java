package com.traineeApp.model.persistence.trainee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.traineeApp.model.persistence.factory.ConnectionFactory;
import com.traineeApp.model.exceptions.DataAccessException;
import com.traineeApp.model.exceptions.TraineeNotFoundException;

public class TraineeDaoImpl implements TraineeDao {

	private Connection connection;

	public TraineeDaoImpl() {
		this.connection = ConnectionFactory.getConnection();
	}

	@Override
	public List<Trainee> allTrainees() {
		// id ,name ,address, mobile ,email , dob
		List<Trainee> trainees = new ArrayList<>();
		Trainee trainee = null;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from trainee");
			while (rs.next()) {
				trainee = new Trainee(rs.getInt("trainee_id"), rs.getString("trainee_name"), rs.getString("branch"),
						rs.getDouble("percentage"));
				trainees.add(trainee);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}

		return trainees;
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		//
		try {
	 PreparedStatement pstmt = connection.prepareStatement(
					"insert into trainee(trainee_name, branch, percentage) values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

	        pstmt.setString(1, trainee.getTrainee_name());
			pstmt.setString(2, trainee.getBranch());
			pstmt.setDouble(3, trainee.getPercentage());
			
			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				trainee.setTrainee_id(rs.getInt(1));
			}

		} catch (SQLException ex) {
			throw new DataAccessException(ex.getCause().toString());
		}

		return trainee;
	}

	

	@Override
	public Trainee getTraineeById(int id) {
		Trainee trainee=null;
		try {
			PreparedStatement pstmt = 
					connection.prepareStatement
					("select * from trainee where id=?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				trainee = new Trainee(rs.getInt("trainee_id"), rs.getString("trainee_name"), rs.getString("branch"),
						rs.getDouble("percentage"));
			}else {
				throw new TraineeNotFoundException("Trainee with id "+ id +" is not found");
			}

		} catch (SQLException ex) {
			throw new DataAccessException(ex.getCause().toString());
		}
		return trainee;
	}

}
