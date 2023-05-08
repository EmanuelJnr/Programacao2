package Lista03;

import java.util.Scanner;

public class ProgramaQ678 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("X 1: ");
		int x1 = input.nextInt();
		System.out.print("Y 1: ");
		int y1 = input.nextInt();
		Ponto p1 = new Ponto();
		p1.setCooX(x1);
		p1.setCooY(y1);
		System.out.println("O primeiro ponto está no "+p1.quadrante());
		
		System.out.print("X 2: ");
		int x2 = input.nextInt();
		System.out.print("Y 2: ");
		int y2 = input.nextInt();
		Ponto p2 = new Ponto();
		p2.setCooX(x2);
		p2.setCooY(y2);
		System.out.println("O segundo ponto está no "+p2.quadrante());
		
		if (p1.eIgual(p2))
			System.out.println("Os dois pontos são iguais");
		else
			System.out.println("Os dois pontos são diferentes");
		
		input.close();
	}
}