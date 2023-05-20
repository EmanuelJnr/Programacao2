package Lista12;

public class Impressora {
	private int qtdPaginas;
	private float cargaToner;

	public Impressora(int qtdPaginas, float cargaToner) {
		setQtdPaginas(qtdPaginas);
		setCargaToner(cargaToner);
	}
	public int imprimir(int qtdP) throws FaltouPapelException, FaltouTintaException{
		int qtdPI = qtdPaginas;
		if(qtdP<=qtdPaginas) {
			if(qtdP * 0.35<=cargaToner) {
				qtdPaginas -= qtdP;
				cargaToner -= qtdP * 0.35;
				return qtdP;
			}
			else {
				throw new FaltouTintaException();
			}
		}
		else if(qtdP>qtdPaginas){
			int faltou = qtdP - qtdPaginas;
			qtdPaginas = 0;
			throw new FaltouPapelException(faltou);
		}
		return qtdPI;
	}
	public int getQtdPaginas() {
		return qtdPaginas;
	}
	public void setQtdPaginas(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}
	public float getCargaToner() {
		return cargaToner;
	}
	public void setCargaToner(float cargaToner) {
		this.cargaToner = cargaToner;
	}
}