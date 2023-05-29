package TreinarMySQL;

import java.util.Date;

public class ContaBancaria {
	private String nome;
	private double saldo;
	private String tipo;
	private Date dataCriacao;
	
	public ContaBancaria(String nome, double saldo, String tipo, Date dataCriacao) {
		setNome(nome);
		setSaldo(saldo);
		setTipo(tipo);
		setDataCriacao(dataCriacao);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}