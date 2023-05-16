package Lista11;

import java.text.NumberFormat;
import java.util.Locale;

public class CarroUsado extends Carro{
	private double percentualDesc;
	
	public CarroUsado(String modelo, double preco) {
		super(modelo, preco);
		setPercentualDesc(super.getPreco()*0.10);
	}
	public String toString() {
		NumberFormat dinheiro = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
		String desc = "Preço mais desconto: "+dinheiro.format(getPreco());
		return "Carro usado, "+super.getModelo()+", "+dinheiro.format(super.getPreco())+"\n"+desc;
	}
	public double getPreco() {
		return super.getPreco()-getPercentualDesc();
	}
	public double getPercentualDesc() {
		return percentualDesc;
	}
	public void setPercentualDesc(double percentualDesc) {
		this.percentualDesc = percentualDesc;
	}
}