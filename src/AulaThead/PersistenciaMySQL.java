package AulaThead;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersistenciaMySQL {
	Connection conexao = null;

	public PersistenciaMySQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Conectando ao banco.");
			conexao = DriverManager.getConnection("jdbc:mysql://192.168.18.150/java","user","");
			//"jdbc:mysql://localhost/java","Eclipse",""
		} catch (ClassNotFoundException e) {
			System.out.println("Driver do banco de dados não localizado.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco: "+e.getMessage());
			e.printStackTrace();
		}
	}
	public void salvarContaBancaria(ContaBancaria cb) throws SQLException {
		PreparedStatement pstm = null;
		
		try {
			pstm = conexao.prepareStatement("insert into ContasBancarias(nome,saldo,tipo,dataCriacao)values(?,?,?,?)");
			pstm.setString(1, cb.getNome());
			pstm.setDouble(2, cb.getSaldo());
			pstm.setString(3, cb.getTipo());
			pstm.setString(4, cb.getDataCriacao());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<ContaBancaria> recuperarContas(){
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
		}catch (SQLException ErroSQL) {
			System.out.println(ErroSQL.getMessage());
		}
		return contas;
	}
}