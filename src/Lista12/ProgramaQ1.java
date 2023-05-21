package Lista12;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ProgramaQ1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		MinhaData md=null;
		boolean flag=true;
		while(flag) {
			try {
				System.out.println("Informe uma data: (DD/MM/YYYY): ");
				String data = input.nextLine();
				md = new MinhaData(data);
				flag=false;
			} catch (DateTimeParseException e) {
				System.out.println("Data inválida!");
			}
		}
		System.out.println("A data: "+md.getStrDate()+" é válida.");
		input.close();
	}
}