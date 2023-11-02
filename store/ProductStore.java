package store;

import model.IWeight;

public class ProductStore extends AbstractStore {

	public void add(IWeight newProduct) {
		super.add(newProduct);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("Product directory:\n");
		sb.append(super.toString());
		return sb.toString();

	}

	public float calcTotalWeight() {
		float fullWeight = 0;
		for (Object object : this.getArr()) {
			fullWeight += ((IWeight) object).weight();
		}
		return fullWeight;
	}

}