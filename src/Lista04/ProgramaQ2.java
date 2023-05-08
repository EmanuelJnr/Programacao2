package Lista04;
import java.util.Scanner;
public class ProgramaQ2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Entrada 1: ");
		String nome1 = input.nextLine();
		System.out.print("Entrada 2: ");
		String nome2 = input.nextLine();
		
		while (nome1.equals(nome2)) {
			System.out.println("As duas entradas devem ser diferentes");
			System.out.print("Entrada 2: ");
			nome2 = input.nextLine();
		}
		
		if(nome1.compareTo(nome2) == -1)
			System.out.print(nome1+", "+nome2);
		else
			System.out.print(nome2+", "+nome1);
		
		input.close();
	}
}