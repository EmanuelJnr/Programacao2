package Lista12;

public class Radar {
	private float veloMaxPer;
	
	public Radar(float veloMaxPer) {
		this.veloMaxPer = veloMaxPer;
	}
	public void verificarVelocidade(Veiculo v) throws VelocidadeMaximaNaoRespeitadaException{
		if(v.getVeloAtual()>porce(getVeloMaxPer(),50)) {
			throw new VelocidadeMaximaNaoRespeitadaException(new Multa(v, 574.62f));
		}
		else if(v.getVeloAtual()>porce(getVeloMaxPer(),20)) {
			throw new VelocidadeMaximaNaoRespeitadaException(new Multa(v, 127.53f));
		}
		else if(v.getVeloAtual()>getVeloMaxPer()) {
			throw new VelocidadeMaximaNaoRespeitadaException(new Multa(v, 85.13f));
		}
		else if(v.getVeloAtual()<getVeloMaxPer()*0.50) {
			throw new VelocidadeMinimaNaoRespeitadaException(new Multa(v, 87.33f));
		}
	}
	public float porce(float valor, int porce) {
		return valor + valor * porce/100;
	}
	public float getVeloMaxPer() {
		return veloMaxPer;
	}
	public void setVeloMaxPer(float veloMaxPer) {
		this.veloMaxPer = veloMaxPer;
	}
}