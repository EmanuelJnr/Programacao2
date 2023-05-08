package TestePersistencia;

import java.util.ArrayList;

public class Livraria {
	private ArrayList<Livro> livros = new ArrayList<Livro>();
	private float saldoEmCaixa=0;
	
	public boolean cadastarLivro(Livro lcad) {
		if(livros.size()==0) {
			livros.add(lcad);
			return true;
		}
		for(Livro l:livros) {
			if(l.getTitulo().equalsIgnoreCase(lcad.getTitulo()))
				return false;
		}
		livros.add(lcad);
		return true;
	}
	public String comprarLivro(String titulo) {
		for(Livro l:livros) {
			if(titulo.equals(l.getTitulo())) {
				if(l.getQtdisponivel()>0) {
					l.setQtdisponivel(l.getQtdisponivel()-1);
					saldoEmCaixa+=l.getPreco();
					return "SUCESSO";
				}
				else
					return "ESGOTADO";
			}
		}
		return "NÃO ENCONTRADO";
	}
	public int getQtlivroscad() {
		return livros.size();
	}
	public ArrayList<Livro> getLivros() {
		return this.livros;
	}
	public float getSaldoEmCaixa() {
		return saldoEmCaixa;
	}
}