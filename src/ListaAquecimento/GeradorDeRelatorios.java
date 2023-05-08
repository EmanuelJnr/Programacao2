package ListaAquecimento;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeradorDeRelatorios {
	public static void obterProgramacaoDoMes(CentralDeInformacoes c, Month month) {
		int check=0;
		Document documento = new Document(PageSize.A4);
		String mes = month.toString().toLowerCase();
		try {
			FileOutputStream file = new FileOutputStream("relatório "+mes+".pdf");
			PdfWriter.getInstance(documento, file);
			for(Evento e : c.getTodosOsEventos()) {
				if(e.getData().getMonthValue()==month.valorMonth && e.getData().getYear()==2023 && e.isContrato()) {
					documento.open();
					documento.add(new Paragraph(e.getInformacoesE()));
					check++;
				}
			}
			documento.close();
			if(check==0)
				System.out.println("Não há Eventos no mês informado!");
			else
				System.out.println("Relatório criado!");
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException io) {
			System.err.println(io.getMessage());
		}
	}
	/*public static void gerarRelatorioCompleto(CentralDeInformacoes c) {
		Document documento = new Document(PageSize.A4);
		try {
			FileOutputStream os = new FileOutputStream("Relatório Completo.pdf");
			PdfWriter.getInstance(documento, os);
			documento.open();
			for (Cliente cliente : c.getTodosOsClientes()) {
				Paragraph nomeC = new Paragraph(cliente.getNome());
				documento.add(nomeC);
				for(Evento evento: c.recuperarEventosDeUmCliente(cliente.getEmail())) {
					Paragraph eventos = new Paragraph(evento.toString());
					documento.add(eventos);
				}
				documento.add(new Paragraph("\n"));
			}
			documento.close();
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException io) {
			System.err.println(io.getMessage());
		}
	}*/
}