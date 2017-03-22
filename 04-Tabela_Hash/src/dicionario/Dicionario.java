package dicionario;

import hashTable.ItemTabelaHash;
import hashTable.TabelaHash;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class Dicionario<TK, TV> {
    private TabelaHash tabelaHash = new TabelaHash(100);

    public void insert(TK key, TV value) {
        ItemTabelaHash<TK, TV> newItem = new ItemTabelaHash<>(key, value);

        this.tabelaHash.add(newItem);
    }

    public TV find(TK key) {
        for (ItemTabelaHash item : this.tabelaHash.get((String) key)) {
            if (item.getKey() == key) {
                return (TV) item.getValue();
            }
        }

        throw new IllegalArgumentException("Chave não encontrada");
    }

    public void remove(TK key) {
        List<ItemTabelaHash> itens = this.tabelaHash.get((String) key);

        for (ItemTabelaHash item: itens) {
            if (item.getKey() == key) {
                itens.remove(item);
            }
        }
    }

    public int size() {
        return this.tabelaHash.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public List<TK> keys() {
        List<TK> keys = new LinkedList<>();

        for (ItemTabelaHash item: this.tabelaHash.getAll()) {
            keys.add((TK) item.getKey());
        }

        return keys;
    }

    public List<TV> values() {
        List<TV> values = new LinkedList<>();

        for (ItemTabelaHash item: this.tabelaHash.getAll()) {
            values.add((TV) item.getValue());
        }

        return values;
    }

}
