package Lista12;

public class FaltouPapelException extends Exception{
	private static final long serialVersionUID = 1L;
	private int faltou;

	public FaltouPapelException(int faltou) {
		super("Papel insuficiente, faltou: "+faltou+" páginas");
		this.faltou=faltou;
	}
	public int getFaltou() {
		return faltou;
	}
}