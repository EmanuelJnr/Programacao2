package Util;

import javax.swing.JTextField;

public class MeuTextField extends JTextField {
	private static final long serialVersionUID = 1L;
	
	public MeuTextField(String nome, int x, int y, int comp, int alt) {
		super(nome);
		setBounds(x, y, comp, alt);
	}
}