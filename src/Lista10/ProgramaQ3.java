package Lista10;

import java.util.Scanner;

public class ProgramaQ3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		FormatacaoTexto f;
		
		System.out.print("Digite uma mensagem: ");
		String texto = input.nextLine();
		
		System.out.println("Formatar texto para");
		System.out.println("1-Maiúsculas, 2-Minúscula ou 3-Inverter");
		String op = input.nextLine();
		if(op.equals("1"))
			f = new Maiuscula();
		else if(op.equals("2"))
			f = new Minuscula();
		else
			f = new Invertida();
		
		System.out.println(f.formatarTexto(texto));
		
		input.close();
	}
}