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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			
						
			if(id == null || id.isEmpty()) {
				
				daoLivros.salvarLivros(livro);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("principal.jsp");
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
