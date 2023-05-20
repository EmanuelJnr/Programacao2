package Lista12;

public class FaltouPapelException extends Exception{
	private static final long serialVersionUID = 1L;
	private int qtdPagNImpressas;

	public FaltouPapelException(int qtdPagNImpressas) {
		super("Papel insuficiente, faltou: "+qtdPagNImpressas+" páginas");
		setQtdPagNImpressas(qtdPagNImpressas);
	}
	public int getQtdPagNImpressas() {
		return qtdPagNImpressas;
	}
	public void setQtdPagNImpressas(int qtdPagNImpressas) {
		this.qtdPagNImpressas = qtdPagNImpressas;
	}
}