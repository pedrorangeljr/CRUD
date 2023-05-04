<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gerenciamento de Livros</title>
</head>
<body>

	<br />

	<center>
		<h1>Gerenciamentos de livros</h1>
		<h2>
			<a href="adicionarLivros.jsp">Adicionar Livros</a> &nbsp;&nbsp;&nbsp;

		</h2>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Lista de Livros</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Titulo</th>
				<th>Autor</th>
				<th>Preço</th>
				<th>Ações</th>
			</tr>
			<c:forEach var="book" items="${listBook}">
				<tr>
					<td><c:out value="${book.id}" /></td>
					<td><c:out value="${book.title}" /></td>
					<td><c:out value="${book.author}" /></td>
					<td><c:out value="${book.price}" /></td>
					<td><a href="/edit?id=<c:out value='${book.id}' />">Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/delete?id=<c:out value='${book.id}' />">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>