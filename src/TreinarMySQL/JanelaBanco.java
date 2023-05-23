package TreinarMySQL;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class JanelaBanco extends JFrame{
	static final long serialVersionUID = 1L;
	private DataSource p;
	private MeuTextField tfNome;
	private MeuTextField tfSaldo;
	private MeuTextField tfTipo;
	private MeuTextField tfDataCriacao;

	public JanelaBanco() {
		super("Programa Banco");
		escolherBanco();//showOptionDialog para escolher o banco
		setSize(500, 700);
		setLayout(null);//define que a janela não terá layout
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/TreinarMySQL/banco.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fecha a janela e encerra o programa
		setLocationRelativeTo(null);//seta a janela para o centro da tela
		adicionarTextFields();
		adicionarTabela();
		adicionarBotões();
		setVisible(true);//torna a janela visível
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
	private void adicionarBotões() {
		JButton cadConta = new JButton("Cadastrar conta");
		cadConta.setBounds(316, 560, 138, 30);
		add(cadConta);

		cadConta.addActionListener(new ActionListener() {//cria um ouvinte para o botão
			public void actionPerformed(ActionEvent e) {//verifica se o botão foi pressionado
				String nome,tipo,dataCriacao;
				double saldo;

				nome = tfNome.getText();
				saldo = Double.parseDouble(tfSaldo.getText());
				tipo = tfTipo.getText();
				dataCriacao = tfDataCriacao.getText();

				ContaBancaria cb = new ContaBancaria(nome,saldo,tipo,dataCriacao);
				p.salvarDados(cb);//salva a conta no banco de dados
				adicionarTabela();//cria uma nova tabela
			}
		});
	}
	private void adicionarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabela = new JTable(modelo);
		modelo.addColumn("Nome");//adiciona a coluna Nome na tabela
		modelo.addColumn("Saldo");//adiciona a coluna Saldo na tabela
		modelo.addColumn("Tipo da Conta");//adiciona a coluna Tipo na tabela
		modelo.addColumn("Data de criação");//adiciona a coluna Data na tabela

		for (ContaBancaria c : p.carregarDados()) {//percorre os objetos dentro do Banco de dados
			Object[] linha = new Object[modelo.getColumnCount()];//cria uma linha com N colunas
			linha[0] = c.getNome();//adiciona o nome do objeto na primeira coluna
			linha[1] = c.getSaldo();//adiciona o saldo do objeto na segunda coluna
			linha[2]= c.getTipo();//adiciona o tipo da conta do objeto na terceira coluna
			linha[3] = c.getDataCriacao();//adiciona a data de criação da conta do objeto na quarta coluna
			modelo.addRow(linha);//adiciona a linha no modelo
		}

		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);//cria um objeto que ordena as linhas do modelo
		tabela.setRowSorter(sorter);//quando pressiona a coluna ele ordena as linhas
		JScrollPane painel = new JScrollPane(tabela);//adiciona a tabela no painel
		painel.setBounds(30, 300, 425, 250);//seta as dimensões do painel
		add(painel);//adiciona o painel na janela
	}
	private void adicionarTextFields() {
		tfNome = new MeuTextField(" Nome completo", 150, 100, 190, 25);
		tfNome.addFocusListener(new OuvinteDeFoco(tfNome));
		add(tfNome);

		tfSaldo = new MeuTextField(" Saldo da conta", 150, 150, 190, 25);
		tfSaldo.addFocusListener(new OuvinteDeFoco(tfSaldo));
		add(tfSaldo);

		tfTipo = new MeuTextField(" Tipo da conta", 150, 200, 190, 25);
		tfTipo.addFocusListener(new OuvinteDeFoco(tfTipo));
		add(tfTipo);

		tfDataCriacao = new MeuTextField(" Data de criação", 150, 250, 190, 25);
		tfDataCriacao.addFocusListener(new OuvinteDeFoco(tfDataCriacao));
		add(tfDataCriacao);
	}
}