package Lista12;

import java.util.ArrayList;

public class ProgramaQ6 {
	public static void main(String[] args) {
		ArrayList<Veiculo> veiculos = new ArrayList<>();

		for(int i=0;i<100;i++) {
			int rand = (int)(Math.random() * 112) + 40;
			veiculos.add(new Veiculo(rand));
		}
		Radar r = new Radar(90);
		for(Veiculo v : veiculos) {
			try {
				r.verificarVelocidade(v);
				System.out.println("Não foi multado");
			}catch (VelocidadeMaximaNaoRespeitadaException e) {
				System.out.println(e+"\nMultado em R$ "+e.getM().getValorMulta());
			}
		}
		System.out.println("Total de multas: "+VelocidadeMaximaNaoRespeitadaException
				.contMultas+"\nValor total R$ "+
				VelocidadeMaximaNaoRespeitadaException.somaMultas);
	}
}