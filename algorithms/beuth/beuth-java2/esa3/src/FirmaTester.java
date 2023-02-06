import java.util.Arrays;

public class FirmaTester {
	
    /**
     * Main-Methode.
     * 
     * @param args Uebergabeparameter
     */
    public static void main(String[] args) {
        Firma kmu = new Firma(4, "Java4You");
        Angestellte ang1 = new Angestellte("Taylor", "Elisabeth",
                "Amrummer Strasse", "10", "Hamburg", "14444", true, 410000f);
        kmu.addAngestellte(ang1);
        // result should be 410000
        System.out.println(kmu.alleGehaelter());
        Angestellte ang2 = new Angestellte("Mueller", "Mark",
                "Amrummer Strasse", "11", "Hamburg", "15555", false, 10000f);
        kmu.addAngestellte(ang2);
        // result should be 420000
        System.out.println(kmu.alleGehaelter());
        Kunde k1 = new Kunde("Cruise", "Tom", "Amrummer Strasse", "12",
        		"Berlin", "12222", false);
        kmu.addKunde(k1);
        // result should be 0
        System.out.println(k1.getKundenNr());
        Kunde k2 = new Kunde("Jolie", "Angelina", "Amrummer Strasse", "13",
        		"Berlin", "13333", true);
        kmu.addKunde(k2);
        // result should be 1
        System.out.println(k2.getKundenNr());
        // check we have the right people
        kmu.alleAdressenAusgeben();
        Kunde k3 = new Kunde("Deneuve", "Catherine", "Amrummer Strasse", "14",
                 "Paris", "11111", true);
        // should not be possible
        kmu.addKunde(k3);
        // should be true
        System.out.println(kmu.istVoll());

        Person[] alle = kmu.getAllePersonen();
        Arrays.sort(alle, (p1,p2) -> p1.vorname.compareTo(p2.vorname));
        System.out.println(Arrays.deepToString(alle));
        Arrays.sort(alle, (p1,p2) -> p1.ort.compareTo(p2.ort));
        System.out.println(Arrays.deepToString(alle));

        System.out.println("===========================");
        System.out.println("INITIAL LIST:");
        System.out.println(Arrays.deepToString(alle));

        // sort by city and PLZ
        System.out.println("1. SORTED BY CITY AND PLZ:");
        Arrays.sort(alle, new IPerson.PersonComparer());
        System.out.println(Arrays.deepToString(alle));

        System.out.println("2. SORTED BY CITY AND PLZ WITH LAMDA:");
        Arrays.sort(alle, (p1,p2) -> {
            IPerson.PersonComparer c = new IPerson.PersonComparer();
            return c.compare(p1, p2);
        });
        System.out.println(Arrays.deepToString(alle));
    }

}
