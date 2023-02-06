import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * Class to substitute certain chars from the input html file.
 *
 * @author pm
 * @version 1.1, 10/2020
 */
public class HtmlConv {
    private static final HashMap<String, String> charToHtmlMap = new HashMap<>();
    private static final String[] charsChange = new String[]{"a", "b", "c"};
    static {
        charToHtmlMap.put("a", "AA");
        charToHtmlMap.put("b", "BBB");
        charToHtmlMap.put("c", "CCCC");
    }

    /**
     * Main-Method.
     *
     * @param args parameters
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String fileIn = "datei1702_vor.html";
        String fileOut = "datei1702_nach.html";
        replaceChars(fileIn, fileOut);
    }

    /**
     * Replace all target chars in the input file and save result in the new file.
     *
     * @param fileIn input file
     * @param fileOut output file
     * @throws IOException
     */
    public static void replaceChars(String fileIn, String fileOut) throws IOException {
        // read input data
        FileInputStream fiStream = new FileInputStream(fileIn);
        DataInputStream diStream = new DataInputStream(fiStream);

        // get byte array
        int dateiGroesse = (int) new File(fileIn).length();
        byte[] byteA = new byte[dateiGroesse];
        diStream.read(byteA);
        // close stream
        diStream.close();

        // byte array to string
        String str = new String(byteA,  StandardCharsets.UTF_8);

        // replace all chars in string
        int i;
        for (i = 0; i < charsChange.length; i++) {
            String replacement = charToHtmlMap.get(charsChange[i]);
            str = str.replaceAll(charsChange[i], replacement);
        }

        // open new file
        FileOutputStream foStream = new FileOutputStream(fileOut);
        DataOutputStream doStream = new DataOutputStream(foStream);

        // write the resulting string
        doStream.write(str.getBytes());
        doStream.flush();
        doStream.close();

        // try to check file in editor
        try {
            File fileToRead = new File(fileOut);
            java.awt.Desktop.getDesktop().edit(fileToRead);
        } catch (Exception e) {
            System.out.print("Could not open file in editor. Err: " + e.getMessage());
        }
    }
}
