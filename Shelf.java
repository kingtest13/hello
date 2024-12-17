//TODO: implement Weightful.

import java.util.Arrays;

public class Shelf implements Weightful {
	
	
	private int maxWeight;
	private shelfItem[] items;
		
	
	public Shelf(int maxWeight, int laenge, shelfItem[] items) {
		this.maxWeight = maxWeight;
		this.items = Arrays.copyOf(items, laenge) ;   //this.items = items wäre ein fehler aus bekannten gründen.
	
	}
	


	public boolean containsItem(shelfItem item) {
		for(int i = 0; i < items.length; i++) {
			if(items[i] != null) {
			if(items[i].equals(item)) return true;
			}
		}
		return false;
	}	
	
	
	public void addItems(shelfItem item) {
		if(item != null) {	
		}
		for(int i = 0; i < items.length; i++) {
			if(items[i] == null && !containsItem(item)		
				&& (getWeight() + item.getWeight()) <= maxWeight) {
				items[i] = item;
			return;
			} 
		}	
	}
	
	public String toString() {
	return Arrays.toString(items);
	}
	
	
	
	
	public int indexOf(String name, int startIndex) {
		
		if(startIndex < 0 || startIndex > items.length-1) return -1;
		
		
		if(items[startIndex] != null && name.equals(items[startIndex].getName())) return startIndex;
		else return indexOf(name,startIndex + 1);
 
		
	}


	@Override
	public float getWeight() {
		float weight = 0;
	for(int i = 0; i < items.length; i++) {
		if(items[i] != null) {
		weight += items[i].getWeight();
		}
		
	}
	return weight;
	}
	
	
	
	
	}
	
	
	
	


