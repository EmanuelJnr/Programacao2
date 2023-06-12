package TreinarMySQL;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import Util.Labels;
import Util.LimitaCaracteres;
import Util.MeuTextField;
import Util.OuvinteFocoIdade;
import Util.OuvinteFocoNome;
import Util.OuvinteFocoSaldo;

public class JanelaBanco extends JFrame{
	static final long serialVersionUID = 1L;
	private Persistencia p;
	private MeuTextField tfNome;
	private MeuTextField tfIdade;
	private MeuTextField tfNumero;
	private MeuTextField tfSaldo;
	private JRadioButton contaPoupanca;
	private JRadioButton contaCorrente;

	public JanelaBanco() {
		super("Programa Banco");
		escolherBanco();
		setSize(800, 650);
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
		add(new Labels("Nome do Cliente", 100, 50, 98, 25));

		add(new Labels("Idade do Cliente", 100, 100, 98, 25));

		add(new Labels("Saldo", 100, 150, 32, 25));

		add(new Labels("Número da Conta", 100, 250, 98, 25));
		
		JLabel img = new JLabel();
		img.setBounds(480, 40, 240, 240);
		img.setIcon(getImg("banco.png", 240,240));
		add(img);
	}
	public static ImageIcon getImg(String nome, int x, int y) {
		ImageIcon icone = new ImageIcon("src/TreinarMySQL/" + nome);
		Image image = icone.getImage();
		Image newimg = image.getScaledInstance(x, y,  java.awt.Image.SCALE_SMOOTH);
		return icone = new ImageIcon(newimg);
	}
	private void adicionarBotões() {
		JButton cadConta = new JButton("Cadastrar Conta");
		cadConta.setBounds(316, 560, 138, 30);
		add(cadConta);

		cadConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = tfNome.getText();
					int idade = Integer.parseInt(tfIdade.getText());
					String numero = tfNumero.getText();
					double saldo = Double.parseDouble(tfSaldo.getText());
					String tipo;
					if(contaPoupanca.isSelected()) {
						tipo = "Poupança";
					}
					else
						tipo = "Corrente";
					for (ContaBancaria cbs : p.carregarContasBancaria()) {
						if(cbs.getNumero().equals(numero))
							return;
					}
					
					for (Cliente c : p.carregarClientes()) {
						if(c.getNome().equals(nome)) {
							if(c.isTemCorrente() && c.isTemPoupanca())
								return;
							else if(c.isTemCorrente() && contaCorrente.isSelected()) {
								return;
							}
							else if(c.isTemPoupanca() && contaPoupanca.isSelected()) {
								return;
							}
							else {
								if(contaPoupanca.isSelected())
									c.setTemPoupanca(true);
								else if(contaPoupanca.isSelected())
									c.setTemCorrente(true);;
								ContaBancaria cb = new ContaBancaria(c.getIdCliente(),numero,saldo,tipo);
								System.out.println(c.isTemCorrente()+", "+c.isTemPoupanca());
								p.salvarContaBancaria(cb);
								adicionarTabela();
								return;
							}
						}
					}
					Cliente c = new Cliente(nome, idade, contaCorrente.isSelected(), contaPoupanca.isSelected());
					ContaBancaria cb = new ContaBancaria(c.getIdCliente(),numero,saldo,tipo);
					System.out.println(c.isTemCorrente()+", "+c.isTemPoupanca());
					p.salvarCliente(c);
					p.salvarContaBancaria(cb);
					adicionarTabela();
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Saldo inválido!");
				}
			}
		});
	}
	private void adicionarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabela = new JTable(modelo);
		modelo.addColumn("Nome do Cliente");
		modelo.addColumn("Saldo");
		modelo.addColumn("Tipo da Conta");
		modelo.addColumn("Número da Conta");
		modelo.addColumn("Data de Criação");

		for (ContaBancaria cbs : p.carregarContasBancaria()) {
			Object[] linha = new Object[modelo.getColumnCount()];
			if(p.recuperarClienteID(cbs.getIdCliente())!=null)
				linha[0] = p.recuperarClienteID(cbs.getIdCliente()).getNome();
			linha[1] = cbs.getSaldo();
			linha[2] = cbs.getTipo();
			linha[3] = cbs.getNumero();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			linha[4] = sdf.format(cbs.getDataCriacao());
			modelo.addRow(linha);
		}

		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
		tabela.setRowSorter(sorter);
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(10, 300, 765, 250);
		add(painel);
	}
	private void adicionarRadioButton() {
		contaPoupanca = new JRadioButton("Conta Poupança", true);
		contaPoupanca.setBounds(100, 200, 118, 25);

		contaCorrente = new JRadioButton("Conta Corrente");
		contaCorrente.setBounds(283, 200, 118, 25);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(contaPoupanca);
		grupo.add(contaCorrente);

		add(contaPoupanca);
		add(contaCorrente);
	}
	private void adicionarTextFields() {
		tfNome = new MeuTextField("", 203, 50, 190, 25);
		tfNome.setDocument(new LimitaCaracteres(LimitaCaracteres.TipoEntrada.NOME));
		tfNome.addFocusListener(new OuvinteFocoNome(tfNome));
		add(tfNome);

		tfIdade = new MeuTextField("", 203, 100, 190, 25);
		tfIdade.setDocument(new LimitaCaracteres(LimitaCaracteres.TipoEntrada.NUMEROIDADE));
		tfIdade.addFocusListener(new OuvinteFocoIdade(tfIdade));
		add(tfIdade);

		tfSaldo = new MeuTextField("", 150, 150, 243, 25);
		tfSaldo.setDocument(new LimitaCaracteres(LimitaCaracteres.TipoEntrada.NUMEROSALDO));
		tfSaldo.addFocusListener(new OuvinteFocoSaldo(tfSaldo));
		add(tfSaldo);

		tfNumero = new MeuTextField("", 210, 250, 183, 25);
		tfNumero.setDocument(new LimitaCaracteres(LimitaCaracteres.TipoEntrada.NUMEROCONTA));
		tfNumero.addFocusListener(new OuvinteFocoIdade(tfNumero));
		add(tfNumero);
	}
}