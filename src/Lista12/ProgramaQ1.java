package Lista12;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ProgramaQ1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Informe uma data: (DD/MM/YYYY): ");
		String data = input.nextLine();
		
		MinhaData md=null;
		boolean flag=true;
		while(flag) {
			try {
				md = new MinhaData(data);
				flag=false;
			} catch (DateTimeParseException e) {
				System.out.println("Data inválida!");
				System.out.println("Informe outra data: (DD/MM/YYYY): ");
				data = input.nextLine();
			}
		}
		System.out.println("A data: "+md.getStrDate()+" é válida.");
		input.close();
	}
}