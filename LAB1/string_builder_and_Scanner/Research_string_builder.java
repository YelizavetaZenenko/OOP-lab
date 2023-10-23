package string_builder_and_Scanner;

public class Research_string_builder {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder("Hello World");
		builder.append("!");//add symbol !
		String result = builder.toString();
		System.out.println(result);

		builder.deleteCharAt(11);//delete symbol 
		String result1 = builder.toString();
		System.out.println(result1);

		builder.reverse();//reverse
		String result2 = builder.toString();
		System.out.println(result2);
	}

}
