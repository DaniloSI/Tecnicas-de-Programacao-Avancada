package hashTable;

/**
 * Created by danilo on 05/04/17.
 */
public abstract class HashTable {

    public static final ItemTabelaHash NO_SUCH_KEY = new ItemTabelaHash(null, null);

    abstract void insert(ItemTabelaHash itemAdd);

    abstract ItemTabelaHash find(Object key);

    abstract ItemTabelaHash remove(Object key);

    abstract int size();

    abstract boolean isEmpty();

    abstract Object[] keys();

    abstract Object[] elements();

    abstract String getCsv();
}
