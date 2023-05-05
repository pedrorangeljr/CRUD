package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Livro;
import conexao.SingleConnection;

public class DaoLivros {

	private Connection connection;

	public DaoLivros() {

		connection = SingleConnection.getConnection();
	}

	/* Metodo salvar Livros */

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

	/* Metodo listar livros na tela do Sistema */

	public List<Livro> listar() throws Exception {

		List<Livro> listar = new ArrayList<Livro>();

		String sql = "select * from livros";
		PreparedStatement select = connection.prepareStatement(sql);
		ResultSet resultado = select.executeQuery();

		while (resultado.next()) {

			Livro livro = new Livro();

			livro.setId(resultado.getLong("id"));
			livro.setTitulo(resultado.getString("titulo"));
			livro.setAutor(resultado.getString("autor"));
			livro.setPreco(resultado.getString("preco"));

			listar.add(livro);

		}

		return listar;
	}
	
	/*Metodo deletar*/
	
	public void delete(String id) {
		
		try {
			
			String sql = "delete from livros where id = '"+id+"'";
			PreparedStatement deletar = connection.prepareStatement(sql);
			deletar.execute();
			
			connection.commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			try {
				
				connection.rollback();
				
			} catch (SQLException e1) {
		
				e1.printStackTrace();
			}
		}
	}

	/* Metodo Não deixa gravar titulo duplicado */

	public boolean validarTitulo(String titulo) {

		try {

			String sql = "select count(1) as quantidade from livros where titulo = '" + titulo + "'";
			PreparedStatement consultar = connection.prepareStatement(sql);
			ResultSet resultado = consultar.executeQuery();

			if (resultado.next()) {

				return resultado.getInt("quantidade") <= 0; // return true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}
}
