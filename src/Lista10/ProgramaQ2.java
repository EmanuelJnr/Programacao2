package Lista10;

import java.util.ArrayList;
import java.util.Scanner;

public class ProgramaQ2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Cliente> clientes = new ArrayList<>();

		for(int i=0;i<3;i++) {
			System.out.print("1-Cadastrar Clente Comum ou 2-Cadastrar Clente VIP: ");
			
			if(input.nextLine().equals("1"))
				clientes.add(new ClienteC());
			else
				clientes.add(new ClienteV());

			System.out.print("Informe o nome do cliente: ");
			clientes.get(i).setNome(input.nextLine());
			System.out.print("Informe o CPF do cliente: ");
			clientes.get(i).setCPF(input.nextLine());
		}

		System.out.print("Para realizar a compra da passagem informe seu CPF: ");
		double total=0;
		for (Cliente c : clientes) {
			if(c.getCPF().equals(input.nextLine())) {
				if(c instanceof ClienteV)
					total=(1000-1000*0.35);
				else
					total+=1000;
			}
		}
		if(total==0)
			System.out.println("CPF não encontrado!");
		else
			System.out.println("Você irá pagar: "+total+" reais");
		input.close();
	}
}