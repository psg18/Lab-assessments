<%@page import="com.traineeApp.model.persistence.trainee.Trainee"%>
<%@page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show all trainees</title>
</head>
<body>
	Welcome ${user.username}
	<br>!
	<a href="logout">logout</a>
	<br>
	<table>
		<thead>
			<tr>
				<th>Trainee_id</th>
				<th>Trainee_name</th>
				<th>Branch</th>
				<th>Percentage</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${trainees}" var="trainee">
				<tr>
					<td><c:out value="${trainee.trainee_id }" /></td>
					<td><c:out value="${trainee.trainee_name}" /></td>
					<td><c:out value="${trainee.branch}" /></td>
					<td><c:out value="${trainee.percentage}" /></td>
					
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="traineecontroller.do?action=add">add trainee</a>
</body>
</html>