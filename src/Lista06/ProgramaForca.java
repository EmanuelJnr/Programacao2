package Lista06;

import java.util.Scanner;

public class ProgramaForca {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		JogoDaForca jogo = new JogoDaForca();
		Palavra[] palavras = new Palavra[2];
		
		for(int i=0;i<palavras.length;i++) {
			Palavra p = new Palavra();
			System.out.printf("Digite a %dª palavra: ",i+1);
			p.setPalavra(input.nextLine());
			System.out.printf("Digite a dica da %dª palavra: ",i+1);
			p.setDica(input.nextLine());
			palavras[i]=p;
		}
		jogo.setDicionario(palavras);
		jogo.sortear();
		int conterros=0;
		int pontuacao = 2*jogo.getDicionario()[jogo.getPosisort()].getPalavra().length();
		
		System.out.print("A dica é: ");
		System.out.println(jogo.pegarDica());
		while(jogo.testaSeAcabou()) {
			System.out.println(jogo.getGabarito());
			System.out.print("Qual letra você quer testar: ");
			String c = input.nextLine();
			if(jogo.testarLetra(c.charAt(0)))
				System.out.println("Você acertou");
			else {
				System.out.println("Você errou");
				conterros++;
			}
		}
		System.out.println(jogo.getGabarito());
		System.out.printf("Pontuação: %d",pontuacao-conterros);
		
		input.close();
	}
}