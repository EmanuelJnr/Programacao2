package Lista14;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Questao2 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton botaoConfirmar;
	JLabel lbDado;
	JLabel textoFim;
	JSpinner jSpinner;
	
	public Questao2() {
		setTitle("Jogo do dado");
		setSize(400,600);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		addBotao();
		addSpinner();
		addLabels();
		setVisible(true);
	}
	public int rolarDado() {
		int valor = (int) (Math.random()*6 + 1);
		ImageIcon dado = new ImageIcon("d"+valor+".png");
		lbDado.setIcon(dado);
		return valor;
	}
	
	public void addSpinner() {
		jSpinner = new JSpinner();
		SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 6, 1);
		jSpinner.setModel(model);
		jSpinner.setBounds(100, 100, 50, 30);
		add(jSpinner);
	}
	
	public void addBotao() {
		botaoConfirmar = new JButton("JOGAR");
		botaoConfirmar.setBounds(200, 100, 100,30);
		add(botaoConfirmar);
		
		botaoConfirmar.addActionListener(this);
	}
	
	public void addLabels() {
		lbDado = new JLabel();
		lbDado.setBounds(140, 300, 120, 120);
		lbDado.setHorizontalAlignment(JLabel.CENTER);
		add(lbDado);
		
		textoFim = new JLabel();
		textoFim.setBounds(160, 500, 80, 30);
		textoFim.setHorizontalAlignment(JLabel.CENTER);
		textoFim.setFont(new Font("Arial", Font.BOLD, 12));
		add(textoFim);
	}
	
	public void actionPerformed(ActionEvent e) {
		int spinning = (int) jSpinner.getValue();
		int valor = rolarDado();
		
		if(spinning == valor) {
			textoFim.setText("Você acertou");
		} else {
			textoFim.setText("Você errou");
		}
		
		String[] opcoes = {"Sim", "Não"};
		int opc = JOptionPane.showOptionDialog(null, "Quer jogar novamente", "", 0, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
		
		if(opc==0) {
			dispose();
			new Questao2();
		} else {	
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Questao2();
	}
}
