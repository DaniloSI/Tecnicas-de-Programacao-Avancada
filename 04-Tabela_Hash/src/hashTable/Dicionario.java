package hashTable;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class Dicionario<TK, TV> {

    private HashTable hashTable;
    public static ItemTabelaHash NO_SUCH_KEY;
    private static final int sizeTabelaHash = 1000;

    public Dicionario(TipoFuncaoHash tipoFuncaoHash) {

        switch (tipoFuncaoHash) {
            case POLINOMIAL:
                hashTable = new TabelaHashEA(sizeTabelaHash, this::funcaoHashPolinomial);
                break;
            case NAO_POLINOMIAL:
                hashTable = new TabelaHashEA(sizeTabelaHash, this::funcaoHashNaoPolinomial);
                break;
            default:
                throw new IllegalArgumentException("Tipo de função Hash inválida.");
        }

        NO_SUCH_KEY = HashTable.NO_SUCH_KEY;

    }

    public void insert(TK key, TV value) {
        ItemTabelaHash<TK, TV> newItem = new ItemTabelaHash<>(key, value);
        hashTable.insert(newItem);
    }

    public TV find(TK key) throws Exception {
        ItemTabelaHash item = hashTable.find(key);

        if (item == HashTable.NO_SUCH_KEY) {

            throw new Exception("Chave inválida.");

        } else {

            return (TV) item.getValue();

        }
    }

    public void remove(TK key) {
        hashTable.remove(key);
    }

    public int size() {
        return hashTable.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public TK[] keys() {

        return (TK[]) hashTable.keys();
    }

    public TV[] elements() {

        return (TV[]) hashTable.elements();
    }

    public String getCsvArmazenamento() {
        return hashTable.getCsv();
    }

    private int funcaoHashPolinomial(Object key) {
        int hash = 0;
        int base = 2;
        int expoente = 0;

        for (char caracter : ((String) key).toCharArray()) {
            hash += caracter * (base^expoente);

            expoente++;
        }

        return hash % sizeTabelaHash;
    }

    private int funcaoHashNaoPolinomial(Object key) {
        int hash = 0;

        for (char caracter : ((String) key).toCharArray()) {
            hash += caracter;
        }

        return hash % sizeTabelaHash;
    }

}
