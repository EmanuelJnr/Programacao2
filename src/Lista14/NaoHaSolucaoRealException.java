package Lista14;

public class NaoHaSolucaoRealException extends Exception{
	private static final long serialVersionUID = 1L;

	public NaoHaSolucaoRealException() {
		super("Não há solução real: delta negativo");
	}
}