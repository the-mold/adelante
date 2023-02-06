import java.util.Arrays;

/**
 * a very simplified version of java.util.ArrayList<E>
 *
 * @param <E>
 */
public class MeineArrayList<E> {
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY_INCREMENTOR = 5;

    private Object[] list;
    /**
     * The size of the ArrayList (the number of elements it contains).
     *
     * @serial
     */
    private int size;
    private int capacity;
    private int capacityIncrementor;

    private void grow(int newCapacity) {
        list = Arrays.copyOf(list, newCapacity);
    }

    private void ensureCapacity() {
        if (size + 1 > capacity) {
            grow(capacity + capacityIncrementor);
        }
    }

    /**
     * default constructor.
     */
    public MeineArrayList() {
        capacity = DEFAULT_CAPACITY;
        list = new Object[capacity];
        size = 0;
        capacityIncrementor = DEFAULT_CAPACITY_INCREMENTOR;
    }

    /**
     * constructs a MeineArrayList-Object with initial capacity c
     * and increment inc
     * @param c the initial capacity
     * @param inc the number of positions that will be added
     * when the list is made bigger
     */
    public MeineArrayList(int c, int inc) {
        if (c > 0) {
            capacity = c;
        } else {
            capacity = DEFAULT_CAPACITY;
        }
        if (inc > 0) {
            capacityIncrementor = inc;
        } else {
            capacityIncrementor = DEFAULT_CAPACITY_INCREMENTOR;
        }
        list = new Object[capacity];
        size = 0;
    }
    /**
     * Get item by idx.
     * @return returns an item.
     */
    @SuppressWarnings("unchecked")
    private E get(int idx) {
        return (E) list[idx];
    }
    /**
     * Appends a new item to the list.
     * @return boolean confirmation that an item was added.
     */
    public boolean add(E newItem) {
        ensureCapacity();
        list[size] = newItem;
        size++;
        return true;
    }
    /**
     * Checks if requested index is within the range.
     * @throws IndexOutOfBoundsException
     */
    private void rangeCheck(int index) throws IndexOutOfBoundsException {
        if (index >= size)
            throw new IndexOutOfBoundsException("not in range");
    }
    /**
     * Removes a list items by the index.
     * @throws IndexOutOfBoundsException
     * @return removed item.
     */
    public E remove(int idx) throws IndexOutOfBoundsException {
        rangeCheck(idx);

        E oldValue = get(idx);
        Object[] newList = new Object[capacity];
        int newListIDX = 0;
        for (int i = 0; i < list.length; i++) {
            if (i == idx) {
                size--;
            } else {
                newList[newListIDX] = list[i];
                newListIDX++;
            }
        }
        list = newList;
        return oldValue;
    }
    /**
     * Clears the list.
     */
    public void clear() {
        list = new Object[capacity];
        size = 0;
    }
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < list.length; i++) {
            E item = get(i);
            if (item != null) {
                str = str.concat("[" + item + "]") ;
            }
        }
        return "[" + str + "]";
    }
}
