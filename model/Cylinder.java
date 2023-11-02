package model;

public class Cylinder extends AbstractForm {
	private float length;
	private float diameter;
	
	@Override
	public float volume() {

		return (float) (Math.PI*diameter/2*diameter/2*length);
	}

	public Cylinder(Wood wood, float length, float diameter) {
		super();
		this.wood = wood;
		this.length = length;
		this.diameter = diameter;

	}

	@Override
	public String toString() {
		return "Cylinder = "  + wood.getName() + ", volume = " + volume();
	}


	public float getLength() {
		return length;
	}

	public float getDiameter() {
		return diameter;
	}

}
