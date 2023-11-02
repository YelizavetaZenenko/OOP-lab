package test;

import model.Wood;
import store.WoodDirectory;

public class TestWood {

	public static void main(String[] args) {
		WoodDirectory wd = new WoodDirectory();

		System.out.println(wd.get(2)+"\n");

		Wood w = new Wood (3, "Oak", 950);

		if(wd.add(w))  
			System.out.println(wd);

		if(!wd.add(w))
				System.out.println(w + " already exists\n");
	}
}
