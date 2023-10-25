package store;

import java.util.Arrays;

import model.Wood;

public class WoodDirectory {
	private Wood[] arr = new Wood[3];
	private int count = 0;
	{
		arr[0] = new Wood(0, "Larch", 1000);
		arr[1] = new Wood(1, "Pine", 750);
		arr[2] = new Wood(2, "Birch", 800);
		count = 3;
	}
	public Wood[] getArr() {
		return Arrays.copyOf(arr, count);
	}
	public Wood get(int id) {
		for(int i = 0; i < count; i++) {
			if(arr[i].getId() == id)
				return arr[i];
		}
		return null;
	}
	public boolean add(Wood newWood) {
		if(get(newWood.getId()) != null) 
			return false;
		if(arr.length == count)
			arr = Arrays.copyOf(arr, count + count/2);
		arr[count++] = newWood;
		return true;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder("Wood directiry\n");
		for(int i = 0; i < count; i++) {
			sb.append(arr[i]).append("\n");
		}
		return sb.toString();
		
	}

}
