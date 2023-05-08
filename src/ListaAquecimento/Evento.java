package ListaAquecimento;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Evento {
	private long id;
	private String nome;
	private LocalDateTime data;
	private String local;
	private Cliente cliente;
	private boolean contrato;

	public Evento(String nome, LocalDateTime data, String local, Cliente cliente, boolean contrato) {
		id = System.currentTimeMillis();
		setNome(nome);
		setData(data);
		setLocal(local);
		setCliente(cliente);
		setContrato(contrato);
	}
	public Evento() {
		id = System.currentTimeMillis();
	}
	public String toString() {
		String[] priNome = cliente.getNome().split(" ");
		DateTimeFormatter parser = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy HH:mm").toFormatter();
		return priNome[0]+" convida para seu "+nome+", "+(jaOcorreu() ? "realizado" : "a ser realizado")+" em "+data.format(parser)+", "+local+", "+(this.contrato ? "contratado" : "não contratado");
	}
	public String getInformacoesE() {
		DateTimeFormatter parser = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy HH:mm").toFormatter();	
		return "Evento: "+nome+", "+(jaOcorreu() ? "realizado" : "a ser realizado")+" em "+data.format(parser)+"h, local: "+local+"\n"+cliente.getInformacoesC();
	}
	public boolean jaOcorreu() {
		if(data.isBefore(LocalDateTime.now()))
			return true;
		return false;
	}
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public boolean isContrato() {
		return contrato;
	}
	public void setContrato(boolean contrato) {
		this.contrato = contrato;
	}
}