package test;

import model.Cylinder;
import model.Timber;
import model.Waste;
import store.ProductStore;
import store.WoodDirectory;

public class TestApp {
	private WoodDirectory wd = new WoodDirectory();
	private ProductStore ps = new ProductStore();
	private ProductStore cl = new ProductStore();
	private ProductStore ws = new ProductStore();

	public static void main(String[] args) {
		TestApp app = new TestApp();
		app.startApp();
	}

	private void startApp() {
		ps.add(new Timber(wd.get(0), 10f, 0.3f, 0.4f));
		ps.add(new Timber(wd.get(1), 12f, 0.3f, 0.4f));
		ps.add(new Timber(wd.get(2), 14f, 0.3f, 0.4f));
		
		cl.add(new Cylinder(wd.get(0), 10f, 0.5f));
		cl.add(new Cylinder(wd.get(1), 12f, 0.5f));
		cl.add(new Cylinder(wd.get(2), 14f, 0.5f));
		
		ws.add(new Waste(1f));
		ws.add(new Waste(2f));

		for (Object timber : ps.getArr()) {
			System.out.println(timber);
		}
		System.out.printf("(Timber)Total weight -> %1.3f \n", ps.calcTotalWeight());
		
		for (Object cylinder : cl.getArr()) {
			System.out.println(cylinder);
		}
		System.out.printf("(Cylinder)Total weight -> %1.3f \n", cl.calcTotalWeight());
	    
		for (Object waste : ws.getArr()) {
			System.out.println(waste);
		}
		System.out.printf("(Waste)Total weight -> %1.3f \n", ws.calcTotalWeight());

	}

}