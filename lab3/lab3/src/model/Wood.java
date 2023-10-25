package model;

public class Wood {
	private int id;
	private String name;
	private float density;
	
	public Wood(int id, String name, float density) {
		super();
		this.id = id;
		this.name = name;
		this.density = density;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getDensity() {
		return density;
	}

	public void setDensity(float density) {
		this.density = density;
	}

	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Wood [id=" + id + ", name=" + name + ", density=" + density + "]";
	}
}
