package string_integer;

import java.util.Scanner;

public class String_integer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter line the number: ");

		String num = sc.nextLine();
		String[] sArr = num.split(" ");

		int[] numbers = new int[sArr.length];
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < sArr.length; i++) 
		{
			numbers[i] = Integer.parseInt(sArr[i]);
			sum += numbers[i];

			if (numbers[i] < min) 
			{
				min = numbers[i];
			}
			if (numbers[i] > max) 
			{
				max = numbers[i];
			}

		}
		System.out.println("Summ: " + sum + " Min: " + min + " Max: " + max);

	}

}
