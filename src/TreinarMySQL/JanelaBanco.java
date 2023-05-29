package TreinarMySQL;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

public class JanelaBanco extends JFrame{
	static final long serialVersionUID = 1L;
	private Persistencia p;
	private MeuTextField tfNome;
	private MeuTextField tfSaldo;
	private JRadioButton contaPoupanca;
	private JRadioButton contaCorrente;
	private JFormattedTextField tfDataCriacao;

	public JanelaBanco() {
		super("Programa Banco");
		escolherBanco();
		setSize(500, 700);
		setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/TreinarMySQL/banco.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		adicionarLabels();
		adicionarBotões();
		adicionarTabela();
		adicionarRadioButton();
		adicionarTextFields();
		setVisible(true);
	}
	public void escolherBanco() {
		String[] op = {"XML", "MySQL"};
		var selection = JOptionPane.showOptionDialog(null, "Selecione um Banco de Dados:", 
				"Banco de Dados", 0, 3, null, op, op[0]);

		if (selection == 0)
			p = new PersistenciaXML();
		else
			p = new PersistenciaMySQL();
	}
	public void adicionarLabels() {
		JLabel nome = new JLabel("Nome");
		nome.setBounds(100, 100, 33, 25);
		add(nome);

		JLabel saldo = new JLabel("Saldo");
		saldo.setBounds(100, 150, 32, 25);
		add(saldo);

		JLabel dataCriacao = new JLabel("Data da Criação");
		dataCriacao.setBounds(100, 250, 90, 25);
		add(dataCriacao);
	}
	private void adicionarBotões() {
		JButton cadConta = new JButton("Cadastrar Conta");
		cadConta.setBounds(316, 560, 138, 30);
		add(cadConta);

		cadConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = tfNome.getText();
					double saldo = Double.parseDouble(tfSaldo.getText());

					String tipo;
					if(contaPoupanca.isSelected())
						tipo = "Poupança";
					else
						tipo = "Corrente";

					Date dataCriacao = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					dataCriacao = sdf.parse(tfDataCriacao.getText());

					ContaBancaria cb = new ContaBancaria(nome,saldo,tipo,dataCriacao);
					p.salvarDados(cb);
					adicionarTabela();
				}catch(ParseException pe) {
					JOptionPane.showMessageDialog(null, "Data inválida!");
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Saldo inválido!");
				}
			}
		});
	}
	private void adicionarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabela = new JTable(modelo);
		modelo.addColumn("Nome");
		modelo.addColumn("Saldo");
		modelo.addColumn("Tipo da Conta");
		modelo.addColumn("Data de Criação");

		for (ContaBancaria c : p.carregarDados()) {
			Object[] linha = new Object[modelo.getColumnCount()];
			linha[0] = c.getNome();
			linha[1] = c.getSaldo();
			linha[2]= c.getTipo();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			linha[3] = sdf.format(c.getDataCriacao());
			modelo.addRow(linha);
		}

		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
		tabela.setRowSorter(sorter);
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(30, 300, 425, 250);
		add(painel);
	}
	private void adicionarRadioButton() {
		contaPoupanca = new JRadioButton("Conta Poupança", true);
		contaPoupanca.setBounds(100, 200, 118, 25);

		contaCorrente = new JRadioButton("Conta Corrente");
		contaCorrente.setBounds(232, 200, 118, 25);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(contaPoupanca);
		grupo.add(contaCorrente);

		add(contaPoupanca);
		add(contaCorrente);
	}
	private void adicionarTextFields() {
		tfNome = new MeuTextField("", 150, 100, 190, 25);
		tfNome.setDocument(new LimitaCaracteres(LimitaCaracteres.TipoEntrada.NOME));
		tfNome.addFocusListener(new OuvinteFocoNome(tfNome));
		add(tfNome);

		tfSaldo = new MeuTextField("", 150, 150, 190, 25);
		tfSaldo.setDocument(new LimitaCaracteres(LimitaCaracteres.TipoEntrada.NUMERODECIMAL));
		tfSaldo.addFocusListener(new OuvinteFocoSaldo(tfSaldo));
		add(tfSaldo);

		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			tfDataCriacao = new JFormattedTextField(mascaraData);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,"Data inválida!");
		}
		tfDataCriacao.setBounds(210, 250, 130, 25);
		add(tfDataCriacao);
	}
}