Zusatztestat
Aufgabe 1: ObjektorienƟerte Programmierung mit Schnittstellen
A1.1

Erstelle eine Schnittstelle namens Person mit den folgenden Methoden:
 String getStudent(): Gibt den Namen des Studenten zurück.
 int getId(): Gibt die ID des Studenten zurück.

Lösung:
public interface Person {
 String getStudent();
 int getId();
}


A1.2
ImplemenƟere eine Klasse Student die die SchniƩstelle Person implemenƟert.
Die Klasse Student soll zwei private AƩribute haben:
 name (String)
 id (int).
ImplemenƟere einen Konstruktor, der die AƩribute name und id iniƟalisiert.
ImplemenƟere die Methoden getStudent() und getId() aus der SchniƩstelle Person.

Lösung:
public class Student implements Person {
 private String name;
 private int id;
 public Student(String name, int id) {
 this.name = name;
 this.id = id;
 }
 @Override
 public String getStudent() {
 return name;
 }
 @Override
 public int getId() {
 return id;
 }
}



A1.3
ImplemenƟere in der Klasse Student eine Methode equals(Object other).
Diese Methode soll überprüfen, ob zwei Student-Objekte gleich sind.
Zwei Student-Objekte sind gleich, wenn ihre IDs übereinsƟmmen.


Lösung:
public class Student implements Person {
[Code von der Aufgabe davor]
 @Override
 public boolean equals(Object o) {
 if (o == null) {
 return false;
 }

 if (this == o) {
 return true;
 }

 if (getClass() != o.getClass()) {
 return false;
 }

 Student student = (Student) o;
 return id == student.id;
 }
}



Aufgabe 2: Array-Verarbeitung und ExcepƟon-Handling

Schreibe eine Methode calculateAverage(int[] values), die den DurchschniƩ der Werte in einem
gegebenen Integer-Array berechnet.
Die Methode soll eine IllegalArgumentExcepƟon werfen, wenn das Array null ist oder keine Elemente
enthält.

Lösung
public class ArrayUtils {
 public static double calculateAverage(int[] values) {
 if (values == null || values.length == 0) {
 throw new IllegalArgumentException("Array darf nicht null sein und
muss mindestens ein Element enthalten");
 }
 int sum = 0;

 for (int i = 0; i < values.length; i++) {
 sum = sum + values[i];
 }

 return (double) sum / values.length;
 }
}

Main-Methode zum Testen:
public static void main(String[] args) {
 int[] values = {1, 2, 3, 4, 5};
 double average = ArrayUtils.calculateAverage(values);
 System.out.println("Der Durchschnitt ist: " + average);
 }


Aufgabe 3: Einfach verkettete Liste

ImplemenƟere eine Klasse LinkedList für eine einfach verkeƩete Liste von Strings.
Die Klasse soll folgende Methoden enthalten:
 int size(): Gibt die Anzahl der Elemente in der Liste zurück.
 void add(String element): Fügt ein Element am Anfang der Liste hinzu.
 String get(int index): Gibt das Element an der angegebenen PosiƟon zurück. Die Methode soll
eine IllegalArgumentExcepƟon werfen, wenn der Index ungülƟg ist (d.h. kleiner als 0 oder
größer als die aktuelle Größe der Liste).

Lösung
public class LinkedList {
 private Node head;
 private static class Node {
 String data;
 Node next;
 public Node(String data) {
 this.data = data;
 this.next = null;
 }
 }
 public int size() {
 int count = 0;
 Node current = head;
 while (current != null) {
 count++;
 current = current.next;
 }
 return count;
 }
 public void add(String element) {
 Node newNode = new Node(element);
 newNode.next = head;
 head = newNode;
 }
 public String get(int index) {
 if (index < 0) {
 throw new IllegalArgumentException("Index muss größer oder gleich 0
sein");
 }
 Node current = head;
 int i = 0;
 while (current != null && i < index) {
 current = current.next;
 i++;
 }
 if (current == null) {
 throw new IllegalArgumentException("Index ist außerhalb des gültigen
Bereichs");
 }
 return current.data;
 }
}
Main-Methode zum Testen
public static void main(String[] args) {
 LinkedList list = new LinkedList();
 list.add("Hallo");
 list.add("Welt");
 System.out.println(list.size()); // Ausgabe: 2
 System.out.println(list.get(0)); // Ausgabe: Welt
 }
