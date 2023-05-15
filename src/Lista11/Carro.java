package Lista11;

public abstract class Carro {
	private String modelo;
	private double preco;
	
	public Carro(String modelo, double preco) {
		setModelo(modelo);
		setPreco(preco);
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}