package Lista10;

public class Pokemon {
	private String nome;
	private String tipo;
	private int nivel=5;
	private StrategyAtaque ataqueA;
	private StrategyAtaque ataqueB;
	private StrategyAtaque ataqueC;
	private StrategyAtaque ataqueD;
	
	public Pokemon(String nome, String tipo) {
		setNome(nome);
		setTipo(tipo);
		setAtaqueA(new RazorLeaf());
		setAtaqueB(new EarthQuake());
		setAtaqueC(null);
		setAtaqueD(null);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public StrategyAtaque getAtaqueA() {
		return ataqueA;
	}
	public void setAtaqueA(StrategyAtaque ataqueA) {
		this.ataqueA = ataqueA;
	}
	public StrategyAtaque getAtaqueB() {
		return ataqueB;
	}
	public void setAtaqueB(StrategyAtaque ataqueB) {
		this.ataqueB = ataqueB;
	}
	public StrategyAtaque getAtaqueC() {
		return ataqueC;
	}
	public void setAtaqueC(StrategyAtaque ataqueC) {
		this.ataqueC = ataqueC;
	}
	public StrategyAtaque getAtaqueD() {
		return ataqueD;
	}
	public void setAtaqueD(StrategyAtaque ataqueD) {
		this.ataqueD = ataqueD;
	}
}