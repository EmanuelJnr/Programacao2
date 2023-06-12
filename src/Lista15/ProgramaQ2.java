package Lista15;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ProgramaQ2 extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel p;
	private ArrayList<JButton> bts = new ArrayList<>();

	public ProgramaQ2() {
		super("Jogo da Velha");
		setSize(425, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		addBotoes();
		addPainel();
		setVisible(true);
	}

	public static void main(String[] args) {
		new ProgramaQ2();
	}

	public void addPainel() {
		p = new JPanel(new GridLayout(3,3));

		for (JButton b : bts)
			p.add(b);

		p.setBounds(30, 30, 350, 350);
		add(p);
	}

	int jogador=0;
	private void evento(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if(b.getText()!="") {
			JOptionPane.showMessageDialog(this, "Escolha outra posição");
			return;
		}
		jogador++;

		if(jogador%2==0)
			b.setText("O");
		else if(jogador%2==1)
			b.setText("X");
	}

	public void addBotoes() {
		for(int i=0;i<9;i++) {
			JButton b = new JButton();
			b.setFont(new Font(null, Font.BOLD, 50));
			b.addActionListener(this :: evento);
			bts.add(b);
		}

		JButton novoJogo = new JButton("Novo Jogo");
		novoJogo.setFont(new Font(null, Font.BOLD, 25));
		novoJogo.setBounds(-1,422,425,40);
		add(novoJogo);

		novoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JButton b : bts)
					b.setText("");
			}
		});
	}
}