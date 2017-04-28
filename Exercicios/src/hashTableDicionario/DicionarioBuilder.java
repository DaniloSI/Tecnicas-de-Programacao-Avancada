package hashTableDicionario;


import hashTable.HashEngine;
import hashTable.HashTableChain;
import hashTable.HashTableEA;

/**
 * Created by 20142bsi0186 on 06/04/2017.
 */
public class DicionarioBuilder<TK, TV> {

    public enum TipoTabelaHash {LINEAR_PROBING, CHINING}
    private TipoTabelaHash tipoTabelaHash;
    private HashEngine hashEngine;


    public DicionarioBuilder setHashEngine(HashEngine hashEngine) {
        this.hashEngine = hashEngine;

        return this;
    }

    public DicionarioBuilder setTipoTabelaHash(TipoTabelaHash tipoTabelaHash) {
        this.tipoTabelaHash = tipoTabelaHash;

        return this;
    }

    public Dicionario get() {
        if (tipoTabelaHash == TipoTabelaHash.CHINING)
            return new Dicionario<TK, TV>(new HashTableChain(hashEngine));
        else
            return new Dicionario<TK, TV>(new HashTableEA(hashEngine));
    }

}
