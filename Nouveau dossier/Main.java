package müsterlösung;

public class Main {
	
	public static void main(String[] args) {
		ShelfItems book1 = new Book("aa", 1.5f);
        ShelfItems book2 = new Book("bb", 1.8f);
        ShelfItems book3 = new Book("cc", 1.5f);
        ShelfItems collection1 = new DustyCollection("dd", 5.2f);

        Shelf shelf = new Shelf(new ShelfItems[]{book1, book2,book3, collection1});


        System.out.println("Gesamtanzahl der Items: " + shelf.getTotalShelfItems());
        System.out.println("Gesamtgewicht der Items: " + shelf.getTotalWeight());

        
	}

}
