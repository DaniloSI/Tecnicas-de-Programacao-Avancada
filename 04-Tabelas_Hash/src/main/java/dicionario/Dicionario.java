package dicionario;


import hashTable.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class Dicionario<TK, TV> {

    private HashTable hashTable;

    public Dicionario(HashTable hashTable) {
        this.hashTable = hashTable;
    }

    public void insert(TK key, TV value) {
        hashTable.insertItem(key, value);
    }

    public TV find(TK key) {
        Object object = hashTable.findElem(key);

        if (object == HashTable.NO_SUCH_KEY)
            throw new IllegalArgumentException("Chave inválida.");
        else
            return (TV) object;
    }

    public void remove(TK key) {
        hashTable.removeItem(key);
    }

    public int size() {
        return hashTable.size();
    }

    public boolean isEmpty() {
        return hashTable.empty();
    }

    public List<TK> keys() {
        List<TK> listKeys = new LinkedList<>();

        for (Object objectKey: hashTable.keys()) {
            listKeys.add((TK) objectKey);
        }

        return listKeys;
    }

    public List<TV> elements() {
        List<TV> listElements = new LinkedList<>();

        for (Object objectKey: hashTable.elements()) {
            listElements.add((TV) objectKey);
        }

        return listElements;
    }

    public void salvaColisoesKeys(String fileName) throws IOException {
        hashTable.salvaColisoes(fileName);
    }

}
