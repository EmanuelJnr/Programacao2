package Lista13;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProgramaQ3 extends JFrame{
	private static final long serialVersionUID = 1L;
	public ProgramaQ3(ArrayList<Pessoa> pessoas) {
        setSize(350, 350);
        GridLayout g = new GridLayout(2,2);
        setLayout(g);
        for(Pessoa p:pessoas) {
            String ano = "" + p.getAnoNasc();
            JLabel j = new JLabel(p.getNome(), JLabel.CENTER);
            j.setToolTipText(ano);
            add(j);
        }
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args){
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        for(int i=0;i<4;){
            String nome="";
            int idade=0;

            while (i!=4&&nome.equals("")&&idade==0){
                nome = JOptionPane.showInputDialog("Digite um nome");
                idade = Integer.parseInt(JOptionPane.showInputDialog("Digite uma idade"));
            }
            i++;
            pessoas.add(new Pessoa(nome,idade));
        }
        new ProgramaQ3(pessoas);
    }
}