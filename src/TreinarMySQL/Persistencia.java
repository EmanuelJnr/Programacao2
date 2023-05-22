package TreinarMySQL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Persistencia {
	private XStream xstream = new XStream(new DomDriver());
	private File arquivo;

	public Persistencia() {
		xstream.addPermission(AnyTypePermission.ANY);
	}
	public void salvarContaBancaria(ContaBancaria cb) throws IOException{
		String xml = xstream.toXML(cb);
		arquivo = new File("CentralBanco.xml");


		if(!arquivo.exists())
			arquivo.createNewFile();
		/*String myXML = xstream.toXML(myPOJO);
			BufferedWriter writer = new BufferedWriter(new FileWriter("myFile.xml"));
			writer.write(myXML); //salva fisicamente
			writer.close();*/

		PrintWriter gravar = new PrintWriter(arquivo);
		gravar.print(xml);
		gravar.close();
	}
	public ContaBancaria recuperarContaBancaria() throws FileNotFoundException {
		arquivo = new File("CentralBanco.xml");

		if(arquivo.exists()) {
			FileInputStream fis = new FileInputStream(arquivo);
			return (ContaBancaria) xstream.fromXML(fis);
		}
		return null;
	}
	public ArrayList<ContaBancaria> recuperarContas() throws FileNotFoundException, ParserConfigurationException, IOException, SAXException {
		File arquivo = new File("CentralBanco.xml");

		// Cria um DocumentBuilder para fazer o parsing do arquivo XML
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		// Faz o parsing do arquivo XML e obtém o documento
		Document documento = dBuilder.parse(arquivo);
		documento.getDocumentElement().normalize();

		// Obtém todos os elementos com o nome desejado (exemplo: "nomeDaClasse")
		NodeList nodeList = documento.getElementsByTagName("ContaBancaria");

		ArrayList<ContaBancaria> contas = new ArrayList<>();

		// Itera sobre os elementos encontrados e cria os objetos correspondentes
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element elemento = (Element) nodeList.item(i);

			// Extrai os dados do elemento para criar um objeto
			/*int id = Integer.parseInt(elemento.getAttribute("id"));
			String nome = elemento.getElementsByTagName("nome").item(0).getTextContent();
			int valor = Integer.parseInt(elemento.getElementsByTagName("valor").item(0).getTextContent());*/
			
			String nome,tipo,dataCriacao;
			double saldo;
			
			nome = elemento.getAttribute("nome");
			saldo = Double.parseDouble(elemento.getAttribute("saldo"));
			tipo = elemento.getAttribute("tipo");
			dataCriacao = elemento.getAttribute("dataCriacao");

			contas.add(new ContaBancaria(nome, saldo, tipo, dataCriacao));
		}

		return contas;
	}
}