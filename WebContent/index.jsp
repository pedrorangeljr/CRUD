<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<center>
		<h1>Login</h1>

	</center>

	<div align="center">

		<form action="ServletLogin" method="post">

			<table border="1" cellpadding="5">

				<tr>
					<th>Login:</th>
					<td><input type="text" name="login" id = "login" size="45" /></td>
				</tr>
				
				<tr>
					<th>Senha:</th>
					<td><input type="password" name="senha" id="senha" size="45" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Entrar" /></td>
				</tr>

			</table>

		</form>

	</div>

</body>
</html>