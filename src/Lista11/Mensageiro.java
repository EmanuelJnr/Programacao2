package Lista11;

public class Mensageiro {
	public Mensagem prepararMensagem(String msg, String destino) {
		Mensagem m = new Mensagem(msg);
		
		if(destino.equals("interno"))
			return m;
		
		else if(destino.equals("externo")) {
			Decorador d = new Criptografia(msg);
			m.setTexto(d.getTexto());
			
			d = new DireitosAutorais(m.getTexto());
			m.setTexto(d.getTexto());
			
			return m;
		}
		else
			return m;
	}
}