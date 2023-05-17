package AulaThead;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Interface.CamposDeTexto;

public class JanelaBanco extends JFrame{
	Persistencia pe = new Persistencia();
	CentralDeInformacoes central = pe.recuperarCentral("CentralBanco.xml");
	static final long serialVersionUID = 1L;
	private CamposDeTexto tfNome;
	private CamposDeTexto tfSaldo;
	private CamposDeTexto tfTipo;
	private CamposDeTexto tfDataCriacao;
	
	public JanelaBanco(String nome) {
		super(nome);//nomeia o nome da janela
		setSize(500, 700);//comprimento e largura da janela
		setLayout(null);//define que a janela não terá layout
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/AulaThead/banco.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fecha a janela e encerra o programa
		setLocationRelativeTo(null);//seta a janela para o centro da tela
		//criarContas();//cria contas e add no Array
		adicionarTextFields();
		adicionarTabela();//adiciona a tabela na janela
		adicionarBotao();//adiciona o botão na janela
		setVisible(true);//torna a janela visível
	}
	private void adicionarBotao() {
		JButton cadConta = new JButton("Cadastrar conta");
		cadConta.setBounds(316, 560, 138, 30);
		add(cadConta);
		
		cadConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						central.adicionarConta(new ContaBancaria(tfNome.getText(), Double.parseDouble(tfSaldo.getText()), tfTipo.getText(), tfDataCriacao.getText()));
						pe.salvarCentral(central, "CentralBanco.xml");
						dispose();
						new JanelaBanco("Programa Banco");
					}
				}.start();
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

		for (ContaBancaria c : central.getTodasContasBancarias()) {//percorre os objetos dentro do Array
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
		tfNome = new CamposDeTexto(" Nome completo", 150, 100, 190, 25);
		tfNome.addFocusListener(new OuvinteDeFoco(tfNome));
		add(tfNome);

		tfSaldo = new CamposDeTexto(" Saldo da conta", 150, 150, 190, 25);
		tfSaldo.addFocusListener(new OuvinteDeFoco(tfSaldo));
		add(tfSaldo);

		tfTipo = new CamposDeTexto(" Tipo da conta", 150, 200, 190, 25);
		tfTipo.addFocusListener(new OuvinteDeFoco(tfTipo));
		add(tfTipo);

		tfDataCriacao = new CamposDeTexto(" Data de criação", 150, 250, 190, 25);
		tfDataCriacao.addFocusListener(new OuvinteDeFoco(tfDataCriacao));
		add(tfDataCriacao);
	}
}