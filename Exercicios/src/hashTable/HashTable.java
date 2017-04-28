package hashTable;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by danilo on 05/04/17.
 */
public abstract class HashTable {

    public static final Item NO_SUCH_KEY = new Item(null, null);

    protected int tamanho = 1;
    protected int quantidadeItens = 0;
    protected HashEngine hashEngine;

    public HashTable() {
        this.hashEngine = new HashEngineDefault();
    }

    public HashTable(HashEngine hE) {
        this.hashEngine = hE;
    }

    public HashTable(int tam, HashEngine hE) {
        this.tamanho = tam;
        this.hashEngine = hE;
    }

    public abstract boolean insertItem(Object key, Object elem);

    public abstract Object removeItem(Object key);

    public abstract Object findElem(Object key);

    public abstract int size();

    public abstract boolean empty();

    public abstract LinkedList keys();

    public abstract LinkedList elements();

    public abstract void salvaColisoes(String fileName) throws IOException;
}
