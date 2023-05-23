package TreinarMySQL;

import java.awt.Font;

import javax.swing.JTextField;

public class MeuTextField extends JTextField {
	private static final long serialVersionUID = 1L;
	
	//public CamposDeTexto(int x, int y, int comp, int alt) {
	//	setFont(new Font("Tahoma", Font.PLAIN, 10));
	//	setBounds(x, y, comp, alt);
	//}
	
	public MeuTextField(String nome, int x, int y, int comp, int alt) {
		super(nome);
		setFont(new Font("Tahoma", Font.PLAIN, 10));
		setBounds(x, y, comp, alt);
	}

	/*public void adicionarFormatoData(JFrame jf) {
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/#### ##:##");
			JFormattedTextField campo = new JFormattedTextField(mascara);
			campo.setBounds(130, 205, 90, 25);
			campo.addFocusListener(new OuvinteDeFoco(campo));
			jf.add(campo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}*/
}