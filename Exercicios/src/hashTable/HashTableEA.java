package hashTable;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class HashTableEA extends HashTable {

    private Item[] tabelaHash = new Item[tamanho];

    public HashTableEA() { }

    public HashTableEA(HashEngine hE) {
        super(hE);
    }

    public HashTableEA(int tam, HashEngine hE) {
        super(tam, hE);
    }

    @Override
    public boolean insertItem(Object key, Object elem) {
        Item newItem = new Item(key, elem, hashEngine.hashCode(key));

        Integer posicao = getPosicao(key, newItem.getCacheHCode());

        if (tabelaHash[posicao] != null) {
            tabelaHash[posicao].setElem(elem);
        } else {
            tabelaHash[posicao] = newItem;
            quantidadeItens++;
        }

        if ((quantidadeItens) >= (int)(0.95 * tamanho))
            redimensiona();

        return true;
    }

    private void redimensiona() {
        Item[] oldTabelaHash = tabelaHash;
        tamanho *= 2;
        tabelaHash = new Item[tamanho];

        for (int i = 0 ; i < oldTabelaHash.length ; i++) {
            Item item = oldTabelaHash[i];

            if (item != null) {
                int posicao = item.getCacheHCode() % tamanho;

                while (tabelaHash[posicao] != null)
                    posicao = (posicao + 1) % tamanho;

                tabelaHash[posicao] = item;
            }
        }

    }

    @Override
    public Object removeItem(Object key) {
        Integer posicao = getPosicao(key, hashEngine.hashCode(key));
        Item itemRemove;

        if (tabelaHash[posicao] != null) {
            itemRemove = tabelaHash[posicao];
            tabelaHash[posicao] = null;
            quantidadeItens--;

            return itemRemove.getElement();
        }

        return NO_SUCH_KEY;
    }

    @Override
    public Object findElem(Object key) {
        Integer posicao = getPosicao(key, hashEngine.hashCode(key));

        return (tabelaHash[posicao] != null) ? tabelaHash[posicao].getElement() : NO_SUCH_KEY;
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
            if (tabelaHash[i] != null)
                keys.add(tabelaHash[i].getKey());
        }

        return keys;
    }

    @Override
    public LinkedList elements() {
        LinkedList<Object> elements = new LinkedList<>();

        for (int i = 0 ; i < tamanho ; i++) {
            if (tabelaHash[i] != null)
                elements.add(tabelaHash[i].getElement());
        }

        return elements;
    }

    @Override
    public void salvaColisoes(String fileName) throws IOException {
        PrintWriter fileColisoes = new PrintWriter(new File(fileName));
        int[] countColisoes = new int[tamanho];

        for (int i = 0 ; i < tamanho ; i++) {
            if (tabelaHash[i] != null)
                countColisoes[getPosicao(tabelaHash[i].getCacheHCode())]++;
        }

        for (int i = 0 ; i < countColisoes.length ; i++) {
            if (countColisoes[i] > 0)
                fileColisoes.println(i + "," + (countColisoes[i] - 1));
        }

        fileColisoes.close();
    }

    private Integer getPosicao(Object key, int hashCode) {
        int posicao = getPosicao(hashCode);

        // Procura um item existente com a mesma chave.
        for (int i = 0 ; i < tamanho ; i++) {
            Item item = tabelaHash[posicao];

            if (item != null && item.equals(new Item(key, null)))
                return posicao;

            posicao = (posicao + 1) % tamanho;
        }

        while (tabelaHash[posicao] != null) {
            posicao = (posicao + 1) % tamanho;
        }

        return posicao;
    }

    private Integer getPosicao(int hashCode) {
        return hashCode % tamanho;
    }
}
