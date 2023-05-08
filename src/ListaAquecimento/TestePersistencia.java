package ListaAquecimento;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Scanner;

public class TestePersistencia {
	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central.xml");
		for (Evento eventos : central.getTodosOsEventos())
			eventos.toString();
		boolean flag = true;

		while(flag) {
			System.out.println("1-novo cliente");
			System.out.println("2-listar todos os clientes");
			System.out.println("3-exibir informações de um cliente específico");
			System.out.println("4-novo evento");
			System.out.println("5-listar todos os eventos");
			System.out.println("6-listar os eventos de um cliente");
			System.out.println("7–gerar relatório de programação do mês");
			System.out.println("8-contratar evento");
			System.out.println("S-sair");
			String op = input.nextLine();

			if(op.equals("1")) {
				System.out.print("Digite seu nome: ");
				String nome = input.nextLine();
				System.out.print("Feminino ou Masculino? ");
				Sexo sexo = Sexo.valueOf(input.nextLine().toUpperCase());
				System.out.print("Digite seu CPF: ");
				String CPF = input.nextLine();
				System.out.print("Digite seu email: ");
				String email = input.nextLine();
				if(central.adicionarCliente(new Cliente(nome, sexo, CPF, email))) {
					p.salvarCentral(central, "central.xml");
					System.out.println("Adicionado com sucesso!");
				}
				else
					System.out.println("Já existe um cliente com o mesmo email!");
			}
			else if(op.equals("2")) {
				if(central.getTodosOsClientes().size()!=0) {
					for (Cliente c : central.getTodosOsClientes())
						System.out.println(c.toString());
				}
				else
					System.out.println("Não há clientes cadastrados!");
			}
			else if(op.equals("3")) {
				if(central.getTodosOsClientes().size()!=0) {
					System.out.print("Qual email para consulta do cliente: ");
					String email = input.nextLine();
					if(central.recuperarClientePorEmail(email)!=null)
						System.out.println(central.recuperarClientePorEmail(email).getInformacoesC());
					else
						System.out.println("Cliente não encontrado!");
				}
				else
					System.out.println("Não há clientes cadastrados!");
			}
			else if(op.equals("4")) {
				Cliente c;
				System.out.print("Digite seu email: ");
				String email = input.nextLine();
				if(central.recuperarClientePorEmail(email)!=null) {
					c = central.recuperarClientePorEmail(email);
					System.out.print("Digite o nome do Evento: ");
					String nomeE = input.nextLine();
					System.out.print("Digite o local do Evento: ");
					String local = input.nextLine();
					System.out.print("Digite a data e hora do Evento:(dd/MM/yyyy HH:mm) ");
					String dataEHora = input.nextLine();
					DateTimeFormatter parser = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy HH:mm").toFormatter();
					LocalDateTime data = LocalDateTime.parse(dataEHora, parser);

					if(central.adicionarEvento(new Evento(nomeE, data, local, c, false))) {
						p.salvarCentral(central, "central.xml");
						System.out.println("Evento adicionado!");
					}
					else
						System.out.println("Evento não cadastrado!");
				}
				else
					System.out.println("Cliente não encontrado!");
			}
			else if(op.equals("5")) {
				if(central.getTodosOsEventos().size()!=0) {
					for (Evento eventos : central.getTodosOsEventos())
						System.out.println(eventos);
				}
				else
					System.out.println("Não há Eventos cadastrados!");
			}
			else if(op.equals("6")) {
				System.out.print("Digite seu email: ");
				String email = input.nextLine();
				if(central.recuperarEventosDeUmCliente(email)==null)
					System.out.println("Cliente não encontrado!");
				else if(central.recuperarEventosDeUmCliente(email).size()==0)
					System.out.println("Este cliente não tem nenhum Evento!");
				else {
					for (Evento eventos : central.recuperarEventosDeUmCliente(email))
						System.out.println(eventos);
				}
			}
			else if(op.equals("7")) {
				System.out.print("Digite o Mês: ");
				Month mes = Month.valueOf(input.nextLine().toUpperCase());
				GeradorDeRelatorios.obterProgramacaoDoMes(central, mes);
			}
			else if(op.equals("8")) {
				for (Evento eventos : central.getTodosOsEventos()) {
					if(!eventos.isContrato())
						System.out.println(eventos.getNome());
				}
				System.out.print("Digite o nome do evento que deseja contratar: ");
				String nome = input.nextLine();
				boolean envio=false;
				for(Evento evento : central.getTodosOsEventos()) {
					if(nome.equals(evento.getNome())) {
						evento.setContrato(true);
						Mensageiro m = new Mensageiro();
						System.out.println("Escreva a mensagem para o cliente:");
						m.enviarEmailParaCliente(evento, input.nextLine());
						envio = true;
						p.salvarCentral(central, "central.xml");
						System.out.println("Mensagem enviada!");
					}
				}
				if(!envio)
					System.out.println("Não enviou a mensagem!");
			}
			else {
				System.out.println("Fim do programa.");
				flag = false;
			}
		}
		input.close();
	}
}