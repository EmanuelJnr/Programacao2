package Lista12;

import java.util.Scanner;

public class ProgramaQ3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Impressora imp = new Impressora(0, 100);
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
				int pag = Integer.parseInt(input.nextLine());
				try {
					pagImpressas+=imp.imprimir(pag);
				} catch (FaltouPapelException  p) {
					System.out.println(p.getMessage());
					pagImpressas+=pag-p.getFaltou();
				} catch(FaltouTintaException t) {
					System.out.println(t.getMessage());
				}
			}
			else if(op.equals("2")) {
				System.out.print("Quantas folhas vai pôr na impressora: ");
				int papeis = Integer.parseInt(input.nextLine());
				imp.setQtdPapel(imp.getQtdPapel()+papeis);
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