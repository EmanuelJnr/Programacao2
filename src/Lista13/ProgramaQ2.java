package Lista13;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ProgramaQ2 {
    public static void main(String[] args){
        String escolha = JOptionPane.showInputDialog(
                "Estados Unidos, Brasil, Espanha, Itália e França").toLowerCase();
        
        ArrayList<String> msgs = new ArrayList<>(Arrays.asList(
                "Hello world","Olá mundo","Hola mundo","Ciao mondo","Bonjour le monde"));
        ArrayList<String> flags = new ArrayList<>(Arrays.asList(
                "usa.png","brasil.png","espanha.png","italia.png","frança.png"));
        
        int indice=-1;
        for (int i=0;i<flags.size();i++) {
            String[] p = flags.get(i).split("\\.");
            if(escolha.equals(p[0])){
                indice=i;
            }
        }
        
        if(indice!=-1){
            System.out.println("entrou");
            ImageIcon icon = new ImageIcon(flags.get(indice));
            JOptionPane.showMessageDialog(null,msgs.get(indice),
                    null, JOptionPane.INFORMATION_MESSAGE,icon);
        }
    }
}