package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Livro;
import conexao.SingleConnection;

public class DaoLivros {
	
	private Connection connection;
	
	public DaoLivros() {
		
		connection = SingleConnection.getConnection();
	}
	
	/*Metodo salvar Livros*/
	
	public void salvarLivros(Livro livro) {
		
		try {
			
			String sql = "insert into livros(titulo,autor,preco)values(?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, livro.getTitulo());
			insert.setString(2, livro.getAutor());
			insert.setString(3, livro.getPreco());
			insert.execute();
			
			connection.commit();
			
		} catch (Exception e) {
			
			try {
				connection.rollback();
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
	}

}
