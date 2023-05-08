package Lista02;

import java.util.Scanner;

public class ProgramaQ2e3 {
	public static void main(String[] args) {
		ProdutoImportado prod = new ProdutoImportado();
		AgenteDeImportacao agente = new AgenteDeImportacao();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Por favor, informe o tipo do produto: ");
		prod.setTipo(input.nextLine());
		System.out.println("Agora informe o preço em Dólares: ");
		prod.setPreco(input.nextFloat());
		
		float total =  agente.converter(prod) + agente.calcularImposto(prod);
		
		System.out.printf("O preço do produto em Reais + impostos é: %.2f", total);
		
		input.close();
	}
}