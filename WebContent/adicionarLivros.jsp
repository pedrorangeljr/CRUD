<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Livros</title>
</head>
<body>

	<center>
		<h1>Gerenciamento de Livros</h1>
		<h2>
			&nbsp;&nbsp;&nbsp; <a href="principal.jsp">Lista Livros</a>

		</h2>
	</center>

	<div align="center">

		<form action="ServletsLivro" method="post">

			<table border="1" cellpadding="5">
				<caption>
					<h2>Cadastrar Livros</h2>
				</caption>

				<input type="hidden" name="id" id="id" />

				<tr>
					<th>Titulo:</th>
					<td><input type="text" name="titulo" size="45" /></td>
				</tr>
				<tr>
					<th>Autor:</th>
					<td><input type="text" name="autor" size="45" /></td>
				</tr>
				<tr>
					<th>Preço:</th>
					<td><input type="text" name="preco" size="5" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Cadastrar" /></td>
				</tr>

			</table>

		</form>
	</div>

</body>
</html>