package String_builder_and_Scanner;
import java.util.Scanner;
public class research_scanner {

	public static void main(String[] args) {
		System.out.println("Enter number: ");//nextInt
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println("Number " + number);
		
		Scanner scan = new Scanner(System.in);//nextLine
		System.out.println("Enter 2 worlds or phrase: ");
		String phrase = scan.nextLine();
		System.out.println("You phrase " + phrase);
		
		

	}

}
