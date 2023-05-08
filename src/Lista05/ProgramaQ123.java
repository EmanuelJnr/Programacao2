package Lista05;

import java.util.Scanner;

public class ProgramaQ123 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MaquinaDeLavar m = new MaquinaDeLavar();
		
		System.out.print("Quantas roupas irá lavar? ");
		int qtroupas = Integer.parseInt(input.nextLine());
		
		Roupa[] roupas = new Roupa[qtroupas];
		for(int i=0;i<roupas.length;i++) {
			Roupa r = new Roupa();
			System.out.print("Qual a cor da "+(i+1)+"ª roupa: ");
			r.setCor(TipoCor.valueOf(input.nextLine().toUpperCase()));
			
			System.out.print("Qual o estado da "+(i+1)+"ª roupa: ");
			r.setEstado(TipoEstado.valueOf(input.nextLine().toUpperCase()));
			
			System.out.print("Qual o tamanho da "+(i+1)+"ª roupa: ");
			r.setTamanho(TipoTamanho.valueOf(input.nextLine().toUpperCase()));
			roupas[i] = r;
		}
		for(Roupa r:roupas)
			System.out.println(r.getCor()+", "+r.getEstado()+", "+r.getTamanho());
		
		int tempo = m.lavar(roupas);
		if(tempo==-1)
			System.out.println("Não é possível lavar as roupas!");
		else
			System.out.println("O tempo de lavagem será: "+tempo);
		
		for(Roupa r:roupas)
			System.out.println(r.getCor()+", "+r.getEstado()+", "+r.getTamanho());
		
		input.close();
	}
}