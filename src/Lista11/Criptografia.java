package Lista11;

public class Criptografia extends Decorador{
	
	public Criptografia(String texto) {
		super(texto);
	}
	public String getTexto() {
		setTexto(super.getTexto().replace(" ", "*"));
		return super.getTexto();
	}
}