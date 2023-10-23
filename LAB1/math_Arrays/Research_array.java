package math_Arrays;

import java.util.Arrays;

public class Research_array {
	public static void main(String[] args) {
		int [] arr1 = {0, 1, 2, 3};
		int [] arr2 = {0, 1, 2, 3};

		System.out.println(Arrays.equals(arr1, arr2));//true/false
		int [] numbersCopy = Arrays.copyOf(arr1, arr1.length);//copy
		System.out.println(Arrays.toString(numbersCopy));
	}

}
