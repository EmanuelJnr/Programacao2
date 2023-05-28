package Lista12;

public class Radar {
	private float veloMaxPer;
	
	public Radar(float veloMaxPer) {
		setVeloMaxPer(veloMaxPer);
	}
	public void verificarVelocidade(Veiculo v) throws VelocidadeMaximaNaoRespeitadaException{
		if(v.getVeloAtual()>porce(50))
			throw new VelocidadeMaximaNaoRespeitadaException(new Multa(v, 574.62f));
		else if(v.getVeloAtual()>porce(20))
			throw new VelocidadeMaximaNaoRespeitadaException(new Multa(v, 127.53f));
		else if(v.getVeloAtual()>veloMaxPer)
			throw new VelocidadeMaximaNaoRespeitadaException(new Multa(v, 85.13f));
		else if(v.getVeloAtual()<porce(50))
			throw new VelocidadeMinimaNaoRespeitadaException(new Multa(v, 87.33f));
	}
	public float porce(int p) {
		return veloMaxPer + veloMaxPer * p/100;
	}
	public float getVeloMaxPer() {
		return veloMaxPer;
	}
	public void setVeloMaxPer(float veloMaxPer) {
		this.veloMaxPer = veloMaxPer;
	}
}