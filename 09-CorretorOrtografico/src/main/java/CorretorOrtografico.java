import hashTable.ItemTabelaHash;
import hashTable.TabelaHash;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by danilo on 23/04/17.
 */
public class CorretorOrtografico {
    private TabelaHash dicionarioPalavras;

    public CorretorOrtografico() {
        dicionarioPalavras = new TabelaHash();
    }

    public void addNewWord(String word) {
        dicionarioPalavras.insert(new ItemTabelaHash(word, word));
    }

    public List<String> calculaNGrama(String word) {
        List<String> nGramas = new LinkedList<>();

        for (int sizeNGrama = 1 ; sizeNGrama <= word.length() ; sizeNGrama++){
            for (int inicioPalavra = 0 ; (inicioPalavra + sizeNGrama) <= word.length() ; inicioPalavra++) {
                nGramas.add(word.substring(inicioPalavra, (inicioPalavra + sizeNGrama)));
            }
        }

        return nGramas;
    }


}
