package dicionario;


import hashTable.*;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class Dicionario<TK, TV> {

    private HashTable hashTable;
    public static ItemTabelaHash NO_SUCH_KEY;

    public Dicionario(HashTable hashTable) {

        this.hashTable = hashTable;

        NO_SUCH_KEY = HashTable.NO_SUCH_KEY;

    }

    public void insert(TK key, TV value) {
        ItemTabelaHash<TK, TV> newItem = new ItemTabelaHash<>(key, value);
        hashTable.insert(newItem);
    }

    public TV find(TK key) {
        ItemTabelaHash item = hashTable.find(key);

        if (item == HashTable.NO_SUCH_KEY) {

            throw new IllegalArgumentException("Chave inválida.");

        } else {

            return (TV) item.getValue();

        }
    }

    public void remove(TK key) {
        hashTable.remove(key);
    }

    public int size() {
        return hashTable.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public TK[] keys() {

        return (TK[]) hashTable.keys();
    }

    public TV[] elements() {

        return (TV[]) hashTable.elements();
    }

    public String getCsvArmazenamento() {
        return hashTable.getCsv();
    }

}
