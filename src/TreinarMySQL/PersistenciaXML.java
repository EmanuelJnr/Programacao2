package TreinarMySQL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class PersistenciaXML implements Persistencia{
	private XStream xstream = new XStream(new DomDriver());
	private File arquivo;

	public PersistenciaXML() {
		xstream.addPermission(AnyTypePermission.ANY);
	}

	public void salvarContaBancaria(ContaBancaria cbAdd) {
		for(ContaBancaria cbs: carregarContasBancaria()) {
			if(cbAdd.equals(cbs))
				return;
		}
		ArrayList<ContaBancaria> contas = carregarContasBancaria();
		contas.add(cbAdd);

		String xml = xstream.toXML(contas);
		File arquivo = new File("ContasBancarias.xml");

		try {
			if(!arquivo.exists())
				arquivo.createNewFile();
			PrintWriter gravar = new PrintWriter(arquivo);
			gravar.print(xml);
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public ArrayList<ContaBancaria> carregarContasBancaria() {
		arquivo = new File("ContasBancarias.xml");
		try {
			if(arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				List<ContaBancaria> cbs = (ArrayList<ContaBancaria>) xstream.fromXML(fis);
				return (ArrayList<ContaBancaria>) cbs;
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	public ContaBancaria recuperarContaBancariaID(UUID idContaBancaria) {
		for (ContaBancaria cbs : carregarContasBancaria()) {
			if(cbs.getIdContaBancaria().equals(idContaBancaria)) {
				return cbs;
			}
		}
		return null;
	}

	public void salvarCliente(Cliente cAdd) {
		for(Cliente c: carregarClientes()) {
			if(cAdd.equals(c))
				return;
		}
		ArrayList<Cliente> clientes = carregarClientes();
		clientes.add(cAdd);

		String xml = xstream.toXML(clientes);
		File arquivo = new File("Clientes.xml");

		try {
			if(!arquivo.exists())
				arquivo.createNewFile();
			PrintWriter gravar = new PrintWriter(arquivo);
			gravar.print(xml);
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> carregarClientes() {
		arquivo = new File("Clientes.xml");
		try {
			if(arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				List<Cliente> c = (ArrayList<Cliente>) xstream.fromXML(fis);
				return (ArrayList<Cliente>) c;
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	public Cliente recuperarClienteID(UUID idCliente) {
		for (Cliente c : carregarClientes()) {
			if(c.getIdCliente().equals(idCliente)) {
				return c;
			}
		}
		return null;
	}
}