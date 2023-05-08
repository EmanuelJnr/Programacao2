package Lista02;

import java.util.Scanner;

public class ProgramaQ4 {
	public static void main(String[] args) {
		Retangulo ret = new Retangulo();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe a base do retângulo: ");
		ret.setBase(input.nextInt());
		System.out.println("Informe a altura do retângulo: ");
		ret.setAltura(input.nextInt());
		
		int area = ret.area();
		int peri = ret.perimetro();
		
		System.out.println("A área e o perímetro desse retângulo são: "+area+" "+peri);
		
		input.close();
	}
}