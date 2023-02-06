import java.io.File;
import java.io.IOException;

/**
 * Class to get file info.
 *
 * @author pm
 * @version 1.1, 10/2020
 */
public class DatInfo {
    /**
     * Gibt die letzte Änderung der übergebenen Datei auf
     * der Standardausgabe aus.
     *
     * @param eingabe zu überprüfende Datei
     */
    public static void aenderungAusgeben(File eingabe) {
        System.out.println(eingabe.lastModified());
    }

    /**
     * Prüft, ob die übergebene Datei existiert und gibt
     * das Ergebnis als Boolean zurück
     *
     * @param eingabe zu überprüfende Datei
     * @throws IOException
     * @return Datei existiert?
     */
    public static boolean existiert(File eingabe) throws IOException {
        boolean exists = eingabe.exists();
        if (!exists) {
            throw new IOException("file does not exist");
        }
        return exists;
    }

    /**
     * Gibt die Größe der übergebenen Datei auf der Standardausgabe aus.
     *
     * @param eingabe zu überprüfende Datei
     */
    public static void groesseAusgeben(File eingabe) {
        System.out.println(eingabe.length());
    }

    /**
     * Gibt auf der Standardausgabe aus, ob das übergebene File eine Datei
     * oder ein Verzeichnis ist.
     *
     * @param eingabe zu überprüfende Datei
     */
    public static void dateiOderVerzeichnis(File eingabe) {
        if (eingabe.isFile()) {
            System.out.println("File");
        } else {
            System.out.println("Verzeichnis");
        }
    }

    /**
     * Gibt die Zugriffsrechte der übergebenen Datei auf der
     * Standardausgabe aus.
     *
     * @param eingabe zu überprüfende Datei
     */
    public static void lesenSchreiben(File eingabe) {
        System.out.println("lesen: " + eingabe.canRead());
        System.out.println("schreiben: " + eingabe.canWrite());
    }

    /**
     * Gibt den Pfad der übergebenen Datei auf der Standardausgabe aus.
     *
     * @param eingabe zu überprüfende Datei
     */
    public static void pfadAusgeben(File eingabe) {
        System.out.println(eingabe.getAbsolutePath());
    }

    /**
     * Test-Mainfunktion, um die Klasse als Stand-Alone-Applikation zu testen.
     *
     * @param args Pfad zur Datei.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try {
            String path = "test.txt";
            if (args.length > 0) {
                path = args[0];
            }
            File testFile = new File(path);
            testFile.createNewFile();
            pfadAusgeben(testFile);
            lesenSchreiben(testFile);
            dateiOderVerzeichnis(testFile);
            aenderungAusgeben(testFile);
            dateiOderVerzeichnis(testFile);
            existiert(testFile);
            groesseAusgeben(testFile);
            testFile.delete();
        } catch (Exception e) {
            throw new IOException("DatInfo#maing#" + e.getMessage());
        }
    }
}
