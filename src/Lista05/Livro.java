package Lista05;

public class Livro {
	private String titulo;
	private int anoPubli;
	private int qtDisponivel;
	private float preco;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAnopubli() {
		return anoPubli;
	}
	public void setAnopubli(int anopubli) {
		this.anoPubli = anopubli;
	}
	public int getQtdisponivel() {
		return qtDisponivel;
	}
	public void setQtdisponivel(int qtdisponivel) {
		this.qtDisponivel = qtdisponivel;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
}