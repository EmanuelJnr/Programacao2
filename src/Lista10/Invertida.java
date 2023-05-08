package Lista10;

public class Invertida extends FormatacaoTexto{

	@Override
	public String formatarTexto(String texto) {
		return new StringBuilder(texto).reverse().toString();
	}
}