package Lista12;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProgramaQ7 {
	public static void main(String[] args) {
		ArrayList<Integer> valores = new ArrayList<>();

		for(int i=0;i<3;i++)
			valores.add(0);

		boolean flag;
		do {
			int posi=0;
			int valor=0;
			boolean valoresOK=true;
			while(valoresOK) {
				try {
					String strValor = JOptionPane.showInputDialog("Informe um valor");
					valor = Integer.parseInt(strValor);
					String strPosi = JOptionPane.showInputDialog("Informe uma posição");
					posi = Integer.parseInt(strPosi);
					valores.set(posi, valor);
					valoresOK=false;
				}catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Caractere inválido!");
				}catch (IndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null, "Posição inválida!");
				}
			}
			
			flag = false;
			for (Integer i : valores) {
				if(i==0)
					flag = true;
			}
		}while(flag);

		int soma=0;
		for (Integer i : valores)
			soma+=i;
		JOptionPane.showMessageDialog(null, "A soma dos valores: "+soma);
	}
}