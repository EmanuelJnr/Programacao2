package Lista03;
public class Ponto {
	private int cooX;
	private int cooY;
	
	public int getCooX() {
		return cooX;
	}
	public void setCooX(int cooX) {
		this.cooX = cooX;
	}
	public int getCooY() {
		return cooY;
	}
	public void setCooY(int cooY) {
		this.cooY = cooY;
	}
	
	public boolean eIgual(Ponto pon) {
		if (cooX == pon.getCooX()) {
			if (cooY == pon.getCooY())
				return true;
			else
				return false;
		} else
			return false;
	}
	public String quadrante() {
		if (cooX > 0 && cooY > 0)
			return "1º Quadrante";
		else if (cooX < 0 && cooY < 0)
			return "3º Quadrante";
		else if (cooX < 0 && cooY > 0)
			return "2º Quadrante";
		else if (cooX > 0 && cooY < 0)
			return "4º Quadrante";
		else if (cooX == 0 && cooY != 0)
			return "Eixo vertical";
		else if (cooY == 0 && cooX != 0)
			return "Eixo horizontal";
		return "origem";
	}
}