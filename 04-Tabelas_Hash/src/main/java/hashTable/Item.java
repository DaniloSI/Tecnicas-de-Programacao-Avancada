package hashTable;

/**
 * Created by danilo on 23/04/17.
 */
public class Item {
    private Object key;
    private Object elemento;
    private int cacheHashCode;

    public Item(Object key, Object elemento) {
        this.key = key;
        this.elemento = elemento;
    }

    public Item(Object key, Object elemento, int cacheHashCode) {
        this.key = key;
        this.elemento = elemento;
        this.cacheHashCode = cacheHashCode;
    }

    public Object getKey() {
        return key;
    }

    public Object getElement() {
        return elemento;
    }

    public int getCacheHCode() {
        return cacheHashCode;
    }

    public void setElem(Object pelem) {
        this.elemento = pelem;
    }

    public void setCacheHCode(int hashCode) {
        this.cacheHashCode = hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Item) {
            Item item = (Item) obj;
            return (key == null) ? item.getKey() == null : key.equals(item.getKey());
        }

        return false;
    }
}
