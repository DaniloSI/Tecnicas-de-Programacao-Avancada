package hashTable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class TabelaHashEnderecamentoAberto {
    private ItemTabelaHash[] tabelaHashLista;
    private int quantidadeElementos;

    public TabelaHashEnderecamentoAberto(int size) {
        this.tabelaHashLista = new ItemTabelaHash[size];
        this.quantidadeElementos = 0;
    }

    public void add(ItemTabelaHash item) {
        if (quantidadeElementos < this.tabelaHashLista.length) {
            int posicao = fHash((String) item.getKey());

            tabelaHashLista[posicao] = item;

            quantidadeElementos++;
        } else {
            throw new ArrayIndexOutOfBoundsException("Tabela hash cheia.");
        }
    }

    public ItemTabelaHash get(String key) {
        int posicao = fHash(key);
        return tabelaHashLista[posicao];
    }

    public int size() {
        return this.tabelaHashLista.length;
    }

    public ItemTabelaHash[] getAll() {
        return this.tabelaHashLista;
    }

    public int indexOf(String key) {
        return fHash(key);
    }

    public void remove(int index) {
        this.tabelaHashLista[index] = null;
    }

    private int fHash(String key) {
        int base = 2;
        int expoente = 0;
        int hash = 0;

        for (char caracter : key.toCharArray()) {
            hash += caracter * (base^expoente);

            expoente++;
        }

        hash = this.tabelaHashLista.length / hash;

        while (this.tabelaHashLista[hash] != null) {
            hash = (hash + 1) % this.tabelaHashLista.length;
        }


        return hash;
    }
}
