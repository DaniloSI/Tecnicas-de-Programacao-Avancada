package hashTable;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class ItemTabelaHash<TK, TV> {
    private TK key;
    private TV value;

    public ItemTabelaHash(TK key, TV value) {
        this.key = key;
        this.value = value;
    }

    public TK getKey() {
        return key;
    }

    public void setKey(TK key) {
        this.key = key;
    }

    public TV getValue() {
        return value;
    }

    public void setValue(TV value) {
        this.value = value;
    }
}
