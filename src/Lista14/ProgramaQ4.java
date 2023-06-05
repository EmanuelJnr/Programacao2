package Lista14;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ProgramaQ4 extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField tfA;
	private JTextField tfB;
	private JTextField tfC;
	private JLabel labelX1;
	private JLabel labelX2;

	public ProgramaQ4() {
		super("Solucionador de Equações de Segundo Grau");
		setSize(450,250);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		labels();
		camposTxt();
		botoes();
		setVisible(true);
	}
	public JLabel criaLabel(String nome, int tamanho, int x, int y, int comp, int alt) {
		JLabel l = new JLabel(nome);
		l.setBounds(x, y, comp, alt);
		l.setFont(new Font(null, Font.BOLD, tamanho ));
		return l;
	}

	public void labels() {
		add(criaLabel("A equação de segundo grau é:", 22, 25, 15, 311, 30));

		add(criaLabel("X² +", 17, 50, 55, 32, 35));

		add(criaLabel("X +", 17, 125, 55, 26, 35));

		add(criaLabel("= 0", 17, 197, 55, 24, 35));

		add(criaLabel("X1 =", 17, 150, 115, 35, 35));

		add(criaLabel("X2 =", 17, 150, 150, 35, 35));

		labelX1 = criaLabel("?", 17, 190, 115, 200, 35);
		add(labelX1);

		labelX2 = criaLabel("?", 17, 190, 150, 200, 35);
		add(labelX2);
	}
	public void camposTxt() {
		tfA = new JTextField();
		tfA.setBounds(18,55,25,35);
		add(tfA);

		tfB = new JTextField();
		tfB.setBounds(90,55,25,35);
		add(tfB);

		tfC = new JTextField();
		tfC.setBounds(162,55,25,35);
		add(tfC);
	}
	public void botoes() {
		JButton bEntrar = new JButton("raízes");
		bEntrar.setBounds(235, 55, 93, 35);
		add(bEntrar);

		bEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a = Integer.parseInt(tfA.getText());
					int b = Integer.parseInt(tfB.getText());
					int c = Integer.parseInt(tfC.getText());
					labelX1.setText(""+EquacaoSegundoGrau.getX(a, b, c, true));
					labelX2.setText(""+EquacaoSegundoGrau.getX(a, b, c, false));
				}catch (NaoHaSolucaoRealException nhsre) {
					JOptionPane.showMessageDialog(null, nhsre.getMessage());
				}catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos com números positivos ou negativos!");
				}
			}
		});
	}

	public static void main(String[] args) {
		new ProgramaQ4();
	}
}