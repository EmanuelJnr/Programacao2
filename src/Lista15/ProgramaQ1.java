package Lista15;

import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProgramaQ1 extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField tfTotal;

	public ProgramaQ1() {
		super("Checkbox teste");
		setSize(500,150);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addCheckBox();
		addLabel();
		addTextField();
		setVisible(true);
	}

	public static void main(String[] args) {
		new ProgramaQ1();
	}

	public void addCheckBox() {
		JCheckBox cbDez = new JCheckBox("10");
		cbDez.addActionListener(this :: evento);
		cbDez.setBounds(15, 45, 52, 20);
		add(cbDez);

		JCheckBox cbVinte = new JCheckBox("20");
		cbVinte.addActionListener(this :: evento);
		cbVinte.setBounds(77, 45, 52, 20);
		add(cbVinte);

		JCheckBox cbTrinta = new JCheckBox("30");
		cbTrinta.addActionListener(this :: evento);
		cbTrinta.setBounds(129, 45, 52, 20);
		add(cbTrinta);

		JCheckBox cbCinquenta = new JCheckBox("50");
		cbCinquenta.addActionListener(this :: evento);
		cbCinquenta.setBounds(181, 45, 52, 20);
		add(cbCinquenta);
	}

	public void addLabel() {
		JLabel total = new JLabel("Total:");
		total.setBounds(233, 45, 52, 20);
		add(total);
	}

	public void addTextField() {
		tfTotal = new JTextField();
		tfTotal.setBounds(295, 45, 120, 25);
		tfTotal.setEditable(false);
		add(tfTotal);
	}

	int resultado = 0;

	private void evento(ActionEvent e) {
		JCheckBox cb = (JCheckBox) e.getSource();

		if(cb.isSelected())
			resultado += Integer.parseInt(cb.getText());
		else if(!cb.isSelected())
			resultado -= Integer.parseInt(cb.getText());
		tfTotal.setText(""+resultado);
	}
}