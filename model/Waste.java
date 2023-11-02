package model;

public class Waste implements IWeight {
	private float weight;

	public Waste(float weight) {
		super();
		this.weight = weight;
	}

	@Override
	public float weight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Waste weight = " + weight();
	}

	@Override
	public float volume() {
		// TODO Auto-generated method stub
		return 0;
	}

}
