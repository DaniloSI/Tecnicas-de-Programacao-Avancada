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
        ItemTabelaHash itemFound = getItemTabelaHash(key);

        if (itemFound == null) {
            ItemTabelaHash<TK, TV> newItem = new ItemTabelaHash<>(key, value);

            tabelaHash.add(newItem);
        } else {
            itemFound.setValue(value);
        }

    }

    public TV find(TK key) {
        return (TV) getItemTabelaHash(key).getValue();
    }

    private ItemTabelaHash getItemTabelaHash(TK key) {
        ItemTabelaHash item = this.tabelaHash.get((String) key);

        if (item == null) {
            return null;
        } else {
            if (item.getKey() != key) {
                ItemTabelaHash[] itens = tabelaHash.getAll();
                int index = tabelaHash.indexOf((String) key);

                for (int i = 0 ; i < tabelaHash.size() ; i++) {
                    if (itens[index].getKey() == key) {
                        return itens[index];
                    }

                    index = (index + 1) % tabelaHash.size();
                }

                return null;

            } else {
                return item;
            }
        }
    }

    public void remove(TK key) {
        ItemTabelaHash[] itens = this.tabelaHash.getAll();
        int index = this.tabelaHash.indexOf((String) key);

        for (int i = 0 ; i < this.tabelaHash.size() && itens[index] != null ; i++) {
            if (itens[index].getKey() == key) {
                this.tabelaHash.remove(index);
                itens[index] = null;
            } else {
                index = (index + 1) % tabelaHash.size();
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
