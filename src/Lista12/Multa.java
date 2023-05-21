package Lista12;

public class Multa {
	private Veiculo veiculo;
	private float valorMulta;
	
	public Multa(Veiculo veiculo, float valorMulta) {
		setVeiculo(veiculo);
		setValorMulta(valorMulta);
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public float getValorMulta() {
		return valorMulta;
	}
	public void setValorMulta(float valorMulta) {
		this.valorMulta = valorMulta;
	}
}