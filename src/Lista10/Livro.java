package Lista10;

import java.util.Scanner;

public class Livro extends Publicacao{
	Scanner input = new Scanner(System.in);
	private String autor;
	private int ano;
	private static int contL=0;
	
	public Livro() {
		contL++;
	}
	@Override
	public void mostra() {
		System.out.println(getNome()+", "+autor+", "+ano);
	}
	@Override
	public void introduzDados() {
		System.out.print("Qual o nome da Publicação: ");
		setNome(input.nextLine());
		System.out.print("Informe o autor: ");
		autor = input.nextLine();
		System.out.print("Informe o ano: ");
		ano = Integer.parseInt(input.nextLine());
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public static int getContL() {
		return contL;
	}
}