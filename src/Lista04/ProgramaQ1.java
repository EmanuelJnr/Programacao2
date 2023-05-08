package Lista04;
import java.util.Scanner;
public class ProgramaQ1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Digite um mês: ");
		String nome = input.nextLine().toLowerCase();

		switch (nome) {
		case "janeiro":
		case "março":
		case "maio":
		case "julho":
		case "agosto":
		case "outubro":
		case "dezembro":
			System.out.print(nome+" tem 31 dias.");
			break;
		case "fevereiro": 
			System.out.print(nome+" tem 28 dias.");
			break;
		case "junho":
		case "setembro":
		case "novembro":
		case "abril":
			System.out.print(nome+" tem 30 dias.");
			break;
		default:
			System.out.println("Entrada inválida!");
		}
		input.close();
	}
}