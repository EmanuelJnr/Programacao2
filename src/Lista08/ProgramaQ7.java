package Lista08;

import java.util.Scanner;

public class ProgramaQ7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] nums = new int[5];
		
		for(int i=0;i<nums.length;i++) {
			System.out.print("Digite o "+(i+1)+"º número: ");
			nums[i] = input.nextInt();
		}
		System.out.print("O maior é: ");
		System.out.println(CalMaior.maior(nums[0], nums[1], nums[2], nums[3], nums[4]));
		
		input.close();
	}
}