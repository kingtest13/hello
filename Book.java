//TODO: Inherit from shelfitem
public class Book extends shelfItem {
	
	
	//TODO: refer to superclass- constructor
	public Book(String name, float weight) {
		super(name, weight);
	}
	
	
	
	public String toString(){
		return "Book: "+ super.toString();

	}

}
