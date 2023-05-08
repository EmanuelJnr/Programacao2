package Lista07;

import java.util.Scanner;

public class ProgramaQ6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Pessoa[] povo = new Pessoa[3];
		int contE=0;
		
		for(int i=0;i<povo.length;) {
			System.out.print("Qual o nome da "+(i+1)+"ª pessoa: ");
			String nome = input.nextLine();
			System.out.print("Qual a idade da "+(i+1)+"ª pessoa: ");
			int idade = Integer.parseInt(input.nextLine());
			System.out.print("Qual o estado civil da "+(i+1)+"ª pessoa: ");
			EstadoCivil estadocivil = EstadoCivil.valueOf(input.nextLine().toUpperCase());
			Pessoa p = new Pessoa(nome, estadocivil, idade);
			
			boolean add=true;
			for(int j=0;j<i;j++) {
				if(p.equals(povo[j])) {
					System.out.println("Pessoa repetida! Não foi possível adicionar.");
					contE++;
					add=false;
					break;
				}
			}
			if(add) {
				//System.out.println(p.getId());
				povo[i]=p;
				i++;
			}
		}
		int contS=0;
		int contC=0;
		for(Pessoa p:povo) {
			//System.out.println(p.getId());
			if(p.getEstadoCivil().equals(EstadoCivil.SOLTEIRO))
				contS++;
			else if(p.getEstadoCivil().equals(EstadoCivil.CASADO))
				contC++;
			System.out.println(p.toString());
		}
		System.out.println("Solteiros: "+contS);
		System.out.println("Casados: "+contC);
		System.out.println("Erros: "+contE);
		
		input.close();
	}
}