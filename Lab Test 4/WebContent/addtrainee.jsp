
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script src="validate.js"></script>
</head>

<body>
	<form action="traineecontroller.do" method="post">
		<input type="hidden" name="id" value="0" />
		<table>
			<tr>
				<td>Enter name:</td>
				<td><input type="text" name="name" id="nameId" /></td>
				<td><label id="nameMsg"></label></td>
			</tr>

			<tr>
				<td>Enter branch:</td>
				<td><select id="branch" name ="branch">
				  <option value="java">Java</option>
				  <option value="oracle">Oracle</option>
				  <option value="php">PHP</option>
				  <option value="dotnet">DotNet</option>
				</select></td>
				<td><label id="branchMsg"></label></td>
			</tr>


			<tr>
				<td>Enter percentage:</td>
				<td><input type="text" name="percentage" id="perId" /></td>
				<td><label id="perMsg"></label></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add Trainee" onclick="return validate();" /></td>
			</tr>
		</table>


	</form>
</body>

</html>