package Lista02;

import java.util.Scanner;

public class ProgramaQ567 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Carro car = new Carro();
		Planejador plan = new Planejador();
		
		System.out.println("Qual a capacidade do tanque: ");
		car.setCapacidadeDoTanque(input.nextInt());
		System.out.println("Qual a autonomia do carro: ");
		car.setAutonomia(input.nextFloat());
		System.out.println("Qual a distância que irá percorrer: ");
		int dist = input.nextInt();
		
		System.out.print("O carro precisa fazer ");
		System.out.print(plan.estimarAbastecimentos(car, dist));
		System.out.println(" abastecimentos");
		
		input.close();
	}
}