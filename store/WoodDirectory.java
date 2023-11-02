package store;
import model.Wood;

public class WoodDirectory extends AbstractStore{
	{
		arr[0] = new Wood(0, "Larch", 1000);
		arr[1] = new Wood(1, "Pine", 750);
		arr[2] = new Wood(2, "Birch", 800);
		count = 3;
	}

	public Wood get(int id) {
		for (int i = 0; i < count; i++) {
			Wood wood = (Wood) arr[i];
			if(wood.getId() == id)
				return wood;
		}
		return null;
	}
	public boolean add(Wood newWood) {
		if(get(newWood.getId()) != null)
			return false;
		super.add(newWood);
		return true;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder("Wood directiry\n");
		sb.append(super.toString());
	     return sb.toString();

	}

}
