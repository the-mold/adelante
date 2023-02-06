import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class for EUR/USD currency conversion. Class reads int and string inputs from console.
 *
 * @author pm
 * @version 1.1, 10/2020
 */
public class Eurorechner {
    private final static String EUR = "E";
    private final static String USD = "U";
    private final static String IS_REPEATING = "J";
    double EUR_TO_USD_FX;

    /**
     * Class constructor.
     *
     * @param fx is EUR/USD exchange rate.
     */
    public Eurorechner (double fx) {
        EUR_TO_USD_FX = fx;
    }

    /**
     * Main-Method.
     *
     * @param args parameters
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // 1. collect data
        String currency = ensureStringEntry("Eingabe der Ausgangswaehrung (" + EUR + ")uro oder (" + USD + ")S Dollar?");
        int amount = ensureIntEntry("Betrag eingeben");

        // 2. init class
        Eurorechner obj = new Eurorechner(1.17);

        // 3. report
        System.out.println("Ergebnis " + obj.convert(currency, amount));
    }

    /**
     * Ensure string value that is read from the console.
     *
     * @param currency currency choice
     * @param amount amount to convert
     */
    public double convert(String currency, int amount) {
        if (currency.equalsIgnoreCase(USD)) {
            return EUR_TO_USD_FX * amount;
        }

        return 1 / EUR_TO_USD_FX * amount;
    }

    /**
     * Ensure string value that is read from the console.
     *
     * @param str string message.
     * @throws IOException
     */
    public static String ensureStringEntry(String str) throws IOException {
        // read string
        String currency = textInput(str);

        // early return if value is correct
        if (currency.equalsIgnoreCase(EUR) || currency.equalsIgnoreCase(USD)) {
            System.out.println("Waerung ist " + currency);
            return currency;
        }

        if (isRepeatingEntry()) {
            return ensureStringEntry(str);
        } else {
            terminateProgram();
        }

        return "";
    }

    /**
     * Collect user input on whether entry should be repeated.
     *
     * @throws IOException
     */
    public static boolean isRepeatingEntry() throws IOException {
        System.out.println("Falsche Eingabe bitte nochmal!");
        String ans = textInput("Wollen Sie noch einmal j/n?");
        return ans.equalsIgnoreCase(IS_REPEATING);
    }

    /**
     * Ensure int value that is read from the console.
     *
     * @param str string message.
     * @throws IOException
     */
    public static int ensureIntEntry(String str) throws IOException {
        int amount = 0;
        try {
            amount = intInput(str);
        } catch (Exception e) {
            if (isRepeatingEntry()) {
                return ensureIntEntry(str);
            }
            terminateProgram();
        }
        System.out.println("Betrag ist " + amount);
        return amount;
    }

    /**
     * Read and return string input from the console.
     *
     * @param str string message.
     * @throws IOException
     */
    public static String textInput(String str) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(str + " : ");
        return reader.readLine();
    }

    /**
     * Read and return int input from the console.
     *
     * @param str string message.
     * @throws IOException
     */
    public static int intInput(String str) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(str + ": ");
        return Integer.parseInt(reader.readLine());
    }

    /**
     * Terminates program if needed.
     */
    public static void terminateProgram() {
        System.out.println("Bye!");
        System.exit(0);
    }
}
