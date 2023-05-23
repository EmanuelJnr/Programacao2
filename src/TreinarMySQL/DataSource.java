package TreinarMySQL;

import java.util.ArrayList;

public interface DataSource {
	public void salvarDados(ContaBancaria cb);
	public ArrayList<ContaBancaria> carregarDados();
}