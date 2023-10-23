package string_builder_and_Scanner;

import java.util.Scanner;

public class String_builder_and_scanner {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Enter information: ");
		sb.append("Name/number of bad grades/average/\n");
		sb.append("Example: Cat/2/3/");
		
		System.out.println(sb);
		
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("/");
		String name = sc.next();
		
		int n = sc.nextInt();	
		
		float b = sc.nextFloat();
		sc.close();
		
		System.out.println(name+ ": bad grades " + n + "; average= "+ b);

	}

}
