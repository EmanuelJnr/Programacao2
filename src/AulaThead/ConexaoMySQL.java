package AulaThead;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoMySQL {
	public static void main(String[] args) throws SQLException {
		Connection conexao = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/java","root","Jazer2023@");
			ResultSet rsCliente = conexao.createStatement().executeQuery("SELECT * FROM pessoas");
			while(rsCliente.next()) {
				System.out.println("Nome: "+rsCliente.getString("nome"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver do banco de dados não localizado.");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco: "+e.getMessage());
			e.printStackTrace();
		} finally {
			if(conexao != null)
				conexao.close();
		}
	}
}