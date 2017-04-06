package hashTable;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class TabelaHashEA extends HashTable {

    private ItemTabelaHash[] tabelaHashLinearProbing;
    private int quantidadeElementos;
    private FHash fHash;

    public TabelaHashEA(int size, FHash fHash) {
        this.tabelaHashLinearProbing = new ItemTabelaHash[size];
        this.quantidadeElementos = 0;
        this.fHash = fHash;
    }

    public void insert(ItemTabelaHash itemAdd) {
        int position = fHash.calculaHash(itemAdd.getKey());

        if (quantidadeElementos == tabelaHashLinearProbing.length) {

            throw new IllegalArgumentException("Tabela hash cheia.");

        } else if (tabelaHashLinearProbing[position] != null &&
                tabelaHashLinearProbing[position].getKey().equals(itemAdd.getKey())) {

            tabelaHashLinearProbing[position].setValue(itemAdd.getValue());

        } else {

            do position = (position + 1) % tabelaHashLinearProbing.length;
            while (tabelaHashLinearProbing[position] != null);

            tabelaHashLinearProbing[position] = itemAdd;
            quantidadeElementos++;

        }

    }

    public ItemTabelaHash find(Object key) {
        int position = fHash.calculaHash(key);

        while (tabelaHashLinearProbing[position] != null) {

            if (tabelaHashLinearProbing[position].getKey().equals(key))
                return tabelaHashLinearProbing[position];
            else
                position = (position + 1) % tabelaHashLinearProbing.length;

        }

        return NO_SUCH_KEY;
    }

    public ItemTabelaHash remove(Object key) {
        int position = fHash.calculaHash(key);

        while (tabelaHashLinearProbing[position] != null) {

            if (tabelaHashLinearProbing[position].getKey().equals(key)) {
                ItemTabelaHash itemRemovido = tabelaHashLinearProbing[position];

                tabelaHashLinearProbing[position] = null;
                quantidadeElementos--;

                return itemRemovido;
            }
            else
                position = (position + 1) % tabelaHashLinearProbing.length;

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

        for (ItemTabelaHash item : tabelaHashLinearProbing) {
            if (item != null) {
                keys[position] = item.getKey();
                position++;
            }
        }

        return keys;
    }

    public Object[] elements() {
        Object[] elements = new Object[quantidadeElementos];
        int position = 0;

        for (ItemTabelaHash item : tabelaHashLinearProbing) {
            if (item != null) {
                elements[position] = item.getValue();
                position++;
            }
        }

        return elements;
    }

    @Override
    String getCsv() {
        String csv = "posicao,quantidade de elementos\n";


        for (int i = 0 ; i < tabelaHashLinearProbing.length ; i++) {
            if (tabelaHashLinearProbing[i] != null) {
                csv += i + "," + 1 + "\n";
            } else {
                csv += i + "," + 0 + "\n";
            }
        }

        return csv;
    }
}
