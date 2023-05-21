package Lista12;

public class VelocidadeMinimaNaoRespeitadaException extends VelocidadeMaximaNaoRespeitadaException{
	private static final long serialVersionUID = 1L;
	
	public VelocidadeMinimaNaoRespeitadaException(Multa m) {
		super(m);
	}
	public String toString() {
		return "A velocidade do veículo estava abaixo do permitido!";
	}
}