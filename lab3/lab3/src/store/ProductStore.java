package store;

import java.util.Arrays;

import model.Timber;

public class ProductStore {
	private Timber[] arr = new Timber[3];
	private int count = 0;
	
		
	public Timber[] getArr() {
		return Arrays.copyOf(arr, count);
	}
	
	public void add(Timber newTimber) {
		if(arr.length == count) {
			arr = Arrays.copyOf(arr, count +count/2);
		}
		arr[count++] = newTimber;
	}
	 
	 public String toString() {
	     StringBuilder sb = new StringBuilder("Timber Store\n");
	     for (int i = 0; i < count; i++) {
	         sb.append(arr[i]).append("\n");
	     } 
	     return sb.toString();
	 }
	 
	 public float calcTotalWeight() {
		 float sum = 0;
	     for (int i = 0; i < count; i++) {
	    	 sum += arr[i].weight();
	     }
	     return sum;
	 }

}