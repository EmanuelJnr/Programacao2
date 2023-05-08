package Lista06;

public class JogoDaForca {
	private Palavra[] dicionario;
	private int posisort;
	private String gabarito;
	
	public String pegarDica() {
		return dicionario[posisort].getDica();
	}
	public void sortear() {
		gabarito="";
		posisort = (int) (Math.random()*dicionario.length);
		for (int i=0;i<dicionario[posisort].getPalavra().length();i++)
			gabarito += "?";
	}
	public boolean testarLetra(char c) {
		if(dicionario[posisort].getPalavra().indexOf(c)!= -1) {
			String[] agabarito = gabarito.split("");
			for(int i=0;i<dicionario[posisort].getPalavra().length();i++) {
				char a = dicionario[posisort].getPalavra().charAt(i);
				if(c==a) {
					agabarito[i] = ""+c;
				}
			}
			gabarito="";
			for(String g : agabarito) {
				gabarito+=g;
			}
			return true;
		}
		return false;
	}
	public boolean testaSeAcabou() {
		if(gabarito.indexOf('?')== -1) {
			dicionario[posisort] = null;
			posisort = -1;
			return false;
		}
		else
			return true;
	}
	
	public Palavra[] getDicionario() {
		return dicionario;
	}
	public void setDicionario(Palavra[] dicionario) {
		this.dicionario = dicionario;
	}
	public int getPosisort() {
		return posisort;
	}
	public String getGabarito() {
		return gabarito;
	}
}