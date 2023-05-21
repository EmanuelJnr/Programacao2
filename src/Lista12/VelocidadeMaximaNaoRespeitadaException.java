package Lista12;

public class VelocidadeMaximaNaoRespeitadaException extends Exception{
	private static final long serialVersionUID = 1L;
	private Multa m;
	public static int contMultas;
	public static float somaMultas;

	public VelocidadeMaximaNaoRespeitadaException(Multa m) {
		setM(m);
		contMultas++;
		somaMultas+=m.getValorMulta();
	}
	public String toString() {
		return "A velocidade do veículo estava acima do permitido!";
	}
	public Multa getM() {
		return m;
	}
	public void setM(Multa m) {
		this.m = m;
	}
}