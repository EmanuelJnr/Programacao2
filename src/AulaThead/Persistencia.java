package AulaThead;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Persistencia {
	private XStream xstream = new XStream(new DomDriver());
	private File arquivo;
	
	public Persistencia() {
		xstream.addPermission(AnyTypePermission.ANY);
	}
	public void salvarCentral(CentralDeInformacoes ci, String nomeFile) {
		String xml = xstream.toXML(ci);
		arquivo = new File(nomeFile);

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
	public CentralDeInformacoes recuperarCentral(String nomeFile) {
		arquivo = new File(nomeFile);
		try {
			if(arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				return (CentralDeInformacoes) xstream.fromXML(fis);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new CentralDeInformacoes();
	}
}