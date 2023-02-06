import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class UtilitiesArraysFiles {

    /**
     * liest ganze Zahlen aus der Datei filename und gibt sie in ein Array zurück.
     * Es ist erwartet dass jede Zeile genau eine ganze Zahl hat.
     * Der Name der Datei soll den ganzen Pfad beinhalten, z.B.
     * "C:/Users/Beuth/vfh/Standford/QuickSort.txt"
     * @param filename, Namen der Datei, in der die Zahlen gespeichert sind
     * @return ein Array das alle Zahlen enthält.
     * @throws IOException
     */
    public static int[] readInArray(String filename) {
        try {
            File fi = new File(filename);
            System.out.println(fi.length());

            BufferedReader in
                    = new BufferedReader(new FileReader(filename));

            ArrayList<Integer> ar = new ArrayList<>();

            String s = in.readLine();
            while (s != null) {
                int i = Integer.parseInt(s);
                ar.add(i);
                s = in.readLine();
            }
            System.out.println(ar.size());
            int [] ir = new int [ar.size()];
            for (int i=0; i< ir.length; i++) {
                ir [i] = ar.get(i);
            }
            in.close();
            return ir;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new int[0];
        }
    }

    // this implementation uses classes and regular expressions
    // new in Java 8

    public static int[] readInArray2(String filename) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Path path = Paths.get(filename);
        try(Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                numbers.add(Integer.parseInt(line));
            });
        } catch(IOException ex) {
            System.out.println("Datei '" + filename + "' konnte nicht gelesen werden: "+ex.getMessage());
        }
        return numbers.stream().mapToInt(i -> i).toArray();
        //return numbers.toArray(new int[0]); does not work because int ist not Integer
    }
    /**
     * schreibt alle Zahlen im Array ir in die Datei namens filename.
     * Eine Zahl wird auf eine eigene Zeile geschrieben.
     * Der Name der Datei soll den ganzen Pfad beinhalten, z.B.
     * "C:/Users/Beuth/vfh/Standford/QuickSortSorted.txt"
     * @param ir
     * @param filename
     */

    public static void writeArrayToFile(int [] ir, String filename ) {

        try {
            FileOutputStream   felix = new FileOutputStream  (filename);
            OutputStreamWriter olli  = new OutputStreamWriter(felix);
            BufferedWriter     bruno = new BufferedWriter    (olli);

            for(int i=0; i<ir.length-1; i++) {
                bruno.write("" + ir[i]  );
                bruno.newLine();
            }
            bruno.write("" +ir[ir.length -1] );
            bruno.flush();
            bruno.close();
        } catch ( IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
