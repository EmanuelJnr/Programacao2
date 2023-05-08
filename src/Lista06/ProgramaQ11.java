package Lista06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class ProgramaQ11 {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		JogoDaForca jogo = new JogoDaForca();
		//FileWriter arq = new FileWriter("CriaTXT.txt");
		//PrintWriter gravaNoTXT = new PrintWriter(arq);
		//gravaNoTXT.printf("+--Resultado--+%n");
		//arq.close();
		Path caminho = Paths.get("File.txt");
		
		byte[] texto = Files.readAllBytes(caminho);
		String leitura = new String(texto);
		Stream<String> lines = leitura.lines();
		Object[] linhas = lines.toArray();
		
		Palavra[] palavras = new Palavra[linhas.length];
		
		for(int i=0;i<palavras.length;i++) {
			Palavra p = new Palavra();
			String txts[] = ((String) linhas[i]).split(", ");
			p.setPalavra(txts[0]);
			p.setDica(txts[1]);
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
			if(jogo.testarLetra(c.charAt(0))) {
				System.out.println("Você acertou");
			} else {
				System.out.println("Você errou");
				conterros++;
			}
		}
		System.out.println(jogo.getGabarito());
		System.out.printf("Pontuação: %d",pontuacao-conterros);
		
		input.close();
	}
}