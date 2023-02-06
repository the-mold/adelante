import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class to create order structure.
 *
 * @author pm
 * @version 1.1, 10/2020
 */
public class VerzErst {
    /**
     * Fordert zur Eingabe eines Strings (hier: Pfad) auf und liefert diesen zurück.
     *
     * @param text Enthaelt die Eingabeaufforderung fuer den Benutzer
     * @throws IOException
     * @return eingelesener String
     */
    public static String eingeben(String text) throws IOException {
        System.out.print(text + ": ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        return path;
    }

    /**
     * Erstellt ein Verzeichnis: Pfad+Verzeichnis entsprechen dem übergebenen String.
     *
     * @param verz Verzeichnisname + Pfad des zu erstellenden Verzeichnisses
     */
    public static void erstellen(String verz) {
        String fullPath = System.getProperty("user.dir") + "/" + verz;
        File f = new File(fullPath);
        if (f.mkdirs()) {
            System.out.println("Ordners wurden generiert: " + fullPath);
        } else {
            System.out.println("Kann nicht Ordners generieren: " + fullPath);
        }
    }

    /**
     * Test-Mainfunktion, um die Klasse als Stand-Alone-Applikation zu testen.
     *
     * @param args Pfad
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String path1 = eingeben("Pfad1 eingeben");
        erstellen(path1);
    }
}
