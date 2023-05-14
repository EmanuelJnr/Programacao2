package Lista11;

import java.util.Scanner;

public class ProgramaQ4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MinhaData[] datas = new MinhaData[2];
		
		for(int i=0;i<2;i++) {
			System.out.println("Informe a "+(i+1)+"ª data: (DD/MM/YYYY)");
			String data = input.nextLine();
			datas[i] = ConversorData.dataToMData(data);
		}
		
		if(datas[0].comparacao(datas[1])==1) {
			System.out.println("\n"+datas[1]);
			System.out.println(datas[0]);
		}
		else {
			System.out.println("\n"+datas[0]);
			System.out.println(datas[1]);
		}
		input.close();
	}
}