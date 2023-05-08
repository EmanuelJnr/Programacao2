package Lista07;

public class Pessoa {
	private String nome;
	private EstadoCivil estadoCivil;
	private int idade;
	//private long id;
	
	public void criarID() {
	}
	
	public Pessoa(String nome, EstadoCivil estadoCivil, int idade) {
		//this.id = System.currentTimeMillis();
		setNome(nome);
		setEstadoCivil(estadoCivil);
		setIdade(idade);
	}
	public Pessoa() {
		//this.id = System.currentTimeMillis();
		setNome("Desconhecido");
		setEstadoCivil(EstadoCivil.SOLTEIRO);
		setIdade(5);
	}
	
	public boolean equals(Pessoa p) {
		if(p.getNome().equals(nome) && p.getEstadoCivil().equals(estadoCivil) && p.getIdade() == idade)
			return true;
		return false;
	}
	public String toString() {
		String fase="infantil";
		if(idade>=60)
			fase="velho";
		else if(idade>=21)
			fase="adulto";
		else if(idade>=12)
			fase="adolescente";
		return nome+" "+fase;
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
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	//public long getId() {
	//	return id;
	//}
}