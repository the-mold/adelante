import de.vfh.gp1.bib.Konsole;

/**
 * SportTip let's you get sport tip for your age.
 *
 * @author Team (s77409@beuth-hochschule.de)
 * @version 1.01, 10/2018
 */
public class SportTip {
    public static void main(String []args) {
        int benutzerAuswahl = Konsole
                .getInputInt("Alter?: ");

        if (benutzerAuswahl <= 15) {
            System.out.println("Fußball");
        } else if (15 < benutzerAuswahl && benutzerAuswahl <= 25) {
            String aufregung = Konsole
                    .getInputString("Aufregung lieben? ");

            switch (aufregung) {
                case "ja":
                    System.out.println("Fallschirmspringen");
                    break;
                default:
                    System.out.println("Golf");
            }
        } else if (25 < benutzerAuswahl && benutzerAuswahl <= 40) {
            int kids = Konsole
                    .getInputInt("Wie viele Kinder? ");

            switch (kids) {
                case 0:
                    System.out.println("Fahradtour");
                    break;
                case 1:
                case 2:
                    System.out.println("Tennis");
                    break;
                default:
                    System.out.println("Basketball");
            }

        } else {
            System.out.println("Frage mal den Arzt");
        }
    }
}
