package TestePersistencia;
import java.util.Scanner;

public class ProgramaQ45678 {
	public static void main(String[] args) throws Exception {
		PersistenciaLivraria pl = new PersistenciaLivraria();
		Scanner input = new Scanner(System.in);
		Livraria liv = pl.recuperarLivraria("livraria.xml");
		
		int opcao = 0;
		
		while (opcao!=5) {
			System.out.println("1) Cadastrar um novo livro no estoque");
			System.out.println("2) Listar o estoque");
			System.out.println("3) Vender um livro");
			System.out.println("4) Consultar o caixa da livraria");
			System.out.println("5) Sair");
			opcao = Integer.parseInt(input.nextLine());
			switch (opcao) {
			case 1: {
				Livro l = new Livro();
				System.out.print("Qual o título do livro: ");
				l.setTitulo(input.nextLine());
				System.out.print("Qual o ano de publicação: ");
				l.setAnopubli(Integer.parseInt(input.nextLine()));
				System.out.print("Qual a quantidade disponível: ");
				l.setQtdisponivel(Integer.parseInt(input.nextLine()));
				System.out.print("Qual o preço: ");
				l.setPreco(Float.parseFloat(input.nextLine()));
				if(liv.cadastarLivro(l)) {
					pl.salvarLivraria(liv);
					System.out.println("Cadastro bem sucedido");
				}
				else
					System.out.println("Não cadastrou");
				break;
			}
			case 2: {
				if(liv.getQtlivroscad()==0)
					System.out.println("Nenhum livro cadastrado");
				else {
					for(Livro l:liv.getLivros()) {
						System.out.println("Título: "+l.getTitulo());
						System.out.println("Quantidade: "+l.getQtdisponivel());
					}
				}
				break;
			}
			case 3: {
				if(liv.getQtlivroscad()==0)
					System.out.println("Nenhum livro cadastrado");
				else {
					System.out.print("Qual o título do livro que deseja comprar: ");
					String titulo = input.nextLine();
					System.out.println(liv.comprarLivro(titulo));
					pl.salvarLivraria(liv);
				}
				break;
			}
			case 4: {
				System.out.printf("O total em caixa é: %.2f reais\n", liv.getSaldoEmCaixa());
				break;
			}
			case 5:
				System.out.println("Saiu");
				break;
			default:
				System.out.println("Essa opção não é válida");;
			}
		}
		input.close();
	}
}