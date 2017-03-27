package dicionario;

import hashTable.ItemTabelaHash;
import hashTable.TabelaHashEnderecamentoAberto;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class DicionarioEnderecamentoAberto<TK, TV> {
    private TabelaHashEnderecamentoAberto tabelaHash = new TabelaHashEnderecamentoAberto(100);

    public void insert(TK key, TV value) {
        try {
            ItemTabelaHash<TK, TV> itemFound = tabelaHash.get(key);
            itemFound.setValue(value);
        } catch (IllegalArgumentException e) {
            ItemTabelaHash<TK, TV> newItem = new ItemTabelaHash<>(key, value);
            tabelaHash.add(newItem);
        }
    }

    public TV find(TK key) {
        return (TV) tabelaHash.get(key).getValue();
    }

    public void remove(TK key) {
        tabelaHash.delete(key);
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
            if (item != null) {
                keys.add((TK) item.getKey());
            }
        }

        return keys;
    }

    public List<TV> values() {
        List<TV> values = new LinkedList<>();

        for (ItemTabelaHash item: this.tabelaHash.getAll()) {
            if (item != null) {
                values.add((TV) item.getValue());
            }
        }

        return values;
    }

}
