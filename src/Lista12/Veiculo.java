package Lista12;

public class Veiculo {
	private String placa;
	private float veloAtual;
	private String nomeProprietario;
	
	public Veiculo(float veloAtual) {
		setVeloAtual(veloAtual);
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public float getVeloAtual() {
		return veloAtual;
	}
	public void setVeloAtual(float veloAtual) {
		this.veloAtual = veloAtual;
	}
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
}