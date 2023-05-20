package Lista12;

import java.util.Scanner;

public class ProgramaQ3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Impressora imp = new Impressora(0, 0);
		int pagImpressas=0;
		
		boolean flag = true;
		while(flag) {
			System.out.println("1 – Imprimir\n"
					+ "2 – Carregar papel na impressora\n"
					+ "3 – Trocar o toner da impressora \n"
					+ "4 - Sair");
			String op = input.nextLine();
			
			if(op.equals("1")) {
				System.out.print("Quantas páginas vai imprimir: ");
				try {
					pagImpressas+=imp.imprimir(Integer.parseInt(input.nextLine()));
				} catch (FaltouPapelException | FaltouTintaException f) {
					System.out.println(f.getMessage());
				}
			}
			else if(op.equals("2")) {
				System.out.print("Quantas folhas vai pôr na impressora: ");
				int papeis = Integer.parseInt(input.nextLine());
				imp.setQtdPaginas(imp.getQtdPaginas()+papeis);
			}
			else if(op.equals("3")) {
				imp.setCargaToner(100);
				System.out.println("Toner abastecido");
			}
			else if(op.equals("4")) {
				flag = false;
				System.out.println("Foi impresso "+pagImpressas+" páginas");
			}
			else
				System.out.println("Entrada inválida!");
		}
		input.close();
	}
}