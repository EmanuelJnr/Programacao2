package Lista08;

import java.util.Scanner;

public class ProgramaQ9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ContaPoupanca[] p = new ContaPoupanca[100];
		ContaCorrente[] c = new ContaCorrente[100];
		int contP=0;
		int contC=0;
		
		for(int i=0;i<100;i++) {
			System.out.print("1-Conta Poupança e 2-Conta Corrente: ");
			String tipo = input.nextLine();
			
			System.out.print("Qual o saldo da conta? ");
			float saldo = Float.parseFloat(input.nextLine());
			System.out.print("Quem é o titular? ");
			String titular = input.nextLine();
			System.out.print("Qual o número da conta? ");
			String numero = input.nextLine();
			
			if(tipo.equals("1")) {
				System.out.print("Qual a taxa de rendimento? ");
				float taxaRendimento = Float.parseFloat(input.nextLine());
				p[contP++] = new ContaPoupanca(saldo, titular, numero, taxaRendimento);
			}
			else {
				System.out.print("Qual o valor do cheque especial? ");
				float chequeEspecial = Float.parseFloat(input.nextLine());
				c[contC++] = new ContaCorrente(saldo, titular, numero, chequeEspecial);
			}
		}
		for (int i=0;i<100;i++) {
			if(p[i]!=null)
				System.out.println(p[i]);
			if(c[i]!=null)
				System.out.println(c[i]);
		}
		System.out.println("Tem "+contP+" contas poupança");
		System.out.println("Tem "+contC+" contas correntes");
		
		input.close();
	}
}