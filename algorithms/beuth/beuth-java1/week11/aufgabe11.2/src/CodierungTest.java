import de.vfh.gp1.bib.Konsole;

/**
 * Class used to test Codierung.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 12/2018
 *
 */

public class CodierungTest {
    public static void main(String[] args) {
        System.out.println("Provide string to encode:");
        String inputString = Konsole.getInputString();

        System.out.println("Key 1(rows):");
        int inputRows = Konsole.getInputInt();

        System.out.println("Key 2(columns):");
        int inputColumns = Konsole.getInputInt();

        Codierung c = new Codierung(inputRows, inputColumns);
        System.out.println("Encoded text:\n" + c.verschluessleText(inputString));
    }
}
