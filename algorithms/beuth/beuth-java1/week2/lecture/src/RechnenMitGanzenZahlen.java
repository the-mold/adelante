public class RechnenMitGanzenZahlen {

    public static void main(String[] args) {

        int a = 24;
        int b =  2;
        int c =  0;

        System.out.println("");
        System.out.println("Den Variable a, b und c sind folgende " +
        "Werte zugewiesen worden: ");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);

        //----------------------------------------------------------

        System.out.println("");
        System.out.println("Arithmetische Operatoren:");
        System.out.println("");

        //Inkrement von i:
        System.out.println("");
        System.out.println("Das Inkrement von a = ++a ist: " + (++a) + ".");

        //Division ganzer Zahlen:
        c=a/b;
        System.out.println("");
        System.out.println("Das Ergebnis der Division der beiden Zahlen a=25 " +
        "dividiert durch b=2 ist: " + c + ".");

        //Modulo (Restwert der Division):
        c=a%b;
        System.out.println("");
        System.out.println("Der Restwert betraegt: " + c + ".");

        //Ausgabe des groessten Wertes, der vom Datentyp long ist:
        System.out.println("");
        System.out.println("Der groesste Wert vom Typ " +
        "long ist: " + Long.MAX_VALUE + ".");

        //------------------------------------------------------------

        System.out.println("");
        System.out.println("Vergleichsoperatoren:");
        System.out.println("");

        //Welche Zahl ist groesser???
        System.out.println("");
        System.out.println("Ist a groesser als b???");
        System.out.println(" a > b = " + (a > b));	  //true

        //Welche Zahl ist kleiner???
        System.out.println("");
        System.out.println("Welche Zahl ist kleiner???");
        System.out.println(" a < b = " + (a < b));     //false

        //Welche Zahl ist groesser oder gleich???
        System.out.println("");
        System.out.println("Welche Zahl ist groesser oder gleich???");
        System.out.println(" a >= b = " + (a >= b));   //true

        // Welche Zahl ist kleiner oder gleich???
        System.out.println("");
        System.out.println("Welche Zahl ist kleiner oder gleich???");
        System.out.println(" a <= b = " + (a <= b));   //false

        // Welche Zahlen sind gleich???
        System.out.println("");
        System.out.println("Welche Zahlen sind gleich???");
        System.out.println(" a == b = " + (a == b));   //false

        // Welche Zahlen sind ungleich???
        System.out.println("");
        System.out.println("Welche Zahlen sind ungleich???");
        System.out.println(" a != b = " + (a != b));   //true
        System.out.println("");

        //-----------------------------------------------------------

        System.out.println("");
        System.out.println("Kombination von Zuweisungs- und arithmetischen Operatoren:");
        System.out.println("");

        //Addiere b zu a und weise das Ergebnis a zu
        System.out.println("");
        System.out.println(" a+=b: Addiere a+b und weise das Ergebnis a zu");
        System.out.println(" a+=b; a=" + (a+=b));

        //Subtrahiere b von a und weise das Ergebnis a zu
        System.out.println("");
        System.out.println(" a-=b: Subtrahiere a-b und weise das Ergebnis a zu");
        System.out.println(" a-=b; a=" + (a-=b));

        //Multipliziere b mit a und weise das Ergebnis a zu
        System.out.println("");
        System.out.println(" a*=b: Multipliziere a*b und weise das Ergebnis a zu");
        System.out.println(" a*=b; a=" + (a*=b));

        //Dividiere a durch b und weise das Ergebnis a zu
        System.out.println("");
        System.out.println(" a/=b: Dividiere a/b und weise das Ergebnis a zu");
        System.out.println(" a/=b; a=" + (a/=b));
    }
}

