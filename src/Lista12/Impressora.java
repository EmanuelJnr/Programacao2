package Lista12;

public class Impressora {
	private int qtdPapel;
	private float cargaToner;

	public Impressora(int qtdPapel, float cargaToner) {
		setQtdPapel(qtdPapel);
		setCargaToner(cargaToner);
	}
	public int imprimir(int qtdImprimir) throws FaltouPapelException, FaltouTintaException{
		if(qtdImprimir<=qtdPapel) {
			if(qtdImprimir * 0.35<=cargaToner) {
				qtdPapel -= qtdImprimir;
				cargaToner -= qtdImprimir * 0.35;
				return qtdImprimir;
			}
			else
				throw new FaltouTintaException();
		}
		else {
			int faltou = qtdImprimir - qtdPapel;
			qtdPapel = 0;
			throw new FaltouPapelException(faltou);
		}
	}
	public int getQtdPapel() {
		return qtdPapel;
	}
	public void setQtdPapel(int qtdPapel) {
		this.qtdPapel = qtdPapel;
	}
	public float getCargaToner() {
		return cargaToner;
	}
	public void setCargaToner(float cargaToner) {
		this.cargaToner = cargaToner;
	}
}