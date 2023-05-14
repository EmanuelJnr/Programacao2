package Lista11;

import java.util.Scanner;

public class ProgramaQ3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Mensageiro m = new Mensageiro();
		
		System.out.print("Escreva seu texto: ");
		String txt = input.nextLine();
		System.out.println("Destino: interno ou externo");
		String destino = input.nextLine();
		
		System.out.println(m.prepararMensagem(txt, destino).getTexto());
		
		input.close();
	}
}