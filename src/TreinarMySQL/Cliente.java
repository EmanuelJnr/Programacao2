package TreinarMySQL;

import java.util.UUID;

public class Cliente {
	private UUID idCliente;
	private String nome;
	private int idade;
	private boolean temCorrente;
	private boolean temPoupanca;

	public Cliente(UUID idCliente, String nome, int idade, boolean temCorrente, boolean temPoupanca) {
		this.idCliente = idCliente;
		setNome(nome);
		setIdade(idade);
		setTemCorrente(temCorrente);
		setTemPoupanca(temPoupanca);
	}
	public Cliente(String nome, int idade, boolean temCorrente, boolean temPoupanca) {
		idCliente = UUID.randomUUID();
		setNome(nome);
		setIdade(idade);
		setTemCorrente(temCorrente);
		setTemPoupanca(temPoupanca);
	}

	public boolean equals(Cliente c) {
		if(c.getNome().equals(nome))
			return true;
		return false;
	}
	public UUID getIdCliente() {
		return idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public boolean isTemCorrente() {
		return temCorrente;
	}
	public void setTemCorrente(boolean temCorrente) {
		this.temCorrente = temCorrente;
	}
	public boolean isTemPoupanca() {
		return temPoupanca;
	}
	public void setTemPoupanca(boolean temPoupanca) {
		this.temPoupanca = temPoupanca;
	}
}