package TreinarMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class PersistenciaMySQL implements Persistencia{
	Connection conexao = null;

	public PersistenciaMySQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://containers-us-west-180.railway.app:7656/railway","root","rReqwN16qHIPzgf5bvFS");
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
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			java.sql.Date data = new java.sql.Date(sdf.parse(sdf.format(cb.getDataCriacao())).getTime());
			pstm.setDate(4, data);
			pstm.executeUpdate();
		} catch(SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Não conseguiu salvar no banco!");
		}catch(ParseException pe) {
			JOptionPane.showMessageDialog(null,"Data inválida!");
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
				String nome = rs.getString("nome");
				double saldo = rs.getDouble("saldo");
				String tipo = rs.getString("tipo");
				Date dataCriacao = rs.getDate("dataCriacao");

				contas.add(new ContaBancaria(nome, saldo, tipo, dataCriacao));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return contas;
	}
}