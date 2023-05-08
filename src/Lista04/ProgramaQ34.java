package Lista04;
import java.util.Scanner;
public class ProgramaQ34 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String run;
		int esc=0;
		int iso=0;
		int equ=0;
		
		do {
			Triangulo t = new Triangulo();
			System.out.print("Informe o 1º lado: ");
			t.setLado1(Integer.parseInt(input.nextLine()));
			System.out.print("Informe o 2º lado: ");
			t.setLado2(Integer.parseInt(input.nextLine()));
			System.out.print("Informe o 3º lado: ");
			t.setLado3(Integer.parseInt(input.nextLine()));
			
			if(t.tipo().toString().equals("ESCALENO"))
				esc++;
			else if(t.tipo().toString().equals("ISOSCELES"))
				iso++;
			else
				equ++;
			
			System.out.print("Deseja continuar? (S/N) ");
			run = input.nextLine();
		} while (run.equalsIgnoreCase("s"));
		
		System.out.println(esc+" escalenos");
		System.out.println(iso+" isosceles");
		System.out.println(equ+" equilatero");
		
		input.close();
	}
}