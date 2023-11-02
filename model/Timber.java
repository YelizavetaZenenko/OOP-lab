package model;

public class Timber extends AbstractForm {

	private float length;
	private float height;
	private float width;
	
	public Timber(Wood wood, float length, float height, float width) {
		super();
		this.wood = wood;
		this.length = length;
		this.height = height;
		this.width = width;
	}

	public float getLength() {
		return length;
	}

	public float getHeight() {
		return height;
	}

	public float getWidth() {
		return width;
	}
	public float volume(){
		return length * height * width;
	}
	
	@Override
	public String toString() {
		return "Timber = " + wood.getName() + ", weight= " + weight();
	}

}
