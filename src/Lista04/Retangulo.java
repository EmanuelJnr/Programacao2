package Lista04;
public class Retangulo {
	private int base;
	private int altura;
	
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public boolean isQuadrado() {
		if (altura == base)
			return true;
		return false;
	}
	public void autoDesenhar() {
		for(int i=0;i<altura;i++) {
			for(int j=0;j<base;j++)
				System.out.print("O");
			System.out.println("");
		}
	}
}