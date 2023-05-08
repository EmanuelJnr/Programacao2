package Lista04;
import java.util.Scanner;
public class ProgramaQ56 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CDF cdf = new CDF();
		
		System.out.print("Digite um número: ");
		int num = input.nextInt();
		
		for(int i=1;i<=num;i++) {
			if(cdf.ePerfeito(i))
				System.out.println(i);
		}
		input.close();
	}
}