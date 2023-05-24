package TreinarMySQL;

import java.util.ArrayList;

public interface Persistencia {
	public void salvarDados(ContaBancaria cb);
	public ArrayList<ContaBancaria> carregarDados();
}