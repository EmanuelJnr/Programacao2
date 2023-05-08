package Lista02;

public class AgenteDeImportacao {
	public float converter(ProdutoImportado prod){
		return (float) (prod.getPreco()*5.18);
	}
	
	public float calcularImposto(ProdutoImportado prod){
		return (float) (converter(prod)*0.60);
	}
}