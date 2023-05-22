package TreinarMySQL;

import java.util.ArrayList;

public class CentralDeInformacoes {
	private ArrayList<ContaBancaria> todasContasBancarias = new ArrayList<>();
	
	public boolean adicionarConta(ContaBancaria cbAdd) {
		for (ContaBancaria cb : todasContasBancarias) {
			if(cbAdd.equals(cb))
				return false;			
		}
		todasContasBancarias.add(cbAdd);
		return true;
	}
	public ArrayList<ContaBancaria> getTodasContasBancarias() {
		return todasContasBancarias;
	}
}