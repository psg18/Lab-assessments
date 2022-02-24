<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="login.js"></script>
</head>
<body>

${param.status}<br>

<form action="LoginController" method="post">
    <table>
        <tr>
            <td>Enter user name:</td>
            <td><input type="text" name="username" id="usernameId" /></td>
            <td><label id="usernameMsg"></label></td>
        </tr>

        <tr>
            <td>Enter password:</td>
            <td><input type="password" name="password" id="passwordId" /></td>
            <td><label id="passwordMsg"></label></td>
        </tr>

        <tr>
            <td><input type="submit" value="Login" onclick="return validateLogin();" /></td>
        </tr>
    </table>
</form>
</body>
</html>