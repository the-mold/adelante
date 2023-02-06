import java.util.ArrayList;

/**
 * Class holds telephone list.
 *
 * @author pm
 * @version 1.1, 10/2020
 */
public class Telefonliste {
    private ArrayList<TelefonEintrag> list = new ArrayList<>();

    /**
     * adds entry to the list.
     */
    public void addEntry(String key, String value) {
        TelefonEintrag ti = new TelefonEintrag(key, value);
        if (!list.contains(ti)) {
            list.add(ti);
        }
    }

    /**
     * clears the list.
     */
    public void clear() {
        list = new ArrayList<>();
    }

    /**
     * returns size of the list.
     * @return int size of the list.
     */
    public int size() {
        return list.size();
    }

    /**
     * search entry by name.
     * @return string representation of an entry.
     */
    public String searchByName(String key) {
        for (TelefonEintrag c : list) {
            if (c.getName().equalsIgnoreCase(key)) {
                return c.toString();
            }
        }
        return "";
    }

    /**
     * search entry by phone.
     * @return string representation of an entry.
     */
    public String searchNameByNumber(String value) {
        for (TelefonEintrag c : list) {
            if (c.getNumber().equalsIgnoreCase(value)) {
                return c.toString();
            }
        }
        return "";
    }

    /**
     * remove entry by name and phone.
     */
    public void removeEntry(String key, String value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName() == key && list.get(i).getNumber() == value) {
                list.remove(i);
                return;
            }
        }
        return;
    }

    /**
     * modifyEntry entry by name and phone with the new data.
     * @return boolean if operation was successful.
     */
    public boolean modifyEntry(String oldKey, String oldValue, String newKey, String newValue) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName() == oldKey && list.get(i).getNumber() == oldValue) {
                list.set(i, new TelefonEintrag(newKey, newValue));
                return true;
            }
        }
        return false;
    }
}
