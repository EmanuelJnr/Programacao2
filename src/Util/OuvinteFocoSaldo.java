package Util;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class OuvinteFocoSaldo implements FocusListener{
	private JTextField campo;

	public OuvinteFocoSaldo(JTextField campo) {
		this.campo = campo;
		campo.setText("0.00");
	}

	public void focusGained(FocusEvent arg0) {
		campo.setText("");
	}
	public void focusLost(FocusEvent arg0) {
		if(campo.getText().equals(""))
			campo.setText("0.00");
	}
}