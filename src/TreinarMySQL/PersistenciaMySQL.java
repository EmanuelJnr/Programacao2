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
import java.util.UUID;

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
	public void salvarContaBancaria(ContaBancaria cbAdd) {
		for(ContaBancaria cbs: carregarContasBancaria()) {
			if(cbAdd.equals(cbs))
				return;
		}
		PreparedStatement pstm = null;
		try {
			pstm = conexao.prepareStatement("insert into contasbancarias(idContaBancaria,idCliente,numero,saldo,tipo,dataCriacao)values(?,?,?,?,?,?)");
			pstm.setString(1, ""+cbAdd.getIdContaBancaria());
			pstm.setString(2, ""+cbAdd.getIdCliente());
			pstm.setString(3, cbAdd.getNumero());
			pstm.setDouble(4, cbAdd.getSaldo());
			pstm.setString(5, cbAdd.getTipo());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			java.sql.Date data = new java.sql.Date(sdf.parse(sdf.format(cbAdd.getDataCriacao())).getTime());
			pstm.setDate(6, data);
			pstm.executeUpdate();
		} catch(SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Não conseguiu salvar no banco!");
		}catch(ParseException pe) {
			JOptionPane.showMessageDialog(null,"Data inválida!");
		}
	}
	public ArrayList<ContaBancaria> carregarContasBancaria() {
		ArrayList<ContaBancaria> contas = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conexao.prepareStatement("SELECT * FROM contasbancarias");
			rs = pstm.executeQuery();
			while(rs.next()) {
				UUID idContaBancaria = UUID.fromString(rs.getString("idContaBancaria"));
				UUID idCliente = UUID.fromString(rs.getString("idCliente"));
				String numero = rs.getString("numero");
				double saldo = rs.getDouble("saldo");
				String tipo = rs.getString("tipo");
				Date dataCriacao = rs.getDate("dataCriacao");

				contas.add(new ContaBancaria(idContaBancaria, idCliente, numero, saldo, tipo, dataCriacao));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return contas;
	}
	public ContaBancaria recuperarContaBancariaID(UUID idContaBancaria) {
		for (ContaBancaria cbs : carregarContasBancaria()) {
			if(cbs.getIdContaBancaria().equals(idContaBancaria)) {
				return cbs;
			}
		}
		return null;
	}

	public void salvarCliente(Cliente cAdd) {
		for(Cliente c: carregarClientes()) {
			if(cAdd.equals(c))
				return;
		}
		PreparedStatement pstm = null;
		try {
			pstm = conexao.prepareStatement("insert into clientes(idCliente,nome,idade,temCorrente,temPoupanca)values(?,?,?,?,?)");
			pstm.setString(1, ""+cAdd.getIdCliente());
			pstm.setString(2, cAdd.getNome());
			pstm.setInt(3, cAdd.getIdade());
			pstm.setBoolean(4, cAdd.isTemCorrente());
			pstm.setBoolean(5, cAdd.isTemPoupanca());
			pstm.executeUpdate();
		} catch(SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Não conseguiu salvar no banco!");
		}
	}
	public ArrayList<Cliente> carregarClientes() {
		ArrayList<Cliente> clientes = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conexao.prepareStatement("SELECT * FROM clientes");
			rs = pstm.executeQuery();
			while(rs.next()) {
				UUID idCliente = UUID.fromString(rs.getString("idCliente"));
				String nome = rs.getString("nome");
				int idade = rs.getInt("idade");
				boolean temCorrente = rs.getBoolean("temCorrente");
				boolean temPoupanca = rs.getBoolean("temCorrente");

				clientes.add(new Cliente(idCliente, nome, idade, temCorrente, temPoupanca));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}
	public Cliente recuperarClienteID(UUID idCliente) {
		for (Cliente c : carregarClientes()) {
			if(c.getIdCliente().equals(idCliente)) {
				return c;
			}
		}
		return null;
	}
}