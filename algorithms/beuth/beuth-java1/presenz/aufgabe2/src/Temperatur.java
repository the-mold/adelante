import java.util.Arrays;
import java.text.DecimalFormat;
import de.vfh.gp1.bib.Konsole;

public class Temperatur {
    private static final int TYPE_CELCIUS = 1;
    private static final int TYPE_FAHRENHEIT = 2;

    static int[] createCelciusArray() {
        int[] res = new int[20];
        for (int i = 0; i < 40; i++) {
            if (i % 2 == 0) {
                res = addElement(res, i);
            }
        }

        /*int[] res = {0};
        for (int i = 2; i < 39; i++) {
            if (i % 2 == 0) {
                res = addElement(res, i);
            }
        }*/

        return res;
    }

    static String formatFahrenheit(double temp) {
        DecimalFormat formatter = new DecimalFormat(".0");
        String s = formatter.format(temp) + "F";
        return s;
    }

    static double celciusToFahrenheit(int celcius) {
        return celcius * 1.8 + 32;
    }

    static int[] addElement(int[] a, int e) {
        a  = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }

    static String printSeparator(int currValue, int input, int type) {
        if (type == TYPE_CELCIUS) {
            if (currValue <= input) {
                return "#";
            }
        }

        if (type == TYPE_FAHRENHEIT) {
            double currValueFahrenheit =  celciusToFahrenheit(currValue);

            if (currValueFahrenheit <= input) {
                return "#";
            }
        }

        return "";
    }

    public static void main(String[] args) {
        int[] celciusArr = createCelciusArray();

        int input = Konsole.getInputInt("Temperatur heute?");
        String inputTypeStr = Konsole.getInputString("Celsius oder Fahrenheit");

        int type = TYPE_FAHRENHEIT;

        if (inputTypeStr.equals("C") || inputTypeStr.equals("c")) {
            type = TYPE_CELCIUS;
        }

        String fTemp;
        String breack = "    ";

        for (int i = celciusArr.length - 1; i > 0; i--) {

            fTemp = formatFahrenheit(celciusToFahrenheit(celciusArr[i]));

            System.out.println(celciusArr[i] + "C" + breack + printSeparator(celciusArr[i], input, type) + breack + fTemp);
        }
    }
}
