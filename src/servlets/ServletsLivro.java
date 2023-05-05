package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Livro;
import dao.DaoLivros;

@WebServlet("/ServletsLivro")
public class ServletsLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoLivros daoLivros = new DaoLivros();

	public ServletsLivro() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String acao = request.getParameter("acao");
			String livro = request.getParameter("livro");
			
			if(acao.equalsIgnoreCase("delete")) {
				
				daoLivros.delete(livro);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("principal.jsp");
				request.setAttribute("livros", daoLivros.listar());
				dispatcher.forward(request, response);
			}

			else if (acao.equalsIgnoreCase("listartodos")) {

				RequestDispatcher dispatcher = request.getRequestDispatcher("principal.jsp");
				request.setAttribute("livros", daoLivros.listar());
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String id = request.getParameter("id");
			String titulo = request.getParameter("titulo");
			String autor = request.getParameter("autor");
			String preco = request.getParameter("preco");

			Livro livro = new Livro();

			livro.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			livro.setTitulo(titulo);
			livro.setAutor(autor);
			livro.setPreco(preco);

			/* Inicio verificação, não deixa gravar Titulo duplicado */

			if (id == null || id.isEmpty() && !daoLivros.validarTitulo(titulo)) {

				request.setAttribute("mensagem", "Já existe livro com mesmo Titulo");
			}

			else if (id == null || id.isEmpty()) {

				daoLivros.salvarLivros(livro);

			}

			/* Lista Livros na tela */

			RequestDispatcher dispatcher = request.getRequestDispatcher("principal.jsp");
			request.setAttribute("livros", daoLivros.listar());
			dispatcher.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
