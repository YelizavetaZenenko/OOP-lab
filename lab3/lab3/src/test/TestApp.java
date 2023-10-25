package test;

import model.Timber;
import store.ProductStore;
import store.WoodDirectory;

public class TestApp {
	private WoodDirectory wd = new WoodDirectory();
	private ProductStore ps = new ProductStore();

	public static void main(String[] args) {
		TestApp app = new TestApp();
		app.startApp();
	}

	private void startApp() {
		ps.add(new Timber(wd.get(1), 10f, 0.3f, 0.4f));
		ps.add(new Timber(wd.get(2), 12f, 0.3f, 0.4f));

		for (Timber timber : ps.getArr()) {
			System.out.println(timber);
		}

		System.out.printf("Total weight = %1.3f", ps.calcTotalWeight());
	}

}