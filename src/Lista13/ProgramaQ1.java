package Lista13;

import javax.swing.*;
import java.util.ArrayList;

public class ProgramaQ1 {
    public static void main(String[] args){
        ArrayList<String> nomes = new ArrayList<>();

        String nome;
        do{
            nome = JOptionPane.showInputDialog("Digite um nome");
            System.out.println(nome);
            if(!nome.equals("fim"))
                nomes.add(nome);
        }while (!nome.equals("fim"));
        
        String escolha = JOptionPane.showInputDialog("Escolha um nome");
        
        int cont=0;
        for (String n: nomes) {
            if(n.equals(escolha))
                cont++;
        }
        
        JOptionPane.showMessageDialog(null, "Esse nome foi lido "+cont+" vezes");
    }
}