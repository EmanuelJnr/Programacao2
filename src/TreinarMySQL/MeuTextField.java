package TreinarMySQL;

import java.awt.Font;

import javax.swing.JTextField;

public class MeuTextField extends JTextField {
	private static final long serialVersionUID = 1L;
	public MeuTextField(String nome, int x, int y, int comp, int alt) {
		super(nome);
		setFont(new Font("Tahoma", Font.PLAIN, 10));
		setBounds(x, y, comp, alt);
	}
}