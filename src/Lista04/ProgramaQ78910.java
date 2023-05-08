package Lista04;
import java.util.Scanner;
public class ProgramaQ78910 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Retangulo re = new Retangulo();
		
		System.out.print("Qual a base: ");
		re.setBase(input.nextInt());
		System.out.print("Qual a altura: ");
		re.setAltura(input.nextInt());
		
		if(re.isQuadrado())
			System.out.println("É um quadrado.");
		else
			System.out.println("Não é um quadrado.");
		
		re.autoDesenhar();
		input.close();
	}
}