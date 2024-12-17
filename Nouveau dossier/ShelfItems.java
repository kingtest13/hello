package müsterlösung;

public class ShelfItems implements Weightful{
	private String name;
	private float weight;
	
	public ShelfItems(String name, float weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public int shelfIndex() {
		return 1;
	}

	public float getWeight() {
		return weight;
	}
}
