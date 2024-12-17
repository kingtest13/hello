Testat 2: Aufgaben und L¨osungen
Aufgabe 1:
Schritt 1:
Aufgabe: F¨ugen Sie der Klasse ShelfItem zwei private Instanzvariablen hinzu: name (vom Typ String)
und weight (vom Typ float). Initialisieren Sie diese Variablen im Konstruktor.
L¨osung:
1 public class ShelfItem {
2 private String name ;
3 private float weight ;
4
5 public ShelfItem ( String name , float weight ) {
6 this . name = name ;
7 this . weight = weight ;
8 }
9 }
Schritt 2:
Aufgabe: Implementieren Sie die Schnittstelle Weightful in der Klasse ShelfItem, sodass die Methode
getWeight() das Gewicht zur¨uckgibt.
L¨osung:
1 public class ShelfItem implements Weightful {
2
3 @Override
4 public float getWeight () {
5 return this . weight ;
6 }
7 }
Schritt 3:
Aufgabe: Uberschreiben Sie die ¨ toString()-Methode, sodass sie eine Zeichenkette im Format <name>
(<weight> kg) zur¨uckgibt.
L¨osung:
1 @Override
2 public String toString () {
3 return name + " (" + weight + " kg)";
4 }
1
Schritt 4:
Aufgabe: Erg¨anzen Sie die Klassen Book und DustCollector, indem sie von ShelfItem erben. F¨ugen
Sie Konstruktoren hinzu und ¨uberschreiben Sie die toString()-Methode:
- DustCollector: <name> (<weight> kg)
- Book: <name> (<weight> kg)
L¨osung:
1 public class Book extends ShelfItem {
2
3 public Book ( String name , float weight ) {
4 super ( name , weight ) ;
5 }
6
7 @Override
8 public String toString () {
9 return " Book : " + super . toString () ;
10 }
11 }
12
13 public class DustCollector extends ShelfItem {
14
15 public DustCollector ( String name , float weight ) {
16 super ( name , weight ) ;
17 }
18
19 @Override
20 public String toString () {
21 return " DustCollector : " + super . toString () ;
22 }
23 }
Aufgabe 2:
Schritt 1:
Aufgabe: Implementieren Sie die Schnittstelle Weightful in der Klasse Shelf, sodass die Methode
getWeight() die Summe der Gewichte aller Gegenst¨ande im Regal zur¨uckgibt.
L¨osung:
1 public class Shelf implements Weightful {
2
3 @Override
4 public float getWeight () {
5 float totalWeight = 0;
6 for ( ShelfItem item : items ) {
7 if ( item != null ) {
8 totalWeight += item . getWeight () ;
9 }
10 }
11 return totalWeight ;
12 }
13 }
2
Schritt 2:
Aufgabe: Erweitern Sie die Methode addItem(), sodass ein Gegenstand nur hinzugef¨ugt wird, wenn er
nicht bereits im Regal existiert, es noch Platz im Regal gibt, und das maximale Gewicht nicht ¨uberschritten
wird.
L¨osung:
1 public void addItem ( ShelfItem newItem ) {
2 if ( getWeight () + newItem . getWeight () > maxWeight ) {
3 return ;
4 }
5 for (int i = 0; i < items . length ; i++) {
6 if ( items [i] == null && ! containsItem ( newItem ) ) {
7 items [i] = newItem ;
8 return ;
9 }
10 }
11 }
Schritt 3:
Aufgabe: Implementieren Sie die Methode indexOf(String name, int startIndex), um ein ShelfItem
rekursiv anhand seines Namens ab einer Startposition zu suchen. Dabei soll der kleinste Indexe zur¨uckgegeben
werden, sollte das Item im angegebenen Bereich vorhanden sein. Ansonsten soll -1 zur¨uckgegeben werden.
F¨ur diese L¨osung darf nur rekusiv gearbeitet werden
L¨osung:
1 public int indexOf ( String name , int startIndex ) {
2 if ( startIndex >= items . length ) {
3 return -1;
4 }
5 if ( items [ startIndex ] != null && items [ startIndex ]. getName () . equals ( name ) ) {
6 return startIndex ;
7 }
8 return indexOf ( name , startIndex + 1) ;
9 }
3