package model;
public abstract class AbstractForm implements IWeight {
	
	public abstract float volume();

	protected Wood wood;

	public AbstractForm() {
		super();
	}

	public Wood getWood() {
		return wood;
	}

	@Override
	public float weight() {
		return wood.getDensity() * volume();
	}

}