package Lista11;

import java.util.Scanner;

public class ProgramaQ5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Carro c;
		
		System.out.print("Informe o preço do carro: ");
		double preco = Double.parseDouble(input.nextLine());
		System.out.print("Informe o modelo do carro: ");
		String modelo = input.nextLine();
		System.out.print("1-Carro Novo, 2-Carro Usado: ");
		String op = input.nextLine();
		
		if(op.equals("1"))
			c = new CarroNovo(modelo, preco);
		else
			c = new CarroUsado(modelo, preco);
		
		System.out.println(c);
		
		input.close();
	}
}