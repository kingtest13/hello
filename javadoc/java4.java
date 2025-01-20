Aufgabe 1 – Exceptions

Implemenieren Sie die folgenden Methoden in der Klasse Executor wie folgt:
 void checkRange(int n, int min, int max)
Diese Methode soll eine IllegalArgumentException auslösen, falls der Wert von "n" kleiner ist
als "min" oder größer ist als "max". Im ersten Fall soll die in der Exception enthaltene
Meldung (engl. message) aus der Zeichenkette "N is too small." bestehen. Im zweiten Fall soll
die Meldung auf "N is too large" gesetzt sein. 


public class Executor {
    public void checkRange(int n, int min, int max) {
        if (n < min) {
            throw new IllegalArgumentException("N is too small.");
        } else if (n > max) {
            throw new IllegalArgumentException("N is too large.");
        }
    }
}



int executeSafely(Executable executable)
Diese Methode soll zuerst die Methode execute() und dann die Methode finish() am
übergebenen "executable" aufrufen. Die Methode finish() soll auch dann aufgerufen werden,
falls die Methode execute() eine Exception auslöst. Der Rückgabewert der Methode soll 0
sein, falls der Aufruf von execute() keine Exception auslöst. Wird beim Aufruf von execute()
eine IllegalStateExcepƟon ausgelöst, soll -1 zurückgegeben werden. Wird beim Aufruf von
execute() eine IOException ausgelöst, soll 1 zurückgegeben werden.


public class Executor {
    public int executeSafely(Executable executable) {
        try {
            executable.execute(); // Führt die Methode execute() aus
            return 0; // Kein Fehler, Rückgabewert 0
        } catch (IllegalStateException e) {
            return -1; // Rückgabewert bei IllegalStateException
        } catch (IOException e) {
            return 1; // Rückgabewert bei IOException
        } finally {
            try {
                executable.finish(); // finish() wird immer ausgeführt
            } catch (Exception e) {
                // Ignorieren oder Logging falls nötig
            }
        }
    }
}


Aufgabe 2 – I/O Streams 

ImplemenƟeren Sie die folgenden Methoden in der Klasse IntegerListSerializer:
 void write(BufferedWriter writer, List<Integer> list)
Diese Methode soll den Inhalt der übergebenen Liste mit Hilfe des übergebenen Writers
schreiben. Jedes einzelne Element der Liste soll dabei auf eine eigene Zeile ausgegeben
werden. Den hierfür notwendigen Zeilenumbruch können Sie mit dem Steuerzeichen "\n"
erzeugen.

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class IntegerListSerializer {
    public void write(BufferedWriter writer, List<Integer> list) {
        for (Integer number : list) {
            try {
                writer.write(number.toString() + "\n");
            } catch (IOException e) {
                throw new RuntimeException("Error writing to writer", e);
            }
        }
    }
}


public class IntegerListSerializer {

    // Method to write integers from a list into a BufferedWriter
    public void write(BufferedWriter writer, List list) throws IOException {
        // Iterate over each integer in the list
        for (Integer number : list) {
            // Write the number followed by a newline character
            writer.write(number.toString());
            writer.write("\n");
        }
        
        // Ensure all data is flushed to avoid buffering issues
        writer.flush();
    }
}


List<Integer> read(BufferedReader reader)
Diese Methode soll den gesamten Inhalt des übergebenen Readers zeilenweise lesen und mit
Hilfe der Methode convertStringToInteger in Zahlen umwandeln. Die umgewandelten Zahlen
sollen anschließend als Liste zurückgegeben werden. 


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IntegerListSerializer {
    public List<Integer> read(BufferedReader reader) throws IOException {
        List<Integer> integers = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            integers.add(convertStringToInteger(line));
        }

        return integers;
    }

    private Integer convertStringToInteger(String str) {
        return Integer.parseInt(str);
    }
}






