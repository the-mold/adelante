import de.vfh.gp1.bib.Konsole;

/**
 * Class used to get Reihung.
 *
 * @author Petro Moldovan (s77409@beuth-hochschule.de)
 * @version 1.01, 12/2018
 *
 */

public class Reihung {
    private int untereGrenze;
    private int obereGrenze;
    private int maximaleAnzahl;
    private int[] validArray;
    private int[] invalidArray;

    public Reihung(int untereGrenze, int obereGrenze, int maximaleAnzahl) {
        this.untereGrenze = untereGrenze;
        this.obereGrenze = obereGrenze;
        this.maximaleAnzahl = maximaleAnzahl;

        this.validArray = new int[maximaleAnzahl];
        this.invalidArray = new int[maximaleAnzahl];
    }

    public Reihung(int [] reihung) {
        // min value
        for (int item : reihung) {
            if (item < this.untereGrenze) {
                this.untereGrenze = item;
            }
        }

        // max value
        for (int item : reihung) {
            if (item > this.untereGrenze) {
                this.obereGrenze = item;
            }
        }

        // length
        this.maximaleAnzahl = reihung.length;

        this.validArray = new int[maximaleAnzahl];
        this.invalidArray = new int[maximaleAnzahl];
    }

    public void einlesen() {
        int inputNumber;

        System.out.println("Please enter number between " + this.untereGrenze + " and " + this.obereGrenze + ". Enter 0 to finish");
        inputNumber = Konsole.getInputInt();

        if (inputNumber == 0) {
            // end
            System.out.println("Ending input");
            return;
        }

        // validate
        if (inputNumber > this.obereGrenze || inputNumber < this.untereGrenze) {
            System.out.println("Invalid number");
            this.invalidArray = arrayIntPush(this.invalidArray, inputNumber);
            this.einlesen();
            return;
        }

        System.out.println("Valid number");
        this.validArray = arrayIntPush(this.validArray, inputNumber);
        this.einlesen();
    }

    public static int[] arrayIntPush(int[] arr, int item) {
        int[] res = arr;
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0) {
              res[i] = item;
              break;
            }
        }

        return res;
    }

    public int getMin() {
        int res = 0;
        for (int item : this.validArray) {
            if (item < res) {
                res = item;
            }
        }

        return res;
    }

    public int getMax() {
        int res = 0;
        for (int i = 0; i < this.validArray.length; i++) {
            if (this.validArray[i] > res) {
                res = this.validArray[i];
            }
        }

        return res;
    }

    public int berechneSumme() {
        int res = 0;
        for (int i = 0; i < this.validArray.length; i++) {
            if (this.validArray[i] > res) {
                res = res + this.validArray[i];
            }
        }

        return res;
    }

    public String arrToString(int[] arr) {
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                res = res + "[" + arr[i] + "]";
            }
        }

        return res;
    }

    public int arrEffectiveLength(int []arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                res++;
            }
        }

        return res;
    }

    public int[] sortierteReihung() {
        boolean ok;
        int[] res = this.validArray;
        do {
            ok = true;
            for (int i = 0; i < (res.length - 1); i++) {
                if (res[i] > res[i + 1]) {
                    int temp = res[i];
                    res[i] = res[i + 1];
                    res[i + 1] = temp;
                    ok = false;
                }
            }
        } while (!ok);

        return res;
    }

    public String toString() {
        return "****************************************\n"
                + "Valid numbers: " + arrEffectiveLength(this.validArray) + "\n"
                + "Invalid numbers: " + arrEffectiveLength(this.invalidArray) + "\n"
                + "Lower allowed limit: " + this.untereGrenze + "\n"
                + "Upper allowed limit: " + this.obereGrenze + "\n"
                + "Array numbers: " + arrToString(this.validArray) + "\n"
                + "Sorted array: " + arrToString(sortierteReihung()) + "\n"
                + "Biggest number: " + getMax() + "\n"
                + "Array sum: " + berechneSumme() + "\n";
    }
}
