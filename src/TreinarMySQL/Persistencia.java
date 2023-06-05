package TreinarMySQL;

import java.util.ArrayList;
import java.util.UUID;

public interface Persistencia {
	
	public void salvarContaBancaria(ContaBancaria cb);
	
	public ArrayList<ContaBancaria> carregarContasBancaria();
	
	public ContaBancaria recuperarContaBancariaID(UUID idContaBancaria);
	
	public void salvarCliente(Cliente c);
	
	public ArrayList<Cliente> carregarClientes();
	
	public Cliente recuperarClienteID(UUID idCliente);
	
}