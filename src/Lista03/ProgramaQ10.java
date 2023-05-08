package Lista03;

import java.util.Scanner;

public class ProgramaQ10 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String txt1;
		String txt2;
		
		System.out.println("Digite o primeiro nome: ");
		txt1=input.nextLine();
		System.out.println("Digite o segundo nome: ");
		txt2=input.nextLine();
		
		if (txt1.equals(txt2))
			System.out.println("Nomes iguais");
		else
			System.out.println("Nomes diferentes");
		
		input.close();
	}
}