package Lista03;

import java.util.Scanner;

public class ProgramaQ23 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Nutricionista nut = new Nutricionista();
		Paciente pac = new Paciente();
		
		System.out.print("Qual sua altura: ");
		pac.setAltura(input.nextFloat());
		System.out.print("Qual seu peso: ");
		pac.setPeso(input.nextFloat());
		
		System.out.println("Sua classificação é: "+nut.avaliarIMC(pac));
		
		input.close();
	}
}