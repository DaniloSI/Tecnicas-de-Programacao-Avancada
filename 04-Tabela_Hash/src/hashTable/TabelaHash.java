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

    public void add(ItemTabelaHash item) {
        int posicao = getPosicao(fHash((String) item.getKey()));

        System.out.println(tabelaHashLista.length);

        if (tabelaHashLista[posicao] == null) {
            tabelaHashLista[posicao] = new LinkedList<>();
        }

        tabelaHashLista[posicao].add(item);
    }

    public List<ItemTabelaHash> get(String key) {
        int posicao = getPosicao(fHash(key));
        return tabelaHashLista[posicao];
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

    private int getPosicao(int hash) {
        return tabelaHashLista.length / hash;
    }

    private int fHash(String key) {
        int base = 2;
        int expoente = 0;
        int hash = 0;

        for (char caracter : key.toCharArray()) {
            hash += caracter * (base^expoente);

            expoente++;
        }

        return hash;
    }
}
