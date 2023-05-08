package TestePersistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class PersistenciaLivraria {
	private XStream xstream = new XStream(new DomDriver());
	private File arquivo = new File("Livraria.xml");
	
	public PersistenciaLivraria() {
		xstream.addPermission(AnyTypePermission.ANY);
	}
	public void salvarLivraria(Livraria livraria) {
		String xml = xstream.toXML(livraria);
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
	
	public Livraria recuperarLivraria(String nomeFile) {
		arquivo = new File(nomeFile);
		try {
			if(arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				return (Livraria) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new Livraria();
	}
}