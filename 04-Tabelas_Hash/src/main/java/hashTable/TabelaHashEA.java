package hashTable;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class TabelaHashEA extends HashTable {

    private ItemTabelaHash[] tabelaHashLinearProbing;
    private int quantidadeElementos;
    private FHash fHash;

    public TabelaHashEA(FHash fHash) {
        this.tabelaHashLinearProbing = new ItemTabelaHash[100];
        this.quantidadeElementos = 0;
        this.fHash = fHash;
    }

    public TabelaHashEA() {
        this.tabelaHashLinearProbing = new ItemTabelaHash[100];
        this.fHash = (Object key, int relativeValue) -> {
            int hash = 0;
            int base = 2;
            int expoente = 0;

            for (char caracter : ((String) key).toCharArray()) {
                hash += caracter * (base^expoente);

                expoente++;
            }

            return hash % relativeValue;
        };
    }

    public void insert(ItemTabelaHash itemAdd) {
        int position = fHash.calculaHash(itemAdd.getKey(), tabelaHashLinearProbing.length);

        if (tabelaHashLinearProbing[position] != null &&
                tabelaHashLinearProbing[position].getKey().equals(itemAdd.getKey())) {

            tabelaHashLinearProbing[position].setValue(itemAdd.getValue());

        } else {

            if (quantidadeElementos >= (tabelaHashLinearProbing.length * 0.8)) {
                increaseSizeTabelaHash();
                position = fHash.calculaHash(itemAdd.getKey(), tabelaHashLinearProbing.length);
            }

            while (tabelaHashLinearProbing[position] != null)
                position = (position + 1) % tabelaHashLinearProbing.length;

            tabelaHashLinearProbing[position] = itemAdd;
            quantidadeElementos++;

        }

    }

    private void increaseSizeTabelaHash() {
        ItemTabelaHash[] antigaTabelaHash = tabelaHashLinearProbing;
        tabelaHashLinearProbing = new ItemTabelaHash[tabelaHashLinearProbing.length * 2];

        for (ItemTabelaHash item: antigaTabelaHash) {
            if (item != null) {
                this.insert(item);
            }
        }

    }

    public ItemTabelaHash find(Object key) {
        int position = fHash.calculaHash(key, tabelaHashLinearProbing.length);

        while (tabelaHashLinearProbing[position] != null) {

            if (tabelaHashLinearProbing[position].getKey().equals(key))
                return tabelaHashLinearProbing[position];
            else
                position = (position + 1) % tabelaHashLinearProbing.length;

        }

        return NO_SUCH_KEY;
    }

    public ItemTabelaHash remove(Object key) {
        int position = fHash.calculaHash(key, tabelaHashLinearProbing.length);

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

    public String getCsv() {
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
