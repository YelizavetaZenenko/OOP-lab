package math_Arrays;
import java.util.Arrays;
import java.util.Scanner;

public class Math_Arrays {

	public static void main(String[] args) {
System.out.println("The program was created by Zenenko Yelizaveta");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter  length array: ");
		int size = sc.nextInt();
		if(size > 5) {//if more than 5 then plus 10
	     size += 10;
		}
		sc.close();
		
		double[] arr = new double [size];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Math.random()*100;
		}
		
		Arrays.sort(arr);
		
		System.out.println("Numbers array");
		for (double d : arr) {
			System.out.printf("%6.2f", d);
			
		}
			
System.out.println();

	}

}
