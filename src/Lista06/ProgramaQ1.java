package Lista06;

import java.util.Scanner;

public class ProgramaQ1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String txt = input.nextLine();
		String[] txts;
		
		txts = txt.split(", ");
		int[] nums = new int[txts.length];
		
		for(int i=0;i<txts.length;i++)
			nums[i] = Integer.parseInt(txts[i]);
		
		int maior=nums[0];
		int menor=nums[0];
		for (int i : nums) {
			maior = Math.max(maior, i);
			menor = Math.min(menor, i);
		}
		System.out.println(maior);
		System.out.println(menor);
		
		input.close();
	}
}