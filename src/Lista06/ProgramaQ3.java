package Lista06;

import java.util.Scanner;

public class ProgramaQ3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Número Binário: ");
		String txt = input.nextLine();
		
		String numh = Integer.toString(Integer.parseInt(txt, 2), 16);
		int numb = Integer.parseInt(txt, 2);
		
		System.out.println("Base Hexadecimal: "+numh.toUpperCase());
		System.out.println("Base Decimal: "+numb);
		
		input.close();
	}
}