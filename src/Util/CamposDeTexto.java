package Util;

import javax.swing.JTextField;

public class CamposDeTexto extends JTextField {
	private static final long serialVersionUID = 1L;

	public CamposDeTexto(String nome, int x, int y, int comp, int alt) {
		super(nome);
		setBounds(x, y, comp, alt);
	}
}