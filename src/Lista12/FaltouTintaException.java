package Lista12;

public class FaltouTintaException extends Exception{
	private static final long serialVersionUID = 1L;

	public FaltouTintaException() {
		super("Tinta insuficiente para continuar a impressão!");
	}
}