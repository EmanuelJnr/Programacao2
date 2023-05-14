package Lista11;

public class Decorador extends Mensagem{
	private Mensagem mensagem;
	
	public Decorador(String texto) {
		super(texto);
	}
	public Mensagem getMensagem() {
		return mensagem;
	}
	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
}