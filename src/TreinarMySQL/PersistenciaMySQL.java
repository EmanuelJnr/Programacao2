package TreinarMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersistenciaMySQL implements Persistencia{
	Connection conexao = null;

	public PersistenciaMySQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/java","Eclipse","");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver do banco de dados não localizado.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco: "+e.getMessage());
			e.printStackTrace();
		}
	}
	public void salvarDados(ContaBancaria cb) {
		PreparedStatement pstm = null;
		try {
			pstm = conexao.prepareStatement("insert into contasbancarias(nome,saldo,tipo,dataCriacao)values(?,?,?,?)");
			pstm.setString(1, cb.getNome());
			pstm.setDouble(2, cb.getSaldo());
			pstm.setString(3, cb.getTipo());
			pstm.setString(4, cb.getDataCriacao());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<ContaBancaria> carregarDados() {
		ArrayList<ContaBancaria> contas = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conexao.prepareStatement("SELECT * FROM contasbancarias");
			rs = pstm.executeQuery();
			while(rs.next()) {
				String nome,tipo,dataCriacao;
				double saldo;
				
				nome = rs.getString("nome");
				saldo = rs.getDouble("saldo");
				tipo = rs.getString("tipo");
				dataCriacao = rs.getString("dataCriacao");
				
				contas.add(new ContaBancaria(nome, saldo, tipo, dataCriacao));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return contas;
	}
}