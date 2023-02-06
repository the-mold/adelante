import java.io.IOException;
import java.util.Comparator;

/**
 * Interface class that orders Person object by city and plz.
 *
 * @author PM
 * @since 10.10.2020
 */
public interface IPerson extends Comparable<IPerson>{
    /**
     * Inner class to compare two Person objects.
     */
    public static class PersonComparer implements Comparator<IPerson> {
        /**
         * Method to compare two Person objects.
         *
         * @return int comparison value.
         */
        @Override
        public int compare(IPerson p1, IPerson p2) {
            int comp = p1.getCity().compareTo(p2.getCity());
            if (comp != 0) {
                return comp;
            }
            return p1.getPLZ().compareTo(p2.getPLZ());
        }
    }

    /**
     * Method to retrieve a city from the Person object.
     *
     * @return String city name
     */
    String getCity();

    /**
     * Method to retrieve plz from the Person object.
     *
     * @return String plz
     */
    String getPLZ();

    /**
     * Compare function for two Person Objects.
     *
     * @param p Person object to compare.
     * @throws IOException
     */
    //@Override
    default int compareTo(IPerson p) {
        int comp = this.getCity().compareTo(p.getCity());
        if (comp != 0) {
            return comp;
        }
        return this.getPLZ().compareTo(p.getPLZ());
    }
}
