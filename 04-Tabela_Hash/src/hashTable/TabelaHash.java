package hashTable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class TabelaHash {

    public static final ItemTabelaHash NO_SUCH_KEY = new ItemTabelaHash(null, null);

    private List<ItemTabelaHash>[] tabelaHashLista;
    private FHash funcaoHash;
    private int quantidadeElementos = 0;

    public TabelaHash(int size, FHash funcaoHash) {
        this.tabelaHashLista = new LinkedList[size];
        this.funcaoHash = funcaoHash;
    }

    public void add(ItemTabelaHash itemAdd) {
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

    public ItemTabelaHash get(Object key) {
        int posicao = funcaoHash.calculaHash(key);

        for(ItemTabelaHash item: tabelaHashLista[posicao]) {
            if (item.getKey().equals(key)) {
                return item;
            }
        }

        return NO_SUCH_KEY;
    }

    public void delete(Object key) {
        int posicao = funcaoHash.calculaHash(key);


        for(Object item: tabelaHashLista[posicao].toArray()) {
            if (((ItemTabelaHash) item).getKey().equals(key)) {
                tabelaHashLista[posicao].remove(item);
                quantidadeElementos--;
            }
        }
    }

    public int size() {
        return quantidadeElementos;
    }

    public List<ItemTabelaHash> getAll() {
        List<ItemTabelaHash> itens = new LinkedList<>();

        for (List<ItemTabelaHash> listItens: this.tabelaHashLista) {
            if (listItens != null) {
                itens.addAll(listItens);
            }
        }

        return itens;
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
