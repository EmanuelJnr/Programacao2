package ListaAquecimento;

import java.util.ArrayList;

public class CentralDeInformacoes {
	private ArrayList<Cliente> todosOsClientes = new ArrayList<>();
	private ArrayList<Evento> todosOsEventos = new ArrayList<>();
	
	public boolean adicionarCliente(Cliente cAdd) {
		for (Cliente cliente : todosOsClientes) {
			if(cAdd.equals(cliente))
				return false;			
		}
		todosOsClientes.add(cAdd);
		return true;
	}
	public Cliente recuperarClientePorEmail(String email) {
		for (Cliente cliente : todosOsClientes) {
			if(email.equals(cliente.getEmail()))
				return cliente;
		}
		return null;
	}
	public boolean adicionarEvento(Evento eAdd) {
		for(Evento evento : todosOsEventos) {
			if(eAdd.getId()==evento.getId())
				return false;
		}
		if(eAdd.jaOcorreu()) {
			return false;
		}
		todosOsEventos.add(eAdd);
		return true;
	}
	public Evento recuperarEventoPeloId(long id) {
		for(Evento evento : todosOsEventos) {
			if(id==evento.getId())
				return evento;
		}
		return null;
	}
	public ArrayList<Evento> recuperarEventosDeUmCliente(String email){
		if(recuperarClientePorEmail(email)==null)
			return null;
		ArrayList<Evento> eventosDeUmCliente = new ArrayList<>();
		for (Evento evento : todosOsEventos) {
			if(evento.getCliente().equals(recuperarClientePorEmail(email)))
				eventosDeUmCliente.add(evento);
		}
		return eventosDeUmCliente;
	}
	public ArrayList<Cliente> getTodosOsClientes() {
		return todosOsClientes;
	}
	public void setTodosOsClientes(ArrayList<Cliente> todosOsClientes) {
		this.todosOsClientes = todosOsClientes;
	}
	public ArrayList<Evento> getTodosOsEventos() {
		return todosOsEventos;
	}
	public void setTodosOsEventos(ArrayList<Evento> todosOsEventos) {
		this.todosOsEventos = todosOsEventos;
	}
}