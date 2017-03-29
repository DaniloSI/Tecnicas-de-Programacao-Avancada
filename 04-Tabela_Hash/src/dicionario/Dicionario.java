package dicionario;

import hashTable.ItemTabelaHash;
import hashTable.TabelaHash;
import hashTable.TipoFuncaoHash;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class Dicionario<TK, TV> {
    private TabelaHash tabelaHash;

    public Dicionario() {
        tabelaHash = new TabelaHash(100, TipoFuncaoHash.POLINOMIAL);
    }

    public Dicionario(TipoFuncaoHash tipoFuncaoHash) {
        tabelaHash = new TabelaHash(100, tipoFuncaoHash);
    }

    public void insert(TK key, TV value) {
        ItemTabelaHash<TK, TV> newItem = new ItemTabelaHash<>(key, value);
        tabelaHash.add(newItem);
    }

    public TV find(TK key) {
        ItemTabelaHash item = tabelaHash.get(key);

        if (item != null) {
            return (TV) item.getValue();
        } else {
            throw new IllegalArgumentException("Chave não encontrada");
        }
    }

    public void remove(TK key) {
        tabelaHash.delete(key);
    }

    public int size() {
        return tabelaHash.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public List<TK> keys() {
        List<TK> listKeys = new LinkedList<>();

        for(ItemTabelaHash item: tabelaHash.getAll()) {
            listKeys.add((TK) item.getKey());
        }

        return listKeys;
    }

    public List<TV> values() {
        List<TV> values = new LinkedList<>();

        for (ItemTabelaHash item: this.tabelaHash.getAll()) {
            values.add((TV) item.getValue());
        }

        return values;
    }

    public String getGraficoArmazenamento() {
        return tabelaHash.getGrafrico();
    }

}
