package TreinarMySQL;

import java.util.Date;
import java.util.UUID;

public class ContaBancaria {
	private UUID idContaBancaria;
	private UUID idCliente;
	private String numero;
	private double saldo;
	private String tipo;
	private Date dataCriacao;

	public ContaBancaria(UUID idContaBancaria, UUID idCliente, String numero, double saldo, String tipo, Date dataCriacao) {
		this.idContaBancaria = idContaBancaria;
		this.dataCriacao = dataCriacao;
		this.idCliente = idCliente;
		this.numero = numero;
		setSaldo(saldo);
		this.tipo = tipo;
	}
	public ContaBancaria(UUID idCliente, String numero, double saldo, String tipo) {
		idContaBancaria = UUID.randomUUID();
		dataCriacao = new Date(System.currentTimeMillis());
		this.idCliente = idCliente;
		this.numero = numero;
		setSaldo(saldo);
		this.tipo = tipo;
	}

	public boolean equals(ContaBancaria cb) {
		if(cb.getNumero().equals(numero))
			return true;
		return false;
	}
	public UUID getIdContaBancaria() {
		return idContaBancaria;
	}
	public UUID getIdCliente() {
		return idCliente;
	}
	public String getNumero() {
		return numero;
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
	public Date getDataCriacao() {
		return dataCriacao;
	}
}