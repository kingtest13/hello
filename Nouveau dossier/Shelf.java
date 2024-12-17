package müsterlösung;

public class Shelf {
	private ShelfItems[] items;
	
	public Shelf(ShelfItems[] items) {
		this.items=items;
	}
	
	public int getTotalShelfItems() {
		int total = 0;
        for (ShelfItems item : items) {
            total += item.shelfIndex();
        }
        return total;
	}
	
	public float getTotalWeight() {
        float total = 0;
        for (ShelfItems item : items) {
            total += item.getWeight();
        }
        return total;
    }
}
