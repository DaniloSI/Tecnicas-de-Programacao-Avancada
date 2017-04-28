package hashTable;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class TabelaHashChain extends HashTable {

    private List<Item>[] tabelaHash = new LinkedList[tamanho];

    public TabelaHashChain() { }

    public TabelaHashChain(HashEngine hE) {
        super(hE);
    }

    public TabelaHashChain(int tam, HashEngine hE) {
        super(tam, hE);
    }

    @Override
    public boolean insertItem(Object key, Object elem) {
        Item newItem = new Item(key, elem, hashEngine.hashCode(key));
        int posicao = getPosicao(newItem.getCacheHCode());

        if (tabelaHash[posicao] == null)
            tabelaHash[posicao] = new LinkedList<>();

        // Procurar item existente.
        for (int i = 0 ; i < tabelaHash[posicao].size() ; i++) {
            Item item = tabelaHash[posicao].get(i);

            if (item.equals(newItem)) {
                item.setElem(elem);
                redimensiona();
                return true;
            }
        }

        tabelaHash[posicao].add(newItem);
        quantidadeItens++;
        redimensiona();
        return true;
    }

    private void redimensiona() {
        if (((float) quantidadeItens) >= (0.95 * tamanho))
            redimensionar();
    }

    private void redimensionar() {
        List<Item>[] oldTabelaHash = this.tabelaHash;
        this.tamanho *= 2;
        this.tabelaHash = new LinkedList[tamanho];

        for (int i = 0 ; i < oldTabelaHash.length ; i++) {
            List<Item> listItens = oldTabelaHash[i];

            for (int j = 0 ; listItens != null && j < listItens.size() ; j++) {
                int posicao = listItens.get(j).getCacheHCode() % tamanho;

                if (tabelaHash[posicao] == null)
                    tabelaHash[posicao] = new LinkedList<>();

                tabelaHash[posicao].add(listItens.get(j));
            }
        }

    }

    @Override
    public Object removeItem(Object key) {
        int posicao = getPosicao(hashEngine.hashCode(key));
        List<Item> listItens = tabelaHash[posicao];

        for (int i = 0 ; listItens != null && i < listItens.size() ; i++) {
            Item item = listItens.get(i);

            if (item.equals(new Item(key, null))) {
                listItens.remove(i);
                quantidadeItens--;

                return item.getElement();
            }
        }

        return NO_SUCH_KEY;
    }

    @Override
    public Object findElem(Object key) {
        int posicao = getPosicao(hashEngine.hashCode(key));
        List<Item> listItens = tabelaHash[posicao];

        for (int i = 0 ; listItens != null && i < listItens.size() ; i++) {
            Item item = listItens.get(i);

            if (item.equals(new Item(key, null)))
                return item.getElement();
        }

        return NO_SUCH_KEY;
    }

    @Override
    public int size() {
        return quantidadeItens;
    }

    @Override
    public boolean empty() {
        return quantidadeItens == 0;
    }

    @Override
    public LinkedList keys() {
        LinkedList<Object> keys = new LinkedList<>();

        for (int i = 0 ; i < tamanho ; i++) {
            List<Item> listItens = tabelaHash[i];

            for (int j = 0 ; listItens != null && j < listItens.size() ; j++) {
                keys.add(listItens.get(j).getKey());
            }
        }

        return keys;
    }

    @Override
    public LinkedList elements() {
        LinkedList<Object> elements = new LinkedList<>();

        for (int i = 0 ; i < tamanho ; i++) {
            List<Item> listItens = tabelaHash[i];

            for (int j = 0 ; listItens != null && j < listItens.size() ; j++) {
                elements.add(listItens.get(j).getElement());
            }
        }

        return elements;
    }

    @Override
    public void salvaColisoes(String fileName) throws IOException {
        PrintWriter fileColisoes = new PrintWriter(new File(fileName));

        for (int i = 0 ; i < tamanho ; i++) {
            List<Item> listItens = tabelaHash[i];

            if (listItens != null)
                fileColisoes.println(i + "," + (listItens.size() - 1));
        }

        fileColisoes.close();
    }

    private int getPosicao(int hashCode) {
        return hashCode % tamanho;
    }
}
