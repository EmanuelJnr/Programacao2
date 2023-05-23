package TreinarMySQL;

public class ContaBancaria {
	private String nome;
	private double saldo;
	private String tipo;
	private String dataCriacao;
	
	public ContaBancaria(String nome, double saldo, String tipo, String dataCriacao) {
		setNome(nome);
		setSaldo(saldo);
		setTipo(tipo);
		setDataCriacao(dataCriacao);
	}
	public boolean equals(ContaBancaria cb) {
		if(cb.getNome().equals(nome))
			return true;
		return false;
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
	public String getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}