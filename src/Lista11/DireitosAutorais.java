package Lista11;

public class DireitosAutorais extends Decorador{
	
	public DireitosAutorais(String texto) {
		super(texto);
	}
	public String getTexto() {
		setTexto(super.getTexto().concat("... [Direitos Reservados]."));
		return super.getTexto();
	}
}