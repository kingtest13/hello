//TODO: implement Weightful

public class shelfItem implements Weightful {
	
	//TODO: create variables
	private String name;
	private float weight;
	
	
	
	
	//TODO: fill the constructor with parameters.
	public shelfItem(String name, float weight) {
		this.name = name;
		this.weight = weight;
		
		
	}
	//TODO: Override this method.
	public String toString() {
		return name + " (" + weight + " kg)" ;
		
	}
	@Override
	public float getWeight() {
		//
		return weight;
	}
	public String getName() {
		return name;
		
	}
	
	

}
