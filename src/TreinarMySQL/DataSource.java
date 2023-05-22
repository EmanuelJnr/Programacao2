package TreinarMySQL;

public interface DataSource {
	public void salvarDados(String dados);
	public String carregarDados();
}