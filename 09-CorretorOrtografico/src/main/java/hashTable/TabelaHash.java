package hashTable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class TabelaHash {

    public static final ItemTabelaHash NO_SUCH_KEY = new ItemTabelaHash(null, null);
    private List<ItemTabelaHash>[] tabelaHashLista;
    int quantidadeElementos = 0;

    public void insert(ItemTabelaHash paramItem) {
        Object itemKey = paramItem.getKey();
        ItemTabelaHash itemExistente;

        // Aumenta o tamanho da tabela hash, caso necessario.
        if (calculaHash(itemKey) >= tabelaHashLista.length)
            aumentarTabelaHash(calculaHash(itemKey));

        // Recupera um item pela chave, caso exista.
        itemExistente = getByKey(itemKey);

        // Se o item existe, entao altera o valor existente para o novo valor.
        if (itemExistente != NO_SUCH_KEY)
            itemExistente.setValue(paramItem.getValue());

        else {
            // Se a posicao do hash nao possui uma lista de itens, cria uma nova lista.
            if (tabelaHashLista[calculaHash(itemKey)] == null)
                tabelaHashLista[calculaHash(itemKey)] = new LinkedList<>();

            tabelaHashLista[calculaHash(itemKey)].add(paramItem);
            quantidadeElementos++;
        }

    }

    private void aumentarTabelaHash(int paramNewSize) {

        // Antiga tabela hash.
        List<ItemTabelaHash>[] oldTabelaHashLista = this.tabelaHashLista;

        // Nova tabela hash.
        this.tabelaHashLista = new LinkedList[paramNewSize];

        for (int i = 0 ; i < oldTabelaHashLista.length ; i++) {
            if (oldTabelaHashLista[i] != null)
                this.tabelaHashLista[i] = oldTabelaHashLista[i];
        }
    }

    private ItemTabelaHash getByKey(Object key) {

        for(ItemTabelaHash item: tabelaHashLista[calculaHash(key)]) {
            if (item.getKey().equals(key)) {
                return item;
            }
        }

        return NO_SUCH_KEY;
    }

    public ItemTabelaHash find(Object key) {
        if (tabelaHashLista[calculaHash(key)] == null)
            return NO_SUCH_KEY;

        else
            for(ItemTabelaHash item: tabelaHashLista[calculaHash(key)]) {
                if (item.getKey().equals(key))
                    return item;
            }

        return NO_SUCH_KEY;
    }

    public ItemTabelaHash remove(Object key) {
        int posicao = calculaHash(key);

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
        List<Integer> listKeys = new LinkedList<>();

        for (int i = 0 ; i < tabelaHashLista.length ; i++) {
            if (tabelaHashLista[i] != null)
                listKeys.add(i);
        }

        return listKeys.toArray();
    }

    public Object[] elements() {
        Object[] elements = new Object[quantidadeElementos];
        int position = 0;

        for (List<ItemTabelaHash> listItens: this.tabelaHashLista) {
            if (listItens != null) {
                for (ItemTabelaHash item: listItens) {
                    elements[position] = item.getValue();
                    position++;
                }
            }
        }

        return elements;
    }

    private int calculaHash(Object paramKey) {
        return ((String) paramKey).length();
    }
}
