package hashTable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class TabelaHash {
    private List<ItemTabelaHash>[] tabelaHashLista;

    public TabelaHash(int size) {
        this.tabelaHashLista = new LinkedList[size];
    }

    public void add(ItemTabelaHash itemAdd) {
        int posicao = fHash((String) itemAdd.getKey());
        ItemTabelaHash itemExistente;

        if (tabelaHashLista[posicao] == null) {
            tabelaHashLista[posicao] = new LinkedList<>();
            tabelaHashLista[posicao].add(itemAdd);

        } else {
            itemExistente = getByKey(itemAdd.getKey(), posicao);

            if (itemExistente != null) {
                itemExistente.setValue(itemAdd.getValue());
            } else {
                tabelaHashLista[posicao].add(itemAdd);
            }
        }
    }

    private ItemTabelaHash getByKey(Object key, Integer posicao) {
        if (posicao == null) {
            posicao = fHash((String) key);
        }

        for(ItemTabelaHash item: tabelaHashLista[posicao]) {
            if (item.getKey().equals(key)) {
                return item;
            }
        }

        return null;
    }

    public ItemTabelaHash get(Object key) {
        int posicao = fHash((String) key);

        for(ItemTabelaHash item: tabelaHashLista[posicao]) {
            if (item.getKey().equals(key)) {
                return item;
            }
        }

        return null;
    }

    public void delete(Object key) {
        int posicao = fHash((String) key);


        for(Object item: tabelaHashLista[posicao].toArray()) {
            if (((ItemTabelaHash) item).getKey().equals(key)) {
                tabelaHashLista[posicao].remove(item);
            }
        }
    }

    public int size() {
        int size = 0;

        for (List list : this.tabelaHashLista) {
            size += (list != null) ? list.size() : 0;
        }

        return size;
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

    private int fHash(String key) {
        int base = 2;
        int expoente = 0;
        int hash = 0;

        for (char caracter : key.toCharArray()) {
            hash += caracter * (base^expoente);

            expoente++;
        }

        return hash % tabelaHashLista.length;
    }

    public String getGrafrico() {
        String grafico = "posicao,quantidade de elementos\n";


        for (int i = 0 ; i < tabelaHashLista.length ; i++) {
            if (tabelaHashLista[i] != null) {
                grafico += i + "," + tabelaHashLista[i].size() + "\n";
            }
        }

        return grafico;
    }
}
