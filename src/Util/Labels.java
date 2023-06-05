package Util;

import javax.swing.JLabel;

public class Labels extends JLabel {
	private static final long serialVersionUID = 1L;

	public Labels(String nome, int x, int y, int comp, int alt) {
		super(nome);
		setBounds(x, y, comp, alt);
	}
}