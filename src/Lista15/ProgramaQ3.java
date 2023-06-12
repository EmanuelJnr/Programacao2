package Lista15;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class ProgramaQ3 extends JFrame{
	private static final long serialVersionUID = 1L;
	private JFrame cad,list;
	private JTextField ctNome;
	private JFormattedTextField ctData;
	private ArrayList<Evento> eventos = new ArrayList<>();

	public ProgramaQ3() {
		janelaCadastro();
		janelaListagem();
	}
	public static void main(String[] args) {
		new ProgramaQ3();
	}
	public class Evento {
		String nome;
		LocalDate data;
		
		public Evento(String nome, LocalDate data) {
			this.nome = nome;
			this.data = data;
		}
	}

	public void janelaCadastro() {
		cad = new JFrame("Cadastro");
		cad.setSize(300, 250);
		cad.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cad.setResizable(false);
		cad.setLayout(null);
		cad.setLocationRelativeTo(null);
		addCamposTexto();
		addBotao();
		cad.setVisible(true);
	}
	public void addCamposTexto() {
		ctNome = new JTextField();
		ctNome.setBounds(20, 30, 230, 30);
		cad.add(ctNome);

		MaskFormatter mascara1;
		try {
			mascara1 = new MaskFormatter("##/##/####");
			ctData = new JFormattedTextField(mascara1);
			ctData.setBounds(20, 75, 230, 30);
			cad.add(ctData);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public LocalDate verificaData(String strDate) {
		try {
			DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/uuuu")
					.withResolverStyle(ResolverStyle.STRICT);
			LocalDate data = LocalDate.parse(strDate, dTF);

			if(data.isAfter(LocalDate.now()))
				return data;
			else {
				throw new Exception();
			}
		}catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, "Data inválida!");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Essa data já ocorreu!");
		}
		return null;
	}
	public void addBotao() {
		JButton btAdicionar = new JButton("Adicionar");
		btAdicionar.setBounds(20, 120, 230, 30);
		cad.add(btAdicionar);

		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verificaData(ctData.getText())==null)
					return;
				eventos.add(new Evento(ctNome.getText(), verificaData(ctData.getText())));
				JOptionPane.showMessageDialog(null, "Evento cadastrado!");
				list.dispose();
				janelaListagem();
			}
		});
	}

	public void janelaListagem() {
		list = new JFrame("Listagem");
		list.setSize(300, 350);
		list.setDefaultCloseOperation(EXIT_ON_CLOSE);
		list.setResizable(false);
		list.setLayout(null);
		list.setLocation(cad.getLocation().x - 305, cad.getLocation().y);
		addTabela();
		list.setVisible(true);
	}
	
	public void addTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nome");
		modelo.addColumn("Data");

		for(Evento e : eventos) {
			Object[] linha = new Object[2];
			linha[0] = e.nome;
			linha[1] = e.data;
			modelo.addRow(linha);
		}
		JTable tabela = new JTable(modelo) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
		JScrollPane painelScrow = new JScrollPane(tabela);
		painelScrow.setBounds(8, 15, 270, 280);
		list.add(painelScrow);
	          
		tabela.addMouseListener( new MouseAdapter(){
		    public void mouseClicked(MouseEvent e){
		        if(e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
		        	int selectedRow = tabela.getSelectedRow();
					int respo = JOptionPane.showConfirmDialog(null, "Deseja deletar o evento?", "Deletar", JOptionPane.YES_NO_OPTION);
					if(respo==0) {
						eventos.remove(selectedRow);
					}
					list.dispose();
					janelaListagem();
		        }
		    }
		});
	}
}