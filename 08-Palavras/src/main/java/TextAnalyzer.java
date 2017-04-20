import dicionario.Dicionario;
import dicionario.DicionarioBuilder;
import hashTable.TipoFuncaoHash;

/**
 * Created by Danilo de Oliveira on 18/04/17.
 */
public class TextAnalyzer {
    private Dicionario<String, Integer> words;

    public TextAnalyzer(TextFileLoader fileLoader) throws Exception {
        String line;
        this.words = new DicionarioBuilder<String, Integer>()
                .setTipoFuncaoHash(TipoFuncaoHash.POLINOMIAL)
                .setTipoTabelaHash(DicionarioBuilder.TipoTabelaHash.CHINING)
                .get();

        while ( (line = fileLoader.nextLine()) != null) {
            for (String word : line.split("[\\p{Punct}\\s\\d]")) {
                if (word.length() > 0) {
                    try {
                        words.insert(word.toLowerCase(), words.find(word.toLowerCase()) + 1);
                    } catch (IllegalArgumentException e) {
                        words.insert(word.toLowerCase(), 1);
                    }
                }
            }
        }

        fileLoader.finish();
    }

    public int getFrequencyWord(String word) {
        int frequencia;

        try {
            frequencia = words.find(word.toLowerCase());
        } catch (IllegalArgumentException e) {
            frequencia = 0;
        }

        return frequencia;
    }

    public String getWordMaiorFrequencia() {
        String palavra = "";
        int frequencia = 0;

        Object[] objectWord = words.keys();

        for (int i = 0 ; i < objectWord.length ; i++) {
            String wordKey = (String) objectWord[i];
            int frequenciaWordKey = words.find(wordKey);

            if (frequenciaWordKey > frequencia) {
                palavra = wordKey;

                frequencia = frequenciaWordKey;
            }
        }

        return palavra;
    }
}
