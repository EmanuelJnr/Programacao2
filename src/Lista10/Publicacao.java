package Lista10;

public abstract class Publicacao {
	private String nome;
	
	public abstract void mostra();
	public abstract void introduzDados();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}