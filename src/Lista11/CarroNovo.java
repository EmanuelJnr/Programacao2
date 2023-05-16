package Lista11;

import java.text.NumberFormat;
import java.util.Locale;

public class CarroNovo extends Carro{
	private double percentualAcres;
	
	public CarroNovo(String modelo, double preco) {
		super(modelo, preco);
		setPercentualAcres(super.getPreco()*0.10);
	}
	public String toString() {
		NumberFormat dinheiro = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
		String acres = "Preço mais acréscimo: "+dinheiro.format(getPreco());
		return "Carro novo, "+super.getModelo()+", "+dinheiro.format(super.getPreco())+"\n"+acres;
	}
	public double getPreco() {
		return super.getPreco()+getPercentualAcres();
	}
	public double getPercentualAcres() {
		return percentualAcres;
	}
	public void setPercentualAcres(double percentualAcres) {
		this.percentualAcres = percentualAcres;
	}
}