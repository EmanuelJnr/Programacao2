package Lista14;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ProgramaQ3 extends JFrame{
	private static final long serialVersionUID = 1L;
	private JComboBox<TextoCor> combo;

	public ProgramaQ3() {
		setLayout(null);
		setSize(400,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		comboBox();
		mudaCorJanela();
		setVisible(true);
	}

	public class TextoCor{
		public String nome;
		public Color cor;
		public TextoCor(String nome, Color cor) {
			this.nome = nome;
			this.cor = cor;
		}
		public String toString() {
			return nome;
		}
	}
	public void comboBox() {
		combo = new JComboBox<>();
		combo.addItem(new TextoCor("BLACK", Color.BLACK));
		combo.addItem(new TextoCor("BLUE", Color.BLUE));
		combo.addItem(new TextoCor("CYAN", Color.CYAN));
		combo.addItem(new TextoCor("DARK_GRAY", Color.DARK_GRAY));
		combo.addItem(new TextoCor("GRAY", Color.GRAY));
		combo.addItem(new TextoCor("GREEN", Color.GREEN));
		combo.addItem(new TextoCor("LIGHT_GRAY", Color.LIGHT_GRAY));
		combo.addItem(new TextoCor("MAGENTA", Color.MAGENTA));
		combo.addItem(new TextoCor("ORANGE", Color.ORANGE));
		combo.addItem(new TextoCor("PINK", Color.PINK));
		combo.addItem(new TextoCor("RED", Color.RED));
		combo.addItem(new TextoCor("WHITE", Color.WHITE));
		combo.addItem(new TextoCor("YELLOW", Color.YELLOW));
		combo.setBounds(20,20,200,35);
		add(combo);
	}
	public void mudaCorJanela(){		
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoCor corSelecionada = (TextoCor) combo.getSelectedItem();
				getContentPane().setBackground(corSelecionada.cor);
			}
		});
	}
	public static void main(String[] args) {
		new ProgramaQ3();
	}
}