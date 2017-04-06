package hashTable;

/**
 * Created by danilo on 05/04/17.
 */
public abstract class HashTable {

    public static final ItemTabelaHash NO_SUCH_KEY = new ItemTabelaHash(null, null);

    public abstract void insert(ItemTabelaHash itemAdd);

    public abstract ItemTabelaHash find(Object key);

    public abstract ItemTabelaHash remove(Object key);

    public abstract int size();

    public abstract boolean isEmpty();

    public abstract Object[] keys();

    public abstract Object[] elements();

    public abstract String getCsv();
}
