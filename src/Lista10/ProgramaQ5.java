package Lista10;

import java.util.ArrayList;
import java.util.Scanner;

public class ProgramaQ5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Publicacao> publis = new ArrayList<>();

		boolean flag = true;
		while(flag) {
			System.out.println("1-Cadastrar novo livro");
			System.out.println("2-Cadastrar nova revista");
			System.out.println("3-Listar todas as publicações");
			System.out.println("4-Listar apenas os livros");
			System.out.println("5-Listar apenas as revistas");
			System.out.println("S-Sair");
			String op = input.nextLine().toUpperCase();
			if(op.equals("1")) {
				Livro l = new Livro();
				l.introduzDados();
				publis.add(l);
			}
			else if(op.equals("2")) {
				Revista r = new Revista();
				r.introduzDados();
				publis.add(r);
			}
			else if(op.equals("3")) {
				for (Publicacao p : publis)
					p.mostra();
			}
			else if(op.equals("4")) {
				for (Publicacao p : publis) {
					if(p instanceof Livro)
						p.mostra();
				}
			}
			else if(op.equals("5")) {
				for (Publicacao p : publis) {
					if(p instanceof Revista)
						p.mostra();
				}
			}
			else if(op.equals("S")) {
				flag = false;
			}
			else
				System.out.println("Opção inválida!");
		}
		System.out.println("Livros: "+Livro.getContL());
		System.out.println("Revistas: "+Revista.getContR());
		input.close();
	}
}