package Lista06;

import java.util.Scanner;

public class ProgramaQ2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        
        String txt = input.nextLine().toLowerCase();
        txt = txt.replaceAll(" ","");
        char[] txts = txt.toCharArray();
        
        String str = "aeiou";
        
        int contV = 0;
        for(char t:txts){
        	if(str.indexOf(t) != -1)
        		contV++;
        }
        
        System.out.println("Vogais: "+contV);
        System.out.printf("Consoantes: %d",txts.length-contV);
        
        input.close();
    }
}