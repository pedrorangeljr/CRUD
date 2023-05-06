<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			&nbsp;&nbsp;&nbsp; <a href="ServletsLivro?acao=listartodos">Lista Livros</a>

		</h2>
	</center>

	<div align="center">

		<form action="ServletsLivro" method="post">

			<table border="1" cellpadding="5">
				<caption>
					<h2>Cadastrar Livros</h2>
				</caption>				 
				 
				 <tr>
					<th>ID:</th>
					<td><input type="text" id="id" name="id"placeholder="ID" readonly="readonly" value="${livro.id }"></td>
				</tr>

				<tr>
					<th>Titulo:</th>
					<td><input type="text" id="titulo" name="titulo" size="45" value="${livro.titulo }"/></td>
				</tr>
				<tr>
					<th>Autor:</th>
					<td><input type="text" id="autor" name="autor" size="45" value="${livro.autor }" /></td>
				</tr>
				<tr>
					<th>Preço:</th>
					<td><input type="text" id="preco" name="preco" size="5" value="${livro.preco }"/></td>
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