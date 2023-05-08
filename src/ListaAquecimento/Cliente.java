package ListaAquecimento;

public class Cliente {
	private String nome;
	private Sexo sexo;
	private String CPF;
	private String email;
	
	public Cliente(String nome, Sexo sexo, String CPF, String email) {
		setNome(nome);
		setSexo(sexo);
		setCPF(CPF);
		this.email = email;
	}
	public boolean equals(Cliente c) {
		if(c.getEmail().equals(email))
			return true;
		return false;
	}
	public String toString() {
		return nome;
	}
	public String getInformacoesC() {
		return "Cliente: "+nome+", CPF: "+CPF+", email: "+email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	public String getEmail() {
		return email;
	}
}