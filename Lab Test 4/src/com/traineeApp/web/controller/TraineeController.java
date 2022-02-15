package com.traineeApp.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.traineeApp.model.exceptions.DataAccessException;
import com.traineeApp.model.service.TraineeService;
import com.traineeApp.model.service.TraineeServiceImpl;
import com.traineeApp.model.persistence.trainee.Trainee;

public class TraineeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TraineeService traineeService = new TraineeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		HttpSession httpSession = request.getSession();
		if (action.equalsIgnoreCase("showall")) {
			List<Trainee> trainees = traineeService.allTrainees();
			request.setAttribute("trainees", trainees);
			RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
			rd.forward(request, response);
		} else if (action.equalsIgnoreCase("add")) {
			request.getRequestDispatcher("addtrainee.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		// int id = Integer.parseInt(request.getParameter("id").trim());
		String trainee_name = request.getParameter("trainee_name");
		String branch = request.getParameter("branch");
		Double percentage = Double.parseDouble(request.getParameter("percentage"));

		Trainee trainee = new Trainee(trainee_name, branch, percentage);

		try {
			trainee = traineeService.addTrainee(trainee);
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}

		response.sendRedirect("traineecontroller.do?action=showall");
	}

}
