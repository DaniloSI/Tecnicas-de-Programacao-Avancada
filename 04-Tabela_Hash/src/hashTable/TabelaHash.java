package hashTable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class TabelaHash extends HashTable {

    private List<ItemTabelaHash>[] tabelaHashLista;
    private FHash funcaoHash;
    private int quantidadeElementos = 0;

    public TabelaHash(int size, FHash funcaoHash) {
        this.tabelaHashLista = new LinkedList[size];
        this.funcaoHash = funcaoHash;
    }

    public void insert(ItemTabelaHash itemAdd) {
        int posicao = funcaoHash.calculaHash(itemAdd.getKey());

        if (tabelaHashLista[posicao] == null) {
            tabelaHashLista[posicao] = new LinkedList<>();
            tabelaHashLista[posicao].add(itemAdd);
            quantidadeElementos++;

        } else {
            ItemTabelaHash itemExistente = getByKey(itemAdd.getKey(), posicao);

            if (itemExistente != NO_SUCH_KEY) {
                itemExistente.setValue(itemAdd.getValue());
            } else {
                tabelaHashLista[posicao].add(itemAdd);
                quantidadeElementos++;
            }
        }
    }

    private ItemTabelaHash getByKey(Object key, Integer posicao) {
        if (posicao == null) {
            posicao = funcaoHash.calculaHash(key);
        }

        for(ItemTabelaHash item: tabelaHashLista[posicao]) {
            if (item.getKey().equals(key)) {
                return item;
            }
        }

        return NO_SUCH_KEY;
    }

    public ItemTabelaHash find(Object key) {
        int posicao = funcaoHash.calculaHash(key);

        for(ItemTabelaHash item: tabelaHashLista[posicao]) {
            if (item.getKey().equals(key)) {
                return item;
            }
        }

        return NO_SUCH_KEY;
    }

    public ItemTabelaHash remove(Object key) {
        int posicao = funcaoHash.calculaHash(key);

        for(ItemTabelaHash item: tabelaHashLista[posicao]) {
            Object itemKey = item.getKey();

            if (itemKey.equals(key)) {
                tabelaHashLista[posicao].remove(item);
                quantidadeElementos--;

                return item;
            }
        }

        return NO_SUCH_KEY;
    }

    public int size() {
        return quantidadeElementos;
    }

    public boolean isEmpty() {
        return quantidadeElementos == 0;
    }

    public Object[] keys() {
        Object[] keys = new Object[quantidadeElementos];
        int position = 0;

        for (List<ItemTabelaHash> listItens: this.tabelaHashLista) {
            for (ItemTabelaHash item: listItens) {
                if (item != null) {
                    keys[position] = item.getKey();
                    position++;
                }
            }
        }

        return keys;
    }

    public Object[] elements() {
        Object[] elements = new Object[quantidadeElementos];
        int position = 0;

        for (List<ItemTabelaHash> listItens: this.tabelaHashLista) {
            for (ItemTabelaHash item: listItens) {
                if (item != null) {
                    elements[position] = item.getValue();
                    position++;
                }
            }
        }

        return elements;
    }

    public String getCsv() {
        String csv = "posicao,quantidade de elementos\n";


        for (int i = 0 ; i < tabelaHashLista.length ; i++) {
            if (tabelaHashLista[i] != null) {
                csv += i + "," + tabelaHashLista[i].size() + "\n";
            } else {
                csv += i + "," + 0 + "\n";
            }
        }

        return csv;
    }
}
