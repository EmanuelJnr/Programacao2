package Lista08;

public class ContaCorrente {
	private float saldo;
	private String titular;
	private String numero;
	private float chequeEspecial;
	
	public ContaCorrente(float saldo, String titular, String numero, float chequeEspecial) {
		setSaldo(saldo);
		setTitular(titular);
		setNumero(numero);
		setChequeEspecial(chequeEspecial);
	}
	public String toString() {
		return "Conta Corrente Nº: "+numero+" e saldo: "+saldo;
	}
	public boolean equals(ContaCorrente c) {
		if(c.numero.equals(numero))
			return true;
		return false;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public float getChequeEspecial() {
		return chequeEspecial;
	}
	public void setChequeEspecial(float chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}
}