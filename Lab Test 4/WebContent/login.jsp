<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trainee application</title>
  <script src="login.js"></script> 	
</head>
<body>

	${param.error}
	<br> ${param.message }
	<br>
	<br>
	<div>
		<div>
			<form method="POST" action="loginController">

				<table>
					<tr>
						<td>Enter username:</td>
						<td><input type="text" name="username" id="usernameId" /></td>
						<td><label id="usernameMsg"></label></td>
					</tr>

					<tr>
						<td>Enter password:</td>
						<td><input type="password" name="password" id="passwordId" /></td>
						<td><label id="passwordMsg"></label></td>
					</tr>

					<tr>
						<td><input type="submit" name="submit"
							onclick="return validateLogin();" value="Login" /></td>
					</tr>
				</table>

			</form>
		</div>
</body>
</html>