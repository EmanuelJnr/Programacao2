package Lista05;
public class Livraria {
	private Livro[] livros = new Livro[100];
	private int qtLivrosCad=0;
	private float saldoEmCaixa=0;
	
	public boolean cadastarLivro(Livro lcad) {
		if(qtLivrosCad==100)
			return false;
		if(qtLivrosCad==0) {
			livros[0] = lcad;
			qtLivrosCad++;
			return true;
		}
		for(int i=0;i<qtLivrosCad;i++) {
			if(livros[i].getTitulo().equalsIgnoreCase(lcad.getTitulo()))
				return false;
		}
		livros[qtLivrosCad] = lcad;
		qtLivrosCad++;
		return true;
	}
	public String comprarLivro(String titulo) {
		for(int i=0;i<qtLivrosCad;i++) {
			if(titulo.equals(livros[i].getTitulo())) {
				if(livros[i].getQtdisponivel()>0) {
					livros[i].setQtdisponivel(livros[i].getQtdisponivel()-1);
					saldoEmCaixa+=livros[i].getPreco();
					return "SUCESSO";
				}
				else
					return "ESGOTADO";
			}
		}
		return "NÃO ENCONTRADO";
	}
	public int getQtlivroscad() {
		return qtLivrosCad;
	}
	public Livro[] getLivros() {
		return this.livros;
	}
	public float getSaldoEmCaixa() {
		return saldoEmCaixa;
	}
}