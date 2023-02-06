/**
 * Class holds telephone entry.
 *
 * @author pm
 * @version 1.1, 10/2020
 */
public class TelefonEintrag {
    private String number;
    private String name;
    /**
     * constructs a new TelefonEintrag-Object with the specified name and
     * phonenumber.
     * @param name, the name of this entry
     * @param number, the phone number of this entry
     */
    public TelefonEintrag(String name, String number) {
        this.name = name;
        this.number = number;
    }

    /**
     * returns the phone number.
     * @return the phonenumber.
     */
    public String getNumber() {
        return this.number;
    }
    /**
     * returns the name.
     * @return the name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * updates the phone number
     * @param number, the new phone number.
     */
    public void setNumber(String number) {
        this.number = number;
    }
    /**
     * updates the name
     * @param name, the new name.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Nummer: " + this.number;
    }
}
