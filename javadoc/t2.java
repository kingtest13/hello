

public class Shelf {
private ShelfItem[] items; // Array für die Gegenstände im Regal
private int maxItems; // Maximale Anzahl an Gegenständen
private float maxWeight; // Maximales Gewicht des Regals
// Konstruktor
public Shelf(int maxItems, float maxWeight) {
this.items = new ShelfItem[maxItems];
this.maxItems = maxItems;
this.maxWeight = maxWeight;
 }
public ShelfItem[] getItems() {
return items;
}
private boolean containsItem(ShelfItem item) {
 if (item == null) return false;

 for (ShelfItem currentItem : items) {
 if (currentItem != null && currentItem.equals(item)) {
 return true;
 }
 }
 return false;
 }
public void addItem(ShelfItem item) {
 if (item != null && items.length < maxItems) {
 for (int i = 0; i < items.length; i++) {
 if (items[i] == null) {
 items[i] = item;
 System.out.println("Gegenstand erfolgreich hinzugefügt.“);
 return;
 }
 }
 }
 System.out.println("Gegenstand wirde nicht hinzugefügt.");
}
} 

1.1.1
Fügen Sie der Klasse 2 private Instanzvariablen hinzu: "name" vom Typ String und "weight" vom Typ
float. 

public class ShelfItem {
// A1.1.1: name & weight hinzufügen
private String name;
private float weight;
public ShelfItem() {

 }
} 

1.1.2
IniƟalisieren Sie diese Felder im vorgegebenen Konstruktor mit den Werten, die dieser als Parameter
erhält. 

public class ShelfItem {
// A1.1.1: name & weight hinzufügen
private String name;
private float weight;
// A1.1.2: Konstruktor mit name & weight als Übergabeparameter
public ShelfItem(String name, float weight) {
this.name = name;
 this.weight = weight;
} } 
 
1.1.3
ImplemenƟeren Sie die SchniƩstelle Weighƞul indem Sie den Wert der Instanzvariable "weight"
zurückgeben. 

// A1.1.3: Weightful implementieren, "implements Weightful" hinzufügen
public class ShelfItem implements Weightful {
// A1.1.1: name & weight hinzufügen
private String name;
private float weight;
// A1.1.2: Konstruktor mit name & weight als Übergabeparameter
public ShelfItem(String name, float weight) {
this.name = name;
 this.weight = weight;
}
// A1.1.3: Methode entwickeln, die weight zurückgibt
@Override
public float getWeight() {
 return weight;
}
} 

1.1.4
Überschreiben Sie die toString() Methode aus java.lang.Object, so dass diese eine ZeichenkeƩe in
folgendem Format zurückgibt: <name> (<weight> kg) 

public class ShelfItem {
// A1.1.1: name & weight hinzufügen
private String name;
private float weight;
// A1.1.2: Konstruktor mit name & weight als Übergabeparameter
public ShelfItem(String name, float weight) {
this.name = name;
 this.weight = weight;
}
// A1.1.3: getWeight überschreiben, die weight zurückgibt
@Override
public float getWeight() {
 return weight;
}
// A1.1.4: Methode toString von Object überschreiben
@Override
public String toString() {
return name + " (" + weight + " kg)";
}
} 

Aufgabe 1.2: Klassen Book & DustyCollecƟon
Ändern Sie die Vererbungsbeziehungen so, dass beide Klassen von Shelfltem erben.

// A1.2.1: Von ShelfItem vererben lassen, "extends ShelfItem" hinzufügen
public class Book extends ShelfItem {
public Book() {

 }
} 


1.2.2
Fügen Sie den Klassen den Konstruktor Ihrer neuen Superklasse hinzu und geben Sie die Parameter
an die Superklasse weiter.
Lösung bei Klasse Book:
// A1.2.1: Von ShelfItem vererben lassen, "extends ShelfItem" hinzufügen
public class Book extends ShelfItem {
// A1.2.2: name & weight als Übergabeparameter und Super-Konstruktor verwenden
public Book(String name, float weight) {
super(name, weight);
}
}
Lösung bei Klasse DustyCollecƟon:
// A1.2.1: Von ShelfItem vererben lassen, "extends ShelfItem" hinzufügen
public class DustyCollection {
// A1.2.2: name & weight als Übergabeparameter und Super-Konstruktor verwenden
public DustyCollection(String name, float weight) {
 super(name, weight); 
}
} 

1.2.3
Überschreiben Sie die toString() Methode, so dass vor den Wert der ImplemenƟerung aus der
Superklasse noch der Name der Klasse gefolgt von einem Doppelpunkt und einem Leerzeichen
angefügt wird. D.h. analog zu Shelfltem soll die Ausgabe wie folgt aussehen:

Lösung bei Klasse Book:
// A1.2.1: Von ShelfItem vererben lassen, "extends ShelfItem" hinzufügen
public class Book extends ShelfItem {
// A1.2.2: name & weight als Übergabeparameter und Super-Konstruktor verwenden
public Book(String name, float weight) {
super(name, weight);
}
// A1.2.3: toString-Methode hinzufügen, "Book: " + "super.toString" ausgeben
@Override
public String toString() {
 return "Book: " + super.toString();
}
}
Lösung bei Klasse DustyCollecƟon:
// A1.2.1: Von ShelfItem vererben lassen, "extends ShelfItem" hinzufügen
public class DustyCollection {
// A1.2.2: name & weight als Übergabeparameter und Super-Konstruktor verwenden
public DustyCollection(String name, float weight) {
 super(name, weight);
}
// A1.2.3: toString-Methode hinzufügen, "DustCollector: " + "super.toString"
ausgeben
@Override
public String toString() {
 return "DustCollecter: " + super.toString();
}
} 



Aufgabe 2: OOP, Bedingungen, Arrays, Rekursion 

Aufgabe 2.1
// A2.1: Weightful implementieren, "implements Weightful" hinzufügen
public class Shelf implements Weightful {
[…]
// A2.1: getWeight-Methode hinzufügen und Summe von allen Gewichten der Objekte
ermitteln
@Override
public float getWeight() {
 float sum = 0;

 for (int i = 0; i < items.length; i++) {
if (items[i] != null) {
 sum = sum + items[i].getWeight();
}
 }
 return sum;
}
[…]
} 

Aufgabe 2.2 

[…]
// A2.2: addItem verändern
public void addItem(ShelfItem item) {
 // Überprüfen, ob das Item nicht null ist
 if (item == null) {
 return;
 }
 // Überprüfen, ob das Item bereits im Regal ist
 if (containsItem(item)) {
 return;
 }
 // Überprüfen, ob das maximale Gewicht überschritten wird
 if (getWeight() + item.getWeight() > maxWeight) {
 return;
 }
 // Hinzufügen des Items, wenn noch Platz im Array vorhanden ist
 for (int i = 0; i < items.length; i++) {
 if (items[i] == null) { // Freien Platz gefunden
 items[i] = item;
 System.out.println("Gegenstand erfolgreich hinzugefügt.“);
 return;
 }
 }
 // Kein Platz im Regal
 System.out.println("Gegenstand wurde nicht hinzugefügt.");
} 


Aufgabe 2.3 
Lösung bei Klasse ShelfItem:
// Zusätzliche Methode hinzufügen
public String getName() {
 return name;
}

Lösung bei Klasse Shelf:
[…]
// A2.3: IndexOf hinzufügen, mit name & startIndex als Übergabeparameter
public int indexOf(String name, int startIndex) {
 // Basisfälle
 if (startIndex >= items.length) {
 return -1; // Wenn der Startindex außerhalb des Arrays liegt
 }
 if (items[startIndex] != null && items[startIndex].getName().equals(name)) {
 return startIndex; // Wenn der Gegenstand mit dem Namen gefunden wurde
 }
 // Rekursiver Schritt
 return indexOf(name, startIndex + 1);
} 




Summe eines 1D-Arrays ermiƩeln
// Summe eines 1D-Arrays ermitteln
 public static int getSum1D(int[] array, int index) {
 int summe = array[index];
 if (index != array.length - 1) {
 return summe + getSum1D(array, index + 1);
 } else {
 return summe;
 }
 } 

Summe eines 2D-Arrays ermiƩeln
// Summe eines 2D-Arrays ermitteln
 public static int getSum2D(int[][] array, int zeile, int spalte) {
 if (zeile < array.length) {
 if (spalte < array[zeile].length) {
 int summe = array[zeile][spalte];
 return summe + getSum2D(array, zeile, spalte + 1);
 } else {
 return getSum2D(array, zeile + 1, 0);
 }
 }
 return 0;
 }
