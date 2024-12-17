
public class Main {

	public static void main(String[] args) {	
		
		
		int laenge = 3;
		shelfItem[] test = new shelfItem[laenge];
		Shelf shelf = new Shelf(1500, laenge,test);	
	shelfItem book1 = new Book("Deep Work", 100);
	shelfItem dustCollector1 = new dustCollector("Duden", 300);
	shelfItem book2 = new Book("Laws of Human nature", 1200);
	
	
	
	shelfItem book3 = new shelfItem("Deep Work", 100);
	
	System.out.println("----------------------toString() in shelfItem--------------------------------");
	System.out.println("So sollte die ausgabe von toString in der Klasse Book aussehen:\nDeep Work (100.0 kg)");
	System.out.println();
	System.out.println("Deine toString()-methode "
			+ "ergibt in der Klasse Book folgende ausgabe: \n" 
			+ book3.toString() + "\n");
	System.out.println("-----------------------toString() in Book-----------------------------------------");
	
	
	
	
	//test für ;
	
	System.out.println("So sollte die ausgabe von toString in der Klasse Book aussehen:\nBook: Deep Work (100.0 kg)");
	System.out.println();
	System.out.println("Deine toString()-methode "
			+ "ergibt in der Klasse Book folgende ausgabe: \n" 
			+ book1.toString() + "\n");
	System.out.println("-------------------------toString() in dustCollector-------------------------------------");
	
	System.out.println("So sollte die ausgabe von toString in der Klasse dustCollector aussehen:\ndustCollector: Duden (300.0 kg)");
	System.out.println();
	System.out.println("Deine toString()-methode "
			+ "ergibt in der Klasse Book folgende ausgabe: \n" 
			+ dustCollector1.toString() + "\n");
	System.out.println("------------------------Aufgabe 2: addItems()-----------------------------------");
	System.out.println();
	
	
	
	
	
	
	shelf.addItems(dustCollector1);
	shelf.addItems(book1);
	shelf.addItems(book2);
	
	
	
	//test für addItems();
	
	System.out.println("So sieht der Regal aus wenn addItems richtig implementiert wurde:");
	System.out.println("[dustCollector: Duden (300.0 kg), Book: Deep Work (100.0 kg), null]");
	
	System.out.println();
	System.out.println("So sieht dein Regal aus:");
	System.out.println(shelf.toString());
	
	
	
	System.out.println("--------------------------Rekursiv indexOf()-------------------------------------");
	System.out.println();

	
	//test für indexOf;
	System.out.println();
	
   int index = shelf.indexOf("Deep Work", 0);
   System.out.println("Das Buch ist in index 1.");
   System.out.println("Bei dir ist das Buch in index: " + index);
	
   
   int index2 = shelf.indexOf("Duden", 9);
   System.out.println("Das Buch ist in index -1.");
   System.out.println("Bei dir ist das Buch in index: " + index2);
	

	 

	}

}
