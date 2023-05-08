package Lista08;

public class ContaPoupanca {
	private float saldo;
	private String titular;
	private String numero;
	private float taxaRendimento;
	
	public ContaPoupanca(float saldo, String titular, String numero, float taxaRendimento) {
		setSaldo(saldo);
		setTitular(titular);
		setNumero(numero);
		setTaxaRendimento(taxaRendimento);
	}
	public String toString() {
		return "Conta Poupança Nº: "+numero+" e saldo: "+saldo;
	}
	public boolean equals(ContaPoupanca p) {
		if(p.numero.equals(numero))
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
	public float getTaxaRendimento() {
		return taxaRendimento;
	}
	public void setTaxaRendimento(float taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}
}