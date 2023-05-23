package TreinarMySQL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class PersistenciaXML implements DataSource{
	private XStream xstream = new XStream(new DomDriver());
	private File arquivo;

	public PersistenciaXML() {
		xstream.addPermission(AnyTypePermission.ANY);
	}
	public void salvarDados(ContaBancaria cb) {
		ArrayList<ContaBancaria> contas = carregarDados();
		contas.add(cb);

		String xml = xstream.toXML(contas);
		File arquivo = new File("CentralBanco.xml");

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
	public ArrayList<ContaBancaria> carregarDados() {
		arquivo = new File("CentralBanco.xml");
		try {
			if(arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				List<ContaBancaria> c = (ArrayList<ContaBancaria>) xstream.fromXML(fis);
				return (ArrayList<ContaBancaria>) c;
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}