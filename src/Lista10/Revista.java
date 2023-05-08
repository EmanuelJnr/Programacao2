package Lista10;

import java.util.Scanner;

public class Revista extends Publicacao{
	Scanner input = new Scanner(System.in);
	private int numero;
	private static int contR=0;
	
	public Revista() {
		contR = getContR() + 1;
	}
	@Override
	public void mostra() {
		System.out.println(getNome()+", "+numero);
	}
	@Override
	public void introduzDados() {
		System.out.print("Qual o nome da Publicação: ");
		setNome(input.nextLine());
		System.out.print("Informe o número: ");
		numero = Integer.parseInt(input.nextLine());
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public static int getContR() {
		return contR;
	}
}