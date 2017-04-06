package dicionario;

import hashTable.*;

/**
 * Created by 20142bsi0186 on 06/04/2017.
 */
public class DicionarioBuilder<TK, TV> {

    public enum TipoTabelaHash {LINEAR_PROBING, CHINING}
    private TipoTabelaHash tipoTabelaHash;
    private TipoFuncaoHash tipoFuncaoHash;


    public DicionarioBuilder setTipoFuncaoHash(TipoFuncaoHash tipoFuncaoHash) {
        this.tipoFuncaoHash = tipoFuncaoHash;

        return this;
    }

    public DicionarioBuilder setTipoTabelaHash(TipoTabelaHash tipoTabelaHash) {
        this.tipoTabelaHash = tipoTabelaHash;

        return this;
    }

    public Dicionario get() {
        FHash fHash;
        HashTable hashTable;

        fHash = (tipoFuncaoHash == TipoFuncaoHash.POLINOMIAL) ? this::fHashPolinomial : this::fHashNaoPolinomial;

        hashTable = (tipoTabelaHash == TipoTabelaHash.CHINING) ? new TabelaHash(100, fHash) : new TabelaHashEA(fHash);

        return new Dicionario<TK, TV>(hashTable);
    }

    private int fHashPolinomial(Object key, int relativeValue) {
        int hash = 0;
        int base = 2;
        int expoente = 0;

        for (char caracter : ((String) key).toCharArray()) {
            hash += caracter * (base^expoente);

            expoente++;
        }

        return hash % relativeValue;
    }

    private int fHashNaoPolinomial(Object key, int relativeValue) {
        int hash = 0;

        for (char caracter : ((String) key).toCharArray()) {
            hash += caracter;
        }

        return hash % relativeValue;
    }


}
