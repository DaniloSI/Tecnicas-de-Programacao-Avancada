package hashTable;

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

            while (this.tabelaHashLista[posicao] != null) {
                posicao = (posicao + 1) % this.tabelaHashLista.length;
            }

            tabelaHashLista[posicao] = item;

            quantidadeElementos++;
        } else {
            throw new ArrayIndexOutOfBoundsException("Tabela hash cheia.");
        }
    }

    public ItemTabelaHash get(Object key) {
        int posicao = fHash((String) key);

        for (int i = 0; i < tabelaHashLista.length && tabelaHashLista[posicao] != null; i++) {
            if (tabelaHashLista[posicao].getKey().equals(key)) {
                return tabelaHashLista[posicao];
            }
            posicao = (posicao + 1) % tabelaHashLista.length;
        }

        throw new IllegalArgumentException("Chave não armazenada.");
    }

    public int size() {
        return this.quantidadeElementos;
    }

    public ItemTabelaHash[] getAll() {
        return this.tabelaHashLista;
    }

    public void delete(Object key) {
        int posicao = fHash((String) key);

        for (int i = 0; i < tabelaHashLista.length && tabelaHashLista[posicao] != null; i++) {
            if (tabelaHashLista[posicao].getKey() == key) {
                tabelaHashLista[posicao] = null;
            } else {
                posicao = (posicao + 1) % tabelaHashLista.length;
            }
        }
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

        return hash;
    }
}
